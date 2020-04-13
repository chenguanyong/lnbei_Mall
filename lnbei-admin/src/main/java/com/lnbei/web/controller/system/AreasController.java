package com.lnbei.web.controller.system;

import java.util.ArrayList;
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
import com.lnbei.system.domain.Areas;
import com.lnbei.system.service.IAreasService;
import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.page.TableDataInfo;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.core.domain.Cascade;
import com.lnbei.common.core.domain.Ztree;
import com.lnbei.common.utils.StringUtils;
import com.lnbei.common.utils.poi.ExcelUtil;
import com.lnbei.framework.util.ShiroUtils;
import com.lnbei.home.domain.HomeCategory;

/**
 * 城市管理 信息操作处理
 * 
 * @author lnbei
 * @date 2020-02-04
 */
@Controller
@RequestMapping("/system/areas")
public class AreasController extends BaseController {
	private String prefix = "system/areas";

	@Autowired
	private IAreasService areasService;

	@RequiresPermissions("system:areas:view")
	@GetMapping()
	public String areas() {
		return prefix + "/areas";
	}

	/**
	 * 查询城市管理列表
	 */
	@RequiresPermissions("system:areas:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Areas areas) {
		startPage();
		List<Areas> list = areasService.selectAreasList(areas);
		return getDataTable(list);
	}

	/**
	 * 导出城市管理列表
	 */
	@RequiresPermissions("system:areas:export")
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(Areas areas) {
		List<Areas> list = areasService.selectAreasList(areas);
		ExcelUtil<Areas> util = new ExcelUtil<Areas>(Areas.class);
		return util.exportExcel(list, "areas");
	}

	/**
	 * 新增城市管理
	 */
	@GetMapping("/add/{id}")
	public String add(@PathVariable("id") String id, ModelMap mmMap) {
		Areas mAreas = areasService.selectAreasById(id);
		mmMap.put("mAreas", mAreas);
		return prefix + "/add";
	}

	/**
	 * 新增保存城市管理
	 */
	@RequiresPermissions("system:areas:add")
	@Log(title = "城市管理", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Areas areas) {
		Areas mAreas = areasService.selectAreasById(areas.getParentId());
		if (mAreas != null) {
			mAreas.setPath("0-" + mAreas.getMid());
		} else {
			mAreas.setPath(mAreas.getPath() + "-" + mAreas.getMid());
		}
		int r = areasService.insertAreas(areas, ShiroUtils.getUser());
		if (r > 0) {
			Areas tempAreas = new Areas();
			tempAreas.setMid(areas.getMid());
			tempAreas.setChildCount(mAreas.getChildCount() + 1);
			areasService.updateAreas(tempAreas, ShiroUtils.getUser());
		}
		return toAjax(r);
	}

	/**
	 * 修改城市管理
	 */
	@GetMapping("/edit/{mid}")
	public String edit(@PathVariable("mid") String mid, ModelMap mmap) {
		Areas areas = areasService.selectAreasById(mid);
		if (StringUtils.isEmpty(areas.getMid())) {
			areas.setMid("0");
		}
		mmap.put("areas", areas);
		return prefix + "/edit";
	}

	/**
	 * 修改保存城市管理
	 */
	@RequiresPermissions("system:areas:edit")
	@Log(title = "城市管理", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Areas areas) {
		return toAjax(areasService.updateAreas(areas, ShiroUtils.getUser()));
	}

	/**
	 * 删除城市管理
	 */
	@RequiresPermissions("system:areas:remove")
	@Log(title = "城市管理", businessType = BusinessType.DELETE)
	@PostMapping("/remove")
	@ResponseBody
	public AjaxResult remove(String ids) {
		return toAjax(areasService.deleteAreasByIds(ids));
	}

	@PostMapping("/treeData")
	@ResponseBody
	public List<Ztree> treeData(String id) {
		if (StringUtils.isEmpty(id)) {
			id = "0";
		}
		List<Ztree> ztrees = areasService.getZtreeListByParentId(id);
		return ztrees;
	}

	/**
	 * 分类状态修改
	 */
	@Log(title = "区域管理", businessType = BusinessType.UPDATE)
	@RequiresPermissions("system:areas:changeIsShow")
	@PostMapping("/changeIsShow")
	@ResponseBody
	public AjaxResult changeIsShow(Areas mAreas) {
		return toAjax(areasService.updateAreas(mAreas, ShiroUtils.getUser()));
	}

	/**
	 * 分类状态修改
	 */

	@PostMapping("/cascadeList")
	@ResponseBody
	public AjaxResult cascadeList(String parentId) {
		Areas mAreas2 = new Areas();
		if (StringUtils.isEmpty(parentId) || parentId.equals("0")) {
			mAreas2.setParentId("0");
		}else {
			mAreas2.setParentId(parentId);
		}
		List<Areas> mList = areasService.selectAreasList(mAreas2);
		List<Cascade> mmCascades = new ArrayList<Cascade>();
		for (Areas areas : mList) {
			Cascade cascade = new Cascade();
			cascade.setMid(areas.getMid());
			cascade.setName(areas.getAreaName());
			mmCascades.add(cascade);
		}
		return AjaxResult.success("操作成功", mmCascades);
	}
}
