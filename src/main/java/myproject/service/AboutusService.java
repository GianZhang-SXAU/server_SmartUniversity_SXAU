package myproject.service;

import myproject.common.page.PageResult;
import myproject.common.utils.BaseService;
import myproject.vo.AboutusVO;
import myproject.query.AboutusQuery;
import myproject.entity.AboutusEntity;

import java.util.List;

/**
* 关于我们
*
*/
public interface AboutusService extends BaseService<AboutusEntity> {

    PageResult<AboutusVO> page(AboutusQuery query);

    List<AboutusVO> queryList(AboutusQuery query);

    void save(AboutusVO vo);

    void update(AboutusVO vo);

    void delete(List<Long> idList);

    void export(AboutusQuery query);
}