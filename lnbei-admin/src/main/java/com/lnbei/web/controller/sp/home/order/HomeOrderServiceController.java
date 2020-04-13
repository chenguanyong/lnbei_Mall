package com.lnbei.web.controller.sp.home.order;

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
@RequestMapping("/spHome/HomeOrderService")
public class HomeOrderServiceController extends BaseController {

	/**
	 * 待付款
	 * @return
	 */
	@RequiresPermissions("spHome:HomeOrderService:list")
	@GetMapping("/index")
	public String index() {
		return "";
	}

}
