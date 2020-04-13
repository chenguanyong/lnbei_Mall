package com.lnbei.fi.domain;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.lnbei.wf.domain.WfBase;
/**
 * 支付方式表 fi_payments
 * 
 * @author lnbei
 * @date 2020-02-13
 */
public class FiPayments extends WfBase
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private String mid;
	/**  */
	private String payCode;
	/**  */
	private String payName;
	/**  */
	private String payDesc;
	/**  */
	private String payOrder;
	/**  */
	private String payConfig;
	/**  */
	private String enabled;
	/**  */
	private String isOnline;
	/**  */
	private String payFor;
	/** 状态 */
	private String status;

	public void setMid(String mid) 
	{
		this.mid = mid;
	}

	public String getMid() 
	{
		return mid;
	}
	public void setPayCode(String payCode) 
	{
		this.payCode = payCode;
	}

	public String getPayCode() 
	{
		return payCode;
	}
	public void setPayName(String payName) 
	{
		this.payName = payName;
	}

	public String getPayName() 
	{
		return payName;
	}
	public void setPayDesc(String payDesc) 
	{
		this.payDesc = payDesc;
	}

	public String getPayDesc() 
	{
		return payDesc;
	}
	public void setPayOrder(String payOrder) 
	{
		this.payOrder = payOrder;
	}

	public String getPayOrder() 
	{
		return payOrder;
	}
	public void setPayConfig(String payConfig) 
	{
		this.payConfig = payConfig;
	}

	public String getPayConfig() 
	{
		return payConfig;
	}
	public void setEnabled(String enabled) 
	{
		this.enabled = enabled;
	}

	public String getEnabled() 
	{
		return enabled;
	}
	public void setIsOnline(String isOnline) 
	{
		this.isOnline = isOnline;
	}

	public String getIsOnline() 
	{
		return isOnline;
	}
	public void setPayFor(String payFor) 
	{
		this.payFor = payFor;
	}

	public String getPayFor() 
	{
		return payFor;
	}

	public void setStatus(String status) 
	{
		this.status = status;
	}

	public String getStatus() 
	{
		return status;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("mid", getMid())
            .append("payCode", getPayCode())
            .append("payName", getPayName())
            .append("payDesc", getPayDesc())
            .append("payOrder", getPayOrder())
            .append("payConfig", getPayConfig())
            .append("enabled", getEnabled())
            .append("isOnline", getIsOnline())
            .append("payFor", getPayFor())
            .append("createTime", getCreateTime())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .append("remark", getRemark())
            .append("sort", getSort())
            .append("status", getStatus())
            .toString();
    }
}
