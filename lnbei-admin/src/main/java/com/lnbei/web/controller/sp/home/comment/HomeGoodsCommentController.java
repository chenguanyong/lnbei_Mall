package com.lnbei.web.controller.sp.home.comment;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lnbei.common.core.controller.BaseController;

/**
 * 商家财务管理
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/spHome/HomeGoodsComment")
public class HomeGoodsCommentController extends BaseController {
	
	private String prefix = "sphome/comment";

	/**
	 * 购物车列表
	 * 
	 * @param mmMap
	 * @return
	 */
	@RequiresPermissions("spHome:HomeGoodsComment:list")
	@GetMapping()
	public String index(ModelMap mmMap) {

		return prefix + "/index";
	}
}
