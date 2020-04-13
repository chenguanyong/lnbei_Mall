package com.lnbei.web.core.wf;
/***
 * 处理流程返回的结果
 * @author Administrator
 *
 */
public class WorkFlowResult {
	
	private String currentStepId;
	
	private String statusName;//上一步的状态名称
	
	private String currentStepNum;//当前步号
	
	private String currentStatusName;//当前状态名称
	
	private String isPending;
	
	
	public String getIsPending() {
		return isPending;
	}

	public void setIsPending(String isPending) {
		this.isPending = isPending;
	}

	public WorkFlowResult() {
		
	}

	public String getCurrentStepId() {
		return currentStepId;
	}

	public void setCurrentStepId(String currentStepId) {
		this.currentStepId = currentStepId;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getCurrentStepNum() {
		return currentStepNum;
	}

	public void setCurrentStepNum(String currentStepNum) {
		this.currentStepNum = currentStepNum;
	}

	public String getCurrentStatusName() {
		return currentStatusName;
	}

	public void setCurrentStatusName(String currentStatusName) {
		this.currentStatusName = currentStatusName;
	}
	
}
