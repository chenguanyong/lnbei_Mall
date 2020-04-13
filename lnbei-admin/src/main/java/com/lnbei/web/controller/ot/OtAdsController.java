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
import com.lnbei.ot.domain.OtAds;
import com.lnbei.ot.service.IOtAdsService;
import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.page.TableDataInfo;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.utils.poi.ExcelUtil;

/**
 * 广告 信息操作处理
 * 
 * @author lnbei
 * @date 2020-04-10
 */
@Controller
@RequestMapping("/ot/otAds")
public class OtAdsController extends BaseController
{
    private String prefix = "ot/otAds";
	
	@Autowired
	private IOtAdsService otAdsService;
	
	@RequiresPermissions("ot:otAds:view")
	@GetMapping()
	public String otAds()
	{
	    return prefix + "/otAds";
	}
	
	/**
	 * 查询广告列表
	 */
	@RequiresPermissions("ot:otAds:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(OtAds otAds)
	{
		startPage();
        List<OtAds> list = otAdsService.selectOtAdsList(otAds);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出广告列表
	 */
	@RequiresPermissions("ot:otAds:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(OtAds otAds)
    {
    	List<OtAds> list = otAdsService.selectOtAdsList(otAds);
        ExcelUtil<OtAds> util = new ExcelUtil<OtAds>(OtAds.class);
        return util.exportExcel(list, "otAds");
    }
	
	/**
	 * 新增广告
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存广告
	 */
	@RequiresPermissions("ot:otAds:add")
	@Log(title = "广告", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(OtAds otAds)
	{		
		return toAjax(otAdsService.insertOtAds(otAds));
	}

	/**
	 * 修改广告
	 */
	@GetMapping("/edit/{mid}")
	public String edit(@PathVariable("mid") String mid, ModelMap mmap)
	{
		OtAds otAds = otAdsService.selectOtAdsById(mid);
		mmap.put("otAds", otAds);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存广告
	 */
	@RequiresPermissions("ot:otAds:edit")
	@Log(title = "广告", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(OtAds otAds)
	{		
		return toAjax(otAdsService.updateOtAds(otAds));
	}
	
	/**
	 * 删除广告
	 */
	@RequiresPermissions("ot:otAds:remove")
	@Log(title = "广告", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(otAdsService.deleteOtAdsByIds(ids));
	}
	
}
