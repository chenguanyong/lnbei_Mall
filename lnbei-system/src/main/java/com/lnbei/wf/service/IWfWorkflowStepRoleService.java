package com.lnbei.wf.service;

import com.lnbei.wf.domain.WfWorkflowStepRole;
import java.util.List;

/**
 * 流程步骤角色 服务层
 * 
 * @author lnbei
 * @date 2020-02-08
 */
public interface IWfWorkflowStepRoleService 
{
	/**
     * 查询流程步骤角色信息
     * 
     * @param mid 流程步骤角色ID
     * @return 流程步骤角色信息
     */
	public WfWorkflowStepRole selectWfWorkflowStepRoleById(String mid);
	
	/**
     * 查询流程步骤角色列表
     * 
     * @param wfWorkflowStepRole 流程步骤角色信息
     * @return 流程步骤角色集合
     */
	public List<WfWorkflowStepRole> selectWfWorkflowStepRoleList(WfWorkflowStepRole wfWorkflowStepRole);
	
	/**
     * 新增流程步骤角色
     * 
     * @param wfWorkflowStepRole 流程步骤角色信息
     * @return 结果
     */
	public int insertWfWorkflowStepRole(WfWorkflowStepRole wfWorkflowStepRole);
	
	/**
     * 修改流程步骤角色
     * 
     * @param wfWorkflowStepRole 流程步骤角色信息
     * @return 结果
     */
	public int updateWfWorkflowStepRole(WfWorkflowStepRole wfWorkflowStepRole);
		
	/**
     * 删除流程步骤角色信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteWfWorkflowStepRoleByIds(String ids);
	
}
