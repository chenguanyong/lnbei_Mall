package com.lnbei.web.controller.sp.home.order;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lnbei.common.core.controller.BaseController;

/**
 * 订单管理
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/spHome/HomeOrder")
public class HomeOrderController extends BaseController {
	private String prefix = "sphome/order";
	/**
	 * 提交订单
	 * @return
	 */
	@GetMapping("/index")
	public String index(String status, ModelMap mmMap) {
		return prefix + "/index";
	}
	/**
	 * 提交订单
	 * @return
	 */
	public String buildOrder() {
		return "";
	}
	/**
	 * 提交虚拟订单
	 * @return
	 */
	public String quickSubmit() {
		return "";
	}
	/**
	 * 待付款
	 * @return
	 */
	public String noPayOrder() {
		return "";
	}
	/**
	 * 待发货
	 * @return
	 */
	public String noDeliveredOrder() {
		return "";
	}
	/**
	 * 已完成订单
	 * @return
	 */
	public String finnishedOrder() {
		return "";
	}
	/**
	 * 待收货
	 * @return
	 */
	public String noReceivedOrder() {
		return "";
	}
	/**
	 * 待评论订单
	 * @return
	 */
	public String noCommentOrder() {
		return "";
	}
	/**
	 * 取消订单
	 * @return
	 */
	public String cancelOrder() {
		return "";
	}
	/**
	 * 拒收订单
	 */
	public String rejectedOrder() {
		return "";
	}
	/**
	 * 收货
	 * @return
	 */
	public String receive() {
		return "";
	}
	/**
	 * 跳去评论
	 * @return
	 */
	public String toComment() {
		
		return "";
	}
	
	
}
