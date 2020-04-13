package com.lnbei.web.controller.sp.admin;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.lnbei.common.annotation.Log;
import com.lnbei.common.enums.BusinessType;
import com.lnbei.sp.domain.SpSpecItems;
import com.lnbei.sp.service.ISpSpecItemsService;
import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.page.TableDataInfo;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.utils.poi.ExcelUtil;
import com.lnbei.framework.util.ShiroUtils;

/**
 * 规格值 信息操作处理
 * 
 * @author lnbei
 * @date 2020-02-05
 */
@Controller
@RequestMapping("/spadmin/spSpecItems")
public class SpSpecItemsController extends BaseController {
	private String prefix = "sp/spSpecItems";

	@Autowired
	private ISpSpecItemsService spSpecItemsService;

	@RequiresPermissions("spadmin:spSpecItems:view")
	@GetMapping()
	public String spSpecItems() {
		return prefix + "/spSpecItems";
	}

	/**
	 * 查询规格值列表
	 */
	@RequiresPermissions("spadmin:spSpecItems:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SpSpecItems spSpecItems) {
		startPage();
		List<SpSpecItems> list = spSpecItemsService.selectSpSpecItemsList(spSpecItems);
		return getDataTable(list);
	}

	/**
	 * 导出规格值列表
	 */
	@RequiresPermissions("spadmin:spSpecItems:export")
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(SpSpecItems spSpecItems) {
		List<SpSpecItems> list = spSpecItemsService.selectSpSpecItemsList(spSpecItems);
		ExcelUtil<SpSpecItems> util = new ExcelUtil<SpSpecItems>(SpSpecItems.class);
		return util.exportExcel(list, "spSpecItems");
	}

	/**
	 * 新增规格值
	 */
	@GetMapping("/add")
	public String add() {
		return prefix + "/add";
	}

	/**
	 * 新增保存规格值
	 */
	@RequiresPermissions("spadmin:spSpecItems:add")
	@Log(title = "规格值", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(SpSpecItems spSpecItems) {
		spSpecItems.initInsert(ShiroUtils.getUser());
		return toAjax(spSpecItemsService.insertSpSpecItems(spSpecItems));
	}

	/**
	 * 修改规格值
	 */
	@GetMapping("/edit/{mid}")
	public String edit(@PathVariable("mid") String mid, ModelMap mmap) {
		SpSpecItems spSpecItems = spSpecItemsService.selectSpSpecItemsById(mid);
		mmap.put("spSpecItems", spSpecItems);
		return prefix + "/edit";
	}

	/**
	 * 修改保存规格值
	 */
	@RequiresPermissions("spadmin:spSpecItems:edit")
	@Log(title = "规格值", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(SpSpecItems spSpecItems) {
		spSpecItems.initUpdate(ShiroUtils.getUser());
		return toAjax(spSpecItemsService.updateSpSpecItems(spSpecItems));
	}

	/**
	 * 删除规格值
	 */
	@RequiresPermissions("spadmin:spSpecItems:remove")
	@Log(title = "规格值", businessType = BusinessType.DELETE)
	@PostMapping("/remove")
	@ResponseBody
	public AjaxResult remove(String ids) {
		return toAjax(spSpecItemsService.deleteSpSpecItemsByIds(ids));
	}

}
