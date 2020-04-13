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
import com.lnbei.sp.domain.SpCarts;
import com.lnbei.sp.service.ISpCartsService;
import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.page.TableDataInfo;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.utils.poi.ExcelUtil;

/**
 * 购物车 信息操作处理
 * 
 * @author lnbei
 * @date 2020-02-05
 */
@Controller
@RequestMapping("/spadmin/spCarts")
public class SpCartsController extends BaseController
{
    private String prefix = "sp/spCarts";
	
	@Autowired
	private ISpCartsService spCartsService;
	
	@RequiresPermissions("spadmin:spCarts:view")
	@GetMapping()
	public String spCarts()
	{
	    return prefix + "/spCarts";
	}
	
	/**
	 * 查询购物车列表
	 */
	@RequiresPermissions("spadmin:spCarts:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SpCarts spCarts)
	{
		startPage();
        List<SpCarts> list = spCartsService.selectSpCartsList(spCarts);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出购物车列表
	 */
	@RequiresPermissions("spadmin:spCarts:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SpCarts spCarts)
    {
    	List<SpCarts> list = spCartsService.selectSpCartsList(spCarts);
        ExcelUtil<SpCarts> util = new ExcelUtil<SpCarts>(SpCarts.class);
        return util.exportExcel(list, "spCarts");
    }
	
	/**
	 * 新增购物车
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存购物车
	 */
	@RequiresPermissions("spadmin:spCarts:add")
	@Log(title = "购物车", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(SpCarts spCarts)
	{		
		return toAjax(spCartsService.insertSpCarts(spCarts));
	}

	/**
	 * 修改购物车
	 */
	@GetMapping("/edit/{mid}")
	public String edit(@PathVariable("mid") String mid, ModelMap mmap)
	{
		SpCarts spCarts = spCartsService.selectSpCartsById(mid);
		mmap.put("spCarts", spCarts);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存购物车
	 */
	@RequiresPermissions("spadmin:spCarts:edit")
	@Log(title = "购物车", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(SpCarts spCarts)
	{		
		return toAjax(spCartsService.updateSpCarts(spCarts));
	}
	
	/**
	 * 删除购物车
	 */
	@RequiresPermissions("spadmin:spCarts:remove")
	@Log(title = "购物车", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(spCartsService.deleteSpCartsByIds(ids));
	}
	
}
