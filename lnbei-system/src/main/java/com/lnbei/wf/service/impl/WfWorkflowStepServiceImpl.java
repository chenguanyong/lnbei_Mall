package com.lnbei.wf.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lnbei.wf.mapper.WfWorkflowStepMapper;
import com.lnbei.wf.mapper.WfWorkflowStepUserMapper;
import com.lnbei.wf.domain.WfWorkflowStep;
import com.lnbei.wf.domain.WfWorkflowStepUser;
import com.lnbei.wf.service.IWfWorkflowStepService;
import com.lnbei.common.core.text.Convert;

/**
 * 流程步骤 服务层实现
 * 
 * @author lnbei
 * @date 2020-02-08
 */
@Service
public class WfWorkflowStepServiceImpl implements IWfWorkflowStepService {
	@Autowired
	private WfWorkflowStepMapper wfWorkflowStepMapper;

	@Autowired
	private WfWorkflowStepUserMapper wfWorkflowStepUserMapper;

	/**
	 * 查询流程步骤信息
	 * 
	 * @param mid 流程步骤ID
	 * @return 流程步骤信息
	 */
	@Override
	public WfWorkflowStep selectWfWorkflowStepById(String mid) {
		return wfWorkflowStepMapper.selectWfWorkflowStepById(mid);
	}

	/**
	 * 查询流程步骤列表
	 * 
	 * @param wfWorkflowStep 流程步骤信息
	 * @return 流程步骤集合
	 */
	@Override
	public List<WfWorkflowStep> selectWfWorkflowStepList(WfWorkflowStep wfWorkflowStep) {
		return wfWorkflowStepMapper.selectWfWorkflowStepList(wfWorkflowStep);
	}

	/**
	 * 新增流程步骤
	 * 
	 * @param wfWorkflowStep 流程步骤信息
	 * @return 结果
	 */
	@Override
	@Transactional
	public int insertWfWorkflowStep(WfWorkflowStep wfWorkflowStep, Object user) {
		WfWorkflowStep mWfWorkflowStep = new WfWorkflowStep();
		mWfWorkflowStep.setWorkflowId(wfWorkflowStep.getWorkflowId());
		List<WfWorkflowStep> mmList = wfWorkflowStepMapper.selectWfWorkflowStepList(mWfWorkflowStep);
		WfWorkflowStep mparentWfWorkflowStep3 = null;
		if (mmList.size() == 0) {
			wfWorkflowStep.setStepNum(1);
			wfWorkflowStep.setFlowFlag("-->" + mmList.size() + 1);
			wfWorkflowStep.setParentId("0");
		} else {
			WfWorkflowStep mWfWorkflowStep2 = new WfWorkflowStep();
			mWfWorkflowStep2.setStepNum(mmList.size());
			mWfWorkflowStep2.setWorkflowId(wfWorkflowStep.getWorkflowId());
			List<WfWorkflowStep> mParentWorkflowSteps = wfWorkflowStepMapper.selectWfWorkflowStepList(mWfWorkflowStep2);
			mparentWfWorkflowStep3 = mParentWorkflowSteps.get(0);
			wfWorkflowStep.setParentId(mparentWfWorkflowStep3.getParentId());
			wfWorkflowStep.setStepNum(mmList.size() + 1);
			if (mmList.size() - 1 == 0) {
				wfWorkflowStep.setFlowFlag("-->" + mmList.size() + 1);
			} else {
				wfWorkflowStep.setFlowFlag("-->" + (mmList.size() - 1) + "-->" + mmList.size() + 1);
			}
		}
		int r = wfWorkflowStepMapper.insertWfWorkflowStep(wfWorkflowStep);
		if (r == 0) {
			if (mparentWfWorkflowStep3 != null) {
				WfWorkflowStep mWfWorkflowStep2 = new WfWorkflowStep();
				mWfWorkflowStep2.setMid(mparentWfWorkflowStep3.getMid());
				mWfWorkflowStep2.setNextId(wfWorkflowStep.getMid());
				wfWorkflowStepMapper.updateWfWorkflowStep(mWfWorkflowStep2);
			}
		}
		insetWFWorkflowStep(wfWorkflowStep.getUserIds(), wfWorkflowStep, user);
		return r;
	}

	/**
	 * 修改流程步骤
	 * 
	 * @param wfWorkflowStep 流程步骤信息
	 * @return 结果
	 */
	@Override
	@Transactional
	public int updateWfWorkflowStep(WfWorkflowStep wfWorkflowStep, Object user) {
		WfWorkflowStep mWfWorkflowStep = wfWorkflowStepMapper.selectWfWorkflowStepById(wfWorkflowStep.getParentId());// 获取上一个步骤
		WfWorkflowStep mWfWorkflowStep2 = wfWorkflowStepMapper.selectWfWorkflowStepById(wfWorkflowStep.getMid());
		//////////////////
		mWfWorkflowStep.setNextId(mWfWorkflowStep2.getMid());
		wfWorkflowStepMapper.updateWfWorkflowStep(mWfWorkflowStep);
		//////////////////////
		WfWorkflowStepUser mWfWorkflowStepUser = new WfWorkflowStepUser();
		mWfWorkflowStepUser.setWorkflowId(mWfWorkflowStep2.getWorkflowId());
		mWfWorkflowStepUser.setWfstepId(mWfWorkflowStep2.getMid());
		wfWorkflowStepUserMapper.deleteWfWorkflowStepUserByConditions(mWfWorkflowStepUser);

		//////
		insetWFWorkflowStep(wfWorkflowStep.getUserIds(), mWfWorkflowStep2, user);

		return wfWorkflowStepMapper.updateWfWorkflowStep(wfWorkflowStep);
	}

	/**
	 * 删除流程步骤对象
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	@Override
	public int deleteWfWorkflowStepByIds(String ids) {
		return wfWorkflowStepMapper.deleteWfWorkflowStepByIds(Convert.toStrArray(ids));
	}

	private int insetWFWorkflowStep(String userIds, WfWorkflowStep mWfWorkflowStep, Object user) {
		String[] UserIdArray = Convert.toStrArray(userIds);
		int result = 0;
		for (String string : UserIdArray) {

			WfWorkflowStepUser mWfWorkflowStepUser = new WfWorkflowStepUser();

			mWfWorkflowStepUser.setUserId(string);
			mWfWorkflowStepUser.setWfstepId(mWfWorkflowStep.getMid());
			mWfWorkflowStepUser.setWorkflowId(mWfWorkflowStep.getWorkflowId());
			mWfWorkflowStepUser.initInsert(user);
			result = wfWorkflowStepUserMapper.insertWfWorkflowStepUser(mWfWorkflowStepUser);
		}

		return result;
	}
}
