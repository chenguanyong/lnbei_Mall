package com.lnbei.web.controller.home;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.lnbei.common.annotation.Log;
import com.lnbei.common.enums.BusinessType;

import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.page.TableDataInfo;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.utils.StringUtils;
import com.lnbei.common.utils.poi.ExcelUtil;
import com.lnbei.framework.util.ShiroUtils;
import com.lnbei.framework.web.exception.CommonExecption;
import com.lnbei.home.domain.HomeArticle;
import com.lnbei.home.domain.HomeComment;
import com.lnbei.home.service.IHomeCommentService;
import com.lnbei.system.domain.SysUser;

/**
 * 评论 信息操作处理
 * 
 * @author lnbei
 * @date 2020-02-01
 */
@Controller
@RequestMapping("/home/homeComment")
public class HomeCommentController extends BaseController
{
    private String prefix = "home/homeComment";
	
	@Autowired
	private IHomeCommentService homeCommentService;
	
	@RequiresPermissions("home:homeComment:view")
	@GetMapping()
	public String homeComment()
	{
	    return prefix + "/homeComment";
	}
	
	/**
	 * 查询评论列表
	 */
	@RequiresPermissions("home:homeComment:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(HomeComment homeComment)
	{
		startPage();
        List<HomeComment> list = homeCommentService.selectHomeCommentList(homeComment);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出评论列表
	 */
	@RequiresPermissions("home:homeComment:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HomeComment homeComment)
    {
    	List<HomeComment> list = homeCommentService.selectHomeCommentList(homeComment);
        ExcelUtil<HomeComment> util = new ExcelUtil<HomeComment>(HomeComment.class);
        return util.exportExcel(list, "homeComment");
    }
	
	/**
	 * 新增评论
	 */
	@GetMapping("/add/{mid}")
	public String add(@PathVariable("mid") String mid, ModelMap map)
	{
		HomeComment mComment = homeCommentService.selectHomeCommentById(mid);
		map.put("mComment", mComment);
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存评论
	 */
	@RequiresPermissions("home:homeComment:add")
	@Log(title = "评论", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(HomeComment homeComment, String commentId)
	{		
		HomeComment mComment = homeCommentService.selectHomeCommentById(commentId);
		if(mComment == null) {
			throw new CommonExecption("不存在！！！");
		}
		homeComment.setParentId(commentId);
		return toAjax(homeCommentService.insertHomeComment(homeComment,ShiroUtils.getUser()));
	}

	/**
	 * 修改评论
	 */
	@GetMapping("/edit/{mid}")
	public String edit(@PathVariable("mid") String mid, ModelMap mmap)
	{
		HomeComment homeComment = homeCommentService.selectHomeCommentById(mid);
		mmap.put("homeComment", homeComment);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存评论
	 */
	@RequiresPermissions("home:homeComment:edit")
	@Log(title = "评论", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(HomeComment homeComment)
	{		
		return toAjax(homeCommentService.updateHomeComment(homeComment,ShiroUtils.getUser()));
	}
	
	/**
	 * 删除评论
	 */
	@RequiresPermissions("home:homeComment:remove")
	@Log(title = "评论", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(homeCommentService.deleteHomeCommentByIds(ids));
	}
	/**
	 * 分类状态修改
	 */
	@Log(title = "文章管理", businessType = BusinessType.UPDATE)
	@RequiresPermissions("home:homeComment:report")
	@PostMapping("/report")
	@ResponseBody
	public AjaxResult report(HomeComment homeComment) {
		return toAjax(homeCommentService.updateHomeComment(homeComment, ShiroUtils.getUser()));
	}

	/**
	 * 审核状态
	 */
	@Log(title = "文章管理", businessType = BusinessType.UPDATE)
	@RequiresPermissions("home:homeComment:audit")
	@PostMapping("/audit")
	@ResponseBody
	public AjaxResult audit(HomeComment homeComment, String auditFlag) {
		HomeComment mComment = homeCommentService.selectHomeCommentById(homeComment.getMid());
		if (mComment.getFlag().equals("2")) {

			return AjaxResult.error("已经审核通过无需在次审核");
		}
		SysUser mSysUser = ShiroUtils.getSysUser();
		mComment.setAuditor(mSysUser.getLogName());
		mComment.setAuditorId(mSysUser.getId());
		if (StringUtils.isEmpty(auditFlag)) {
			return toAjax(0);
		}
		if (auditFlag.equals("1")) {
			homeComment.setFlag("2");
		} else if (auditFlag.equals("0")) {
			homeComment.setFlag("20");
		}

		return toAjax(homeCommentService.updateHomeComment(homeComment, ShiroUtils.getUser()));
	}

	/**
	 * 审核状态
	 */
	@Log(title = "文章管理", businessType = BusinessType.UPDATE)
	@RequiresPermissions("home:homeComment:view")
	@GetMapping("/lookView")
	public String lookView(HomeComment homeComment, ModelMap mmMap) {
		HomeComment mComment = homeCommentService.selectHomeCommentById(homeComment.getMid());
		mmMap.put("mComment", mComment);
		return prefix + "/lookView";
	}

	/**
	 * 审核状态
	 */
	@Log(title = "文章管理", businessType = BusinessType.UPDATE)
	@RequiresPermissions("home:homeComment:audit")
	@GetMapping("/auditView")
	public String auditView(HomeComment homeComment, ModelMap mmMap) {
		HomeComment mHomeComment = homeCommentService.selectHomeCommentById(homeComment.getMid());
		mmMap.put("mHomeComment", mHomeComment);
		return prefix + "/auditView";
	}
}
