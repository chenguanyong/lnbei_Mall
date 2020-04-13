package com.lnbei.web.controller.sp.home.other;



import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lnbei.common.core.controller.BaseController;


/**
 * 银行卡管理
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/spHome/HomeBank")
public class HomeBankController extends BaseController {
	private String prefix = "sphome/bank";
	@RequiresPermissions("spHome:HomeBank:list")
	@GetMapping()
	public String index(ModelMap mmap) {

		return prefix + "/index";
	}
	
}
