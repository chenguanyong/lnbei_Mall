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

import com.alibaba.druid.sql.visitor.ParameterizedOutputVisitorUtils;
import com.lnbei.common.annotation.Log;
import com.lnbei.common.enums.BusinessType;
import com.lnbei.sp.domain.SpGoodsCats;
import com.lnbei.sp.service.ISpGoodsCatsService;
import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.page.TableDataInfo;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.utils.poi.ExcelUtil;
import com.lnbei.framework.util.ShiroUtils;

/**
 * 商品分类 信息操作处理
 * 
 * @author lnbei
 * @date 2020-02-05
 */
@Controller
@RequestMapping("/spadmin/spGoodsCats")
public class SpGoodsCatsController extends BaseController {
	private String prefix = "sp/spGoodsCats";

	@Autowired
	private ISpGoodsCatsService spGoodsCatsService;

	@RequiresPermissions("spadmin:spGoodsCats:view")
	@GetMapping()
	public String spGoodsCats() {
		return prefix + "/spGoodsCats";
	}

	/**
	 * 查询商品分类列表
	 */
	@RequiresPermissions("spadmin:spGoodsCats:list")
	@GetMapping("/list")
	@ResponseBody
	public List<SpGoodsCats> list(SpGoodsCats spGoodsCats) {
		List<SpGoodsCats> list = spGoodsCatsService.selectSpGoodsCatsList(spGoodsCats);
		return list;
	}

	/**
	 * 导出商品分类列表
	 */
	@RequiresPermissions("spadmin:spGoodsCats:export")
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(SpGoodsCats spGoodsCats) {
		List<SpGoodsCats> list = spGoodsCatsService.selectSpGoodsCatsList(spGoodsCats);
		ExcelUtil<SpGoodsCats> util = new ExcelUtil<SpGoodsCats>(SpGoodsCats.class);
		return util.exportExcel(list, "spGoodsCats");
	}

	/**
	 * 新增商品分类
	 */
	@GetMapping("/add/{mid}")
	public String add(@PathVariable("mid") String mid, ModelMap mmMap) {
		mmMap.put("mid", mid);
		return prefix + "/add";
	}

	/**
	 * 新增保存商品分类
	 */
	@RequiresPermissions("spadmin:spGoodsCats:add")
	@Log(title = "商品分类", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(SpGoodsCats spGoodsCats) {
		spGoodsCats.initInsert(ShiroUtils.getUser());
		return toAjax(spGoodsCatsService.insertSpGoodsCats(spGoodsCats));
	}

	/**
	 * 修改商品分类
	 */
	@GetMapping("/edit/{mid}")
	public String edit(@PathVariable("mid") String mid, ModelMap mmap) {
		SpGoodsCats spGoodsCats = spGoodsCatsService.selectSpGoodsCatsById(mid);
		mmap.put("spGoodsCats", spGoodsCats);
		return prefix + "/edit";
	}

	/**
	 * 修改保存商品分类
	 */
	@RequiresPermissions("spadmin:spGoodsCats:edit")
	@Log(title = "商品分类", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(SpGoodsCats spGoodsCats) {
		spGoodsCats.initUpdate(ShiroUtils.getUser());
		return toAjax(spGoodsCatsService.updateSpGoodsCats(spGoodsCats));
	}

	/**
	 * 删除商品分类
	 */
	@RequiresPermissions("spadmin:spGoodsCats:remove")
	@Log(title = "商品分类", businessType = BusinessType.DELETE)
	@PostMapping("/remove")
	@ResponseBody
	public AjaxResult remove(String ids) {
		return toAjax(spGoodsCatsService.deleteSpGoodsCatsByIds(ids));
	}

}
