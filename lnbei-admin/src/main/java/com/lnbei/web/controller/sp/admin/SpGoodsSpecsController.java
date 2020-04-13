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
import com.lnbei.sp.domain.SpGoodsSpecs;
import com.lnbei.sp.service.ISpGoodsSpecsService;
import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.page.TableDataInfo;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.utils.poi.ExcelUtil;

/**
 * 商品规格 信息操作处理
 * 
 * @author lnbei
 * @date 2020-02-05
 */
@Controller
@RequestMapping("/spadmin/spGoodsSpecs")
public class SpGoodsSpecsController extends BaseController
{
    private String prefix = "sp/spGoodsSpecs";
	
	@Autowired
	private ISpGoodsSpecsService spGoodsSpecsService;
	
	@RequiresPermissions("spadmin:spGoodsSpecs:view")
	@GetMapping()
	public String spGoodsSpecs()
	{
	    return prefix + "/spGoodsSpecs";
	}
	
	/**
	 * 查询商品规格列表
	 */
	@RequiresPermissions("spadmin:spGoodsSpecs:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SpGoodsSpecs spGoodsSpecs)
	{
		startPage();
        List<SpGoodsSpecs> list = spGoodsSpecsService.selectSpGoodsSpecsList(spGoodsSpecs);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出商品规格列表
	 */
	@RequiresPermissions("spadmin:spGoodsSpecs:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SpGoodsSpecs spGoodsSpecs)
    {
    	List<SpGoodsSpecs> list = spGoodsSpecsService.selectSpGoodsSpecsList(spGoodsSpecs);
        ExcelUtil<SpGoodsSpecs> util = new ExcelUtil<SpGoodsSpecs>(SpGoodsSpecs.class);
        return util.exportExcel(list, "spGoodsSpecs");
    }
	
	/**
	 * 新增商品规格
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存商品规格
	 */
	@RequiresPermissions("spadmin:spGoodsSpecs:add")
	@Log(title = "商品规格", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(SpGoodsSpecs spGoodsSpecs)
	{		
		return toAjax(spGoodsSpecsService.insertSpGoodsSpecs(spGoodsSpecs));
	}

	/**
	 * 修改商品规格
	 */
	@GetMapping("/edit/{mid}")
	public String edit(@PathVariable("mid") String mid, ModelMap mmap)
	{
		SpGoodsSpecs spGoodsSpecs = spGoodsSpecsService.selectSpGoodsSpecsById(mid);
		mmap.put("spGoodsSpecs", spGoodsSpecs);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存商品规格
	 */
	@RequiresPermissions("spadmin:spGoodsSpecs:edit")
	@Log(title = "商品规格", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(SpGoodsSpecs spGoodsSpecs)
	{		
		return toAjax(spGoodsSpecsService.updateSpGoodsSpecs(spGoodsSpecs));
	}
	
	/**
	 * 删除商品规格
	 */
	@RequiresPermissions("spadmin:spGoodsSpecs:remove")
	@Log(title = "商品规格", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(spGoodsSpecsService.deleteSpGoodsSpecsByIds(ids));
	}
	
}
