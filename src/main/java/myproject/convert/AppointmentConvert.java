package myproject.convert;

import myproject.entity.AppointmentEntity;
import myproject.vo.AppointmentVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
* 预约
*
*/
@Mapper
public interface AppointmentConvert {
    AppointmentConvert INSTANCE = Mappers.getMapper(AppointmentConvert.class);

    AppointmentEntity convert(AppointmentVO vo);

    AppointmentVO convert(AppointmentEntity entity);

    List<AppointmentVO> convertList(List<AppointmentEntity> list);

    List<AppointmentEntity> convertEntityList(List<AppointmentVO> list);
}