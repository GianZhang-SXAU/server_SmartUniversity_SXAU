package myproject.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import myproject.common.page.PageResult;
import myproject.common.impl.BaseServiceImpl;
import myproject.convert.VehicleclassificationConvert;
import myproject.entity.VehicleclassificationEntity;
import myproject.query.VehicleclassificationQuery;
import myproject.vo.VehicleclassificationVO;
import myproject.dao.VehicleclassificationDao;
import myproject.service.VehicleclassificationService;
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
* 车辆分类
*
*/
@Service
@AllArgsConstructor
public class VehicleclassificationServiceImpl extends BaseServiceImpl<VehicleclassificationDao, VehicleclassificationEntity> implements VehicleclassificationService {

    @Override
    public PageResult<VehicleclassificationVO> page(VehicleclassificationQuery query) {
        IPage<VehicleclassificationEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));
        return new PageResult<>(VehicleclassificationConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }

    @Override
    public List<VehicleclassificationVO> queryList(VehicleclassificationQuery query) {
        return VehicleclassificationConvert.INSTANCE.convertList(baseMapper.selectList(getWrapper(query)));
    }

    private LambdaQueryWrapper<VehicleclassificationEntity> getWrapper(VehicleclassificationQuery query){
        LambdaQueryWrapper<VehicleclassificationEntity> wrapper = Wrappers.lambdaQuery();
                    wrapper.eq(null!=query.getId(), VehicleclassificationEntity::getId, query.getId());
                    wrapper.eq(StringUtils.isNotEmpty(query.getName()), VehicleclassificationEntity::getName, query.getName());
                    wrapper.between(ArrayUtils.isNotEmpty(query.getAddtime()), VehicleclassificationEntity::getAddtime, ArrayUtils.isNotEmpty(query.getAddtime()) ? query.getAddtime()[0] : null, ArrayUtils.isNotEmpty(query.getAddtime()) ? query.getAddtime()[1] : null);
            return wrapper;
    }

    @Override
    public void save(VehicleclassificationVO vo) {
        VehicleclassificationEntity entity = VehicleclassificationConvert.INSTANCE.convert(vo);
        baseMapper.insert(entity);
    }

    @Override
    public void update(VehicleclassificationVO vo) {
        VehicleclassificationEntity entity = VehicleclassificationConvert.INSTANCE.convert(vo);
        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);
    }

    @Override
    @SneakyThrows
    public void export(VehicleclassificationQuery query) {
        List<VehicleclassificationVO> list = VehicleclassificationConvert.INSTANCE.convertList(baseMapper.selectList(getWrapper(query)));
        // 写到浏览器打开
        ExcelUtils.excelExport(VehicleclassificationVO.class, "车辆分类" + DateUtils.format(new Date()), null, list);
    }

    @Override
    @SneakyThrows
    public void importvehicleclassification(File file) {
        ExcelUtils.readAnalysis(file, VehicleclassificationVO.class, new ExcelFinishCallBack<VehicleclassificationVO>() {
            @Override
            public void doAfterAllAnalysed(List<VehicleclassificationVO> result) {
                saveVehicleclassifications(result);
            }

            @Override
            public void doSaveBatch(List<VehicleclassificationVO> result) {
                saveVehicleclassifications(result);
            }

            private void saveVehicleclassifications(List<VehicleclassificationVO> result) {
                List<VehicleclassificationEntity> VehicleclassificationEntities = VehicleclassificationConvert.INSTANCE.convertEntityList(result);
                saveBatch(VehicleclassificationEntities);
            }
        });
    }

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, LambdaQueryWrapper<VehicleclassificationEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, LambdaQueryWrapper<VehicleclassificationEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, LambdaQueryWrapper<VehicleclassificationEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }
}