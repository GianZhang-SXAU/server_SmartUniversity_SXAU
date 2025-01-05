package myproject.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import myproject.common.page.PageResult;
import myproject.common.impl.BaseServiceImpl;
import myproject.convert.TestprojectConvert;
import myproject.entity.TestprojectEntity;
import myproject.query.TestprojectQuery;
import myproject.vo.TestprojectVO;
import myproject.dao.TestprojectDao;
import myproject.service.TestprojectService;
import myproject.common.utils.DateUtils;
import myproject.common.excel.ExcelFinishCallBack;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import myproject.common.utils.ExcelUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.io.File;

/**
* 检测项目
*
*/
@Service
@AllArgsConstructor
public class TestprojectServiceImpl extends BaseServiceImpl<TestprojectDao, TestprojectEntity> implements TestprojectService {

    @Override
    public PageResult<TestprojectVO> page(TestprojectQuery query) {
        IPage<TestprojectEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));
        return new PageResult<>(TestprojectConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }

    @Override
    public List<TestprojectVO> queryList(TestprojectQuery query) {
        return TestprojectConvert.INSTANCE.convertList(baseMapper.selectList(getWrapper(query)));
    }

    private LambdaQueryWrapper<TestprojectEntity> getWrapper(TestprojectQuery query){
        LambdaQueryWrapper<TestprojectEntity> wrapper = Wrappers.lambdaQuery();
                    wrapper.eq(null!=query.getId(), TestprojectEntity::getId, query.getId());
                    wrapper.eq(StringUtils.isNotEmpty(query.getName()), TestprojectEntity::getName, query.getName());
                    wrapper.eq(StringUtils.isNotEmpty(query.getPhoto()), TestprojectEntity::getPhoto, query.getPhoto());
                    wrapper.eq(StringUtils.isNotEmpty(query.getPhotos()), TestprojectEntity::getPhotos, query.getPhotos());
                    wrapper.eq(StringUtils.isNotEmpty(query.getClassify()), TestprojectEntity::getClassify, query.getClassify());
                    wrapper.eq(StringUtils.isNotEmpty(query.getDetail()), TestprojectEntity::getDetail, query.getDetail());
                    wrapper.eq(StringUtils.isNotEmpty(query.getDetails()), TestprojectEntity::getDetails, query.getDetails());
                    wrapper.eq(null!=query.getAdduserid(), TestprojectEntity::getAdduserid, query.getAdduserid());
                    wrapper.eq(StringUtils.isNotEmpty(query.getAddusername()), TestprojectEntity::getAddusername, query.getAddusername());
                    wrapper.between(ArrayUtils.isNotEmpty(query.getAddtime()), TestprojectEntity::getAddtime, ArrayUtils.isNotEmpty(query.getAddtime()) ? query.getAddtime()[0] : null, ArrayUtils.isNotEmpty(query.getAddtime()) ? query.getAddtime()[1] : null);
            return wrapper;
    }

    @Override
    public void save(TestprojectVO vo) {
        TestprojectEntity entity = TestprojectConvert.INSTANCE.convert(vo);
        baseMapper.insert(entity);
    }

    @Override
    public void update(TestprojectVO vo) {
        TestprojectEntity entity = TestprojectConvert.INSTANCE.convert(vo);
        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);
    }

    @Override
    @SneakyThrows
    public void export(TestprojectQuery query) {
        List<TestprojectVO> list = TestprojectConvert.INSTANCE.convertList(baseMapper.selectList(getWrapper(query)));
        // 写到浏览器打开
        ExcelUtils.excelExport(TestprojectVO.class, "检测项目" + DateUtils.format(new Date()), null, list);
    }

    @Override
    @SneakyThrows
    public void importtestproject(File file) {
        ExcelUtils.readAnalysis(file, TestprojectVO.class, new ExcelFinishCallBack<TestprojectVO>() {
            @Override
            public void doAfterAllAnalysed(List<TestprojectVO> result) {
                saveTestprojects(result);
            }

            @Override
            public void doSaveBatch(List<TestprojectVO> result) {
                saveTestprojects(result);
            }

            private void saveTestprojects(List<TestprojectVO> result) {
                List<TestprojectEntity> TestprojectEntities = TestprojectConvert.INSTANCE.convertEntityList(result);
                saveBatch(TestprojectEntities);
            }
        });
    }

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, LambdaQueryWrapper<TestprojectEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, LambdaQueryWrapper<TestprojectEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, LambdaQueryWrapper<TestprojectEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }
}