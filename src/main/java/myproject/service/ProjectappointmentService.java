package myproject.service;

import myproject.common.page.PageResult;
import myproject.common.utils.BaseService;
import myproject.vo.ProjectappointmentVO;
import myproject.query.ProjectappointmentQuery;
import myproject.entity.ProjectappointmentEntity;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

import java.util.List;
import java.util.Map;
import java.io.File;
/**
* 项目预约
*
*/
public interface ProjectappointmentService extends BaseService<ProjectappointmentEntity> {

    PageResult<ProjectappointmentVO> page(ProjectappointmentQuery query);

    List<ProjectappointmentVO> queryList(ProjectappointmentQuery query);

    void save(ProjectappointmentVO vo);

    void update(ProjectappointmentVO vo);

    void delete(List<Long> idList);

    void export(ProjectappointmentQuery query);

    void importprojectappointment(File importFile);
                
    List<Map<String, Object>> selectValue(Map<String, Object> params, LambdaQueryWrapper<ProjectappointmentEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, LambdaQueryWrapper<ProjectappointmentEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params, LambdaQueryWrapper<ProjectappointmentEntity> wrapper);
}