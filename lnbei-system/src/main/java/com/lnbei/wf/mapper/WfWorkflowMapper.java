package com.lnbei.wf.mapper;

import com.lnbei.wf.domain.WfWorkflow;
import java.util.List;	

/**
 * 流程 数据层
 * 
 * @author lnbei
 * @date 2020-02-08
 */
public interface WfWorkflowMapper 
{
	/**
     * 查询流程信息
     * 
     * @param mid 流程ID
     * @return 流程信息
     */
	public WfWorkflow selectWfWorkflowById(String mid);
	
	/**
     * 查询流程列表
     * 
     * @param wfWorkflow 流程信息
     * @return 流程集合
     */
	public List<WfWorkflow> selectWfWorkflowList(WfWorkflow wfWorkflow);
	
	/**
     * 新增流程
     * 
     * @param wfWorkflow 流程信息
     * @return 结果
     */
	public int insertWfWorkflow(WfWorkflow wfWorkflow);
	
	/**
     * 修改流程
     * 
     * @param wfWorkflow 流程信息
     * @return 结果
     */
	public int updateWfWorkflow(WfWorkflow wfWorkflow);
	
	/**
     * 删除流程
     * 
     * @param mid 流程ID
     * @return 结果
     */
	public int deleteWfWorkflowById(String mid);
	
	/**
     * 批量删除流程
     * 
     * @param mids 需要删除的数据ID
     * @return 结果
     */
	public int deleteWfWorkflowByIds(String[] mids);
	
}