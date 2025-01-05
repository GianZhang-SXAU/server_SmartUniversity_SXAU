package myproject.convert;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import myproject.entity.PostcategoriesEntity;
import myproject.vo.PostcategoriesVO;

import java.util.List;

/**
 * 帖子话题分类
 */
@Mapper
public interface PostcategoriesConvert {
	PostcategoriesConvert INSTANCE = Mappers.getMapper(PostcategoriesConvert.class);

	PostcategoriesEntity convert(PostcategoriesVO vo);

	PostcategoriesVO convert(PostcategoriesEntity entity);

	List<PostcategoriesVO> convertList(List<PostcategoriesEntity> list);

}