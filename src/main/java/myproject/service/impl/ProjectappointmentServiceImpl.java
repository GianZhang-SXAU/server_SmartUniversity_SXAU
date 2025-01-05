package myproject.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import myproject.common.page.PageResult;
import myproject.common.impl.BaseServiceImpl;
import myproject.convert.ProjectappointmentConvert;
import myproject.entity.ProjectappointmentEntity;
import myproject.query.ProjectappointmentQuery;
import myproject.vo.ProjectappointmentVO;
import myproject.dao.ProjectappointmentDao;
import myproject.service.ProjectappointmentService;
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
* 项目预约
*
*/
@Service
@AllArgsConstructor
public class ProjectappointmentServiceImpl extends BaseServiceImpl<ProjectappointmentDao, ProjectappointmentEntity> implements ProjectappointmentService {

    @Override
    public PageResult<ProjectappointmentVO> page(ProjectappointmentQuery query) {
        IPage<ProjectappointmentEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));
        return new PageResult<>(ProjectappointmentConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }

    @Override
    public List<ProjectappointmentVO> queryList(ProjectappointmentQuery query) {
        return ProjectappointmentConvert.INSTANCE.convertList(baseMapper.selectList(getWrapper(query)));
    }

    private LambdaQueryWrapper<ProjectappointmentEntity> getWrapper(ProjectappointmentQuery query){
        LambdaQueryWrapper<ProjectappointmentEntity> wrapper = Wrappers.lambdaQuery();
                    wrapper.eq(null!=query.getId(), ProjectappointmentEntity::getId, query.getId());
                    wrapper.eq(StringUtils.isNotEmpty(query.getName()), ProjectappointmentEntity::getName, query.getName());
                    wrapper.eq(null!=query.getShenheid(), ProjectappointmentEntity::getShenheid, query.getShenheid());
                    wrapper.eq(null!=query.getUserid(), ProjectappointmentEntity::getUserid, query.getUserid());
                    wrapper.eq(StringUtils.isNotEmpty(query.getUsername()), ProjectappointmentEntity::getUsername, query.getUsername());
                    wrapper.eq(null!=query.getAdduserid(), ProjectappointmentEntity::getAdduserid, query.getAdduserid());
                    wrapper.eq(StringUtils.isNotEmpty(query.getAddusername()), ProjectappointmentEntity::getAddusername, query.getAddusername());
                    wrapper.eq(StringUtils.isNotEmpty(query.getPhoto()), ProjectappointmentEntity::getPhoto, query.getPhoto());
                    wrapper.eq(StringUtils.isNotEmpty(query.getShenhe()), ProjectappointmentEntity::getShenhe, query.getShenhe());
                    wrapper.eq(StringUtils.isNotEmpty(query.getFiles()), ProjectappointmentEntity::getFiles, query.getFiles());
                    wrapper.between(ArrayUtils.isNotEmpty(query.getAddtime()), ProjectappointmentEntity::getAddtime, ArrayUtils.isNotEmpty(query.getAddtime()) ? query.getAddtime()[0] : null, ArrayUtils.isNotEmpty(query.getAddtime()) ? query.getAddtime()[1] : null);
            return wrapper;
    }

    @Override
    public void save(ProjectappointmentVO vo) {
        ProjectappointmentEntity entity = ProjectappointmentConvert.INSTANCE.convert(vo);
        baseMapper.insert(entity);
    }

    @Override
    public void update(ProjectappointmentVO vo) {
        ProjectappointmentEntity entity = ProjectappointmentConvert.INSTANCE.convert(vo);
        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);
    }

    @Override
    @SneakyThrows
    public void export(ProjectappointmentQuery query) {
        List<ProjectappointmentVO> list = ProjectappointmentConvert.INSTANCE.convertList(baseMapper.selectList(getWrapper(query)));
        // 写到浏览器打开
        ExcelUtils.excelExport(ProjectappointmentVO.class, "项目预约" + DateUtils.format(new Date()), null, list);
    }

    @Override
    @SneakyThrows
    public void importprojectappointment(File file) {
        ExcelUtils.readAnalysis(file, ProjectappointmentVO.class, new ExcelFinishCallBack<ProjectappointmentVO>() {
            @Override
            public void doAfterAllAnalysed(List<ProjectappointmentVO> result) {
                saveProjectappointments(result);
            }

            @Override
            public void doSaveBatch(List<ProjectappointmentVO> result) {
                saveProjectappointments(result);
            }

            private void saveProjectappointments(List<ProjectappointmentVO> result) {
                List<ProjectappointmentEntity> ProjectappointmentEntities = ProjectappointmentConvert.INSTANCE.convertEntityList(result);
                saveBatch(ProjectappointmentEntities);
            }
        });
    }

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, LambdaQueryWrapper<ProjectappointmentEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, LambdaQueryWrapper<ProjectappointmentEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, LambdaQueryWrapper<ProjectappointmentEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }
}