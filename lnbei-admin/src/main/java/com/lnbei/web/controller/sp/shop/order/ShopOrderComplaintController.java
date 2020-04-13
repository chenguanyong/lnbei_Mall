package com.lnbei.web.controller.sp.shop.order;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lnbei.common.core.controller.BaseController;
@Controller
@RequestMapping("/spShop/ShopOrderComplaint")
public class ShopOrderComplaintController extends BaseController {

	/**
	 * 订单投诉
	 * @return
	 */
	@RequiresPermissions("spShop:ShopOrder:view")
	@GetMapping("/index")
	public String index() {
		return "";
	}

	
}
