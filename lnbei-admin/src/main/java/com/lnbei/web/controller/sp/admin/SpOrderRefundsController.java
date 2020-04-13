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
import com.lnbei.sp.domain.SpOrderRefunds;
import com.lnbei.sp.service.ISpOrderRefundsService;
import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.page.TableDataInfo;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.utils.poi.ExcelUtil;

/**
 * 退款订单 信息操作处理
 * 
 * @author lnbei
 * @date 2020-02-05
 */
@Controller
@RequestMapping("/spadmin/spOrderRefunds")
public class SpOrderRefundsController extends BaseController
{
    private String prefix = "sp/spOrderRefunds";
	
	@Autowired
	private ISpOrderRefundsService spOrderRefundsService;
	
	@RequiresPermissions("sp:spOrderRefunds:view")
	@GetMapping()
	public String spOrderRefunds()
	{
	    return prefix + "/spOrderRefunds";
	}
	
	/**
	 * 查询退款订单列表
	 */
	@RequiresPermissions("sp:spOrderRefunds:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SpOrderRefunds spOrderRefunds)
	{
		startPage();
        List<SpOrderRefunds> list = spOrderRefundsService.selectSpOrderRefundsList(spOrderRefunds);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出退款订单列表
	 */
	@RequiresPermissions("sp:spOrderRefunds:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SpOrderRefunds spOrderRefunds)
    {
    	List<SpOrderRefunds> list = spOrderRefundsService.selectSpOrderRefundsList(spOrderRefunds);
        ExcelUtil<SpOrderRefunds> util = new ExcelUtil<SpOrderRefunds>(SpOrderRefunds.class);
        return util.exportExcel(list, "spOrderRefunds");
    }
	
	/**
	 * 新增退款订单
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存退款订单
	 */
	@RequiresPermissions("sp:spOrderRefunds:add")
	@Log(title = "退款订单", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(SpOrderRefunds spOrderRefunds)
	{		
		return toAjax(spOrderRefundsService.insertSpOrderRefunds(spOrderRefunds));
	}

	/**
	 * 修改退款订单
	 */
	@GetMapping("/edit/{mid}")
	public String edit(@PathVariable("mid") String mid, ModelMap mmap)
	{
		SpOrderRefunds spOrderRefunds = spOrderRefundsService.selectSpOrderRefundsById(mid);
		mmap.put("spOrderRefunds", spOrderRefunds);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存退款订单
	 */
	@RequiresPermissions("sp:spOrderRefunds:edit")
	@Log(title = "退款订单", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(SpOrderRefunds spOrderRefunds)
	{		
		return toAjax(spOrderRefundsService.updateSpOrderRefunds(spOrderRefunds));
	}
	
	/**
	 * 删除退款订单
	 */
	@RequiresPermissions("sp:spOrderRefunds:remove")
	@Log(title = "退款订单", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(spOrderRefundsService.deleteSpOrderRefundsByIds(ids));
	}
	
}
