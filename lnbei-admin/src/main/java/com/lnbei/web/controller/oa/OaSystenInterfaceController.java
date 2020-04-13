package com.lnbei.web.controller.oa;

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
import com.lnbei.oa.domain.OaSystem;
import com.lnbei.oa.domain.OaSystenInterface;
import com.lnbei.oa.service.IOaSystemService;
import com.lnbei.oa.service.IOaSystenInterfaceService;
import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.page.TableDataInfo;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.utils.StringUtils;
import com.lnbei.common.utils.poi.ExcelUtil;
import com.lnbei.framework.util.ShiroUtils;

/**
 * 接口管理 信息操作处理
 * 
 * @author lnbei
 * @date 2019-03-19
 */
@Controller
@RequestMapping("/oa/oaSystenInterface")
public class OaSystenInterfaceController extends BaseController
{
    private String prefix = "oa/oaSystenInterface";
	
	@Autowired
	private IOaSystenInterfaceService oaSystenInterfaceService;
	@Autowired
	private IOaSystemService oaSystemService;
	
	@RequiresPermissions("oa:oaSystenInterface:view")
	@GetMapping()
	public String oaSystenInterface()
	{
	    return prefix + "/oaSystenInterface";
	}
	
	/**
	 * 查询接口管理列表
	 */
	@RequiresPermissions("oa:oaSystenInterface:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(OaSystenInterface oaSystenInterface)
	{
		startPage();
        List<OaSystenInterface> list = oaSystenInterfaceService.selectOaSystenInterfaceList(oaSystenInterface);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出接口管理列表
	 */
	@RequiresPermissions("oa:oaSystenInterface:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(OaSystenInterface oaSystenInterface)
    {
    	List<OaSystenInterface> list = oaSystenInterfaceService.selectOaSystenInterfaceList(oaSystenInterface);
        ExcelUtil<OaSystenInterface> util = new ExcelUtil<OaSystenInterface>(OaSystenInterface.class);
        return util.exportExcel(list, "oaSystenInterface");
    }
	
	/**
	 * 新增接口管理
	 */
	@GetMapping("/add/{systemId}")
	public String add(@PathVariable("systemId") String systemId, ModelMap mmMap)
	{
		if(StringUtils.isEmpty(systemId)) {
			systemId = "0";
		}
		List<OaSystem> oaSystems = oaSystemService.selectOaSystemList(new OaSystem());
		mmMap.put("systemId", systemId);
		mmMap.put("oaSystemList", oaSystems);
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存接口管理
	 */
	@RequiresPermissions("oa:oaSystenInterface:add")
	@Log(title = "接口管理", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(OaSystenInterface oaSystenInterface)
	{	
		oaSystenInterface.insertData(ShiroUtils.getSysUser());
		oaSystenInterface.setCreateBy(ShiroUtils.getLoginName());
		return toAjax(oaSystenInterfaceService.insertOaSystenInterface(oaSystenInterface));
	}

	/**
	 * 修改接口管理
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		OaSystenInterface oaSystenInterface = oaSystenInterfaceService.selectOaSystenInterfaceById(id);
		List<OaSystem> oaSystemList = oaSystemService.selectOaSystemList(null);
		mmap.put("oaSystenInterface", oaSystenInterface);
		mmap.put("oaSystemList", oaSystemList);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存接口管理
	 */
	@RequiresPermissions("oa:oaSystenInterface:edit")
	@Log(title = "接口管理", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(OaSystenInterface oaSystenInterface)
	{	
		oaSystenInterface.setUpdateBy(ShiroUtils.getLoginName());
		return toAjax(oaSystenInterfaceService.updateOaSystenInterface(oaSystenInterface));
	}
	
	/**
	 * 删除接口管理
	 */
	@RequiresPermissions("oa:oaSystenInterface:remove")
	@Log(title = "接口管理", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(oaSystenInterfaceService.deleteOaSystenInterfaceByIds(ids));
	}
	
    /**
     * 状态修改
     */
    @Log(title = "系统注册", businessType = BusinessType.UPDATE)
    @RequiresPermissions("oa:oaSystenInterface:edit")
    @PostMapping("/changeStatus")
    @ResponseBody
    public AjaxResult changeStatus(OaSystenInterface oaSystenInterface)
    {
    	oaSystenInterface.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(oaSystenInterfaceService.updateOaSystenInterface(oaSystenInterface));
    }
	
}
