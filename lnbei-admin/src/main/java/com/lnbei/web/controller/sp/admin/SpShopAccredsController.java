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
import com.lnbei.sp.domain.SpShopAccreds;
import com.lnbei.sp.service.ISpShopAccredsService;
import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.page.TableDataInfo;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.utils.poi.ExcelUtil;

/**
 * 店铺认证 信息操作处理
 * 
 * @author lnbei
 * @date 2020-02-05
 */
@Controller
@RequestMapping("/spadmin/spShopAccreds")
public class SpShopAccredsController extends BaseController
{
    private String prefix = "sp/spShopAccreds";
	
	@Autowired
	private ISpShopAccredsService spShopAccredsService;
	
	@RequiresPermissions("spadmin:spShopAccreds:view")
	@GetMapping()
	public String spShopAccreds()
	{
	    return prefix + "/spShopAccreds";
	}
	
	/**
	 * 查询店铺认证列表
	 */
	@RequiresPermissions("spadmin:spShopAccreds:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SpShopAccreds spShopAccreds)
	{
		startPage();
        List<SpShopAccreds> list = spShopAccredsService.selectSpShopAccredsList(spShopAccreds);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出店铺认证列表
	 */
	@RequiresPermissions("spadmin:spShopAccreds:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SpShopAccreds spShopAccreds)
    {
    	List<SpShopAccreds> list = spShopAccredsService.selectSpShopAccredsList(spShopAccreds);
        ExcelUtil<SpShopAccreds> util = new ExcelUtil<SpShopAccreds>(SpShopAccreds.class);
        return util.exportExcel(list, "spShopAccreds");
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
	@RequiresPermissions("spadmin:spShopAccreds:add")
	@Log(title = "店铺认证", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(SpShopAccreds spShopAccreds)
	{		
		return toAjax(spShopAccredsService.insertSpShopAccreds(spShopAccreds));
	}

	/**
	 * 修改店铺认证
	 */
	@GetMapping("/edit/{mid}")
	public String edit(@PathVariable("mid") String mid, ModelMap mmap)
	{
		SpShopAccreds spShopAccreds = spShopAccredsService.selectSpShopAccredsById(mid);
		mmap.put("spShopAccreds", spShopAccreds);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存店铺认证
	 */
	@RequiresPermissions("spadmin:spShopAccreds:edit")
	@Log(title = "店铺认证", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(SpShopAccreds spShopAccreds)
	{		
		return toAjax(spShopAccredsService.updateSpShopAccreds(spShopAccreds));
	}
	
	/**
	 * 删除店铺认证
	 */
	@RequiresPermissions("spadmin:spShopAccreds:remove")
	@Log(title = "店铺认证", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(spShopAccredsService.deleteSpShopAccredsByIds(ids));
	}
	
}
