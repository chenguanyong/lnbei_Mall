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
import com.lnbei.wf.domain.WfWorkflowStepUser;
import com.lnbei.wf.service.IWfWorkflowStepUserService;
import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.page.TableDataInfo;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.utils.poi.ExcelUtil;

/**
 * 流程步骤用户 信息操作处理
 * 
 * @author lnbei
 * @date 2020-02-08
 */
@Controller
@RequestMapping("/wf/wfWorkflowStepUser")
public class WfWorkflowStepUserController extends BaseController
{
    private String prefix = "wf/wfWorkflowStepUser";
	
	@Autowired
	private IWfWorkflowStepUserService wfWorkflowStepUserService;
	
	@RequiresPermissions("wf:wfWorkflowStepUser:view")
	@GetMapping()
	public String wfWorkflowStepUser()
	{
	    return prefix + "/wfWorkflowStepUser";
	}
	
	/**
	 * 查询流程步骤用户列表
	 */
	@RequiresPermissions("wf:wfWorkflowStepUser:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(WfWorkflowStepUser wfWorkflowStepUser)
	{
		startPage();
        List<WfWorkflowStepUser> list = wfWorkflowStepUserService.selectWfWorkflowStepUserList(wfWorkflowStepUser);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出流程步骤用户列表
	 */
	@RequiresPermissions("wf:wfWorkflowStepUser:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(WfWorkflowStepUser wfWorkflowStepUser)
    {
    	List<WfWorkflowStepUser> list = wfWorkflowStepUserService.selectWfWorkflowStepUserList(wfWorkflowStepUser);
        ExcelUtil<WfWorkflowStepUser> util = new ExcelUtil<WfWorkflowStepUser>(WfWorkflowStepUser.class);
        return util.exportExcel(list, "wfWorkflowStepUser");
    }
	
	/**
	 * 新增流程步骤用户
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存流程步骤用户
	 */
	@RequiresPermissions("wf:wfWorkflowStepUser:add")
	@Log(title = "流程步骤用户", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(WfWorkflowStepUser wfWorkflowStepUser)
	{		
		return toAjax(wfWorkflowStepUserService.insertWfWorkflowStepUser(wfWorkflowStepUser));
	}

	/**
	 * 修改流程步骤用户
	 */
	@GetMapping("/edit/{mid}")
	public String edit(@PathVariable("mid") String mid, ModelMap mmap)
	{
		WfWorkflowStepUser wfWorkflowStepUser = wfWorkflowStepUserService.selectWfWorkflowStepUserById(mid);
		mmap.put("wfWorkflowStepUser", wfWorkflowStepUser);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存流程步骤用户
	 */
	@RequiresPermissions("wf:wfWorkflowStepUser:edit")
	@Log(title = "流程步骤用户", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(WfWorkflowStepUser wfWorkflowStepUser)
	{		
		return toAjax(wfWorkflowStepUserService.updateWfWorkflowStepUser(wfWorkflowStepUser));
	}
	
	/**
	 * 删除流程步骤用户
	 */
	@RequiresPermissions("wf:wfWorkflowStepUser:remove")
	@Log(title = "流程步骤用户", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(wfWorkflowStepUserService.deleteWfWorkflowStepUserByIds(ids));
	}
	
}
