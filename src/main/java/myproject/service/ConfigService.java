package myproject.service;

import org.springframework.web.multipart.MultipartFile;
import myproject.common.page.PageResult;
import myproject.common.utils.BaseService;
import myproject.entity.ConfigEntity;
import myproject.query.ConfigQuery;
import myproject.vo.ConfigVO;

import java.util.List;

/**
 * 配置文件
 */
public interface ConfigService extends BaseService<ConfigEntity> {

	PageResult<ConfigVO> page(ConfigQuery query);

	List<ConfigVO> queryList(ConfigQuery query);

	void save(ConfigVO vo);

	void update(ConfigVO vo);

	void delete(List<Long> idList);

	void export(ConfigQuery query);

	void importExcel(MultipartFile file);
}