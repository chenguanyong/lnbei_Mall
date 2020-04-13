package com.lnbei.web.controller.sp.shop.goods;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lnbei.common.core.controller.BaseController;

/**
 * 商商品分类管理
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/spShop/ShopGoodsCat")
public class ShopGoodsCatController extends BaseController {
	private String prefix = "spshop/goodscat";
	@RequiresPermissions("spShop:ShopGoodsCat:view")
	@GetMapping("/index")
	public String index() {
		
		return prefix + "/index";
	}
}
