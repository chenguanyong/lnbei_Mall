package com.lnbei.home.domain;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.lnbei.member.domain.MemberUser;
import com.lnbei.system.domain.SysUser;

/**
 * 评论表 home_comment
 * 
 * @author lnbei
 * @date 2020-02-01
 */
public class HomeComment extends HomeBase
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private String mid;
	/** 文章Id */
	private String articleId;
	/**  */
	private String title;
	/**  */
	private String userId;
	/**  */
	private String memberId;
	/**  */
	private String flag;
	/**  */
	private String status;
	/** 审核人 */
	private String auditor;
	/** 审核人Id */
	private String auditorId;
	/** 审核意见 */
	private String auditorOpinion;
	/** 好评 */
	private Integer praise;
	/** 差评数量 */
	private Integer badReview;
	/**  */
	private String toName;
	/** 回复人Id */
	private String toId;

	/** 用户类型 */
	private String userType;
	/** 回复数量 */
	private Integer replySize;
	
	private String createName;
	
	private String parentId;

	public String getCreateName() {
		return createName;
	}

	public void setCreateName(String createName) {
		this.createName = createName;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public void setMid(String mid) 
	{
		this.mid = mid;
	}

	public String getMid() 
	{
		return mid;
	}
	public void setArticleId(String articleId) 
	{
		this.articleId = articleId;
	}

	public String getArticleId() 
	{
		return articleId;
	}
	public void setTitle(String title) 
	{
		this.title = title;
	}

	public String getTitle() 
	{
		return title;
	}
	public void setUserId(String userId) 
	{
		this.userId = userId;
	}

	public String getUserId() 
	{
		return userId;
	}
	public void setMemberId(String memberId) 
	{
		this.memberId = memberId;
	}

	public String getMemberId() 
	{
		return memberId;
	}
	public void setFlag(String flag) 
	{
		this.flag = flag;
	}

	public String getFlag() 
	{
		return flag;
	}
	public void setStatus(String status) 
	{
		this.status = status;
	}

	public String getStatus() 
	{
		return status;
	}
	public void setAuditor(String auditor) 
	{
		this.auditor = auditor;
	}

	public String getAuditor() 
	{
		return auditor;
	}
	public void setAuditorId(String auditorId) 
	{
		this.auditorId = auditorId;
	}

	public String getAuditorId() 
	{
		return auditorId;
	}
	public void setAuditorOpinion(String auditorOpinion) 
	{
		this.auditorOpinion = auditorOpinion;
	}

	public String getAuditorOpinion() 
	{
		return auditorOpinion;
	}
	public void setPraise(Integer praise) 
	{
		this.praise = praise;
	}

	public Integer getPraise() 
	{
		return praise;
	}
	public void setBadReview(Integer badReview) 
	{
		this.badReview = badReview;
	}

	public Integer getBadReview() 
	{
		return badReview;
	}
	public void setToName(String toName) 
	{
		this.toName = toName;
	}

	public String getToName() 
	{
		return toName;
	}
	public void setToId(String toId) 
	{
		this.toId = toId;
	}

	public String getToId() 
	{
		return toId;
	}

	public void setUserType(String userType) 
	{
		this.userType = userType;
	}

	public String getUserType() 
	{
		return userType;
	}
	public void setReplySize(Integer replySize) 
	{
		this.replySize = replySize;
	}

	public Integer getReplySize() 
	{
		return replySize;
	}
	@Override
	public void initInsert(MemberUser mmSysUser) {
		super.initInsert(mmSysUser);
		this.createName = mmSysUser.getLoginName();
		this.userType = "0";
	}
	@Override
	public void initInsert(SysUser mmSysUser) {
		super.initInsert(mmSysUser);
		this.createName = mmSysUser.getLogName();
		this.userType = "1";
	}
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("mid", getMid())
            .append("articleId", getArticleId())
            .append("title", getTitle())
            .append("userId", getUserId())
            .append("memberId", getMemberId())
            .append("flag", getFlag())
            .append("status", getStatus())
            .append("auditor", getAuditor())
            .append("auditorId", getAuditorId())
            .append("auditorOpinion", getAuditorOpinion())
            .append("praise", getPraise())
            .append("badReview", getBadReview())
            .append("toName", getToName())
            .append("toId", getToId())
            .append("delFlag", getDelFlag())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("sort", getSort())
            .append("userType", getUserType())
            .append("replySize", getReplySize())
            .toString();
    }
}
