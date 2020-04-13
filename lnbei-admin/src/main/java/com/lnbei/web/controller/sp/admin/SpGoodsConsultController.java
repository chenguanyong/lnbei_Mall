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
import com.lnbei.sp.domain.SpGoodsConsult;
import com.lnbei.sp.service.ISpGoodsConsultService;
import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.page.TableDataInfo;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.utils.poi.ExcelUtil;

/**
 * 商品咨询 信息操作处理
 * 
 * @author lnbei
 * @date 2020-02-05
 */
@Controller
@RequestMapping("/spadmin/spGoodsConsult")
public class SpGoodsConsultController extends BaseController
{
    private String prefix = "sp/spGoodsConsult";
	
	@Autowired
	private ISpGoodsConsultService spGoodsConsultService;
	
	@RequiresPermissions("spadmin:spGoodsConsult:view")
	@GetMapping()
	public String spGoodsConsult()
	{
	    return prefix + "/spGoodsConsult";
	}
	
	/**
	 * 查询商品咨询列表
	 */
	@RequiresPermissions("spadmin:spGoodsConsult:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SpGoodsConsult spGoodsConsult)
	{
		startPage();
        List<SpGoodsConsult> list = spGoodsConsultService.selectSpGoodsConsultList(spGoodsConsult);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出商品咨询列表
	 */
	@RequiresPermissions("spadmin:spGoodsConsult:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SpGoodsConsult spGoodsConsult)
    {
    	List<SpGoodsConsult> list = spGoodsConsultService.selectSpGoodsConsultList(spGoodsConsult);
        ExcelUtil<SpGoodsConsult> util = new ExcelUtil<SpGoodsConsult>(SpGoodsConsult.class);
        return util.exportExcel(list, "spGoodsConsult");
    }
	
	/**
	 * 新增商品咨询
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存商品咨询
	 */
	@RequiresPermissions("spadmin:spGoodsConsult:add")
	@Log(title = "商品咨询", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(SpGoodsConsult spGoodsConsult)
	{		
		return toAjax(spGoodsConsultService.insertSpGoodsConsult(spGoodsConsult));
	}

	/**
	 * 修改商品咨询
	 */
	@GetMapping("/edit/{mid}")
	public String edit(@PathVariable("mid") String mid, ModelMap mmap)
	{
		SpGoodsConsult spGoodsConsult = spGoodsConsultService.selectSpGoodsConsultById(mid);
		mmap.put("spGoodsConsult", spGoodsConsult);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存商品咨询
	 */
	@RequiresPermissions("spadmin:spGoodsConsult:edit")
	@Log(title = "商品咨询", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(SpGoodsConsult spGoodsConsult)
	{		
		return toAjax(spGoodsConsultService.updateSpGoodsConsult(spGoodsConsult));
	}
	
	/**
	 * 删除商品咨询
	 */
	@RequiresPermissions("spadmin:spGoodsConsult:remove")
	@Log(title = "商品咨询", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(spGoodsConsultService.deleteSpGoodsConsultByIds(ids));
	}
	
}
