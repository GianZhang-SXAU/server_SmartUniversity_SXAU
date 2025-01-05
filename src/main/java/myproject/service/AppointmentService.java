package myproject.service;

import myproject.common.page.PageResult;
import myproject.common.utils.BaseService;
import myproject.vo.AppointmentVO;
import myproject.query.AppointmentQuery;
import myproject.entity.AppointmentEntity;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

import java.util.List;
import java.util.Map;
import java.io.File;
/**
* 预约
*
*/
public interface AppointmentService extends BaseService<AppointmentEntity> {

    PageResult<AppointmentVO> page(AppointmentQuery query);

    List<AppointmentVO> queryList(AppointmentQuery query);

    void save(AppointmentVO vo);

    void update(AppointmentVO vo);

    void delete(List<Long> idList);

    void export(AppointmentQuery query);

    void importappointment(File importFile);
                
    List<Map<String, Object>> selectValue(Map<String, Object> params, LambdaQueryWrapper<AppointmentEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, LambdaQueryWrapper<AppointmentEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params, LambdaQueryWrapper<AppointmentEntity> wrapper);
}