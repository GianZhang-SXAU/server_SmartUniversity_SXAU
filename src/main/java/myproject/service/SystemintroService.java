package myproject.service;


import myproject.common.page.PageResult;
import myproject.common.utils.BaseService;
import myproject.entity.SystemintroEntity;
import myproject.query.SystemintroQuery;
import myproject.vo.SystemintroVO;

import java.util.List;

/**
 * 关于我们
 *

 */
public interface SystemintroService extends BaseService
		<SystemintroEntity> {

	PageResult<SystemintroVO> page(SystemintroQuery query);

	void save(SystemintroVO vo);

	void update(SystemintroVO vo);

	void delete(List
			            <Long> idList);
}