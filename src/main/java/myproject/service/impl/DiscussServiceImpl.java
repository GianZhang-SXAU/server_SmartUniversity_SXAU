package myproject.service.impl;


import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.AllArgsConstructor;
import myproject.common.impl.BaseServiceImpl;
import myproject.common.page.PageResult;
import myproject.common.utils.GloabUtils;
import myproject.common.utils.TokenEntity;
import myproject.convert.DiscussConvert;
import myproject.dao.DiscussDao;
import myproject.entity.DiscussEntity;
import myproject.query.DiscussQuery;
import myproject.service.DiscussService;
import myproject.vo.DiscussVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 评论表
 */
@Service
@AllArgsConstructor
public class DiscussServiceImpl extends BaseServiceImpl<DiscussDao, DiscussEntity> implements DiscussService {


	@Override
	public PageResult<DiscussVO> page(DiscussQuery query) {
		IPage<DiscussEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));
		return new PageResult<>(DiscussConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
	}

	private LambdaQueryWrapper<DiscussEntity> getWrapper(DiscussQuery query) {
		LambdaQueryWrapper<DiscussEntity> wrapper = Wrappers.lambdaQuery();
		wrapper.eq(null != query.getId(), DiscussEntity::getId, query.getId());
		wrapper.eq(null != query.getRefid(), DiscussEntity::getRefid, query.getRefid());
		wrapper.eq(null != query.getUserid(), DiscussEntity::getUserid, query.getUserid());
		wrapper.eq(StringUtils.isNotEmpty(query.getAvatarurl()), DiscussEntity::getAvatarurl, query.getAvatarurl());
		wrapper.eq(StringUtils.isNotEmpty(query.getNickname()), DiscussEntity::getNickname, query.getNickname());
		wrapper.like(StringUtils.isNotEmpty(query.getContent()), DiscussEntity::getContent, query.getContent());
		wrapper.eq(null != query.getParentId(), DiscussEntity::getParentId, query.getParentId());
		wrapper.eq(null != query.getLikesCount(), DiscussEntity::getLikesCount, query.getLikesCount());
		wrapper.eq(null != query.getCreateTime(), DiscussEntity::getCreateTime, query.getCreateTime());
		return wrapper;
	}

	@Override
	public void save(DiscussVO vo) {
		DiscussEntity entity = DiscussConvert.INSTANCE.convert(vo);
		TokenEntity userInfo = GloabUtils.getUserInfo();
		entity.setUserid(userInfo.getUserid());
		entity.setAvatarurl(userInfo.getAvatarurl());
		entity.setNickname(userInfo.getName());
		entity.setCreateTime(DateUtil.date());
		entity.setLikesCount(0);
		baseMapper.insert(entity);
	}

	@Override
	public void update(DiscussVO vo) {
		DiscussEntity entity = DiscussConvert.INSTANCE.convert(vo);
		updateById(entity);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void delete(List<Long> idList) {
		for (Long id : idList) {
			deleteChildren(id);
		}
		removeByIds(idList);
	}

	@Transactional
	public boolean deleteChildren(Long id) {
		//根据父id查询子id列表
		LambdaQueryWrapper<DiscussEntity> lambdaQueryWrapper = new LambdaQueryWrapper<>();
		lambdaQueryWrapper.eq(DiscussEntity::getParentId, id);
		List<DiscussEntity> list = list(lambdaQueryWrapper);
		for (DiscussEntity comment : list) {
			this.removeById(id);
			deleteChildren(comment.getId());
		}
		return true;
	}

	@Override
	public List<DiscussVO> queryList(DiscussQuery query) {
		LambdaQueryWrapper<DiscussEntity> wrapper = Wrappers.lambdaQuery();
		wrapper.eq(null != query.getRefid(), DiscussEntity::getRefid, query.getRefid());
		wrapper.isNull(DiscussEntity::getParentId);
		//所有父评论
		List<DiscussEntity> discussEntities = baseMapper.selectList(wrapper);
		List<DiscussVO> discussVOS = DiscussConvert.INSTANCE.convertList(discussEntities);
		for (DiscussVO discussVO : discussVOS) {
			setChildren(discussVO);
		}
		return discussVOS;
	}

	@Override
	public void like(Long id) {
		baseMapper.like(id);
	}

	private void setChildren(DiscussVO discussVO) {
		LambdaQueryWrapper<DiscussEntity> rootCommentsWrapper = new LambdaQueryWrapper<>();
		rootCommentsWrapper.eq(DiscussEntity::getParentId, discussVO.getId());
		List<DiscussEntity> children = baseMapper.selectList(rootCommentsWrapper);
		List<DiscussVO> childrens = DiscussConvert.INSTANCE.convertList(children);
		//遍历子结点
		if (!children.isEmpty()) {
			discussVO.setChildren(childrens);
			for (DiscussVO child : childrens) {
				setChildren(child);
			}
		}
	}

}