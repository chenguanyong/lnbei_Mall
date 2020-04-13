package com.lnbei.web.controller.home;

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
import com.lnbei.home.domain.HomeUrlInfo;
import com.lnbei.home.service.IHomeUrlInfoService;
import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.page.TableDataInfo;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.utils.poi.ExcelUtil;
import com.lnbei.framework.util.ShiroUtils;

/**
 * 链接内容 信息操作处理
 * 
 * @author lnbei
 * @date 2020-01-24
 */
@Controller
@RequestMapping("/home/homeUrlInfo")
public class HomeUrlInfoController extends BaseController
{
    private String prefix = "home/homeUrlInfo";
	
	@Autowired
	private IHomeUrlInfoService homeUrlInfoService;
	
	@RequiresPermissions("home:homeUrlInfo:view")
	@GetMapping()
	public String homeUrlInfo()
	{
	    return prefix + "/homeUrlInfo";
	}
	
	/**
	 * 查询链接内容列表
	 */
	@RequiresPermissions("home:homeUrlInfo:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(HomeUrlInfo homeUrlInfo)
	{
		startPage();
        List<HomeUrlInfo> list = homeUrlInfoService.selectHomeUrlInfoList(homeUrlInfo);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出链接内容列表
	 */
	@RequiresPermissions("home:homeUrlInfo:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HomeUrlInfo homeUrlInfo)
    {
    	List<HomeUrlInfo> list = homeUrlInfoService.selectHomeUrlInfoList(homeUrlInfo);
        ExcelUtil<HomeUrlInfo> util = new ExcelUtil<HomeUrlInfo>(HomeUrlInfo.class);
        return util.exportExcel(list, "homeUrlInfo");
    }
	
	/**
	 * 新增链接内容
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存链接内容
	 */
	@RequiresPermissions("home:homeUrlInfo:add")
	@Log(title = "链接内容", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(HomeUrlInfo homeUrlInfo)
	{	
	
		return toAjax(homeUrlInfoService.insertHomeUrlInfo(homeUrlInfo, ShiroUtils.getUser()));
	}

	/**
	 * 修改链接内容
	 */
	@GetMapping("/edit/{mid}")
	public String edit(@PathVariable("mid") String mid, ModelMap mmap)
	{
		HomeUrlInfo homeUrlInfo = homeUrlInfoService.selectHomeUrlInfoById(mid);
		mmap.put("homeUrlInfo", homeUrlInfo);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存链接内容
	 */
	@RequiresPermissions("home:homeUrlInfo:edit")
	@Log(title = "链接内容", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(HomeUrlInfo homeUrlInfo)
	{		
		return toAjax(homeUrlInfoService.updateHomeUrlInfo(homeUrlInfo, ShiroUtils.getUser()));
	}
	
	/**
	 * 删除链接内容
	 */
	@RequiresPermissions("home:homeUrlInfo:remove")
	@Log(title = "链接内容", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(homeUrlInfoService.deleteHomeUrlInfoByIds(ids));
	}
	
}
