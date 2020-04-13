package com.lnbei.sp.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 售后服务ID表 sp_log_services
 * 
 * @author lnbei
 * @date 2020-03-23
 */
public class SpLogServices extends SpBase
{
	private static final long serialVersionUID = 1L;
	
	/** 自增ID */
	private Integer mid;
	/** 订单id */
	private Integer orderId;
	/** 售后id */
	private Integer serviceId;
	/** 操作日志 */
	private String logContent;
	/** 操作者Id,如果是商家的话记录商家的ID */
	private Integer logTargetId;
	/** 操作者类型,0：用户  1：商家 */
	private Integer logType;


	public void setMid(Integer mid) 
	{
		this.mid = mid;
	}

	public Integer getMid() 
	{
		return mid;
	}
	public void setOrderId(Integer orderId) 
	{
		this.orderId = orderId;
	}

	public Integer getOrderId() 
	{
		return orderId;
	}
	public void setServiceId(Integer serviceId) 
	{
		this.serviceId = serviceId;
	}

	public Integer getServiceId() 
	{
		return serviceId;
	}
	public void setLogContent(String logContent) 
	{
		this.logContent = logContent;
	}

	public String getLogContent() 
	{
		return logContent;
	}
	public void setLogTargetId(Integer logTargetId) 
	{
		this.logTargetId = logTargetId;
	}

	public Integer getLogTargetId() 
	{
		return logTargetId;
	}
	public void setLogType(Integer logType) 
	{
		this.logType = logType;
	}

	public Integer getLogType() 
	{
		return logType;
	}


    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("mid", getMid())
            .append("orderId", getOrderId())
            .append("serviceId", getServiceId())
            .append("logContent", getLogContent())
            .append("logTargetId", getLogTargetId())
            .append("logType", getLogType())
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
