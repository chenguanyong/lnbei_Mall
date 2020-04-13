package com.lnbei.sp.domain;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 商品咨询表 sp_goods_consult
 * 
 * @author lnbei
 * @date 2020-02-05
 */
public class SpGoodsConsult extends SpBase
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private String mid;
	/**  */
	private String goodsId;
	/**  */
	private String memberId;
	/** 咨询类别 */
	private String consultType;
	/** 咨询内容 */
	private String consultContent;
	/** 商家回复 */
	private String reply;
	/** 回复时间 */
	private Date replyTime;
	/** 是否显示数据 */
	private String isShow;

	public void setMid(String mid) 
	{
		this.mid = mid;
	}

	public String getMid() 
	{
		return mid;
	}
	public void setGoodsId(String goodsId) 
	{
		this.goodsId = goodsId;
	}

	public String getGoodsId() 
	{
		return goodsId;
	}
	public void setMemberId(String memberId) 
	{
		this.memberId = memberId;
	}

	public String getMemberId() 
	{
		return memberId;
	}
	public void setConsultType(String consultType) 
	{
		this.consultType = consultType;
	}

	public String getConsultType() 
	{
		return consultType;
	}
	public void setConsultContent(String consultContent) 
	{
		this.consultContent = consultContent;
	}

	public String getConsultContent() 
	{
		return consultContent;
	}
	public void setReply(String reply) 
	{
		this.reply = reply;
	}

	public String getReply() 
	{
		return reply;
	}
	public void setReplyTime(Date replyTime) 
	{
		this.replyTime = replyTime;
	}

	public Date getReplyTime() 
	{
		return replyTime;
	}
	public void setIsShow(String isShow) 
	{
		this.isShow = isShow;
	}

	public String getIsShow() 
	{
		return isShow;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("mid", getMid())
            .append("goodsId", getGoodsId())
            .append("memberId", getMemberId())
            .append("consultType", getConsultType())
            .append("consultContent", getConsultContent())
            .append("reply", getReply())
            .append("replyTime", getReplyTime())
            .append("isShow", getIsShow())
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
