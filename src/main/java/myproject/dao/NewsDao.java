package myproject.dao;

import myproject.common.utils.BaseDao;
import myproject.entity.NewsEntity;
import org.apache.ibatis.annotations.Mapper;

/**
* 公告信息
*
*/
@Mapper
public interface NewsDao extends BaseDao<NewsEntity> {

}