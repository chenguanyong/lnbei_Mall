package com.lnbei.sp.domain;

import java.math.BigDecimal;


import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.lnbei.sp.viewdomain.SpGoodsSpecsView;

/**
 * 商品规格表 sp_goods_specs
 * 
 * @author lnbei
 * @date 2020-02-05
 */
public class SpGoodsSpecs extends SpGoodsSpecsView
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private String mid;
	/**  */
	private String shopId;
	/**  */
	private String goodsId;
	/**  */
	private String productNo;
	/**  */
	private String specIds;
	/**  */
	private BigDecimal marketPrice;
	/**  */
	private BigDecimal specPrice;
	/**  */
	private BigDecimal specStock;
	/**  */
	private BigDecimal warnStock;
	/**  */
	private BigDecimal saleNum;
	/**  */
	private String isDefault;
	
	private String itemName0id;
	
	private String itemName0;
	
	private String itemName1id;
	
	private String itemName1;
	
	public String getItemName0id() {
		return itemName0id;
	}

	public void setItemName0id(String itemName0id) {
		this.itemName0id = itemName0id;
	}

	public String getItemName0() {
		return itemName0;
	}

	public void setItemName0(String itemName0) {
		this.itemName0 = itemName0;
	}

	public String getItemName1id() {
		return itemName1id;
	}

	public void setItemName1id(String itemName1id) {
		this.itemName1id = itemName1id;
	}

	public String getItemName1() {
		return itemName1;
	}

	public void setItemName1(String itemName1) {
		this.itemName1 = itemName1;
	}



	/** 商品重量 */
	private BigDecimal specWeight;
	/** 商品体积 */
	private BigDecimal specVolume;



	public void setMid(String mid) 
	{
		this.mid = mid;
	}

	public String getMid() 
	{
		return mid;
	}
	public void setShopId(String shopId) 
	{
		this.shopId = shopId;
	}

	public String getShopId() 
	{
		return shopId;
	}
	public void setGoodsId(String goodsId) 
	{
		this.goodsId = goodsId;
	}

	public String getGoodsId() 
	{
		return goodsId;
	}
	public void setProductNo(String productNo) 
	{
		this.productNo = productNo;
	}

	public String getProductNo() 
	{
		return productNo;
	}
	public void setSpecIds(String specIds) 
	{
		this.specIds = specIds;
	}

	public String getSpecIds() 
	{
		return specIds;
	}
	public void setMarketPrice(BigDecimal marketPrice) 
	{
		this.marketPrice = marketPrice;
	}

	public BigDecimal getMarketPrice() 
	{
		return marketPrice;
	}
	public void setSpecPrice(BigDecimal specPrice) 
	{
		this.specPrice = specPrice;
	}

	public BigDecimal getSpecPrice() 
	{
		return specPrice;
	}
	public void setSpecStock(BigDecimal specStock) 
	{
		this.specStock = specStock;
	}

	public BigDecimal getSpecStock() 
	{
		return specStock;
	}

	public BigDecimal getWarnStock() {
		return warnStock;
	}

	public void setWarnStock(BigDecimal warnStock) {
		this.warnStock = warnStock;
	}

	public BigDecimal getSaleNum() {
		return saleNum;
	}

	public void setSaleNum(BigDecimal saleNum) {
		this.saleNum = saleNum;
	}

	public void setIsDefault(String isDefault) 
	{
		this.isDefault = isDefault;
	}

	public String getIsDefault() 
	{
		return isDefault;
	}
	public void setSpecWeight(BigDecimal specWeight) 
	{
		this.specWeight = specWeight;
	}

	public BigDecimal getSpecWeight() 
	{
		return specWeight;
	}
	public void setSpecVolume(BigDecimal specVolume) 
	{
		this.specVolume = specVolume;
	}

	public BigDecimal getSpecVolume() 
	{
		return specVolume;
	}

	

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("mid", getMid())
            .append("shopId", getShopId())
            .append("goodsId", getGoodsId())
            .append("productNo", getProductNo())
            .append("specIds", getSpecIds())
            .append("marketPrice", getMarketPrice())
            .append("specPrice", getSpecPrice())
            .append("specStock", getSpecStock())
            .append("warnStock", getWarnStock())
            .append("saleNum", getSaleNum())
            .append("isDefault", getIsDefault())
            .append("specWeight", getSpecWeight())
            .append("specVolume", getSpecVolume())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("deptId", getDeptId())
            .append("deptName", getDeptName())
            .append("sort", getSort())
            .toString();
    }
}
