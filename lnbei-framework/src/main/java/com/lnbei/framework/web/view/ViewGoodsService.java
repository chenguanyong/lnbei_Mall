package com.lnbei.framework.web.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lnbei.common.utils.StringUtils;
import com.lnbei.sp.domain.SpGoods;
import com.lnbei.sp.domain.SpGoodsCats;
import com.lnbei.sp.service.ISpGoodsCatsService;
import com.lnbei.sp.service.ISpGoodsService;

@Service("ViewGoods")
public class ViewGoodsService extends BaseViewService {
	@Autowired
	private ISpGoodsService spGoodsService;
	@Autowired
	private ISpGoodsCatsService spGoodsCatsService;
	/**
	 * 
	 * 
	 * @param dictType 字典类型
	 * @return 参数键值
	 */

	public List<SpGoods> getSpgoodsList(String pageSize, String pageNum, String orderByColumn, String isASC,
			String condition) {
		SpGoods mGoods = new SpGoods();
		if (StringUtils.isEmpty(condition)) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("condition", "and " + condition);
			mGoods.setParams(map);
		}
		return seleGoodsList(pageSize,pageNum,orderByColumn,isASC,mGoods);
	}
	private List<SpGoods> seleGoodsList(String pageSize, String pageNum, String orderByColumn, String isASC,
			SpGoods mGoods){
		if (StringUtils.isEmpty(orderByColumn)) {
			orderByColumn = "sort";
		}
		if (StringUtils.isEmpty(isASC)) {
			isASC = "desc";
		}
		startPage(Integer.parseInt(pageSize), Integer.parseInt(pageNum), orderByColumn, isASC);
		return spGoodsService.selectSpGoodsList(mGoods);	
	}
	/**
	 * 获取推荐商品列表
	 * 
	 * @param pageSize
	 * @param pageNum
	 * @param dataType
	 * @param orderByColumn
	 * @param isASC
	 * @return
	 */
	public List<SpGoods> getReCommondGoodsList(String pageSize, String pageNum, String dataType, String orderByColumn,
			String isASC) {
		if (StringUtils.isEmpty(dataType)) {
			dataType = "1";
		}
		if (StringUtils.isEmpty(orderByColumn)) {
			orderByColumn = "sort";
		}
		if (StringUtils.isEmpty(isASC)) {
			isASC = "desc";
		}
		startPage(Integer.parseInt(pageSize), Integer.parseInt(pageNum), orderByColumn, isASC);
		return spGoodsService.selectSpGoodsGoodsListByGoodsType(dataType);
	}

	/**
	 * 查询非推荐型的商品列表
	 * 
	 * @param pageSize
	 * @param pageNum
	 * @param dataType
	 * @param orderByColumn
	 * @param isASC
	 * @return
	 */
	public List<SpGoods> getGoodsListByGoodType(String pageSize, String pageNum, Integer dataType, String orderByColumn,
			String isASC) {
		if (dataType == 0) {
			dataType = 1;
		}
		if (StringUtils.isEmpty(orderByColumn)) {
			orderByColumn = "sort";
		}
		if (StringUtils.isEmpty(isASC)) {
			isASC = "desc";
		}
		SpGoods mGoods = new SpGoods();
		switch (dataType) {
		case 1:
			mGoods.setIsBest("1");// 精品
			break;
		case 2:
			mGoods.setIsHot("2");// 热销
			break;
		case 3:
			mGoods.setIsNew("3");
			;// 新品
			break;
		case 4:
			mGoods.setIsRecom("4");
			;// 推荐
			break;
		}
		mGoods.setDelFlag("0");
		mGoods.setStatus("0");
		return spGoodsService.selectSpGoodsList(mGoods);
	}

	/**
	 * 获取精品 如果推荐表中没有就根据各商家的设置推荐
	 * 
	 * @param pageSize
	 * @param pageNum
	 * @param dataType
	 * @param orderByColumn
	 * @param isASC
	 * @return
	 */
	public List<SpGoods> getGoodsDataTypeList(String pageSize, String pageNum, String dataType, String orderByColumn,
			String isASC) {
		List<SpGoods> mGoods = getReCommondGoodsList(pageSize, pageNum, dataType, orderByColumn, isASC);
		
		if(mGoods.size() == 0) {
			mGoods = getGoodsListByGoodType(pageSize, pageNum, Integer.parseInt(dataType), orderByColumn, isASC);
		}
		return mGoods;
	}
	/**
	 * 获取分层商品数据
	 * @param goodsPageSize
	 * @param goodsPageNum
	 * @param orderByColumn
	 * @param isASC
	 * @return
	 */
	public List<SpGoodsCats> getFloorGoodsList(String goodsPageSize, String goodsPageNum,  String orderByColumn,
			String isASC){
		SpGoodsCats mmCats = new SpGoodsCats();
		mmCats.setParentId("0");
		mmCats.setStatus("0");
		mmCats.setDataFlag("0");
		List<SpGoodsCats> mCats = spGoodsCatsService.selectSpGoodsCatsList(mmCats);
		for (SpGoodsCats spGoodsCats : mCats) {
			SpGoods mGoods = new SpGoods();
			mGoods.setGoodscatId(spGoodsCats.getMid());
			List<SpGoods> mGoodList = seleGoodsList(goodsPageSize,goodsPageNum,orderByColumn,isASC,mGoods);
			spGoodsCats.setSpGoodsList(mGoodList);
		}
		return mCats;
	}
	/**
	 * 查询店铺各层商品
	 * @param goodsPageSize
	 * @param goodsPageNum
	 * @param orderByColumn
	 * @param isASC
	 * @param shopId
	 * @return
	 */
	public List<SpGoodsCats> getSelfShopFloorGoodsList(String goodsPageSize, String goodsPageNum,  String orderByColumn,
			String isASC, String shopId){
		SpGoodsCats mmCats = new SpGoodsCats();
		mmCats.setParentId("0");
		mmCats.setStatus("0");
		mmCats.setDataFlag("0");
		List<SpGoodsCats> mCats = spGoodsCatsService.selectSpGoodsCatsList(mmCats);
		for (SpGoodsCats spGoodsCats : mCats) {
			SpGoods mGoods = new SpGoods();
			mGoods.setGoodscatId(spGoodsCats.getMid());
			mGoods.setShopId(shopId);
			List<SpGoods> mGoodList = seleGoodsList(goodsPageSize,goodsPageNum,orderByColumn,isASC,mGoods);
			spGoodsCats.setSpGoodsList(mGoodList);
		}
		return mCats;
	}
	/**
	 * 获取系统推荐的商品
	 * @param goodsPageSize
	 * @param goodsPageNum
	 * @param orderByColumn
	 * @param isASC
	 * @return
	 */
	public List<SpGoods> getSysRecommendSpGoodsList(String goodsPageSize, String goodsPageNum,  String orderByColumn,
			String isASC){
		SpGoods mGoods = new SpGoods();
		//mGoods.setGoodscatId(spGoodsCats.getMid());
		//mGoods.setShopId(shopId);
		List<SpGoods> mGoodList = seleGoodsList(goodsPageSize,goodsPageNum,orderByColumn,isASC,mGoods);
		return mGoodList;
	} 
	/**
	 * 获取系统最喜欢的商品
	 * @param goodsPageSize
	 * @param goodsPageNum
	 * @param orderByColumn
	 * @param isASC
	 * @return
	 */
	public List<SpGoods> getSysFavouriteSpGoodsList(String goodsPageSize, String goodsPageNum,  String orderByColumn,
			String isASC){
		SpGoods mGoods = new SpGoods();
		//mGoods.setGoodscatId(spGoodsCats.getMid());
		//mGoods.setShopId(shopId);
		List<SpGoods> mGoodList = seleGoodsList(goodsPageSize,goodsPageNum,orderByColumn,isASC,mGoods);
		return mGoodList;
	} 	
	/**
	 * 获取系统关注的商品
	 * @param goodsPageSize
	 * @param goodsPageNum
	 * @param orderByColumn
	 * @param isASC
	 * @return
	 */
	public List<SpGoods> getSysFollowSpGoodsList(String goodsPageSize, String goodsPageNum,  String orderByColumn,
			String isASC){
		SpGoods mGoods = new SpGoods();
		//mGoods.setGoodscatId(spGoodsCats.getMid());
		//mGoods.setShopId(shopId);
		List<SpGoods> mGoodList = seleGoodsList(goodsPageSize,goodsPageNum,orderByColumn,isASC,mGoods);
		return mGoodList;
	}	
}
