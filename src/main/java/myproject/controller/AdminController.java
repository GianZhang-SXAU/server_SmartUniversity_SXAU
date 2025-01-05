package myproject.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import myproject.common.page.PageResult;
import myproject.common.request.RequestSingleParam;
import myproject.common.sysLog.SysLog;
import myproject.common.utils.PwdUtil;
import myproject.common.utils.Result;
import myproject.common.utils.TokenEntity;
import myproject.constants.Constants;
import myproject.convert.AdminConvert;
import myproject.entity.AdminEntity;
import myproject.query.AdminQuery;
import myproject.service.AdminService;
import myproject.vo.AdminVO;
import myproject.vo.SysAccountLoginVO;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

/**
 * 后台管理用户表
 */
@RestController
@RequestMapping("admin")
@Tag(name = "后台管理用户表")
@AllArgsConstructor
public class AdminController {
	private final AdminService adminService;
	private static final String StpPre = "admin";

	/**
	 * 账号密码登录
	 */
	@SaIgnore
	@PostMapping(value = "/login")
	@SysLog(title = "管理员登录", content = "系统日志")
	public Result<TokenEntity> login(@RequestBody SysAccountLoginVO sysAccountLoginVO) {
		AdminEntity user = adminService.getOne(new QueryWrapper<AdminEntity>().eq("username", sysAccountLoginVO.getUsername()));
		if (user == null || !user.getPassword().equals(PwdUtil.encrypt(sysAccountLoginVO.getPassword()))) {
			return Result.error("账号或密码不正确");
		}
		StpUtil.login(StpPre + user.getId());
		TokenEntity tokenEntity = new TokenEntity();
		tokenEntity.setUsername(user.getUsername());
		tokenEntity.setUserid(user.getId());
		tokenEntity.setRole(user.getRole());
		tokenEntity.setTablename("admin");
		tokenEntity.setAddtime(user.getAddtime());
		tokenEntity.setAvatarurl(user.getAvatarurl());
		tokenEntity.setName(user.getName());
		tokenEntity.setToken(StpUtil.getTokenValue());
		StpUtil.getSession().set(Constants.CURRENT_USER, tokenEntity);
		return Result.ok(tokenEntity);
	}

	/**
	 * 注册
	 */
	@SaIgnore
	@PostMapping(value = "/register")
	@SysLog(title = "管理员注册")
	public Result<Boolean> register(@RequestBody AdminEntity user) {
		if (adminService.getOne(new QueryWrapper<AdminEntity>().eq("username", user.getUsername())) != null) {
			return Result.error("用户已存在");
		}
		user.setPassword(PwdUtil.encrypt(user.getPassword()));
		adminService.save(user);
		return Result.ok(true);
	}

	@PostMapping("update")
	@Operation(summary = "修改")
	@SysLog(title = "管理员修改")
	public Result<String> update(@RequestBody @Valid AdminVO vo) {
		if (StrUtil.isNotBlank(vo.getPassword())) {
			vo.setPassword(PwdUtil.encrypt(vo.getPassword()));
		}
		adminService.update(vo);
		return Result.ok();
	}

	@PostMapping("page")
	@Operation(summary = "分页")
	@SysLog(title = "查看管理员分页")
	public Result<PageResult<AdminVO>> page(@RequestBody @Valid AdminQuery query) {
		PageResult<AdminVO> page = adminService.page(query);
		return Result.ok(page);
	}

	@PostMapping("list")
	@Operation(summary = "列表")
	@SysLog(title = "查看管理员列表")
	public Result<List<AdminVO>> list(@RequestBody @Valid AdminQuery query) {
		List<AdminVO> list = adminService.queryList(query);
		return Result.ok(list);
	}

	@PostMapping("/info")
	@Operation(summary = "信息")
	@SysLog(title = "查看管理员详细信息")
	public Result<AdminVO> get(@RequestSingleParam(value = "id") Long id) {
		AdminEntity entity = adminService.getById(id);
		return Result.ok(AdminConvert.INSTANCE.convert(entity));
	}

	@PostMapping("save")
	@Operation(summary = "保存")
	@SysLog(title = "保存管理员信息")
	public Result<String> save(@RequestBody AdminVO vo) {
		vo.setPassword(PwdUtil.encrypt(vo.getPassword()));
		adminService.save(vo);
		return Result.ok();
	}


	@PostMapping("delete")
	@Operation(summary = "删除")
	@SysLog(title = "删除管理员信息")
	public Result<String> delete(@RequestBody List<Long> idList) {
		adminService.delete(idList);
		return Result.ok();
	}

	@PostMapping("export")
	@Operation(summary = "导出")
	@SysLog(title = "导出管理员信息")
	public void export(@RequestBody @Valid AdminQuery query) {
		adminService.export(query);
	}

	@PostMapping("importAdmin")
	@Operation(summary = "导入")
	@SysLog(title = "导入管理员信息")
	public Result<Boolean> importAdmin(@RequestParam("file") MultipartFile file) {
		if (file.isEmpty()) {
			return Result.error("请选择需要上传的文件");
		}
		adminService.importAdmin(file, PwdUtil.encrypt(Constants.RESETPASS));
		return Result.ok();
	}
}