package com.lnbei.web.core.wf;

import com.lnbei.member.domain.MemberUser;
import com.lnbei.system.domain.SysUser;

public class WorkFlowParam {
/**
 * 用户意见
 */
	private String userOpinion;
/**
 * 当前步骤
 */
	private String currentStepId;// 当前步号
	
	/**
	 * 状态名称
	 */
	private String statusName;
	/**
	 * 流程ID
	 */
	private String workFlowId;
	/**
	 * 当前需要审核的项目ID
	 */
	private String objectId;
	/**
	 * 委托人
	 */
	private String wfUserId;
	/**
	 * 委托人名称
	 */
	private String wfUserName;

	private String currentUserId;
	private String currentUserName;
	private Object user;
	
	/**
	 * 用户意见ID
	 */
	private String userOperateId;
	
	private String wfFlag;

	

	public String getWfFlag() {
		return wfFlag;
	}

	public void setWfFlag(String wfFlag) {
		this.wfFlag = wfFlag;
	}

	public String getUserOperateId() {
		return userOperateId;
	}

	public void setUserOperateId(String userOperateId) {
		this.userOperateId = userOperateId;
	}

	public Object getUser() {
		return user;
	}

	public void setUser(Object user) {
		this.user = user;
	}

	public String getCurrentUserId() {
		return currentUserId;
	}

	public void setCurrentUserId(String currentUserId) {
		this.currentUserId = currentUserId;
	}

	public String getCurrentUserName() {
		return currentUserName;
	}

	public void setCurrentUserName(String currentUserName) {
		this.currentUserName = currentUserName;
	}

	public WorkFlowParam(Object user) {
		this.user = user;
		if (user instanceof SysUser) {

			SysUser mSysUser = (SysUser) user;
			this.currentUserId = mSysUser.getId();
			this.currentUserName = mSysUser.getLogName();
		} else if (user instanceof MemberUser) {
			MemberUser mSysUser = (MemberUser) user;
			this.currentUserId = mSysUser.getMid();
			this.currentUserName = mSysUser.getLoginName();
		}

	}



	public String getWfUserId() {
		return wfUserId;
	}

	public void setWfUserId(String wfUserId) {
		this.wfUserId = wfUserId;
	}

	public String getWfUserName() {
		return wfUserName;
	}

	public void setWfUserName(String wfUserName) {
		this.wfUserName = wfUserName;
	}

	public String getObjectId() {
		return objectId;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}

	public String getWorkFlowId() {
		return workFlowId;
	}

	public void setWorkFlowId(String workFlowId) {
		this.workFlowId = workFlowId;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getUserOpinion() {
		return userOpinion;
	}

	public void setUserOpinion(String userOpinion) {
		this.userOpinion = userOpinion;
	}

	public String getCurrentStepId() {
		return currentStepId;
	}

	public void setCurrentStepId(String currentStepId) {
		this.currentStepId = currentStepId;
	}

}
