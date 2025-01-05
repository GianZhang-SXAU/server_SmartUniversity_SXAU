package myproject.convert;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import myproject.entity.SystemintroEntity;
import myproject.vo.SystemintroVO;

import java.util.List;

/**
 * 关于我们
 */
@Mapper
public interface SystemintroConvert {
	SystemintroConvert INSTANCE = Mappers.getMapper(SystemintroConvert.class);

	SystemintroEntity convert(SystemintroVO vo);

	SystemintroVO convert(SystemintroEntity entity);

	List<SystemintroVO> convertList(List<SystemintroEntity> list);

}