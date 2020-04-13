package com.lnbei.sp.domain;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 订单快递表 sp_order_express
 * 
 * @author lnbei
 * @date 2020-02-05
 */
public class SpOrderExpress extends SpBase
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private String mid;
	/**  */
	private String orderId;
	/**  */
	private String ordergoodsId;
	/**  */
	private Date deliveryTime;
	/** 1:��ҫ����  0:�������� */
	private String isExpress;
	/**  */
	private String expressId;
	/**  */
	private String expressNo;


	public void setMid(String mid) 
	{
		this.mid = mid;
	}

	public String getMid() 
	{
		return mid;
	}
	public void setOrderId(String orderId) 
	{
		this.orderId = orderId;
	}

	public String getOrderId() 
	{
		return orderId;
	}
	public void setOrdergoodsId(String ordergoodsId) 
	{
		this.ordergoodsId = ordergoodsId;
	}

	public String getOrdergoodsId() 
	{
		return ordergoodsId;
	}
	public void setDeliveryTime(Date deliveryTime) 
	{
		this.deliveryTime = deliveryTime;
	}

	public Date getDeliveryTime() 
	{
		return deliveryTime;
	}
	public void setIsExpress(String isExpress) 
	{
		this.isExpress = isExpress;
	}

	public String getIsExpress() 
	{
		return isExpress;
	}
	public void setExpressId(String expressId) 
	{
		this.expressId = expressId;
	}

	public String getExpressId() 
	{
		return expressId;
	}
	public void setExpressNo(String expressNo) 
	{
		this.expressNo = expressNo;
	}

	public String getExpressNo() 
	{
		return expressNo;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("mid", getMid())
            .append("orderId", getOrderId())
            .append("ordergoodsId", getOrdergoodsId())
            .append("deliveryTime", getDeliveryTime())
            .append("isExpress", getIsExpress())
            .append("expressId", getExpressId())
            .append("expressNo", getExpressNo())
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
