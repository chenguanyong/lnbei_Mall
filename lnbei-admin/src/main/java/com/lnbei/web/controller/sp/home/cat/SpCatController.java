package com.lnbei.web.controller.sp.home.cat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.core.page.TableDataInfo;
import com.lnbei.common.core.text.Convert;
import com.lnbei.common.utils.StringUtils;
import com.lnbei.framework.util.ShiroUtils;
import com.lnbei.member.domain.MemberUser;
import com.lnbei.sp.domain.SpCarts;
import com.lnbei.sp.service.ISpCartsService;


@Controller
@RequestMapping("/spHome/cat")
public class SpCatController extends BaseController {
	private String prefix = "sphome/cat";
	@Autowired
	private ISpCartsService spCartsService;

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

	/**
	 * 
	 * @param spCarts
	 * @return
	 */
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SpCarts spCarts) {
		MemberUser memberUser = ShiroUtils.getMemberUser();
		spCarts.setMemberId(memberUser.getUserId());
		startPage();
		List<SpCarts> list = spCartsService.selectSpCartsList(spCarts);
		return getDataTable(list);
	}

	/**
	 * 删除购物车商品
	 * 
	 * @param ids
	 * @return
	 */
	@PostMapping("/removeAll")
	@ResponseBody
	public AjaxResult removeAll(String ids) {

		return toAjax(spCartsService.deleteSpCartsByIds(ids));
	}

	/**
	 * 添加购物车
	 * 
	 * @param mCarts
	 * @return
	 */
	@PostMapping("/addCart")
	@ResponseBody
	public AjaxResult addCart(SpCarts mCarts) {
		mCarts.initInsert(ShiroUtils.getUser());
		return spCartsService.addCart(mCarts);
	}
	/**
	**檢查商品規格
	*/
	@PostMapping("/checkedGoods")
	@ResponseBody
	public AjaxResult checkedGoods(String value, String ids) {
		if(StringUtils.isEmpty(ids)) {
			return AjaxResult.error("系统出错");
		}
		String[] mids = Convert.toStrArray(",", ids);
		return toAjax(spCartsService.checkedGoods(value, mids));
	}
}
