package myproject.service;

import myproject.common.page.PageResult;
import myproject.common.utils.BaseService;
import myproject.vo.SensoresVO;
import myproject.query.SensoresQuery;
import myproject.entity.SensoresEntity;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

import java.util.List;
import java.util.Map;
import java.io.File;
/**
* 传感器
*
*/
public interface SensoresService extends BaseService<SensoresEntity> {

    PageResult<SensoresVO> page(SensoresQuery query);

    List<SensoresVO> queryList(SensoresQuery query);

    void save(SensoresVO vo);

    void update(SensoresVO vo);

    void delete(List<Long> idList);

    void export(SensoresQuery query);

    void importsensores(File importFile);
                
    List<Map<String, Object>> selectValue(Map<String, Object> params, LambdaQueryWrapper<SensoresEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, LambdaQueryWrapper<SensoresEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params, LambdaQueryWrapper<SensoresEntity> wrapper);
}