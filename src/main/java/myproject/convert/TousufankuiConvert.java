package myproject.convert;

import myproject.entity.TousufankuiEntity;
import myproject.vo.TousufankuiVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
* 投诉反馈
*
*/
@Mapper
public interface TousufankuiConvert {
    TousufankuiConvert INSTANCE = Mappers.getMapper(TousufankuiConvert.class);

    TousufankuiEntity convert(TousufankuiVO vo);

    TousufankuiVO convert(TousufankuiEntity entity);

    List<TousufankuiVO> convertList(List<TousufankuiEntity> list);

}