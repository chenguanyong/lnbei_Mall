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
import com.lnbei.sp.domain.SpShopExpress;
import com.lnbei.sp.service.ISpShopExpressService;
import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.page.TableDataInfo;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.utils.poi.ExcelUtil;

/**
 * 商家快递 信息操作处理
 * 
 * @author lnbei
 * @date 2020-02-05
 */
@Controller
@RequestMapping("/spadmin/spShopExpress")
public class SpShopExpressController extends BaseController
{
    private String prefix = "sp/spShopExpress";
	
	@Autowired
	private ISpShopExpressService spShopExpressService;
	
	@RequiresPermissions("spadmin:spShopExpress:view")
	@GetMapping()
	public String spShopExpress()
	{
	    return prefix + "/spShopExpress";
	}
	
	/**
	 * 查询商家快递列表
	 */
	@RequiresPermissions("spadmin:spShopExpress:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SpShopExpress spShopExpress)
	{
		startPage();
        List<SpShopExpress> list = spShopExpressService.selectSpShopExpressList(spShopExpress);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出商家快递列表
	 */
	@RequiresPermissions("spadmin:spShopExpress:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SpShopExpress spShopExpress)
    {
    	List<SpShopExpress> list = spShopExpressService.selectSpShopExpressList(spShopExpress);
        ExcelUtil<SpShopExpress> util = new ExcelUtil<SpShopExpress>(SpShopExpress.class);
        return util.exportExcel(list, "spShopExpress");
    }
	
	/**
	 * 新增商家快递
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存商家快递
	 */
	@RequiresPermissions("spadmin:spShopExpress:add")
	@Log(title = "商家快递", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(SpShopExpress spShopExpress)
	{		
		return toAjax(spShopExpressService.insertSpShopExpress(spShopExpress));
	}

	/**
	 * 修改商家快递
	 */
	@GetMapping("/edit/{mid}")
	public String edit(@PathVariable("mid") String mid, ModelMap mmap)
	{
		SpShopExpress spShopExpress = spShopExpressService.selectSpShopExpressById(mid);
		mmap.put("spShopExpress", spShopExpress);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存商家快递
	 */
	@RequiresPermissions("spadmin:spShopExpress:edit")
	@Log(title = "商家快递", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(SpShopExpress spShopExpress)
	{		
		return toAjax(spShopExpressService.updateSpShopExpress(spShopExpress));
	}
	
	/**
	 * 删除商家快递
	 */
	@RequiresPermissions("spadmin:spShopExpress:remove")
	@Log(title = "商家快递", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(spShopExpressService.deleteSpShopExpressByIds(ids));
	}
	
}
