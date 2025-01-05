package myproject.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import myproject.common.page.PageResult;
import myproject.common.impl.BaseServiceImpl;
import myproject.convert.VehiclesConvert;
import myproject.entity.VehiclesEntity;
import myproject.query.VehiclesQuery;
import myproject.vo.VehiclesVO;
import myproject.dao.VehiclesDao;
import myproject.service.VehiclesService;
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
* 车辆
*
*/
@Service
@AllArgsConstructor
public class VehiclesServiceImpl extends BaseServiceImpl<VehiclesDao, VehiclesEntity> implements VehiclesService {

    @Override
    public PageResult<VehiclesVO> page(VehiclesQuery query) {
        IPage<VehiclesEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));
        return new PageResult<>(VehiclesConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }

    @Override
    public List<VehiclesVO> queryList(VehiclesQuery query) {
        return VehiclesConvert.INSTANCE.convertList(baseMapper.selectList(getWrapper(query)));
    }

    private LambdaQueryWrapper<VehiclesEntity> getWrapper(VehiclesQuery query){
        LambdaQueryWrapper<VehiclesEntity> wrapper = Wrappers.lambdaQuery();
                    wrapper.eq(null!=query.getId(), VehiclesEntity::getId, query.getId());
                    wrapper.eq(StringUtils.isNotEmpty(query.getClassify()), VehiclesEntity::getClassify, query.getClassify());
                    wrapper.eq(StringUtils.isNotEmpty(query.getName()), VehiclesEntity::getName, query.getName());
                    wrapper.eq(StringUtils.isNotEmpty(query.getColor()), VehiclesEntity::getColor, query.getColor());
                    wrapper.eq(null!=query.getVin(), VehiclesEntity::getVin, query.getVin());
                    wrapper.eq(StringUtils.isNotEmpty(query.getCode()), VehiclesEntity::getCode, query.getCode());
                    wrapper.eq(StringUtils.isNotEmpty(query.getType()), VehiclesEntity::getType, query.getType());
                    wrapper.eq(StringUtils.isNotEmpty(query.getTransmissiontype()), VehiclesEntity::getTransmissiontype, query.getTransmissiontype());
                    wrapper.eq(StringUtils.isNotEmpty(query.getSize()), VehiclesEntity::getSize, query.getSize());
                    wrapper.eq(StringUtils.isNotEmpty(query.getTirespecifications()), VehiclesEntity::getTirespecifications, query.getTirespecifications());
                    wrapper.eq(StringUtils.isNotEmpty(query.getMileage()), VehiclesEntity::getMileage, query.getMileage());
                    wrapper.eq(StringUtils.isNotEmpty(query.getFueltype()), VehiclesEntity::getFueltype, query.getFueltype());
                    wrapper.eq(StringUtils.isNotEmpty(query.getDetail()), VehiclesEntity::getDetail, query.getDetail());
                    wrapper.eq(StringUtils.isNotEmpty(query.getDetails()), VehiclesEntity::getDetails, query.getDetails());
                    wrapper.eq(StringUtils.isNotEmpty(query.getPhoto()), VehiclesEntity::getPhoto, query.getPhoto());
                    wrapper.eq(StringUtils.isNotEmpty(query.getPhotos()), VehiclesEntity::getPhotos, query.getPhotos());
                    wrapper.eq(StringUtils.isNotEmpty(query.getStatus()), VehiclesEntity::getStatus, query.getStatus());
                    wrapper.between(ArrayUtils.isNotEmpty(query.getAddtime()), VehiclesEntity::getAddtime, ArrayUtils.isNotEmpty(query.getAddtime()) ? query.getAddtime()[0] : null, ArrayUtils.isNotEmpty(query.getAddtime()) ? query.getAddtime()[1] : null);
            return wrapper;
    }

    @Override
    public void save(VehiclesVO vo) {
        VehiclesEntity entity = VehiclesConvert.INSTANCE.convert(vo);
        baseMapper.insert(entity);
    }

    @Override
    public void update(VehiclesVO vo) {
        VehiclesEntity entity = VehiclesConvert.INSTANCE.convert(vo);
        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);
    }

    @Override
    @SneakyThrows
    public void export(VehiclesQuery query) {
        List<VehiclesVO> list = VehiclesConvert.INSTANCE.convertList(baseMapper.selectList(getWrapper(query)));
        // 写到浏览器打开
        ExcelUtils.excelExport(VehiclesVO.class, "车辆" + DateUtils.format(new Date()), null, list);
    }

    @Override
    @SneakyThrows
    public void importvehicles(File file) {
        ExcelUtils.readAnalysis(file, VehiclesVO.class, new ExcelFinishCallBack<VehiclesVO>() {
            @Override
            public void doAfterAllAnalysed(List<VehiclesVO> result) {
                saveVehicless(result);
            }

            @Override
            public void doSaveBatch(List<VehiclesVO> result) {
                saveVehicless(result);
            }

            private void saveVehicless(List<VehiclesVO> result) {
                List<VehiclesEntity> VehiclesEntities = VehiclesConvert.INSTANCE.convertEntityList(result);
                saveBatch(VehiclesEntities);
            }
        });
    }

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, LambdaQueryWrapper<VehiclesEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, LambdaQueryWrapper<VehiclesEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, LambdaQueryWrapper<VehiclesEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }
}