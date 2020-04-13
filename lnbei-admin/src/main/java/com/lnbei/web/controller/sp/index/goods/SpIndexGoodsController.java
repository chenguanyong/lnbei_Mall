package com.lnbei.web.controller.sp.index.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lnbei.common.core.controller.BaseController;
import com.lnbei.sp.domain.SpGoods;
import com.lnbei.sp.service.ISpGoodsService;


@Controller
@RequestMapping("/spIndex/spGoods")
public class SpIndexGoodsController extends BaseController {
	private String prefix = "spindex/goods";
	@Autowired
	private ISpGoodsService spGoodsServiceImpl;	
	
	@GetMapping()
	public String index(String mid, ModelMap mmMap) {
		SpGoods mGoods = spGoodsServiceImpl.selectSpGoodsById(mid);
		mmMap.put("mgoods", mGoods);
		return prefix + "/index";
	}
	/**
	 * 商品分类
	 * @return
	 */
	@GetMapping("/goodsCategory")
	public String goodsCategory() {
		
		return prefix +"/goodsCategory";
	}
	/**
	 * 获取单个商品的详情
	 * @param goodsId
	 * @return
	 */
	@GetMapping("detail")
	public String detail(String goodsId, ModelMap mmMap) {
		SpGoods mGoods = spGoodsServiceImpl.selectSpGoodsById(goodsId);
		mmMap.put("mGoods", mGoods);
		return prefix + "/detail";
	}
}
