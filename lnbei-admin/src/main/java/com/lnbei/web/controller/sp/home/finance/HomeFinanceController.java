package com.lnbei.web.controller.sp.home.finance;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lnbei.common.core.controller.BaseController;

/**
 * 商家财务管理
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/spHome/HomeFinance")
public class HomeFinanceController extends BaseController {
	private String prefix = "sphome/finance";

	/**
	 * 我的积分
	 * 
	 * @param mmMap
	 * @return
	 */
	@RequiresPermissions("spHome:HomeFinance:list")
	@GetMapping()
	public String index(ModelMap mmMap) {

		return prefix + "/index";
	}
	/**
	 * 我的账户
	 * @param mmMap
	 * @return
	 */
	@RequiresPermissions("spHome:HomeFinance:account")
	@GetMapping("/account")
	public String account(ModelMap mmMap) {

		return prefix + "/account";
	}
	/**
	 * 奖金明细
	 * @param mmMap
	 * @return
	 */
	@RequiresPermissions("spHome:HomeFinance:bonusInfo")
	@GetMapping("/bonusInfo")
	public String bonusInfo(ModelMap mmMap) {

		return prefix + "/bonusInfo";
	}
}
