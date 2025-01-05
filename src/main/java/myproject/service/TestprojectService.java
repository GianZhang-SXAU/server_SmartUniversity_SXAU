package myproject.service;

import myproject.common.page.PageResult;
import myproject.common.utils.BaseService;
import myproject.vo.TestprojectVO;
import myproject.query.TestprojectQuery;
import myproject.entity.TestprojectEntity;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

import java.util.List;
import java.util.Map;
import java.io.File;
/**
* 检测项目
*
*/
public interface TestprojectService extends BaseService<TestprojectEntity> {

    PageResult<TestprojectVO> page(TestprojectQuery query);

    List<TestprojectVO> queryList(TestprojectQuery query);

    void save(TestprojectVO vo);

    void update(TestprojectVO vo);

    void delete(List<Long> idList);

    void export(TestprojectQuery query);

    void importtestproject(File importFile);
                
    List<Map<String, Object>> selectValue(Map<String, Object> params, LambdaQueryWrapper<TestprojectEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, LambdaQueryWrapper<TestprojectEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params, LambdaQueryWrapper<TestprojectEntity> wrapper);
}