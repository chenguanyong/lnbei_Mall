package com.lnbei.web.controller.ot;

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
import com.lnbei.ot.domain.OtCarouselPositions;
import com.lnbei.ot.service.IOtCarouselPositionsService;
import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.page.TableDataInfo;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.utils.poi.ExcelUtil;

/**
 * 轮播图位置 信息操作处理
 * 
 * @author lnbei
 * @date 2020-04-10
 */
@Controller
@RequestMapping("/ot/otCarouselPositions")
public class OtCarouselPositionsController extends BaseController
{
    private String prefix = "ot/otCarouselPositions";
	
	@Autowired
	private IOtCarouselPositionsService otCarouselPositionsService;
	
	@RequiresPermissions("ot:otCarouselPositions:view")
	@GetMapping()
	public String otCarouselPositions()
	{
	    return prefix + "/otCarouselPositions";
	}
	
	/**
	 * 查询轮播图位置列表
	 */
	@RequiresPermissions("ot:otCarouselPositions:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(OtCarouselPositions otCarouselPositions)
	{
		startPage();
        List<OtCarouselPositions> list = otCarouselPositionsService.selectOtCarouselPositionsList(otCarouselPositions);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出轮播图位置列表
	 */
	@RequiresPermissions("ot:otCarouselPositions:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(OtCarouselPositions otCarouselPositions)
    {
    	List<OtCarouselPositions> list = otCarouselPositionsService.selectOtCarouselPositionsList(otCarouselPositions);
        ExcelUtil<OtCarouselPositions> util = new ExcelUtil<OtCarouselPositions>(OtCarouselPositions.class);
        return util.exportExcel(list, "otCarouselPositions");
    }
	
	/**
	 * 新增轮播图位置
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存轮播图位置
	 */
	@RequiresPermissions("ot:otCarouselPositions:add")
	@Log(title = "轮播图位置", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(OtCarouselPositions otCarouselPositions)
	{		
		return toAjax(otCarouselPositionsService.insertOtCarouselPositions(otCarouselPositions));
	}

	/**
	 * 修改轮播图位置
	 */
	@GetMapping("/edit/{mid}")
	public String edit(@PathVariable("mid") String mid, ModelMap mmap)
	{
		OtCarouselPositions otCarouselPositions = otCarouselPositionsService.selectOtCarouselPositionsById(mid);
		mmap.put("otCarouselPositions", otCarouselPositions);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存轮播图位置
	 */
	@RequiresPermissions("ot:otCarouselPositions:edit")
	@Log(title = "轮播图位置", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(OtCarouselPositions otCarouselPositions)
	{		
		return toAjax(otCarouselPositionsService.updateOtCarouselPositions(otCarouselPositions));
	}
	
	/**
	 * 删除轮播图位置
	 */
	@RequiresPermissions("ot:otCarouselPositions:remove")
	@Log(title = "轮播图位置", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(otCarouselPositionsService.deleteOtCarouselPositionsByIds(ids));
	}
	
}
