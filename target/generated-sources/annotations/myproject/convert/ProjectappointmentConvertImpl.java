package myproject.convert;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import myproject.entity.ProjectappointmentEntity;
import myproject.vo.ProjectappointmentVO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-30T12:44:20+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_401 (Oracle Corporation)"
)
public class ProjectappointmentConvertImpl implements ProjectappointmentConvert {

    @Override
    public ProjectappointmentEntity convert(ProjectappointmentVO vo) {
        if ( vo == null ) {
            return null;
        }

        ProjectappointmentEntity projectappointmentEntity = new ProjectappointmentEntity();

        projectappointmentEntity.setId( vo.getId() );
        projectappointmentEntity.setName( vo.getName() );
        projectappointmentEntity.setShenheid( vo.getShenheid() );
        projectappointmentEntity.setUserid( vo.getUserid() );
        projectappointmentEntity.setUsername( vo.getUsername() );
        projectappointmentEntity.setAdduserid( vo.getAdduserid() );
        projectappointmentEntity.setAddusername( vo.getAddusername() );
        projectappointmentEntity.setPhoto( vo.getPhoto() );
        projectappointmentEntity.setShenhe( vo.getShenhe() );
        projectappointmentEntity.setFiles( vo.getFiles() );
        projectappointmentEntity.setAddtime( vo.getAddtime() );

        return projectappointmentEntity;
    }

    @Override
    public ProjectappointmentVO convert(ProjectappointmentEntity entity) {
        if ( entity == null ) {
            return null;
        }

        ProjectappointmentVO projectappointmentVO = new ProjectappointmentVO();

        projectappointmentVO.setId( entity.getId() );
        projectappointmentVO.setName( entity.getName() );
        projectappointmentVO.setShenheid( entity.getShenheid() );
        projectappointmentVO.setUserid( entity.getUserid() );
        projectappointmentVO.setUsername( entity.getUsername() );
        projectappointmentVO.setAdduserid( entity.getAdduserid() );
        projectappointmentVO.setAddusername( entity.getAddusername() );
        projectappointmentVO.setPhoto( entity.getPhoto() );
        projectappointmentVO.setShenhe( entity.getShenhe() );
        projectappointmentVO.setFiles( entity.getFiles() );
        projectappointmentVO.setAddtime( entity.getAddtime() );

        return projectappointmentVO;
    }

    @Override
    public List<ProjectappointmentVO> convertList(List<ProjectappointmentEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<ProjectappointmentVO> list1 = new ArrayList<ProjectappointmentVO>( list.size() );
        for ( ProjectappointmentEntity projectappointmentEntity : list ) {
            list1.add( convert( projectappointmentEntity ) );
        }

        return list1;
    }

    @Override
    public List<ProjectappointmentEntity> convertEntityList(List<ProjectappointmentVO> list) {
        if ( list == null ) {
            return null;
        }

        List<ProjectappointmentEntity> list1 = new ArrayList<ProjectappointmentEntity>( list.size() );
        for ( ProjectappointmentVO projectappointmentVO : list ) {
            list1.add( convert( projectappointmentVO ) );
        }

        return list1;
    }
}
