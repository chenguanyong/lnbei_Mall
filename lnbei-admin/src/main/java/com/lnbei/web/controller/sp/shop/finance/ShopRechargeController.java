package com.lnbei.web.controller.sp.shop.finance;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lnbei.common.core.controller.BaseController;

/**
 * 充值管理
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/spShop/ShopRecharge")
public class ShopRechargeController extends BaseController {
	private String prefix = "spshop/recharge";
	
	@GetMapping("/index")
	public String index() {
		
		return prefix + "/index";
	}
}
