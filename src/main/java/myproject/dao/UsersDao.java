package myproject.dao;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import myproject.entity.UsersEntity;
import myproject.common.utils.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户
 */
@Mapper
public interface UsersDao extends BaseDao<UsersEntity> {

	List<UsersEntity> selectListView(@Param("ew") Wrapper<UsersEntity> wrapper);

}
