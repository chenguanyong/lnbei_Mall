package com.lnbei.web.controller.sp.shop.promotion;

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
@RequestMapping("/spShop/ShopPromotion")
public class ShopPromotionController extends BaseController {
	private String prefix = "spshop/promotion";
	
	@GetMapping()
	public String index(ModelMap mmap) {

		return prefix + "/index";
	}
}
