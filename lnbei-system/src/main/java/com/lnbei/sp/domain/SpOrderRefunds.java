package com.lnbei.sp.domain;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * 退款订单表 sp_order_refunds
 * 
 * @author lnbei
 * @date 2020-02-05
 */
public class SpOrderRefunds extends SpBase
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private String mid;
	/**  */
	private String orderId;
	/**  */
	private String refundTo;
	/**  */
	private String refundReson;
	/**  */
	private String refundOtherReson;
	/**  */
	private BigDecimal backMoney;
	/**  */
	private String refundTradeNo;
	/**  */
	private String refundRemark;
	/**  */
	private Date refundTime;
	/**  */
	private String shopRejectReason;
	/**  */
	private String refundStatus;
	/**  */
	private String serviceId;
	/** 售后单是否已退款0：未退款 1：已退款 */
	private String isServiceRefund;


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
	public void setRefundTo(String refundTo) 
	{
		this.refundTo = refundTo;
	}

	public String getRefundTo() 
	{
		return refundTo;
	}
	public void setRefundReson(String refundReson) 
	{
		this.refundReson = refundReson;
	}

	public String getRefundReson() 
	{
		return refundReson;
	}
	public void setRefundOtherReson(String refundOtherReson) 
	{
		this.refundOtherReson = refundOtherReson;
	}

	public String getRefundOtherReson() 
	{
		return refundOtherReson;
	}
	public void setBackMoney(BigDecimal backMoney) 
	{
		this.backMoney = backMoney;
	}

	public BigDecimal getBackMoney() 
	{
		return backMoney;
	}
	public void setRefundTradeNo(String refundTradeNo) 
	{
		this.refundTradeNo = refundTradeNo;
	}

	public String getRefundTradeNo() 
	{
		return refundTradeNo;
	}
	public void setRefundRemark(String refundRemark) 
	{
		this.refundRemark = refundRemark;
	}

	public String getRefundRemark() 
	{
		return refundRemark;
	}
	public void setRefundTime(Date refundTime) 
	{
		this.refundTime = refundTime;
	}

	public Date getRefundTime() 
	{
		return refundTime;
	}
	public void setShopRejectReason(String shopRejectReason) 
	{
		this.shopRejectReason = shopRejectReason;
	}

	public String getShopRejectReason() 
	{
		return shopRejectReason;
	}
	public void setRefundStatus(String refundStatus) 
	{
		this.refundStatus = refundStatus;
	}

	public String getRefundStatus() 
	{
		return refundStatus;
	}
	public void setServiceId(String serviceId) 
	{
		this.serviceId = serviceId;
	}

	public String getServiceId() 
	{
		return serviceId;
	}
	public void setIsServiceRefund(String isServiceRefund) 
	{
		this.isServiceRefund = isServiceRefund;
	}

	public String getIsServiceRefund() 
	{
		return isServiceRefund;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("mid", getMid())
            .append("orderId", getOrderId())
            .append("refundTo", getRefundTo())
            .append("refundReson", getRefundReson())
            .append("refundOtherReson", getRefundOtherReson())
            .append("backMoney", getBackMoney())
            .append("refundTradeNo", getRefundTradeNo())
            .append("refundRemark", getRefundRemark())
            .append("refundTime", getRefundTime())
            .append("shopRejectReason", getShopRejectReason())
            .append("refundStatus", getRefundStatus())
            .append("serviceId", getServiceId())
            .append("isServiceRefund", getIsServiceRefund())
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
