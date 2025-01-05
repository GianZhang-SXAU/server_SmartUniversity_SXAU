package myproject.convert;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import myproject.entity.SensoresEntity;
import myproject.vo.SensoresVO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-30T12:44:20+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_401 (Oracle Corporation)"
)
public class SensoresConvertImpl implements SensoresConvert {

    @Override
    public SensoresEntity convert(SensoresVO vo) {
        if ( vo == null ) {
            return null;
        }

        SensoresEntity sensoresEntity = new SensoresEntity();

        sensoresEntity.setId( vo.getId() );
        sensoresEntity.setName( vo.getName() );
        sensoresEntity.setType( vo.getType() );
        sensoresEntity.setSensorbrand( vo.getSensorbrand() );
        sensoresEntity.setInstallationposition( vo.getInstallationposition() );
        sensoresEntity.setInstallationtime( vo.getInstallationtime() );
        sensoresEntity.setSensorstate( vo.getSensorstate() );
        sensoresEntity.setVehicleid( vo.getVehicleid() );
        sensoresEntity.setVehiclename( vo.getVehiclename() );
        sensoresEntity.setPhoto( vo.getPhoto() );
        sensoresEntity.setDetails( vo.getDetails() );
        sensoresEntity.setAddtime( vo.getAddtime() );

        return sensoresEntity;
    }

    @Override
    public SensoresVO convert(SensoresEntity entity) {
        if ( entity == null ) {
            return null;
        }

        SensoresVO sensoresVO = new SensoresVO();

        sensoresVO.setId( entity.getId() );
        sensoresVO.setName( entity.getName() );
        sensoresVO.setType( entity.getType() );
        sensoresVO.setSensorbrand( entity.getSensorbrand() );
        sensoresVO.setInstallationposition( entity.getInstallationposition() );
        sensoresVO.setInstallationtime( entity.getInstallationtime() );
        sensoresVO.setSensorstate( entity.getSensorstate() );
        sensoresVO.setVehicleid( entity.getVehicleid() );
        sensoresVO.setVehiclename( entity.getVehiclename() );
        sensoresVO.setPhoto( entity.getPhoto() );
        sensoresVO.setDetails( entity.getDetails() );
        sensoresVO.setAddtime( entity.getAddtime() );

        return sensoresVO;
    }

    @Override
    public List<SensoresVO> convertList(List<SensoresEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<SensoresVO> list1 = new ArrayList<SensoresVO>( list.size() );
        for ( SensoresEntity sensoresEntity : list ) {
            list1.add( convert( sensoresEntity ) );
        }

        return list1;
    }

    @Override
    public List<SensoresEntity> convertEntityList(List<SensoresVO> list) {
        if ( list == null ) {
            return null;
        }

        List<SensoresEntity> list1 = new ArrayList<SensoresEntity>( list.size() );
        for ( SensoresVO sensoresVO : list ) {
            list1.add( convert( sensoresVO ) );
        }

        return list1;
    }
}
