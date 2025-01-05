package myproject.convert;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import myproject.entity.TestprojectEntity;
import myproject.vo.TestprojectVO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-30T12:44:19+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_401 (Oracle Corporation)"
)
public class TestprojectConvertImpl implements TestprojectConvert {

    @Override
    public TestprojectEntity convert(TestprojectVO vo) {
        if ( vo == null ) {
            return null;
        }

        TestprojectEntity testprojectEntity = new TestprojectEntity();

        testprojectEntity.setId( vo.getId() );
        testprojectEntity.setName( vo.getName() );
        testprojectEntity.setPhoto( vo.getPhoto() );
        testprojectEntity.setPhotos( vo.getPhotos() );
        testprojectEntity.setClassify( vo.getClassify() );
        testprojectEntity.setDetail( vo.getDetail() );
        testprojectEntity.setDetails( vo.getDetails() );
        testprojectEntity.setAdduserid( vo.getAdduserid() );
        testprojectEntity.setAddusername( vo.getAddusername() );
        testprojectEntity.setAddtime( vo.getAddtime() );

        return testprojectEntity;
    }

    @Override
    public TestprojectVO convert(TestprojectEntity entity) {
        if ( entity == null ) {
            return null;
        }

        TestprojectVO testprojectVO = new TestprojectVO();

        testprojectVO.setId( entity.getId() );
        testprojectVO.setName( entity.getName() );
        testprojectVO.setPhoto( entity.getPhoto() );
        testprojectVO.setPhotos( entity.getPhotos() );
        testprojectVO.setClassify( entity.getClassify() );
        testprojectVO.setDetail( entity.getDetail() );
        testprojectVO.setDetails( entity.getDetails() );
        testprojectVO.setAdduserid( entity.getAdduserid() );
        testprojectVO.setAddusername( entity.getAddusername() );
        testprojectVO.setAddtime( entity.getAddtime() );

        return testprojectVO;
    }

    @Override
    public List<TestprojectVO> convertList(List<TestprojectEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<TestprojectVO> list1 = new ArrayList<TestprojectVO>( list.size() );
        for ( TestprojectEntity testprojectEntity : list ) {
            list1.add( convert( testprojectEntity ) );
        }

        return list1;
    }

    @Override
    public List<TestprojectEntity> convertEntityList(List<TestprojectVO> list) {
        if ( list == null ) {
            return null;
        }

        List<TestprojectEntity> list1 = new ArrayList<TestprojectEntity>( list.size() );
        for ( TestprojectVO testprojectVO : list ) {
            list1.add( convert( testprojectVO ) );
        }

        return list1;
    }
}
