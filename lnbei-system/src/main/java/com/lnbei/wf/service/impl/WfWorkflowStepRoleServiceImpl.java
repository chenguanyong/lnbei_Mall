package com.lnbei.wf.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnbei.wf.mapper.WfWorkflowStepRoleMapper;
import com.lnbei.wf.domain.WfWorkflowStepRole;
import com.lnbei.wf.service.IWfWorkflowStepRoleService;
import com.lnbei.common.core.text.Convert;

/**
 * 流程步骤角色 服务层实现
 * 
 * @author lnbei
 * @date 2020-02-08
 */
@Service
public class WfWorkflowStepRoleServiceImpl implements IWfWorkflowStepRoleService 
{
	@Autowired
	private WfWorkflowStepRoleMapper wfWorkflowStepRoleMapper;

	/**
     * 查询流程步骤角色信息
     * 
     * @param mid 流程步骤角色ID
     * @return 流程步骤角色信息
     */
    @Override
	public WfWorkflowStepRole selectWfWorkflowStepRoleById(String mid)
	{
	    return wfWorkflowStepRoleMapper.selectWfWorkflowStepRoleById(mid);
	}
	
	/**
     * 查询流程步骤角色列表
     * 
     * @param wfWorkflowStepRole 流程步骤角色信息
     * @return 流程步骤角色集合
     */
	@Override
	public List<WfWorkflowStepRole> selectWfWorkflowStepRoleList(WfWorkflowStepRole wfWorkflowStepRole)
	{
	    return wfWorkflowStepRoleMapper.selectWfWorkflowStepRoleList(wfWorkflowStepRole);
	}
	
    /**
     * 新增流程步骤角色
     * 
     * @param wfWorkflowStepRole 流程步骤角色信息
     * @return 结果
     */
	@Override
	public int insertWfWorkflowStepRole(WfWorkflowStepRole wfWorkflowStepRole)
	{
	    return wfWorkflowStepRoleMapper.insertWfWorkflowStepRole(wfWorkflowStepRole);
	}
	
	/**
     * 修改流程步骤角色
     * 
     * @param wfWorkflowStepRole 流程步骤角色信息
     * @return 结果
     */
	@Override
	public int updateWfWorkflowStepRole(WfWorkflowStepRole wfWorkflowStepRole)
	{
	    return wfWorkflowStepRoleMapper.updateWfWorkflowStepRole(wfWorkflowStepRole);
	}

	/**
     * 删除流程步骤角色对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteWfWorkflowStepRoleByIds(String ids)
	{
		return wfWorkflowStepRoleMapper.deleteWfWorkflowStepRoleByIds(Convert.toStrArray(ids));
	}
	
}
