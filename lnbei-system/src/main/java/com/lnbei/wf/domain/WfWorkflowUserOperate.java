package com.lnbei.wf.domain;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 流程用户操作表 wf_workflow_user_operate
 * 
 * @author lnbei
 * @date 2020-02-08
 */
public class WfWorkflowUserOperate extends WfBase
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private String mid;
	/**  */
	private String memberId;
	/**  */
	private String userId;
	/** 用户类型 */
	private String userType;
	/**  */
	private String opinion;

	/**  */
	private String workflowId;
	/**  */
	private String wfstepId;
	
	private String objectId;
	
	private String status;
	
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getObjectId() {
		return objectId;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
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
	public void setUserId(String userId) 
	{
		this.userId = userId;
	}

	public String getUserId() 
	{
		return userId;
	}
	public void setUserType(String userType) 
	{
		this.userType = userType;
	}

	public String getUserType() 
	{
		return userType;
	}
	public void setOpinion(String opinion) 
	{
		this.opinion = opinion;
	}

	public String getOpinion() 
	{
		return opinion;
	}

	public void setWorkflowId(String workflowId) 
	{
		this.workflowId = workflowId;
	}

	public String getWorkflowId() 
	{
		return workflowId;
	}
	public void setWfstepId(String wfstepId) 
	{
		this.wfstepId = wfstepId;
	}

	public String getWfstepId() 
	{
		return wfstepId;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("mid", getMid())
            .append("memberId", getMemberId())
            .append("userId", getUserId())
            .append("userType", getUserType())
            .append("opinion", getOpinion())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("sort", getSort())
            .append("workflowId", getWorkflowId())
            .append("wfstepId", getWfstepId())
            .toString();
    }
}
