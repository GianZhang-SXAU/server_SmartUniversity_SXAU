package myproject.service;

import myproject.common.page.PageResult;
import myproject.common.utils.BaseService;
import myproject.vo.TextContentVO;
import myproject.query.TextContentQuery;
import myproject.entity.TextContentEntity;

import java.util.List;

/**
* 

*/
public interface TextContentService extends BaseService<TextContentEntity> {

    PageResult<TextContentVO> page(TextContentQuery query);

    List<TextContentVO> queryList(TextContentQuery query);

    void save(TextContentVO vo);

    void update(TextContentVO vo);

    void delete(List<Long> idList);

    void export(TextContentQuery query);
}