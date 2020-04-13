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
import com.lnbei.sp.domain.SpExpress;
import com.lnbei.sp.service.ISpExpressService;
import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.page.TableDataInfo;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.utils.poi.ExcelUtil;

/**
 * 快递 信息操作处理
 * 
 * @author lnbei
 * @date 2020-02-05
 */
@Controller
@RequestMapping("/spadmin/spExpress")
public class SpExpressController extends BaseController
{
    private String prefix = "sp/spExpress";
	
	@Autowired
	private ISpExpressService spExpressService;
	
	@RequiresPermissions("spadmin:spExpress:view")
	@GetMapping()
	public String spExpress()
	{
	    return prefix + "/spExpress";
	}
	
	/**
	 * 查询快递列表
	 */
	@RequiresPermissions("spadmin:spExpress:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SpExpress spExpress)
	{
		startPage();
        List<SpExpress> list = spExpressService.selectSpExpressList(spExpress);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出快递列表
	 */
	@RequiresPermissions("spadmin:spExpress:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SpExpress spExpress)
    {
    	List<SpExpress> list = spExpressService.selectSpExpressList(spExpress);
        ExcelUtil<SpExpress> util = new ExcelUtil<SpExpress>(SpExpress.class);
        return util.exportExcel(list, "spExpress");
    }
	
	/**
	 * 新增快递
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存快递
	 */
	@RequiresPermissions("spadmin:spExpress:add")
	@Log(title = "快递", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(SpExpress spExpress)
	{		
		return toAjax(spExpressService.insertSpExpress(spExpress));
	}

	/**
	 * 修改快递
	 */
	@GetMapping("/edit/{mid}")
	public String edit(@PathVariable("mid") String mid, ModelMap mmap)
	{
		SpExpress spExpress = spExpressService.selectSpExpressById(mid);
		mmap.put("spExpress", spExpress);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存快递
	 */
	@RequiresPermissions("spadmin:spExpress:edit")
	@Log(title = "快递", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(SpExpress spExpress)
	{		
		return toAjax(spExpressService.updateSpExpress(spExpress));
	}
	
	/**
	 * 删除快递
	 */
	@RequiresPermissions("spadmin:spExpress:remove")
	@Log(title = "快递", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(spExpressService.deleteSpExpressByIds(ids));
	}
	
}
