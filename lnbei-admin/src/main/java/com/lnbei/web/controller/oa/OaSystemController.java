package com.lnbei.web.controller.oa;

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
import com.lnbei.oa.domain.OaSystem;
import com.lnbei.oa.service.IOaSystemService;
import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.page.TableDataInfo;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.core.domain.Ztree;
import com.lnbei.common.utils.poi.ExcelUtil;
import com.lnbei.framework.util.ShiroUtils;

/**
 * 系统注册 信息操作处理
 * 
 * @author lnbei
 * @date 2019-03-19
 */
@Controller
@RequestMapping("/oa/oaSystem")
public class OaSystemController extends BaseController {
	private String prefix = "oa/oaSystem";

	@Autowired
	private IOaSystemService oaSystemService;

	@RequiresPermissions("oa:oaSystem:view")
	@GetMapping()
	public String oaSystem() {
		return prefix + "/oaSystem";
	}

	/**
	 * 查询系统注册列表
	 */
	@RequiresPermissions("oa:oaSystem:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(OaSystem oaSystem) {
		startPage();
		List<OaSystem> list = oaSystemService.selectOaSystemList(oaSystem);
		return getDataTable(list);
	}

	/**
	 * 导出系统注册列表
	 */
	@RequiresPermissions("oa:oaSystem:export")
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(OaSystem oaSystem) {
		List<OaSystem> list = oaSystemService.selectOaSystemList(oaSystem);
		ExcelUtil<OaSystem> util = new ExcelUtil<OaSystem>(OaSystem.class);
		return util.exportExcel(list, "oaSystem");
	}

	/**
	 * 新增系统注册
	 */
	@GetMapping("/add")
	public String add() {
		return prefix + "/add";
	}

	/**
	 * 新增保存系统注册
	 */
	@RequiresPermissions("oa:oaSystem:add")
	@Log(title = "系统注册", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(OaSystem oaSystem) {
		oaSystem.setCreateBy(ShiroUtils.getLoginName());
		oaSystem.insertData(ShiroUtils.getSysUser());
		int re = oaSystemService.insertOaSystem(oaSystem);
		return toAjax(re);
	}

	/**
	 * 修改系统注册
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap) {
		OaSystem oaSystem = oaSystemService.selectOaSystemById(id);
		mmap.put("oaSystem", oaSystem);
		return prefix + "/edit";
	}

	/**
	 * 修改保存系统注册
	 */
	@RequiresPermissions("oa:oaSystem:edit")
	@Log(title = "系统注册", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(OaSystem oaSystem) {
		oaSystem.setUpdateBy(ShiroUtils.getLoginName());
		return toAjax(oaSystemService.updateOaSystem(oaSystem));
	}

	/**
	 * 删除系统注册
	 */
	@RequiresPermissions("oa:oaSystem:remove")
	@Log(title = "系统注册", businessType = BusinessType.DELETE)
	@PostMapping("/remove")
	@ResponseBody
	public AjaxResult remove(String ids) {
		return toAjax(oaSystemService.deleteOaSystemByIds(ids));
	}

	/**
	 * 加载系统列表树
	 */
	@GetMapping("/treeData")
	@ResponseBody
	public List<Ztree> treeData() {
		List<Ztree> mList = oaSystemService.getSystemZtrees();
		return mList;
	}
    /**
     * 状态修改
     */
    @Log(title = "系统注册", businessType = BusinessType.UPDATE)
    @RequiresPermissions("oa:oaSystem:edit")
    @PostMapping("/changeStatus")
    @ResponseBody
    public AjaxResult changeStatus(OaSystem oaSystem)
    {
    	oaSystem.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(oaSystemService.updateOaSystem(oaSystem));
    }
}
