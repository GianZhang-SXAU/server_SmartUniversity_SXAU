package myproject.convert;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import myproject.entity.AdminEntity;
import myproject.vo.AdminVO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-30T12:44:19+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_401 (Oracle Corporation)"
)
public class AdminConvertImpl implements AdminConvert {

    @Override
    public AdminEntity convert(AdminVO vo) {
        if ( vo == null ) {
            return null;
        }

        AdminEntity adminEntity = new AdminEntity();

        adminEntity.setId( vo.getId() );
        adminEntity.setUsername( vo.getUsername() );
        adminEntity.setPassword( vo.getPassword() );
        adminEntity.setName( vo.getName() );
        adminEntity.setGender( vo.getGender() );
        adminEntity.setPhone( vo.getPhone() );
        adminEntity.setAvatarurl( vo.getAvatarurl() );
        adminEntity.setEmail( vo.getEmail() );
        adminEntity.setRole( vo.getRole() );
        adminEntity.setAddtime( vo.getAddtime() );

        return adminEntity;
    }

    @Override
    public AdminVO convert(AdminEntity entity) {
        if ( entity == null ) {
            return null;
        }

        AdminVO adminVO = new AdminVO();

        adminVO.setId( entity.getId() );
        adminVO.setUsername( entity.getUsername() );
        adminVO.setPassword( entity.getPassword() );
        adminVO.setName( entity.getName() );
        adminVO.setGender( entity.getGender() );
        adminVO.setPhone( entity.getPhone() );
        adminVO.setAvatarurl( entity.getAvatarurl() );
        adminVO.setEmail( entity.getEmail() );
        adminVO.setRole( entity.getRole() );
        adminVO.setAddtime( entity.getAddtime() );

        return adminVO;
    }

    @Override
    public List<AdminVO> convertList(List<AdminEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<AdminVO> list1 = new ArrayList<AdminVO>( list.size() );
        for ( AdminEntity adminEntity : list ) {
            list1.add( convert( adminEntity ) );
        }

        return list1;
    }

    @Override
    public List<AdminEntity> convertListEntity(List<AdminVO> result) {
        if ( result == null ) {
            return null;
        }

        List<AdminEntity> list = new ArrayList<AdminEntity>( result.size() );
        for ( AdminVO adminVO : result ) {
            list.add( convert( adminVO ) );
        }

        return list;
    }
}
