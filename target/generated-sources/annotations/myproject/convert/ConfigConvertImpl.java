package myproject.convert;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import myproject.entity.ConfigEntity;
import myproject.vo.ConfigVO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-30T12:44:20+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_401 (Oracle Corporation)"
)
public class ConfigConvertImpl implements ConfigConvert {

    @Override
    public ConfigEntity convert(ConfigVO vo) {
        if ( vo == null ) {
            return null;
        }

        ConfigEntity configEntity = new ConfigEntity();

        configEntity.setId( vo.getId() );
        configEntity.setName( vo.getName() );
        configEntity.setValue( vo.getValue() );
        configEntity.setAddtime( vo.getAddtime() );

        return configEntity;
    }

    @Override
    public ConfigVO convert(ConfigEntity entity) {
        if ( entity == null ) {
            return null;
        }

        ConfigVO configVO = new ConfigVO();

        configVO.setId( entity.getId() );
        configVO.setName( entity.getName() );
        configVO.setValue( entity.getValue() );
        configVO.setAddtime( entity.getAddtime() );

        return configVO;
    }

    @Override
    public List<ConfigVO> convertList(List<ConfigEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<ConfigVO> list1 = new ArrayList<ConfigVO>( list.size() );
        for ( ConfigEntity configEntity : list ) {
            list1.add( convert( configEntity ) );
        }

        return list1;
    }

    @Override
    public List<ConfigEntity> convertEntityList(List<ConfigVO> result) {
        if ( result == null ) {
            return null;
        }

        List<ConfigEntity> list = new ArrayList<ConfigEntity>( result.size() );
        for ( ConfigVO configVO : result ) {
            list.add( convert( configVO ) );
        }

        return list;
    }
}
