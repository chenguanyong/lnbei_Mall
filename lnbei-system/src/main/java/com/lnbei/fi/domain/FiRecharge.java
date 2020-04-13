package com.lnbei.fi.domain;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.lnbei.common.core.domain.BaseEntity;
import com.lnbei.wf.domain.WfBase;
/**
 * 充值表 fi_recharge
 * 
 * @author lnbei
 * @date 2020-02-13
 */
public class FiRecharge extends WfBase
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private String mid;
	/**  */
	private String memberId;
	/**  */
	private String serialNumber;
	/**  */
	private String moneyType;
	/**  */
	private Float money;
	/** 状态：0-申请；1-批准；2-不批准 */
	private String status;
	/** 凭证图片的路径 */
	private String voucher;
	/** 审核时间 */
	private Integer checkTime;
	/** 留言内容 */
	private String content;
	/**  */
	private String workflowId;
	/**  */
	private String stepId;
	/**  */
	private String reviewStatus;
	/** 是否挂起 */
	private String isPending;

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
	public void setMemberId(String memberId) 
	{
		this.memberId = memberId;
	}

	public String getMemberId() 
	{
		return memberId;
	}
	public void setSerialNumber(String serialNumber) 
	{
		this.serialNumber = serialNumber;
	}

	public String getSerialNumber() 
	{
		return serialNumber;
	}
	public void setMoneyType(String moneyType) 
	{
		this.moneyType = moneyType;
	}

	public String getMoneyType() 
	{
		return moneyType;
	}
	public void setMoney(Float money) 
	{
		this.money = money;
	}

	public Float getMoney() 
	{
		return money;
	}
	public void setStatus(String status) 
	{
		this.status = status;
	}

	public String getStatus() 
	{
		return status;
	}
	public void setVoucher(String voucher) 
	{
		this.voucher = voucher;
	}

	public String getVoucher() 
	{
		return voucher;
	}
	public void setCheckTime(Integer checkTime) 
	{
		this.checkTime = checkTime;
	}

	public Integer getCheckTime() 
	{
		return checkTime;
	}
	public void setContent(String content) 
	{
		this.content = content;
	}

	public String getContent() 
	{
		return content;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("mid", getMid())
            .append("memberId", getMemberId())
            .append("serialNumber", getSerialNumber())
            .append("moneyType", getMoneyType())
            .append("money", getMoney())
            .append("status", getStatus())
            .append("voucher", getVoucher())
            .append("checkTime", getCheckTime())
            .append("content", getContent())
            .append("createTime", getCreateTime())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .append("remark", getRemark())
            .append("sort", getSort())
            .toString();
    }
}
