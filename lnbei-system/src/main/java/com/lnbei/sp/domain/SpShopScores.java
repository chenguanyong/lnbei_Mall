package com.lnbei.sp.domain;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 商品评分表 sp_shop_scores
 * 
 * @author lnbei
 * @date 2020-02-05
 */
public class SpShopScores extends SpBase
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private String mid;
	/**  */
	private String shopId;
	/**  */
	private Integer totalScore;
	/**  */
	private Integer totalUsers;
	/**  */
	private Integer goodsScore;
	/**  */
	private Integer goodsUsers;
	/**  */
	private Integer serviceScore;
	/**  */
	private Integer serviceUsers;
	/**  */
	private Integer timeScore;
	/**  */
	private Integer timeUsers;


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
	public void setTotalScore(Integer totalScore) 
	{
		this.totalScore = totalScore;
	}

	public Integer getTotalScore() 
	{
		return totalScore;
	}
	public void setTotalUsers(Integer totalUsers) 
	{
		this.totalUsers = totalUsers;
	}

	public Integer getTotalUsers() 
	{
		return totalUsers;
	}
	public void setGoodsScore(Integer goodsScore) 
	{
		this.goodsScore = goodsScore;
	}

	public Integer getGoodsScore() 
	{
		return goodsScore;
	}
	public void setGoodsUsers(Integer goodsUsers) 
	{
		this.goodsUsers = goodsUsers;
	}

	public Integer getGoodsUsers() 
	{
		return goodsUsers;
	}
	public void setServiceScore(Integer serviceScore) 
	{
		this.serviceScore = serviceScore;
	}

	public Integer getServiceScore() 
	{
		return serviceScore;
	}
	public void setServiceUsers(Integer serviceUsers) 
	{
		this.serviceUsers = serviceUsers;
	}

	public Integer getServiceUsers() 
	{
		return serviceUsers;
	}
	public void setTimeScore(Integer timeScore) 
	{
		this.timeScore = timeScore;
	}

	public Integer getTimeScore() 
	{
		return timeScore;
	}
	public void setTimeUsers(Integer timeUsers) 
	{
		this.timeUsers = timeUsers;
	}

	public Integer getTimeUsers() 
	{
		return timeUsers;
	}


    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("mid", getMid())
            .append("shopId", getShopId())
            .append("totalScore", getTotalScore())
            .append("totalUsers", getTotalUsers())
            .append("goodsScore", getGoodsScore())
            .append("goodsUsers", getGoodsUsers())
            .append("serviceScore", getServiceScore())
            .append("serviceUsers", getServiceUsers())
            .append("timeScore", getTimeScore())
            .append("timeUsers", getTimeUsers())
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
