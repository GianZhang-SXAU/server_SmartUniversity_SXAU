package myproject.convert;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import myproject.entity.MessageEntity;
import myproject.vo.MessageVO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-30T12:44:19+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_401 (Oracle Corporation)"
)
public class MessageConvertImpl implements MessageConvert {

    @Override
    public MessageEntity convert(MessageVO vo) {
        if ( vo == null ) {
            return null;
        }

        MessageEntity messageEntity = new MessageEntity();

        messageEntity.setId( vo.getId() );
        messageEntity.setFromId( vo.getFromId() );
        messageEntity.setToId( vo.getToId() );
        messageEntity.setType( vo.getType() );
        messageEntity.setContentType( vo.getContentType() );
        messageEntity.setContentId( vo.getContentId() );
        messageEntity.setCreateTime( vo.getCreateTime() );
        messageEntity.setUpdateTime( vo.getUpdateTime() );

        return messageEntity;
    }

    @Override
    public MessageVO convert(MessageEntity entity) {
        if ( entity == null ) {
            return null;
        }

        MessageVO messageVO = new MessageVO();

        messageVO.setId( entity.getId() );
        messageVO.setFromId( entity.getFromId() );
        messageVO.setToId( entity.getToId() );
        messageVO.setType( entity.getType() );
        messageVO.setContentType( entity.getContentType() );
        messageVO.setContentId( entity.getContentId() );
        messageVO.setCreateTime( entity.getCreateTime() );
        messageVO.setUpdateTime( entity.getUpdateTime() );

        return messageVO;
    }

    @Override
    public List<MessageVO> convertList(List<MessageEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<MessageVO> list1 = new ArrayList<MessageVO>( list.size() );
        for ( MessageEntity messageEntity : list ) {
            list1.add( convert( messageEntity ) );
        }

        return list1;
    }
}
