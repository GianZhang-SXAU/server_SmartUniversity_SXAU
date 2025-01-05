package myproject.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import myproject.common.page.PageResult;
import myproject.common.impl.BaseServiceImpl;
import myproject.convert.StoreupConvert;
import myproject.entity.StoreupEntity;
import myproject.query.StoreupQuery;
import myproject.vo.StoreupVO;
import myproject.dao.StoreupDao;
import myproject.service.StoreupService;
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
* 收藏表
*
*/
@Service
@AllArgsConstructor
public class StoreupServiceImpl extends BaseServiceImpl<StoreupDao, StoreupEntity> implements StoreupService {

    @Override
    public PageResult<StoreupVO> page(StoreupQuery query) {
        IPage<StoreupEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));
        return new PageResult<>(StoreupConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }

    @Override
    public List<StoreupVO> queryList(StoreupQuery query) {
        return StoreupConvert.INSTANCE.convertList(baseMapper.selectList(getWrapper(query)));
    }

    private LambdaQueryWrapper<StoreupEntity> getWrapper(StoreupQuery query){
        LambdaQueryWrapper<StoreupEntity> wrapper = Wrappers.lambdaQuery();
                    wrapper.eq(null!=query.getId(), StoreupEntity::getId, query.getId());
                    wrapper.between(ArrayUtils.isNotEmpty(query.getAddtime()), StoreupEntity::getAddtime, ArrayUtils.isNotEmpty(query.getAddtime()) ? query.getAddtime()[0] : null, ArrayUtils.isNotEmpty(query.getAddtime()) ? query.getAddtime()[1] : null);
                    wrapper.eq(null!=query.getUserid(), StoreupEntity::getUserid, query.getUserid());
                    wrapper.eq(null!=query.getRefid(), StoreupEntity::getRefid, query.getRefid());
                    wrapper.eq(StringUtils.isNotEmpty(query.getTablename()), StoreupEntity::getTablename, query.getTablename());
                    wrapper.eq(StringUtils.isNotEmpty(query.getName()), StoreupEntity::getName, query.getName());
                    wrapper.eq(StringUtils.isNotEmpty(query.getPicture()), StoreupEntity::getPicture, query.getPicture());
                    wrapper.eq(null!=query.getType(), StoreupEntity::getType, query.getType());
                    wrapper.eq(StringUtils.isNotEmpty(query.getInteltype()), StoreupEntity::getInteltype, query.getInteltype());
                    wrapper.eq(StringUtils.isNotEmpty(query.getRemark()), StoreupEntity::getRemark, query.getRemark());
            return wrapper;
    }

    @Override
    public void save(StoreupVO vo) {
        StoreupEntity entity = StoreupConvert.INSTANCE.convert(vo);
        baseMapper.insert(entity);
    }

    @Override
    public void update(StoreupVO vo) {
        StoreupEntity entity = StoreupConvert.INSTANCE.convert(vo);
        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);
    }

    @Override
    @SneakyThrows
    public void export(StoreupQuery query) {
        List<StoreupVO> list = StoreupConvert.INSTANCE.convertList(baseMapper.selectList(getWrapper(query)));
        // 写到浏览器打开
        ExcelUtils.excelExport(StoreupVO.class, "收藏表" + DateUtils.format(new Date()), null, list);
    }

    @Override
    @SneakyThrows
    public void importstoreup(File file) {
        ExcelUtils.readAnalysis(file, StoreupVO.class, new ExcelFinishCallBack<StoreupVO>() {
            @Override
            public void doAfterAllAnalysed(List<StoreupVO> result) {
                saveStoreups(result);
            }

            @Override
            public void doSaveBatch(List<StoreupVO> result) {
                saveStoreups(result);
            }

            private void saveStoreups(List<StoreupVO> result) {
                List<StoreupEntity> StoreupEntities = StoreupConvert.INSTANCE.convertEntityList(result);
                saveBatch(StoreupEntities);
            }
        });
    }

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, LambdaQueryWrapper<StoreupEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, LambdaQueryWrapper<StoreupEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, LambdaQueryWrapper<StoreupEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }
}