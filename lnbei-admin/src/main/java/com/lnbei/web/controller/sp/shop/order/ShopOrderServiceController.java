package com.lnbei.web.controller.sp.shop.order;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lnbei.common.core.controller.BaseController;
/**
 * 售后管理
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/spShop/ShopOrderService")
public class ShopOrderServiceController extends BaseController {

	/**
	 * 待付款
	 * @return
	 */
	@RequiresPermissions("spShop:ShopOrderService:index")
	@GetMapping("/index")
	public String index() {
		return "";
	}

}
