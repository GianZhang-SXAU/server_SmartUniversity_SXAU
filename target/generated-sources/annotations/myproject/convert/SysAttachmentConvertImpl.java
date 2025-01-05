package myproject.convert;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import myproject.entity.SysAttachmentEntity;
import myproject.vo.SysAttachmentVO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-30T12:44:20+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_401 (Oracle Corporation)"
)
public class SysAttachmentConvertImpl implements SysAttachmentConvert {

    @Override
    public SysAttachmentEntity convert(SysAttachmentVO vo) {
        if ( vo == null ) {
            return null;
        }

        SysAttachmentEntity sysAttachmentEntity = new SysAttachmentEntity();

        sysAttachmentEntity.setId( vo.getId() );
        sysAttachmentEntity.setName( vo.getName() );
        sysAttachmentEntity.setUrl( vo.getUrl() );
        sysAttachmentEntity.setSize( vo.getSize() );
        sysAttachmentEntity.setPlatform( vo.getPlatform() );
        sysAttachmentEntity.setCreator( vo.getCreator() );
        sysAttachmentEntity.setCreateTime( vo.getCreateTime() );

        return sysAttachmentEntity;
    }

    @Override
    public SysAttachmentVO convert(SysAttachmentEntity entity) {
        if ( entity == null ) {
            return null;
        }

        SysAttachmentVO sysAttachmentVO = new SysAttachmentVO();

        sysAttachmentVO.setId( entity.getId() );
        sysAttachmentVO.setName( entity.getName() );
        sysAttachmentVO.setUrl( entity.getUrl() );
        sysAttachmentVO.setSize( entity.getSize() );
        sysAttachmentVO.setPlatform( entity.getPlatform() );
        sysAttachmentVO.setCreator( entity.getCreator() );
        sysAttachmentVO.setCreateTime( entity.getCreateTime() );

        return sysAttachmentVO;
    }

    @Override
    public List<SysAttachmentVO> convertList(List<SysAttachmentEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<SysAttachmentVO> list1 = new ArrayList<SysAttachmentVO>( list.size() );
        for ( SysAttachmentEntity sysAttachmentEntity : list ) {
            list1.add( convert( sysAttachmentEntity ) );
        }

        return list1;
    }
}
