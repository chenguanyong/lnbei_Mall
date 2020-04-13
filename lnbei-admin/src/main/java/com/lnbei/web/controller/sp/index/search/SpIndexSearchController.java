package com.lnbei.web.controller.sp.index.search;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lnbei.common.core.controller.BaseController;
import com.lnbei.sp.domain.SpGoods;
import com.lnbei.sp.service.ISpGoodsService;
import com.lnbei.sp.viewdomain.SpGoodsView;
/**
 * 商品收缩管理
 * @author Administrator
 *
 */

@Controller
@RequestMapping("/spIndex/SpIndexSearch")
public class SpIndexSearchController extends BaseController {
	private String prefix = "spindex/search";
	@Autowired
	private ISpGoodsService spGoodsServiceImpl;	
	/**
	 * 商城搜索
	 * @param mmMap
	 * @return
	 */
	@GetMapping()
	public String index(ModelMap mmMap) {
		
		List<SpGoods> mGoods = spGoodsServiceImpl.selectSpGoodsList(new SpGoods());
		
		mmMap.put("mgoods", mGoods);
		
		return prefix + "/index";
	}
	/**
	 * 店铺搜索结果
	 * @return
	 */
	@PostMapping("/search")
	public List<SpGoods> search(SpGoodsView mGoodsView){
		
		return spGoodsServiceImpl.search(mGoodsView);
	}
	/**
	 * 店铺搜索
	 * @return
	 */
	@GetMapping("/shopSearch")
	public String shopSearch(){
		
		return prefix + "/shopsearch";
	}
}
