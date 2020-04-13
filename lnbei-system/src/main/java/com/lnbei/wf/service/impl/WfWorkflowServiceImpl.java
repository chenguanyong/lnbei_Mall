package com.lnbei.wf.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnbei.wf.mapper.WfWorkflowMapper;
import com.lnbei.wf.domain.WfWorkflow;
import com.lnbei.wf.service.IWfWorkflowService;
import com.lnbei.common.core.text.Convert;

/**
 * 流程 服务层实现
 * 
 * @author lnbei
 * @date 2020-02-08
 */
@Service
public class WfWorkflowServiceImpl implements IWfWorkflowService 
{
	@Autowired
	private WfWorkflowMapper wfWorkflowMapper;

	/**
     * 查询流程信息
     * 
     * @param mid 流程ID
     * @return 流程信息
     */
    @Override
	public WfWorkflow selectWfWorkflowById(String mid)
	{
	    return wfWorkflowMapper.selectWfWorkflowById(mid);
	}
	
	/**
     * 查询流程列表
     * 
     * @param wfWorkflow 流程信息
     * @return 流程集合
     */
	@Override
	public List<WfWorkflow> selectWfWorkflowList(WfWorkflow wfWorkflow)
	{
	    return wfWorkflowMapper.selectWfWorkflowList(wfWorkflow);
	}
	
    /**
     * 新增流程
     * 
     * @param wfWorkflow 流程信息
     * @return 结果
     */
	@Override
	public int insertWfWorkflow(WfWorkflow wfWorkflow)
	{
	    return wfWorkflowMapper.insertWfWorkflow(wfWorkflow);
	}
	
	/**
     * 修改流程
     * 
     * @param wfWorkflow 流程信息
     * @return 结果
     */
	@Override
	public int updateWfWorkflow(WfWorkflow wfWorkflow)
	{
	    return wfWorkflowMapper.updateWfWorkflow(wfWorkflow);
	}

	/**
     * 删除流程对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteWfWorkflowByIds(String ids)
	{
		return wfWorkflowMapper.deleteWfWorkflowByIds(Convert.toStrArray(ids));
	}
	
}
