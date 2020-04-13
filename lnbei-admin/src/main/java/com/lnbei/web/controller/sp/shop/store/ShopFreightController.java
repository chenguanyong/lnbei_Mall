package com.lnbei.web.controller.sp.shop.store;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lnbei.common.core.controller.BaseController;

/**
 * 商家运费模板
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/spShop/ShopFreight")
public class ShopFreightController extends BaseController {
	
	private String prefix = "spshop/freight";
	
	@RequiresPermissions("spShop:ShopFreight:view")
	@GetMapping("/index")
	public String index(ModelMap mmap) {
		
		return prefix + "/index";
	}
	/***
	 * 店铺资料
	 * @param mmap
	 * @return
	 */
	@RequiresPermissions("spShop:ShopFreight:view")
	@GetMapping("/storeInfo")
	public String storeInfo(ModelMap mmap) {
		
		return prefix + "/storeInfo";
	}
	/***
	 * 店铺设置（）
	 * @param mmap
	 * @return
	 */
	@RequiresPermissions("spShop:ShopFreight:view")
	@GetMapping("/storeSet")
	public String storeSet(ModelMap mmap) {
		
		return prefix + "/storeSet";
	}
	@RequiresPermissions("spShop:ShopFreight:storeNotice")
	@GetMapping("/storeNotice")
	public String storeNotice(ModelMap mmap) {
		
		return prefix + "/storeNotice";
	}	
	
}
