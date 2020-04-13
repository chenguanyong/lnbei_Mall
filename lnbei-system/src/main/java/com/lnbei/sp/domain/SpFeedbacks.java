package com.lnbei.sp.domain;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 反馈表 sp_feedbacks
 * 
 * @author lnbei
 * @date 2020-03-23
 */
public class SpFeedbacks extends SpBase
{
	private static final long serialVersionUID = 1L;
	
	/** 自增ID */
	private String mid;
	/** 反馈类型 */
	private Integer feedbackType;
	/** 反馈内容 */
	private String feedbackContent;
	/** 反馈者ID */
	private String memberId;
	/** 联系方式 手机/qq/微信 */
	private String contactInfo;
	/** 处理人 */
	private String staffId;
	/** 处理时间 */
	private Date handleTime;
	/** 处理结果 */
	private String handleContent;

	public void setMid(String mid) 
	{
		this.mid = mid;
	}

	public String getMid() 
	{
		return mid;
	}
	public void setFeedbackType(Integer feedbackType) 
	{
		this.feedbackType = feedbackType;
	}

	public Integer getFeedbackType() 
	{
		return feedbackType;
	}
	public void setFeedbackContent(String feedbackContent) 
	{
		this.feedbackContent = feedbackContent;
	}

	public String getFeedbackContent() 
	{
		return feedbackContent;
	}
	public void setMemberId(String memberId) 
	{
		this.memberId = memberId;
	}

	public String getMemberId() 
	{
		return memberId;
	}
	public void setContactInfo(String contactInfo) 
	{
		this.contactInfo = contactInfo;
	}

	public String getContactInfo() 
	{
		return contactInfo;
	}

	public void setStaffId(String staffId) 
	{
		this.staffId = staffId;
	}

	public String getStaffId() 
	{
		return staffId;
	}
	public void setHandleTime(Date handleTime) 
	{
		this.handleTime = handleTime;
	}

	public Date getHandleTime() 
	{
		return handleTime;
	}
	public void setHandleContent(String handleContent) 
	{
		this.handleContent = handleContent;
	}

	public String getHandleContent() 
	{
		return handleContent;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("mid", getMid())
            .append("feedbackType", getFeedbackType())
            .append("feedbackContent", getFeedbackContent())
            .append("memberId", getMemberId())
            .append("contactInfo", getContactInfo())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("deptId", getDeptId())
            .append("deptName", getDeptName())
            .append("sort", getSort())
            .append("status", getStatus())
            .append("staffId", getStaffId())
            .append("handleTime", getHandleTime())
            .append("handleContent", getHandleContent())
            .toString();
    }
}
