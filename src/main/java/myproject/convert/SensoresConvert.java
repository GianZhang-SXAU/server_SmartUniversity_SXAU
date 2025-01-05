package myproject.convert;

import myproject.entity.SensoresEntity;
import myproject.vo.SensoresVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
* 传感器
*
*/
@Mapper
public interface SensoresConvert {
    SensoresConvert INSTANCE = Mappers.getMapper(SensoresConvert.class);

    SensoresEntity convert(SensoresVO vo);

    SensoresVO convert(SensoresEntity entity);

    List<SensoresVO> convertList(List<SensoresEntity> list);

    List<SensoresEntity> convertEntityList(List<SensoresVO> list);
}