package myproject.dao;

import myproject.common.utils.BaseDao;
import myproject.entity.ConfigEntity;
import org.apache.ibatis.annotations.Mapper;

/**
* 配置文件
*
*/
@Mapper
public interface ConfigDao extends BaseDao<ConfigEntity> {

}