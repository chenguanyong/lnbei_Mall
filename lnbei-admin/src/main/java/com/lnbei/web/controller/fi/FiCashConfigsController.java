package com.lnbei.web.controller.fi;

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
import com.lnbei.fi.domain.FiCashConfigs;
import com.lnbei.fi.service.IFiCashConfigsService;
import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.page.TableDataInfo;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.utils.poi.ExcelUtil;

/**
 * 提现账号管理 信息操作处理
 * 
 * @author lnbei
 * @date 2020-02-13
 */
@Controller
@RequestMapping("/fi/fiCashConfigs")
public class FiCashConfigsController extends BaseController
{
    private String prefix = "fi/fiCashConfigs";
	
	@Autowired
	private IFiCashConfigsService fiCashConfigsService;
	
	@RequiresPermissions("fi:fiCashConfigs:view")
	@GetMapping()
	public String fiCashConfigs()
	{
	    return prefix + "/fiCashConfigs";
	}
	
	/**
	 * 查询提现账号管理列表
	 */
	@RequiresPermissions("fi:fiCashConfigs:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(FiCashConfigs fiCashConfigs)
	{
		startPage();
        List<FiCashConfigs> list = fiCashConfigsService.selectFiCashConfigsList(fiCashConfigs);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出提现账号管理列表
	 */
	@RequiresPermissions("fi:fiCashConfigs:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FiCashConfigs fiCashConfigs)
    {
    	List<FiCashConfigs> list = fiCashConfigsService.selectFiCashConfigsList(fiCashConfigs);
        ExcelUtil<FiCashConfigs> util = new ExcelUtil<FiCashConfigs>(FiCashConfigs.class);
        return util.exportExcel(list, "fiCashConfigs");
    }
	
	/**
	 * 新增提现账号管理
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存提现账号管理
	 */
	@RequiresPermissions("fi:fiCashConfigs:add")
	@Log(title = "提现账号管理", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(FiCashConfigs fiCashConfigs)
	{		
		return toAjax(fiCashConfigsService.insertFiCashConfigs(fiCashConfigs));
	}

	/**
	 * 修改提现账号管理
	 */
	@GetMapping("/edit/{mid}")
	public String edit(@PathVariable("mid") String mid, ModelMap mmap)
	{
		FiCashConfigs fiCashConfigs = fiCashConfigsService.selectFiCashConfigsById(mid);
		mmap.put("fiCashConfigs", fiCashConfigs);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存提现账号管理
	 */
	@RequiresPermissions("fi:fiCashConfigs:edit")
	@Log(title = "提现账号管理", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(FiCashConfigs fiCashConfigs)
	{		
		return toAjax(fiCashConfigsService.updateFiCashConfigs(fiCashConfigs));
	}
	
	/**
	 * 删除提现账号管理
	 */
	@RequiresPermissions("fi:fiCashConfigs:remove")
	@Log(title = "提现账号管理", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(fiCashConfigsService.deleteFiCashConfigsByIds(ids));
	}
	
}
