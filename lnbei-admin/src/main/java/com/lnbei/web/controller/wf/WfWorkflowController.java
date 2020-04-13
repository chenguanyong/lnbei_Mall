package com.lnbei.web.controller.wf;

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
import com.lnbei.wf.domain.WfWorkflow;
import com.lnbei.wf.service.IWfWorkflowService;
import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.page.TableDataInfo;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.utils.poi.ExcelUtil;
import com.lnbei.home.domain.HomeCategory;
import com.lnbei.home.service.IHomeCategoryService;

/**
 * 流程 信息操作处理
 * 
 * @author lnbei
 * @date 2020-02-08
 */
@Controller
@RequestMapping("/wf/wfWorkflow")
public class WfWorkflowController extends BaseController {
	private String prefix = "wf/wfWorkflow";

	@Autowired
	private IWfWorkflowService wfWorkflowService;
	@Autowired
	private IHomeCategoryService homeCategoryService;

	@RequiresPermissions("wf:wfWorkflow:view")
	@GetMapping()
	public String wfWorkflow() {
		return prefix + "/wfWorkflow";
	}

	/**
	 * 查询流程列表
	 */
	@RequiresPermissions("wf:wfWorkflow:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(WfWorkflow wfWorkflow) {
		startPage();
		List<WfWorkflow> list = wfWorkflowService.selectWfWorkflowList(wfWorkflow);
		return getDataTable(list);
	}

	/**
	 * 导出流程列表
	 */
	@RequiresPermissions("wf:wfWorkflow:export")
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(WfWorkflow wfWorkflow) {
		List<WfWorkflow> list = wfWorkflowService.selectWfWorkflowList(wfWorkflow);
		ExcelUtil<WfWorkflow> util = new ExcelUtil<WfWorkflow>(WfWorkflow.class);
		return util.exportExcel(list, "wfWorkflow");
	}

	/**
	 * 新增流程
	 */
	@GetMapping("/add")
	public String add(String categoryId, ModelMap mmMap) {
		HomeCategory mCategory = homeCategoryService.selectHomeCategoryById(categoryId);
		mmMap.put("mCategory", mCategory);
		return prefix + "/add";
	}

	/**
	 * 新增保存流程
	 */
	@RequiresPermissions("wf:wfWorkflow:add")
	@Log(title = "流程", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(WfWorkflow wfWorkflow) {
		return toAjax(wfWorkflowService.insertWfWorkflow(wfWorkflow));
	}

	/**
	 * 修改流程
	 */
	@GetMapping("/edit/{mid}")
	public String edit(@PathVariable("mid") String mid, ModelMap mmap) {
		WfWorkflow wfWorkflow = wfWorkflowService.selectWfWorkflowById(mid);
		mmap.put("wfWorkflow", wfWorkflow);
		return prefix + "/edit";
	}

	/**
	 * 修改保存流程
	 */
	@RequiresPermissions("wf:wfWorkflow:edit")
	@Log(title = "流程", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(WfWorkflow wfWorkflow) {
		return toAjax(wfWorkflowService.updateWfWorkflow(wfWorkflow));
	}

	/**
	 * 删除流程
	 */
	@RequiresPermissions("wf:wfWorkflow:remove")
	@Log(title = "流程", businessType = BusinessType.DELETE)
	@PostMapping("/remove")
	@ResponseBody
	public AjaxResult remove(String ids) {
		return toAjax(wfWorkflowService.deleteWfWorkflowByIds(ids));
	}
	@RequiresPermissions("wf:wfWorkflow:detail")
	@Log(title = "流程", businessType = BusinessType.DELETE)
	@GetMapping("/detail/{wfId}")

	public String goToStepController(@PathVariable("wfId") String wfId) {
		return redirect("/wf/wfWorkflowStep?mid="+wfId);
	}
}
