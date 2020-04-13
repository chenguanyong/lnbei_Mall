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
import com.lnbei.sp.domain.SpShopConfigs;
import com.lnbei.sp.service.ISpShopConfigsService;
import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.page.TableDataInfo;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.utils.poi.ExcelUtil;
import com.lnbei.home.domain.HomeCategory;
import com.lnbei.home.service.IHomeCategoryService;
import com.lnbei.home.service.impl.HomeCategoryServiceImpl;

/**
 * 商家配置 信息操作处理
 * 
 * @author lnbei
 * @date 2020-02-05
 */
@Controller
@RequestMapping("/spadmin/spShopConfigs")
public class SpShopConfigsController extends BaseController
{
    private String prefix = "sp/spShopConfigs";
	
	@Autowired
	private ISpShopConfigsService spShopConfigsService;

	
	@RequiresPermissions("spadmin:spShopConfigs:view")
	@GetMapping()
	public String spShopConfigs()
	{
	    return prefix + "/spShopConfigs";
	}
	
	/**
	 * 查询商家配置列表
	 */
	@RequiresPermissions("spadmin:spShopConfigs:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SpShopConfigs spShopConfigs)
	{
		startPage();
        List<SpShopConfigs> list = spShopConfigsService.selectSpShopConfigsList(spShopConfigs);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出商家配置列表
	 */
	@RequiresPermissions("spadmin:spShopConfigs:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SpShopConfigs spShopConfigs)
    {
    	List<SpShopConfigs> list = spShopConfigsService.selectSpShopConfigsList(spShopConfigs);
        ExcelUtil<SpShopConfigs> util = new ExcelUtil<SpShopConfigs>(SpShopConfigs.class);
        return util.exportExcel(list, "spShopConfigs");
    }
	
	/**
	 * 新增商家配置
	 */
	@GetMapping("/add")
	public String add(ModelMap mmMap)
	{

	    return prefix + "/add";
	}
	
	/**
	 * 新增保存商家配置
	 */
	@RequiresPermissions("spadmin:spShopConfigs:add")
	@Log(title = "商家配置", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(SpShopConfigs spShopConfigs)
	{		
		return toAjax(spShopConfigsService.insertSpShopConfigs(spShopConfigs));
	}

	/**
	 * 修改商家配置
	 */
	@GetMapping("/edit/{mid}")
	public String edit(@PathVariable("mid") String mid, ModelMap mmap)
	{
		SpShopConfigs spShopConfigs = spShopConfigsService.selectSpShopConfigsById(mid);
		mmap.put("spShopConfigs", spShopConfigs);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存商家配置
	 */
	@RequiresPermissions("spadmin:spShopConfigs:edit")
	@Log(title = "商家配置", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(SpShopConfigs spShopConfigs)
	{		
		return toAjax(spShopConfigsService.updateSpShopConfigs(spShopConfigs));
	}
	
	/**
	 * 删除商家配置
	 */
	@RequiresPermissions("spadmin:spShopConfigs:remove")
	@Log(title = "商家配置", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(spShopConfigsService.deleteSpShopConfigsByIds(ids));
	}
	
}
