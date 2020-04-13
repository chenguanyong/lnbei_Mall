package com.lnbei.oa.service;

import com.lnbei.oa.domain.OaMessageLog;
import java.util.List;

/**
 * 主动发消息日志 服务层
 * 
 * @author lnbei
 * @date 2019-03-20
 */
public interface IOaMessageLogService 
{
	/**
     * 查询主动发消息日志信息
     * 
     * @param id 主动发消息日志ID
     * @return 主动发消息日志信息
     */
	public OaMessageLog selectOaMessageLogById(String id);
	
	/**
     * 查询主动发消息日志列表
     * 
     * @param oaMessageLog 主动发消息日志信息
     * @return 主动发消息日志集合
     */
	public List<OaMessageLog> selectOaMessageLogList(OaMessageLog oaMessageLog);
	
	/**
     * 新增主动发消息日志
     * 
     * @param oaMessageLog 主动发消息日志信息
     * @return 结果
     */
	public int insertOaMessageLog(OaMessageLog oaMessageLog);
	
	/**
     * 修改主动发消息日志
     * 
     * @param oaMessageLog 主动发消息日志信息
     * @return 结果
     */
	public int updateOaMessageLog(OaMessageLog oaMessageLog);
		
	/**
     * 删除主动发消息日志信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteOaMessageLogByIds(String ids);
	/**
	 * 发送消息
	 * @param tableName
	 * @param targetId
	 * @return
	 */
	public int sendMsg(String tableName, String targetId, Integer actionType, Integer isBatch);
	
}
