package myproject.convert;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import myproject.entity.DiscussEntity;
import myproject.vo.DiscussVO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-30T12:44:20+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_401 (Oracle Corporation)"
)
public class DiscussConvertImpl implements DiscussConvert {

    @Override
    public DiscussEntity convert(DiscussVO vo) {
        if ( vo == null ) {
            return null;
        }

        DiscussEntity discussEntity = new DiscussEntity();

        discussEntity.setId( vo.getId() );
        discussEntity.setRefid( vo.getRefid() );
        discussEntity.setUserid( vo.getUserid() );
        discussEntity.setAvatarurl( vo.getAvatarurl() );
        discussEntity.setNickname( vo.getNickname() );
        discussEntity.setContent( vo.getContent() );
        discussEntity.setParentId( vo.getParentId() );
        discussEntity.setLikesCount( vo.getLikesCount() );
        discussEntity.setCreateTime( vo.getCreateTime() );

        return discussEntity;
    }

    @Override
    public DiscussVO convert(DiscussEntity entity) {
        if ( entity == null ) {
            return null;
        }

        DiscussVO discussVO = new DiscussVO();

        discussVO.setId( entity.getId() );
        discussVO.setRefid( entity.getRefid() );
        discussVO.setUserid( entity.getUserid() );
        discussVO.setAvatarurl( entity.getAvatarurl() );
        discussVO.setNickname( entity.getNickname() );
        discussVO.setContent( entity.getContent() );
        discussVO.setParentId( entity.getParentId() );
        discussVO.setLikesCount( entity.getLikesCount() );
        discussVO.setCreateTime( entity.getCreateTime() );

        return discussVO;
    }

    @Override
    public List<DiscussVO> convertList(List<DiscussEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<DiscussVO> list1 = new ArrayList<DiscussVO>( list.size() );
        for ( DiscussEntity discussEntity : list ) {
            list1.add( convert( discussEntity ) );
        }

        return list1;
    }
}
