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
import com.lnbei.sp.domain.SpAttributes;
import com.lnbei.sp.domain.SpGoods;
import com.lnbei.sp.domain.SpGoodsAttributes;
import com.lnbei.sp.domain.SpGoodsSpecs;
import com.lnbei.sp.domain.SpSpecCats;
import com.lnbei.sp.domain.SpSpecItems;
import com.lnbei.sp.service.ISpAttributesService;
import com.lnbei.sp.service.ISpGoodsAttributesService;
import com.lnbei.sp.service.ISpGoodsService;
import com.lnbei.sp.service.ISpGoodsSpecsService;
import com.lnbei.sp.service.ISpSpecCatsService;
import com.lnbei.sp.service.impl.SpSpecCatsServiceImpl;

import javassist.expr.NewArray;

import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.page.TableDataInfo;
import com.lnbei.common.core.text.Convert;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.utils.StringUtils;
import com.lnbei.common.utils.poi.ExcelUtil;
import com.lnbei.framework.util.ShiroUtils;
import com.alibaba.fastjson.JSON;
/**
 * 商品 信息操作处理
 * 
 * @author lnbei
 * @date 2020-02-05
 */
@Controller
@RequestMapping("/spadmin/spGoods")
public class SpGoodsController extends BaseController
{
    private String prefix = "sp/spGoods";
	
	@Autowired
	private ISpGoodsService spGoodsService;
	@Autowired
	private ISpGoodsSpecsService spGoodsSpecsService;
	@Autowired
	private ISpSpecCatsService SpSpecCatsServiceImpl;
	@Autowired
	private ISpGoodsAttributesService spGoodsAttributesService; 
	@Autowired
	private ISpAttributesService spAttributesService; 
	@RequiresPermissions("spadmin:spGoods:view")
	@GetMapping()
	public String spGoods()
	{
	    return prefix + "/spGoods";
	}
	
