package com.lnbei.web.controller.sp.shop.order;

import org.apache.shiro.authz.annotation.RequiresPermissions;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lnbei.common.core.controller.BaseController;
/**
 * 商家发票管理
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/spShop/ShopInvoice")
public class ShopInvoiceController extends BaseController {

	/**
	 * 
	 * @return
	 */
	@RequiresPermissions("spShop:ShopInvoice:view")
	@GetMapping("/index")
	public String index() {
		return "";
	}
	
	
}
