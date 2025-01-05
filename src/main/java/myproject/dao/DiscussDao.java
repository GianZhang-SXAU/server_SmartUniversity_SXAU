package myproject.dao;


import org.apache.ibatis.annotations.Mapper;
import myproject.common.utils.BaseDao;
import myproject.entity.DiscussEntity;

/**
 * 评论表
 *

 */
@Mapper
public interface DiscussDao extends BaseDao<DiscussEntity> {

	void like(Long id);
}