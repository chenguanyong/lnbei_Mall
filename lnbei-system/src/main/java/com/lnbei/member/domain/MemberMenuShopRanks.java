package com.lnbei.member.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 商家等级关系表 member_menu_shop_ranks
 * 
 * @author lnbei
 * @date 2020-02-25
 */
public class MemberMenuShopRanks extends MemberBase
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private String mid;
	/** 等级ID */
	private String ranksId;
	/** 菜单ID */
	private String menuId;

	public void setMid(String mid) 
	{
		this.mid = mid;
	}

	public String getMid() 
	{
		return mid;
	}
	public void setRanksId(String ranksId) 
	{
		this.ranksId = ranksId;
	}

	public String getRanksId() 
	{
		return ranksId;
	}
	public void setMenuId(String menuId) 
	{
		this.menuId = menuId;
	}

	public String getMenuId() 
	{
		return menuId;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("mid", getMid())
            .append("ranksId", getRanksId())
            .append("menuId", getMenuId())
            .toString();
    }
}
