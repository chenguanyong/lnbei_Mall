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
import com.lnbei.sp.domain.SpShopFreightTemplate;
import com.lnbei.sp.service.ISpShopFreightTemplateService;
import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.page.TableDataInfo;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.utils.poi.ExcelUtil;

/**
 * 店铺运费模板 信息操作处理
 * 
 * @author lnbei
 * @date 2020-02-05
 */
@Controller
@RequestMapping("/spadmin/spShopFreightTemplate")
public class SpShopFreightTemplateController extends BaseController
{
    private String prefix = "sp/spShopFreightTemplate";
	
	@Autowired
	private ISpShopFreightTemplateService spShopFreightTemplateService;
	
	@RequiresPermissions("spadmin:spShopFreightTemplate:view")
	@GetMapping()
	public String spShopFreightTemplate()
	{
	    return prefix + "/spShopFreightTemplate";
	}
	
	/**
	 * 查询店铺运费模板列表
	 */
	@RequiresPermissions("spadmin:spShopFreightTemplate:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SpShopFreightTemplate spShopFreightTemplate)
	{
		startPage();
        List<SpShopFreightTemplate> list = spShopFreightTemplateService.selectSpShopFreightTemplateList(spShopFreightTemplate);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出店铺运费模板列表
	 */
	@RequiresPermissions("spadmin:spShopFreightTemplate:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SpShopFreightTemplate spShopFreightTemplate)
    {
    	List<SpShopFreightTemplate> list = spShopFreightTemplateService.selectSpShopFreightTemplateList(spShopFreightTemplate);
        ExcelUtil<SpShopFreightTemplate> util = new ExcelUtil<SpShopFreightTemplate>(SpShopFreightTemplate.class);
        return util.exportExcel(list, "spShopFreightTemplate");
    }
	
	/**
	 * 新增店铺运费模板
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存店铺运费模板
	 */
	@RequiresPermissions("spadmin:spShopFreightTemplate:add")
	@Log(title = "店铺运费模板", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(SpShopFreightTemplate spShopFreightTemplate)
	{		
		return toAjax(spShopFreightTemplateService.insertSpShopFreightTemplate(spShopFreightTemplate));
	}

	/**
	 * 修改店铺运费模板
	 */
	@GetMapping("/edit/{mid}")
	public String edit(@PathVariable("mid") String mid, ModelMap mmap)
	{
		SpShopFreightTemplate spShopFreightTemplate = spShopFreightTemplateService.selectSpShopFreightTemplateById(mid);
		mmap.put("spShopFreightTemplate", spShopFreightTemplate);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存店铺运费模板
	 */
	@RequiresPermissions("spadmin:spShopFreightTemplate:edit")
	@Log(title = "店铺运费模板", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(SpShopFreightTemplate spShopFreightTemplate)
	{		
		return toAjax(spShopFreightTemplateService.updateSpShopFreightTemplate(spShopFreightTemplate));
	}
	
	/**
	 * 删除店铺运费模板
	 */
	@RequiresPermissions("spadmin:spShopFreightTemplate:remove")
	@Log(title = "店铺运费模板", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(spShopFreightTemplateService.deleteSpShopFreightTemplateByIds(ids));
	}
	
}
