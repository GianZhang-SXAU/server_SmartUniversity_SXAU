package myproject.convert;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import myproject.entity.TousufankuiEntity;
import myproject.vo.TousufankuiVO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-30T12:44:20+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_401 (Oracle Corporation)"
)
public class TousufankuiConvertImpl implements TousufankuiConvert {

    @Override
    public TousufankuiEntity convert(TousufankuiVO vo) {
        if ( vo == null ) {
            return null;
        }

        TousufankuiEntity tousufankuiEntity = new TousufankuiEntity();

        tousufankuiEntity.setId( vo.getId() );
        tousufankuiEntity.setName( vo.getName() );
        tousufankuiEntity.setPhoto( vo.getPhoto() );
        tousufankuiEntity.setDetail( vo.getDetail() );
        tousufankuiEntity.setDetails( vo.getDetails() );
        tousufankuiEntity.setUserid( vo.getUserid() );
        tousufankuiEntity.setUsername( vo.getUsername() );
        tousufankuiEntity.setStatus( vo.getStatus() );
        tousufankuiEntity.setFankuijieguo( vo.getFankuijieguo() );
        tousufankuiEntity.setAddtime( vo.getAddtime() );

        return tousufankuiEntity;
    }

    @Override
    public TousufankuiVO convert(TousufankuiEntity entity) {
        if ( entity == null ) {
            return null;
        }

        TousufankuiVO tousufankuiVO = new TousufankuiVO();

        tousufankuiVO.setId( entity.getId() );
        tousufankuiVO.setName( entity.getName() );
        tousufankuiVO.setPhoto( entity.getPhoto() );
        tousufankuiVO.setDetail( entity.getDetail() );
        tousufankuiVO.setDetails( entity.getDetails() );
        tousufankuiVO.setUserid( entity.getUserid() );
        tousufankuiVO.setUsername( entity.getUsername() );
        tousufankuiVO.setStatus( entity.getStatus() );
        tousufankuiVO.setFankuijieguo( entity.getFankuijieguo() );
        tousufankuiVO.setAddtime( entity.getAddtime() );

        return tousufankuiVO;
    }

    @Override
    public List<TousufankuiVO> convertList(List<TousufankuiEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<TousufankuiVO> list1 = new ArrayList<TousufankuiVO>( list.size() );
        for ( TousufankuiEntity tousufankuiEntity : list ) {
            list1.add( convert( tousufankuiEntity ) );
        }

        return list1;
    }
}
