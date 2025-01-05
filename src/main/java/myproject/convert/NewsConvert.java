package myproject.convert;

import myproject.entity.NewsEntity;
import myproject.vo.NewsVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
* 公告信息
*
*/
@Mapper
public interface NewsConvert {
    NewsConvert INSTANCE = Mappers.getMapper(NewsConvert.class);

    NewsEntity convert(NewsVO vo);

    NewsVO convert(NewsEntity entity);

    List<NewsVO> convertList(List<NewsEntity> list);

}