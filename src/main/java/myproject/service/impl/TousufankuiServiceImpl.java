package myproject.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import myproject.common.page.PageResult;
import myproject.common.impl.BaseServiceImpl;
import myproject.convert.TousufankuiConvert;
import myproject.entity.TousufankuiEntity;
import myproject.query.TousufankuiQuery;
import myproject.vo.TousufankuiVO;
import myproject.dao.TousufankuiDao;
import myproject.service.TousufankuiService;
import myproject.common.utils.DateUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import myproject.common.utils.ExcelUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Map;
/**
* 投诉反馈
*
*/
@Service
@AllArgsConstructor
public class TousufankuiServiceImpl extends BaseServiceImpl<TousufankuiDao, TousufankuiEntity> implements TousufankuiService {

    @Override
    public PageResult<TousufankuiVO> page(TousufankuiQuery query) {
        IPage<TousufankuiEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));
        return new PageResult<>(TousufankuiConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }

    @Override
    public List<TousufankuiVO> queryList(TousufankuiQuery query) {
        return TousufankuiConvert.INSTANCE.convertList(baseMapper.selectList(getWrapper(query)));
    }

    private LambdaQueryWrapper<TousufankuiEntity> getWrapper(TousufankuiQuery query){
        LambdaQueryWrapper<TousufankuiEntity> wrapper = Wrappers.lambdaQuery();
                    wrapper.eq(null!=query.getId(), TousufankuiEntity::getId, query.getId());
                    wrapper.eq(StringUtils.isNotEmpty(query.getName()), TousufankuiEntity::getName, query.getName());
                    wrapper.eq(StringUtils.isNotEmpty(query.getPhoto()), TousufankuiEntity::getPhoto, query.getPhoto());
                    wrapper.eq(StringUtils.isNotEmpty(query.getDetail()), TousufankuiEntity::getDetail, query.getDetail());
                    wrapper.eq(StringUtils.isNotEmpty(query.getDetails()), TousufankuiEntity::getDetails, query.getDetails());
                    wrapper.eq(null!=query.getUserid(), TousufankuiEntity::getUserid, query.getUserid());
                    wrapper.eq(StringUtils.isNotEmpty(query.getUsername()), TousufankuiEntity::getUsername, query.getUsername());
                    wrapper.eq(StringUtils.isNotEmpty(query.getStatus()), TousufankuiEntity::getStatus, query.getStatus());
                    wrapper.eq(StringUtils.isNotEmpty(query.getFankuijieguo()), TousufankuiEntity::getFankuijieguo, query.getFankuijieguo());
                    wrapper.between(ArrayUtils.isNotEmpty(query.getAddtime()), TousufankuiEntity::getAddtime, ArrayUtils.isNotEmpty(query.getAddtime()) ? query.getAddtime()[0] : null, ArrayUtils.isNotEmpty(query.getAddtime()) ? query.getAddtime()[1] : null);
            return wrapper;
    }

    @Override
    public void save(TousufankuiVO vo) {
        TousufankuiEntity entity = TousufankuiConvert.INSTANCE.convert(vo);
        baseMapper.insert(entity);
    }

    @Override
    public void update(TousufankuiVO vo) {
        TousufankuiEntity entity = TousufankuiConvert.INSTANCE.convert(vo);
        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);
    }

    @Override
    @SneakyThrows
    public void export(TousufankuiQuery query) {
        List<TousufankuiVO> list = TousufankuiConvert.INSTANCE.convertList(baseMapper.selectList(getWrapper(query)));
        // 写到浏览器打开
        ExcelUtils.excelExport(TousufankuiVO.class, "投诉反馈" + DateUtils.format(new Date()), null, list);
    }
    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, LambdaQueryWrapper<TousufankuiEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, LambdaQueryWrapper<TousufankuiEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, LambdaQueryWrapper<TousufankuiEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper); 
    }
}