package myproject.service;

import myproject.common.page.PageResult;
import myproject.common.utils.BaseService;
import myproject.entity.PostcategoriesEntity;
import myproject.query.PostcategoriesQuery;
import myproject.vo.PostcategoriesVO;

import java.util.List;

/**
 * 帖子话题分类
 */
public interface PostcategoriesService extends BaseService<PostcategoriesEntity> {

	PageResult<PostcategoriesVO> page(PostcategoriesQuery query);

	List<PostcategoriesVO> queryList(PostcategoriesQuery query);

	void save(PostcategoriesVO vo);

	void update(PostcategoriesVO vo);

	void delete(List<Long> idList);

	void export(PostcategoriesQuery query);
}