package myproject.convert;

import myproject.entity.VehicleclassificationEntity;
import myproject.vo.VehicleclassificationVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
* 车辆分类
*
*/
@Mapper
public interface VehicleclassificationConvert {
    VehicleclassificationConvert INSTANCE = Mappers.getMapper(VehicleclassificationConvert.class);

    VehicleclassificationEntity convert(VehicleclassificationVO vo);

    VehicleclassificationVO convert(VehicleclassificationEntity entity);

    List<VehicleclassificationVO> convertList(List<VehicleclassificationEntity> list);

    List<VehicleclassificationEntity> convertEntityList(List<VehicleclassificationVO> list);
}