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
import com.lnbei.sp.domain.SpTemplateMsgs;
import com.lnbei.sp.service.ISpTemplateMsgsService;
import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.page.TableDataInfo;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.utils.poi.ExcelUtil;

/**
 * 消息模板 信息操作处理
 * 
 * @author lnbei
 * @date 2020-02-23
 */
@Controller
@RequestMapping("/spadmin/spTemplateMsgs")
public class SpTemplateMsgsController extends BaseController
{
    private String prefix = "sp/spTemplateMsgs";
	
	@Autowired
	private ISpTemplateMsgsService spTemplateMsgsService;
	
	@RequiresPermissions("spadmin:spTemplateMsgs:view")
	@GetMapping()
	public String spTemplateMsgs()
	{
	    return prefix + "/spTemplateMsgs";
	}
	
	/**
	 * 查询消息模板列表
	 */
	@RequiresPermissions("spadmin:spTemplateMsgs:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SpTemplateMsgs spTemplateMsgs)
	{
		startPage();
        List<SpTemplateMsgs> list = spTemplateMsgsService.selectSpTemplateMsgsList(spTemplateMsgs);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出消息模板列表
	 */
	@RequiresPermissions("spadmin:spTemplateMsgs:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SpTemplateMsgs spTemplateMsgs)
    {
    	List<SpTemplateMsgs> list = spTemplateMsgsService.selectSpTemplateMsgsList(spTemplateMsgs);
        ExcelUtil<SpTemplateMsgs> util = new ExcelUtil<SpTemplateMsgs>(SpTemplateMsgs.class);
        return util.exportExcel(list, "spTemplateMsgs");
    }
	
	/**
	 * 新增消息模板
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存消息模板
	 */
	@RequiresPermissions("spadmin:spTemplateMsgs:add")
	@Log(title = "消息模板", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(SpTemplateMsgs spTemplateMsgs)
	{		
		return toAjax(spTemplateMsgsService.insertSpTemplateMsgs(spTemplateMsgs));
	}

	/**
	 * 修改消息模板
	 */
	@GetMapping("/edit/{mid}")
	public String edit(@PathVariable("mid") String mid, ModelMap mmap)
	{
		SpTemplateMsgs spTemplateMsgs = spTemplateMsgsService.selectSpTemplateMsgsById(mid);
		mmap.put("spTemplateMsgs", spTemplateMsgs);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存消息模板
	 */
	@RequiresPermissions("spadmin:spTemplateMsgs:edit")
	@Log(title = "消息模板", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(SpTemplateMsgs spTemplateMsgs)
	{		
		return toAjax(spTemplateMsgsService.updateSpTemplateMsgs(spTemplateMsgs));
	}
	
	/**
	 * 删除消息模板
	 */
	@RequiresPermissions("spadmin:spTemplateMsgs:remove")
	@Log(title = "消息模板", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(spTemplateMsgsService.deleteSpTemplateMsgsByIds(ids));
	}
	
}
