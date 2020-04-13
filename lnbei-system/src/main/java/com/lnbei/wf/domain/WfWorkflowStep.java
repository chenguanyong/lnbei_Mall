package com.lnbei.wf.domain;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 流程步骤表 wf_workflow_step
 * 
 * @author lnbei
 * @date 2020-02-08
 */
public class WfWorkflowStep extends WfBase
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private String mid;
	/** 工作流名称 */
	private String title;
	/** 工作流类型 */
	private String flowType;

	/** 上一步 */
	private String parentId;
	/** 下一步 */
	private String nextId;
	/**  */
	private String flowStatus;
	/** 步号 */
	private Integer stepNum;
	/** 状态名称 */
	private String statusName;
	/** 下一步个数 */
	private Integer nextSize;
	/** 工作流ID */
	private String workflowId;
	/** tiaojian */
	private String conditions;
	
	private String returnId;
	
	private String status;
	/** 是否超时 */
	private String isTimeout;
	/** 超时时间 */
	private Integer timeOut;
	/** 挂起 */
	private String isPending;
	/** 允许委托 */
	private String isCommission;
	
	private String flowFlag;
	
	private String userIds;
	
	private String userNames;
	
	private List<WfWorkflowStepRole> wfWorkflowStepRoles;
	
	private List<WfWorkflowStepUser> wfWorkflowStepUsers;
	
	
	public String getUserIds() {
		return userIds;
	}

	public void setUserIds(String userIds) {
		this.userIds = userIds;
	}

	public String getUserNames() {
		return userNames;
	}

	public void setUserNames(String userNames) {
		this.userNames = userNames;
	}

	public String getFlowFlag() {
		return flowFlag;
	}

	public void setFlowFlag(String flowFlag) {
		this.flowFlag = flowFlag;
	}

	public List<WfWorkflowStepRole> getWfWorkflowStepRoles() {
		return wfWorkflowStepRoles;
	}

	public void setWfWorkflowStepRoles(List<WfWorkflowStepRole> wfWorkflowStepRoles) {
		this.wfWorkflowStepRoles = wfWorkflowStepRoles;
	}

	public List<WfWorkflowStepUser> getWfWorkflowStepUsers() {
		return wfWorkflowStepUsers;
	}

	public void setWfWorkflowStepUsers(List<WfWorkflowStepUser> wfWorkflowStepUsers) {
		this.wfWorkflowStepUsers = wfWorkflowStepUsers;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIsTimeout() {
		return isTimeout;
	}

	public void setIsTimeout(String isTimeout) {
		this.isTimeout = isTimeout;
	}

	public Integer getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(Integer timeOut) {
		this.timeOut = timeOut;
	}

	public String getIsPending() {
		return isPending;
	}

	public void setIsPending(String isPending) {
		this.isPending = isPending;
	}

	public String getIsCommission() {
		return isCommission;
	}

	public void setIsCommission(String isCommission) {
		this.isCommission = isCommission;
	}

	public String getReturnId() {
		return returnId;
	}

	public void setReturnId(String returnId) {
		this.returnId = returnId;
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

	public void setParentId(String parentId) 
	{
		this.parentId = parentId;
	}

	public String getParentId() 
	{
		return parentId;
	}
	public void setNextId(String nextId) 
	{
		this.nextId = nextId;
	}

	public String getNextId() 
	{
		return nextId;
	}
	public void setFlowStatus(String flowStatus) 
	{
		this.flowStatus = flowStatus;
	}

	public String getFlowStatus() 
	{
		return flowStatus;
	}
	public void setStepNum(Integer stepNum) 
	{
		this.stepNum = stepNum;
	}

	public Integer getStepNum() 
	{
		return stepNum;
	}
	public void setStatusName(String statusName) 
	{
		this.statusName = statusName;
	}

	public String getStatusName() 
	{
		return statusName;
	}
	public void setNextSize(Integer nextSize) 
	{
		this.nextSize = nextSize;
	}

	public Integer getNextSize() 
	{
		return nextSize;
	}
	public void setWorkflowId(String workflowId) 
	{
		this.workflowId = workflowId;
	}

	public String getWorkflowId() 
	{
		return workflowId;
	}
	public void setConditions(String conditions) 
	{
		this.conditions = conditions;
	}

	public String getConditions() 
	{
		return conditions;
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
            .append("parentId", getParentId())
            .append("nextId", getNextId())
            .append("flowStatus", getFlowStatus())
            .append("stepNum", getStepNum())
            .append("statusName", getStatusName())
            .append("nextSize", getNextSize())
            .append("workflowId", getWorkflowId())
            .append("condition", getConditions())
            .toString();
    }
}
