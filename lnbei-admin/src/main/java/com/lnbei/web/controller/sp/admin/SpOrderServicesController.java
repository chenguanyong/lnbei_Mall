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
import com.lnbei.sp.domain.SpOrderServices;
import com.lnbei.sp.service.ISpOrderServicesService;
import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.page.TableDataInfo;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.utils.poi.ExcelUtil;

/**
 * 订单服务 信息操作处理
 * 
 * @author lnbei
 * @date 2020-02-05
 */
@Controller
@RequestMapping("/spadmin/spOrderServices")
public class SpOrderServicesController extends BaseController
{
    private String prefix = "sp/spOrderServices";
	
	@Autowired
	private ISpOrderServicesService spOrderServicesService;
	
	@RequiresPermissions("spadmin:spOrderServices:view")
	@GetMapping()
	public String spOrderServices()
	{
	    return prefix + "/spOrderServices";
	}
	
	/**
	 * 查询订单服务列表
	 */
	@RequiresPermissions("spadmin:spOrderServices:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SpOrderServices spOrderServices)
	{
		startPage();
        List<SpOrderServices> list = spOrderServicesService.selectSpOrderServicesList(spOrderServices);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出订单服务列表
	 */
	@RequiresPermissions("spadmin:spOrderServices:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SpOrderServices spOrderServices)
    {
    	List<SpOrderServices> list = spOrderServicesService.selectSpOrderServicesList(spOrderServices);
        ExcelUtil<SpOrderServices> util = new ExcelUtil<SpOrderServices>(SpOrderServices.class);
        return util.exportExcel(list, "spOrderServices");
    }
	
	/**
	 * 新增订单服务
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存订单服务
	 */
	@RequiresPermissions("spadmin:spOrderServices:add")
	@Log(title = "订单服务", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(SpOrderServices spOrderServices)
	{		
		return toAjax(spOrderServicesService.insertSpOrderServices(spOrderServices));
	}

	/**
	 * 修改订单服务
	 */
	@GetMapping("/edit/{mid}")
	public String edit(@PathVariable("mid") String mid, ModelMap mmap)
	{
		SpOrderServices spOrderServices = spOrderServicesService.selectSpOrderServicesById(mid);
		mmap.put("spOrderServices", spOrderServices);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存订单服务
	 */
	@RequiresPermissions("spadmin:spOrderServices:edit")
	@Log(title = "订单服务", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(SpOrderServices spOrderServices)
	{		
		return toAjax(spOrderServicesService.updateSpOrderServices(spOrderServices));
	}
	
	/**
	 * 删除订单服务
	 */
	@RequiresPermissions("spadmin:spOrderServices:remove")
	@Log(title = "订单服务", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(spOrderServicesService.deleteSpOrderServicesByIds(ids));
	}
	
}
