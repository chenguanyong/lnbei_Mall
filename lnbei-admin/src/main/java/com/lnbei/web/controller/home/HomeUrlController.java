package com.lnbei.web.controller.home;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.lnbei.common.annotation.Log;
import com.lnbei.common.enums.BusinessType;
import com.lnbei.home.domain.HomeCategory;
import com.lnbei.home.domain.HomeUrl;
import com.lnbei.home.domain.HomeUrlInfo;
import com.lnbei.home.service.IHomeCategoryService;
import com.lnbei.home.service.IHomeUrlInfoService;
import com.lnbei.home.service.IHomeUrlService;
import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.page.TableDataInfo;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.utils.poi.ExcelUtil;
import com.lnbei.framework.util.ShiroUtils;

/**
 * 链接详情 信息操作处理
 * 
 * @author lnbei
 * @date 2020-01-24
 */
@Controller
@RequestMapping("/home/homeUrl")
public class HomeUrlController extends BaseController
{
    private String prefix = "home/homeUrl";
	
	@Autowired
	private IHomeUrlService homeUrlService;
	@Autowired
	private IHomeUrlInfoService homeUrlInfoService;	
	@Autowired
	private IHomeCategoryService homeCategoryService;
	
	@RequiresPermissions("home:homeUrl:view")
	@GetMapping()
	public String homeUrl()
	{
	    return prefix + "/homeUrl";
	}
	
	/**
	 * 查询链接详情列表
	 */
	@RequiresPermissions("home:homeUrl:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(HomeUrl homeUrl)
	{
		startPage();
        List<HomeUrl> list = homeUrlService.selectHomeUrlList(homeUrl);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出链接详情列表
	 */
	@RequiresPermissions("home:homeUrl:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HomeUrl homeUrl)
    {
    	List<HomeUrl> list = homeUrlService.selectHomeUrlList(homeUrl);
        ExcelUtil<HomeUrl> util = new ExcelUtil<HomeUrl>(HomeUrl.class);
        return util.exportExcel(list, "homeUrl");
    }
	
	/**
	 * 新增链接详情
	 */
	@GetMapping("/add/{catgoryId}")
	public String add(@PathVariable("catgoryId") String catgoryId, ModelMap mmMap)
	{
		
		HomeCategory mmCategory = homeCategoryService.selectHomeCategoryById(catgoryId);
		if(mmCategory != null) {
			mmMap.put("categoryId", mmCategory.getMid());
			mmMap.put("category", mmCategory.getCategory());
		}else {
			mmMap.put("categoryId", "");
			mmMap.put("category","");
		}
		
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存链接详情
	 */
	@RequiresPermissions("home:homeUrl:add")
	@Log(title = "链接详情", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	@Transactional
	public AjaxResult addSave(HomeUrl homeUrl, HomeUrlInfo homeUrlInfo)
	{		
		int result = homeUrlService.insertHomeUrl(homeUrl, ShiroUtils.getUser());
		if(result > 0) {
			homeUrlInfo.setUrlId(homeUrl.getMid());
			result = homeUrlInfoService.insertHomeUrlInfo(homeUrlInfo, ShiroUtils.getUser());
		}
		return toAjax(result);
	}

	/**
	 * 修改链接详情
	 */
	@GetMapping("/edit/{mid}")
	public String edit(@PathVariable("mid") String mid, ModelMap mmap)
	{
		HomeUrl homeUrl = homeUrlService.selectHomeUrlById(mid);
		mmap.put("homeUrl", homeUrl);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存链接详情
	 */
	@RequiresPermissions("home:homeUrl:edit")
	@Log(title = "链接详情", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(HomeUrl homeUrl, HomeUrlInfo mHomeUrlInfo)
	{		
		int result = homeUrlService.updateHomeUrl(homeUrl, ShiroUtils.getUser());
		if(result > 0) {
			
			result = homeUrlInfoService.updateHomeUrlInfo(mHomeUrlInfo, ShiroUtils.getUser());
		}
		return toAjax(result);
	}
	
	/**
	 * 删除链接详情
	 */
	@RequiresPermissions("home:homeUrl:remove")
	@Log(title = "链接详情", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(homeUrlService.deleteHomeUrlByIds(ids));
	}
    /**
     * 分类状态修改
     */
    @Log(title = "分类管理", businessType = BusinessType.UPDATE)
    @RequiresPermissions("system:role:edit")
    @PostMapping("/changeStatus")
    @ResponseBody
    public AjaxResult changeStatus(HomeUrl mHomeUrl)
    {
        return toAjax(homeUrlService.changeStatus(mHomeUrl));
    }
}
