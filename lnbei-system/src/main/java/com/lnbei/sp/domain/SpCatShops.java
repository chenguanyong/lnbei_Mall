package com.lnbei.sp.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 类别和店铺表 sp_cat_shops
 * 
 * @author lnbei
 * @date 2020-03-06
 */
public class SpCatShops extends SpBase
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private String mid;
	/**  */
	private String shopId;
	/**  */
	private String catId;

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
	public void setCatId(String catId) 
	{
		this.catId = catId;
	}

	public String getCatId() 
	{
		return catId;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("mid", getMid())
            .append("shopId", getShopId())
            .append("catId", getCatId())
            .toString();
    }
}
