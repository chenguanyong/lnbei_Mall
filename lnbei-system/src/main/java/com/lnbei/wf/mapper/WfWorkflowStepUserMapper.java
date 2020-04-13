package com.lnbei.wf.mapper;

import com.lnbei.wf.domain.WfWorkflowStepUser;
import java.util.List;	

/**
 * 流程步骤用户 数据层
 * 
 * @author lnbei
 * @date 2020-02-08
 */
public interface WfWorkflowStepUserMapper 
{
	/**
     * 查询流程步骤用户信息
     * 
     * @param mid 流程步骤用户ID
     * @return 流程步骤用户信息
     */
	public WfWorkflowStepUser selectWfWorkflowStepUserById(String mid);
	
	/**
     * 查询流程步骤用户列表
     * 
     * @param wfWorkflowStepUser 流程步骤用户信息
     * @return 流程步骤用户集合
     */
	public List<WfWorkflowStepUser> selectWfWorkflowStepUserList(WfWorkflowStepUser wfWorkflowStepUser);
	
	/**
     * 新增流程步骤用户
     * 
     * @param wfWorkflowStepUser 流程步骤用户信息
     * @return 结果
     */
	public int insertWfWorkflowStepUser(WfWorkflowStepUser wfWorkflowStepUser);
	
	/**
     * 修改流程步骤用户
     * 
     * @param wfWorkflowStepUser 流程步骤用户信息
     * @return 结果
     */
	public int updateWfWorkflowStepUser(WfWorkflowStepUser wfWorkflowStepUser);
	
	/**
     * 删除流程步骤用户
     * 
     * @param mid 流程步骤用户ID
     * @return 结果
     */
	public int deleteWfWorkflowStepUserById(String mid);
	
	/**
     * 批量删除流程步骤用户
     * 
     * @param mids 需要删除的数据ID
     * @return 结果
     */
	public int deleteWfWorkflowStepUserByIds(String[] mids);
	/**
	 * 根据条件删除数据
	 * @param wfWorkflowStepUser
	 * @return
	 */
	public int deleteWfWorkflowStepUserByConditions(WfWorkflowStepUser wfWorkflowStepUser);
}