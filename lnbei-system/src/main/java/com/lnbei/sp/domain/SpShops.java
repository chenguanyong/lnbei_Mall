package com.lnbei.sp.domain;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 店铺表 sp_shops
 * 
 * @author lnbei
 * @date 2020-02-05
 */
public class SpShops extends SpBase
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private String mid;
	/**  */
	private String shopSn;
	/**  */
	private String memberId;
	/**  */
	private String areaIdPath;
	/**  */
	private String areaId;
	/**  */
	private String isSelf;
	/**  */
	private String shopName;
	/**  */
	private String shopKeeper;
	/**  */
	private String telephone;
	/**  */
	private String shopCompany;
	/**  */
	private String shopImg;
	/**  */
	private String shopTel;
	/**  */
	private String shopQq;
	/**  */
	private String shopWangWang;
	/**  */
	private String shopAddress;
	/**  */
	private String bankId;
	/**  */
	private String bankNo;
	/**  */
	private String bankUserName;
	/**  */
	private String isInvoice;
	/**  */
	private String invoiceRemarks;
	/**  */
	private Date serviceStartTime;
	/**  */
	private Date serviceEndTime;
	/**  */
	private Integer freight;
	/**  */
	private String shopAtive;
	/**  */
	private String shopStatus;
	/**  */
	private String statusDesc;
	/**  */
	private BigDecimal shopMoney;
	/**  */
	private BigDecimal lockMoney;
	/**  */
	private Integer noSettledOrderNum;
	/**  */
	private BigDecimal noSettledOrderFee;
	/**  */
	private BigDecimal paymentMoney;
	/**  */
	private String bankAreaId;
	/**  */
	private String bankAreaidPath;
	/**  */
	private String applyStatus;
	/**  */
	private String applyDesc;
	/**  */
	private Date applyTime;
	/**  */
	private String applyStep;
	/** 店铺公告 */
	private String shopNotice;
	/** 充值金额 */
	private BigDecimal rechargeMoney;
	/**  */
	private BigDecimal longitude;
	/**  */
	private BigDecimal latitude;
	/**  */
	private Integer mapLevel;

	private String goodsCatIds;
	
	
	public String getGoodsCatIds() {
		return goodsCatIds;
	}

	public void setGoodsCatIds(String goodsCatIds) {
		this.goodsCatIds = goodsCatIds;
	}

	public void setMid(String mid) 
	{
		this.mid = mid;
	}

	public String getMid() 
	{
		return mid;
	}
	public void setShopSn(String shopSn) 
	{
		this.shopSn = shopSn;
	}

	public String getShopSn() 
	{
		return shopSn;
	}
	public void setMemberId(String memberId) 
	{
		this.memberId = memberId;
	}

	public String getMemberId() 
	{
		return memberId;
	}
	public void setAreaIdPath(String areaIdPath) 
	{
		this.areaIdPath = areaIdPath;
	}

	public String getAreaIdPath() 
	{
		return areaIdPath;
	}
	public void setAreaId(String areaId) 
	{
		this.areaId = areaId;
	}

	public String getAreaId() 
	{
		return areaId;
	}
	public void setIsSelf(String isSelf) 
	{
		this.isSelf = isSelf;
	}

	public String getIsSelf() 
	{
		return isSelf;
	}
	public void setShopName(String shopName) 
	{
		this.shopName = shopName;
	}

	public String getShopName() 
	{
		return shopName;
	}
	public void setShopKeeper(String shopKeeper) 
	{
		this.shopKeeper = shopKeeper;
	}

	public String getShopKeeper() 
	{
		return shopKeeper;
	}
	public void setTelephone(String telephone) 
	{
		this.telephone = telephone;
	}

	public String getTelephone() 
	{
		return telephone;
	}
	public void setShopCompany(String shopCompany) 
	{
		this.shopCompany = shopCompany;
	}

	public String getShopCompany() 
	{
		return shopCompany;
	}
	public void setShopImg(String shopImg) 
	{
		this.shopImg = shopImg;
	}

	public String getShopImg() 
	{
		return shopImg;
	}
	public void setShopTel(String shopTel) 
	{
		this.shopTel = shopTel;
	}

	public String getShopTel() 
	{
		return shopTel;
	}
	public void setShopQq(String shopQq) 
	{
		this.shopQq = shopQq;
	}

	public String getShopQq() 
	{
		return shopQq;
	}
	public void setShopWangWang(String shopWangWang) 
	{
		this.shopWangWang = shopWangWang;
	}

	public String getShopWangWang() 
	{
		return shopWangWang;
	}
	public void setShopAddress(String shopAddress) 
	{
		this.shopAddress = shopAddress;
	}

	public String getShopAddress() 
	{
		return shopAddress;
	}
	public void setBankId(String bankId) 
	{
		this.bankId = bankId;
	}

	public String getBankId() 
	{
		return bankId;
	}
	public void setBankNo(String bankNo) 
	{
		this.bankNo = bankNo;
	}

	public String getBankNo() 
	{
		return bankNo;
	}
	public void setBankUserName(String bankUserName) 
	{
		this.bankUserName = bankUserName;
	}

	public String getBankUserName() 
	{
		return bankUserName;
	}
	public void setIsInvoice(String isInvoice) 
	{
		this.isInvoice = isInvoice;
	}

	public String getIsInvoice() 
	{
		return isInvoice;
	}
	public void setInvoiceRemarks(String invoiceRemarks) 
	{
		this.invoiceRemarks = invoiceRemarks;
	}

	public String getInvoiceRemarks() 
	{
		return invoiceRemarks;
	}
	public void setServiceStartTime(Date serviceStartTime) 
	{
		this.serviceStartTime = serviceStartTime;
	}

	public Date getServiceStartTime() 
	{
		return serviceStartTime;
	}
	public void setServiceEndTime(Date serviceEndTime) 
	{
		this.serviceEndTime = serviceEndTime;
	}

	public Date getServiceEndTime() 
	{
		return serviceEndTime;
	}
	public void setFreight(Integer freight) 
	{
		this.freight = freight;
	}

	public Integer getFreight() 
	{
		return freight;
	}
	public void setShopAtive(String shopAtive) 
	{
		this.shopAtive = shopAtive;
	}

	public String getShopAtive() 
	{
		return shopAtive;
	}
	public void setShopStatus(String shopStatus) 
	{
		this.shopStatus = shopStatus;
	}

	public String getShopStatus() 
	{
		return shopStatus;
	}
	public void setStatusDesc(String statusDesc) 
	{
		this.statusDesc = statusDesc;
	}

	public String getStatusDesc() 
	{
		return statusDesc;
	}
	public void setShopMoney(BigDecimal shopMoney) 
	{
		this.shopMoney = shopMoney;
	}

	public BigDecimal getShopMoney() 
	{
		return shopMoney;
	}
	public void setLockMoney(BigDecimal lockMoney) 
	{
		this.lockMoney = lockMoney;
	}

	public BigDecimal getLockMoney() 
	{
		return lockMoney;
	}
	public void setNoSettledOrderNum(Integer noSettledOrderNum) 
	{
		this.noSettledOrderNum = noSettledOrderNum;
	}

	public Integer getNoSettledOrderNum() 
	{
		return noSettledOrderNum;
	}
	public void setNoSettledOrderFee(BigDecimal noSettledOrderFee) 
	{
		this.noSettledOrderFee = noSettledOrderFee;
	}

	public BigDecimal getNoSettledOrderFee() 
	{
		return noSettledOrderFee;
	}
	public void setPaymentMoney(BigDecimal paymentMoney) 
	{
		this.paymentMoney = paymentMoney;
	}

	public BigDecimal getPaymentMoney() 
	{
		return paymentMoney;
	}
	public void setBankAreaId(String bankAreaId) 
	{
		this.bankAreaId = bankAreaId;
	}

	public String getBankAreaId() 
	{
		return bankAreaId;
	}
	public void setBankAreaidPath(String bankAreaidPath) 
	{
		this.bankAreaidPath = bankAreaidPath;
	}

	public String getBankAreaidPath() 
	{
		return bankAreaidPath;
	}
	public void setApplyStatus(String applyStatus) 
	{
		this.applyStatus = applyStatus;
	}

	public String getApplyStatus() 
	{
		return applyStatus;
	}
	public void setApplyDesc(String applyDesc) 
	{
		this.applyDesc = applyDesc;
	}

	public String getApplyDesc() 
	{
		return applyDesc;
	}
	public void setApplyTime(Date applyTime) 
	{
		this.applyTime = applyTime;
	}

	public Date getApplyTime() 
	{
		return applyTime;
	}
	public void setApplyStep(String applyStep) 
	{
		this.applyStep = applyStep;
	}

	public String getApplyStep() 
	{
		return applyStep;
	}
	public void setShopNotice(String shopNotice) 
	{
		this.shopNotice = shopNotice;
	}

	public String getShopNotice() 
	{
		return shopNotice;
	}
	public void setRechargeMoney(BigDecimal rechargeMoney) 
	{
		this.rechargeMoney = rechargeMoney;
	}

	public BigDecimal getRechargeMoney() 
	{
		return rechargeMoney;
	}
	public void setLongitude(BigDecimal longitude) 
	{
		this.longitude = longitude;
	}

	public BigDecimal getLongitude() 
	{
		return longitude;
	}
	public void setLatitude(BigDecimal latitude) 
	{
		this.latitude = latitude;
	}

	public BigDecimal getLatitude() 
	{
		return latitude;
	}
	public void setMapLevel(Integer mapLevel) 
	{
		this.mapLevel = mapLevel;
	}

	public Integer getMapLevel() 
	{
		return mapLevel;
	}


    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("mid", getMid())
            .append("shopSn", getShopSn())
            .append("memberId", getMemberId())
            .append("areaIdPath", getAreaIdPath())
            .append("areaId", getAreaId())
            .append("isSelf", getIsSelf())
            .append("shopName", getShopName())
            .append("shopKeeper", getShopKeeper())
            .append("telephone", getTelephone())
            .append("shopCompany", getShopCompany())
            .append("shopImg", getShopImg())
            .append("shopTel", getShopTel())
            .append("shopQq", getShopQq())
            .append("shopWangWang", getShopWangWang())
            .append("shopAddress", getShopAddress())
            .append("bankId", getBankId())
            .append("bankNo", getBankNo())
            .append("bankUserName", getBankUserName())
            .append("isInvoice", getIsInvoice())
            .append("invoiceRemarks", getInvoiceRemarks())
            .append("serviceStartTime", getServiceStartTime())
            .append("serviceEndTime", getServiceEndTime())
            .append("freight", getFreight())
            .append("shopAtive", getShopAtive())
            .append("shopStatus", getShopStatus())
            .append("statusDesc", getStatusDesc())
            .append("shopMoney", getShopMoney())
            .append("lockMoney", getLockMoney())
            .append("noSettledOrderNum", getNoSettledOrderNum())
            .append("noSettledOrderFee", getNoSettledOrderFee())
            .append("paymentMoney", getPaymentMoney())
            .append("bankAreaId", getBankAreaId())
            .append("bankAreaidPath", getBankAreaidPath())
            .append("applyStatus", getApplyStatus())
            .append("applyDesc", getApplyDesc())
            .append("applyTime", getApplyTime())
            .append("applyStep", getApplyStep())
            .append("shopNotice", getShopNotice())
            .append("rechargeMoney", getRechargeMoney())
            .append("longitude", getLongitude())
            .append("latitude", getLatitude())
            .append("mapLevel", getMapLevel())
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
