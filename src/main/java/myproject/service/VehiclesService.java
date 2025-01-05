package myproject.service;

import myproject.common.page.PageResult;
import myproject.common.utils.BaseService;
import myproject.vo.VehiclesVO;
import myproject.query.VehiclesQuery;
import myproject.entity.VehiclesEntity;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

import java.util.List;
import java.util.Map;
import java.io.File;
/**
* 车辆
*
*/
public interface VehiclesService extends BaseService<VehiclesEntity> {

    PageResult<VehiclesVO> page(VehiclesQuery query);

    List<VehiclesVO> queryList(VehiclesQuery query);

    void save(VehiclesVO vo);

    void update(VehiclesVO vo);

    void delete(List<Long> idList);

    void export(VehiclesQuery query);

    void importvehicles(File importFile);
                
    List<Map<String, Object>> selectValue(Map<String, Object> params, LambdaQueryWrapper<VehiclesEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, LambdaQueryWrapper<VehiclesEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params, LambdaQueryWrapper<VehiclesEntity> wrapper);
}