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
 * 商家资料
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/spShop/ShopMemberInfo")
public class ShopMemberInfoController extends BaseController {

	private String prefix = "spshop/memberinfo";
	
	@Autowired
	private IMemberUserService memberUserService;
	
	/**
	 * 会员列表
	 * @param mmap
	 * @return
	 */
	@RequiresPermissions("spShop:ShopMemberInfo:view")
	@PostMapping("/index")
	public String index(ModelMap mmap) {

		return prefix + "/index";
	}
	/**
	 * 商家账号管理
	 * @param mmap
	 * @return
	 */
	@RequiresPermissions("spShop:ShopMemberInfo:accountSet")
	@PostMapping("/accountSet")
	public String accountSet(ModelMap mmap) {

		return prefix + "/account";
	}

}
