package myproject.service;

import myproject.common.page.PageResult;
import myproject.common.utils.BaseService;
import myproject.vo.ProjectclassificationVO;
import myproject.query.ProjectclassificationQuery;
import myproject.entity.ProjectclassificationEntity;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

import java.util.List;
import java.util.Map;
import java.io.File;
/**
* 项目分类
*
*/
public interface ProjectclassificationService extends BaseService<ProjectclassificationEntity> {

    PageResult<ProjectclassificationVO> page(ProjectclassificationQuery query);

    List<ProjectclassificationVO> queryList(ProjectclassificationQuery query);

    void save(ProjectclassificationVO vo);

    void update(ProjectclassificationVO vo);

    void delete(List<Long> idList);

    void export(ProjectclassificationQuery query);

    void importprojectclassification(File importFile);
                
    List<Map<String, Object>> selectValue(Map<String, Object> params, LambdaQueryWrapper<ProjectclassificationEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, LambdaQueryWrapper<ProjectclassificationEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params, LambdaQueryWrapper<ProjectclassificationEntity> wrapper);
}