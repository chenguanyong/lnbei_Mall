package com.lnbei.web.controller.sp.admin;

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
import com.lnbei.sp.domain.SpAccreds;
import com.lnbei.sp.domain.SpCatShops;
import com.lnbei.sp.domain.SpGoodsCats;
import com.lnbei.sp.domain.SpShopAccreds;
import com.lnbei.sp.domain.SpShopExpress;
import com.lnbei.sp.domain.SpShopExtras;
import com.lnbei.sp.domain.SpShops;
import com.lnbei.sp.service.ISpAccredsService;
import com.lnbei.sp.service.ISpCatShopsService;
import com.lnbei.sp.service.ISpGoodsCatsService;
import com.lnbei.sp.service.ISpShopAccredsService;
import com.lnbei.sp.service.ISpShopExtrasService;
import com.lnbei.sp.service.ISpShopsService;
import com.lnbei.sp.service.impl.SpShopExtrasServiceImpl;
import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.page.TableDataInfo;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.core.domain.CheckboxData;
import com.lnbei.common.utils.poi.ExcelUtil;
import com.lnbei.fi.domain.FiBanks;
import com.lnbei.fi.service.IFiBanksService;
import com.lnbei.framework.util.ShiroUtils;
import com.lnbei.home.domain.HomeCategory;
import com.lnbei.home.service.IHomeCategoryService;
import com.lnbei.member.domain.MemberUser;

/**
 * 店铺 信息操作处理
 * 
 * @author lnbei
 * @date 2020-02-05
 */
@Controller
@RequestMapping("/spadmin/spShops")
public class SpShopsController extends BaseController
{
    private String prefix = "sp/spShops";
	
	@Autowired
	private ISpShopsService spShopsService;
	@Autowired
	private IHomeCategoryService homeCategoryServiceImpl;
	@Autowired
	private ISpShopExtrasService spShopExtrasServiceImpl;
	@Autowired
	private IFiBanksService fiBanksService;	
	@Autowired
	private ISpAccredsService spAccredsService;	
	@Autowired
	private ISpShopAccredsService spShopAccredsService;	
	
	@Autowired
	private ISpGoodsCatsService spGoodsCatsService;	
	@Autowired
	private ISpCatShopsService spCatShopsService;		
	@RequiresPermissions("spadmin:spShops:view")
	@GetMapping()
	public String spShops()
	{
	    return prefix + "/spShops";
	}
	
