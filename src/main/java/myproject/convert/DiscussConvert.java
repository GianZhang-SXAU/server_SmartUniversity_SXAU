package myproject.convert;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import myproject.entity.DiscussEntity;
import myproject.vo.DiscussVO;

import java.util.List;

/**
 * 评论表
 */
@Mapper
public interface DiscussConvert {
	DiscussConvert INSTANCE = Mappers.getMapper(DiscussConvert.class);

	DiscussEntity convert(DiscussVO vo);

	DiscussVO convert(DiscussEntity entity);

	List<DiscussVO> convertList(List<DiscussEntity> list);

}