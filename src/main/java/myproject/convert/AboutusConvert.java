package myproject.convert;

import myproject.entity.AboutusEntity;
import myproject.vo.AboutusVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
* 关于我们
*
*/
@Mapper
public interface AboutusConvert {
    AboutusConvert INSTANCE = Mappers.getMapper(AboutusConvert.class);

    AboutusEntity convert(AboutusVO vo);

    AboutusVO convert(AboutusEntity entity);

    List<AboutusVO> convertList(List<AboutusEntity> list);

}