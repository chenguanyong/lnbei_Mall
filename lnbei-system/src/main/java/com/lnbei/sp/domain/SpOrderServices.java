package com.lnbei.sp.domain;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 订单服务表 sp_order_services
 * 
 * @author lnbei
 * @date 2020-02-05
 */
public class SpOrderServices extends SpBase
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private String mid;
	/**  */
	private String orderId;
	/** 0：退款退货 1：退款 2：换货 */
	private String goodsServiceType;
	/** 退换货类型,数据由基础数据类型里取 */
	private Integer serviceType;
	/** 退换货原因 */
	private String serviceRemark;
	/** 附件 */
	private String serviceAnnex;
	/** 本次申请可退还的积分，由系统计算得出 */
	private Integer refundScore;
	/** 使用的积分可抵扣金额 */
	private BigDecimal useScoreMoney;
	/** 获得的积分可抵扣金额 */
	private BigDecimal getScoreMoney;
	/** 申请退款的金额 */
	private BigDecimal refundMoney;
	/** 售后单可退款金额 */
	private BigDecimal refundableMoney;
	/** 1:同意 0：不同意 */
	private String isShopAgree;
	/** 商家不同意原因 */
	private String disagreeRemark;
	/** 用户收货地址id */
	private String userAddressId;
	/** 地区id */
	private String areaId;
	/** 地区id值 */
	private String areaIdPath;
	/** 用户收货人 */
	private String userName;
	/** 用户详细收货地址 */
	private String userAddress;
	/** 用户收货电话 */
	private String userPhone;
	/** 商家收货地区id */
	private String shopAreaId;
	/** 商家收货地区id值 */
	private String shopAreaIdPath;
	/** 商家收货人 */
	private String shopName;
	/** 商家详细收货地址 */
	private String shopAddress;
	/** 商家收货电话 */
	private String shopPhone;
	/** 0：未发货 1：已发货 */
	private String isUserSendGoods;
	/** 0：无需物流  1：快递 */
	private String expressType;
	/** 买家快递id */
	private String expressId;
	/** 买家物流单号 */
	private String expressNo;
	/** 商家是否收到货 -1：拒收  0：未收货  1：已收货 */
	private String isShopAccept;
	/** 商家拒收类型,数据由基础数据类型里取 */
	private Integer shopRejectType;
	/** 商家拒收原因,选择“其他”的时候填写文字 */
	private String shopRejectOther;
	/** 拒收时的货物图片 */
	private String shopRejectImg;
	/** 商家是否发货 0：未发货 1：已发货 */
	private String isShopSend;
	/** 0：无需物流  1：快递 */
	private String shopExpressType;
	/** 商家快递id */
	private String shopExpressId;
	/** 商家快递单号 */
	private String shopExpressNo;
	/** -1：拒收 0：未收货  1：已收货 */
	private String isUserAccept;
	/** 用户拒收原因,数据由基础数据类型里取 */
	private String userRejectType;
	/** 用户拒收原因,选择“其他”的时候填写文字 */
	private String userRejectOther;
	/** 创建时间 */
	private Date createTime;
	/** 是否结束 0：进行中  1:已结束 */
	private String isClose;
	/** 状态备注：0：待商家审核  1：等待用户发货 2：商家等待收货 3：商家确认收货  4：等待商家发货  5：确认收货  6：完成退款/退货 */
	private String serviceStatus;
	/** 商家受理期限 */
	private Date shopAcceptExpireTime;
	/** 用户发货期限 */
	private Date userSendExpireTime;
	/** 商家收货期限 */
	private Date shopReceiveExpireTime;
	/** 本次申请的商品,购买时获得的积分数 */
	private Integer getScoreVal;


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
	public void setGoodsServiceType(String goodsServiceType) 
	{
		this.goodsServiceType = goodsServiceType;
	}

	public String getGoodsServiceType() 
	{
		return goodsServiceType;
	}
	public void setServiceType(Integer serviceType) 
	{
		this.serviceType = serviceType;
	}

	public Integer getServiceType() 
	{
		return serviceType;
	}
	public void setServiceRemark(String serviceRemark) 
	{
		this.serviceRemark = serviceRemark;
	}

	public String getServiceRemark() 
	{
		return serviceRemark;
	}
	public void setServiceAnnex(String serviceAnnex) 
	{
		this.serviceAnnex = serviceAnnex;
	}

	public String getServiceAnnex() 
	{
		return serviceAnnex;
	}
	public void setRefundScore(Integer refundScore) 
	{
		this.refundScore = refundScore;
	}

	public Integer getRefundScore() 
	{
		return refundScore;
	}
	public void setUseScoreMoney(BigDecimal useScoreMoney) 
	{
		this.useScoreMoney = useScoreMoney;
	}

	public BigDecimal getUseScoreMoney() 
	{
		return useScoreMoney;
	}
	public void setGetScoreMoney(BigDecimal getScoreMoney) 
	{
		this.getScoreMoney = getScoreMoney;
	}

	public BigDecimal getGetScoreMoney() 
	{
		return getScoreMoney;
	}
	public void setRefundMoney(BigDecimal refundMoney) 
	{
		this.refundMoney = refundMoney;
	}

	public BigDecimal getRefundMoney() 
	{
		return refundMoney;
	}
	public void setRefundableMoney(BigDecimal refundableMoney) 
	{
		this.refundableMoney = refundableMoney;
	}

	public BigDecimal getRefundableMoney() 
	{
		return refundableMoney;
	}
	public void setIsShopAgree(String isShopAgree) 
	{
		this.isShopAgree = isShopAgree;
	}

	public String getIsShopAgree() 
	{
		return isShopAgree;
	}
	public void setDisagreeRemark(String disagreeRemark) 
	{
		this.disagreeRemark = disagreeRemark;
	}

	public String getDisagreeRemark() 
	{
		return disagreeRemark;
	}
	public void setUserAddressId(String userAddressId) 
	{
		this.userAddressId = userAddressId;
	}

	public String getUserAddressId() 
	{
		return userAddressId;
	}
	public void setAreaId(String areaId) 
	{
		this.areaId = areaId;
	}

	public String getAreaId() 
	{
		return areaId;
	}
	public void setAreaIdPath(String areaIdPath) 
	{
		this.areaIdPath = areaIdPath;
	}

	public String getAreaIdPath() 
	{
		return areaIdPath;
	}
	public void setUserName(String userName) 
	{
		this.userName = userName;
	}

	public String getUserName() 
	{
		return userName;
	}
	public void setUserAddress(String userAddress) 
	{
		this.userAddress = userAddress;
	}

	public String getUserAddress() 
	{
		return userAddress;
	}
	public void setUserPhone(String userPhone) 
	{
		this.userPhone = userPhone;
	}

	public String getUserPhone() 
	{
		return userPhone;
	}
	public void setShopAreaId(String shopAreaId) 
	{
		this.shopAreaId = shopAreaId;
	}

	public String getShopAreaId() 
	{
		return shopAreaId;
	}
	public void setShopAreaIdPath(String shopAreaIdPath) 
	{
		this.shopAreaIdPath = shopAreaIdPath;
	}

	public String getShopAreaIdPath() 
	{
		return shopAreaIdPath;
	}
	public void setShopName(String shopName) 
	{
		this.shopName = shopName;
	}

	public String getShopName() 
	{
		return shopName;
	}
	public void setShopAddress(String shopAddress) 
	{
		this.shopAddress = shopAddress;
	}

	public String getShopAddress() 
	{
		return shopAddress;
	}
	public void setShopPhone(String shopPhone) 
	{
		this.shopPhone = shopPhone;
	}

	public String getShopPhone() 
	{
		return shopPhone;
	}
	public void setIsUserSendGoods(String isUserSendGoods) 
	{
		this.isUserSendGoods = isUserSendGoods;
	}

	public String getIsUserSendGoods() 
	{
		return isUserSendGoods;
	}
	public void setExpressType(String expressType) 
	{
		this.expressType = expressType;
	}

	public String getExpressType() 
	{
		return expressType;
	}
	public void setExpressId(String expressId) 
	{
		this.expressId = expressId;
	}

	public String getExpressId() 
	{
		return expressId;
	}
	public void setExpressNo(String expressNo) 
	{
		this.expressNo = expressNo;
	}

	public String getExpressNo() 
	{
		return expressNo;
	}
	public void setIsShopAccept(String isShopAccept) 
	{
		this.isShopAccept = isShopAccept;
	}

	public String getIsShopAccept() 
	{
		return isShopAccept;
	}
	public void setShopRejectType(Integer shopRejectType) 
	{
		this.shopRejectType = shopRejectType;
	}

	public Integer getShopRejectType() 
	{
		return shopRejectType;
	}
	public void setShopRejectOther(String shopRejectOther) 
	{
		this.shopRejectOther = shopRejectOther;
	}

	public String getShopRejectOther() 
	{
		return shopRejectOther;
	}
	public void setShopRejectImg(String shopRejectImg) 
	{
		this.shopRejectImg = shopRejectImg;
	}

	public String getShopRejectImg() 
	{
		return shopRejectImg;
	}
	public void setIsShopSend(String isShopSend) 
	{
		this.isShopSend = isShopSend;
	}

	public String getIsShopSend() 
	{
		return isShopSend;
	}
	public void setShopExpressType(String shopExpressType) 
	{
		this.shopExpressType = shopExpressType;
	}

	public String getShopExpressType() 
	{
		return shopExpressType;
	}
	public void setShopExpressId(String shopExpressId) 
	{
		this.shopExpressId = shopExpressId;
	}

	public String getShopExpressId() 
	{
		return shopExpressId;
	}
	public void setShopExpressNo(String shopExpressNo) 
	{
		this.shopExpressNo = shopExpressNo;
	}

	public String getShopExpressNo() 
	{
		return shopExpressNo;
	}
	public void setIsUserAccept(String isUserAccept) 
	{
		this.isUserAccept = isUserAccept;
	}

	public String getIsUserAccept() 
	{
		return isUserAccept;
	}
	public void setUserRejectType(String userRejectType) 
	{
		this.userRejectType = userRejectType;
	}

	public String getUserRejectType() 
	{
		return userRejectType;
	}
	public void setUserRejectOther(String userRejectOther) 
	{
		this.userRejectOther = userRejectOther;
	}

	public String getUserRejectOther() 
	{
		return userRejectOther;
	}
	public void setCreateTime(Date createTime) 
	{
		this.createTime = createTime;
	}

	public Date getCreateTime() 
	{
		return createTime;
	}
	public void setIsClose(String isClose) 
	{
		this.isClose = isClose;
	}

	public String getIsClose() 
	{
		return isClose;
	}
	public void setServiceStatus(String serviceStatus) 
	{
		this.serviceStatus = serviceStatus;
	}

	public String getServiceStatus() 
	{
		return serviceStatus;
	}
	public void setShopAcceptExpireTime(Date shopAcceptExpireTime) 
	{
		this.shopAcceptExpireTime = shopAcceptExpireTime;
	}

	public Date getShopAcceptExpireTime() 
	{
		return shopAcceptExpireTime;
	}
	public void setUserSendExpireTime(Date userSendExpireTime) 
	{
		this.userSendExpireTime = userSendExpireTime;
	}

	public Date getUserSendExpireTime() 
	{
		return userSendExpireTime;
	}
	public void setShopReceiveExpireTime(Date shopReceiveExpireTime) 
	{
		this.shopReceiveExpireTime = shopReceiveExpireTime;
	}

	public Date getShopReceiveExpireTime() 
	{
		return shopReceiveExpireTime;
	}
	public void setGetScoreVal(Integer getScoreVal) 
	{
		this.getScoreVal = getScoreVal;
	}

	public Integer getGetScoreVal() 
	{
		return getScoreVal;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("mid", getMid())
            .append("orderId", getOrderId())
            .append("goodsServiceType", getGoodsServiceType())
            .append("serviceType", getServiceType())
            .append("serviceRemark", getServiceRemark())
            .append("serviceAnnex", getServiceAnnex())
            .append("refundScore", getRefundScore())
            .append("useScoreMoney", getUseScoreMoney())
            .append("getScoreMoney", getGetScoreMoney())
            .append("refundMoney", getRefundMoney())
            .append("refundableMoney", getRefundableMoney())
            .append("isShopAgree", getIsShopAgree())
            .append("disagreeRemark", getDisagreeRemark())
            .append("userAddressId", getUserAddressId())
            .append("areaId", getAreaId())
            .append("areaIdPath", getAreaIdPath())
            .append("userName", getUserName())
            .append("userAddress", getUserAddress())
            .append("userPhone", getUserPhone())
            .append("shopAreaId", getShopAreaId())
            .append("shopAreaIdPath", getShopAreaIdPath())
            .append("shopName", getShopName())
            .append("shopAddress", getShopAddress())
            .append("shopPhone", getShopPhone())
            .append("isUserSendGoods", getIsUserSendGoods())
            .append("expressType", getExpressType())
            .append("expressId", getExpressId())
            .append("expressNo", getExpressNo())
            .append("isShopAccept", getIsShopAccept())
            .append("shopRejectType", getShopRejectType())
            .append("shopRejectOther", getShopRejectOther())
            .append("shopRejectImg", getShopRejectImg())
            .append("isShopSend", getIsShopSend())
            .append("shopExpressType", getShopExpressType())
            .append("shopExpressId", getShopExpressId())
            .append("shopExpressNo", getShopExpressNo())
            .append("isUserAccept", getIsUserAccept())
            .append("userRejectType", getUserRejectType())
            .append("userRejectOther", getUserRejectOther())
            .append("createTime", getCreateTime())
            .append("isClose", getIsClose())
            .append("serviceStatus", getServiceStatus())
            .append("shopAcceptExpireTime", getShopAcceptExpireTime())
            .append("userSendExpireTime", getUserSendExpireTime())
            .append("shopReceiveExpireTime", getShopReceiveExpireTime())
            .append("getScoreVal", getGetScoreVal())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("deptId", getDeptId())
            .append("deptName", getDeptName())
            .append("sort", getSort())
            .toString();
    }
}
