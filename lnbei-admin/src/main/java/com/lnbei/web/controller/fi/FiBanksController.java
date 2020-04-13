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
import com.lnbei.fi.domain.FiBanks;
import com.lnbei.fi.service.IFiBanksService;
import com.lnbei.framework.util.ShiroUtils;
import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.page.TableDataInfo;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.utils.poi.ExcelUtil;

/**
 * 银行 信息操作处理
 * 
 * @author lnbei
 * @date 2020-02-13
 */
@Controller
@RequestMapping("/fi/fiBanks")
public class FiBanksController extends BaseController
{
    private String prefix = "fi/fiBanks";
	
	@Autowired
	private IFiBanksService fiBanksService;
	
	@RequiresPermissions("fi:fiBanks:view")
	@GetMapping()
	public String fiBanks()
	{
	    return prefix + "/fiBanks";
	}
	
	/**
	 * 查询银行列表
	 */
	@RequiresPermissions("fi:fiBanks:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(FiBanks fiBanks)
	{
		startPage();
        List<FiBanks> list = fiBanksService.selectFiBanksList(fiBanks);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出银行列表
	 */
	@RequiresPermissions("fi:fiBanks:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FiBanks fiBanks)
    {
    	List<FiBanks> list = fiBanksService.selectFiBanksList(fiBanks);
        ExcelUtil<FiBanks> util = new ExcelUtil<FiBanks>(FiBanks.class);
        return util.exportExcel(list, "fiBanks");
    }
	
	/**
	 * 新增银行
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存银行
	 */
	@RequiresPermissions("fi:fiBanks:add")
	@Log(title = "银行", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(FiBanks fiBanks)
	{		
		fiBanks.initInsert(ShiroUtils.getUser());
		return toAjax(fiBanksService.insertFiBanks(fiBanks));
	}

	/**
	 * 修改银行
	 */
	@GetMapping("/edit/{mid}")
	public String edit(@PathVariable("mid") String mid, ModelMap mmap)
	{
		FiBanks fiBanks = fiBanksService.selectFiBanksById(mid);
		mmap.put("fiBanks", fiBanks);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存银行
	 */
	@RequiresPermissions("fi:fiBanks:edit")
	@Log(title = "银行", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(FiBanks fiBanks)
	{	
		fiBanks.initUpdate(ShiroUtils.getUser());
		return toAjax(fiBanksService.updateFiBanks(fiBanks));
	}
	
	/**
	 * 删除银行
	 */
	@RequiresPermissions("fi:fiBanks:remove")
	@Log(title = "银行", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(fiBanksService.deleteFiBanksByIds(ids));
	}
	
}
