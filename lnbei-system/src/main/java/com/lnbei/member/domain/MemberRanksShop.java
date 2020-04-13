package com.lnbei.member.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 商家与级别关系表 member_ranks_shop
 * 
 * @author lnbei
 * @date 2020-02-25
 */
public class MemberRanksShop extends MemberBase
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private String mid;
	/**  */
	private String memberId;
	/**  */
	private String ranksId;

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
	public void setRanksId(String ranksId) 
	{
		this.ranksId = ranksId;
	}

	public String getRanksId() 
	{
		return ranksId;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("mid", getMid())
            .append("memberId", getMemberId())
            .append("ranksId", getRanksId())
            .toString();
    }
}
