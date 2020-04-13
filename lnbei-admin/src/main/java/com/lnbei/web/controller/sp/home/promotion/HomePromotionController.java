package com.lnbei.web.controller.sp.home.promotion;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lnbei.common.core.controller.BaseController;

/**
 * 会员促销管理
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/HomeOrder/HomePromotion")
public class HomePromotionController extends BaseController {
	private String prefix = "sphome/promotion";
	
	
	@RequiresPermissions("spHome:HomePromotion:list")
	@GetMapping()
	public String index(ModelMap mmap) {

		return prefix + "/index";
	}
}
