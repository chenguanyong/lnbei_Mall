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
 * 商家店铺管理
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/spShop/ShopMember")
public class ShopMemberController extends BaseController {

	private String prefix = "spshop/member";
	
	@Autowired
	private IMemberUserService memberUserService;
	
	/**
	 * 会员列表
	 * @param mmap
	 * @return
	 */
	@RequiresPermissions("spadmin:ShopMember:list")
	@PostMapping("/index")
	public String index(ModelMap mmap) {

		return prefix + "/index";
	}

	
	@RequiresPermissions("spadmin:ShopMember:list")
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
	@RequiresPermissions("spadmin:ShopMember:add")
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	/**
	 * 编辑用户
	 */
	@RequiresPermissions("spadmin:ShopMember:edit")
	@PostMapping("/edit")
	public AjaxResult editSave()
	{
	    return toAjax(0);
	}	
	/**
	 * 编辑用户
	 */
	@RequiresPermissions("spadmin:ShopMember:edit")
	@GetMapping("/edit")
	public String edit()
	{
	    return prefix + "/edit";
	}
	/**
	 * 添加用户
	 */
	@RequiresPermissions("spadmin:ShopMember:add")
	@PostMapping("/add")
	public AjaxResult addSave()
	{
	    return toAjax(0);
	}
	/**
	 * 
	 * @return
	 */
	@RequiresPermissions("spadmin:ShopMember:removeAll")
	@PostMapping("/removeAll")
	public AjaxResult removeAll() {
		
		return toAjax(0);
	}
}
