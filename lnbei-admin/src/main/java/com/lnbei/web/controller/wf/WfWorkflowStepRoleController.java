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
import com.lnbei.wf.domain.WfWorkflowStepRole;
import com.lnbei.wf.service.IWfWorkflowStepRoleService;
import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.page.TableDataInfo;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.utils.poi.ExcelUtil;

/**
 * 流程步骤角色 信息操作处理
 * 
 * @author lnbei
 * @date 2020-02-08
 */
@Controller
@RequestMapping("/wf/wfWorkflowStepRole")
public class WfWorkflowStepRoleController extends BaseController
{
    private String prefix = "wf/wfWorkflowStepRole";
	
	@Autowired
	private IWfWorkflowStepRoleService wfWorkflowStepRoleService;
	
	@RequiresPermissions("wf:wfWorkflowStepRole:view")
	@GetMapping()
	public String wfWorkflowStepRole()
	{
	    return prefix + "/wfWorkflowStepRole";
	}
	
	/**
	 * 查询流程步骤角色列表
	 */
	@RequiresPermissions("wf:wfWorkflowStepRole:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(WfWorkflowStepRole wfWorkflowStepRole)
	{
		startPage();
        List<WfWorkflowStepRole> list = wfWorkflowStepRoleService.selectWfWorkflowStepRoleList(wfWorkflowStepRole);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出流程步骤角色列表
	 */
	@RequiresPermissions("wf:wfWorkflowStepRole:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(WfWorkflowStepRole wfWorkflowStepRole)
    {
    	List<WfWorkflowStepRole> list = wfWorkflowStepRoleService.selectWfWorkflowStepRoleList(wfWorkflowStepRole);
        ExcelUtil<WfWorkflowStepRole> util = new ExcelUtil<WfWorkflowStepRole>(WfWorkflowStepRole.class);
        return util.exportExcel(list, "wfWorkflowStepRole");
    }
	
	/**
	 * 新增流程步骤角色
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存流程步骤角色
	 */
	@RequiresPermissions("wf:wfWorkflowStepRole:add")
	@Log(title = "流程步骤角色", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(WfWorkflowStepRole wfWorkflowStepRole)
	{		
		return toAjax(wfWorkflowStepRoleService.insertWfWorkflowStepRole(wfWorkflowStepRole));
	}

	/**
	 * 修改流程步骤角色
	 */
	@GetMapping("/edit/{mid}")
	public String edit(@PathVariable("mid") String mid, ModelMap mmap)
	{
		WfWorkflowStepRole wfWorkflowStepRole = wfWorkflowStepRoleService.selectWfWorkflowStepRoleById(mid);
		mmap.put("wfWorkflowStepRole", wfWorkflowStepRole);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存流程步骤角色
	 */
	@RequiresPermissions("wf:wfWorkflowStepRole:edit")
	@Log(title = "流程步骤角色", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(WfWorkflowStepRole wfWorkflowStepRole)
	{		
		return toAjax(wfWorkflowStepRoleService.updateWfWorkflowStepRole(wfWorkflowStepRole));
	}
	
	/**
	 * 删除流程步骤角色
	 */
	@RequiresPermissions("wf:wfWorkflowStepRole:remove")
	@Log(title = "流程步骤角色", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(wfWorkflowStepRoleService.deleteWfWorkflowStepRoleByIds(ids));
	}
	
}
