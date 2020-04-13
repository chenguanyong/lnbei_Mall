package com.lnbei.sp.domain;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
/**
 * 订单商品表 sp_order_goods
 * 
 * @author lnbei
 * @date 2020-02-05
 */
public class SpOrderGoods extends SpBase
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private String mid;
	/**  */
	private String orderId;
	/**  */
	private String goodsId;
	/**  */
	private Float goodsNum;
	/**  */
	private BigDecimal goodSprice;
	/**  */
	private String goodsspecId;
	/**  */
	private String goodsspecNames;
	/**  */
	private String goodsName;
	/**  */
	private String goodsImg;
	/**  */
	private String extraJson;
	/**  */
	private String goodsType;
	/**  */
	private BigDecimal commissionRate;
	/**  */
	private String goodsCode;
	/**  */
	private String promotionJson;
	/** 优惠券减免金额 */
	private BigDecimal couponVal;
	/** 满减减免金额 */
	private BigDecimal rewardVal;
	/** 商品使用的积分 */
	private Integer usescoreVal;
	/** 积分抵扣金额 */
	private BigDecimal scoreMoney;
	/** 购买该商品获得的积分数 */
	private Integer getscoreVal;
	/** 订单商品佣金 */
	private BigDecimal orderGoodsCommission;
	/** 获得的积分数可抵扣的金额 */
	private BigDecimal getScoreMoney;


	public void setMid(String mid) 
	{
		this.mid = mid;
	}

	public String getMid() 
	{
		return mid;
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
	public void setGoodsNum(Float goodsNum) 
	{
		this.goodsNum = goodsNum;
	}

	public Float getGoodsNum() 
	{
		return goodsNum;
	}
	public void setGoodSprice(BigDecimal goodSprice) 
	{
		this.goodSprice = goodSprice;
	}

	public BigDecimal getGoodSprice() 
	{
		return goodSprice;
	}
	public void setGoodsspecId(String goodsspecId) 
	{
		this.goodsspecId = goodsspecId;
	}

	public String getGoodsspecId() 
	{
		return goodsspecId;
	}
	public void setGoodsspecNames(String goodsspecNames) 
	{
		this.goodsspecNames = goodsspecNames;
	}

	public String getGoodsspecNames() 
	{
		return goodsspecNames;
	}
	public void setGoodsName(String goodsName) 
	{
		this.goodsName = goodsName;
	}

	public String getGoodsName() 
	{
		return goodsName;
	}
	public void setGoodsImg(String goodsImg) 
	{
		this.goodsImg = goodsImg;
	}

	public String getGoodsImg() 
	{
		return goodsImg;
	}
	public void setExtraJson(String extraJson) 
	{
		this.extraJson = extraJson;
	}

	public String getExtraJson() 
	{
		return extraJson;
	}
	public void setGoodsType(String goodsType) 
	{
		this.goodsType = goodsType;
	}

	public String getGoodsType() 
	{
		return goodsType;
	}
	public void setCommissionRate(BigDecimal commissionRate) 
	{
		this.commissionRate = commissionRate;
	}

	public BigDecimal getCommissionRate() 
	{
		return commissionRate;
	}
	public void setGoodsCode(String goodsCode) 
	{
		this.goodsCode = goodsCode;
	}

	public String getGoodsCode() 
	{
		return goodsCode;
	}
	public void setPromotionJson(String promotionJson) 
	{
		this.promotionJson = promotionJson;
	}

	public String getPromotionJson() 
	{
		return promotionJson;
	}
	public void setCouponVal(BigDecimal couponVal) 
	{
		this.couponVal = couponVal;
	}

	public BigDecimal getCouponVal() 
	{
		return couponVal;
	}
	public void setRewardVal(BigDecimal rewardVal) 
	{
		this.rewardVal = rewardVal;
	}

	public BigDecimal getRewardVal() 
	{
		return rewardVal;
	}
	public void setUsescoreVal(Integer usescoreVal) 
	{
		this.usescoreVal = usescoreVal;
	}

	public Integer getUsescoreVal() 
	{
		return usescoreVal;
	}
	public void setScoreMoney(BigDecimal scoreMoney) 
	{
		this.scoreMoney = scoreMoney;
	}

	public BigDecimal getScoreMoney() 
	{
		return scoreMoney;
	}
	public void setGetscoreVal(Integer getscoreVal) 
	{
		this.getscoreVal = getscoreVal;
	}

	public Integer getGetscoreVal() 
	{
		return getscoreVal;
	}
	public void setOrderGoodsCommission(BigDecimal orderGoodsCommission) 
	{
		this.orderGoodsCommission = orderGoodsCommission;
	}

	public BigDecimal getOrderGoodsCommission() 
	{
		return orderGoodsCommission;
	}
	public void setGetScoreMoney(BigDecimal getScoreMoney) 
	{
		this.getScoreMoney = getScoreMoney;
	}

	public BigDecimal getGetScoreMoney() 
	{
		return getScoreMoney;
	}


    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("mid", getMid())
            .append("orderId", getOrderId())
            .append("goodsId", getGoodsId())
            .append("goodsNum", getGoodsNum())
            .append("goodSprice", getGoodSprice())
            .append("goodsspecId", getGoodsspecId())
            .append("goodsspecNames", getGoodsspecNames())
            .append("goodsName", getGoodsName())
            .append("goodsImg", getGoodsImg())
            .append("extraJson", getExtraJson())
            .append("goodsType", getGoodsType())
            .append("commissionRate", getCommissionRate())
            .append("goodsCode", getGoodsCode())
            .append("promotionJson", getPromotionJson())
            .append("couponVal", getCouponVal())
            .append("rewardVal", getRewardVal())
            .append("usescoreVal", getUsescoreVal())
            .append("scoreMoney", getScoreMoney())
            .append("getscoreVal", getGetscoreVal())
            .append("orderGoodsCommission", getOrderGoodsCommission())
            .append("getScoreMoney", getGetScoreMoney())
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
