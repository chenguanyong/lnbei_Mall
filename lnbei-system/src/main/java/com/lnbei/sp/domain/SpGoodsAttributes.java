package com.lnbei.sp.domain;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 商品属性表 sp_goods_attributes
 * 
 * @author lnbei
 * @date 2020-02-05
 */
public class SpGoodsAttributes extends SpBase
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private String mid;
	/**  */
	private String shopId;
	/**  */
	private String goodsId;
	/**  */
	private String attrId;
	/**  */
	private String attrVal;


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
	public void setAttrId(String attrId) 
	{
		this.attrId = attrId;
	}

	public String getAttrId() 
	{
		return attrId;
	}
	public void setAttrVal(String attrVal) 
	{
		this.attrVal = attrVal;
	}

	public String getAttrVal() 
	{
		return attrVal;
	}


    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("mid", getMid())
            .append("shopId", getShopId())
            .append("goodsId", getGoodsId())
            .append("attrId", getAttrId())
            .append("attrVal", getAttrVal())
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
