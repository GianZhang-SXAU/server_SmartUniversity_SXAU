package myproject.dao;

import org.apache.ibatis.annotations.Mapper;
import myproject.common.utils.BaseDao;
import myproject.entity.PostcategoriesEntity;

/**
 * 帖子话题分类
 */
@Mapper
public interface PostcategoriesDao extends BaseDao<PostcategoriesEntity> {

}