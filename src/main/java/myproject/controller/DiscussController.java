package myproject.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import myproject.common.page.PageResult;
import myproject.common.request.RequestSingleParam;
import myproject.common.sysLog.SysLog;
import myproject.common.utils.Result;
import myproject.convert.DiscussConvert;
import myproject.entity.DiscussEntity;
import myproject.query.DiscussQuery;
import myproject.service.DiscussService;
import myproject.vo.DiscussVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * 评论表
 */
@RestController
@RequestMapping("discuss")
@Tag(name = "评论表")
@AllArgsConstructor
public class DiscussController {
	private final DiscussService discussService;

	@PostMapping("page")
	@Operation(summary = "分页")
	@SysLog(title = "查看评论分页")
	public Result<PageResult<DiscussVO>> page(@RequestBody @Valid DiscussQuery query) {
		PageResult<DiscussVO> page = discussService.page(query);
		return Result.ok(page);
	}

	@PostMapping("list")
	@Operation(summary = "查询评论列表")
	@SysLog(title = "查询评论列表")
	public Result<List<DiscussVO>> list(@RequestBody @Valid DiscussQuery query) {
		List<DiscussVO> list = discussService.queryList(query);
		return Result.ok(list);
	}

	@PostMapping("like")
	@Operation(summary = "点赞")
	@SysLog(title = "点赞评论")
	public Result<Boolean> like(@RequestSingleParam("id") Long id) {
		discussService.like(id);
		return Result.ok(true);
	}

	@PostMapping("/info")
	@Operation(summary = "信息")
	@SysLog(title = "查看评论信息")
	public Result<DiscussVO> get(@RequestSingleParam("id") Long id) {
		DiscussEntity entity = discussService.getById(id);
		return Result.ok(DiscussConvert.INSTANCE.convert(entity));
	}

	@PostMapping("save")
	@Operation(summary = "保存")
	@SysLog(title = "评论")
	public Result<String> save(@RequestBody DiscussVO vo) {
		discussService.save(vo);
		return Result.ok();
	}

	@PostMapping("update")
	@Operation(summary = "修改")
	@SysLog(title = "修改评论")
	public Result<String> update(@RequestBody @Valid DiscussVO vo) {
		discussService.update(vo);
		return Result.ok();
	}

	@PostMapping("delete")
	@Operation(summary = "删除")
	@SysLog(title = "删除评论")
	public Result<String> delete(@RequestBody List<Long> idList) {
		discussService.delete(idList);
		return Result.ok();
	}
}