package com.lnbei.fi.domain;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.lnbei.wf.domain.WfBase;

/**
 * 提现账号管理表 fi_cash_configs
 * 
 * @author lnbei
 * @date 2020-02-13
 */
public class FiCashConfigs extends WfBase
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private String mid;
	/**  */
	private String targetType;
	/**  */
	private String targetId;
	/**  */
	private String accType;
	/**  */
	private String accTargetId;
	/**  */
	private String accAreaId;
	/**  */
	private String accNo;
	/**  */
	private String accUser;

	/** 状态 */
	private String status;

	public void setMid(String mid) 
	{
		this.mid = mid;
	}

	public String getMid() 
	{
		return mid;
	}
	public void setTargetType(String targetType) 
	{
		this.targetType = targetType;
	}

	public String getTargetType() 
	{
		return targetType;
	}
	public void setTargetId(String targetId) 
	{
		this.targetId = targetId;
	}

	public String getTargetId() 
	{
		return targetId;
	}
	public void setAccType(String accType) 
	{
		this.accType = accType;
	}

	public String getAccType() 
	{
		return accType;
	}
	public void setAccTargetId(String accTargetId) 
	{
		this.accTargetId = accTargetId;
	}

	public String getAccTargetId() 
	{
		return accTargetId;
	}
	public void setAccAreaId(String accAreaId) 
	{
		this.accAreaId = accAreaId;
	}

	public String getAccAreaId() 
	{
		return accAreaId;
	}
	public void setAccNo(String accNo) 
	{
		this.accNo = accNo;
	}

	public String getAccNo() 
	{
		return accNo;
	}
	public void setAccUser(String accUser) 
	{
		this.accUser = accUser;
	}

	public String getAccUser() 
	{
		return accUser;
	}


	public void setStatus(String status) 
	{
		this.status = status;
	}

	public String getStatus() 
	{
		return status;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("mid", getMid())
            .append("targetType", getTargetType())
            .append("targetId", getTargetId())
            .append("accType", getAccType())
            .append("accTargetId", getAccTargetId())
            .append("accAreaId", getAccAreaId())
            .append("accNo", getAccNo())
            .append("accUser", getAccUser())
            .append("createTime", getCreateTime())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .append("remark", getRemark())
            .append("sort", getSort())
            .append("status", getStatus())
            .toString();
    }
}
