package myproject.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import myproject.common.utils.BaseDao;
import myproject.entity.TousufankuiEntity;

import java.util.List;
import java.util.Map;

/**
 * 投诉反馈
 */
@Mapper
public interface TousufankuiDao extends BaseDao<TousufankuiEntity> {
	List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params, @Param(Constants.WRAPPER) LambdaQueryWrapper<TousufankuiEntity> wrapper);

	List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params, @Param(Constants.WRAPPER) LambdaQueryWrapper<TousufankuiEntity> wrapper);

	List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params, @Param(Constants.WRAPPER) LambdaQueryWrapper<TousufankuiEntity> wrapper);
}