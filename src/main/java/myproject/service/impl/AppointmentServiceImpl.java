package myproject.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import myproject.common.page.PageResult;
import myproject.common.impl.BaseServiceImpl;
import myproject.convert.AppointmentConvert;
import myproject.entity.AppointmentEntity;
import myproject.query.AppointmentQuery;
import myproject.vo.AppointmentVO;
import myproject.dao.AppointmentDao;
import myproject.service.AppointmentService;
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
* 预约
*
*/
@Service
@AllArgsConstructor
public class AppointmentServiceImpl extends BaseServiceImpl<AppointmentDao, AppointmentEntity> implements AppointmentService {

    @Override
    public PageResult<AppointmentVO> page(AppointmentQuery query) {
        IPage<AppointmentEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));
        return new PageResult<>(AppointmentConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }

    @Override
    public List<AppointmentVO> queryList(AppointmentQuery query) {
        return AppointmentConvert.INSTANCE.convertList(baseMapper.selectList(getWrapper(query)));
    }

    private LambdaQueryWrapper<AppointmentEntity> getWrapper(AppointmentQuery query){
        LambdaQueryWrapper<AppointmentEntity> wrapper = Wrappers.lambdaQuery();
                    wrapper.eq(null!=query.getId(), AppointmentEntity::getId, query.getId());
                    wrapper.eq(null!=query.getShenheid(), AppointmentEntity::getShenheid, query.getShenheid());
                    wrapper.eq(StringUtils.isNotEmpty(query.getName()), AppointmentEntity::getName, query.getName());
                    wrapper.eq(null!=query.getUserid(), AppointmentEntity::getUserid, query.getUserid());
                    wrapper.eq(StringUtils.isNotEmpty(query.getUsername()), AppointmentEntity::getUsername, query.getUsername());
                    wrapper.eq(StringUtils.isNotEmpty(query.getShenhe()), AppointmentEntity::getShenhe, query.getShenhe());
                    wrapper.eq(StringUtils.isNotEmpty(query.getPhoto()), AppointmentEntity::getPhoto, query.getPhoto());
                    wrapper.between(ArrayUtils.isNotEmpty(query.getAddtime()), AppointmentEntity::getAddtime, ArrayUtils.isNotEmpty(query.getAddtime()) ? query.getAddtime()[0] : null, ArrayUtils.isNotEmpty(query.getAddtime()) ? query.getAddtime()[1] : null);
            return wrapper;
    }

    @Override
    public void save(AppointmentVO vo) {
        AppointmentEntity entity = AppointmentConvert.INSTANCE.convert(vo);
        baseMapper.insert(entity);
    }

    @Override
    public void update(AppointmentVO vo) {
        AppointmentEntity entity = AppointmentConvert.INSTANCE.convert(vo);
        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);
    }

    @Override
    @SneakyThrows
    public void export(AppointmentQuery query) {
        List<AppointmentVO> list = AppointmentConvert.INSTANCE.convertList(baseMapper.selectList(getWrapper(query)));
        // 写到浏览器打开
        ExcelUtils.excelExport(AppointmentVO.class, "预约" + DateUtils.format(new Date()), null, list);
    }

    @Override
    @SneakyThrows
    public void importappointment(File file) {
        ExcelUtils.readAnalysis(file, AppointmentVO.class, new ExcelFinishCallBack<AppointmentVO>() {
            @Override
            public void doAfterAllAnalysed(List<AppointmentVO> result) {
                saveAppointments(result);
            }

            @Override
            public void doSaveBatch(List<AppointmentVO> result) {
                saveAppointments(result);
            }

            private void saveAppointments(List<AppointmentVO> result) {
                List<AppointmentEntity> AppointmentEntities = AppointmentConvert.INSTANCE.convertEntityList(result);
                saveBatch(AppointmentEntities);
            }
        });
    }

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, LambdaQueryWrapper<AppointmentEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, LambdaQueryWrapper<AppointmentEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, LambdaQueryWrapper<AppointmentEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }
}