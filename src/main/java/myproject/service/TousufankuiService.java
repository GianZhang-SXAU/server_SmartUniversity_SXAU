package myproject.service;

import myproject.common.page.PageResult;
import myproject.common.utils.BaseService;
import myproject.vo.TousufankuiVO;
import myproject.query.TousufankuiQuery;
import myproject.entity.TousufankuiEntity;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

import java.util.List;
import java.util.Map;
/**
* 投诉反馈
*
*/
public interface TousufankuiService extends BaseService<TousufankuiEntity> {

    PageResult<TousufankuiVO> page(TousufankuiQuery query);

    List<TousufankuiVO> queryList(TousufankuiQuery query);

    void save(TousufankuiVO vo);

    void update(TousufankuiVO vo);

    void delete(List<Long> idList);

    void export(TousufankuiQuery query);
                
    List<Map<String, Object>> selectValue(Map<String, Object> params, LambdaQueryWrapper<TousufankuiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, LambdaQueryWrapper<TousufankuiEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params, LambdaQueryWrapper<TousufankuiEntity> wrapper);
}