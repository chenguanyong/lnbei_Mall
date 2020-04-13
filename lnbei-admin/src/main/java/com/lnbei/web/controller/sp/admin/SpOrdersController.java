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
import com.lnbei.sp.domain.SpOrders;
import com.lnbei.sp.service.ISpOrdersService;
import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.page.TableDataInfo;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.utils.poi.ExcelUtil;

/**
 * 订单 信息操作处理
 * 
 * @author lnbei
 * @date 2020-02-05
 */
@Controller
@RequestMapping("/spadmin/spOrders")
public class SpOrdersController extends BaseController
{
    private String prefix = "sp/spOrders";
	
	@Autowired
	private ISpOrdersService spOrdersService;
	
	@RequiresPermissions("sp:spOrders:view")
	@GetMapping()
	public String spOrders()
	{
	    return prefix + "/spOrders";
	}
	
	/**
	 * 查询订单列表
	 */
	@RequiresPermissions("sp:spOrders:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SpOrders spOrders)
	{
		startPage();
        List<SpOrders> list = spOrdersService.selectSpOrdersList(spOrders);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出订单列表
	 */
	@RequiresPermissions("sp:spOrders:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SpOrders spOrders)
    {
    	List<SpOrders> list = spOrdersService.selectSpOrdersList(spOrders);
        ExcelUtil<SpOrders> util = new ExcelUtil<SpOrders>(SpOrders.class);
        return util.exportExcel(list, "spOrders");
    }
	
	/**
	 * 新增订单
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存订单
	 */
	@RequiresPermissions("sp:spOrders:add")
	@Log(title = "订单", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(SpOrders spOrders)
	{		
		return toAjax(spOrdersService.insertSpOrders(spOrders));
	}

	/**
	 * 修改订单
	 */
	@GetMapping("/edit/{mid}")
	public String edit(@PathVariable("mid") String mid, ModelMap mmap)
	{
		SpOrders spOrders = spOrdersService.selectSpOrdersById(mid);
		mmap.put("spOrders", spOrders);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存订单
	 */
	@RequiresPermissions("sp:spOrders:edit")
	@Log(title = "订单", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(SpOrders spOrders)
	{		
		return toAjax(spOrdersService.updateSpOrders(spOrders));
	}
	
	/**
	 * 删除订单
	 */
	@RequiresPermissions("sp:spOrders:remove")
	@Log(title = "订单", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(spOrdersService.deleteSpOrdersByIds(ids));
	}
	
}
