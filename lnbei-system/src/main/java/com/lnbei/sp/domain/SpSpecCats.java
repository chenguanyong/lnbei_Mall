package com.lnbei.sp.domain;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 规格分类表 sp_spec_cats
 * 
 * @author lnbei
 * @date 2020-02-05
 */
public class SpSpecCats extends SpBase
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private String mid;
	/**  */
	private String goodsCatId;
	/**  */
	private String goodsCatPath;
	/**  */
	private String catName;
	/**  */
	private String isAllowImg;

	private String catType;
	
	private String shopId;
	
	private String goodsId;
	
	private String goodsCatTitle;
	
	private List<SpSpecItems> spSpecItems;
	
	public String getGoodsCatTitle() {
		return goodsCatTitle;
	}

	public void setGoodsCatTitle(String goodsCatTitle) {
		this.goodsCatTitle = goodsCatTitle;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public List<SpSpecItems> getSpSpecItems() {
		return spSpecItems;
	}

	public void setSpSpecItems(List<SpSpecItems> spSpecItems) {
		this.spSpecItems = spSpecItems;
	}

	public String getCatType() {
		return catType;
	}

	public void setCatType(String catType) {
		this.catType = catType;
	}

	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public void setMid(String mid) 
	{
		this.mid = mid;
	}

	public String getMid() 
	{
		return mid;
	}
	public void setGoodsCatId(String goodsCatId) 
	{
		this.goodsCatId = goodsCatId;
	}

	public String getGoodsCatId() 
	{
		return goodsCatId;
	}
	public void setGoodsCatPath(String goodsCatPath) 
	{
		this.goodsCatPath = goodsCatPath;
	}

	public String getGoodsCatPath() 
	{
		return goodsCatPath;
	}
	public void setCatName(String catName) 
	{
		this.catName = catName;
	}

	public String getCatName() 
	{
		return catName;
	}
	public void setIsAllowImg(String isAllowImg) 
	{
		this.isAllowImg = isAllowImg;
	}

	public String getIsAllowImg() 
	{
		return isAllowImg;
	}


	public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("mid", getMid())
            .append("goodsCatId", getGoodsCatId())
            .append("goodsCatPath", getGoodsCatPath())
            .append("catName", getCatName())
            .append("isAllowImg", getIsAllowImg())
            .append("status", getStatus())
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
