package myproject.convert;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import myproject.entity.ProjectclassificationEntity;
import myproject.vo.ProjectclassificationVO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-30T12:44:19+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_401 (Oracle Corporation)"
)
public class ProjectclassificationConvertImpl implements ProjectclassificationConvert {

    @Override
    public ProjectclassificationEntity convert(ProjectclassificationVO vo) {
        if ( vo == null ) {
            return null;
        }

        ProjectclassificationEntity projectclassificationEntity = new ProjectclassificationEntity();

        projectclassificationEntity.setId( vo.getId() );
        projectclassificationEntity.setName( vo.getName() );
        projectclassificationEntity.setAddtime( vo.getAddtime() );

        return projectclassificationEntity;
    }

    @Override
    public ProjectclassificationVO convert(ProjectclassificationEntity entity) {
        if ( entity == null ) {
            return null;
        }

        ProjectclassificationVO projectclassificationVO = new ProjectclassificationVO();

        projectclassificationVO.setId( entity.getId() );
        projectclassificationVO.setName( entity.getName() );
        projectclassificationVO.setAddtime( entity.getAddtime() );

        return projectclassificationVO;
    }

    @Override
    public List<ProjectclassificationVO> convertList(List<ProjectclassificationEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<ProjectclassificationVO> list1 = new ArrayList<ProjectclassificationVO>( list.size() );
        for ( ProjectclassificationEntity projectclassificationEntity : list ) {
            list1.add( convert( projectclassificationEntity ) );
        }

        return list1;
    }

    @Override
    public List<ProjectclassificationEntity> convertEntityList(List<ProjectclassificationVO> list) {
        if ( list == null ) {
            return null;
        }

        List<ProjectclassificationEntity> list1 = new ArrayList<ProjectclassificationEntity>( list.size() );
        for ( ProjectclassificationVO projectclassificationVO : list ) {
            list1.add( convert( projectclassificationVO ) );
        }

        return list1;
    }
}
