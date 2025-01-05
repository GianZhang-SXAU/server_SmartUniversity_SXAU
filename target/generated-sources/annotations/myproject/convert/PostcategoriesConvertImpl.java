package myproject.convert;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import myproject.entity.PostcategoriesEntity;
import myproject.vo.PostcategoriesVO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-30T12:44:19+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_401 (Oracle Corporation)"
)
public class PostcategoriesConvertImpl implements PostcategoriesConvert {

    @Override
    public PostcategoriesEntity convert(PostcategoriesVO vo) {
        if ( vo == null ) {
            return null;
        }

        PostcategoriesEntity postcategoriesEntity = new PostcategoriesEntity();

        postcategoriesEntity.setId( vo.getId() );
        postcategoriesEntity.setAddtime( vo.getAddtime() );
        postcategoriesEntity.setUserid( vo.getUserid() );
        postcategoriesEntity.setUsername( vo.getUsername() );
        postcategoriesEntity.setCategoryName( vo.getCategoryName() );

        return postcategoriesEntity;
    }

    @Override
    public PostcategoriesVO convert(PostcategoriesEntity entity) {
        if ( entity == null ) {
            return null;
        }

        PostcategoriesVO postcategoriesVO = new PostcategoriesVO();

        postcategoriesVO.setId( entity.getId() );
        postcategoriesVO.setAddtime( entity.getAddtime() );
        postcategoriesVO.setUserid( entity.getUserid() );
        postcategoriesVO.setUsername( entity.getUsername() );
        postcategoriesVO.setCategoryName( entity.getCategoryName() );

        return postcategoriesVO;
    }

    @Override
    public List<PostcategoriesVO> convertList(List<PostcategoriesEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<PostcategoriesVO> list1 = new ArrayList<PostcategoriesVO>( list.size() );
        for ( PostcategoriesEntity postcategoriesEntity : list ) {
            list1.add( convert( postcategoriesEntity ) );
        }

        return list1;
    }
}
