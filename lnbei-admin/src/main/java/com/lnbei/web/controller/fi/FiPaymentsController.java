package com.lnbei.web.controller.fi;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.lnbei.common.annotation.Log;
import com.lnbei.common.enums.BusinessType;
import com.lnbei.fi.domain.FiPayments;
import com.lnbei.fi.service.IFiPaymentsService;
import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.page.TableDataInfo;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.utils.poi.ExcelUtil;
import org.springframework.stereotype.Controller;
/**
 * 支付方式 信息操作处理
 * 
 * @author lnbei
 * @date 2020-02-13
 */
@Controller
@RequestMapping("/fi/fiPayments")
public class FiPaymentsController extends BaseController
{
    private String prefix = "fi/fiPayments";
	
	@Autowired
	private IFiPaymentsService fiPaymentsService;
	
	@RequiresPermissions("fi:fiPayments:view")
	@GetMapping()
	public String fiPayments()
	{
	    return prefix + "/fiPayments";
	}
	
	/**
	 * 查询支付方式列表
	 */
	@RequiresPermissions("fi:fiPayments:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(FiPayments fiPayments)
	{
		startPage();
        List<FiPayments> list = fiPaymentsService.selectFiPaymentsList(fiPayments);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出支付方式列表
	 */
	@RequiresPermissions("fi:fiPayments:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FiPayments fiPayments)
    {
    	List<FiPayments> list = fiPaymentsService.selectFiPaymentsList(fiPayments);
        ExcelUtil<FiPayments> util = new ExcelUtil<FiPayments>(FiPayments.class);
        return util.exportExcel(list, "fiPayments");
    }
	
	/**
	 * 新增支付方式
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存支付方式
	 */
	@RequiresPermissions("fi:fiPayments:add")
	@Log(title = "支付方式", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(FiPayments fiPayments)
	{		
		return toAjax(fiPaymentsService.insertFiPayments(fiPayments));
	}

	/**
	 * 修改支付方式
	 */
	@GetMapping("/edit/{mid}")
	public String edit(@PathVariable("mid") String mid, ModelMap mmap)
	{
		FiPayments fiPayments = fiPaymentsService.selectFiPaymentsById(mid);
		mmap.put("fiPayments", fiPayments);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存支付方式
	 */
	@RequiresPermissions("fi:fiPayments:edit")
	@Log(title = "支付方式", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(FiPayments fiPayments)
	{		
		return toAjax(fiPaymentsService.updateFiPayments(fiPayments));
	}
	
	/**
	 * 删除支付方式
	 */
	@RequiresPermissions("fi:fiPayments:remove")
	@Log(title = "支付方式", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(fiPaymentsService.deleteFiPaymentsByIds(ids));
	}
	
}
