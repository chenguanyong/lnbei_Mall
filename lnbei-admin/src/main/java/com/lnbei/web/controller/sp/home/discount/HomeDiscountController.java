package com.lnbei.web.controller.sp.home.discount;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lnbei.common.core.controller.BaseController;

/**
 * 我的优惠信息
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/spHome/HomeDiscount")
public class HomeDiscountController extends BaseController {
	private String prefix = "sphome/discount";

	/**
	 * 购物车列表
	 * 
	 * @param mmMap
	 * @return
	 */
	@RequiresPermissions("spHome:HomeDiscount:list")
	@GetMapping()
	public String index(ModelMap mmMap) {

		return prefix + "/index";
	}
}
