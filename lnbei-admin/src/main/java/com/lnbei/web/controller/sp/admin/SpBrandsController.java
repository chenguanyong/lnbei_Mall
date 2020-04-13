package com.lnbei.web.controller.sp.admin;

import java.io.IOException;
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
import org.springframework.web.multipart.MultipartFile;

import com.lnbei.common.annotation.Log;
import com.lnbei.common.enums.BusinessType;
import com.lnbei.sp.domain.SpBrands;
import com.lnbei.sp.service.ISpBrandsService;
import com.lnbei.web.controller.common.CommonUnitBaseController;
import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.page.TableDataInfo;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.utils.poi.ExcelUtil;
import com.lnbei.framework.util.ShiroUtils;

/**
 * 品牌 信息操作处理
 * 
 * @author lnbei
 * @date 2020-02-05
 */
@Controller
@RequestMapping("/spadmin/spBrands")
public class SpBrandsController extends CommonUnitBaseController {
	private String prefix = "sp/spBrands";

	@Autowired
	private ISpBrandsService spBrandsService;

	@RequiresPermissions("spadmin:spBrands:view")
	@GetMapping()
	public String spBrands() {
		return prefix + "/spBrands";
	}

	/**
	 * 查询品牌列表
	 */
	@RequiresPermissions("spadmin:spBrands:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SpBrands spBrands) {
		startPage();
		List<SpBrands> list = spBrandsService.selectSpBrandsList(spBrands);
		return getDataTable(list);
	}

	/**
	 * 导出品牌列表
	 */
	@RequiresPermissions("spadmin:spBrands:export")
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(SpBrands spBrands) {
		List<SpBrands> list = spBrandsService.selectSpBrandsList(spBrands);
		ExcelUtil<SpBrands> util = new ExcelUtil<SpBrands>(SpBrands.class);
		return util.exportExcel(list, "spBrands");
	}

	/**
	 * 新增品牌
	 */
	@GetMapping("/add")
	public String add() {
		return prefix + "/add";
	}

	/**
	 * 新增保存品牌
	 * 
	 * @throws IOException
	 */
	@RequiresPermissions("spadmin:spBrands:add")
	@Log(title = "品牌", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(SpBrands spBrands)  {
		spBrands.initInsert(ShiroUtils.getUser());
		return toAjax(spBrandsService.insertSpBrands(spBrands));
	}

	/**
	 * 修改品牌
	 */
	@GetMapping("/edit/{mid}")
	public String edit(@PathVariable("mid") String mid, ModelMap mmap) {
		SpBrands spBrands = spBrandsService.selectSpBrandsById(mid);
		mmap.put("spBrands", spBrands);
		return prefix + "/edit";
	}

	/**
	 * 修改保存品牌
	 * @throws IOException 
	 */
	@RequiresPermissions("spadmin:spBrands:edit")
	@Log(title = "品牌", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(SpBrands spBrands) throws IOException {
		spBrands.initUpdate(ShiroUtils.getUser());
		return toAjax(spBrandsService.updateSpBrands(spBrands));
	}

	/**
	 * 删除品牌
	 */
	@RequiresPermissions("spadmin:spBrands:remove")
	@Log(title = "品牌", businessType = BusinessType.DELETE)
	@PostMapping("/remove")
	@ResponseBody
	public AjaxResult remove(String ids) {
		return toAjax(spBrandsService.deleteSpBrandsByIds(ids));
	}

}
