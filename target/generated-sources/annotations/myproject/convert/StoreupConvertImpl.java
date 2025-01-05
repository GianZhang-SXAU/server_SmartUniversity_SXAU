package myproject.convert;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import myproject.entity.StoreupEntity;
import myproject.vo.StoreupVO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-30T12:44:19+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_401 (Oracle Corporation)"
)
public class StoreupConvertImpl implements StoreupConvert {

    @Override
    public StoreupEntity convert(StoreupVO vo) {
        if ( vo == null ) {
            return null;
        }

        StoreupEntity storeupEntity = new StoreupEntity();

        storeupEntity.setId( vo.getId() );
        storeupEntity.setAddtime( vo.getAddtime() );
        storeupEntity.setUserid( vo.getUserid() );
        storeupEntity.setRefid( vo.getRefid() );
        storeupEntity.setTablename( vo.getTablename() );
        storeupEntity.setName( vo.getName() );
        storeupEntity.setPicture( vo.getPicture() );
        storeupEntity.setType( vo.getType() );
        storeupEntity.setInteltype( vo.getInteltype() );
        storeupEntity.setRemark( vo.getRemark() );

        return storeupEntity;
    }

    @Override
    public StoreupVO convert(StoreupEntity entity) {
        if ( entity == null ) {
            return null;
        }

        StoreupVO storeupVO = new StoreupVO();

        storeupVO.setId( entity.getId() );
        storeupVO.setAddtime( entity.getAddtime() );
        storeupVO.setUserid( entity.getUserid() );
        storeupVO.setRefid( entity.getRefid() );
        storeupVO.setTablename( entity.getTablename() );
        storeupVO.setName( entity.getName() );
        storeupVO.setPicture( entity.getPicture() );
        storeupVO.setType( entity.getType() );
        storeupVO.setInteltype( entity.getInteltype() );
        storeupVO.setRemark( entity.getRemark() );

        return storeupVO;
    }

    @Override
    public List<StoreupVO> convertList(List<StoreupEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<StoreupVO> list1 = new ArrayList<StoreupVO>( list.size() );
        for ( StoreupEntity storeupEntity : list ) {
            list1.add( convert( storeupEntity ) );
        }

        return list1;
    }

    @Override
    public List<StoreupEntity> convertEntityList(List<StoreupVO> list) {
        if ( list == null ) {
            return null;
        }

        List<StoreupEntity> list1 = new ArrayList<StoreupEntity>( list.size() );
        for ( StoreupVO storeupVO : list ) {
            list1.add( convert( storeupVO ) );
        }

        return list1;
    }
}
