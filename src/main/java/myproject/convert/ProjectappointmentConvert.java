package myproject.convert;

import myproject.entity.ProjectappointmentEntity;
import myproject.vo.ProjectappointmentVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
* 项目预约
*
*/
@Mapper
public interface ProjectappointmentConvert {
    ProjectappointmentConvert INSTANCE = Mappers.getMapper(ProjectappointmentConvert.class);

    ProjectappointmentEntity convert(ProjectappointmentVO vo);

    ProjectappointmentVO convert(ProjectappointmentEntity entity);

    List<ProjectappointmentVO> convertList(List<ProjectappointmentEntity> list);

    List<ProjectappointmentEntity> convertEntityList(List<ProjectappointmentVO> list);
}