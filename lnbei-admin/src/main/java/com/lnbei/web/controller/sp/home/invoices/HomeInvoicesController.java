package com.lnbei.web.controller.sp.home.invoices;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lnbei.common.core.controller.BaseController;

/**
 * 发票管理
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/spHome/HomeInvoices")
public class HomeInvoicesController extends BaseController {
	private String prefix = "sphome/invoices";

	/**
	 * 购物车列表
	 * 
	 * @param mmMap
	 * @return
	 */
	@RequiresPermissions("spHome:HomeGoods:list")
	@GetMapping()
	public String index(ModelMap mmMap) {

		return prefix + "/index";
	}
}
