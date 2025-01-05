package myproject.convert;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import myproject.entity.VehicleclassificationEntity;
import myproject.vo.VehicleclassificationVO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-30T12:44:20+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_401 (Oracle Corporation)"
)
public class VehicleclassificationConvertImpl implements VehicleclassificationConvert {

    @Override
    public VehicleclassificationEntity convert(VehicleclassificationVO vo) {
        if ( vo == null ) {
            return null;
        }

        VehicleclassificationEntity vehicleclassificationEntity = new VehicleclassificationEntity();

        vehicleclassificationEntity.setId( vo.getId() );
        vehicleclassificationEntity.setName( vo.getName() );
        vehicleclassificationEntity.setAddtime( vo.getAddtime() );

        return vehicleclassificationEntity;
    }

    @Override
    public VehicleclassificationVO convert(VehicleclassificationEntity entity) {
        if ( entity == null ) {
            return null;
        }

        VehicleclassificationVO vehicleclassificationVO = new VehicleclassificationVO();

        vehicleclassificationVO.setId( entity.getId() );
        vehicleclassificationVO.setName( entity.getName() );
        vehicleclassificationVO.setAddtime( entity.getAddtime() );

        return vehicleclassificationVO;
    }

    @Override
    public List<VehicleclassificationVO> convertList(List<VehicleclassificationEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<VehicleclassificationVO> list1 = new ArrayList<VehicleclassificationVO>( list.size() );
        for ( VehicleclassificationEntity vehicleclassificationEntity : list ) {
            list1.add( convert( vehicleclassificationEntity ) );
        }

        return list1;
    }

    @Override
    public List<VehicleclassificationEntity> convertEntityList(List<VehicleclassificationVO> list) {
        if ( list == null ) {
            return null;
        }

        List<VehicleclassificationEntity> list1 = new ArrayList<VehicleclassificationEntity>( list.size() );
        for ( VehicleclassificationVO vehicleclassificationVO : list ) {
            list1.add( convert( vehicleclassificationVO ) );
        }

        return list1;
    }
}
