package com.lnbei.web.controller.system;

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
import com.lnbei.system.domain.SysLine;
import com.lnbei.system.domain.SysStation;
import com.lnbei.system.service.ISysLineService;
import com.lnbei.system.service.ISysStationService;
import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.page.TableDataInfo;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.utils.poi.ExcelUtil;
import com.lnbei.framework.util.ShiroUtils;

import org.springframework.stereotype.Controller;

/**
 * 站 信息操作处理
 * 
 * @author lnbei
 * @date 2019-03-11
 */
@Controller
@RequestMapping("/system/sysStation")
public class SysStationController extends BaseController
{
    private String prefix = "system/sysStation";
	
	@Autowired
	private ISysStationService sysStationService;
	
	@Autowired
	private ISysLineService sysLineService;
	
	@RequiresPermissions("system:sysStation:view")
	@GetMapping()
	public String sysStation()
	{
	    return prefix + "/sysStation";
	}
	
	/**
	 * 查询站列表
	 */
	@RequiresPermissions("system:sysStation:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SysStation sysStation)
	{
		startPage();
        List<SysStation> list = sysStationService.selectSysStationList(sysStation);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出站列表
	 */
	@RequiresPermissions("system:sysStation:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysStation sysStation)
    {
    	List<SysStation> list = sysStationService.selectSysStationList(sysStation);
        ExcelUtil<SysStation> util = new ExcelUtil<SysStation>(SysStation.class);
        return util.exportExcel(list, "sysStation");
    }
	
	/**
	 * 新增站
	 */
	@GetMapping("/add/{lineId}")
	public String add(@PathVariable("lineId") String lineId, ModelMap mmMap)
	{
		List<SysLine> mSysLines = sysLineService.selectLineList(null);
		mmMap.put("sysLineList", mSysLines);
		mmMap.put("lineId", lineId);
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存站
	 */
	@RequiresPermissions("system:sysStation:add")
	@Log(title = "站", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(SysStation sysStation)
	{	
		sysStation.insertData(ShiroUtils.getSysUser());
		return toAjax(sysStationService.insertSysStation(sysStation));
	}

	/**
	 * 修改站
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		SysStation sysStation = sysStationService.selectSysStationById(id);
		mmap.put("sysStation", sysStation);
		List<SysLine> mSysLines = sysLineService.selectLineList(null);
		mmap.put("sysLineList", mSysLines);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存站
	 */
	@RequiresPermissions("system:sysStation:edit")
	@Log(title = "站", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(SysStation sysStation)
	{		
		sysStation.setUpdateBy(ShiroUtils.getLoginName());
		return toAjax(sysStationService.updateSysStation(sysStation));
	}
	
	/**
	 * 删除站
	 */
	@RequiresPermissions("system:sysStation:remove")
	@Log(title = "站", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(sysStationService.deleteSysStationByIds(ids));
	}
	
}
