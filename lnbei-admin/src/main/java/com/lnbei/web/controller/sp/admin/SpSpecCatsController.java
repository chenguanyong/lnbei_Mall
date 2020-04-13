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
import com.lnbei.sp.domain.SpSpecCats;
import com.lnbei.sp.service.ISpSpecCatsService;
import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.page.TableDataInfo;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.utils.poi.ExcelUtil;
import com.lnbei.framework.util.ShiroUtils;
import com.lnbei.home.domain.HomeCategory;

/**
 * 规格分类 信息操作处理
 * 
 * @author lnbei
 * @date 2020-02-05
 */
@Controller
@RequestMapping("/spadmin/spSpecCats")
public class SpSpecCatsController extends BaseController
{
    private String prefix = "sp/spSpecCats";
	
	@Autowired
	private ISpSpecCatsService spSpecCatsService;
	
	@RequiresPermissions("spadmin:spSpecCats:view")
	@GetMapping()
	public String spSpecCats()
	{
	    return prefix + "/spSpecCats";
	}
	
	/**
	 * 查询规格分类列表
	 */
	@RequiresPermissions("spadmin:spSpecCats:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SpSpecCats spSpecCats)
	{
		startPage();
        List<SpSpecCats> list = spSpecCatsService.selectSpSpecCatsList(spSpecCats);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出规格分类列表
	 */
	@RequiresPermissions("spadmin:spSpecCats:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SpSpecCats spSpecCats)
    {
    	List<SpSpecCats> list = spSpecCatsService.selectSpSpecCatsList(spSpecCats);
        ExcelUtil<SpSpecCats> util = new ExcelUtil<SpSpecCats>(SpSpecCats.class);
        return util.exportExcel(list, "spSpecCats");
    }
	
	/**
	 * 新增规格分类
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存规格分类
	 */
	@RequiresPermissions("spadmin:spSpecCats:add")
	@Log(title = "规格分类", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(SpSpecCats spSpecCats)
	{		
		spSpecCats.setCatType("1");
		spSpecCats.initInsert(ShiroUtils.getUser());
		return toAjax(spSpecCatsService.insertSpSpecCats(spSpecCats));
	}
    /**
     * 分类状态修改
     */
    @Log(title = "规格管理", businessType = BusinessType.UPDATE)
    @RequiresPermissions("system:role:edit")
    @PostMapping("/changeStatus")
    @ResponseBody
    public AjaxResult changeStatus(SpSpecCats spSpecCats)
    {
        return toAjax(spSpecCatsService.changeStatus(spSpecCats));
    }
	/**
	 * 修改规格分类
	 */
	@GetMapping("/edit/{mid}")
	public String edit(@PathVariable("mid") String mid, ModelMap mmap)
	{
		SpSpecCats spSpecCats = spSpecCatsService.selectSpSpecCatsById(mid);
		mmap.put("spSpecCats", spSpecCats);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存规格分类
	 */
	@RequiresPermissions("spadmin:spSpecCats:edit")
	@Log(title = "规格分类", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(SpSpecCats spSpecCats)
	{   spSpecCats.setCatType("1");
		spSpecCats.initUpdate(ShiroUtils.getUser());
		return toAjax(spSpecCatsService.updateSpSpecCats(spSpecCats));
	}
	
	/**
	 * 删除规格分类
	 */
	@RequiresPermissions("spadmin:spSpecCats:remove")
	@Log(title = "规格分类", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(spSpecCatsService.deleteSpSpecCatsByIds(ids));
	}
	/**
	 * 获取规格
	 */
	@PostMapping( "/getSpecListByCatId")
	@ResponseBody
	public AjaxResult getSpecListByCatId(SpSpecCats spSpecCats)
	{		List<SpSpecCats> mCats = spSpecCatsService.selectSpSpecCatsAndSpecItemsList(spSpecCats);
		return AjaxResult.success("操作成功", mCats); 
	}	
}
