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
import com.lnbei.fi.domain.FiDayMemberBonusDetail;
import com.lnbei.fi.service.IFiDayMemberBonusDetailService;
import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.page.TableDataInfo;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.utils.poi.ExcelUtil;
import org.springframework.stereotype.Controller;
/**
 * 会员每日奖金记录 信息操作处理
 * 
 * @author lnbei
 * @date 2020-02-13
 */
@Controller
@RequestMapping("/fi/fiDayMemberBonusDetail")
public class FiDayMemberBonusDetailController extends BaseController
{
    private String prefix = "fi/fiDayMemberBonusDetail";
	
	@Autowired
	private IFiDayMemberBonusDetailService fiDayMemberBonusDetailService;
	
	@RequiresPermissions("fi:fiDayMemberBonusDetail:view")
	@GetMapping()
	public String fiDayMemberBonusDetail()
	{
	    return prefix + "/fiDayMemberBonusDetail";
	}
	
	/**
	 * 查询会员每日奖金记录列表
	 */
	@RequiresPermissions("fi:fiDayMemberBonusDetail:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(FiDayMemberBonusDetail fiDayMemberBonusDetail)
	{
		startPage();
        List<FiDayMemberBonusDetail> list = fiDayMemberBonusDetailService.selectFiDayMemberBonusDetailList(fiDayMemberBonusDetail);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出会员每日奖金记录列表
	 */
	@RequiresPermissions("fi:fiDayMemberBonusDetail:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FiDayMemberBonusDetail fiDayMemberBonusDetail)
    {
    	List<FiDayMemberBonusDetail> list = fiDayMemberBonusDetailService.selectFiDayMemberBonusDetailList(fiDayMemberBonusDetail);
        ExcelUtil<FiDayMemberBonusDetail> util = new ExcelUtil<FiDayMemberBonusDetail>(FiDayMemberBonusDetail.class);
        return util.exportExcel(list, "fiDayMemberBonusDetail");
    }
	
	/**
	 * 新增会员每日奖金记录
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存会员每日奖金记录
	 */
	@RequiresPermissions("fi:fiDayMemberBonusDetail:add")
	@Log(title = "会员每日奖金记录", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(FiDayMemberBonusDetail fiDayMemberBonusDetail)
	{		
		return toAjax(fiDayMemberBonusDetailService.insertFiDayMemberBonusDetail(fiDayMemberBonusDetail));
	}

	/**
	 * 修改会员每日奖金记录
	 */
	@GetMapping("/edit/{mid}")
	public String edit(@PathVariable("mid") String mid, ModelMap mmap)
	{
		FiDayMemberBonusDetail fiDayMemberBonusDetail = fiDayMemberBonusDetailService.selectFiDayMemberBonusDetailById(mid);
		mmap.put("fiDayMemberBonusDetail", fiDayMemberBonusDetail);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存会员每日奖金记录
	 */
	@RequiresPermissions("fi:fiDayMemberBonusDetail:edit")
	@Log(title = "会员每日奖金记录", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(FiDayMemberBonusDetail fiDayMemberBonusDetail)
	{		
		return toAjax(fiDayMemberBonusDetailService.updateFiDayMemberBonusDetail(fiDayMemberBonusDetail));
	}
	
	/**
	 * 删除会员每日奖金记录
	 */
	@RequiresPermissions("fi:fiDayMemberBonusDetail:remove")
	@Log(title = "会员每日奖金记录", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(fiDayMemberBonusDetailService.deleteFiDayMemberBonusDetailByIds(ids));
	}
	
}