	/**
	 * 查询商品列表
	 */
	@RequiresPermissions("spadmin:spGoods:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SpGoods spGoods)
	{
		startPage();
        List<SpGoods> list = spGoodsService.selectSpGoodsList(spGoods);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出商品列表
	 */
	@RequiresPermissions("spadmin:spGoods:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SpGoods spGoods)
    {
    	List<SpGoods> list = spGoodsService.selectSpGoodsList(spGoods);
        ExcelUtil<SpGoods> util = new ExcelUtil<SpGoods>(SpGoods.class);
        return util.exportExcel(list, "spGoods");
    }
	
	/**
	 * 新增商品
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存商品
	 */
	@RequiresPermissions("spadmin:spGoods:add")
	@Log(title = "商品", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(SpGoods spGoods, String goodsAttrStr, String goodsSpecStr, String goodsSpecItemStr)
	{	
		List<SpGoodsAttributes> mAttributes = new ArrayList<SpGoodsAttributes>();
		if(StringUtils.isNotEmpty(goodsAttrStr)) {
			mAttributes = (List<SpGoodsAttributes>) JSON.parseArray(goodsAttrStr, SpGoodsAttributes.class);
		}
		List<SpSpecItems> spSpecItems = new ArrayList<SpSpecItems>();
		if(StringUtils.isNotEmpty(goodsSpecStr)) {
			spSpecItems = (List<SpSpecItems>) JSON.parseArray(goodsSpecStr, SpSpecItems.class);
		}
		List<SpGoodsSpecs> mpGoodsSpecs = new ArrayList<SpGoodsSpecs>();
		if(StringUtils.isNotEmpty(goodsSpecItemStr)) {
			mpGoodsSpecs = (List<SpGoodsSpecs>) JSON.parseArray(goodsSpecItemStr, SpGoodsSpecs.class);
		}		
		
		return toAjax(spGoodsService.insertSpGoods(spGoods,spSpecItems,mpGoodsSpecs,mAttributes, ShiroUtils.getUser()));
	}

	/**
	 * 修改商品
	 */
	@GetMapping("/edit/{mid}")
	public String edit(@PathVariable("mid") String mid, ModelMap mmap)
	{
		SpGoods spGoods = spGoodsService.selectSpGoodsById(mid);
		initGoodsSpecs(spGoods, mmap);
		initGoodsAtrr(spGoods, mmap);
		List<String> mList = new ArrayList<String>();
		String [] mStrings = null ;
		if (StringUtils.isNotEmpty(spGoods.getGallery())) {
			mStrings =  Convert.toStrArray(spGoods.getGallery());
			for (String string : mStrings) {
				mList.add(string);
			}			
		}
		mmap.put("gallery", mList);
		mmap.put("spGoods", spGoods);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存商品
	 */
	@RequiresPermissions("spadmin:spGoods:edit")
	@Log(title = "商品", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(SpGoods spGoods, String goodsAttrStr, String goodsSpecStr, String goodsSpecItemStr)
	{	
		List<SpGoodsAttributes> mAttributes = new ArrayList<SpGoodsAttributes>();
		if(StringUtils.isNotEmpty(goodsAttrStr)) {
			mAttributes = (List<SpGoodsAttributes>) JSON.parseArray(goodsAttrStr, SpGoodsAttributes.class);
		}
		List<SpSpecItems> spSpecItems = new ArrayList<SpSpecItems>();
		if(StringUtils.isNotEmpty(goodsSpecStr)) {
			spSpecItems = (List<SpSpecItems>) JSON.parseArray(goodsSpecStr, SpSpecItems.class);
		}
		List<SpGoodsSpecs> mpGoodsSpecs = new ArrayList<SpGoodsSpecs>();
		if(StringUtils.isNotEmpty(goodsSpecItemStr)) {
			mpGoodsSpecs = (List<SpGoodsSpecs>) JSON.parseArray(goodsSpecItemStr, SpGoodsSpecs.class);
		}	
		return toAjax(spGoodsService.updateSpGoods(spGoods,spSpecItems,mpGoodsSpecs,mAttributes, ShiroUtils.getUser()));
	}
	
	/**
	 * 删除商品
	 */
	@RequiresPermissions("spadmin:spGoods:remove")
	@Log(title = "商品", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(spGoodsService.deleteSpGoodsByIds(ids));
	}
	/**
	 * 初始化商品规格
	 */
	private void initGoodsSpecs(SpGoods mGoods, ModelMap mmMap ) {
		SpGoodsSpecs mGoodsSpecs = new SpGoodsSpecs();
		mGoodsSpecs.setShopId(mGoods.getShopId());
		mGoodsSpecs.setGoodsId(mGoods.getMid());
		List<SpGoodsSpecs> mGoodsSpecs2 = spGoodsSpecsService.selectSpGoodsSpecsList(mGoodsSpecs);
		SpSpecCats mSpecCats = new SpSpecCats();
		mSpecCats.setShopId(mGoods.getShopId());
		mSpecCats.setGoodsCatId(mGoods.getGoodscatId());
		List<SpSpecCats> mmCats = SpSpecCatsServiceImpl.selectSpSpecCatsAndSpecItemsList(mSpecCats);
		for (SpGoodsSpecs specs : mGoodsSpecs2) {
			String specId = specs.getSpecIds();
			String[] specIdArray = Convert.toStrArray(":", specId);
			if (specIdArray.length == 1) {
				SpSpecItems mSpecItems = selectSpecItems(mmCats, specIdArray[0]);
				specs.setItemName0(mSpecItems.getItemName());
				specs.setItemName0id(mSpecItems.getMid());
				specs.setItemSize(1);
			}else if(specIdArray.length == 2) {
				specs.setItemSize(2);
				SpSpecItems mSpecItems = selectSpecItems(mmCats, specIdArray[0]);
				SpSpecItems mSpecItems2 = selectSpecItems(mmCats, specIdArray[1]);
				specs.setItemName0(mSpecItems.getItemName());
				specs.setItemName0id(mSpecItems.getMid());
				specs.setItemName1(mSpecItems2.getItemName());
				specs.setItemName1id(mSpecItems2.getMid());
			}
		}
		mmMap.put("mGoodsSpecs2", mGoodsSpecs2);//商品规格
		mmMap.put("specCat", mmCats);//商品规格
	}
	/**
	 * 根据Id查询spspecItems
	 * @param mCats
	 * @param spSecItemId
	 * @return
	 */
	private SpSpecItems selectSpecItems(List<SpSpecCats> mCats, String spSecItemId) {
		
		for (SpSpecCats spSpecCats : mCats) {
			List<SpSpecItems> mmSpecItems = spSpecCats.getSpSpecItems();
			for (SpSpecItems spSpecItems : mmSpecItems) {
				
				if(spSpecItems.getMid().equals(spSecItemId)) {
					spSpecItems.setIsCheck("1");
					return spSpecItems;
				}
			}	
		}
		return null;
	}
	/****
	 * 初始化商品属性
	 * @param spGoods
	 * @param mmMap
	 */
	private void initGoodsAtrr(SpGoods spGoods, ModelMap mmMap) {
		SpGoodsAttributes mAttributes = new SpGoodsAttributes();
		mAttributes.setGoodsId(spGoods.getMid());
		mAttributes.setShopId(spGoods.getShopId());
		List<SpGoodsAttributes> mmAttributes = spGoodsAttributesService.selectSpGoodsAttributesList(mAttributes);
		SpAttributes mmAttributes2 = new SpAttributes();
		mmAttributes2.setGoodscatId(spGoods.getGoodscatId());
		List<SpAttributes> mSpAttributes = spAttributesService.selectSpAttributesList(mmAttributes2);
		
		for (SpAttributes spAttributes : mSpAttributes) {
			
			SpGoodsAttributes mSpGoodsAttributes = selecAttributes(mmAttributes, spAttributes);
			if(mSpGoodsAttributes != null) {
				spAttributes.setDefaultValue(mSpGoodsAttributes.getAttrVal());
			}
		}
		mmMap.put("mSpAttributes", mSpAttributes);

	}
	
	private SpGoodsAttributes selecAttributes(List<SpGoodsAttributes> mGoodsAttributes, SpAttributes mAttributes) {
		for (SpGoodsAttributes spGoodsAttributes : mGoodsAttributes) {
			String midString =  spGoodsAttributes.getAttrId();
			if(midString.equals(mAttributes.getMid())) {
				return spGoodsAttributes;
			}
		}
		return null;
	}
}
