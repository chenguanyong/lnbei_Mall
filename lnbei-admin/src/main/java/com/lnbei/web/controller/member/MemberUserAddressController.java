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
import com.lnbei.member.domain.MemberUserAddress;
import com.lnbei.member.service.IMemberUserAddressService;
import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.page.TableDataInfo;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.utils.poi.ExcelUtil;
import com.lnbei.framework.util.ShiroUtils;

/**
 * 会员地址 信息操作处理
 * 
 * @author lnbei
 * @date 2020-01-24
 */
@Controller
@RequestMapping("/member/memberUserAddress")
public class MemberUserAddressController extends BaseController
{
    private String prefix = "member/memberUserAddress";
	
	@Autowired
	private IMemberUserAddressService memberUserAddressService;
	
	@RequiresPermissions("member:memberUserAddress:view")
	@GetMapping()
	public String memberUserAddress()
	{
	    return prefix + "/memberUserAddress";
	}
	
	/**
	 * 查询会员地址列表
	 */
	@RequiresPermissions("member:memberUserAddress:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(MemberUserAddress memberUserAddress)
	{
		startPage();
        List<MemberUserAddress> list = memberUserAddressService.selectMemberUserAddressList(memberUserAddress);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出会员地址列表
	 */
	@RequiresPermissions("member:memberUserAddress:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(MemberUserAddress memberUserAddress)
    {
    	List<MemberUserAddress> list = memberUserAddressService.selectMemberUserAddressList(memberUserAddress);
        ExcelUtil<MemberUserAddress> util = new ExcelUtil<MemberUserAddress>(MemberUserAddress.class);
        return util.exportExcel(list, "memberUserAddress");
    }
	
	/**
	 * 新增会员地址
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存会员地址
	 */
	@RequiresPermissions("member:memberUserAddress:add")
	@Log(title = "会员地址", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(MemberUserAddress memberUserAddress)
	{		
		return toAjax(memberUserAddressService.insertMemberUserAddress(memberUserAddress, ShiroUtils.getUser()));
	}

	/**
	 * 修改会员地址
	 */
	@GetMapping("/edit/{mid}")
	public String edit(@PathVariable("mid") String mid, ModelMap mmap)
	{
		MemberUserAddress memberUserAddress = memberUserAddressService.selectMemberUserAddressById(mid);
		mmap.put("memberUserAddress", memberUserAddress);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存会员地址
	 */
	@RequiresPermissions("member:memberUserAddress:edit")
	@Log(title = "会员地址", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(MemberUserAddress memberUserAddress)
	{		
		return toAjax(memberUserAddressService.updateMemberUserAddress(memberUserAddress, ShiroUtils.getUser()));
	}
	
	/**
	 * 删除会员地址
	 */
	@RequiresPermissions("member:memberUserAddress:remove")
	@Log(title = "会员地址", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(memberUserAddressService.deleteMemberUserAddressByIds(ids));
	}
	
}
