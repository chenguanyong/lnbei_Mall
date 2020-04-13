package com.lnbei.web.controller.home;

import java.util.ArrayList;
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
import com.lnbei.home.domain.HomeCategory;
import com.lnbei.home.service.IHomeCategoryService;

import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.page.TableDataInfo;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.core.domain.Cascade;
import com.lnbei.common.core.domain.Ztree;
import com.lnbei.common.utils.poi.ExcelUtil;
import com.lnbei.framework.util.ShiroUtils;
import com.lnbei.framework.web.exception.CommonExecption;

/**
 * 分类 信息操作处理
 * 
 * @author lnbei
 * @date 2020-01-24
 */
@Controller
@RequestMapping("/home/homeCategory")
public class HomeCategoryController extends BaseController
{
    private String prefix = "home/homeCategory";
	
	@Autowired
	private IHomeCategoryService homeCategoryService;
	
	@RequiresPermissions("home:homeCategory:view")
	@GetMapping()
	public String homeCategory()
	{
	    return prefix + "/homeCategory";
	}
	
	/**
	 * 查询分类列表
	 */
	@RequiresPermissions("home:homeCategory:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(HomeCategory homeCategory)
	{
		startPage();
        List<HomeCategory> list = homeCategoryService.selectHomeCategoryList(homeCategory);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出分类列表
	 */
	@RequiresPermissions("home:homeCategory:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HomeCategory homeCategory)
    {
    	List<HomeCategory> list = homeCategoryService.selectHomeCategoryList(homeCategory);
        ExcelUtil<HomeCategory> util = new ExcelUtil<HomeCategory>(HomeCategory.class);
        return util.exportExcel(list, "homeCategory");
    }
	
	/**
	 * 新增分类
	 */
	@GetMapping("/add/{id}")
	public String add(@PathVariable("id") String mid, ModelMap mmMap)
	{
		HomeCategory mmCategory = homeCategoryService.selectHomeCategoryById(mid);
		if (mmCategory == null) {
			mmMap.put("mid", "0");
		}else {
			mmMap.put("mid", mmCategory.getMid());
		}
		
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存分类
	 */
	@RequiresPermissions("home:homeCategory:add")
	@Log(title = "分类", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(HomeCategory homeCategory)
	{		
		return toAjax(homeCategoryService.insertHomeCategory(homeCategory, ShiroUtils.getUser()));
	}

	/**
	 * 修改分类
	 */
	@GetMapping("/edit/{mid}")
	public String edit(@PathVariable("mid") String mid, ModelMap mmap)
	{
		HomeCategory homeCategory = homeCategoryService.selectHomeCategoryById(mid);
		mmap.put("homeCategory", homeCategory);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存分类
	 */
	@RequiresPermissions("home:homeCategory:edit")
	@Log(title = "分类", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(HomeCategory homeCategory)
	{		
		return toAjax(homeCategoryService.updateHomeCategory(homeCategory, ShiroUtils.getUser()));
	}
	
	/**
	 * 删除分类
	 */
	@RequiresPermissions("home:homeCategory:remove")
	@Log(title = "分类", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(homeCategoryService.deleteHomeCategoryByIds(ids));
	}
    @GetMapping("/treeData")
    @ResponseBody
    public List<Ztree> treeData(HomeCategory mmCategory)
    {
        List<Ztree> ztrees = homeCategoryService.selectCategory(mmCategory);
        return ztrees;
    }
    @GetMapping("/treeDataByFlag/{flag}")
    @ResponseBody
    public List<Ztree> treeDataFlag(@PathVariable("flag") String flag)
    {
    	HomeCategory mCategory = homeCategoryService.selectHomeCategoryByFlag(flag);
    	if(mCategory == null) {
    		throw new CommonExecption("不存在");
    	}

        List<Ztree> ztrees = homeCategoryService.selectCategory(mCategory);
        return ztrees;
    }    
    /**
     * 分类状态修改
     */
    @Log(title = "分类管理", businessType = BusinessType.UPDATE)
    @RequiresPermissions("system:role:edit")
    @PostMapping("/changeStatus")
    @ResponseBody
    public AjaxResult changeStatus(HomeCategory mCategory)
    {
        return toAjax(homeCategoryService.changeStatus(mCategory));
    }
    /**
     * 获取分类树
     * @return
     */
    @GetMapping("/categoryTree")
    public String categoryTree(HomeCategory mCategory, ModelMap mmMap)
    {
    	HomeCategory mmCategory = homeCategoryService.selectHomeCategoryByFlag(mCategory.getFlag());
       if(mmCategory != null) {
    	   mmMap.put("mCategory", mmCategory);
       }else {
    	   throw new CommonExecption("不存在");
       }
    	return prefix + "/categoryTree";
    }
    /**
     * 获取分类树
     * @return
     */
    @PostMapping("/getCategoryCascadeList/{flag}")
    @ResponseBody
    public AjaxResult getCategoryCascadeList(@PathVariable("flag") String flag, HomeCategory mCategory)
    {
    	HomeCategory mmCategory = homeCategoryService.selectHomeCategoryByFlag(flag);
    	HomeCategory temCategory = new HomeCategory();
    	temCategory.setPathString(mmCategory.getMid());
    	if(mCategory.getParentId().equals("0")) {
    		mCategory.setParentId(mmCategory.getMid());
    	}
    	temCategory.setParentId(mCategory.getParentId());
    	List<HomeCategory> mHomeCategories = homeCategoryService.selectHomeCategoryByPathParentId(temCategory);
    	List<Cascade> mmCascades = new ArrayList<Cascade>();
    	for (HomeCategory mCategory2 : mHomeCategories) {
    		Cascade mCascade = new Cascade();
    		mCascade.setMid(mCategory2.getMid());
    		mCascade.setName(mCategory2.getCategory());
    		mmCascades.add(mCascade);
		}
    	return AjaxResult.success("操作成功", mmCascades);
    }
    
}
