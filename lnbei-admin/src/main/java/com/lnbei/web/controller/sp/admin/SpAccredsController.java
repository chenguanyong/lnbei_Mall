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
import com.lnbei.sp.domain.SpAccreds;
import com.lnbei.sp.service.ISpAccredsService;
import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.page.TableDataInfo;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.utils.poi.ExcelUtil;
import com.lnbei.framework.util.ShiroUtils;

/**
 * 店铺认证 信息操作处理
 * 
 * @author lnbei
 * @date 2020-02-23
 */
@Controller
@RequestMapping("/spadmin/spAccreds")
public class SpAccredsController extends BaseController
{
    private String prefix = "sp/spAccreds";
	
	@Autowired
	private ISpAccredsService spAccredsService;
	
	@RequiresPermissions("spadmin:spAccreds:view")
	@GetMapping()
	public String spAccreds()
	{
	    return prefix + "/spAccreds";
	}
	
	/**
	 * 查询店铺认证列表
	 */
	@RequiresPermissions("spadmin:spAccreds:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SpAccreds spAccreds)
	{
		startPage();
        List<SpAccreds> list = spAccredsService.selectSpAccredsList(spAccreds);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出店铺认证列表
	 */
	@RequiresPermissions("spadmin:spAccreds:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SpAccreds spAccreds)
    {
    	List<SpAccreds> list = spAccredsService.selectSpAccredsList(spAccreds);
        ExcelUtil<SpAccreds> util = new ExcelUtil<SpAccreds>(SpAccreds.class);
        return util.exportExcel(list, "spAccreds");
    }
	
	/**
	 * 新增店铺认证
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存店铺认证
	 */
	@RequiresPermissions("spadmin:spAccreds:add")
	@Log(title = "店铺认证", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(SpAccreds spAccreds)
	{		spAccreds.initInsert(ShiroUtils.getUser());
		return toAjax(spAccredsService.insertSpAccreds(spAccreds));
	}

	/**
	 * 修改店铺认证
	 */
	@GetMapping("/edit/{mid}")
	public String edit(@PathVariable("mid") String mid, ModelMap mmap)
	{
		SpAccreds spAccreds = spAccredsService.selectSpAccredsById(mid);
		mmap.put("spAccreds", spAccreds);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存店铺认证
	 */
	@RequiresPermissions("spadmin:spAccreds:edit")
	@Log(title = "店铺认证", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(SpAccreds spAccreds)
	{		
		spAccreds.initUpdate(ShiroUtils.getUser());
		return toAjax(spAccredsService.updateSpAccreds(spAccreds));
	}
	
	/**
	 * 删除店铺认证
	 */
	@RequiresPermissions("spadmin:spAccreds:remove")
	@Log(title = "店铺认证", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(spAccredsService.deleteSpAccredsByIds(ids));
	}
	
}
