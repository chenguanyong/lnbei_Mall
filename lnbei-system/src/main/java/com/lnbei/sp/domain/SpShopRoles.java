package com.lnbei.sp.domain;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 商家角色表 sp_shop_roles
 * 
 * @author lnbei
 * @date 2020-02-05
 */
public class SpShopRoles extends SpBase
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private String mid;
	/**  */
	private String shopId;
	/**  */
	private String roleName;
	/**  */
	private String privilegeMsgs;
	/**  */
	private String privilegeUrls;
	
	

	public void setMid(String mid) 
	{
		this.mid = mid;
	}

	public String getMid() 
	{
		return mid;
	}
	public void setShopId(String shopId) 
	{
		this.shopId = shopId;
	}

	public String getShopId() 
	{
		return shopId;
	}
	public void setRoleName(String roleName) 
	{
		this.roleName = roleName;
	}

	public String getRoleName() 
	{
		return roleName;
	}
	public void setPrivilegeMsgs(String privilegeMsgs) 
	{
		this.privilegeMsgs = privilegeMsgs;
	}

	public String getPrivilegeMsgs() 
	{
		return privilegeMsgs;
	}
	public void setPrivilegeUrls(String privilegeUrls) 
	{
		this.privilegeUrls = privilegeUrls;
	}

	public String getPrivilegeUrls() 
	{
		return privilegeUrls;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("mid", getMid())
            .append("shopId", getShopId())
            .append("roleName", getRoleName())
            .append("privilegeMsgs", getPrivilegeMsgs())
            .append("privilegeUrls", getPrivilegeUrls())
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
