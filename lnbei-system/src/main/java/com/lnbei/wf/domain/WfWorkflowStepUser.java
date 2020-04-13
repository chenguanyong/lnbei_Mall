package com.lnbei.wf.domain;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 流程步骤用户表 wf_workflow_step_user
 * 
 * @author lnbei
 * @date 2020-02-08
 */
public class WfWorkflowStepUser extends WfBase
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private String mid;
	/** 工作流名称 */
	private String title;
	/** 工作流类型 */
	private String flowType;
	
	/**  */
	private String workflowId;
	/**  */
	private String wfstepId;
	/**  */
	private String status;
	/**  */
	private String userId;
	/**  */
	private String userType;
	/**  */
	private String isAll;
	/** 是否查看 */
	private String isLook;
	/** 是否操作 */
	private String isOperate;
	
	private String commissionId;
	
	
	private WfWorkflowUserOperate wfWorkflowUserOperate;
	
	
	
	public String getCommissionId() {
		return commissionId;
	}

	public void setCommissionId(String commissionId) {
		this.commissionId = commissionId;
	}

	public WfWorkflowUserOperate getWfWorkflowUserOperate() {
		return wfWorkflowUserOperate;
	}

	public void setWfWorkflowUserOperate(WfWorkflowUserOperate wfWorkflowUserOperate) {
		this.wfWorkflowUserOperate = wfWorkflowUserOperate;
	}

	public void setMid(String mid) 
	{
		this.mid = mid;
	}

	public String getMid() 
	{
		return mid;
	}
	public void setTitle(String title) 
	{
		this.title = title;
	}

	public String getTitle() 
	{
		return title;
	}
	public void setFlowType(String flowType) 
	{
		this.flowType = flowType;
	}

	public String getFlowType() 
	{
		return flowType;
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
	public void setStatus(String status) 
	{
		this.status = status;
	}

	public String getStatus() 
	{
		return status;
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
	public void setIsAll(String isAll) 
	{
		this.isAll = isAll;
	}

	public String getIsAll() 
	{
		return isAll;
	}
	public void setIsLook(String isLook) 
	{
		this.isLook = isLook;
	}

	public String getIsLook() 
	{
		return isLook;
	}
	public void setIsOperate(String isOperate) 
	{
		this.isOperate = isOperate;
	}

	public String getIsOperate() 
	{
		return isOperate;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("mid", getMid())
            .append("title", getTitle())
            .append("flowType", getFlowType())
            .append("delFlag", getDelFlag())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("deptId", getDeptId())
            .append("deptName", getDeptName())
            .append("sort", getSort())
            .append("workflowId", getWorkflowId())
            .append("wfstepId", getWfstepId())
            .append("status", getStatus())
            .append("userIds", getUserId())
            .append("userType", getUserType())
            .append("isAll", getIsAll())
            .append("isLook", getIsLook())
            .append("isOperate", getIsOperate())
            .toString();
    }
}
