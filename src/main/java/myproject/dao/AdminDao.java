package myproject.dao;

import myproject.common.utils.BaseDao;
import myproject.entity.AdminEntity;
import org.apache.ibatis.annotations.Mapper;

/**
* 后台管理用户表
*
*/
@Mapper
public interface AdminDao extends BaseDao<AdminEntity> {

}