package com.lnbei.web.controller.sp.shop.order;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lnbei.common.core.controller.BaseController;
@Controller
@RequestMapping("/spShop/ShopOrder")
public class ShopOrderController extends BaseController {

	/**
	 * 待付款
	 * @return
	 */
	@RequiresPermissions("spShop:ShopOrder:noPayOrder")
	@GetMapping("/noPayOrder")
	public String noPayOrder() {
		return "";
	}
	/**
	 * 待发货
	 * @return
	 */
	@RequiresPermissions("spShop:ShopOrder:noDeliveredOrder")
	@GetMapping("/noDeliveredOrder")
	public String noDeliveredOrder() {
		return "";
	}
	/**
	 * 已完成订单
	 * @return
	 */
	@RequiresPermissions("spShop:ShopOrder:finnishedOrder")
	@GetMapping("/finnishedOrder")	
	public String finnishedOrder() {
		return "";
	}
	/**
	 * 待收货
	 * @return
	 */
	@RequiresPermissions("spShop:ShopOrder:noReceivedOrder")
	@GetMapping("/noReceivedOrder")	
	public String noReceivedOrder() {
		return "";
	}
	/**
	 * 发货订单
	 * @return
	 */
	public String deliver() {
		return "";
	}
	/**
	 * 取消订单
	 * @return
	 */
	public String cancelOrder() {
		
		return "";
	}
	
}
