package com.lnbei.web.controller.sp.home.refund;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lnbei.common.core.controller.BaseController;

/**
 * 退款管理
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/spHome/HomeRefund")
public class HomeRefundController extends BaseController {
	private String prefix = "sphome/refund";
	
	
	@RequiresPermissions("spHome:HomeRefund:list")
	@GetMapping()
	public String index(ModelMap mmap) {

		return prefix + "/index";
	}
}
