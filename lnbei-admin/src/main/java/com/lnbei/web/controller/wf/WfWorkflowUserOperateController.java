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
import com.lnbei.wf.domain.WfWorkflowUserOperate;
import com.lnbei.wf.service.IWfWorkflowUserOperateService;
import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.page.TableDataInfo;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.utils.poi.ExcelUtil;

/**
 * 流程用户操作 信息操作处理
 * 
 * @author lnbei
 * @date 2020-02-08
 */
@Controller
@RequestMapping("/wf/wfWorkflowUserOperate")
public class WfWorkflowUserOperateController extends BaseController
{
    private String prefix = "wf/wfWorkflowUserOperate";
	
	@Autowired
	private IWfWorkflowUserOperateService wfWorkflowUserOperateService;
	
	@RequiresPermissions("wf:wfWorkflowUserOperate:view")
	@GetMapping()
	public String wfWorkflowUserOperate()
	{
	    return prefix + "/wfWorkflowUserOperate";
	}
	
	/**
	 * 查询流程用户操作列表
	 */
	@RequiresPermissions("wf:wfWorkflowUserOperate:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(WfWorkflowUserOperate wfWorkflowUserOperate)
	{
		startPage();
        List<WfWorkflowUserOperate> list = wfWorkflowUserOperateService.selectWfWorkflowUserOperateList(wfWorkflowUserOperate);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出流程用户操作列表
	 */
	@RequiresPermissions("wf:wfWorkflowUserOperate:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(WfWorkflowUserOperate wfWorkflowUserOperate)
    {
    	List<WfWorkflowUserOperate> list = wfWorkflowUserOperateService.selectWfWorkflowUserOperateList(wfWorkflowUserOperate);
        ExcelUtil<WfWorkflowUserOperate> util = new ExcelUtil<WfWorkflowUserOperate>(WfWorkflowUserOperate.class);
        return util.exportExcel(list, "wfWorkflowUserOperate");
    }
	
	/**
	 * 新增流程用户操作
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存流程用户操作
	 */
	@RequiresPermissions("wf:wfWorkflowUserOperate:add")
	@Log(title = "流程用户操作", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(WfWorkflowUserOperate wfWorkflowUserOperate)
	{		
		return toAjax(wfWorkflowUserOperateService.insertWfWorkflowUserOperate(wfWorkflowUserOperate));
	}

	/**
	 * 修改流程用户操作
	 */
	@GetMapping("/edit/{mid}")
	public String edit(@PathVariable("mid") String mid, ModelMap mmap)
	{
		WfWorkflowUserOperate wfWorkflowUserOperate = wfWorkflowUserOperateService.selectWfWorkflowUserOperateById(mid);
		mmap.put("wfWorkflowUserOperate", wfWorkflowUserOperate);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存流程用户操作
	 */
	@RequiresPermissions("wf:wfWorkflowUserOperate:edit")
	@Log(title = "流程用户操作", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(WfWorkflowUserOperate wfWorkflowUserOperate)
	{		
		return toAjax(wfWorkflowUserOperateService.updateWfWorkflowUserOperate(wfWorkflowUserOperate));
	}
	
	/**
	 * 删除流程用户操作
	 */
	@RequiresPermissions("wf:wfWorkflowUserOperate:remove")
	@Log(title = "流程用户操作", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(wfWorkflowUserOperateService.deleteWfWorkflowUserOperateByIds(ids));
	}
	
}
