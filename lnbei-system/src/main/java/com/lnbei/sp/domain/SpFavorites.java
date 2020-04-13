package com.lnbei.sp.domain;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 收藏表 sp_favorites
 * 
 * @author lnbei
 * @date 2020-03-23
 */
public class SpFavorites extends SpBase
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private String mid;
	/**  */
	private String memberId;
	/**  */
	private Integer favoriteType;
	/**  */
	private String targetId;


	public void setMid(String mid) 
	{
		this.mid = mid;
	}

	public String getMid() 
	{
		return mid;
	}
	public void setMemberId(String memberId) 
	{
		this.memberId = memberId;
	}

	public String getMemberId() 
	{
		return memberId;
	}
	public void setFavoriteType(Integer favoriteType) 
	{
		this.favoriteType = favoriteType;
	}

	public Integer getFavoriteType() 
	{
		return favoriteType;
	}
	public void setTargetId(String targetId) 
	{
		this.targetId = targetId;
	}

	public String getTargetId() 
	{
		return targetId;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("mid", getMid())
            .append("memberId", getMemberId())
            .append("favoriteType", getFavoriteType())
            .append("targetId", getTargetId())
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
