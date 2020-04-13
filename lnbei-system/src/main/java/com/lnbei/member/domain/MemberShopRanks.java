package com.lnbei.member.domain;


import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 商家等级表 member_shop_ranks
 * 
 * @author lnbei
 * @date 2020-02-25
 */
public class MemberShopRanks extends MemberBase
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
	/**  */
	private String status;
	/** 角色标识 */
	private String rankKeys;

	private String menuIds;
    /** 部门组（数据权限） */
    private String[] deptIds;
	
	private String dataScope;
	
	public String getDataScope() {
		return dataScope;
	}

	public void setDataScope(String dataScope) {
		this.dataScope = dataScope;
	}

	public String[] getDeptIds() {
		return deptIds;
	}

	public void setDeptIds(String[] deptIds) {
		this.deptIds = deptIds;
	}

	public String getMenuIds() {
		return menuIds;
	}

	public void setMenuIds(String menuIds) {
		this.menuIds = menuIds;
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

	public void setStatus(String status) 
	{
		this.status = status;
	}

	public String getStatus() 
	{
		return status;
	}
	public void setRankKeys(String rankKeys) 
	{
		this.rankKeys = rankKeys;
	}

	public String getRankKeys() 
	{
		return rankKeys;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("mid", getMid())
            .append("rankName", getRankName())
            .append("startScore", getStartScore())
            .append("endScore", getEndScore())
            .append("userrankImg", getUserrankImg())
            .append("delFlag", getDelFlag())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .append("remark", getRemark())
            .append("deptId", getDeptId())
            .append("deptName", getDeptName())
            .append("sort", getSort())
            .append("status", getStatus())
            .append("rankKeys", getRankKeys())
            .toString();
    }
}
