package myproject.convert;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import myproject.entity.TextContentEntity;
import myproject.vo.TextContentVO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-30T12:44:20+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_401 (Oracle Corporation)"
)
public class TextContentConvertImpl implements TextContentConvert {

    @Override
    public TextContentEntity convert(TextContentVO vo) {
        if ( vo == null ) {
            return null;
        }

        TextContentEntity textContentEntity = new TextContentEntity();

        textContentEntity.setId( vo.getId() );
        textContentEntity.setContent( vo.getContent() );
        textContentEntity.setCreateTime( vo.getCreateTime() );
        textContentEntity.setUpdateTime( vo.getUpdateTime() );

        return textContentEntity;
    }

    @Override
    public TextContentVO convert(TextContentEntity entity) {
        if ( entity == null ) {
            return null;
        }

        TextContentVO textContentVO = new TextContentVO();

        textContentVO.setId( entity.getId() );
        textContentVO.setContent( entity.getContent() );
        textContentVO.setCreateTime( entity.getCreateTime() );
        textContentVO.setUpdateTime( entity.getUpdateTime() );

        return textContentVO;
    }

    @Override
    public List<TextContentVO> convertList(List<TextContentEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<TextContentVO> list1 = new ArrayList<TextContentVO>( list.size() );
        for ( TextContentEntity textContentEntity : list ) {
            list1.add( convert( textContentEntity ) );
        }

        return list1;
    }
}
