package myproject.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import myproject.common.impl.BaseServiceImpl;
import myproject.common.page.PageResult;
import myproject.convert.SystemintroConvert;
import myproject.dao.SystemintroDao;
import myproject.entity.SystemintroEntity;
import myproject.query.SystemintroQuery;
import myproject.service.SystemintroService;
import myproject.vo.SystemintroVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 关于我们
 *

 */
@Service
@AllArgsConstructor
public class SystemintroServiceImpl extends BaseServiceImpl
		<SystemintroDao, SystemintroEntity> implements SystemintroService {

	@Override
	public PageResult<SystemintroVO> page(SystemintroQuery query) {
		IPage<SystemintroEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));

		return new PageResult<>(SystemintroConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
	}

	private LambdaQueryWrapper<SystemintroEntity> getWrapper(SystemintroQuery query) {
		LambdaQueryWrapper<SystemintroEntity> wrapper = Wrappers.lambdaQuery();
		return wrapper;
	}

	@Override
	public void save(SystemintroVO vo) {
		SystemintroEntity entity = SystemintroConvert.INSTANCE.convert(vo);

		baseMapper.insert(entity);
	}

	@Override
	public void update(SystemintroVO vo) {
		SystemintroEntity entity = SystemintroConvert.INSTANCE.convert(vo);

		updateById(entity);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void delete(List
			                   <Long> idList) {
		removeByIds(idList);
	}

}