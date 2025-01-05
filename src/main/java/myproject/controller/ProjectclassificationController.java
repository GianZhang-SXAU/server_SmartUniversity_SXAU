package myproject.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import myproject.common.page.PageResult;
import myproject.common.utils.Result;
import myproject.convert.ProjectclassificationConvert;
import myproject.entity.ProjectclassificationEntity;
import myproject.service.ProjectclassificationService;
import myproject.query.ProjectclassificationQuery;
import myproject.vo.ProjectclassificationVO;
import org.springframework.web.bind.annotation.*;
import myproject.common.request.RequestSingleParam;
import myproject.common.sysLog.SysLog;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.io.File;
/**
* 项目分类
*
*/
@RestController
@RequestMapping("projectclassification")
@Tag(name="项目分类")
@AllArgsConstructor
public class ProjectclassificationController {
private final ProjectclassificationService projectclassificationService;

    @PostMapping("page")
    @Operation(summary = "分页")
    @SysLog(title = "查看项目分类分页")
    public Result<PageResult<ProjectclassificationVO>> page(@RequestBody @Valid ProjectclassificationQuery query){
        PageResult<ProjectclassificationVO> page = projectclassificationService.page(query);
        return Result.ok(page);
    }
    @PostMapping("list")
    @Operation(summary = "列表")
    @SaIgnore
    @SysLog(title = "查看项目分类列表")
    public Result<List<ProjectclassificationVO>> list(@RequestBody @Valid ProjectclassificationQuery query){
        List<ProjectclassificationVO> list = projectclassificationService.queryList(query);
        return Result.ok(list);
    }
    @PostMapping("/info")
    @Operation(summary = "信息")
    @SysLog(title = "查看项目分类信息")
    public Result<ProjectclassificationVO> get(@RequestSingleParam(value = "id") Long id){
        ProjectclassificationEntity entity = projectclassificationService.getById(id);
        return Result.ok(ProjectclassificationConvert.INSTANCE.convert(entity));
    }

    @PostMapping("save")
    @Operation(summary = "保存")
    @SysLog(title = "保存项目分类信息")
    public Result<String> save(@RequestBody ProjectclassificationVO vo){
        projectclassificationService.save(vo);
        return Result.ok();
    }

    @PostMapping("update")
    @Operation(summary = "修改")
    @SysLog(title = "修改项目分类信息")
    public Result<String> update(@RequestBody @Valid ProjectclassificationVO vo){
        projectclassificationService.update(vo);
        return Result.ok();
    }

    @PostMapping("delete")
    @Operation(summary = "删除")
    @SysLog(title = "删除项目分类信息")
    public Result<String> delete(@RequestBody List<Long> idList){
            projectclassificationService.delete(idList);
            return Result.ok();
    }

    @PostMapping("export")
    @Operation(summary = "导出")
    @SysLog(title = "导出项目分类列表")
    public void export(@RequestBody @Valid ProjectclassificationQuery query) {
        projectclassificationService.export(query);
    }
    @PostMapping("import")
    @Operation(summary = "导入")
    public Result<String> importprojectclassification(@RequestSingleParam(value = "file") String file) {
        if (file.isEmpty()) {
            return Result.error("请选择需要上传的文件");
        }
        file = file.replace("api/", "");
        File importFile = new File(file);
        projectclassificationService.importprojectclassification(importFile);
        return Result.ok();
    }
    /**
    * （按值统计）
    */
    @SaIgnore
    @RequestMapping("/value/{xColumnName}/{yColumnName}")
    public Result value(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName, HttpServletRequest request) {
    Map<String, Object> params = new HashMap<>();
    params.put("xColumn", xColumnName);
    params.put("yColumn", yColumnName);
    LambdaQueryWrapper<ProjectclassificationEntity> wrapper = Wrappers.lambdaQuery();
    List<Map<String, Object>> result = projectclassificationService.selectValue(params, wrapper);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    for (Map<String, Object> m : result) {
        for (String k : m.keySet()) {
            if (m.get(k) instanceof Date) {
                m.put(k, sdf.format((Date) m.get(k)));
            }
        }
    }
    return Result.ok(result);
    }

    /**
    * （按值统计）时间统计类型
    */
    @SaIgnore
    @RequestMapping("/value/{xColumnName}/{yColumnName}/{timeStatType}")
    public Result valueDay(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType, HttpServletRequest request) {
    Map<String, Object> params = new HashMap<>();
    params.put("xColumn", xColumnName);
    params.put("yColumn", yColumnName);
    params.put("timeStatType", timeStatType);
    LambdaQueryWrapper<ProjectclassificationEntity> wrapper = Wrappers.lambdaQuery();
        List<Map<String, Object>> result = projectclassificationService.selectTimeStatValue(params, wrapper);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (Map<String, Object> m : result) {
            for (String k : m.keySet()) {
                if (m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date) m.get(k)));
                }
            }
        }
    return Result.ok(result);
    }

    /**
    * 分组统计
    */
    @SaIgnore
    @RequestMapping("/group/{columnName}")
    public Result group(@PathVariable("columnName") String columnName, HttpServletRequest request) {
    Map<String, Object> params = new HashMap<>();
    params.put("column", columnName);
    LambdaQueryWrapper<ProjectclassificationEntity> wrapper = Wrappers.lambdaQuery();
        //		wrapper.orderByDesc(ProjectclassificationEntity::getCount);
        List<Map<String, Object>> result = projectclassificationService.selectGroup(params, wrapper);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (Map<String, Object> m : result) {
            for (String k : m.keySet()) {
                if (m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date) m.get(k)));
                }
            }
        }
    return Result.ok(result);
    }
}