package com.lnbei.sp.domain;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 友情链接表 sp_friendlinks
 * 
 * @author lnbei
 * @date 2020-03-23
 */
public class SpFriendlinks extends SpBase
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private String mid;
	/**  */
	private String friendlinkIco;
	/**  */
	private String friendlinkName;
	/**  */
	private String friendlinkUrl;


	public void setMid(String mid) 
	{
		this.mid = mid;
	}

	public String getMid() 
	{
		return mid;
	}
	public void setFriendlinkIco(String friendlinkIco) 
	{
		this.friendlinkIco = friendlinkIco;
	}

	public String getFriendlinkIco() 
	{
		return friendlinkIco;
	}
	public void setFriendlinkName(String friendlinkName) 
	{
		this.friendlinkName = friendlinkName;
	}

	public String getFriendlinkName() 
	{
		return friendlinkName;
	}
	public void setFriendlinkUrl(String friendlinkUrl) 
	{
		this.friendlinkUrl = friendlinkUrl;
	}

	public String getFriendlinkUrl() 
	{
		return friendlinkUrl;
	}


    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("mid", getMid())
            .append("friendlinkIco", getFriendlinkIco())
            .append("friendlinkName", getFriendlinkName())
            .append("friendlinkUrl", getFriendlinkUrl())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("deptId", getDeptId())
            .append("deptName", getDeptName())
            .append("sort", getSort())
            .append("status", getStatus())
            .toString();
    }
}
