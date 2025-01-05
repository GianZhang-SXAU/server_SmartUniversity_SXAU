package myproject.dao;

import myproject.common.utils.BaseDao;
import myproject.entity.PostsEntity;
import org.apache.ibatis.annotations.Mapper;

/**
* 帖子详情
*
*/
@Mapper
public interface PostsDao extends BaseDao<PostsEntity> {

}