package com.lnbei.member.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * 会员地址表 member_user_address
 * 
 * @author lnbei
 * @date 2020-01-24
 */
public class MemberUserAddress extends MemberBase
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private String mid;
	/**  */
	private String userId;
	/**  */
	private String userName;
	/**  */
	private String userPhone;
	/**  */
	private String areaidPath;
	/**  */
	private String areaId;
	/** 选择地址 */
	private String areas;
	/**  */
	private String userAddress;
	/**  */
	private String isDefault;


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
	public void setUserName(String userName) 
	{
		this.userName = userName;
	}

	public String getUserName() 
	{
		return userName;
	}
	public void setUserPhone(String userPhone) 
	{
		this.userPhone = userPhone;
	}

	public String getUserPhone() 
	{
		return userPhone;
	}
	public void setAreaidPath(String areaidPath) 
	{
		this.areaidPath = areaidPath;
	}

	public String getAreaidPath() 
	{
		return areaidPath;
	}
	public void setAreaId(String areaId) 
	{
		this.areaId = areaId;
	}

	public String getAreaId() 
	{
		return areaId;
	}
	public void setAreas(String areas) 
	{
		this.areas = areas;
	}

	public String getAreas() 
	{
		return areas;
	}
	public void setUserAddress(String userAddress) 
	{
		this.userAddress = userAddress;
	}

	public String getUserAddress() 
	{
		return userAddress;
	}
	public void setIsDefault(String isDefault) 
	{
		this.isDefault = isDefault;
	}

	public String getIsDefault() 
	{
		return isDefault;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("mid", getMid())
            .append("userId", getUserId())
            .append("userName", getUserName())
            .append("userPhone", getUserPhone())
            .append("areaidPath", getAreaidPath())
            .append("areaId", getAreaId())
            .append("areas", getAreas())
            .append("userAddress", getUserAddress())
            .append("isDefault", getIsDefault())
            .append("delFlag", getDelFlag())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .append("remark", getRemark())
            .append("sort", getSort())
            .toString();
    }
}
