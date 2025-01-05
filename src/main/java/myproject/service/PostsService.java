package myproject.service;

import myproject.common.page.PageResult;
import myproject.common.utils.BaseService;
import myproject.vo.PostsVO;
import myproject.query.PostsQuery;
import myproject.entity.PostsEntity;

import java.util.List;

/**
* 帖子详情
*
*/
public interface PostsService extends BaseService<PostsEntity> {

    PageResult<PostsVO> page(PostsQuery query);

    List<PostsVO> queryList(PostsQuery query);

    void save(PostsVO vo);

    void update(PostsVO vo);

    void delete(List<Long> idList);

    void export(PostsQuery query);
}