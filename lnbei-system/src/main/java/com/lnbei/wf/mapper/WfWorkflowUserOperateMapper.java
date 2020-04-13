package com.lnbei.wf.mapper;

import com.lnbei.wf.domain.WfWorkflowUserOperate;
import java.util.List;	

/**
 * 流程用户操作 数据层
 * 
 * @author lnbei
 * @date 2020-02-08
 */
public interface WfWorkflowUserOperateMapper 
{
	/**
     * 查询流程用户操作信息
     * 
     * @param mid 流程用户操作ID
     * @return 流程用户操作信息
     */
	public WfWorkflowUserOperate selectWfWorkflowUserOperateById(String mid);
	
	/**
     * 查询流程用户操作列表
     * 
     * @param wfWorkflowUserOperate 流程用户操作信息
     * @return 流程用户操作集合
     */
	public List<WfWorkflowUserOperate> selectWfWorkflowUserOperateList(WfWorkflowUserOperate wfWorkflowUserOperate);
	
	/**
     * 新增流程用户操作
     * 
     * @param wfWorkflowUserOperate 流程用户操作信息
     * @return 结果
     */
	public int insertWfWorkflowUserOperate(WfWorkflowUserOperate wfWorkflowUserOperate);
	
	/**
     * 修改流程用户操作
     * 
     * @param wfWorkflowUserOperate 流程用户操作信息
     * @return 结果
     */
	public int updateWfWorkflowUserOperate(WfWorkflowUserOperate wfWorkflowUserOperate);
	
	/**
     * 删除流程用户操作
     * 
     * @param mid 流程用户操作ID
     * @return 结果
     */
	public int deleteWfWorkflowUserOperateById(String mid);
	
	/**
     * 批量删除流程用户操作
     * 
     * @param mids 需要删除的数据ID
     * @return 结果
     */
	public int deleteWfWorkflowUserOperateByIds(String[] mids);
	
}