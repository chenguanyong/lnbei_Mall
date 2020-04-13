package com.lnbei.sp.viewdomain;

import com.lnbei.sp.domain.SpBase;
/**
 * 商品搜索实体
 * @author chen
 *
 */
public class SpGoodsView extends SpBase {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 商品名称
	 */
	private String searchName;
	/**
	 * 商品类别ID
	 */
	private String goodsCateId;
	/**
	 * 商品属性Id
	 */
	private String goodsAtrrId;
	/**
	 * 商品属性
	 */
	private String goodsSpecId;

	private String isBest;
	/**  */
	private String isHot;
	/**  */
	private String isNew;
	/**  */
	private String isRecom;

	private String shopCatId1;
	/**  */
	private String shopCatId2;
	
	private String isFreeshipping;//包邮
	
	private String goodsSerachKeyWords;
	/**
	 * 是否本搜索店铺
	 */
	private String isSelfShop;
	
	private String shopId;
	
	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public String getIsSelfShop() {
		return isSelfShop;
	}

	public void setIsSelfShop(String isSelfShop) {
		this.isSelfShop = isSelfShop;
	}

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public String getGoodsCateId() {
		return goodsCateId;
	}

	public void setGoodsCateId(String goodsCateId) {
		this.goodsCateId = goodsCateId;
	}

	public String getGoodsAtrrId() {
		return goodsAtrrId;
	}

	public void setGoodsAtrrId(String goodsAtrrId) {
		this.goodsAtrrId = goodsAtrrId;
	}

	public String getGoodsSpecId() {
		return goodsSpecId;
	}

	public void setGoodsSpecId(String goodsSpecId) {
		this.goodsSpecId = goodsSpecId;
	}

	public String getIsBest() {
		return isBest;
	}

	public void setIsBest(String isBest) {
		this.isBest = isBest;
	}

	public String getIsHot() {
		return isHot;
	}

	public void setIsHot(String isHot) {
		this.isHot = isHot;
	}

	public String getIsNew() {
		return isNew;
	}

	public void setIsNew(String isNew) {
		this.isNew = isNew;
	}

	public String getIsRecom() {
		return isRecom;
	}

	public void setIsRecom(String isRecom) {
		this.isRecom = isRecom;
	}

	public String getShopCatId1() {
		return shopCatId1;
	}

	public void setShopCatId1(String shopCatId1) {
		this.shopCatId1 = shopCatId1;
	}

	public String getShopCatId2() {
		return shopCatId2;
	}

	public void setShopCatId2(String shopCatId2) {
		this.shopCatId2 = shopCatId2;
	}

	public String getIsFreeshipping() {
		return isFreeshipping;
	}

	public void setIsFreeshipping(String isFreeshipping) {
		this.isFreeshipping = isFreeshipping;
	}

	public String getGoodsSerachKeyWords() {
		return goodsSerachKeyWords;
	}

	public void setGoodsSerachKeyWords(String goodsSerachKeyWords) {
		this.goodsSerachKeyWords = goodsSerachKeyWords;
	}
	
}
