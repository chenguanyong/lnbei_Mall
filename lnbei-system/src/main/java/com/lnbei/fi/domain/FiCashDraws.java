package com.lnbei.fi.domain;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.lnbei.wf.domain.WfBase;
/**
 * 提现记录表 fi_cash_draws
 * 
 * @author lnbei
 * @date 2020-02-13
 */
public class FiCashDraws extends WfBase
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private String mid;
	/**  */
	private String cashNo;
	/**  */
	private String targetType;
	/**  */
	private String targetId;
	/**  */
	private Float money;
	/**  */
	private String accType;
	/**  */
	private String accTargetName;
	/**  */
	private String accAreaAme;
	/**  */
	private String accNo;
	/**  */
	private String accUser;
	/**  */
	private String cashConfigId;
	/**  */
	private String workflowId;
	/**  */
	private String stepId;
	/**  */
	private String reviewStatus;
	/** 是否挂起 */
	private String isPending;
	/** 状态 */
	private String status;

	public String getWorkflowId() {
		return workflowId;
	}

	public void setWorkflowId(String workflowId) {
		this.workflowId = workflowId;
	}

	public String getStepId() {
		return stepId;
	}

	public void setStepId(String stepId) {
		this.stepId = stepId;
	}

	public String getReviewStatus() {
		return reviewStatus;
	}

	public void setReviewStatus(String reviewStatus) {
		this.reviewStatus = reviewStatus;
	}

	public String getIsPending() {
		return isPending;
	}

	public void setIsPending(String isPending) {
		this.isPending = isPending;
	}

	public void setMid(String mid) 
	{
		this.mid = mid;
	}

	public String getMid() 
	{
		return mid;
	}
	public void setCashNo(String cashNo) 
	{
		this.cashNo = cashNo;
	}

	public String getCashNo() 
	{
		return cashNo;
	}
	public void setTargetType(String targetType) 
	{
		this.targetType = targetType;
	}

	public String getTargetType() 
	{
		return targetType;
	}
	public void setTargetId(String targetId) 
	{
		this.targetId = targetId;
	}

	public String getTargetId() 
	{
		return targetId;
	}
	public void setMoney(Float money) 
	{
		this.money = money;
	}

	public Float getMoney() 
	{
		return money;
	}
	public void setAccType(String accType) 
	{
		this.accType = accType;
	}

	public String getAccType() 
	{
		return accType;
	}
	public void setAccTargetName(String accTargetName) 
	{
		this.accTargetName = accTargetName;
	}

	public String getAccTargetName() 
	{
		return accTargetName;
	}
	public void setAccAreaAme(String accAreaAme) 
	{
		this.accAreaAme = accAreaAme;
	}

	public String getAccAreaAme() 
	{
		return accAreaAme;
	}
	public void setAccNo(String accNo) 
	{
		this.accNo = accNo;
	}

	public String getAccNo() 
	{
		return accNo;
	}
	public void setAccUser(String accUser) 
	{
		this.accUser = accUser;
	}

	public String getAccUser() 
	{
		return accUser;
	}
	public void setCashConfigId(String cashConfigId) 
	{
		this.cashConfigId = cashConfigId;
	}

	public String getCashConfigId() 
	{
		return cashConfigId;
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
            .append("cashNo", getCashNo())
            .append("targetType", getTargetType())
            .append("targetId", getTargetId())
            .append("money", getMoney())
            .append("accType", getAccType())
            .append("accTargetName", getAccTargetName())
            .append("accAreaAme", getAccAreaAme())
            .append("accNo", getAccNo())
            .append("accUser", getAccUser())
            .append("cashConfigId", getCashConfigId())
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
