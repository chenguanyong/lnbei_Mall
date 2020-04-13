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
import com.lnbei.fi.domain.FiCashDraws;
import com.lnbei.fi.service.IFiCashDrawsService;
import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.page.TableDataInfo;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.utils.poi.ExcelUtil;
import org.springframework.stereotype.Controller;
/**
 * 提现记录 信息操作处理
 * 
 * @author lnbei
 * @date 2020-02-13
 */
@Controller
@RequestMapping("/fi/fiCashDraws")
public class FiCashDrawsController extends BaseController
{
    private String prefix = "fi/fiCashDraws";
	
	@Autowired
	private IFiCashDrawsService fiCashDrawsService;
	
	@RequiresPermissions("fi:fiCashDraws:view")
	@GetMapping()
	public String fiCashDraws()
	{
	    return prefix + "/fiCashDraws";
	}
	
	/**
	 * 查询提现记录列表
	 */
	@RequiresPermissions("fi:fiCashDraws:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(FiCashDraws fiCashDraws)
	{
		startPage();
        List<FiCashDraws> list = fiCashDrawsService.selectFiCashDrawsList(fiCashDraws);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出提现记录列表
	 */
	@RequiresPermissions("fi:fiCashDraws:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FiCashDraws fiCashDraws)
    {
    	List<FiCashDraws> list = fiCashDrawsService.selectFiCashDrawsList(fiCashDraws);
        ExcelUtil<FiCashDraws> util = new ExcelUtil<FiCashDraws>(FiCashDraws.class);
        return util.exportExcel(list, "fiCashDraws");
    }
	
	/**
	 * 新增提现记录
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存提现记录
	 */
	@RequiresPermissions("fi:fiCashDraws:add")
	@Log(title = "提现记录", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(FiCashDraws fiCashDraws)
	{		
		return toAjax(fiCashDrawsService.insertFiCashDraws(fiCashDraws));
	}

	/**
	 * 修改提现记录
	 */
	@GetMapping("/edit/{mid}")
	public String edit(@PathVariable("mid") String mid, ModelMap mmap)
	{
		FiCashDraws fiCashDraws = fiCashDrawsService.selectFiCashDrawsById(mid);
		mmap.put("fiCashDraws", fiCashDraws);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存提现记录
	 */
	@RequiresPermissions("fi:fiCashDraws:edit")
	@Log(title = "提现记录", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(FiCashDraws fiCashDraws)
	{		
		return toAjax(fiCashDrawsService.updateFiCashDraws(fiCashDraws));
	}
	
	/**
	 * 删除提现记录
	 */
	@RequiresPermissions("fi:fiCashDraws:remove")
	@Log(title = "提现记录", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(fiCashDrawsService.deleteFiCashDrawsByIds(ids));
	}
	
}
