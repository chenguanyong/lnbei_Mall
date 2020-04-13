package com.lnbei.sp.domain;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 优惠劵表 sp_goods_virtuals
 * 
 * @author lnbei
 * @date 2020-02-05
 */
public class SpGoodsVirtuals extends SpBase
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private String mid;
	/**  */
	private String shopId;
	/**  */
	private String goodsId;
	/**  */
	private String cardNo;
	/**  */
	private String cardPwd;
	/**  */
	private String orderId;
	/**  */
	private String orderNo;
	/**  */
	private String isUse;


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
	public void setCardNo(String cardNo) 
	{
		this.cardNo = cardNo;
	}

	public String getCardNo() 
	{
		return cardNo;
	}
	public void setCardPwd(String cardPwd) 
	{
		this.cardPwd = cardPwd;
	}

	public String getCardPwd() 
	{
		return cardPwd;
	}
	public void setOrderId(String orderId) 
	{
		this.orderId = orderId;
	}

	public String getOrderId() 
	{
		return orderId;
	}
	public void setOrderNo(String orderNo) 
	{
		this.orderNo = orderNo;
	}

	public String getOrderNo() 
	{
		return orderNo;
	}
	public void setIsUse(String isUse) 
	{
		this.isUse = isUse;
	}

	public String getIsUse() 
	{
		return isUse;
	}
	
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("mid", getMid())
            .append("shopId", getShopId())
            .append("goodsId", getGoodsId())
            .append("cardNo", getCardNo())
            .append("cardPwd", getCardPwd())
            .append("orderId", getOrderId())
            .append("orderNo", getOrderNo())
            .append("isUse", getIsUse())
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
