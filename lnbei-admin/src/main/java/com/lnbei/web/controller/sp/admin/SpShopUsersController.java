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
import com.lnbei.sp.domain.SpShopUsers;
import com.lnbei.sp.service.ISpShopUsersService;
import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.page.TableDataInfo;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.utils.poi.ExcelUtil;

/**
 * 店铺用户关系 信息操作处理
 * 
 * @author lnbei
 * @date 2020-02-05
 */
@Controller
@RequestMapping("/spadmin/spShopUsers")
public class SpShopUsersController extends BaseController
{
    private String prefix = "sp/spShopUsers";
	
	@Autowired
	private ISpShopUsersService spShopUsersService;
	
	@RequiresPermissions("spadmin:spShopUsers:view")
	@GetMapping()
	public String spShopUsers()
	{
	    return prefix + "/spShopUsers";
	}
	
	/**
	 * 查询店铺用户关系列表
	 */
	@RequiresPermissions("spadmin:spShopUsers:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SpShopUsers spShopUsers)
	{
		startPage();
        List<SpShopUsers> list = spShopUsersService.selectSpShopUsersList(spShopUsers);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出店铺用户关系列表
	 */
	@RequiresPermissions("spadmin:spShopUsers:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SpShopUsers spShopUsers)
    {
    	List<SpShopUsers> list = spShopUsersService.selectSpShopUsersList(spShopUsers);
        ExcelUtil<SpShopUsers> util = new ExcelUtil<SpShopUsers>(SpShopUsers.class);
        return util.exportExcel(list, "spShopUsers");
    }
	
	/**
	 * 新增店铺用户关系
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存店铺用户关系
	 */
	@RequiresPermissions("spadmin:spShopUsers:add")
	@Log(title = "店铺用户关系", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(SpShopUsers spShopUsers)
	{		
		return toAjax(spShopUsersService.insertSpShopUsers(spShopUsers));
	}

	/**
	 * 修改店铺用户关系
	 */
	@GetMapping("/edit/{mid}")
	public String edit(@PathVariable("mid") String mid, ModelMap mmap)
	{
		SpShopUsers spShopUsers = spShopUsersService.selectSpShopUsersById(mid);
		mmap.put("spShopUsers", spShopUsers);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存店铺用户关系
	 */
	@RequiresPermissions("spadmin:spShopUsers:edit")
	@Log(title = "店铺用户关系", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(SpShopUsers spShopUsers)
	{		
		return toAjax(spShopUsersService.updateSpShopUsers(spShopUsers));
	}
	
	/**
	 * 删除店铺用户关系
	 */
	@RequiresPermissions("spadmin:spShopUsers:remove")
	@Log(title = "店铺用户关系", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(spShopUsersService.deleteSpShopUsersByIds(ids));
	}
	
}
