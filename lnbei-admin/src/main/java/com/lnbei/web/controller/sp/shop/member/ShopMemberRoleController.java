package com.lnbei.web.controller.sp.shop.member;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.core.page.TableDataInfo;
import com.lnbei.member.domain.MemberUser;
import com.lnbei.member.service.IMemberUserService;



/**
 * 商家角色管理
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/spShop/ShopMemberRole")
public class ShopMemberRoleController extends BaseController {

	private String prefix = "spshop/memberrole";
	
	@Autowired
	private IMemberUserService memberUserService;
	
	/**
	 * 会员列表
	 * @param mmap
	 * @return
	 */
	@RequiresPermissions("spShop:ShopMemberRole:list")
	@PostMapping("/index")
	public String index(ModelMap mmap) {

		return prefix + "/index";
	}

	
	@RequiresPermissions("spadmin:ShopMemberRole:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(MemberUser memberUser)
	{
		startPage();
        List<MemberUser> list = memberUserService.selectMemberUserList(memberUser);
		return getDataTable(list);
	}
	
	/**
	 * 新增用户
	 */
	@RequiresPermissions("spadmin:ShopMemberRole:add")
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	/**
	 * 编辑用户
	 */
	@RequiresPermissions("spadmin:ShopMemberRole:edit")
	@PostMapping("/edit")
	public AjaxResult editSave()
	{
	    return toAjax(0);
	}	
	/**
	 * 编辑用户
	 */
	@RequiresPermissions("spadmin:ShopMemberRole:edit")
	@GetMapping("/edit")
	public String edit()
	{
	    return prefix + "/edit";
	}
	/**
	 * 添加用户
	 */
	@RequiresPermissions("spadmin:ShopMemberRole:add")
	@PostMapping("/add")
	public AjaxResult addSave()
	{
	    return toAjax(0);
	}
	/**
	 * 
	 * @return
	 */
	@RequiresPermissions("spadmin:ShopMemberRole:removeAll")
	@PostMapping("/removeAll")
	public AjaxResult removeAll() {
		
		return toAjax(0);
	}
}
