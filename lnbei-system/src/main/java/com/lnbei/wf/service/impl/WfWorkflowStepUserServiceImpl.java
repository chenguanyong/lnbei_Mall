package com.lnbei.wf.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnbei.wf.mapper.WfWorkflowStepUserMapper;
import com.lnbei.wf.domain.WfWorkflowStep;
import com.lnbei.wf.domain.WfWorkflowStepUser;
import com.lnbei.wf.service.IWfWorkflowStepUserService;
import com.lnbei.common.core.text.Convert;

/**
 * 流程步骤用户 服务层实现
 * 
 * @author lnbei
 * @date 2020-02-08
 */
@Service
public class WfWorkflowStepUserServiceImpl implements IWfWorkflowStepUserService 
{
	@Autowired
	private WfWorkflowStepUserMapper wfWorkflowStepUserMapper;

	/**
     * 查询流程步骤用户信息
     * 
     * @param mid 流程步骤用户ID
     * @return 流程步骤用户信息
     */
    @Override
	public WfWorkflowStepUser selectWfWorkflowStepUserById(String mid)
	{
	    return wfWorkflowStepUserMapper.selectWfWorkflowStepUserById(mid);
	}
	
	/**
     * 查询流程步骤用户列表
     * 
     * @param wfWorkflowStepUser 流程步骤用户信息
     * @return 流程步骤用户集合
     */
	@Override
	public List<WfWorkflowStepUser> selectWfWorkflowStepUserList(WfWorkflowStepUser wfWorkflowStepUser)
	{
	    return wfWorkflowStepUserMapper.selectWfWorkflowStepUserList(wfWorkflowStepUser);
	}
	
    /**
     * 新增流程步骤用户
     * 
     * @param wfWorkflowStepUser 流程步骤用户信息
     * @return 结果
     */
	@Override
	public int insertWfWorkflowStepUser(WfWorkflowStepUser wfWorkflowStepUser)
	{
	    return wfWorkflowStepUserMapper.insertWfWorkflowStepUser(wfWorkflowStepUser);
	}
	
	/**
     * 修改流程步骤用户
     * 
     * @param wfWorkflowStepUser 流程步骤用户信息
     * @return 结果
     */
	@Override
	public int updateWfWorkflowStepUser(WfWorkflowStepUser wfWorkflowStepUser)
	{
		
	    return wfWorkflowStepUserMapper.updateWfWorkflowStepUser(wfWorkflowStepUser);
	}

	/**
     * 删除流程步骤用户对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteWfWorkflowStepUserByIds(String ids)
	{
		return wfWorkflowStepUserMapper.deleteWfWorkflowStepUserByIds(Convert.toStrArray(ids));
	}
	/**
	 * 根据指定条件删除数据
	 * @param wfWorkflowStepUser
	 * @return
	 */
	@Override
	public int deleteWfWorkflowStepUserByConditions(WfWorkflowStepUser wfWorkflowStepUser) {
		// TODO Auto-generated method stub
		return wfWorkflowStepUserMapper.deleteWfWorkflowStepUserByConditions(wfWorkflowStepUser);
	}
	
}
