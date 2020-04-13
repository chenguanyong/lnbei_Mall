package com.lnbei.web.controller.sp.home.order;


import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lnbei.common.core.controller.BaseController;
@Controller
@RequestMapping("/spHome/HomeOrderComplaint")
public class HomeOrderComplaintController extends BaseController {

	private String prefix = "sphome/ordercomplaint";

	/**
	 * 购物车列表
	 * 
	 * @param mmMap
	 * @return
	 */
	@RequiresPermissions("spHome:HomeOrderComplaint:list")
	@GetMapping()
	public String index(ModelMap mmMap) {

		return prefix + "/index";
	}

	
}
