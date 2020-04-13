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
import com.lnbei.sp.domain.SpGoodsAppraises;
import com.lnbei.sp.service.ISpGoodsAppraisesService;
import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.page.TableDataInfo;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.utils.poi.ExcelUtil;

/**
 * 商品评价 信息操作处理
 * 
 * @author lnbei
 * @date 2020-02-05
 */
@Controller
@RequestMapping("/spadmin/spGoodsAppraises")
public class SpGoodsAppraisesController extends BaseController
{
    private String prefix = "sp/spGoodsAppraises";
	
	@Autowired
	private ISpGoodsAppraisesService spGoodsAppraisesService;
	
	@RequiresPermissions("spadmin:spGoodsAppraises:view")
	@GetMapping()
	public String spGoodsAppraises()
	{
	    return prefix + "/spGoodsAppraises";
	}
	
	/**
	 * 查询商品评价列表
	 */
	@RequiresPermissions("spadmin:spGoodsAppraises:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SpGoodsAppraises spGoodsAppraises)
	{
		startPage();
        List<SpGoodsAppraises> list = spGoodsAppraisesService.selectSpGoodsAppraisesList(spGoodsAppraises);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出商品评价列表
	 */
	@RequiresPermissions("spadmin:spGoodsAppraises:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SpGoodsAppraises spGoodsAppraises)
    {
    	List<SpGoodsAppraises> list = spGoodsAppraisesService.selectSpGoodsAppraisesList(spGoodsAppraises);
        ExcelUtil<SpGoodsAppraises> util = new ExcelUtil<SpGoodsAppraises>(SpGoodsAppraises.class);
        return util.exportExcel(list, "spGoodsAppraises");
    }
	
	/**
	 * 新增商品评价
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存商品评价
	 */
	@RequiresPermissions("spadmin:spGoodsAppraises:add")
	@Log(title = "商品评价", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(SpGoodsAppraises spGoodsAppraises)
	{		
		return toAjax(spGoodsAppraisesService.insertSpGoodsAppraises(spGoodsAppraises));
	}

	/**
	 * 修改商品评价
	 */
	@GetMapping("/edit/{mid}")
	public String edit(@PathVariable("mid") String mid, ModelMap mmap)
	{
		SpGoodsAppraises spGoodsAppraises = spGoodsAppraisesService.selectSpGoodsAppraisesById(mid);
		mmap.put("spGoodsAppraises", spGoodsAppraises);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存商品评价
	 */
	@RequiresPermissions("spadmin:spGoodsAppraises:edit")
	@Log(title = "商品评价", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(SpGoodsAppraises spGoodsAppraises)
	{		
		return toAjax(spGoodsAppraisesService.updateSpGoodsAppraises(spGoodsAppraises));
	}
	
	/**
	 * 删除商品评价
	 */
	@RequiresPermissions("spadmin:spGoodsAppraises:remove")
	@Log(title = "商品评价", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(spGoodsAppraisesService.deleteSpGoodsAppraisesByIds(ids));
	}
	
}
