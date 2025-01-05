package myproject.dao;

import myproject.common.utils.BaseDao;
import myproject.entity.SysAttachmentEntity;
import org.apache.ibatis.annotations.Mapper;

/**
* 附件管理

*/
@Mapper
public interface SysAttachmentDao extends BaseDao<SysAttachmentEntity> {

}