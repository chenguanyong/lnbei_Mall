package com.lnbei.web.controller.wf;

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
import com.lnbei.wf.domain.WfWorkflow;
import com.lnbei.wf.domain.WfWorkflowStep;
import com.lnbei.wf.service.IWfWorkflowService;
import com.lnbei.wf.service.IWfWorkflowStepService;
import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.page.TableDataInfo;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.utils.poi.ExcelUtil;
import com.lnbei.framework.util.ShiroUtils;

/**
 * 流程步骤 信息操作处理
 * 
 * @author lnbei
 * @date 2020-02-08
 */
@Controller
@RequestMapping("/wf/wfWorkflowStep")
public class WfWorkflowStepController extends BaseController
{
    private String prefix = "wf/wfWorkflowStep";
	
	@Autowired
	private IWfWorkflowStepService wfWorkflowStepService;
	@Autowired
	private IWfWorkflowService wfWorkflowService;	
	@RequiresPermissions("wf:wfWorkflowStep:view")
	@GetMapping()
	public String wfWorkflowStep(WfWorkflow mWfWorkflow ,ModelMap mmMap)
	{
		WfWorkflow mWfWorkflow2 = wfWorkflowService.selectWfWorkflowById(mWfWorkflow.getMid());
		mmMap.put("mWfWorkflow2",mWfWorkflow2);
	    return prefix + "/wfWorkflowStep";
	}
	
	/**
	 * 查询流程步骤列表
	 */
	@RequiresPermissions("wf:wfWorkflowStep:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(WfWorkflowStep wfWorkflowStep)
	{
		startPage();
        List<WfWorkflowStep> list = wfWorkflowStepService.selectWfWorkflowStepList(wfWorkflowStep);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出流程步骤列表
	 */
	@RequiresPermissions("wf:wfWorkflowStep:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(WfWorkflowStep wfWorkflowStep)
    {
    	List<WfWorkflowStep> list = wfWorkflowStepService.selectWfWorkflowStepList(wfWorkflowStep);
        ExcelUtil<WfWorkflowStep> util = new ExcelUtil<WfWorkflowStep>(WfWorkflowStep.class);
        return util.exportExcel(list, "wfWorkflowStep");
    }
	
	/**
	 * 新增流程步骤
	 */
	@GetMapping("/add/{id}")
	public String add(@PathVariable("id") String workflowId,ModelMap mmMap)
	{
		WfWorkflow mWfWorkflow = wfWorkflowService.selectWfWorkflowById(workflowId);
		WfWorkflowStep mmWfWorkflowStep = new WfWorkflowStep();
		mmWfWorkflowStep.setWorkflowId(mWfWorkflow.getMid());
		List<WfWorkflowStep> mWfWorkflowSteps = wfWorkflowStepService.selectWfWorkflowStepList(mmWfWorkflowStep);
		
		mmMap.put("stepSize",mWfWorkflowSteps.size()+1);
		mmMap.put("mWfWorkflow",mWfWorkflow);
		mmMap.put("mWfWorkflowSteps",mWfWorkflowSteps);
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存流程步骤
	 */
	@RequiresPermissions("wf:wfWorkflowStep:add")
	@Log(title = "流程步骤", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(WfWorkflowStep wfWorkflowStep)
	{		
		return toAjax(wfWorkflowStepService.insertWfWorkflowStep(wfWorkflowStep, ShiroUtils.getUser()));
	}

	/**
	 * 修改流程步骤
	 */
	@GetMapping("/edit/{mid}")
	public String edit(@PathVariable("mid") String mid, ModelMap mmap)
	{
		WfWorkflowStep wfWorkflowStep = wfWorkflowStepService.selectWfWorkflowStepById(mid);
		WfWorkflowStep mmWfWorkflowStep = new WfWorkflowStep();
		mmWfWorkflowStep.setWorkflowId(wfWorkflowStep.getWorkflowId());
		List<WfWorkflowStep> mWfWorkflowSteps = wfWorkflowStepService.selectWfWorkflowStepList(mmWfWorkflowStep);
		List<WfWorkflowStep> startList = new ArrayList<WfWorkflowStep>();
		List<WfWorkflowStep> endList = new ArrayList<WfWorkflowStep>();
		boolean flag = true;
		for (WfWorkflowStep wfWorkflowStep2 : mWfWorkflowSteps) {
			
			if(wfWorkflowStep2.getMid().equals(wfWorkflowStep.getMid()) && flag) {
				flag = false;
			}
			
			if(flag) {
				startList.add(wfWorkflowStep2);
			}else {
				endList.add(wfWorkflowStep2);
			}
		}
		mmap.put("stepSize", mWfWorkflowSteps.size());
		mmap.put("startList", startList);
		mmap.put("endList", endList);
		mmap.put("wfWorkflowStep", wfWorkflowStep);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存流程步骤
	 */
	@RequiresPermissions("wf:wfWorkflowStep:edit")
	@Log(title = "流程步骤", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(WfWorkflowStep wfWorkflowStep)
	{	
		return toAjax(wfWorkflowStepService.updateWfWorkflowStep(wfWorkflowStep, ShiroUtils.getUser()));
	}
	
	/**
	 * 删除流程步骤
	 */
	@RequiresPermissions("wf:wfWorkflowStep:remove")
	@Log(title = "流程步骤", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(wfWorkflowStepService.deleteWfWorkflowStepByIds(ids));
	}
	
}
