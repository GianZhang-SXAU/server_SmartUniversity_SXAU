package myproject.convert;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import myproject.entity.SystemintroEntity;
import myproject.vo.SystemintroVO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-30T12:44:20+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_401 (Oracle Corporation)"
)
public class SystemintroConvertImpl implements SystemintroConvert {

    @Override
    public SystemintroEntity convert(SystemintroVO vo) {
        if ( vo == null ) {
            return null;
        }

        SystemintroEntity systemintroEntity = new SystemintroEntity();

        systemintroEntity.setId( vo.getId() );
        systemintroEntity.setAddtime( vo.getAddtime() );
        systemintroEntity.setTitle( vo.getTitle() );
        systemintroEntity.setSubtitle( vo.getSubtitle() );
        systemintroEntity.setContent( vo.getContent() );
        systemintroEntity.setPicture1( vo.getPicture1() );
        systemintroEntity.setPicture2( vo.getPicture2() );
        systemintroEntity.setPicture3( vo.getPicture3() );

        return systemintroEntity;
    }

    @Override
    public SystemintroVO convert(SystemintroEntity entity) {
        if ( entity == null ) {
            return null;
        }

        SystemintroVO systemintroVO = new SystemintroVO();

        systemintroVO.setId( entity.getId() );
        systemintroVO.setAddtime( entity.getAddtime() );
        systemintroVO.setTitle( entity.getTitle() );
        systemintroVO.setSubtitle( entity.getSubtitle() );
        systemintroVO.setContent( entity.getContent() );
        systemintroVO.setPicture1( entity.getPicture1() );
        systemintroVO.setPicture2( entity.getPicture2() );
        systemintroVO.setPicture3( entity.getPicture3() );

        return systemintroVO;
    }

    @Override
    public List<SystemintroVO> convertList(List<SystemintroEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<SystemintroVO> list1 = new ArrayList<SystemintroVO>( list.size() );
        for ( SystemintroEntity systemintroEntity : list ) {
            list1.add( convert( systemintroEntity ) );
        }

        return list1;
    }
}
