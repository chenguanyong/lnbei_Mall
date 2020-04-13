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
import com.lnbei.sp.domain.SpOrderExpress;
import com.lnbei.sp.service.ISpOrderExpressService;
import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.page.TableDataInfo;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.utils.poi.ExcelUtil;

/**
 * 订单快递 信息操作处理
 * 
 * @author lnbei
 * @date 2020-02-05
 */
@Controller
@RequestMapping("/spadmin/spOrderExpress")
public class SpOrderExpressController extends BaseController
{
    private String prefix = "sp/spOrderExpress";
	
	@Autowired
	private ISpOrderExpressService spOrderExpressService;
	
	@RequiresPermissions("spadmin:spOrderExpress:view")
	@GetMapping()
	public String spOrderExpress()
	{
	    return prefix + "/spOrderExpress";
	}
	
	/**
	 * 查询订单快递列表
	 */
	@RequiresPermissions("spadmin:spOrderExpress:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SpOrderExpress spOrderExpress)
	{
		startPage();
        List<SpOrderExpress> list = spOrderExpressService.selectSpOrderExpressList(spOrderExpress);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出订单快递列表
	 */
	@RequiresPermissions("spadmin:spOrderExpress:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SpOrderExpress spOrderExpress)
    {
    	List<SpOrderExpress> list = spOrderExpressService.selectSpOrderExpressList(spOrderExpress);
        ExcelUtil<SpOrderExpress> util = new ExcelUtil<SpOrderExpress>(SpOrderExpress.class);
        return util.exportExcel(list, "spOrderExpress");
    }
	
	/**
	 * 新增订单快递
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存订单快递
	 */
	@RequiresPermissions("spadmin:spOrderExpress:add")
	@Log(title = "订单快递", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(SpOrderExpress spOrderExpress)
	{		
		return toAjax(spOrderExpressService.insertSpOrderExpress(spOrderExpress));
	}

	/**
	 * 修改订单快递
	 */
	@GetMapping("/edit/{mid}")
	public String edit(@PathVariable("mid") String mid, ModelMap mmap)
	{
		SpOrderExpress spOrderExpress = spOrderExpressService.selectSpOrderExpressById(mid);
		mmap.put("spOrderExpress", spOrderExpress);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存订单快递
	 */
	@RequiresPermissions("spadmin:spOrderExpress:edit")
	@Log(title = "订单快递", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(SpOrderExpress spOrderExpress)
	{		
		return toAjax(spOrderExpressService.updateSpOrderExpress(spOrderExpress));
	}
	
	/**
	 * 删除订单快递
	 */
	@RequiresPermissions("spadmin:spOrderExpress:remove")
	@Log(title = "订单快递", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(spOrderExpressService.deleteSpOrderExpressByIds(ids));
	}
	
}
