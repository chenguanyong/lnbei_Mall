package com.lnbei.wf.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnbei.wf.mapper.WfWorkflowUserOperateMapper;
import com.lnbei.wf.domain.WfWorkflowUserOperate;
import com.lnbei.wf.service.IWfWorkflowUserOperateService;
import com.lnbei.common.core.text.Convert;

/**
 * 流程用户操作 服务层实现
 * 
 * @author lnbei
 * @date 2020-02-08
 */
@Service
public class WfWorkflowUserOperateServiceImpl implements IWfWorkflowUserOperateService 
{
	@Autowired
	private WfWorkflowUserOperateMapper wfWorkflowUserOperateMapper;

	/**
     * 查询流程用户操作信息
     * 
     * @param mid 流程用户操作ID
     * @return 流程用户操作信息
     */
    @Override
	public WfWorkflowUserOperate selectWfWorkflowUserOperateById(String mid)
	{
	    return wfWorkflowUserOperateMapper.selectWfWorkflowUserOperateById(mid);
	}
	
	/**
     * 查询流程用户操作列表
     * 
     * @param wfWorkflowUserOperate 流程用户操作信息
     * @return 流程用户操作集合
     */
	@Override
	public List<WfWorkflowUserOperate> selectWfWorkflowUserOperateList(WfWorkflowUserOperate wfWorkflowUserOperate)
	{
	    return wfWorkflowUserOperateMapper.selectWfWorkflowUserOperateList(wfWorkflowUserOperate);
	}
	
    /**
     * 新增流程用户操作
     * 
     * @param wfWorkflowUserOperate 流程用户操作信息
     * @return 结果
     */
	@Override
	public int insertWfWorkflowUserOperate(WfWorkflowUserOperate wfWorkflowUserOperate)
	{
	    return wfWorkflowUserOperateMapper.insertWfWorkflowUserOperate(wfWorkflowUserOperate);
	}
	
	/**
     * 修改流程用户操作
     * 
     * @param wfWorkflowUserOperate 流程用户操作信息
     * @return 结果
     */
	@Override
	public int updateWfWorkflowUserOperate(WfWorkflowUserOperate wfWorkflowUserOperate)
	{
	    return wfWorkflowUserOperateMapper.updateWfWorkflowUserOperate(wfWorkflowUserOperate);
	}

	/**
     * 删除流程用户操作对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteWfWorkflowUserOperateByIds(String ids)
	{
		return wfWorkflowUserOperateMapper.deleteWfWorkflowUserOperateByIds(Convert.toStrArray(ids));
	}
	
}
