package com.lnbei.web.controller.sp.home.store;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lnbei.common.core.controller.BaseController;

/**
 * 一买过的商铺
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/spHome/HomeStore")
public class HomeStoreController extends BaseController {
	private String prefix = "sphome/store";

	@RequiresPermissions("spHome:HomeStore:list")
	@GetMapping()
	public String index(ModelMap mmap) {

		return prefix + "/index";
	}
}
