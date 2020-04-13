package com.lnbei.web.controller.member;

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
import com.lnbei.member.domain.MemberRealAurh;
import com.lnbei.member.service.IMemberRealAurhService;
import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.page.TableDataInfo;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.utils.poi.ExcelUtil;
import com.lnbei.framework.util.ShiroUtils;

/**
 * 实名认证 信息操作处理
 * 
 * @author lnbei
 * @date 2020-01-24
 */
@Controller
@RequestMapping("/member/memberRealAurh")
public class MemberRealAurhController extends BaseController
{
    private String prefix = "member/memberRealAurh";
	
	@Autowired
	private IMemberRealAurhService memberRealAurhService;
	
	@RequiresPermissions("member:memberRealAurh:view")
	@GetMapping()
	public String memberRealAurh()
	{
	    return prefix + "/memberRealAurh";
	}
	
	/**
	 * 查询实名认证列表
	 */
	@RequiresPermissions("member:memberRealAurh:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(MemberRealAurh memberRealAurh)
	{
		startPage();
        List<MemberRealAurh> list = memberRealAurhService.selectMemberRealAurhList(memberRealAurh);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出实名认证列表
	 */
	@RequiresPermissions("member:memberRealAurh:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(MemberRealAurh memberRealAurh)
    {
    	List<MemberRealAurh> list = memberRealAurhService.selectMemberRealAurhList(memberRealAurh);
        ExcelUtil<MemberRealAurh> util = new ExcelUtil<MemberRealAurh>(MemberRealAurh.class);
        return util.exportExcel(list, "memberRealAurh");
    }
	
	/**
	 * 新增实名认证
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存实名认证
	 */
	@RequiresPermissions("member:memberRealAurh:add")
	@Log(title = "实名认证", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(MemberRealAurh memberRealAurh)
	{		
		return toAjax(memberRealAurhService.insertMemberRealAurh(memberRealAurh, ShiroUtils.getUser()));
	}

	/**
	 * 修改实名认证
	 */
	@GetMapping("/edit/{mid}")
	public String edit(@PathVariable("mid") String mid, ModelMap mmap)
	{
		MemberRealAurh memberRealAurh = memberRealAurhService.selectMemberRealAurhById(mid);
		mmap.put("memberRealAurh", memberRealAurh);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存实名认证
	 */
	@RequiresPermissions("member:memberRealAurh:edit")
	@Log(title = "实名认证", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(MemberRealAurh memberRealAurh)
	{		
		return toAjax(memberRealAurhService.updateMemberRealAurh(memberRealAurh, ShiroUtils.getUser()));
	}
	
	/**
	 * 删除实名认证
	 */
	@RequiresPermissions("member:memberRealAurh:remove")
	@Log(title = "实名认证", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(memberRealAurhService.deleteMemberRealAurhByIds(ids));
	}
	
}
