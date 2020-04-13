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
import com.lnbei.sp.domain.SpGoodsAttributes;
import com.lnbei.sp.service.ISpGoodsAttributesService;
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
@RequestMapping("/spadmin/spGoodsAttributes")
public class SpGoodsAttributesController extends BaseController
{
    private String prefix = "sp/spGoodsAttributes";
	
	@Autowired
	private ISpGoodsAttributesService spGoodsAttributesService;
	
	@RequiresPermissions("spadmin:spGoodsAttributes:view")
	@GetMapping()
	public String spGoodsAttributes()
	{
	    return prefix + "/spGoodsAttributes";
	}
	
	/**
	 * 查询商品属性列表
	 */
	@RequiresPermissions("spadmin:spGoodsAttributes:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SpGoodsAttributes spGoodsAttributes)
	{
		startPage();
        List<SpGoodsAttributes> list = spGoodsAttributesService.selectSpGoodsAttributesList(spGoodsAttributes);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出商品属性列表
	 */
	@RequiresPermissions("spadmin:spGoodsAttributes:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SpGoodsAttributes spGoodsAttributes)
    {
    	List<SpGoodsAttributes> list = spGoodsAttributesService.selectSpGoodsAttributesList(spGoodsAttributes);
        ExcelUtil<SpGoodsAttributes> util = new ExcelUtil<SpGoodsAttributes>(SpGoodsAttributes.class);
        return util.exportExcel(list, "spGoodsAttributes");
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
	@RequiresPermissions("spadmin:spGoodsAttributes:add")
	@Log(title = "商品属性", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(SpGoodsAttributes spGoodsAttributes)
	{		
		return toAjax(spGoodsAttributesService.insertSpGoodsAttributes(spGoodsAttributes));
	}

	/**
	 * 修改商品属性
	 */
	@GetMapping("/edit/{mid}")
	public String edit(@PathVariable("mid") String mid, ModelMap mmap)
	{
		SpGoodsAttributes spGoodsAttributes = spGoodsAttributesService.selectSpGoodsAttributesById(mid);
		mmap.put("spGoodsAttributes", spGoodsAttributes);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存商品属性
	 */
	@RequiresPermissions("spadmin:spGoodsAttributes:edit")
	@Log(title = "商品属性", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(SpGoodsAttributes spGoodsAttributes)
	{		
		return toAjax(spGoodsAttributesService.updateSpGoodsAttributes(spGoodsAttributes));
	}
	
	/**
	 * 删除商品属性
	 */
	@RequiresPermissions("spadmin:spGoodsAttributes:remove")
	@Log(title = "商品属性", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(spGoodsAttributesService.deleteSpGoodsAttributesByIds(ids));
	}
	
}
