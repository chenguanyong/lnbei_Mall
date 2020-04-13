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
import com.lnbei.sp.domain.SpShopBases;
import com.lnbei.sp.service.ISpShopBasesService;
import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.page.TableDataInfo;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.utils.poi.ExcelUtil;

/**
 * 商家审核 信息操作处理
 * 
 * @author lnbei
 * @date 2020-02-05
 */
@Controller
@RequestMapping("/spadmin/spShopBases")
public class SpShopBasesController extends BaseController
{
    private String prefix = "sp/spShopBases";
	
	@Autowired
	private ISpShopBasesService spShopBasesService;
	
	@RequiresPermissions("spadmin:spShopBases:view")
	@GetMapping()
	public String spShopBases()
	{
	    return prefix + "/spShopBases";
	}
	
	/**
	 * 查询商家审核列表
	 */
	@RequiresPermissions("spadmin:spShopBases:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SpShopBases spShopBases)
	{
		startPage();
        List<SpShopBases> list = spShopBasesService.selectSpShopBasesList(spShopBases);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出商家审核列表
	 */
	@RequiresPermissions("spadmin:spShopBases:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SpShopBases spShopBases)
    {
    	List<SpShopBases> list = spShopBasesService.selectSpShopBasesList(spShopBases);
        ExcelUtil<SpShopBases> util = new ExcelUtil<SpShopBases>(SpShopBases.class);
        return util.exportExcel(list, "spShopBases");
    }
	
	/**
	 * 新增商家审核
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存商家审核
	 */
	@RequiresPermissions("spadmin:spShopBases:add")
	@Log(title = "商家审核", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(SpShopBases spShopBases)
	{		
		return toAjax(spShopBasesService.insertSpShopBases(spShopBases));
	}

	/**
	 * 修改商家审核
	 */
	@GetMapping("/edit/{mid}")
	public String edit(@PathVariable("mid") String mid, ModelMap mmap)
	{
		SpShopBases spShopBases = spShopBasesService.selectSpShopBasesById(mid);
		mmap.put("spShopBases", spShopBases);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存商家审核
	 */
	@RequiresPermissions("spadmin:spShopBases:edit")
	@Log(title = "商家审核", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(SpShopBases spShopBases)
	{		
		return toAjax(spShopBasesService.updateSpShopBases(spShopBases));
	}
	
	/**
	 * 删除商家审核
	 */
	@RequiresPermissions("spadmin:spShopBases:remove")
	@Log(title = "商家审核", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(spShopBasesService.deleteSpShopBasesByIds(ids));
	}
	
}
