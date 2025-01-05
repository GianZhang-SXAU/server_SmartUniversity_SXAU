package myproject.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import myproject.common.page.PageResult;
import myproject.common.utils.Result;
import myproject.convert.VehicleclassificationConvert;
import myproject.entity.VehicleclassificationEntity;
import myproject.service.VehicleclassificationService;
import myproject.query.VehicleclassificationQuery;
import myproject.vo.VehicleclassificationVO;
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
* 车辆分类
*
*/
@RestController
@RequestMapping("vehicleclassification")
@Tag(name="车辆分类")
@AllArgsConstructor
public class VehicleclassificationController {
private final VehicleclassificationService vehicleclassificationService;

    @PostMapping("page")
    @Operation(summary = "分页")
    @SysLog(title = "查看车辆分类分页")
    public Result<PageResult<VehicleclassificationVO>> page(@RequestBody @Valid VehicleclassificationQuery query){
        PageResult<VehicleclassificationVO> page = vehicleclassificationService.page(query);
        return Result.ok(page);
    }
    @PostMapping("list")
    @Operation(summary = "列表")
    @SaIgnore
    @SysLog(title = "查看车辆分类列表")
    public Result<List<VehicleclassificationVO>> list(@RequestBody @Valid VehicleclassificationQuery query){
        List<VehicleclassificationVO> list = vehicleclassificationService.queryList(query);
        return Result.ok(list);
    }
    @PostMapping("/info")
    @Operation(summary = "信息")
    @SysLog(title = "查看车辆分类信息")
    public Result<VehicleclassificationVO> get(@RequestSingleParam(value = "id") Long id){
        VehicleclassificationEntity entity = vehicleclassificationService.getById(id);
        return Result.ok(VehicleclassificationConvert.INSTANCE.convert(entity));
    }

    @PostMapping("save")
    @Operation(summary = "保存")
    @SysLog(title = "保存车辆分类信息")
    public Result<String> save(@RequestBody VehicleclassificationVO vo){
        vehicleclassificationService.save(vo);
        return Result.ok();
    }

    @PostMapping("update")
    @Operation(summary = "修改")
    @SysLog(title = "修改车辆分类信息")
    public Result<String> update(@RequestBody @Valid VehicleclassificationVO vo){
        vehicleclassificationService.update(vo);
        return Result.ok();
    }

    @PostMapping("delete")
    @Operation(summary = "删除")
    @SysLog(title = "删除车辆分类信息")
    public Result<String> delete(@RequestBody List<Long> idList){
            vehicleclassificationService.delete(idList);
            return Result.ok();
    }

    @PostMapping("export")
    @Operation(summary = "导出")
    @SysLog(title = "导出车辆分类列表")
    public void export(@RequestBody @Valid VehicleclassificationQuery query) {
        vehicleclassificationService.export(query);
    }
    @PostMapping("import")
    @Operation(summary = "导入")
    public Result<String> importvehicleclassification(@RequestSingleParam(value = "file") String file) {
        if (file.isEmpty()) {
            return Result.error("请选择需要上传的文件");
        }
        file = file.replace("api/", "");
        File importFile = new File(file);
        vehicleclassificationService.importvehicleclassification(importFile);
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
    LambdaQueryWrapper<VehicleclassificationEntity> wrapper = Wrappers.lambdaQuery();
    List<Map<String, Object>> result = vehicleclassificationService.selectValue(params, wrapper);
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
    LambdaQueryWrapper<VehicleclassificationEntity> wrapper = Wrappers.lambdaQuery();
        List<Map<String, Object>> result = vehicleclassificationService.selectTimeStatValue(params, wrapper);
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
    LambdaQueryWrapper<VehicleclassificationEntity> wrapper = Wrappers.lambdaQuery();
        //		wrapper.orderByDesc(VehicleclassificationEntity::getCount);
        List<Map<String, Object>> result = vehicleclassificationService.selectGroup(params, wrapper);
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