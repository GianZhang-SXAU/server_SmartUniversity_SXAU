package myproject.convert;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import myproject.entity.PostsEntity;
import myproject.vo.PostsVO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-30T12:44:20+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_401 (Oracle Corporation)"
)
public class PostsConvertImpl implements PostsConvert {

    @Override
    public PostsEntity convert(PostsVO vo) {
        if ( vo == null ) {
            return null;
        }

        PostsEntity postsEntity = new PostsEntity();

        postsEntity.setId( vo.getId() );
        postsEntity.setCategoryId( vo.getCategoryId() );
        postsEntity.setPostingAddress( vo.getPostingAddress() );
        postsEntity.setPicture( vo.getPicture() );
        postsEntity.setPostTitle( vo.getPostTitle() );
        postsEntity.setPostContent( vo.getPostContent() );
        postsEntity.setIsPublished( vo.getIsPublished() );
        postsEntity.setIsApproved( vo.getIsApproved() );
        postsEntity.setUserid( vo.getUserid() );
        postsEntity.setAddtime( vo.getAddtime() );
        postsEntity.setUsername( vo.getUsername() );

        return postsEntity;
    }

    @Override
    public PostsVO convert(PostsEntity entity) {
        if ( entity == null ) {
            return null;
        }

        PostsVO postsVO = new PostsVO();

        postsVO.setId( entity.getId() );
        postsVO.setCategoryId( entity.getCategoryId() );
        postsVO.setPostingAddress( entity.getPostingAddress() );
        postsVO.setPicture( entity.getPicture() );
        postsVO.setPostTitle( entity.getPostTitle() );
        postsVO.setPostContent( entity.getPostContent() );
        postsVO.setIsPublished( entity.getIsPublished() );
        postsVO.setIsApproved( entity.getIsApproved() );
        postsVO.setUserid( entity.getUserid() );
        postsVO.setAddtime( entity.getAddtime() );
        postsVO.setUsername( entity.getUsername() );

        return postsVO;
    }

    @Override
    public List<PostsVO> convertList(List<PostsEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<PostsVO> list1 = new ArrayList<PostsVO>( list.size() );
        for ( PostsEntity postsEntity : list ) {
            list1.add( convert( postsEntity ) );
        }

        return list1;
    }
}
