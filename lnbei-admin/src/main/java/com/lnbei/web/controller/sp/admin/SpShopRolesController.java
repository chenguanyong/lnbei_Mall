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
import com.lnbei.sp.domain.SpShopRoles;
import com.lnbei.sp.service.ISpShopRolesService;
import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.page.TableDataInfo;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.utils.poi.ExcelUtil;
import com.lnbei.framework.util.ShiroUtils;

/**
 * 商家角色 信息操作处理
 * 
 * @author lnbei
 * @date 2020-02-05
 */
@Controller
@RequestMapping("/spadmin/spShopRoles")
public class SpShopRolesController extends BaseController {
	private String prefix = "sp/spShopRoles";

	@Autowired
	private ISpShopRolesService spShopRolesService;

	@RequiresPermissions("spadmin:spShopRoles:view")
	@GetMapping()
	public String spShopRoles() {
		return prefix + "/spShopRoles";
	}

	/**
	 * 查询商家角色列表
	 */
	@RequiresPermissions("spadmin:spShopRoles:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SpShopRoles spShopRoles) {
		startPage();
		List<SpShopRoles> list = spShopRolesService.selectSpShopRolesList(spShopRoles);
		return getDataTable(list);
	}

	/**
	 * 导出商家角色列表
	 */
	@RequiresPermissions("spadmin:spShopRoles:export")
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(SpShopRoles spShopRoles) {
		List<SpShopRoles> list = spShopRolesService.selectSpShopRolesList(spShopRoles);
		ExcelUtil<SpShopRoles> util = new ExcelUtil<SpShopRoles>(SpShopRoles.class);
		return util.exportExcel(list, "spShopRoles");
	}

	/**
	 * 新增商家角色
	 */
	@GetMapping("/add")
	public String add() {
		return prefix + "/add";
	}

	/**
	 * 新增保存商家角色
	 */
	@RequiresPermissions("spadmin:spShopRoles:add")
	@Log(title = "商家角色", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(SpShopRoles spShopRoles) {
		spShopRoles.initInsert(ShiroUtils.getUser());
		spShopRoles.setShopId("1");
		return toAjax(spShopRolesService.insertSpShopRoles(spShopRoles));
	}

	/**
	 * 修改商家角色
	 */
	@GetMapping("/edit/{mid}")
	public String edit(@PathVariable("mid") String mid, ModelMap mmap) {
		SpShopRoles spShopRoles = spShopRolesService.selectSpShopRolesById(mid);
		mmap.put("spShopRoles", spShopRoles);
		return prefix + "/edit";
	}

	/**
	 * 修改保存商家角色
	 */
	@RequiresPermissions("spadmin:spShopRoles:edit")
	@Log(title = "商家角色", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(SpShopRoles spShopRoles) {
		spShopRoles.initUpdate(ShiroUtils.getUser());

		return toAjax(spShopRolesService.updateSpShopRoles(spShopRoles));
	}

	/**
	 * 删除商家角色
	 */
	@RequiresPermissions("spadmin:spShopRoles:remove")
	@Log(title = "商家角色", businessType = BusinessType.DELETE)
	@PostMapping("/remove")
	@ResponseBody
	public AjaxResult remove(String ids) {
		return toAjax(spShopRolesService.deleteSpShopRolesByIds(ids));
	}

}
