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
import com.lnbei.sp.domain.SpShopFlows;
import com.lnbei.sp.service.ISpShopFlowsService;
import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.page.TableDataInfo;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.utils.poi.ExcelUtil;

/**
 * 商铺流程 信息操作处理
 * 
 * @author lnbei
 * @date 2020-02-05
 */
@Controller
@RequestMapping("/spadmin/spShopFlows")
public class SpShopFlowsController extends BaseController
{
    private String prefix = "sp/spShopFlows";
	
	@Autowired
	private ISpShopFlowsService spShopFlowsService;
	
	@RequiresPermissions("spadmin:spShopFlows:view")
	@GetMapping()
	public String spShopFlows()
	{
	    return prefix + "/spShopFlows";
	}
	
	/**
	 * 查询商铺流程列表
	 */
	@RequiresPermissions("spadmin:spShopFlows:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SpShopFlows spShopFlows)
	{
		startPage();
        List<SpShopFlows> list = spShopFlowsService.selectSpShopFlowsList(spShopFlows);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出商铺流程列表
	 */
	@RequiresPermissions("spadmin:spShopFlows:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SpShopFlows spShopFlows)
    {
    	List<SpShopFlows> list = spShopFlowsService.selectSpShopFlowsList(spShopFlows);
        ExcelUtil<SpShopFlows> util = new ExcelUtil<SpShopFlows>(SpShopFlows.class);
        return util.exportExcel(list, "spShopFlows");
    }
	
	/**
	 * 新增商铺流程
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存商铺流程
	 */
	@RequiresPermissions("spadmin:spShopFlows:add")
	@Log(title = "商铺流程", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(SpShopFlows spShopFlows)
	{		
		return toAjax(spShopFlowsService.insertSpShopFlows(spShopFlows));
	}

	/**
	 * 修改商铺流程
	 */
	@GetMapping("/edit/{mid}")
	public String edit(@PathVariable("mid") String mid, ModelMap mmap)
	{
		SpShopFlows spShopFlows = spShopFlowsService.selectSpShopFlowsById(mid);
		mmap.put("spShopFlows", spShopFlows);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存商铺流程
	 */
	@RequiresPermissions("spadmin:spShopFlows:edit")
	@Log(title = "商铺流程", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(SpShopFlows spShopFlows)
	{		
		return toAjax(spShopFlowsService.updateSpShopFlows(spShopFlows));
	}
	
	/**
	 * 删除商铺流程
	 */
	@RequiresPermissions("spadmin:spShopFlows:remove")
	@Log(title = "商铺流程", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(spShopFlowsService.deleteSpShopFlowsByIds(ids));
	}
	
}
