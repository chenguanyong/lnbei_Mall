package com.lnbei.oa.domain;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.lnbei.common.core.domain.BaseEntity;

/**
 * 主动发消息日志表 oa_message_log
 * 
 * @author lnbei
 * @date 2019-03-20
 */
public class OaMessageLog extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 序号 */
	private String id;
	/** 系统名称 */
	private String sysName;
	/**  */
	private String tableName;
	/**  */
	private String targetId;
	/** 是否发送 */
	private Integer isSend;
	/** 是否回复 */
	private Integer isReply;
	/** 创建时间 */
	private Date createTime;
	/** 系统标识 */
	private String sysFlag;
	/** 回复时间 */
	private Date replyTime;
	/**发送次数*/
	private Integer sendSize;
	/**动作类型**/
	private Integer actionType;
	/**批量**/
	private Integer isBatch;
	
	private String url;
	private Integer method;
	private String param;
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getMethod() {
		return method;
	}

	public void setMethod(Integer method) {
		this.method = method;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	public Integer getIsBatch() {
		
		return isBatch;
	}

	public void setIsBatch(Integer isBatch) {
		this.isBatch = isBatch;
	}

	public Integer getActionType() {
		return actionType;
	}

	public void setActionType(Integer actionType) {
		this.actionType = actionType;
	}

	public Integer getSendSize() {
		return sendSize;
	}

	public void setSendSize(Integer sendSize) {
		this.sendSize = sendSize;
	}

	public void setId(String id) 
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}
	public void setSysName(String sysName) 
	{
		this.sysName = sysName;
	}

	public String getSysName() 
	{
		return sysName;
	}
	public void setTableName(String tableName) 
	{
		this.tableName = tableName;
	}

	public String getTableName() 
	{
		return tableName;
	}
	public void setTargetId(String targetId) 
	{
		this.targetId = targetId;
	}

	public String getTargetId() 
	{
		return targetId;
	}
	public void setIsSend(Integer isSend) 
	{
		this.isSend = isSend;
	}

	public Integer getIsSend() 
	{
		return isSend;
	}
	public void setIsReply(Integer isReply) 
	{
		this.isReply = isReply;
	}

	public Integer getIsReply() 
	{
		return isReply;
	}
	public void setCreateTime(Date createTime) 
	{
		this.createTime = createTime;
	}

	public Date getCreateTime() 
	{
		return createTime;
	}
	public void setSysFlag(String sysFlag) 
	{
		this.sysFlag = sysFlag;
	}

	public String getSysFlag() 
	{
		return sysFlag;
	}
	public void setReplyTime(Date replyTime) 
	{
		this.replyTime = replyTime;
	}

	public Date getReplyTime() 
	{
		return replyTime;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("sysName", getSysName())
            .append("tableName", getTableName())
            .append("targetId", getTargetId())
            .append("isSend", getIsSend())
            .append("isReply", getIsReply())
            .append("createTime", getCreateTime())
            .append("sysFlag", getSysFlag())
            .append("replyTime", getReplyTime())
            .toString();
    }
}
