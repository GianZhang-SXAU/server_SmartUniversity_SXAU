package myproject.service;

import myproject.common.page.PageResult;
import myproject.common.utils.BaseService;
import myproject.vo.RouteplanningVO;
import myproject.query.RouteplanningQuery;
import myproject.entity.RouteplanningEntity;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

import java.util.List;
import java.util.Map;
import java.io.File;
/**
* 线路规划
*
*/
public interface RouteplanningService extends BaseService<RouteplanningEntity> {

    PageResult<RouteplanningVO> page(RouteplanningQuery query);

    List<RouteplanningVO> queryList(RouteplanningQuery query);

    void save(RouteplanningVO vo);

    void update(RouteplanningVO vo);

    void delete(List<Long> idList);

    void export(RouteplanningQuery query);

    void importrouteplanning(File importFile);
                
    List<Map<String, Object>> selectValue(Map<String, Object> params, LambdaQueryWrapper<RouteplanningEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, LambdaQueryWrapper<RouteplanningEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params, LambdaQueryWrapper<RouteplanningEntity> wrapper);
}