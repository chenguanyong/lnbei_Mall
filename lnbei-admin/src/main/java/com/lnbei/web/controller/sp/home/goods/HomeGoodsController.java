package com.lnbei.web.controller.sp.home.goods;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lnbei.common.core.controller.BaseController;

/**
 * 会员商品管理
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/spHome/HomeGoods")
public class HomeGoodsController extends BaseController {
	private String prefix = "sphome/goods";
	@RequiresPermissions("spHome:HomeGoods:list")
	@GetMapping()
	public String index(ModelMap mmMap) {

		return prefix + "/index";
	}

	/**
	 * 我的足迹
	 * 
	 * @param mmMap
	 * @return
	 */
	@RequiresPermissions("spHome:HomeGoods:footprintGoods")
	@GetMapping("/footprintGoods")
	public String footprintGoods(ModelMap mmMap) {

		return prefix + "/footprintGoods";
	}
	/**
	 * 我浏览的店铺足迹
	 * @param mmMap
	 * @return
	 */
	@RequiresPermissions("spHome:HomeGoods:footprintShop")
	@GetMapping("/footprintShop")
	public String footprintShop(ModelMap mmMap) {

		return prefix + "/footprintShop";
	}
}
