package myproject.convert;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import myproject.entity.VehiclesEntity;
import myproject.vo.VehiclesVO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-30T12:44:20+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_401 (Oracle Corporation)"
)
public class VehiclesConvertImpl implements VehiclesConvert {

    @Override
    public VehiclesEntity convert(VehiclesVO vo) {
        if ( vo == null ) {
            return null;
        }

        VehiclesEntity vehiclesEntity = new VehiclesEntity();

        vehiclesEntity.setId( vo.getId() );
        vehiclesEntity.setClassify( vo.getClassify() );
        vehiclesEntity.setName( vo.getName() );
        vehiclesEntity.setColor( vo.getColor() );
        vehiclesEntity.setVin( vo.getVin() );
        vehiclesEntity.setCode( vo.getCode() );
        vehiclesEntity.setType( vo.getType() );
        vehiclesEntity.setTransmissiontype( vo.getTransmissiontype() );
        vehiclesEntity.setSize( vo.getSize() );
        vehiclesEntity.setTirespecifications( vo.getTirespecifications() );
        vehiclesEntity.setMileage( vo.getMileage() );
        vehiclesEntity.setFueltype( vo.getFueltype() );
        vehiclesEntity.setDetail( vo.getDetail() );
        vehiclesEntity.setDetails( vo.getDetails() );
        vehiclesEntity.setPhoto( vo.getPhoto() );
        vehiclesEntity.setPhotos( vo.getPhotos() );
        vehiclesEntity.setStatus( vo.getStatus() );
        vehiclesEntity.setAddtime( vo.getAddtime() );

        return vehiclesEntity;
    }

    @Override
    public VehiclesVO convert(VehiclesEntity entity) {
        if ( entity == null ) {
            return null;
        }

        VehiclesVO vehiclesVO = new VehiclesVO();

        vehiclesVO.setId( entity.getId() );
        vehiclesVO.setClassify( entity.getClassify() );
        vehiclesVO.setName( entity.getName() );
        vehiclesVO.setColor( entity.getColor() );
        vehiclesVO.setVin( entity.getVin() );
        vehiclesVO.setCode( entity.getCode() );
        vehiclesVO.setType( entity.getType() );
        vehiclesVO.setTransmissiontype( entity.getTransmissiontype() );
        vehiclesVO.setSize( entity.getSize() );
        vehiclesVO.setTirespecifications( entity.getTirespecifications() );
        vehiclesVO.setMileage( entity.getMileage() );
        vehiclesVO.setFueltype( entity.getFueltype() );
        vehiclesVO.setDetail( entity.getDetail() );
        vehiclesVO.setDetails( entity.getDetails() );
        vehiclesVO.setPhoto( entity.getPhoto() );
        vehiclesVO.setPhotos( entity.getPhotos() );
        vehiclesVO.setStatus( entity.getStatus() );
        vehiclesVO.setAddtime( entity.getAddtime() );

        return vehiclesVO;
    }

    @Override
    public List<VehiclesVO> convertList(List<VehiclesEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<VehiclesVO> list1 = new ArrayList<VehiclesVO>( list.size() );
        for ( VehiclesEntity vehiclesEntity : list ) {
            list1.add( convert( vehiclesEntity ) );
        }

        return list1;
    }

    @Override
    public List<VehiclesEntity> convertEntityList(List<VehiclesVO> list) {
        if ( list == null ) {
            return null;
        }

        List<VehiclesEntity> list1 = new ArrayList<VehiclesEntity>( list.size() );
        for ( VehiclesVO vehiclesVO : list ) {
            list1.add( convert( vehiclesVO ) );
        }

        return list1;
    }
}
