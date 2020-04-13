package com.lnbei.fi.domain;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.lnbei.wf.domain.WfBase;

/**
 * 银行表 fi_banks
 * 
 * @author lnbei
 * @date 2020-02-13
 */
public class FiBanks extends WfBase
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private String mid;
	/**  */
	private String bankName;
	/** 银行图标 */
	private String bankImg;
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
	public void setBankName(String bankName) 
	{
		this.bankName = bankName;
	}

	public String getBankName() 
	{
		return bankName;
	}
	public void setBankImg(String bankImg) 
	{
		this.bankImg = bankImg;
	}

	public String getBankImg() 
	{
		return bankImg;
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
            .append("bankName", getBankName())
            .append("bankImg", getBankImg())
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
