package com.lnbei.sp.domain;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 商品评价表 sp_goods_appraises
 * 
 * @author lnbei
 * @date 2020-02-05
 */
public class SpGoodsAppraises extends SpBase
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private String mid;
	/**  */
	private String shopId;
	/**  */
	private String orderId;
	/**  */
	private String goodsId;
	/**  */
	private String goodsSpecid;
	/**  */
	private String memberId;
	/**  */
	private Integer goodsScore;
	/**  */
	private Integer serviceScore;
	/**  */
	private Integer timeScore;
	/**  */
	private String content;
	/**  */
	private String shopReply;
	/**  */
	private String images;
	/**  */
	private String isShow;
	/**  */
	private Date replyTime;
	/** 订单商品表id */
	private Integer ordergoodsId;


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
	public void setOrderId(String orderId) 
	{
		this.orderId = orderId;
	}

	public String getOrderId() 
	{
		return orderId;
	}
	public void setGoodsId(String goodsId) 
	{
		this.goodsId = goodsId;
	}

	public String getGoodsId() 
	{
		return goodsId;
	}
	public void setGoodsSpecid(String goodsSpecid) 
	{
		this.goodsSpecid = goodsSpecid;
	}

	public String getGoodsSpecid() 
	{
		return goodsSpecid;
	}
	public void setMemberId(String memberId) 
	{
		this.memberId = memberId;
	}

	public String getMemberId() 
	{
		return memberId;
	}
	public void setGoodsScore(Integer goodsScore) 
	{
		this.goodsScore = goodsScore;
	}

	public Integer getGoodsScore() 
	{
		return goodsScore;
	}
	public void setServiceScore(Integer serviceScore) 
	{
		this.serviceScore = serviceScore;
	}

	public Integer getServiceScore() 
	{
		return serviceScore;
	}
	public void setTimeScore(Integer timeScore) 
	{
		this.timeScore = timeScore;
	}

	public Integer getTimeScore() 
	{
		return timeScore;
	}
	public void setContent(String content) 
	{
		this.content = content;
	}

	public String getContent() 
	{
		return content;
	}
	public void setShopReply(String shopReply) 
	{
		this.shopReply = shopReply;
	}

	public String getShopReply() 
	{
		return shopReply;
	}
	public void setImages(String images) 
	{
		this.images = images;
	}

	public String getImages() 
	{
		return images;
	}
	public void setIsShow(String isShow) 
	{
		this.isShow = isShow;
	}

	public String getIsShow() 
	{
		return isShow;
	}
	public void setReplyTime(Date replyTime) 
	{
		this.replyTime = replyTime;
	}

	public Date getReplyTime() 
	{
		return replyTime;
	}
	public void setOrdergoodsId(Integer ordergoodsId) 
	{
		this.ordergoodsId = ordergoodsId;
	}

	public Integer getOrdergoodsId() 
	{
		return ordergoodsId;
	}
	
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("mid", getMid())
            .append("shopId", getShopId())
            .append("orderId", getOrderId())
            .append("goodsId", getGoodsId())
            .append("goodsSpecid", getGoodsSpecid())
            .append("memberId", getMemberId())
            .append("goodsScore", getGoodsScore())
            .append("serviceScore", getServiceScore())
            .append("timeScore", getTimeScore())
            .append("content", getContent())
            .append("shopReply", getShopReply())
            .append("images", getImages())
            .append("isShow", getIsShow())
            .append("replyTime", getReplyTime())
            .append("ordergoodsId", getOrdergoodsId())
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
