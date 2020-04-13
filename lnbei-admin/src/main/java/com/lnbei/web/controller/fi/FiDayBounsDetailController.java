package com.lnbei.web.controller.fi;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.lnbei.common.annotation.Log;
import com.lnbei.common.enums.BusinessType;
import com.lnbei.fi.domain.FiDayBounsDetail;
import com.lnbei.fi.service.IFiDayBounsDetailService;
import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.page.TableDataInfo;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.utils.poi.ExcelUtil;
import org.springframework.stereotype.Controller;
/**
 * 每日奖金记录 信息操作处理
 * 
 * @author lnbei
 * @date 2020-02-13
 */
@Controller
@RequestMapping("/fi/fiDayBounsDetail")
public class FiDayBounsDetailController extends BaseController
{
    private String prefix = "fi/fiDayBounsDetail";
	
	@Autowired
	private IFiDayBounsDetailService fiDayBounsDetailService;
	
	@RequiresPermissions("fi:fiDayBounsDetail:view")
	@GetMapping()
	public String fiDayBounsDetail()
	{
	    return prefix + "/fiDayBounsDetail";
	}
	
	/**
	 * 查询每日奖金记录列表
	 */
	@RequiresPermissions("fi:fiDayBounsDetail:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(FiDayBounsDetail fiDayBounsDetail)
	{
		startPage();
        List<FiDayBounsDetail> list = fiDayBounsDetailService.selectFiDayBounsDetailList(fiDayBounsDetail);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出每日奖金记录列表
	 */
	@RequiresPermissions("fi:fiDayBounsDetail:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FiDayBounsDetail fiDayBounsDetail)
    {
    	List<FiDayBounsDetail> list = fiDayBounsDetailService.selectFiDayBounsDetailList(fiDayBounsDetail);
        ExcelUtil<FiDayBounsDetail> util = new ExcelUtil<FiDayBounsDetail>(FiDayBounsDetail.class);
        return util.exportExcel(list, "fiDayBounsDetail");
    }
	
	/**
	 * 新增每日奖金记录
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存每日奖金记录
	 */
	@RequiresPermissions("fi:fiDayBounsDetail:add")
	@Log(title = "每日奖金记录", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(FiDayBounsDetail fiDayBounsDetail)
	{		
		return toAjax(fiDayBounsDetailService.insertFiDayBounsDetail(fiDayBounsDetail));
	}

	/**
	 * 修改每日奖金记录
	 */
	@GetMapping("/edit/{mid}")
	public String edit(@PathVariable("mid") String mid, ModelMap mmap)
	{
		FiDayBounsDetail fiDayBounsDetail = fiDayBounsDetailService.selectFiDayBounsDetailById(mid);
		mmap.put("fiDayBounsDetail", fiDayBounsDetail);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存每日奖金记录
	 */
	@RequiresPermissions("fi:fiDayBounsDetail:edit")
	@Log(title = "每日奖金记录", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(FiDayBounsDetail fiDayBounsDetail)
	{		
		return toAjax(fiDayBounsDetailService.updateFiDayBounsDetail(fiDayBounsDetail));
	}
	
	/**
	 * 删除每日奖金记录
	 */
	@RequiresPermissions("fi:fiDayBounsDetail:remove")
	@Log(title = "每日奖金记录", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(fiDayBounsDetailService.deleteFiDayBounsDetailByIds(ids));
	}
	
}
