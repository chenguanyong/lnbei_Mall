package com.lnbei.sp.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 订单表 sp_orders
 * 
 * @author lnbei
 * @date 2020-02-05
 */
public class SpOrders extends SpBase
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private String mid;
	/**  */
	private String orderNo;
	/**  */
	private String shopId;
	/**  */
	private String memberId;
	/**  */
	private String orderStatus;
	/**  */
	private BigDecimal goodsMoney;
	/**  */
	private String deliverType;
	/**  */
	private BigDecimal deliverMoney;
	/**  */
	private BigDecimal totalMoney;
	/**  */
	private BigDecimal realTotalMoney;
	/**  */
	private String payType;
	/**  */
	private String payFrom;
	/**  */
	private String isPay;
	/**  */
	private String areaId;
	/**  */
	private String areaIdPath;
	/**  */
	private String userName;
	/**  */
	private String userAddress;
	/**  */
	private String userPhone;
	/**  */
	private Integer orderScore;
	/**  */
	private String isInvoice;
	/**  */
	private String invoiceClient;
	/**  */
	private String orderRemarks;
	/**  */
	private String orderSrc;
	/**  */
	private BigDecimal needPay;
	/**  */
	private Integer payRand;
	/**  */
	private Integer orderType;
	/**  */
	private String isRefund;
	/**  */
	private String isAppraise;
	/**  */
	private Integer cancelReason;
	/**  */
	private Integer rejectReason;
	/**  */
	private String rejectOtherreason;
	/**  */
	private String isClosed;
	/**  */
	private String goodsSearchKeys;
	/**  */
	private String orderunique;
	/**  */
	private Date receiveTime;
	/**  */
	private Date deliveryTime;
	/**  */
	private String tradeNo;
	/**  */
	private String settlementId;
	/**  */
	private BigDecimal commissionFee;
	/**  */
	private BigDecimal scoreMoney;
	/**  */
	private Integer useScore;
	/**  */
	private String orderCode;
	/**  */
	private String extraJson;
	/**  */
	private Integer orderCodeTargetId;
	/** 提醒发货 0:未提醒 1:已提醒 */
	private String noticeDeliver;
	/** 发票信息 */
	private String invoiceJson;
	/** 锁定提现金额 */
	private BigDecimal lockCashMoney;
	/**  */
	private Date payTime;
	/**  */
	private String isBatch;
	/**  */
	private Integer totalPayFee;
	/** 是否开发票 1:是 0:否 */
	private String isMakeInvoice;
	/** 售后结束时间,确认收货时间+后台设置的售后有效天数 */
	private Date afterSaleEndTime;
	/** 获得的积分数可抵扣的金额 */
	private BigDecimal getScoreVal;
	/** 已退款支付金额 */
	private BigDecimal refundedPayMoney;
	/** 已退款积分 */
	private Integer refundedScore;
	/** 已退款积分抵扣金额 */
	private BigDecimal refundedScoreMoney;
	/** 已退款 购买商品获得的积分(用户本身购买商品可获得的积分),即失效的获得积分数 */
	private Integer refundedGetscore;
	/** 已退款 购买商品获得的积分可抵扣的金额 */
	private BigDecimal refundedGetScoreMoney;

	private List<SpOrderGoods> mSpOrderGoodsList;
	
	
	public List<SpOrderGoods> getmSpOrderGoodsList() {
		return mSpOrderGoodsList;
	}

	public void setmSpOrderGoodsList(List<SpOrderGoods> mSpOrderGoodsList) {
		this.mSpOrderGoodsList = mSpOrderGoodsList;
	}

	public void setMid(String mid) 
	{
		this.mid = mid;
	}

	public String getMid() 
	{
		return mid;
	}
	public void setOrderNo(String orderNo) 
	{
		this.orderNo = orderNo;
	}

	public String getOrderNo() 
	{
		return orderNo;
	}
	public void setShopId(String shopId) 
	{
		this.shopId = shopId;
	}

	public String getShopId() 
	{
		return shopId;
	}
	public void setMemberId(String memberId) 
	{
		this.memberId = memberId;
	}

	public String getMemberId() 
	{
		return memberId;
	}
	public void setOrderStatus(String orderStatus) 
	{
		this.orderStatus = orderStatus;
	}

	public String getOrderStatus() 
	{
		return orderStatus;
	}
	public void setGoodsMoney(BigDecimal goodsMoney) 
	{
		this.goodsMoney = goodsMoney;
	}

	public BigDecimal getGoodsMoney() 
	{
		return goodsMoney;
	}
	public void setDeliverType(String deliverType) 
	{
		this.deliverType = deliverType;
	}

	public String getDeliverType() 
	{
		return deliverType;
	}
	public void setDeliverMoney(BigDecimal deliverMoney) 
	{
		this.deliverMoney = deliverMoney;
	}

	public BigDecimal getDeliverMoney() 
	{
		return deliverMoney;
	}
	public void setTotalMoney(BigDecimal totalMoney) 
	{
		this.totalMoney = totalMoney;
	}

	public BigDecimal getTotalMoney() 
	{
		return totalMoney;
	}
	public void setRealTotalMoney(BigDecimal realTotalMoney) 
	{
		this.realTotalMoney = realTotalMoney;
	}

	public BigDecimal getRealTotalMoney() 
	{
		return realTotalMoney;
	}
	public void setPayType(String payType) 
	{
		this.payType = payType;
	}

	public String getPayType() 
	{
		return payType;
	}
	public void setPayFrom(String payFrom) 
	{
		this.payFrom = payFrom;
	}

	public String getPayFrom() 
	{
		return payFrom;
	}
	public void setIsPay(String isPay) 
	{
		this.isPay = isPay;
	}

	public String getIsPay() 
	{
		return isPay;
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
	public void setOrderScore(Integer orderScore) 
	{
		this.orderScore = orderScore;
	}

	public Integer getOrderScore() 
	{
		return orderScore;
	}
	public void setIsInvoice(String isInvoice) 
	{
		this.isInvoice = isInvoice;
	}

	public String getIsInvoice() 
	{
		return isInvoice;
	}
	public void setInvoiceClient(String invoiceClient) 
	{
		this.invoiceClient = invoiceClient;
	}

	public String getInvoiceClient() 
	{
		return invoiceClient;
	}
	public void setOrderRemarks(String orderRemarks) 
	{
		this.orderRemarks = orderRemarks;
	}

	public String getOrderRemarks() 
	{
		return orderRemarks;
	}
	public void setOrderSrc(String orderSrc) 
	{
		this.orderSrc = orderSrc;
	}

	public String getOrderSrc() 
	{
		return orderSrc;
	}
	public void setNeedPay(BigDecimal needPay) 
	{
		this.needPay = needPay;
	}

	public BigDecimal getNeedPay() 
	{
		return needPay;
	}
	public void setPayRand(Integer payRand) 
	{
		this.payRand = payRand;
	}

	public Integer getPayRand() 
	{
		return payRand;
	}
	public void setOrderType(Integer orderType) 
	{
		this.orderType = orderType;
	}

	public Integer getOrderType() 
	{
		return orderType;
	}
	public void setIsRefund(String isRefund) 
	{
		this.isRefund = isRefund;
	}

	public String getIsRefund() 
	{
		return isRefund;
	}
	public void setIsAppraise(String isAppraise) 
	{
		this.isAppraise = isAppraise;
	}

	public String getIsAppraise() 
	{
		return isAppraise;
	}
	public void setCancelReason(Integer cancelReason) 
	{
		this.cancelReason = cancelReason;
	}

	public Integer getCancelReason() 
	{
		return cancelReason;
	}
	public void setRejectReason(Integer rejectReason) 
	{
		this.rejectReason = rejectReason;
	}

	public Integer getRejectReason() 
	{
		return rejectReason;
	}
	public void setRejectOtherreason(String rejectOtherreason) 
	{
		this.rejectOtherreason = rejectOtherreason;
	}

	public String getRejectOtherreason() 
	{
		return rejectOtherreason;
	}
	public void setIsClosed(String isClosed) 
	{
		this.isClosed = isClosed;
	}

	public String getIsClosed() 
	{
		return isClosed;
	}
	public void setGoodsSearchKeys(String goodsSearchKeys) 
	{
		this.goodsSearchKeys = goodsSearchKeys;
	}

	public String getGoodsSearchKeys() 
	{
		return goodsSearchKeys;
	}
	public void setOrderunique(String orderunique) 
	{
		this.orderunique = orderunique;
	}

	public String getOrderunique() 
	{
		return orderunique;
	}
	public void setReceiveTime(Date receiveTime) 
	{
		this.receiveTime = receiveTime;
	}

	public Date getReceiveTime() 
	{
		return receiveTime;
	}
	public void setDeliveryTime(Date deliveryTime) 
	{
		this.deliveryTime = deliveryTime;
	}

	public Date getDeliveryTime() 
	{
		return deliveryTime;
	}
	public void setTradeNo(String tradeNo) 
	{
		this.tradeNo = tradeNo;
	}

	public String getTradeNo() 
	{
		return tradeNo;
	}
	public void setSettlementId(String settlementId) 
	{
		this.settlementId = settlementId;
	}

	public String getSettlementId() 
	{
		return settlementId;
	}
	public void setCommissionFee(BigDecimal commissionFee) 
	{
		this.commissionFee = commissionFee;
	}

	public BigDecimal getCommissionFee() 
	{
		return commissionFee;
	}
	public void setScoreMoney(BigDecimal scoreMoney) 
	{
		this.scoreMoney = scoreMoney;
	}

	public BigDecimal getScoreMoney() 
	{
		return scoreMoney;
	}
	public void setUseScore(Integer useScore) 
	{
		this.useScore = useScore;
	}

	public Integer getUseScore() 
	{
		return useScore;
	}
	public void setOrderCode(String orderCode) 
	{
		this.orderCode = orderCode;
	}

	public String getOrderCode() 
	{
		return orderCode;
	}
	public void setExtraJson(String extraJson) 
	{
		this.extraJson = extraJson;
	}

	public String getExtraJson() 
	{
		return extraJson;
	}
	public void setOrderCodeTargetId(Integer orderCodeTargetId) 
	{
		this.orderCodeTargetId = orderCodeTargetId;
	}

	public Integer getOrderCodeTargetId() 
	{
		return orderCodeTargetId;
	}
	public void setNoticeDeliver(String noticeDeliver) 
	{
		this.noticeDeliver = noticeDeliver;
	}

	public String getNoticeDeliver() 
	{
		return noticeDeliver;
	}
	public void setInvoiceJson(String invoiceJson) 
	{
		this.invoiceJson = invoiceJson;
	}

	public String getInvoiceJson() 
	{
		return invoiceJson;
	}
	public void setLockCashMoney(BigDecimal lockCashMoney) 
	{
		this.lockCashMoney = lockCashMoney;
	}

	public BigDecimal getLockCashMoney() 
	{
		return lockCashMoney;
	}
	public void setPayTime(Date payTime) 
	{
		this.payTime = payTime;
	}

	public Date getPayTime() 
	{
		return payTime;
	}
	public void setIsBatch(String isBatch) 
	{
		this.isBatch = isBatch;
	}

	public String getIsBatch() 
	{
		return isBatch;
	}
	public void setTotalPayFee(Integer totalPayFee) 
	{
		this.totalPayFee = totalPayFee;
	}

	public Integer getTotalPayFee() 
	{
		return totalPayFee;
	}
	public void setIsMakeInvoice(String isMakeInvoice) 
	{
		this.isMakeInvoice = isMakeInvoice;
	}

	public String getIsMakeInvoice() 
	{
		return isMakeInvoice;
	}
	public void setAfterSaleEndTime(Date afterSaleEndTime) 
	{
		this.afterSaleEndTime = afterSaleEndTime;
	}

	public Date getAfterSaleEndTime() 
	{
		return afterSaleEndTime;
	}
	public void setGetScoreVal(BigDecimal getScoreVal) 
	{
		this.getScoreVal = getScoreVal;
	}

	public BigDecimal getGetScoreVal() 
	{
		return getScoreVal;
	}
	public void setRefundedPayMoney(BigDecimal refundedPayMoney) 
	{
		this.refundedPayMoney = refundedPayMoney;
	}

	public BigDecimal getRefundedPayMoney() 
	{
		return refundedPayMoney;
	}
	public void setRefundedScore(Integer refundedScore) 
	{
		this.refundedScore = refundedScore;
	}

	public Integer getRefundedScore() 
	{
		return refundedScore;
	}
	public void setRefundedScoreMoney(BigDecimal refundedScoreMoney) 
	{
		this.refundedScoreMoney = refundedScoreMoney;
	}

	public BigDecimal getRefundedScoreMoney() 
	{
		return refundedScoreMoney;
	}
	public void setRefundedGetscore(Integer refundedGetscore) 
	{
		this.refundedGetscore = refundedGetscore;
	}

	public Integer getRefundedGetscore() 
	{
		return refundedGetscore;
	}
	public void setRefundedGetScoreMoney(BigDecimal refundedGetScoreMoney) 
	{
		this.refundedGetScoreMoney = refundedGetScoreMoney;
	}

	public BigDecimal getRefundedGetScoreMoney() 
	{
		return refundedGetScoreMoney;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("mid", getMid())
            .append("orderNo", getOrderNo())
            .append("shopId", getShopId())
            .append("memberId", getMemberId())
            .append("orderStatus", getOrderStatus())
            .append("goodsMoney", getGoodsMoney())
            .append("deliverType", getDeliverType())
            .append("deliverMoney", getDeliverMoney())
            .append("totalMoney", getTotalMoney())
            .append("realTotalMoney", getRealTotalMoney())
            .append("payType", getPayType())
            .append("payFrom", getPayFrom())
            .append("isPay", getIsPay())
            .append("areaId", getAreaId())
            .append("areaIdPath", getAreaIdPath())
            .append("userName", getUserName())
            .append("userAddress", getUserAddress())
            .append("userPhone", getUserPhone())
            .append("orderScore", getOrderScore())
            .append("isInvoice", getIsInvoice())
            .append("invoiceClient", getInvoiceClient())
            .append("orderRemarks", getOrderRemarks())
            .append("orderSrc", getOrderSrc())
            .append("needPay", getNeedPay())
            .append("payRand", getPayRand())
            .append("orderType", getOrderType())
            .append("isRefund", getIsRefund())
            .append("isAppraise", getIsAppraise())
            .append("cancelReason", getCancelReason())
            .append("rejectReason", getRejectReason())
            .append("rejectOtherreason", getRejectOtherreason())
            .append("isClosed", getIsClosed())
            .append("goodsSearchKeys", getGoodsSearchKeys())
            .append("orderunique", getOrderunique())
            .append("receiveTime", getReceiveTime())
            .append("deliveryTime", getDeliveryTime())
            .append("tradeNo", getTradeNo())
            .append("settlementId", getSettlementId())
            .append("commissionFee", getCommissionFee())
            .append("scoreMoney", getScoreMoney())
            .append("useScore", getUseScore())
            .append("orderCode", getOrderCode())
            .append("extraJson", getExtraJson())
            .append("orderCodeTargetId", getOrderCodeTargetId())
            .append("noticeDeliver", getNoticeDeliver())
            .append("invoiceJson", getInvoiceJson())
            .append("lockCashMoney", getLockCashMoney())
            .append("payTime", getPayTime())
            .append("isBatch", getIsBatch())
            .append("totalPayFee", getTotalPayFee())
            .append("isMakeInvoice", getIsMakeInvoice())
            .append("afterSaleEndTime", getAfterSaleEndTime())
            .append("getScoreVal", getGetScoreVal())
            .append("refundedPayMoney", getRefundedPayMoney())
            .append("refundedScore", getRefundedScore())
            .append("refundedScoreMoney", getRefundedScoreMoney())
            .append("refundedGetscore", getRefundedGetscore())
            .append("refundedGetScoreMoney", getRefundedGetScoreMoney())
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
