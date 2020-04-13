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
import com.lnbei.sp.domain.SpShopScores;
import com.lnbei.sp.service.ISpShopScoresService;
import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.page.TableDataInfo;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.utils.poi.ExcelUtil;

/**
 * 商品评分 信息操作处理
 * 
 * @author lnbei
 * @date 2020-02-05
 */
@Controller
@RequestMapping("/spadmin/spShopScores")
public class SpShopScoresController extends BaseController
{
    private String prefix = "sp/spShopScores";
	
	@Autowired
	private ISpShopScoresService spShopScoresService;
	
	@RequiresPermissions("spadmin:spShopScores:view")
	@GetMapping()
	public String spShopScores()
	{
	    return prefix + "/spShopScores";
	}
	
	/**
	 * 查询商品评分列表
	 */
	@RequiresPermissions("spadmin:spShopScores:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SpShopScores spShopScores)
	{
		startPage();
        List<SpShopScores> list = spShopScoresService.selectSpShopScoresList(spShopScores);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出商品评分列表
	 */
	@RequiresPermissions("spadmin:spShopScores:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SpShopScores spShopScores)
    {
    	List<SpShopScores> list = spShopScoresService.selectSpShopScoresList(spShopScores);
        ExcelUtil<SpShopScores> util = new ExcelUtil<SpShopScores>(SpShopScores.class);
        return util.exportExcel(list, "spShopScores");
    }
	
	/**
	 * 新增商品评分
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存商品评分
	 */
	@RequiresPermissions("spadmin:spShopScores:add")
	@Log(title = "商品评分", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(SpShopScores spShopScores)
	{		
		return toAjax(spShopScoresService.insertSpShopScores(spShopScores));
	}

	/**
	 * 修改商品评分
	 */
	@GetMapping("/edit/{mid}")
	public String edit(@PathVariable("mid") String mid, ModelMap mmap)
	{
		SpShopScores spShopScores = spShopScoresService.selectSpShopScoresById(mid);
		mmap.put("spShopScores", spShopScores);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存商品评分
	 */
	@RequiresPermissions("spadmin:spShopScores:edit")
	@Log(title = "商品评分", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(SpShopScores spShopScores)
	{		
		return toAjax(spShopScoresService.updateSpShopScores(spShopScores));
	}
	
	/**
	 * 删除商品评分
	 */
	@RequiresPermissions("spadmin:spShopScores:remove")
	@Log(title = "商品评分", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(spShopScoresService.deleteSpShopScoresByIds(ids));
	}
	
}
