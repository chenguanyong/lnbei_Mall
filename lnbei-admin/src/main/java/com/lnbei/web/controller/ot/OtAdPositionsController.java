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
import com.lnbei.ot.domain.OtAdPositions;
import com.lnbei.ot.service.IOtAdPositionsService;
import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.page.TableDataInfo;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.utils.poi.ExcelUtil;

/**
 * 广告位置 信息操作处理
 * 
 * @author lnbei
 * @date 2020-04-10
 */
@Controller
@RequestMapping("/ot/otAdPositions")
public class OtAdPositionsController extends BaseController
{
    private String prefix = "ot/otAdPositions";
	
	@Autowired
	private IOtAdPositionsService otAdPositionsService;
	
	@RequiresPermissions("ot:otAdPositions:view")
	@GetMapping()
	public String otAdPositions()
	{
	    return prefix + "/otAdPositions";
	}
	
	/**
	 * 查询广告位置列表
	 */
	@RequiresPermissions("ot:otAdPositions:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(OtAdPositions otAdPositions)
	{
		startPage();
        List<OtAdPositions> list = otAdPositionsService.selectOtAdPositionsList(otAdPositions);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出广告位置列表
	 */
	@RequiresPermissions("ot:otAdPositions:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(OtAdPositions otAdPositions)
    {
    	List<OtAdPositions> list = otAdPositionsService.selectOtAdPositionsList(otAdPositions);
        ExcelUtil<OtAdPositions> util = new ExcelUtil<OtAdPositions>(OtAdPositions.class);
        return util.exportExcel(list, "otAdPositions");
    }
	
	/**
	 * 新增广告位置
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存广告位置
	 */
	@RequiresPermissions("ot:otAdPositions:add")
	@Log(title = "广告位置", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(OtAdPositions otAdPositions)
	{		
		return toAjax(otAdPositionsService.insertOtAdPositions(otAdPositions));
	}

	/**
	 * 修改广告位置
	 */
	@GetMapping("/edit/{mid}")
	public String edit(@PathVariable("mid") String mid, ModelMap mmap)
	{
		OtAdPositions otAdPositions = otAdPositionsService.selectOtAdPositionsById(mid);
		mmap.put("otAdPositions", otAdPositions);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存广告位置
	 */
	@RequiresPermissions("ot:otAdPositions:edit")
	@Log(title = "广告位置", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(OtAdPositions otAdPositions)
	{		
		return toAjax(otAdPositionsService.updateOtAdPositions(otAdPositions));
	}
	
	/**
	 * 删除广告位置
	 */
	@RequiresPermissions("ot:otAdPositions:remove")
	@Log(title = "广告位置", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(otAdPositionsService.deleteOtAdPositionsByIds(ids));
	}
	
}
