package myproject.convert;

import myproject.entity.TestprojectEntity;
import myproject.vo.TestprojectVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
* 检测项目
*
*/
@Mapper
public interface TestprojectConvert {
    TestprojectConvert INSTANCE = Mappers.getMapper(TestprojectConvert.class);

    TestprojectEntity convert(TestprojectVO vo);

    TestprojectVO convert(TestprojectEntity entity);

    List<TestprojectVO> convertList(List<TestprojectEntity> list);

    List<TestprojectEntity> convertEntityList(List<TestprojectVO> list);
}