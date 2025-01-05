package myproject.convert;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import myproject.entity.ConfigEntity;
import myproject.vo.ConfigVO;

import java.util.List;

/**
 * 配置文件
 */
@Mapper
public interface ConfigConvert {
	ConfigConvert INSTANCE = Mappers.getMapper(ConfigConvert.class);

	ConfigEntity convert(ConfigVO vo);

	ConfigVO convert(ConfigEntity entity);

	List<ConfigVO> convertList(List<ConfigEntity> list);

	List<ConfigEntity> convertEntityList(List<ConfigVO> result);
}