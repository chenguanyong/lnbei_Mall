package com.lnbei.web.controller.sp.shop.statistics;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lnbei.common.core.controller.BaseController;

/**
 * 商家店铺管理
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/spShop/ShopStatistics")
public class ShopStatisticsController extends BaseController {
	private String prefix = "spshop/statistics";
	
	@GetMapping()
	public String index(ModelMap mmap) {

		return prefix + "/index";
	}
}
