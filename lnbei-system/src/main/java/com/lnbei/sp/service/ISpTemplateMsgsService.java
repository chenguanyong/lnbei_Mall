package com.lnbei.sp.service;

import com.lnbei.sp.domain.SpTemplateMsgs;
import java.util.List;

/**
 * 消息模板 服务层
 * 
 * @author lnbei
 * @date 2020-02-23
 */
public interface ISpTemplateMsgsService 
{
	/**
     * 查询消息模板信息
     * 
     * @param mid 消息模板ID
     * @return 消息模板信息
     */
	public SpTemplateMsgs selectSpTemplateMsgsById(String mid);
	
	/**
     * 查询消息模板列表
     * 
     * @param spTemplateMsgs 消息模板信息
     * @return 消息模板集合
     */
	public List<SpTemplateMsgs> selectSpTemplateMsgsList(SpTemplateMsgs spTemplateMsgs);
	
	/**
     * 新增消息模板
     * 
     * @param spTemplateMsgs 消息模板信息
     * @return 结果
     */
	public int insertSpTemplateMsgs(SpTemplateMsgs spTemplateMsgs);
	
	/**
     * 修改消息模板
     * 
     * @param spTemplateMsgs 消息模板信息
     * @return 结果
     */
	public int updateSpTemplateMsgs(SpTemplateMsgs spTemplateMsgs);
		
	/**
     * 删除消息模板信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSpTemplateMsgsByIds(String ids);
	
}
