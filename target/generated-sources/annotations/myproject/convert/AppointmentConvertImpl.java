package myproject.convert;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import myproject.entity.AppointmentEntity;
import myproject.vo.AppointmentVO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-30T12:44:19+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_401 (Oracle Corporation)"
)
public class AppointmentConvertImpl implements AppointmentConvert {

    @Override
    public AppointmentEntity convert(AppointmentVO vo) {
        if ( vo == null ) {
            return null;
        }

        AppointmentEntity appointmentEntity = new AppointmentEntity();

        appointmentEntity.setId( vo.getId() );
        appointmentEntity.setShenheid( vo.getShenheid() );
        appointmentEntity.setName( vo.getName() );
        appointmentEntity.setUserid( vo.getUserid() );
        appointmentEntity.setUsername( vo.getUsername() );
        appointmentEntity.setShenhe( vo.getShenhe() );
        appointmentEntity.setPhoto( vo.getPhoto() );
        appointmentEntity.setAddtime( vo.getAddtime() );

        return appointmentEntity;
    }

    @Override
    public AppointmentVO convert(AppointmentEntity entity) {
        if ( entity == null ) {
            return null;
        }

        AppointmentVO appointmentVO = new AppointmentVO();

        appointmentVO.setId( entity.getId() );
        appointmentVO.setShenheid( entity.getShenheid() );
        appointmentVO.setName( entity.getName() );
        appointmentVO.setUserid( entity.getUserid() );
        appointmentVO.setUsername( entity.getUsername() );
        appointmentVO.setShenhe( entity.getShenhe() );
        appointmentVO.setPhoto( entity.getPhoto() );
        appointmentVO.setAddtime( entity.getAddtime() );

        return appointmentVO;
    }

    @Override
    public List<AppointmentVO> convertList(List<AppointmentEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<AppointmentVO> list1 = new ArrayList<AppointmentVO>( list.size() );
        for ( AppointmentEntity appointmentEntity : list ) {
            list1.add( convert( appointmentEntity ) );
        }

        return list1;
    }

    @Override
    public List<AppointmentEntity> convertEntityList(List<AppointmentVO> list) {
        if ( list == null ) {
            return null;
        }

        List<AppointmentEntity> list1 = new ArrayList<AppointmentEntity>( list.size() );
        for ( AppointmentVO appointmentVO : list ) {
            list1.add( convert( appointmentVO ) );
        }

        return list1;
    }
}
