package com.lnbei.web.controller.sp.index.shop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lnbei.common.core.controller.BaseController;
import com.lnbei.sp.domain.SpGoods;
import com.lnbei.sp.service.ISpGoodsService;


@Controller
@RequestMapping("/spIndex/SpShop")
public class SpIndexShopController extends BaseController {
	private String prefix = "spindex/shop";
	@Autowired
	private ISpGoodsService spGoodsServiceImpl;	
	@GetMapping()
	public String index(ModelMap mmMap) {
		
		List<SpGoods> mGoods = spGoodsServiceImpl.selectSpGoodsList(new SpGoods());
		
		mmMap.put("mgoods", mGoods);
		
		return prefix + "/index";
	}
	/**
	 * 店铺分类页面
	 * @param mid
	 * @param mmMap
	 * @return
	 */
	@GetMapping("/category")
	public String category(String mid, ModelMap mmMap) {
		SpGoods mmGoods = new SpGoods();
		mmGoods.setShopCatId1(mid);
		mmGoods.setStatus("0");
		mmGoods.setDelFlag("0");
		List<SpGoods> mmGoodsList = spGoodsServiceImpl.selectSpGoodsList(mmGoods);
		mmMap.put("mmGoodsList", mmGoodsList);
		return prefix + "/category";
	}
}
