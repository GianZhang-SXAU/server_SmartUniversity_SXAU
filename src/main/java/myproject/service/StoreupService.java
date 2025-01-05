package myproject.service;

import myproject.common.page.PageResult;
import myproject.common.utils.BaseService;
import myproject.vo.StoreupVO;
import myproject.query.StoreupQuery;
import myproject.entity.StoreupEntity;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

import java.util.List;
import java.util.Map;
import java.io.File;
/**
* 收藏表
*
*/
public interface StoreupService extends BaseService<StoreupEntity> {

    PageResult<StoreupVO> page(StoreupQuery query);

    List<StoreupVO> queryList(StoreupQuery query);

    void save(StoreupVO vo);

    void update(StoreupVO vo);

    void delete(List<Long> idList);

    void export(StoreupQuery query);

    void importstoreup(File importFile);
                
    List<Map<String, Object>> selectValue(Map<String, Object> params, LambdaQueryWrapper<StoreupEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, LambdaQueryWrapper<StoreupEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params, LambdaQueryWrapper<StoreupEntity> wrapper);
}