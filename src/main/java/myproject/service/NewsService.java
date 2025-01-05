package myproject.service;

import myproject.common.page.PageResult;
import myproject.common.utils.BaseService;
import myproject.vo.NewsVO;
import myproject.query.NewsQuery;
import myproject.entity.NewsEntity;

import java.util.List;

/**
* 公告信息
*
*/
public interface NewsService extends BaseService<NewsEntity> {

    PageResult<NewsVO> page(NewsQuery query);

    List<NewsVO> queryList(NewsQuery query);

    void save(NewsVO vo);

    void update(NewsVO vo);

    void delete(List<Long> idList);

    void export(NewsQuery query);
}