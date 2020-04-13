package com.lnbei.web.controller.sp.shop.goods;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lnbei.common.core.controller.BaseController;

/**
 * 商家店铺管理
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/spShop/ShopGoods")
public class ShopGoodsController extends BaseController {
	private String prefix = "spshop/goods";
	/**
	 * 库存预警
	 * @return
	 */
	@RequiresPermissions("spShop:ShopGoods:view")
	@GetMapping("/index")
	public String index() {
		
		return prefix + "/index";
	}
	/**
	 * 出售中的商品
	 * @return
	 */
	@RequiresPermissions("spShop:ShopGoods:InSaleGoods")
	@GetMapping("/InSaleGoods")
	public String InSaleGoods() {
		
		return prefix + "/index";
	}
	/**
	 * 审核中的商品
	 * @return
	 */
	@RequiresPermissions("spShop:ShopGoods:InAuditGoods")
	@GetMapping("/InAuditGoods")
	public String InAuditGoods() {
		
		return prefix + "/index";
	}
	/**
	 * 仓库中的商品
	 * @return
	 */
	@RequiresPermissions("spShop:ShopGoods:warehouseGoods")
	@GetMapping("/warehouseGoods")
	public String warehouseGoods() {
		
		return prefix + "/index";
	}
	/**
	 * 仓库中的商品
	 * @return
	 */
	@RequiresPermissions("spShop:ShopGoods:illegalGoods")
	@GetMapping("/illegalGoods")
	public String illegalGoods() {
		
		return prefix + "/illegalGoods";
	}

}
