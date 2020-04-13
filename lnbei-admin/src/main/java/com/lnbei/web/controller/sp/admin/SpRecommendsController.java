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
import com.lnbei.sp.domain.SpRecommends;
import com.lnbei.sp.service.ISpRecommendsService;
import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.page.TableDataInfo;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.utils.poi.ExcelUtil;

/**
 * 推荐 信息操作处理
 * 
 * @author lnbei
 * @date 2020-03-31
 */
@Controller
@RequestMapping("/sp/spRecommends")
public class SpRecommendsController extends BaseController
{
    private String prefix = "sp/spRecommends";
	
	@Autowired
	private ISpRecommendsService spRecommendsService;
	
	@RequiresPermissions("sp:spRecommends:view")
	@GetMapping()
	public String spRecommends()
	{
	    return prefix + "/spRecommends";
	}
	
	/**
	 * 查询推荐列表
	 */
	@RequiresPermissions("sp:spRecommends:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SpRecommends spRecommends)
	{
		startPage();
        List<SpRecommends> list = spRecommendsService.selectSpRecommendsList(spRecommends);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出推荐列表
	 */
	@RequiresPermissions("sp:spRecommends:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SpRecommends spRecommends)
    {
    	List<SpRecommends> list = spRecommendsService.selectSpRecommendsList(spRecommends);
        ExcelUtil<SpRecommends> util = new ExcelUtil<SpRecommends>(SpRecommends.class);
        return util.exportExcel(list, "spRecommends");
    }
	
	/**
	 * 新增推荐
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存推荐
	 */
	@RequiresPermissions("sp:spRecommends:add")
	@Log(title = "推荐", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(SpRecommends spRecommends)
	{		
		return toAjax(spRecommendsService.insertSpRecommends(spRecommends));
	}

	/**
	 * 修改推荐
	 */
	@GetMapping("/edit/{mid}")
	public String edit(@PathVariable("mid") String mid, ModelMap mmap)
	{
		SpRecommends spRecommends = spRecommendsService.selectSpRecommendsById(mid);
		mmap.put("spRecommends", spRecommends);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存推荐
	 */
	@RequiresPermissions("sp:spRecommends:edit")
	@Log(title = "推荐", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(SpRecommends spRecommends)
	{		
		return toAjax(spRecommendsService.updateSpRecommends(spRecommends));
	}
	
	/**
	 * 删除推荐
	 */
	@RequiresPermissions("sp:spRecommends:remove")
	@Log(title = "推荐", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(spRecommendsService.deleteSpRecommendsByIds(ids));
	}
	
}
