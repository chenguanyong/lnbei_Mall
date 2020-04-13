package com.lnbei.wf.service;

import com.lnbei.wf.domain.WfWorkflowStepUser;
import java.util.List;

/**
 * 流程步骤用户 服务层
 * 
 * @author lnbei
 * @date 2020-02-08
 */
public interface IWfWorkflowStepUserService 
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
     * 删除流程步骤用户信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteWfWorkflowStepUserByIds(String ids);
	/**
	 * 根据指定条件删除数据
	 * @param wfWorkflowStepUser
	 * @return
	 */
	public int deleteWfWorkflowStepUserByConditions(WfWorkflowStepUser wfWorkflowStepUser);
}
