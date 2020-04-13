package com.lnbei.sp.domain;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 服务关系表 sp_service_goods
 * 
 * @author lnbei
 * @date 2020-02-20
 */
public class SpServiceGoods extends SpBase
{
	private static final long serialVersionUID = 1L;
	
	/** 自增ID */
	private String mid;
	/** 订单id */
	private String orderId;
	/** 售后id */
	private String serviceId;
	/** 商品ID */
	private String goodsId;
	/** 商品规格ID */
	private String goodsSpecId;
	/** 申请售后的商品数量 */
	private Integer goodsNum;


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
	public void setServiceId(String serviceId) 
	{
		this.serviceId = serviceId;
	}

	public String getServiceId() 
	{
		return serviceId;
	}
	public void setGoodsId(String goodsId) 
	{
		this.goodsId = goodsId;
	}

	public String getGoodsId() 
	{
		return goodsId;
	}
	public void setGoodsSpecId(String goodsSpecId) 
	{
		this.goodsSpecId = goodsSpecId;
	}

	public String getGoodsSpecId() 
	{
		return goodsSpecId;
	}
	public void setGoodsNum(Integer goodsNum) 
	{
		this.goodsNum = goodsNum;
	}

	public Integer getGoodsNum() 
	{
		return goodsNum;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("mid", getMid())
            .append("orderId", getOrderId())
            .append("serviceId", getServiceId())
            .append("goodsId", getGoodsId())
            .append("goodsSpecId", getGoodsSpecId())
            .append("goodsNum", getGoodsNum())
            .append("createTime", getCreateTime())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .append("remark", getRemark())
            .append("sort", getSort())
            .append("status", getStatus())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
