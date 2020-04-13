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
import com.lnbei.sp.domain.SpAttributes;
import com.lnbei.sp.service.ISpAttributesService;
import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.page.TableDataInfo;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.utils.poi.ExcelUtil;

/**
 * 商品属性 信息操作处理
 * 
 * @author lnbei
 * @date 2020-02-05
 */
@Controller
@RequestMapping("/spadmin/spAttributes")
public class SpAttributesController extends BaseController
{
    private String prefix = "sp/spAttributes";
	
	@Autowired
	private ISpAttributesService spAttributesService;
	
	@RequiresPermissions("spadmin:spAttributes:view")
	@GetMapping()
	public String spAttributes()
	{
	    return prefix + "/spAttributes";
	}
	
	/**
	 * 查询商品属性列表
	 */
	@RequiresPermissions("spadmin:spAttributes:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SpAttributes spAttributes)
	{
		startPage();
        List<SpAttributes> list = spAttributesService.selectSpAttributesList(spAttributes);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出商品属性列表
	 */
	@RequiresPermissions("spadmin:spAttributes:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SpAttributes spAttributes)
    {
    	List<SpAttributes> list = spAttributesService.selectSpAttributesList(spAttributes);
        ExcelUtil<SpAttributes> util = new ExcelUtil<SpAttributes>(SpAttributes.class);
        return util.exportExcel(list, "spAttributes");
    }
	
	/**
	 * 新增商品属性
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存商品属性
	 */
	@RequiresPermissions("spadmin:spAttributes:add")
	@Log(title = "商品属性", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(SpAttributes spAttributes)
	{		
		spAttributes.initInsert(spAttributes);
		return toAjax(spAttributesService.insertSpAttributes(spAttributes));
	}

	/**
	 * 修改商品属性
	 */
	@GetMapping("/edit/{mid}")
	public String edit(@PathVariable("mid") String mid, ModelMap mmap)
	{
		SpAttributes spAttributes = spAttributesService.selectSpAttributesById(mid);
		mmap.put("spAttributes", spAttributes);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存商品属性
	 */
	@RequiresPermissions("spadmin:spAttributes:edit")
	@Log(title = "商品属性", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(SpAttributes spAttributes)
	{		
		spAttributes.initUpdate(spAttributes);
		return toAjax(spAttributesService.updateSpAttributes(spAttributes));
	}
	
	/**
	 * 删除商品属性
	 */
	@RequiresPermissions("spadmin:spAttributes:remove")
	@Log(title = "商品属性", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(spAttributesService.deleteSpAttributesByIds(ids));
	}
	/**
	 * 删除商品属性
	 */
	@PostMapping( "/selectSpAttributesList")
	@ResponseBody
	public AjaxResult selectSpAttributesList(SpAttributes spAttributes)
	{		
		return AjaxResult.success("获取成功", spAttributesService.selectSpAttributesList(spAttributes));
	}	
}
