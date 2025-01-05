package myproject.service;

import org.springframework.web.multipart.MultipartFile;
import myproject.common.page.PageResult;
import myproject.common.utils.BaseService;
import myproject.entity.AdminEntity;
import myproject.query.AdminQuery;
import myproject.vo.AdminVO;

import java.util.List;

/**
 * 后台管理用户表
 */
public interface AdminService extends BaseService<AdminEntity> {

	PageResult<AdminVO> page(AdminQuery query);

	List<AdminVO> queryList(AdminQuery query);

	void save(AdminVO vo);

	void update(AdminVO vo);

	void delete(List<Long> idList);

	void export(AdminQuery query);

	AdminEntity getByUsername(String username);

	void importAdmin(MultipartFile file, String encrypt);
}