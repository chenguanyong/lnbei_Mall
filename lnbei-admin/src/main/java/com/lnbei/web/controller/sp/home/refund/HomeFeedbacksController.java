package com.lnbei.web.controller.sp.home.refund;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lnbei.common.core.controller.BaseController;

/**
 * 投诉管理
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/spHome/HomeFeedbacks")
public class HomeFeedbacksController extends BaseController {
	private String prefix = "sphome/feedbacks";
	
	@RequiresPermissions("spHome:HomeFeedbacks:list")
	@GetMapping()
	public String index(ModelMap mmap) {

		return prefix + "/index";
	}
}
