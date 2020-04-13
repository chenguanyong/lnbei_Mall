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
import com.lnbei.home.domain.HomeArticleInfo;
import com.lnbei.home.service.IHomeArticleInfoService;
import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.page.TableDataInfo;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.utils.poi.ExcelUtil;
import com.lnbei.framework.util.ShiroUtils;

/**
 * 文章详情 信息操作处理
 * 
 * @author lnbei
 * @date 2020-01-24
 */
@Controller
@RequestMapping("/home/homeArticleInfo")
public class HomeArticleInfoController extends BaseController
{
    private String prefix = "home/homeArticleInfo";
	
	@Autowired
	private IHomeArticleInfoService homeArticleInfoService;
	
	@RequiresPermissions("home:homeArticleInfo:view")
	@GetMapping()
	public String homeArticleInfo()
	{
	    return prefix + "/homeArticleInfo";
	}
	
	/**
	 * 查询文章详情列表
	 */
	@RequiresPermissions("home:homeArticleInfo:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(HomeArticleInfo homeArticleInfo)
	{
		startPage();
        List<HomeArticleInfo> list = homeArticleInfoService.selectHomeArticleInfoList(homeArticleInfo);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出文章详情列表
	 */
	@RequiresPermissions("home:homeArticleInfo:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HomeArticleInfo homeArticleInfo)
    {
    	List<HomeArticleInfo> list = homeArticleInfoService.selectHomeArticleInfoList(homeArticleInfo);
        ExcelUtil<HomeArticleInfo> util = new ExcelUtil<HomeArticleInfo>(HomeArticleInfo.class);
        return util.exportExcel(list, "homeArticleInfo");
    }
	
	/**
	 * 新增文章详情
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存文章详情
	 */
	@RequiresPermissions("home:homeArticleInfo:add")
	@Log(title = "文章详情", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(HomeArticleInfo homeArticleInfo)
	{		
		return toAjax(homeArticleInfoService.insertHomeArticleInfo(homeArticleInfo, ShiroUtils.getUser()));
	}

	/**
	 * 修改文章详情
	 */
	@GetMapping("/edit/{mid}")
	public String edit(@PathVariable("mid") String mid, ModelMap mmap)
	{
		HomeArticleInfo homeArticleInfo = homeArticleInfoService.selectHomeArticleInfoById(mid);
		mmap.put("homeArticleInfo", homeArticleInfo);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存文章详情
	 */
	@RequiresPermissions("home:homeArticleInfo:edit")
	@Log(title = "文章详情", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(HomeArticleInfo homeArticleInfo)
	{		
		return toAjax(homeArticleInfoService.updateHomeArticleInfo(homeArticleInfo, ShiroUtils.getUser()));
	}
	
	/**
	 * 删除文章详情
	 */
	@RequiresPermissions("home:homeArticleInfo:remove")
	@Log(title = "文章详情", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(homeArticleInfoService.deleteHomeArticleInfoByIds(ids));
	}
	
}
