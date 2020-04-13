package com.lnbei.sp.domain;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 店铺认证表 sp_accreds
 * 
 * @author lnbei
 * @date 2020-02-23
 */
public class SpAccreds extends SpBase
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private String mid;
	/**  */
	private String accredName;
	/**  */
	private String accredImg;


	public void setMid(String mid) 
	{
		this.mid = mid;
	}

	public String getMid() 
	{
		return mid;
	}
	public void setAccredName(String accredName) 
	{
		this.accredName = accredName;
	}

	public String getAccredName() 
	{
		return accredName;
	}
	public void setAccredImg(String accredImg) 
	{
		this.accredImg = accredImg;
	}

	public String getAccredImg() 
	{
		return accredImg;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("mid", getMid())
            .append("accredName", getAccredName())
            .append("accredImg", getAccredImg())
            .append("createTime", getCreateTime())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .append("remark", getRemark())
            .append("sort", getSort())
            .append("status", getStatus())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
