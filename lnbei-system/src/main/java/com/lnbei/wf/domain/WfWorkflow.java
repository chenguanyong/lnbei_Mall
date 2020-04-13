package com.lnbei.wf.domain;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 流程表 wf_workflow
 * 
 * @author lnbei
 * @date 2020-02-08
 */
public class WfWorkflow extends WfBase
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private String mid;
	/** 工作流名称 */
	private String title;
	/** 工作流类型 */
	private String flowType;

	/**  */
	private String classify;
	/**  */
	private String classifyId;

	private String status;
	
	private List<WfWorkflowStep> mWfWorkflowSteps;
	
	
	
	public List<WfWorkflowStep> getmWfWorkflowSteps() {
		return mWfWorkflowSteps;
	}

	public void setmWfWorkflowSteps(List<WfWorkflowStep> mWfWorkflowSteps) {
		this.mWfWorkflowSteps = mWfWorkflowSteps;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public void setClassify(String classify) 
	{
		this.classify = classify;
	}

	public String getClassify() 
	{
		return classify;
	}
	public void setClassifyId(String classifyId) 
	{
		this.classifyId = classifyId;
	}

	public String getClassifyId() 
	{
		return classifyId;
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
            .append("classify", getClassify())
            .append("classifyId", getClassifyId())
            .toString();
    }
}
