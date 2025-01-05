package myproject.service;

import myproject.common.page.PageResult;
import myproject.common.utils.BaseService;
import myproject.vo.SysAttachmentVO;
import myproject.query.SysAttachmentQuery;
import myproject.entity.SysAttachmentEntity;

import java.util.List;

/**
* 附件管理

*/
public interface SysAttachmentService extends BaseService<SysAttachmentEntity> {

    PageResult<SysAttachmentVO> page(SysAttachmentQuery query);

    List<SysAttachmentVO> queryList(SysAttachmentQuery query);

    void save(SysAttachmentVO vo);

    void update(SysAttachmentVO vo);

    void delete(List<Long> idList);

    void export(SysAttachmentQuery query);
}