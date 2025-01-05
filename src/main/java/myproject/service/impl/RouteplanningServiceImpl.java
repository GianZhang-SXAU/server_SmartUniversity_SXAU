package myproject.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import myproject.common.page.PageResult;
import myproject.common.impl.BaseServiceImpl;
import myproject.convert.RouteplanningConvert;
import myproject.entity.RouteplanningEntity;
import myproject.query.RouteplanningQuery;
import myproject.vo.RouteplanningVO;
import myproject.dao.RouteplanningDao;
import myproject.service.RouteplanningService;
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
* 线路规划
*
*/
@Service
@AllArgsConstructor
public class RouteplanningServiceImpl extends BaseServiceImpl<RouteplanningDao, RouteplanningEntity> implements RouteplanningService {

    @Override
    public PageResult<RouteplanningVO> page(RouteplanningQuery query) {
        IPage<RouteplanningEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));
        return new PageResult<>(RouteplanningConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }

    @Override
    public List<RouteplanningVO> queryList(RouteplanningQuery query) {
        return RouteplanningConvert.INSTANCE.convertList(baseMapper.selectList(getWrapper(query)));
    }

    private LambdaQueryWrapper<RouteplanningEntity> getWrapper(RouteplanningQuery query){
        LambdaQueryWrapper<RouteplanningEntity> wrapper = Wrappers.lambdaQuery();
                    wrapper.eq(null!=query.getId(), RouteplanningEntity::getId, query.getId());
                    wrapper.eq(StringUtils.isNotEmpty(query.getName()), RouteplanningEntity::getName, query.getName());
                    wrapper.eq(StringUtils.isNotEmpty(query.getRoutenumbers()), RouteplanningEntity::getRoutenumbers, query.getRoutenumbers());
                    wrapper.eq(StringUtils.isNotEmpty(query.getInitiatingstation()), RouteplanningEntity::getInitiatingstation, query.getInitiatingstation());
                    wrapper.eq(StringUtils.isNotEmpty(query.getTerminal()), RouteplanningEntity::getTerminal, query.getTerminal());
                    wrapper.eq(StringUtils.isNotEmpty(query.getTotallength()), RouteplanningEntity::getTotallength, query.getTotallength());
                    wrapper.eq(StringUtils.isNotEmpty(query.getDetail()), RouteplanningEntity::getDetail, query.getDetail());
                    wrapper.eq(StringUtils.isNotEmpty(query.getDetails()), RouteplanningEntity::getDetails, query.getDetails());
                    wrapper.eq(StringUtils.isNotEmpty(query.getPhoto()), RouteplanningEntity::getPhoto, query.getPhoto());
                    wrapper.eq(StringUtils.isNotEmpty(query.getPhotos()), RouteplanningEntity::getPhotos, query.getPhotos());
                    wrapper.between(ArrayUtils.isNotEmpty(query.getAddtime()), RouteplanningEntity::getAddtime, ArrayUtils.isNotEmpty(query.getAddtime()) ? query.getAddtime()[0] : null, ArrayUtils.isNotEmpty(query.getAddtime()) ? query.getAddtime()[1] : null);
            return wrapper;
    }

    @Override
    public void save(RouteplanningVO vo) {
        RouteplanningEntity entity = RouteplanningConvert.INSTANCE.convert(vo);
        baseMapper.insert(entity);
    }

    @Override
    public void update(RouteplanningVO vo) {
        RouteplanningEntity entity = RouteplanningConvert.INSTANCE.convert(vo);
        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);
    }

    @Override
    @SneakyThrows
    public void export(RouteplanningQuery query) {
        List<RouteplanningVO> list = RouteplanningConvert.INSTANCE.convertList(baseMapper.selectList(getWrapper(query)));
        // 写到浏览器打开
        ExcelUtils.excelExport(RouteplanningVO.class, "线路规划" + DateUtils.format(new Date()), null, list);
    }

    @Override
    @SneakyThrows
    public void importrouteplanning(File file) {
        ExcelUtils.readAnalysis(file, RouteplanningVO.class, new ExcelFinishCallBack<RouteplanningVO>() {
            @Override
            public void doAfterAllAnalysed(List<RouteplanningVO> result) {
                saveRouteplannings(result);
            }

            @Override
            public void doSaveBatch(List<RouteplanningVO> result) {
                saveRouteplannings(result);
            }

            private void saveRouteplannings(List<RouteplanningVO> result) {
                List<RouteplanningEntity> RouteplanningEntities = RouteplanningConvert.INSTANCE.convertEntityList(result);
                saveBatch(RouteplanningEntities);
            }
        });
    }

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, LambdaQueryWrapper<RouteplanningEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, LambdaQueryWrapper<RouteplanningEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, LambdaQueryWrapper<RouteplanningEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }
}