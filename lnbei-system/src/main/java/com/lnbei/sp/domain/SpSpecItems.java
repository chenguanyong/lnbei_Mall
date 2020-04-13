package com.lnbei.sp.domain;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.lnbei.sp.viewdomain.SpSpecItemsView;

/**
 * 规格值表 sp_spec_items
 * 
 * @author lnbei
 * @date 2020-02-05
 */
public class SpSpecItems extends SpSpecItemsView
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private String mid;
	/**  */
	private String shopId;
	/**  */
	private String catId;
	/**  */
	private String goodsId;
	/**  */
	private String itemName;
	/**  */
	private String itemDesc;
	/**  */
	private String itemImg;

	private SpSpecCats mSpecCats;

	public SpSpecCats getmSpecCats() {
		return mSpecCats;
	}

	public void setmSpecCats(SpSpecCats mSpecCats) {
		this.mSpecCats = mSpecCats;
	}

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
	public void setGoodsId(String goodsId) 
	{
		this.goodsId = goodsId;
	}

	public String getGoodsId() 
	{
		return goodsId;
	}
	public void setItemName(String itemName) 
	{
		this.itemName = itemName;
	}

	public String getItemName() 
	{
		return itemName;
	}
	public void setItemDesc(String itemDesc) 
	{
		this.itemDesc = itemDesc;
	}

	public String getItemDesc() 
	{
		return itemDesc;
	}
	public void setItemImg(String itemImg) 
	{
		this.itemImg = itemImg;
	}

	public String getItemImg() 
	{
		return itemImg;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("mid", getMid())
            .append("shopId", getShopId())
            .append("catId", getCatId())
            .append("goodsId", getGoodsId())
            .append("itemName", getItemName())
            .append("itemDesc", getItemDesc())
            .append("itemImg", getItemImg())
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
