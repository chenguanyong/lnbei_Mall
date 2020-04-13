package com.lnbei.web.core.wf;

import java.util.List;

import org.apache.ibatis.annotations.Case;
import org.springframework.beans.factory.annotation.Autowired;

import com.lnbei.common.utils.StringUtils;
import com.lnbei.wf.domain.WfWorkflow;
import com.lnbei.wf.domain.WfWorkflowStep;
import com.lnbei.wf.domain.WfWorkflowStepUser;
import com.lnbei.wf.domain.WfWorkflowUserOperate;
import com.lnbei.wf.service.IWfWorkflowService;
import com.lnbei.wf.service.IWfWorkflowStepService;
import com.lnbei.wf.service.IWfWorkflowStepUserService;
import com.lnbei.wf.service.IWfWorkflowUserOperateService;

public class WorkFlowUnit {
	@Autowired
	private IWfWorkflowService mIWfWorkflowService;
	@Autowired
	private IWfWorkflowStepService mIWfWorkflowStepService;
	@Autowired
	private IWfWorkflowUserOperateService mIWfWorkflowUserOperateService;
	@Autowired
	private IWfWorkflowStepUserService mIWfWorkflowStepUserService;
	/**
	 * 主流程
	 */
	private WfWorkflow wfWorkflow;
	/**
	 * 当前步骤Id
	 */
	private String currentStepId;
	/**
	 * 下一步
	 */
	private WfWorkflowStep nextStep;
	/**
	 * 上一步
	 */
	private WfWorkflowStep previousStep;
	/**
	 * 当前步骤
	 */
	private WfWorkflowStep currentStep;
	/**
	 * 状态名称
	 */
	protected String statusName;

	private String objectId;

	private String userOpinion;

	private String workFlowId;

	private WorkFlowParam mFlowParam;

	public String getWorkFlowId() {
		return workFlowId;
	}

	public void setWorkFlowId(String workFlowId) {
		this.workFlowId = workFlowId;
	}

	public String getUserOpinion() {
		return userOpinion;
	}

	public void setUserOpinion(String userOpinion) {
		this.userOpinion = userOpinion;
	}

