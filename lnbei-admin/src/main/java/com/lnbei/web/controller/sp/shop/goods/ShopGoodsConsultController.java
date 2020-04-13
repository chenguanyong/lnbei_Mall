package com.lnbei.web.controller.sp.shop.goods;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lnbei.common.core.controller.BaseController;

/**
 * 商品咨询
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/spShop/ShopGoodsConsult")
public class ShopGoodsConsultController extends BaseController {
	private String prefix = "spshop/goodsConsult";
	@RequiresPermissions("spShop:ShopGoodsConsult:view")
	@GetMapping("/index")
	public String index() {
		
		return prefix + "/index";
	}
}
