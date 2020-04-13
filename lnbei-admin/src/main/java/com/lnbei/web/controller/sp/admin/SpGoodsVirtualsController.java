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
import com.lnbei.sp.domain.SpGoodsVirtuals;
import com.lnbei.sp.service.ISpGoodsVirtualsService;
import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.page.TableDataInfo;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.utils.poi.ExcelUtil;

/**
 * 优惠劵 信息操作处理
 * 
 * @author lnbei
 * @date 2020-02-05
 */
@Controller
@RequestMapping("/spadmin/spGoodsVirtuals")
public class SpGoodsVirtualsController extends BaseController
{
    private String prefix = "sp/spGoodsVirtuals";
	
	@Autowired
	private ISpGoodsVirtualsService spGoodsVirtualsService;
	
	@RequiresPermissions("spadmin:spGoodsVirtuals:view")
	@GetMapping()
	public String spGoodsVirtuals()
	{
	    return prefix + "/spGoodsVirtuals";
	}
	
	/**
	 * 查询优惠劵列表
	 */
	@RequiresPermissions("spadmin:spGoodsVirtuals:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SpGoodsVirtuals spGoodsVirtuals)
	{
		startPage();
        List<SpGoodsVirtuals> list = spGoodsVirtualsService.selectSpGoodsVirtualsList(spGoodsVirtuals);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出优惠劵列表
	 */
	@RequiresPermissions("spadmin:spGoodsVirtuals:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SpGoodsVirtuals spGoodsVirtuals)
    {
    	List<SpGoodsVirtuals> list = spGoodsVirtualsService.selectSpGoodsVirtualsList(spGoodsVirtuals);
        ExcelUtil<SpGoodsVirtuals> util = new ExcelUtil<SpGoodsVirtuals>(SpGoodsVirtuals.class);
        return util.exportExcel(list, "spGoodsVirtuals");
    }
	
	/**
	 * 新增优惠劵
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存优惠劵
	 */
	@RequiresPermissions("spadmin:spGoodsVirtuals:add")
	@Log(title = "优惠劵", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(SpGoodsVirtuals spGoodsVirtuals)
	{		
		return toAjax(spGoodsVirtualsService.insertSpGoodsVirtuals(spGoodsVirtuals));
	}

	/**
	 * 修改优惠劵
	 */
	@GetMapping("/edit/{mid}")
	public String edit(@PathVariable("mid") String mid, ModelMap mmap)
	{
		SpGoodsVirtuals spGoodsVirtuals = spGoodsVirtualsService.selectSpGoodsVirtualsById(mid);
		mmap.put("spGoodsVirtuals", spGoodsVirtuals);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存优惠劵
	 */
	@RequiresPermissions("spadmin:spGoodsVirtuals:edit")
	@Log(title = "优惠劵", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(SpGoodsVirtuals spGoodsVirtuals)
	{		
		return toAjax(spGoodsVirtualsService.updateSpGoodsVirtuals(spGoodsVirtuals));
	}
	
	/**
	 * 删除优惠劵
	 */
	@RequiresPermissions("spadmin:spGoodsVirtuals:remove")
	@Log(title = "优惠劵", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(spGoodsVirtualsService.deleteSpGoodsVirtualsByIds(ids));
	}
	
}
