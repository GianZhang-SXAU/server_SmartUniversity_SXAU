package myproject.convert;

import myproject.entity.VehiclesEntity;
import myproject.vo.VehiclesVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
* 车辆
*
*/
@Mapper
public interface VehiclesConvert {
    VehiclesConvert INSTANCE = Mappers.getMapper(VehiclesConvert.class);

    VehiclesEntity convert(VehiclesVO vo);

    VehiclesVO convert(VehiclesEntity entity);

    List<VehiclesVO> convertList(List<VehiclesEntity> list);

    List<VehiclesEntity> convertEntityList(List<VehiclesVO> list);
}