package myproject.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import myproject.common.page.PageResult;
import myproject.common.impl.BaseServiceImpl;
import myproject.convert.ProjectclassificationConvert;
import myproject.entity.ProjectclassificationEntity;
import myproject.query.ProjectclassificationQuery;
import myproject.vo.ProjectclassificationVO;
import myproject.dao.ProjectclassificationDao;
import myproject.service.ProjectclassificationService;
import myproject.common.utils.DateUtils;
import myproject.common.excel.ExcelFinishCallBack;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import myproject.common.utils.ExcelUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.io.File;

/**
* 项目分类
*
*/
@Service
@AllArgsConstructor
public class ProjectclassificationServiceImpl extends BaseServiceImpl<ProjectclassificationDao, ProjectclassificationEntity> implements ProjectclassificationService {

    @Override
    public PageResult<ProjectclassificationVO> page(ProjectclassificationQuery query) {
        IPage<ProjectclassificationEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));
        return new PageResult<>(ProjectclassificationConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }

    @Override
    public List<ProjectclassificationVO> queryList(ProjectclassificationQuery query) {
        return ProjectclassificationConvert.INSTANCE.convertList(baseMapper.selectList(getWrapper(query)));
    }

    private LambdaQueryWrapper<ProjectclassificationEntity> getWrapper(ProjectclassificationQuery query){
        LambdaQueryWrapper<ProjectclassificationEntity> wrapper = Wrappers.lambdaQuery();
                    wrapper.eq(null!=query.getId(), ProjectclassificationEntity::getId, query.getId());
                    wrapper.eq(StringUtils.isNotEmpty(query.getName()), ProjectclassificationEntity::getName, query.getName());
                    wrapper.between(ArrayUtils.isNotEmpty(query.getAddtime()), ProjectclassificationEntity::getAddtime, ArrayUtils.isNotEmpty(query.getAddtime()) ? query.getAddtime()[0] : null, ArrayUtils.isNotEmpty(query.getAddtime()) ? query.getAddtime()[1] : null);
            return wrapper;
    }

    @Override
    public void save(ProjectclassificationVO vo) {
        ProjectclassificationEntity entity = ProjectclassificationConvert.INSTANCE.convert(vo);
        baseMapper.insert(entity);
    }

    @Override
    public void update(ProjectclassificationVO vo) {
        ProjectclassificationEntity entity = ProjectclassificationConvert.INSTANCE.convert(vo);
        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);
    }

    @Override
    @SneakyThrows
    public void export(ProjectclassificationQuery query) {
        List<ProjectclassificationVO> list = ProjectclassificationConvert.INSTANCE.convertList(baseMapper.selectList(getWrapper(query)));
        // 写到浏览器打开
        ExcelUtils.excelExport(ProjectclassificationVO.class, "项目分类" + DateUtils.format(new Date()), null, list);
    }

    @Override
    @SneakyThrows
    public void importprojectclassification(File file) {
        ExcelUtils.readAnalysis(file, ProjectclassificationVO.class, new ExcelFinishCallBack<ProjectclassificationVO>() {
            @Override
            public void doAfterAllAnalysed(List<ProjectclassificationVO> result) {
                saveProjectclassifications(result);
            }

            @Override
            public void doSaveBatch(List<ProjectclassificationVO> result) {
                saveProjectclassifications(result);
            }

            private void saveProjectclassifications(List<ProjectclassificationVO> result) {
                List<ProjectclassificationEntity> ProjectclassificationEntities = ProjectclassificationConvert.INSTANCE.convertEntityList(result);
                saveBatch(ProjectclassificationEntities);
            }
        });
    }

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, LambdaQueryWrapper<ProjectclassificationEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, LambdaQueryWrapper<ProjectclassificationEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, LambdaQueryWrapper<ProjectclassificationEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }
}