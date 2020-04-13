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
import com.lnbei.sp.domain.SpOrderComplains;
import com.lnbei.sp.service.ISpOrderComplainsService;
import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.page.TableDataInfo;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.utils.poi.ExcelUtil;

/**
 * 商品投诉 信息操作处理
 * 
 * @author lnbei
 * @date 2020-02-05
 */
@Controller
@RequestMapping("/spadmin/spOrderComplains")
public class SpOrderComplainsController extends BaseController
{
    private String prefix = "sp/spOrderComplains";
	
	@Autowired
	private ISpOrderComplainsService spOrderComplainsService;
	
	@RequiresPermissions("spadmin:spOrderComplains:view")
	@GetMapping()
	public String spOrderComplains()
	{
	    return prefix + "/spOrderComplains";
	}
	
	/**
	 * 查询商品投诉列表
	 */
	@RequiresPermissions("spadmin:spOrderComplains:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SpOrderComplains spOrderComplains)
	{
		startPage();
        List<SpOrderComplains> list = spOrderComplainsService.selectSpOrderComplainsList(spOrderComplains);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出商品投诉列表
	 */
	@RequiresPermissions("spadmin:spOrderComplains:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SpOrderComplains spOrderComplains)
    {
    	List<SpOrderComplains> list = spOrderComplainsService.selectSpOrderComplainsList(spOrderComplains);
        ExcelUtil<SpOrderComplains> util = new ExcelUtil<SpOrderComplains>(SpOrderComplains.class);
        return util.exportExcel(list, "spOrderComplains");
    }
	
	/**
	 * 新增商品投诉
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存商品投诉
	 */
	@RequiresPermissions("spadmin:spOrderComplains:add")
	@Log(title = "商品投诉", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(SpOrderComplains spOrderComplains)
	{		
		return toAjax(spOrderComplainsService.insertSpOrderComplains(spOrderComplains));
	}

	/**
	 * 修改商品投诉
	 */
	@GetMapping("/edit/{mid}")
	public String edit(@PathVariable("mid") String mid, ModelMap mmap)
	{
		SpOrderComplains spOrderComplains = spOrderComplainsService.selectSpOrderComplainsById(mid);
		mmap.put("spOrderComplains", spOrderComplains);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存商品投诉
	 */
	@RequiresPermissions("spadmin:spOrderComplains:edit")
	@Log(title = "商品投诉", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(SpOrderComplains spOrderComplains)
	{		
		return toAjax(spOrderComplainsService.updateSpOrderComplains(spOrderComplains));
	}
	
	/**
	 * 删除商品投诉
	 */
	@RequiresPermissions("spadmin:spOrderComplains:remove")
	@Log(title = "商品投诉", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(spOrderComplainsService.deleteSpOrderComplainsByIds(ids));
	}
	
}
