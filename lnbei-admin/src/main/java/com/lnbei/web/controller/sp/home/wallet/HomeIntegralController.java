package com.lnbei.web.controller.sp.home.wallet;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lnbei.common.core.controller.BaseController;

/**
 * 积分管理
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/spHome/HomeIntegral")
public class HomeIntegralController extends BaseController {
	private String prefix = "sphome/integral";

	@RequiresPermissions("spHome:HomeIntegral:list")
	@GetMapping()
	public String index(ModelMap mmap) {

		return prefix + "/index";
	}
}
