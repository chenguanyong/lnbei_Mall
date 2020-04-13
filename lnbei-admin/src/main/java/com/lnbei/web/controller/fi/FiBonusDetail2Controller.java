package com.lnbei.web.controller.fi;

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
import com.lnbei.fi.domain.FiBonusDetail2;
import com.lnbei.fi.service.IFiBonusDetail2Service;
import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.page.TableDataInfo;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.utils.poi.ExcelUtil;

/**
 * 奖金明细 信息操作处理
 * 
 * @author lnbei
 * @date 2020-02-13
 */
@Controller
@RequestMapping("/fi/fiBonusDetail2")
public class FiBonusDetail2Controller extends BaseController
{
    private String prefix = "fi/fiBonusDetail2";
	
	@Autowired
	private IFiBonusDetail2Service fiBonusDetail2Service;
	
	@RequiresPermissions("fi:fiBonusDetail2:view")
	@GetMapping()
	public String fiBonusDetail2()
	{
	    return prefix + "/fiBonusDetail2";
	}
	
	/**
	 * 查询奖金明细列表
	 */
	@RequiresPermissions("fi:fiBonusDetail2:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(FiBonusDetail2 fiBonusDetail2)
	{
		startPage();
        List<FiBonusDetail2> list = fiBonusDetail2Service.selectFiBonusDetail2List(fiBonusDetail2);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出奖金明细列表
	 */
	@RequiresPermissions("fi:fiBonusDetail2:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FiBonusDetail2 fiBonusDetail2)
    {
    	List<FiBonusDetail2> list = fiBonusDetail2Service.selectFiBonusDetail2List(fiBonusDetail2);
        ExcelUtil<FiBonusDetail2> util = new ExcelUtil<FiBonusDetail2>(FiBonusDetail2.class);
        return util.exportExcel(list, "fiBonusDetail2");
    }
	
	/**
	 * 新增奖金明细
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存奖金明细
	 */
	@RequiresPermissions("fi:fiBonusDetail2:add")
	@Log(title = "奖金明细", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(FiBonusDetail2 fiBonusDetail2)
	{		
		return toAjax(fiBonusDetail2Service.insertFiBonusDetail2(fiBonusDetail2));
	}

	/**
	 * 修改奖金明细
	 */
	@GetMapping("/edit/{mid}")
	public String edit(@PathVariable("mid") String mid, ModelMap mmap)
	{
		FiBonusDetail2 fiBonusDetail2 = fiBonusDetail2Service.selectFiBonusDetail2ById(mid);
		mmap.put("fiBonusDetail2", fiBonusDetail2);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存奖金明细
	 */
	@RequiresPermissions("fi:fiBonusDetail2:edit")
	@Log(title = "奖金明细", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(FiBonusDetail2 fiBonusDetail2)
	{		
		return toAjax(fiBonusDetail2Service.updateFiBonusDetail2(fiBonusDetail2));
	}
	
	/**
	 * 删除奖金明细
	 */
	@RequiresPermissions("fi:fiBonusDetail2:remove")
	@Log(title = "奖金明细", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(fiBonusDetail2Service.deleteFiBonusDetail2ByIds(ids));
	}
	
}
