package com.lnbei.wf.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 流程步骤角色表 wf_workflow_step_role
 * 
 * @author lnbei
 * @date 2020-02-08
 */
public class WfWorkflowStepRole extends WfBase
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
	private String roleId;
	/**  */
	private String isAll;

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
	public void setRoleId(String roleId) 
	{
		this.roleId = roleId;
	}

	public String getRoleId() 
	{
		return roleId;
	}
	public void setIsAll(String isAll) 
	{
		this.isAll = isAll;
	}

	public String getIsAll() 
	{
		return isAll;
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
            .append("roleIds", getRoleId())
            .append("isAll", getIsAll())
            .toString();
    }
}
