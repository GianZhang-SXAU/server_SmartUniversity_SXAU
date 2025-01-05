package myproject.convert;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import myproject.entity.RouteplanningEntity;
import myproject.vo.RouteplanningVO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-30T12:44:20+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_401 (Oracle Corporation)"
)
public class RouteplanningConvertImpl implements RouteplanningConvert {

    @Override
    public RouteplanningEntity convert(RouteplanningVO vo) {
        if ( vo == null ) {
            return null;
        }

        RouteplanningEntity routeplanningEntity = new RouteplanningEntity();

        routeplanningEntity.setId( vo.getId() );
        routeplanningEntity.setName( vo.getName() );
        routeplanningEntity.setRoutenumbers( vo.getRoutenumbers() );
        routeplanningEntity.setInitiatingstation( vo.getInitiatingstation() );
        routeplanningEntity.setTerminal( vo.getTerminal() );
        routeplanningEntity.setTotallength( vo.getTotallength() );
        routeplanningEntity.setDetail( vo.getDetail() );
        routeplanningEntity.setDetails( vo.getDetails() );
        routeplanningEntity.setPhoto( vo.getPhoto() );
        routeplanningEntity.setPhotos( vo.getPhotos() );
        routeplanningEntity.setAddtime( vo.getAddtime() );

        return routeplanningEntity;
    }

    @Override
    public RouteplanningVO convert(RouteplanningEntity entity) {
        if ( entity == null ) {
            return null;
        }

        RouteplanningVO routeplanningVO = new RouteplanningVO();

        routeplanningVO.setId( entity.getId() );
        routeplanningVO.setName( entity.getName() );
        routeplanningVO.setRoutenumbers( entity.getRoutenumbers() );
        routeplanningVO.setInitiatingstation( entity.getInitiatingstation() );
        routeplanningVO.setTerminal( entity.getTerminal() );
        routeplanningVO.setTotallength( entity.getTotallength() );
        routeplanningVO.setDetail( entity.getDetail() );
        routeplanningVO.setDetails( entity.getDetails() );
        routeplanningVO.setPhoto( entity.getPhoto() );
        routeplanningVO.setPhotos( entity.getPhotos() );
        routeplanningVO.setAddtime( entity.getAddtime() );

        return routeplanningVO;
    }

    @Override
    public List<RouteplanningVO> convertList(List<RouteplanningEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<RouteplanningVO> list1 = new ArrayList<RouteplanningVO>( list.size() );
        for ( RouteplanningEntity routeplanningEntity : list ) {
            list1.add( convert( routeplanningEntity ) );
        }

        return list1;
    }

    @Override
    public List<RouteplanningEntity> convertEntityList(List<RouteplanningVO> list) {
        if ( list == null ) {
            return null;
        }

        List<RouteplanningEntity> list1 = new ArrayList<RouteplanningEntity>( list.size() );
        for ( RouteplanningVO routeplanningVO : list ) {
            list1.add( convert( routeplanningVO ) );
        }

        return list1;
    }
}
