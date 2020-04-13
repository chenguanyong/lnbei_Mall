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
import com.lnbei.sp.domain.SpShopApplys;
import com.lnbei.sp.service.ISpShopApplysService;
import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.page.TableDataInfo;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.utils.poi.ExcelUtil;

/**
 * 店铺申请 信息操作处理
 * 
 * @author lnbei
 * @date 2020-02-05
 */
@Controller
@RequestMapping("/spadmin/spShopApplys")
public class SpShopApplysController extends BaseController
{
    private String prefix = "sp/spShopApplys";
	
	@Autowired
	private ISpShopApplysService spShopApplysService;
	
	@RequiresPermissions("spadmin:spShopApplys:view")
	@GetMapping()
	public String spShopApplys()
	{
	    return prefix + "/spShopApplys";
	}
	
	/**
	 * 查询店铺申请列表
	 */
	@RequiresPermissions("spadmin:spShopApplys:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SpShopApplys spShopApplys)
	{
		startPage();
        List<SpShopApplys> list = spShopApplysService.selectSpShopApplysList(spShopApplys);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出店铺申请列表
	 */
	@RequiresPermissions("spadmin:spShopApplys:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SpShopApplys spShopApplys)
    {
    	List<SpShopApplys> list = spShopApplysService.selectSpShopApplysList(spShopApplys);
        ExcelUtil<SpShopApplys> util = new ExcelUtil<SpShopApplys>(SpShopApplys.class);
        return util.exportExcel(list, "spShopApplys");
    }
	
	/**
	 * 新增店铺申请
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存店铺申请
	 */
	@RequiresPermissions("spadmin:spShopApplys:add")
	@Log(title = "店铺申请", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(SpShopApplys spShopApplys)
	{		
		return toAjax(spShopApplysService.insertSpShopApplys(spShopApplys));
	}

	/**
	 * 修改店铺申请
	 */
	@GetMapping("/edit/{mid}")
	public String edit(@PathVariable("mid") String mid, ModelMap mmap)
	{
		SpShopApplys spShopApplys = spShopApplysService.selectSpShopApplysById(mid);
		mmap.put("spShopApplys", spShopApplys);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存店铺申请
	 */
	@RequiresPermissions("spadmin:spShopApplys:edit")
	@Log(title = "店铺申请", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(SpShopApplys spShopApplys)
	{		
		return toAjax(spShopApplysService.updateSpShopApplys(spShopApplys));
	}
	
	/**
	 * 删除店铺申请
	 */
	@RequiresPermissions("spadmin:spShopApplys:remove")
	@Log(title = "店铺申请", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(spShopApplysService.deleteSpShopApplysByIds(ids));
	}
	
}
