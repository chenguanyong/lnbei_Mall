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
import com.lnbei.ot.domain.OtCarousel;
import com.lnbei.ot.service.IOtCarouselService;
import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.page.TableDataInfo;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.utils.poi.ExcelUtil;

/**
 * 轮播图 信息操作处理
 * 
 * @author lnbei
 * @date 2020-04-10
 */
@Controller
@RequestMapping("/ot/otCarousel")
public class OtCarouselController extends BaseController
{
    private String prefix = "ot/otCarousel";
	
	@Autowired
	private IOtCarouselService otCarouselService;
	
	@RequiresPermissions("ot:otCarousel:view")
	@GetMapping()
	public String otCarousel()
	{
	    return prefix + "/otCarousel";
	}
	
	/**
	 * 查询轮播图列表
	 */
	@RequiresPermissions("ot:otCarousel:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(OtCarousel otCarousel)
	{
		startPage();
        List<OtCarousel> list = otCarouselService.selectOtCarouselList(otCarousel);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出轮播图列表
	 */
	@RequiresPermissions("ot:otCarousel:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(OtCarousel otCarousel)
    {
    	List<OtCarousel> list = otCarouselService.selectOtCarouselList(otCarousel);
        ExcelUtil<OtCarousel> util = new ExcelUtil<OtCarousel>(OtCarousel.class);
        return util.exportExcel(list, "otCarousel");
    }
	
	/**
	 * 新增轮播图
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存轮播图
	 */
	@RequiresPermissions("ot:otCarousel:add")
	@Log(title = "轮播图", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(OtCarousel otCarousel)
	{		
		return toAjax(otCarouselService.insertOtCarousel(otCarousel));
	}

	/**
	 * 修改轮播图
	 */
	@GetMapping("/edit/{mid}")
	public String edit(@PathVariable("mid") String mid, ModelMap mmap)
	{
		OtCarousel otCarousel = otCarouselService.selectOtCarouselById(mid);
		mmap.put("otCarousel", otCarousel);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存轮播图
	 */
	@RequiresPermissions("ot:otCarousel:edit")
	@Log(title = "轮播图", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(OtCarousel otCarousel)
	{		
		return toAjax(otCarouselService.updateOtCarousel(otCarousel));
	}
	
	/**
	 * 删除轮播图
	 */
	@RequiresPermissions("ot:otCarousel:remove")
	@Log(title = "轮播图", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(otCarouselService.deleteOtCarouselByIds(ids));
	}
	
}
