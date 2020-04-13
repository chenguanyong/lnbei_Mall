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
import com.lnbei.sp.domain.SpShopCats;
import com.lnbei.sp.service.ISpShopCatsService;
import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.page.TableDataInfo;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.utils.poi.ExcelUtil;

/**
 * 商家分类 信息操作处理
 * 
 * @author lnbei
 * @date 2020-02-05
 */
@Controller
@RequestMapping("/spadmin/spShopCats")
public class SpShopCatsController extends BaseController
{
    private String prefix = "sp/spShopCats";
	
	@Autowired
	private ISpShopCatsService spShopCatsService;
	
	@RequiresPermissions("spadmin:spShopCats:view")
	@GetMapping()
	public String spShopCats()
	{
	    return prefix + "/spShopCats";
	}
	
	/**
	 * 查询商家分类列表
	 */
	@RequiresPermissions("spadmin:spShopCats:list")
	@GetMapping("/list")
	@ResponseBody
	public  List<SpShopCats> list(SpShopCats spShopCats)
	{
	
        List<SpShopCats> list = spShopCatsService.selectSpShopCatsList(spShopCats);
		return list;
	}
	
	
	/**
	 * 导出商家分类列表
	 */
	@RequiresPermissions("spadmin:spShopCats:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SpShopCats spShopCats)
    {
    	List<SpShopCats> list = spShopCatsService.selectSpShopCatsList(spShopCats);
        ExcelUtil<SpShopCats> util = new ExcelUtil<SpShopCats>(SpShopCats.class);
        return util.exportExcel(list, "spShopCats");
    }
	
	/**
	 * 新增商家分类
	 */
	@GetMapping("/add/{mid}")
	public String add(@PathVariable("mid") String mid, ModelMap mmp)
	{
		
		mmp.put("mid", mid);
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存商家分类
	 */
	@RequiresPermissions("spadmin:spShopCats:add")
	@Log(title = "商家分类", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(SpShopCats spShopCats)
	{		
		return toAjax(spShopCatsService.insertSpShopCats(spShopCats));
	}

	/**
	 * 修改商家分类
	 */
	@GetMapping("/edit/{mid}")
	public String edit(@PathVariable("mid") String mid, ModelMap mmap)
	{
		SpShopCats spShopCats = spShopCatsService.selectSpShopCatsById(mid);
		mmap.put("spShopCats", spShopCats);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存商家分类
	 */
	@RequiresPermissions("spadmin:spShopCats:edit")
	@Log(title = "商家分类", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(SpShopCats spShopCats)
	{		
		return toAjax(spShopCatsService.updateSpShopCats(spShopCats));
	}
	
	/**
	 * 删除商家分类
	 */
	@RequiresPermissions("spadmin:spShopCats:remove")
	@Log(title = "商家分类", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(spShopCatsService.deleteSpShopCatsByIds(ids));
	}
	
}
