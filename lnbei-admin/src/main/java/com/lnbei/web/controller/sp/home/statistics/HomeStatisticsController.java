package com.lnbei.web.controller.sp.home.statistics;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lnbei.common.core.controller.BaseController;

/**
 * 会员统计
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/spHome/HomeStatistics")
public class HomeStatisticsController extends BaseController {
	private String prefix = "sphome/statistics";
	
	
	@RequiresPermissions("spHome:HomeStatistics:list")
	@GetMapping()
	public String index(ModelMap mmap) {

		return prefix + "/index";
	}
}
