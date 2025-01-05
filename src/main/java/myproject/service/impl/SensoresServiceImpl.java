package myproject.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import myproject.common.page.PageResult;
import myproject.common.impl.BaseServiceImpl;
import myproject.convert.SensoresConvert;
import myproject.entity.SensoresEntity;
import myproject.query.SensoresQuery;
import myproject.vo.SensoresVO;
import myproject.dao.SensoresDao;
import myproject.service.SensoresService;
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
* 传感器
*
*/
@Service
@AllArgsConstructor
public class SensoresServiceImpl extends BaseServiceImpl<SensoresDao, SensoresEntity> implements SensoresService {

    @Override
    public PageResult<SensoresVO> page(SensoresQuery query) {
        IPage<SensoresEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));
        return new PageResult<>(SensoresConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }

    @Override
    public List<SensoresVO> queryList(SensoresQuery query) {
        return SensoresConvert.INSTANCE.convertList(baseMapper.selectList(getWrapper(query)));
    }

    private LambdaQueryWrapper<SensoresEntity> getWrapper(SensoresQuery query){
        LambdaQueryWrapper<SensoresEntity> wrapper = Wrappers.lambdaQuery();
                    wrapper.eq(null!=query.getId(), SensoresEntity::getId, query.getId());
                    wrapper.eq(StringUtils.isNotEmpty(query.getName()), SensoresEntity::getName, query.getName());
                    wrapper.eq(StringUtils.isNotEmpty(query.getType()), SensoresEntity::getType, query.getType());
                    wrapper.eq(StringUtils.isNotEmpty(query.getSensorbrand()), SensoresEntity::getSensorbrand, query.getSensorbrand());
                    wrapper.eq(StringUtils.isNotEmpty(query.getInstallationposition()), SensoresEntity::getInstallationposition, query.getInstallationposition());
                    wrapper.between(ArrayUtils.isNotEmpty(query.getInstallationtime()), SensoresEntity::getInstallationtime, ArrayUtils.isNotEmpty(query.getInstallationtime()) ? query.getInstallationtime()[0] : null, ArrayUtils.isNotEmpty(query.getInstallationtime()) ? query.getInstallationtime()[1] : null);
                    wrapper.eq(StringUtils.isNotEmpty(query.getSensorstate()), SensoresEntity::getSensorstate, query.getSensorstate());
                    wrapper.eq(null!=query.getVehicleid(), SensoresEntity::getVehicleid, query.getVehicleid());
                    wrapper.eq(StringUtils.isNotEmpty(query.getVehiclename()), SensoresEntity::getVehiclename, query.getVehiclename());
                    wrapper.eq(StringUtils.isNotEmpty(query.getPhoto()), SensoresEntity::getPhoto, query.getPhoto());
                    wrapper.eq(StringUtils.isNotEmpty(query.getDetails()), SensoresEntity::getDetails, query.getDetails());
                    wrapper.between(ArrayUtils.isNotEmpty(query.getAddtime()), SensoresEntity::getAddtime, ArrayUtils.isNotEmpty(query.getAddtime()) ? query.getAddtime()[0] : null, ArrayUtils.isNotEmpty(query.getAddtime()) ? query.getAddtime()[1] : null);
            return wrapper;
    }

    @Override
    public void save(SensoresVO vo) {
        SensoresEntity entity = SensoresConvert.INSTANCE.convert(vo);
        baseMapper.insert(entity);
    }

    @Override
    public void update(SensoresVO vo) {
        SensoresEntity entity = SensoresConvert.INSTANCE.convert(vo);
        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);
    }

    @Override
    @SneakyThrows
    public void export(SensoresQuery query) {
        List<SensoresVO> list = SensoresConvert.INSTANCE.convertList(baseMapper.selectList(getWrapper(query)));
        // 写到浏览器打开
        ExcelUtils.excelExport(SensoresVO.class, "传感器" + DateUtils.format(new Date()), null, list);
    }

    @Override
    @SneakyThrows
    public void importsensores(File file) {
        ExcelUtils.readAnalysis(file, SensoresVO.class, new ExcelFinishCallBack<SensoresVO>() {
            @Override
            public void doAfterAllAnalysed(List<SensoresVO> result) {
                saveSensoress(result);
            }

            @Override
            public void doSaveBatch(List<SensoresVO> result) {
                saveSensoress(result);
            }

            private void saveSensoress(List<SensoresVO> result) {
                List<SensoresEntity> SensoresEntities = SensoresConvert.INSTANCE.convertEntityList(result);
                saveBatch(SensoresEntities);
            }
        });
    }

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, LambdaQueryWrapper<SensoresEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, LambdaQueryWrapper<SensoresEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, LambdaQueryWrapper<SensoresEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }
}