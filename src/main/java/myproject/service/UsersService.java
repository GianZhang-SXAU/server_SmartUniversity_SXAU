package myproject.service;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import myproject.common.page.PageResult;
import myproject.common.utils.BaseService;
import myproject.entity.UsersEntity;
import myproject.query.UsersQuery;

import java.util.List;


/**
 * 系统用户
 */
public interface UsersService extends BaseService<UsersEntity> {
	PageResult<UsersEntity> queryPage(UsersQuery user);

	List<UsersEntity> selectListView(Wrapper<UsersEntity> wrapper);

	UsersEntity getByUsername(String username);
}
