package com.lnbei.web.controller.sp.shop.finance;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lnbei.common.core.controller.BaseController;

/**
 * 订单结算
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/spShop/ShopFinance")
public class ShopFinanceController extends BaseController {
	private String prefix = "spshop/finance";
	
	@GetMapping("/index")
	public String index() {
		
		return prefix + "/index";
	}
}
