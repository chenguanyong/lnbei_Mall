package com.lnbei.member.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * 会员等级表 member_user_ranks
 * 
 * @author lnbei
 * @date 2020-01-24
 */
public class MemberUserRanks extends MemberBase
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private String mid;
	/**  */
	private String rankName;
	/**  */
	private Integer startScore;
	/**  */
	private Integer endScore;
	/**  */
	private String userrankImg;
	
	private String status;
	
	private String meunId;
	/**
	 * 角色标识
	 */
	private String rankKeys;

	private String dataScope;
	
	public String getDataScope() {
		return dataScope;
	}

	public void setDataScope(String dataScope) {
		this.dataScope = dataScope;
	}

	public String getMeunId() {
		return meunId;
	}

	public void setMeunId(String meunId) {
		this.meunId = meunId;
	}

	public String getRankKeys() {
		return rankKeys;
	}

	public void setRankKeys(String rankKeys) {
		this.rankKeys = rankKeys;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setMid(String mid) 
	{
		this.mid = mid;
	}

	public String getMid() 
	{
		return mid;
	}
	public void setRankName(String rankName) 
	{
		this.rankName = rankName;
	}

	public String getRankName() 
	{
		return rankName;
	}
	public void setStartScore(Integer startScore) 
	{
		this.startScore = startScore;
	}

	public Integer getStartScore() 
	{
		return startScore;
	}
	public void setEndScore(Integer endScore) 
	{
		this.endScore = endScore;
	}

	public Integer getEndScore() 
	{
		return endScore;
	}
	public void setUserrankImg(String userrankImg) 
	{
		this.userrankImg = userrankImg;
	}

	public String getUserrankImg() 
	{
		return userrankImg;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("mid", getMid())
            .append("rankName", getRankName())
            .append("startScore", getStartScore())
            .append("endScore", getEndScore())
            .append("userrankImg", getUserrankImg())
            .append("deleFlag", getDelFlag())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .append("remark", getRemark())
            .append("sort", getSort())
            .toString();
    }
}
