package com.lnbei.member.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 商户角色和部门关联表 member_shopranks_dept
 * 
 * @author lnbei
 * @date 2020-03-05
 */
public class MemberShopranksDept extends MemberBase
{
	private static final long serialVersionUID = 1L;
	
	/** 角色ID */
	private String ranksId;
	/** 部门ID */
	private String deptId;

	public void setRanksId(String ranksId) 
	{
		this.ranksId = ranksId;
	}

	public String getRanksId() 
	{
		return ranksId;
	}
	public void setDeptId(String deptId) 
	{
		this.deptId = deptId;
	}

	public String getDeptId() 
	{
		return deptId;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("ranksId", getRanksId())
            .append("deptId", getDeptId())
            .toString();
    }
}
