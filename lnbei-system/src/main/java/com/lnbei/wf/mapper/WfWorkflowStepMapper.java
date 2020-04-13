package com.lnbei.wf.mapper;

import com.lnbei.wf.domain.WfWorkflowStep;
import java.util.List;	

/**
 * 流程步骤 数据层
 * 
 * @author lnbei
 * @date 2020-02-08
 */
public interface WfWorkflowStepMapper 
{
	/**
     * 查询流程步骤信息
     * 
     * @param mid 流程步骤ID
     * @return 流程步骤信息
     */
	public WfWorkflowStep selectWfWorkflowStepById(String mid);
	
	/**
     * 查询流程步骤列表
     * 
     * @param wfWorkflowStep 流程步骤信息
     * @return 流程步骤集合
     */
	public List<WfWorkflowStep> selectWfWorkflowStepList(WfWorkflowStep wfWorkflowStep);
	
	/**
     * 新增流程步骤
     * 
     * @param wfWorkflowStep 流程步骤信息
     * @return 结果
     */
	public int insertWfWorkflowStep(WfWorkflowStep wfWorkflowStep);
	
	/**
     * 修改流程步骤
     * 
     * @param wfWorkflowStep 流程步骤信息
     * @return 结果
     */
	public int updateWfWorkflowStep(WfWorkflowStep wfWorkflowStep);
	
	/**
     * 删除流程步骤
     * 
     * @param mid 流程步骤ID
     * @return 结果
     */
	public int deleteWfWorkflowStepById(String mid);
	
	/**
     * 批量删除流程步骤
     * 
     * @param mids 需要删除的数据ID
     * @return 结果
     */
	public int deleteWfWorkflowStepByIds(String[] mids);
	
}