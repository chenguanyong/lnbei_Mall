package com.lnbei.fi.domain;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 奖金明细表 fi_bonus_detail2
 * 
 * @author lnbei
 * @date 2020-02-13
 */
public class FiBonusDetail2 extends FiBase
{
	private static final long serialVersionUID = 1L;
	
	/** 自增ID */
	private String mid;
	/** 当前会员id */
	private String userId;
	/**  */
	private Date today;
	/** 个人编码，奖励金额来源人代码 */
	private String fromUserSerialNumber;
	/**  */
	private String bonustype;
	/**  */
	private Float money;
	/**  */
	private String fromuserId;

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
	public void setUserId(String userId) 
	{
		this.userId = userId;
	}

	public String getUserId() 
	{
		return userId;
	}
	
	public Date getToday() {
		return today;
	}

	public void setToday(Date today) {
		this.today = today;
	}

	public void setFromUserSerialNumber(String fromUserSerialNumber) 
	{
		this.fromUserSerialNumber = fromUserSerialNumber;
	}

	public String getFromUserSerialNumber() 
	{
		return fromUserSerialNumber;
	}
	public void setBonustype(String bonustype) 
	{
		this.bonustype = bonustype;
	}

	public String getBonustype() 
	{
		return bonustype;
	}
	public void setMoney(Float money) 
	{
		this.money = money;
	}

	public Float getMoney() 
	{
		return money;
	}
	public void setFromuserId(String fromuserId) 
	{
		this.fromuserId = fromuserId;
	}

	public String getFromuserId() 
	{
		return fromuserId;
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
            .append("userId", getUserId())
            .append("today", getToday())
            .append("fromUserSerialNumber", getFromUserSerialNumber())
            .append("bonustype", getBonustype())
            .append("money", getMoney())
            .append("fromuserId", getFromuserId())
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
