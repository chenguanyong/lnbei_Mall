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
import com.lnbei.system.domain.SysDept;
import com.lnbei.system.domain.SysLine;
import com.lnbei.system.service.ISysDeptService;
import com.lnbei.system.service.ISysLineService;
import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.page.TableDataInfo;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.core.domain.Ztree;
import com.lnbei.common.utils.poi.ExcelUtil;
import com.lnbei.framework.util.ShiroUtils;

import org.springframework.stereotype.Controller;
/**
 * 线 信息操作处理
 * 
 * @author lnbei
 * @date 2019-03-11
 */
@Controller
@RequestMapping("/system/sysLine")
public class SysLineController extends BaseController
{
    private String prefix = "system/sysLine";
	
	@Autowired
	private ISysLineService sysLineService;
	@Autowired
	private ISysDeptService sysDeptService;
	
	@RequiresPermissions("system:sysLine:view")
	@GetMapping()
	public String sysLine()
	{
	    return prefix + "/sysLine";
	}
	
	/**
	 * 查询线列表
	 */
	@RequiresPermissions("system:sysLine:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SysLine sysLine)
	{
		startPage();
        List<SysLine> list = sysLineService.selectLineList(sysLine);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出线列表
	 */
	@RequiresPermissions("system:sysLine:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysLine sysLine)
    {
    	List<SysLine> list = sysLineService.selectLineList(sysLine);
        ExcelUtil<SysLine> util = new ExcelUtil<SysLine>(SysLine.class);
        return util.exportExcel(list, "sysLine");
    }
	
	/**
	 * 新增线
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存线
	 */
	@RequiresPermissions("system:sysLine:add")
	@Log(title = "线别管理", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(SysLine sysLine)
	{		
		sysLine.insertData(ShiroUtils.getSysUser());
		sysLine.setCreateBy(ShiroUtils.getLoginName());
		return toAjax(sysLineService.insertLine(sysLine));
	}

	/**
	 * 修改线
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		SysLine sysLine = sysLineService.selectLineById(id);
		SysDept sysDept = sysDeptService.selectDeptById(sysLine.getOrgId());
		sysLine.setOrgName(sysDept.getName());
		mmap.put("sysLine", sysLine);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存线
	 */
	@RequiresPermissions("system:sysLine:edit")
	@Log(title = "线别管理", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(SysLine sysLine)
	{		
		return toAjax(sysLineService.updateLine(sysLine));
	}
	
	/**
	 * 删除线
	 */
	@RequiresPermissions("system:sysLine:remove")
	@Log(title = "线别管理", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(sysLineService.deleteLineByIds(ids));
	}
	
    /**
     * 加载线别列表树
     */
    @GetMapping("/treeData")
    @ResponseBody
	public List<Ztree> treeData()
	{
		List<Ztree> mList = sysLineService.getSysLineZtreeList();
		return mList;
	} 
	
}
