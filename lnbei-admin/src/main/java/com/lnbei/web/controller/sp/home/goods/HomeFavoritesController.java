package com.lnbei.web.controller.sp.home.goods;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lnbei.common.core.controller.BaseController;

/**
 * 我的关注/我的收藏
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/spHome/HomeFavorites")
public class HomeFavoritesController extends BaseController {
	private String prefix = "sphome/favorites";

	/**
	 * 列表
	 * 
	 * @param mmMap
	 * @return
	 */
	@RequiresPermissions("spHome:HomeFavorites:view")
	@GetMapping()
	public String index(ModelMap mmMap) {

		return prefix + "/index";
	}
	@RequiresPermissions("spHome:HomeFavorites:shop")
	@GetMapping("/shop")
	public String shop() {
		
		return prefix + "/shop";
	}
	@RequiresPermissions("spHome:HomeFavorites:goods")
	@GetMapping("/goods")
	public String goods() {
		return prefix + "/goods";
	}
	
	
}
