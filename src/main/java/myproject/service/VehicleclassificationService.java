package myproject.service;

import myproject.common.page.PageResult;
import myproject.common.utils.BaseService;
import myproject.vo.VehicleclassificationVO;
import myproject.query.VehicleclassificationQuery;
import myproject.entity.VehicleclassificationEntity;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

import java.util.List;
import java.util.Map;
import java.io.File;
/**
* 车辆分类
*
*/
public interface VehicleclassificationService extends BaseService<VehicleclassificationEntity> {

    PageResult<VehicleclassificationVO> page(VehicleclassificationQuery query);

    List<VehicleclassificationVO> queryList(VehicleclassificationQuery query);

    void save(VehicleclassificationVO vo);

    void update(VehicleclassificationVO vo);

    void delete(List<Long> idList);

    void export(VehicleclassificationQuery query);

    void importvehicleclassification(File importFile);
                
    List<Map<String, Object>> selectValue(Map<String, Object> params, LambdaQueryWrapper<VehicleclassificationEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, LambdaQueryWrapper<VehicleclassificationEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params, LambdaQueryWrapper<VehicleclassificationEntity> wrapper);
}