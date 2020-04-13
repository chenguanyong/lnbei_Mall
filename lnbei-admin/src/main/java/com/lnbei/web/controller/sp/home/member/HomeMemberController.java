package com.lnbei.web.controller.sp.home.member;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lnbei.common.core.controller.BaseController;

/**
 * 会员管理
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/spHome/HomeMember")
public class HomeMemberController extends BaseController {
	private String prefix = "sphome/member";

	/**
	 * 购物车列表
	 * 
	 * @param mmMap
	 * @return
	 */
	@GetMapping()
	public String index(ModelMap mmMap) {

		return prefix + "/index";
	}
}
