package myproject.service;

import myproject.common.page.PageResult;
import myproject.common.utils.BaseService;
import myproject.vo.ImageContentVO;
import myproject.query.ImageContentQuery;
import myproject.entity.ImageContentEntity;

import java.util.List;

/**
* 

*/
public interface ImageContentService extends BaseService<ImageContentEntity> {

    PageResult<ImageContentVO> page(ImageContentQuery query);

    List<ImageContentVO> queryList(ImageContentQuery query);

    void save(ImageContentVO vo);

    void update(ImageContentVO vo);

    void delete(List<Long> idList);

    void export(ImageContentQuery query);
}