	public String getObjectId() {
		return objectId;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getCurrentStepId() {
		return currentStepId;
	}

	public void setCurrentStepId(String currentStepId) {
		this.currentStepId = currentStepId;
	}

	public WfWorkflowStep getNextStep() {
		return nextStep;
	}

	public void setNextStep(WfWorkflowStep nextStep) {
		this.nextStep = nextStep;
	}

	public WfWorkflowStep getPreviousStep() {
		return previousStep;
	}

	public void setPreviousStep(WfWorkflowStep previousStep) {
		this.previousStep = previousStep;
	}

	public WfWorkflowStep getCurrentStep() {
		return currentStep;
	}

	public void setCurrentStep(WfWorkflowStep currentStep) {
		this.currentStep = currentStep;
	}

	public WorkFlowUnit(WorkFlowParam mFlowParam) {
		// this.wfWorkflow = mWfWorkflow;
		this.objectId = mFlowParam.getObjectId();
		this.currentStepId = mFlowParam.getCurrentStepId();
		this.statusName = mFlowParam.getStatusName();
		this.workFlowId = mFlowParam.getWorkFlowId();
		this.userOpinion = mFlowParam.getUserOpinion();
		this.mFlowParam = mFlowParam;
	}

	public WfWorkflow getWfWorkflow() {
		return wfWorkflow;
	}

	public void setWfWorkflow(WfWorkflow wfWorkflow) {
		this.wfWorkflow = wfWorkflow;
	}

	public WorkFlowResult next() {
		WorkFlowResult mFlowResult = new WorkFlowResult();
		// 初始化流程
		this.wfWorkflow = mIWfWorkflowService.selectWfWorkflowById(this.workFlowId);
		this.currentStep = getWfWorkflowStep(this.currentStepId);
		this.nextStep = getWfWorkflowStep(this.currentStep.getNextId());
		mFlowResult.setCurrentStatusName(this.nextStep.getStatusName());
		mFlowResult.setCurrentStepId(this.nextStep.getMid());
		mFlowResult.setCurrentStepNum(this.nextStep.getStepNum().toString());
		mFlowResult.setIsPending("0");
		insertUserOpinion(mFlowResult);
		return mFlowResult;
	}

	public WorkFlowResult isPending() {
		WorkFlowResult mFlowResult = new WorkFlowResult();
		// 初始化流程
		this.wfWorkflow = mIWfWorkflowService.selectWfWorkflowById(this.workFlowId);
		this.currentStep = getWfWorkflowStep(this.currentStepId);
		mFlowResult.setCurrentStatusName("挂起");
		mFlowResult.setCurrentStepId(this.currentStepId);
		mFlowResult.setCurrentStepNum(this.currentStep.getStepNum().toString());
		mFlowResult.setIsPending("1");
		return mFlowResult;
	}

	public WorkFlowResult isCommission() {

		WfWorkflowStepUser mWfWorkflowStepUser = new WfWorkflowStepUser();
		mWfWorkflowStepUser.setCommissionId(this.mFlowParam.getCurrentUserId());
		mWfWorkflowStepUser.setUserId(this.mFlowParam.getWfUserId());
		mWfWorkflowStepUser.setUserType("1");
		mWfWorkflowStepUser.setWorkflowId(this.workFlowId);
		mWfWorkflowStepUser.setWfstepId(this.currentStepId);
		mWfWorkflowStepUser.initInsert(this.mFlowParam.getUser());
		mIWfWorkflowStepUserService.insertWfWorkflowStepUser(mWfWorkflowStepUser);
		return null;
	}

	private WfWorkflowStep getWfWorkflowStep(String mid) {
		List<WfWorkflowStep> mWfWorkflowSteps = this.wfWorkflow.getmWfWorkflowSteps();
		for (WfWorkflowStep wfWorkflowStep : mWfWorkflowSteps) {
			if (wfWorkflowStep.getMid() == mid) {
				return wfWorkflowStep;
			}
		}
		return null;
	}

	public WorkFlowResult back() {
		WorkFlowResult mFlowResult = new WorkFlowResult();
		// 初始化流程
		this.wfWorkflow = mIWfWorkflowService.selectWfWorkflowById(this.workFlowId);
		this.currentStep = getWfWorkflowStep(this.currentStepId);
		this.previousStep = getWfWorkflowStep(this.currentStep.getParentId());
		mFlowResult.setCurrentStatusName(this.nextStep.getStatusName());
		mFlowResult.setCurrentStepId(this.nextStep.getMid());
		mFlowResult.setCurrentStepNum(this.nextStep.getStepNum().toString());
		mFlowResult.setIsPending("0");
		insertUserOpinion(mFlowResult);
		return mFlowResult;
	}

	private int insertUserOpinion(WorkFlowResult FlowResult) {
		WfWorkflowUserOperate mWfWorkflowUserOperate = new WfWorkflowUserOperate();
		mWfWorkflowUserOperate.setObjectId(this.objectId);
		mWfWorkflowUserOperate.setStatus("0");
		mWfWorkflowUserOperate.setWfstepId(this.currentStepId);
		mWfWorkflowUserOperate.setWorkflowId(this.workFlowId);
		mWfWorkflowUserOperate.setUserId(this.mFlowParam.getCurrentUserId());
		mWfWorkflowUserOperate.setOpinion(this.userOpinion);
		int result = 0;
		if (StringUtils.isEmpty(this.mFlowParam.getUserOperateId())) {
			mWfWorkflowUserOperate.initInsert(this.mFlowParam.getUser());
			result = mIWfWorkflowUserOperateService.insertWfWorkflowUserOperate(mWfWorkflowUserOperate);
		} else {
			mWfWorkflowUserOperate.setMid(this.mFlowParam.getUserOperateId());
			result = mIWfWorkflowUserOperateService.updateWfWorkflowUserOperate(mWfWorkflowUserOperate);
		}
		return result;
	}

	public WorkFlowResult run() {
		WorkFlowResult mFlowResult = new WorkFlowResult();
		switch (this.mFlowParam.getWfFlag()) {
		case "0": {
			mFlowResult = next();
			break;
		}
		case "1": {
			mFlowResult = back();
			break;
		}
		case "2": {
			mFlowResult = isPending();
			break;
		}
		case "3": {
			mFlowResult = isCommission();
			break;
		}
		}
		return mFlowResult;
	}
}
