package com.lnbei.web.controller.system;

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
import com.lnbei.system.domain.ConfigTree;

import com.lnbei.system.service.IConfigTreeService;
import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.page.TableDataInfo;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.core.domain.Ztree;
import com.lnbei.common.utils.poi.ExcelUtil;
import com.lnbei.framework.util.ShiroUtils;

/**
 * 配置树 信息操作处理
 * 
 * @author lnbei
 * @date 2019-12-25
 */
@Controller
@RequestMapping("/system/configTree")
public class ConfigTreeController extends BaseController
{
    private String prefix = "system/configTree";
	
	@Autowired
	private IConfigTreeService configTreeService;
	
	@RequiresPermissions("system:configTree:view")
	@GetMapping()
	public String configTree()
	{
	    return prefix + "/configTree";
	}
	
	/**
	 * 查询配置树列表
	 */
	@RequiresPermissions("system:configTree:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(ConfigTree configTree)
	{
		startPage();
        List<ConfigTree> list = configTreeService.selectConfigTreeList(configTree);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出配置树列表
	 */
	@RequiresPermissions("system:configTree:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ConfigTree configTree)
    {
    	List<ConfigTree> list = configTreeService.selectConfigTreeList(configTree);
        ExcelUtil<ConfigTree> util = new ExcelUtil<ConfigTree>(ConfigTree.class);
        return util.exportExcel(list, "configTree");
    }
	
	/**
	 * 新增配置树
	 */
	@GetMapping("/add/{id}")
	public String add(@PathVariable("id")String id, ModelMap map)
	{
		if(!id.equals("0")) {
			ConfigTree mConfigTree = configTreeService.selectConfigTreeById(id);
			map.put("id", mConfigTree.getId());
		}else {
			map.put("id",0);
		}
		
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存配置树
	 */
	@RequiresPermissions("system:configTree:add")
	@Log(title = "配置树", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(ConfigTree configTree)
	{		
		return toAjax(configTreeService.insertConfigTree(configTree));
	}

	/**
	 * 修改配置树
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		ConfigTree configTree = configTreeService.selectConfigTreeById(id);
		mmap.put("configTree", configTree);
	
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存配置树
	 */
	@RequiresPermissions("system:configTree:edit")
	@Log(title = "配置树", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(ConfigTree configTree)
	{		
		return toAjax(configTreeService.updateConfigTree(configTree));
	}
	
	/**
	 * 删除配置树
	 */
	@RequiresPermissions("system:configTree:remove")
	@Log(title = "配置树", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(configTreeService.deleteConfigTreeByIds(ids));
	}
    /**
     * 加载部门列表树
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<Ztree> treeData()
    {
        List<Ztree> ztrees = configTreeService.selectConfigTree(new ConfigTree());
        return ztrees;
    }
    /**
     * 修改排序值
     * @return
     */
    @Log(title = "配置树管理", businessType = BusinessType.UPDATE)
    @RequiresPermissions("system:configTree:editSort")
    @GetMapping("/editSort/{id}")
    public String editSort(@PathVariable("id") String id, ModelMap mmMap ) {
    	mmMap.put("dept", configTreeService.selectConfigTreeById(id));
    	return prefix + "/editSort";
    }
    /**
     * 保存排序值
     */
    @Log(title = "配置树管理", businessType = BusinessType.UPDATE)
    @RequiresPermissions("system:configTree:editSort")
    @PostMapping("/sortSave")
    @ResponseBody
    public AjaxResult editSortSave(ConfigTree mConfigTree)
    {
    	mConfigTree.setUpdateBy(ShiroUtils.getLoginName());
        //oaMessageLogService.sendMsg("dept", dept.getId(), 1, 0);//向子系统发送消息
        return toAjax(configTreeService.updateConfigTree(mConfigTree));
    }
}
