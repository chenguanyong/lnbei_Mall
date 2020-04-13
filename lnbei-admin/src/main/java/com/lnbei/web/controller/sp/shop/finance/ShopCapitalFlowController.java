package com.lnbei.web.controller.sp.shop.finance;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lnbei.common.core.controller.BaseController;

/**
 * 现金流管理
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/spShop/ShopCapitalFlow")
public class ShopCapitalFlowController extends BaseController {
	private String prefix = "spshop/capitalflow";
	
	@GetMapping("/index")
	public String index() {
		
		return prefix + "/index";
	}
}
