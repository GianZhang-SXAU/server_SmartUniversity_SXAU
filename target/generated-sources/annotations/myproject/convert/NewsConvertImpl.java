package myproject.convert;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import myproject.entity.NewsEntity;
import myproject.vo.NewsVO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-30T12:44:20+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_401 (Oracle Corporation)"
)
public class NewsConvertImpl implements NewsConvert {

    @Override
    public NewsEntity convert(NewsVO vo) {
        if ( vo == null ) {
            return null;
        }

        NewsEntity newsEntity = new NewsEntity();

        newsEntity.setId( vo.getId() );
        newsEntity.setAddtime( vo.getAddtime() );
        newsEntity.setTitle( vo.getTitle() );
        newsEntity.setIntroduction( vo.getIntroduction() );
        newsEntity.setPicture( vo.getPicture() );
        newsEntity.setContent( vo.getContent() );

        return newsEntity;
    }

    @Override
    public NewsVO convert(NewsEntity entity) {
        if ( entity == null ) {
            return null;
        }

        NewsVO newsVO = new NewsVO();

        newsVO.setId( entity.getId() );
        newsVO.setAddtime( entity.getAddtime() );
        newsVO.setTitle( entity.getTitle() );
        newsVO.setIntroduction( entity.getIntroduction() );
        newsVO.setPicture( entity.getPicture() );
        newsVO.setContent( entity.getContent() );

        return newsVO;
    }

    @Override
    public List<NewsVO> convertList(List<NewsEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<NewsVO> list1 = new ArrayList<NewsVO>( list.size() );
        for ( NewsEntity newsEntity : list ) {
            list1.add( convert( newsEntity ) );
        }

        return list1;
    }
}