	/**
	 * 查询店铺列表
	 */
	@RequiresPermissions("spadmin:spShops:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SpShops spShops)
	{
		startPage();
        List<SpShops> list = spShopsService.selectSpShopsList(spShops);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出店铺列表
	 */
	@RequiresPermissions("spadmin:spShops:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SpShops spShops)
    {
    	List<SpShops> list = spShopsService.selectSpShopsList(spShops);
        ExcelUtil<SpShops> util = new ExcelUtil<SpShops>(SpShops.class);
        return util.exportExcel(list, "spShops");
    }
	
	/**
	 * 新增店铺
	 */
	@GetMapping("/add")
	public String add(ModelMap mmMap)
	{
		HomeCategory mCategories = homeCategoryServiceImpl.selectHomeCategoryByFlag("sp_cats");
		HomeCategory tempCategories = new HomeCategory();
		tempCategories.setMid(mCategories.getMid());
		List<HomeCategory> mmCategories = homeCategoryServiceImpl.selectHomeCategoryListByParent(tempCategories);
		mmMap.put("mmCategories",mmCategories);
		FiBanks mBanks = new FiBanks();
		List<FiBanks> mmBanks = fiBanksService.selectFiBanksList(mBanks);
		mmMap.put("mmBanks",mmBanks);
		SpAccreds mAccreds = new SpAccreds();
		List<SpAccreds> mSpAccreds = spAccredsService.selectSpAccredsList(mAccreds);
		mmMap.put("mSpAccreds",mSpAccreds);
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存店铺
	 */
	@RequiresPermissions("spadmin:spShops:add")
	@Log(title = "店铺", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(SpShops spShops, SpShopExtras mExtras, MemberUser memberUser)
	{		
		return toAjax(spShopsService.createShop(memberUser, spShops, mExtras, ShiroUtils.getUser()));
	}

	/**
	 * 修改店铺
	 */
	@GetMapping("/edit/{mid}")
	public String edit(@PathVariable("mid") String mid, ModelMap mmap)
	{
		SpShops spShops = spShopsService.selectSpShopsById(mid);
		SpShopExtras mExtras = spShopExtrasServiceImpl.selectSpShopExtrasByShopId(spShops.getMid());
		FiBanks mBanks = new FiBanks();
		List<FiBanks> mmBanks = fiBanksService.selectFiBanksList(mBanks);

		List<CheckboxData> mCheckboxDatas = getSpAccredsList(spShops.getMid());
		
		List<CheckboxData> mCheckboxDatas2 = getSpGoodsCatList ( spShops.getMid());
		mmap.put("mCheckboxDatas",mCheckboxDatas);
		mmap.put("mCheckboxDatas2",mCheckboxDatas2);
		mmap.put("mmBanks",mmBanks);
		mmap.put("spShops", spShops);
		mmap.put("mExtras", mExtras);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存店铺
	 */
	@RequiresPermissions("spadmin:spShops:edit")
	@Log(title = "店铺", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(SpShops spShops, SpShopExtras mExtras)
	{		
		return toAjax(spShopsService.updateSpShops(spShops, mExtras, ShiroUtils.getUser()));
	}
	
	/**
	 * 删除店铺
	 */
	@RequiresPermissions("spadmin:spShops:remove")
	@Log(title = "店铺", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(spShopsService.deleteSpShopsByIds(ids));
	}
	
	private List<CheckboxData> getSpAccredsList (String shopId) {
		SpAccreds mmAccreds = new SpAccreds();
		List<SpAccreds> mAccreds = spAccredsService.selectSpAccredsList(mmAccreds);
		SpShopAccreds mShopAccreds = new SpShopAccreds();
		mShopAccreds.setShopId(shopId);
		List<SpShopAccreds> mSpShopAccreds = spShopAccredsService.selectSpShopAccredsList(mShopAccreds);
		List<CheckboxData> mCheckboxDatas = new ArrayList<CheckboxData>();
		for (SpAccreds mSpAccreds : mAccreds) {
		
			CheckboxData mCheckboxData = new CheckboxData();
			mCheckboxData.mid = mSpAccreds.getMid();
			mCheckboxData.name = mSpAccreds.getAccredName();
			for (SpShopAccreds mAccredsw : mSpShopAccreds) {
				if(mAccredsw.getMid().equals(mSpAccreds.getMid())) {
					
					mCheckboxData.isCheck = "1";
				}else {
					mCheckboxData.isCheck = "0";
				}
			}
			mCheckboxDatas.add(mCheckboxData);
		}
		
		return mCheckboxDatas;
	}
	
	
	private List<CheckboxData> getSpGoodsCatList (String shopId) {
		SpGoodsCats mGoodsCats = new SpGoodsCats();
		List<SpGoodsCats> mAccreds = spGoodsCatsService.selectSpGoodsCatsList(mGoodsCats);
		SpCatShops mmCatShops = new SpCatShops();
		mmCatShops.setShopId(shopId);
		List<SpCatShops> mSpShopAccreds = spCatShopsService.selectSpCatShopsList(mmCatShops);
		List<CheckboxData> mCheckboxDatas = new ArrayList<CheckboxData>();
		for (SpGoodsCats mSpGoodsCats : mAccreds) {
		
			CheckboxData mCheckboxData = new CheckboxData();
			mCheckboxData.mid = mSpGoodsCats.getMid();
			mCheckboxData.name = mSpGoodsCats.getCatName();
			for (SpCatShops mAccredsw : mSpShopAccreds) {
				if(mAccredsw.getMid().equals(mSpGoodsCats.getMid())) {
					
					mCheckboxData.isCheck = "1";
				}else {
					mCheckboxData.isCheck = "0";
				}
			}
			mCheckboxDatas.add(mCheckboxData);
		}
		
		return mCheckboxDatas;
	}
}
