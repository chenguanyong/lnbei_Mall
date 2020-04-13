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
import com.lnbei.sp.domain.SpInvoices;
import com.lnbei.sp.service.ISpInvoicesService;
import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.page.TableDataInfo;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.utils.poi.ExcelUtil;
import com.lnbei.framework.util.ShiroUtils;

/**
 * 发票管理 信息操作处理
 * 
 * @author lnbei
 * @date 2020-02-23
 */
@Controller
@RequestMapping("/spadmin/spInvoices")
public class SpInvoicesController extends BaseController {
	private String prefix = "sp/spInvoices";

	@Autowired
	private ISpInvoicesService spInvoicesService;

	@RequiresPermissions("spadmin:spInvoices:view")
	@GetMapping()
	public String spInvoices() {
		return prefix + "/spInvoices";
	}

	/**
	 * 查询发票管理列表
	 */
	@RequiresPermissions("spadmin:spInvoices:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SpInvoices spInvoices) {
		startPage();
		List<SpInvoices> list = spInvoicesService.selectSpInvoicesList(spInvoices);
		return getDataTable(list);
	}

	/**
	 * 导出发票管理列表
	 */
	@RequiresPermissions("spadmin:spInvoices:export")
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(SpInvoices spInvoices) {
		List<SpInvoices> list = spInvoicesService.selectSpInvoicesList(spInvoices);
		ExcelUtil<SpInvoices> util = new ExcelUtil<SpInvoices>(SpInvoices.class);
		return util.exportExcel(list, "spInvoices");
	}

	/**
	 * 新增发票管理
	 */
	@GetMapping("/add")
	public String add() {
		return prefix + "/add";
	}

	/**
	 * 新增保存发票管理
	 */
	@RequiresPermissions("spadmin:spInvoices:add")
	@Log(title = "发票管理", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(SpInvoices spInvoices) {
		spInvoices.initInsert(ShiroUtils.getUser());
		return toAjax(spInvoicesService.insertSpInvoices(spInvoices));
	}

	/**
	 * 修改发票管理
	 */
	@GetMapping("/edit/{mid}")
	public String edit(@PathVariable("mid") String mid, ModelMap mmap) {
		SpInvoices spInvoices = spInvoicesService.selectSpInvoicesById(mid);
		mmap.put("spInvoices", spInvoices);
		return prefix + "/edit";
	}

	/**
	 * 修改保存发票管理
	 */
	@RequiresPermissions("spadmin:spInvoices:edit")
	@Log(title = "发票管理", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(SpInvoices spInvoices) {
		spInvoices.initUpdate(ShiroUtils.getUser());
		return toAjax(spInvoicesService.updateSpInvoices(spInvoices));
	}

	/**
	 * 删除发票管理
	 */
	@RequiresPermissions("spadmin:spInvoices:remove")
	@Log(title = "发票管理", businessType = BusinessType.DELETE)
	@PostMapping("/remove")
	@ResponseBody
	public AjaxResult remove(String ids) {
		return toAjax(spInvoicesService.deleteSpInvoicesByIds(ids));
	}

}
