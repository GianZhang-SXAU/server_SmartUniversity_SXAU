package myproject.convert;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import myproject.entity.ImageContentEntity;
import myproject.vo.ImageContentVO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-30T12:44:19+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_401 (Oracle Corporation)"
)
public class ImageContentConvertImpl implements ImageContentConvert {

    @Override
    public ImageContentEntity convert(ImageContentVO vo) {
        if ( vo == null ) {
            return null;
        }

        ImageContentEntity imageContentEntity = new ImageContentEntity();

        imageContentEntity.setId( vo.getId() );
        imageContentEntity.setPath( vo.getPath() );
        imageContentEntity.setFileId( vo.getFileId() );
        imageContentEntity.setCreateTime( vo.getCreateTime() );
        imageContentEntity.setUpdateTime( vo.getUpdateTime() );

        return imageContentEntity;
    }

    @Override
    public ImageContentVO convert(ImageContentEntity entity) {
        if ( entity == null ) {
            return null;
        }

        ImageContentVO imageContentVO = new ImageContentVO();

        imageContentVO.setId( entity.getId() );
        imageContentVO.setPath( entity.getPath() );
        imageContentVO.setFileId( entity.getFileId() );
        imageContentVO.setCreateTime( entity.getCreateTime() );
        imageContentVO.setUpdateTime( entity.getUpdateTime() );

        return imageContentVO;
    }

    @Override
    public List<ImageContentVO> convertList(List<ImageContentEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<ImageContentVO> list1 = new ArrayList<ImageContentVO>( list.size() );
        for ( ImageContentEntity imageContentEntity : list ) {
            list1.add( convert( imageContentEntity ) );
        }

        return list1;
    }
}
