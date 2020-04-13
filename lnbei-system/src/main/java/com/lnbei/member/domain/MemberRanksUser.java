package com.lnbei.member.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 会员与级别关系i表 member_ranks_user
 * 
 * @author lnbei
 * @date 2020-02-26
 */
public class MemberRanksUser extends MemberBase
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
