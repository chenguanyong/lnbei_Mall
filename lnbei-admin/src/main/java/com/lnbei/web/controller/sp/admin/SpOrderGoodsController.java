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
import com.lnbei.sp.domain.SpOrderGoods;
import com.lnbei.sp.service.ISpOrderGoodsService;
import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.page.TableDataInfo;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.utils.poi.ExcelUtil;

/**
 * 订单商品 信息操作处理
 * 
 * @author lnbei
 * @date 2020-02-05
 */
@Controller
@RequestMapping("/spadmin/spOrderGoods")
public class SpOrderGoodsController extends BaseController
{
    private String prefix = "sp/spOrderGoods";
	
	@Autowired
	private ISpOrderGoodsService spOrderGoodsService;
	
	@RequiresPermissions("spadmin:spOrderGoods:view")
	@GetMapping()
	public String spOrderGoods()
	{
	    return prefix + "/spOrderGoods";
	}
	
	/**
	 * 查询订单商品列表
	 */
	@RequiresPermissions("spadmin:spOrderGoods:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SpOrderGoods spOrderGoods)
	{
		startPage();
        List<SpOrderGoods> list = spOrderGoodsService.selectSpOrderGoodsList(spOrderGoods);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出订单商品列表
	 */
	@RequiresPermissions("spadmin:spOrderGoods:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SpOrderGoods spOrderGoods)
    {
    	List<SpOrderGoods> list = spOrderGoodsService.selectSpOrderGoodsList(spOrderGoods);
        ExcelUtil<SpOrderGoods> util = new ExcelUtil<SpOrderGoods>(SpOrderGoods.class);
        return util.exportExcel(list, "spOrderGoods");
    }
	
	/**
	 * 新增订单商品
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存订单商品
	 */
	@RequiresPermissions("spadmin:spOrderGoods:add")
	@Log(title = "订单商品", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(SpOrderGoods spOrderGoods)
	{		
		return toAjax(spOrderGoodsService.insertSpOrderGoods(spOrderGoods));
	}

	/**
	 * 修改订单商品
	 */
	@GetMapping("/edit/{mid}")
	public String edit(@PathVariable("mid") String mid, ModelMap mmap)
	{
		SpOrderGoods spOrderGoods = spOrderGoodsService.selectSpOrderGoodsById(mid);
		mmap.put("spOrderGoods", spOrderGoods);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存订单商品
	 */
	@RequiresPermissions("spadmin:spOrderGoods:edit")
	@Log(title = "订单商品", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(SpOrderGoods spOrderGoods)
	{		
		return toAjax(spOrderGoodsService.updateSpOrderGoods(spOrderGoods));
	}
	
	/**
	 * 删除订单商品
	 */
	@RequiresPermissions("spadmin:spOrderGoods:remove")
	@Log(title = "订单商品", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(spOrderGoodsService.deleteSpOrderGoodsByIds(ids));
	}
	
}
