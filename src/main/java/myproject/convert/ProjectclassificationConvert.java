package myproject.convert;

import myproject.entity.ProjectclassificationEntity;
import myproject.vo.ProjectclassificationVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
* 项目分类
*
*/
@Mapper
public interface ProjectclassificationConvert {
    ProjectclassificationConvert INSTANCE = Mappers.getMapper(ProjectclassificationConvert.class);

    ProjectclassificationEntity convert(ProjectclassificationVO vo);

    ProjectclassificationVO convert(ProjectclassificationEntity entity);

    List<ProjectclassificationVO> convertList(List<ProjectclassificationEntity> list);

    List<ProjectclassificationEntity> convertEntityList(List<ProjectclassificationVO> list);
}