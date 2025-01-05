package myproject.convert;

import myproject.entity.StoreupEntity;
import myproject.vo.StoreupVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
* 收藏表
*
*/
@Mapper
public interface StoreupConvert {
    StoreupConvert INSTANCE = Mappers.getMapper(StoreupConvert.class);

    StoreupEntity convert(StoreupVO vo);

    StoreupVO convert(StoreupEntity entity);

    List<StoreupVO> convertList(List<StoreupEntity> list);

    List<StoreupEntity> convertEntityList(List<StoreupVO> list);
}