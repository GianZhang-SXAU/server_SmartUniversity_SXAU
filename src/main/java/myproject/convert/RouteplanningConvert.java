package myproject.convert;

import myproject.entity.RouteplanningEntity;
import myproject.vo.RouteplanningVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
* 线路规划
*
*/
@Mapper
public interface RouteplanningConvert {
    RouteplanningConvert INSTANCE = Mappers.getMapper(RouteplanningConvert.class);

    RouteplanningEntity convert(RouteplanningVO vo);

    RouteplanningVO convert(RouteplanningEntity entity);

    List<RouteplanningVO> convertList(List<RouteplanningEntity> list);

    List<RouteplanningEntity> convertEntityList(List<RouteplanningVO> list);
}