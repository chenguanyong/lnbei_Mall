package com.lnbei.web.controller.fi;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.lnbei.common.annotation.Log;
import com.lnbei.common.enums.BusinessType;
import com.lnbei.fi.domain.FiRecharge;
import com.lnbei.fi.service.IFiRechargeService;
import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.page.TableDataInfo;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.utils.poi.ExcelUtil;
import org.springframework.stereotype.Controller;
/**
 * 充值 信息操作处理
 * 
 * @author lnbei
 * @date 2020-02-13
 */
@Controller
@RequestMapping("/fi/fiRecharge")
public class FiRechargeController extends BaseController
{
    private String prefix = "fi/fiRecharge";
	
	@Autowired
	private IFiRechargeService fiRechargeService;
	
	@RequiresPermissions("fi:fiRecharge:view")
	@GetMapping()
	public String fiRecharge()
	{
	    return prefix + "/fiRecharge";
	}
	
	/**
	 * 查询充值列表
	 */
	@RequiresPermissions("fi:fiRecharge:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(FiRecharge fiRecharge)
	{
		startPage();
        List<FiRecharge> list = fiRechargeService.selectFiRechargeList(fiRecharge);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出充值列表
	 */
	@RequiresPermissions("fi:fiRecharge:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FiRecharge fiRecharge)
    {
    	List<FiRecharge> list = fiRechargeService.selectFiRechargeList(fiRecharge);
        ExcelUtil<FiRecharge> util = new ExcelUtil<FiRecharge>(FiRecharge.class);
        return util.exportExcel(list, "fiRecharge");
    }
	
	/**
	 * 新增充值
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存充值
	 */
	@RequiresPermissions("fi:fiRecharge:add")
	@Log(title = "充值", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(FiRecharge fiRecharge)
	{		
		return toAjax(fiRechargeService.insertFiRecharge(fiRecharge));
	}

	/**
	 * 修改充值
	 */
	@GetMapping("/edit/{mid}")
	public String edit(@PathVariable("mid") String mid, ModelMap mmap)
	{
		FiRecharge fiRecharge = fiRechargeService.selectFiRechargeById(mid);
		mmap.put("fiRecharge", fiRecharge);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存充值
	 */
	@RequiresPermissions("fi:fiRecharge:edit")
	@Log(title = "充值", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(FiRecharge fiRecharge)
	{		
		return toAjax(fiRechargeService.updateFiRecharge(fiRecharge));
	}
	
	/**
	 * 删除充值
	 */
	@RequiresPermissions("fi:fiRecharge:remove")
	@Log(title = "充值", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(fiRechargeService.deleteFiRechargeByIds(ids));
	}
	
}
