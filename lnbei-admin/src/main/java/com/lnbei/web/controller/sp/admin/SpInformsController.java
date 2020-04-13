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
import com.lnbei.sp.domain.SpInforms;
import com.lnbei.sp.service.ISpInformsService;
import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.page.TableDataInfo;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.utils.poi.ExcelUtil;

/**
 * 举报管理 信息操作处理
 * 
 * @author lnbei
 * @date 2020-02-23
 */
@Controller
@RequestMapping("/spadmin/spInforms")
public class SpInformsController extends BaseController
{
    private String prefix = "sp/spInforms";
	
	@Autowired
	private ISpInformsService spInformsService;
	
	@RequiresPermissions("spadmin:spInforms:view")
	@GetMapping()
	public String spInforms()
	{
	    return prefix + "/spInforms";
	}
	
	/**
	 * 查询举报管理列表
	 */
	@RequiresPermissions("spadmin:spInforms:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SpInforms spInforms)
	{
		startPage();
        List<SpInforms> list = spInformsService.selectSpInformsList(spInforms);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出举报管理列表
	 */
	@RequiresPermissions("spadmin:spInforms:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SpInforms spInforms)
    {
    	List<SpInforms> list = spInformsService.selectSpInformsList(spInforms);
        ExcelUtil<SpInforms> util = new ExcelUtil<SpInforms>(SpInforms.class);
        return util.exportExcel(list, "spInforms");
    }
	
	/**
	 * 新增举报管理
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存举报管理
	 */
	@RequiresPermissions("spadmin:spInforms:add")
	@Log(title = "举报管理", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(SpInforms spInforms)
	{		
		return toAjax(spInformsService.insertSpInforms(spInforms));
	}

	/**
	 * 修改举报管理
	 */
	@GetMapping("/edit/{mid}")
	public String edit(@PathVariable("mid") String mid, ModelMap mmap)
	{
		SpInforms spInforms = spInformsService.selectSpInformsById(mid);
		mmap.put("spInforms", spInforms);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存举报管理
	 */
	@RequiresPermissions("spadmin:spInforms:edit")
	@Log(title = "举报管理", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(SpInforms spInforms)
	{		
		return toAjax(spInformsService.updateSpInforms(spInforms));
	}
	
	/**
	 * 删除举报管理
	 */
	@RequiresPermissions("spadmin:spInforms:remove")
	@Log(title = "举报管理", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(spInformsService.deleteSpInformsByIds(ids));
	}
	
}
