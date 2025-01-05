package myproject.service;


import myproject.common.page.PageResult;
import myproject.common.utils.BaseService;
import myproject.entity.DiscussEntity;
import myproject.query.DiscussQuery;
import myproject.vo.DiscussVO;

import java.util.List;

/**
 * 评论表
 *

 */
public interface DiscussService extends BaseService<DiscussEntity> {
	PageResult<DiscussVO> page(DiscussQuery query);

	void save(DiscussVO vo);

	void update(DiscussVO vo);

	void delete(List<Long> idList);

	List<DiscussVO> queryList(DiscussQuery query);

	void like(Long id);
}