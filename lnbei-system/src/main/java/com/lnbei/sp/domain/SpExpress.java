package com.lnbei.sp.domain;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 快递表 sp_express
 * 
 * @author lnbei
 * @date 2020-02-05
 */
public class SpExpress extends SpBase
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private String mid;
	/**  */
	private String expressName;
	/**  */
	private String expressCode;


	public void setMid(String mid) 
	{
		this.mid = mid;
	}

	public String getMid() 
	{
		return mid;
	}
	public void setExpressName(String expressName) 
	{
		this.expressName = expressName;
	}

	public String getExpressName() 
	{
		return expressName;
	}
	public void setExpressCode(String expressCode) 
	{
		this.expressCode = expressCode;
	}

	public String getExpressCode() 
	{
		return expressCode;
	}


    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("mid", getMid())
            .append("expressName", getExpressName())
            .append("expressCode", getExpressCode())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("deptId", getDeptId())
            .append("deptName", getDeptName())
            .append("sort", getSort())
            .toString();
    }
}
