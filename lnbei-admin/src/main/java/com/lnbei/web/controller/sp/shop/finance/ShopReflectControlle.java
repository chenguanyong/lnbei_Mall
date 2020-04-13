package com.lnbei.web.controller.sp.shop.finance;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lnbei.common.core.controller.BaseController;

/**
 * 体现管理
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/spShop/ShopReflect")
public class ShopReflectControlle extends BaseController {
	private String prefix = "spshop/reflect";
	
	@GetMapping("/index")
	public String index() {
		
		return prefix + "/index";
	}
}
