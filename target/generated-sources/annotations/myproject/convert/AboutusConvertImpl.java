package myproject.convert;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import myproject.entity.AboutusEntity;
import myproject.vo.AboutusVO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-30T12:44:20+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_401 (Oracle Corporation)"
)
public class AboutusConvertImpl implements AboutusConvert {

    @Override
    public AboutusEntity convert(AboutusVO vo) {
        if ( vo == null ) {
            return null;
        }

        AboutusEntity aboutusEntity = new AboutusEntity();

        aboutusEntity.setId( vo.getId() );
        aboutusEntity.setAddtime( vo.getAddtime() );
        aboutusEntity.setTitle( vo.getTitle() );
        aboutusEntity.setSubtitle( vo.getSubtitle() );
        aboutusEntity.setContent( vo.getContent() );
        aboutusEntity.setPicture1( vo.getPicture1() );
        aboutusEntity.setPicture2( vo.getPicture2() );
        aboutusEntity.setPicture3( vo.getPicture3() );

        return aboutusEntity;
    }

    @Override
    public AboutusVO convert(AboutusEntity entity) {
        if ( entity == null ) {
            return null;
        }

        AboutusVO aboutusVO = new AboutusVO();

        aboutusVO.setId( entity.getId() );
        aboutusVO.setAddtime( entity.getAddtime() );
        aboutusVO.setTitle( entity.getTitle() );
        aboutusVO.setSubtitle( entity.getSubtitle() );
        aboutusVO.setContent( entity.getContent() );
        aboutusVO.setPicture1( entity.getPicture1() );
        aboutusVO.setPicture2( entity.getPicture2() );
        aboutusVO.setPicture3( entity.getPicture3() );

        return aboutusVO;
    }

    @Override
    public List<AboutusVO> convertList(List<AboutusEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<AboutusVO> list1 = new ArrayList<AboutusVO>( list.size() );
        for ( AboutusEntity aboutusEntity : list ) {
            list1.add( convert( aboutusEntity ) );
        }

        return list1;
    }
}
