package com.lnbei.sp.domain;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 商铺扩展表 sp_shop_extras
 * 
 * @author lnbei
 * @date 2020-02-19
 */
public class SpShopExtras extends SpBase
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private String mid;
	/**  */
	private String shopId;
	/**  */
	private Integer businessLicenceType;
	/**  */
	private String businessLicence;
	/**  */
	private String licenseAddress;
	/**  */
	private String businessAreaPath;
	/**  */
	private String legalPersonName;
	/**  */
	private Date establishmentDate;
	/**  */
	private Date businessStartDate;
	/**  */
	private Date businessEndDate;
	/**  */
	private Integer isLongbusinessDate;
	/**  */
	private Integer registeredCapital;
	/**  */
	private String empiricalRange;
	/**  */
	private String legalCertificateType;
	/**  */
	private String legalCertificate;
	/**  */
	private Date legalCertificateStartDate;
	/**  */
	private Date legalCertificateEndDate;
	/**  */
	private String isLonglegalCertificateDate;
	/**  */
	private String legalCertificateImg;
	/**  */
	private String businessLicenceImg;
	/**  */
	private String bankAccountPermitImg;
	/**  */
	private String organizationCode;
	/**  */
	private Date organizationCodeStartDate;
	/**  */
	private Date organizationCodeEndDate;
	/**  */
	private Integer isLongOrganizationCodeDate;
	/**  */
	private String organizationCodeImg;
	/**  */
	private String taxRegistrationCertificateImg;
	/**  */
	private String taxpayerQualificationImg;
	/**  */
	private String taxpayerType;
	/**  */
	private String taxpayerNo;
	/**  */
	private String applyLinkMan;
	/**  */
	private String applyLinkTel;
	/**  */
	private String applyLinkEmail;
	/**  */
	private Integer isInvestment;
	/**  */
	private String investmentStaff;

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
	public void setBusinessLicenceType(Integer businessLicenceType) 
	{
		this.businessLicenceType = businessLicenceType;
	}

	public Integer getBusinessLicenceType() 
	{
		return businessLicenceType;
	}
	public void setBusinessLicence(String businessLicence) 
	{
		this.businessLicence = businessLicence;
	}

	public String getBusinessLicence() 
	{
		return businessLicence;
	}
	public void setLicenseAddress(String licenseAddress) 
	{
		this.licenseAddress = licenseAddress;
	}

	public String getLicenseAddress() 
	{
		return licenseAddress;
	}
	public void setBusinessAreaPath(String businessAreaPath) 
	{
		this.businessAreaPath = businessAreaPath;
	}

	public String getBusinessAreaPath() 
	{
		return businessAreaPath;
	}
	public void setLegalPersonName(String legalPersonName) 
	{
		this.legalPersonName = legalPersonName;
	}

	public String getLegalPersonName() 
	{
		return legalPersonName;
	}
	public void setEstablishmentDate(Date establishmentDate) 
	{
		this.establishmentDate = establishmentDate;
	}

	public Date getEstablishmentDate() 
	{
		return establishmentDate;
	}
	public void setBusinessStartDate(Date businessStartDate) 
	{
		this.businessStartDate = businessStartDate;
	}

	public Date getBusinessStartDate() 
	{
		return businessStartDate;
	}
	public void setBusinessEndDate(Date businessEnddate) 
	{
		this.businessEndDate = businessEnddate;
	}

	public Date getBusinessEndDate() 
	{
		return businessEndDate;
	}
	public void setIsLongbusinessDate(Integer isLongbusinessDate) 
	{
		this.isLongbusinessDate = isLongbusinessDate;
	}

	public Integer getIsLongbusinessDate() 
	{
		return isLongbusinessDate;
	}

	public void setEmpiricalRange(String empiricalRange) 
	{
		this.empiricalRange = empiricalRange;
	}

	public String getEmpiricalRange() 
	{
		return empiricalRange;
	}
	public void setLegalCertificateType(String legalCertificateType) 
	{
		this.legalCertificateType = legalCertificateType;
	}

	public String getLegalCertificateType() 
	{
		return legalCertificateType;
	}
	public void setLegalCertificate(String legalCertificate) 
	{
		this.legalCertificate = legalCertificate;
	}

	public String getLegalCertificate() 
	{
		return legalCertificate;
	}
	public void setLegalCertificateStartDate(Date legalCertificateStartDate) 
	{
		this.legalCertificateStartDate = legalCertificateStartDate;
	}

	public Date getLegalCertificateStartDate() 
	{
		return legalCertificateStartDate;
	}
	public void setLegalCertificateEndDate(Date legalCertificateEndDate) 
	{
		this.legalCertificateEndDate = legalCertificateEndDate;
	}

	public Date getLegalCertificateEndDate() 
	{
		return legalCertificateEndDate;
	}
	public void setIsLonglegalCertificateDate(String isLonglegalCertificateDate) 
	{
		this.isLonglegalCertificateDate = isLonglegalCertificateDate;
	}

	public String getIsLonglegalCertificateDate() 
	{
		return isLonglegalCertificateDate;
	}
	public void setLegalCertificateImg(String legalCertificateImg) 
	{
		this.legalCertificateImg = legalCertificateImg;
	}

	public String getLegalCertificateImg() 
	{
		return legalCertificateImg;
	}
	public void setBusinessLicenceImg(String businessLicenceImg) 
	{
		this.businessLicenceImg = businessLicenceImg;
	}

	public String getBusinessLicenceImg() 
	{
		return businessLicenceImg;
	}
	public void setBankAccountPermitImg(String bankAccountPermitImg) 
	{
		this.bankAccountPermitImg = bankAccountPermitImg;
	}

	public String getBankAccountPermitImg() 
	{
		return bankAccountPermitImg;
	}
	public void setOrganizationCode(String organizationCode) 
	{
		this.organizationCode = organizationCode;
	}

	public String getOrganizationCode() 
	{
		return organizationCode;
	}
	public void setOrganizationCodeStartDate(Date organizationCodeStartDate) 
	{
		this.organizationCodeStartDate = organizationCodeStartDate;
	}

	public Date getOrganizationCodeStartDate() 
	{
		return organizationCodeStartDate;
	}
	public void setOrganizationCodeEndDate(Date organizationCodeEndDate) 
	{
		this.organizationCodeEndDate = organizationCodeEndDate;
	}

	public Date getOrganizationCodeEndDate() 
	{
		return organizationCodeEndDate;
	}
	public void setIsLongOrganizationCodeDate(Integer isLongOrganizationCodeDate) 
	{
		this.isLongOrganizationCodeDate = isLongOrganizationCodeDate;
	}

	public Integer getIsLongOrganizationCodeDate() 
	{
		return isLongOrganizationCodeDate;
	}
	public void setOrganizationCodeImg(String organizationCodeImg) 
	{
		this.organizationCodeImg = organizationCodeImg;
	}

	public String getOrganizationCodeImg() 
	{
		return organizationCodeImg;
	}
	public void setTaxRegistrationCertificateImg(String taxRegistrationCertificateImg) 
	{
		this.taxRegistrationCertificateImg = taxRegistrationCertificateImg;
	}

	public String getTaxRegistrationCertificateImg() 
	{
		return taxRegistrationCertificateImg;
	}
	public void setTaxpayerQualificationImg(String taxpayerQualificationImg) 
	{
		this.taxpayerQualificationImg = taxpayerQualificationImg;
	}

	public String getTaxpayerQualificationImg() 
	{
		return taxpayerQualificationImg;
	}
	public void setTaxpayerType(String taxpayerType) 
	{
		this.taxpayerType = taxpayerType;
	}

	public String getTaxpayerType() 
	{
		return taxpayerType;
	}
	public void setTaxpayerNo(String taxpayerNo) 
	{
		this.taxpayerNo = taxpayerNo;
	}

	public String getTaxpayerNo() 
	{
		return taxpayerNo;
	}
	public void setApplyLinkMan(String applyLinkMan) 
	{
		this.applyLinkMan = applyLinkMan;
	}

	public String getApplyLinkMan() 
	{
		return applyLinkMan;
	}
	public void setApplyLinkTel(String applyLinkTel) 
	{
		this.applyLinkTel = applyLinkTel;
	}

	public String getApplyLinkTel() 
	{
		return applyLinkTel;
	}
	public void setApplyLinkEmail(String applyLinkEmail) 
	{
		this.applyLinkEmail = applyLinkEmail;
	}

	public String getApplyLinkEmail() 
	{
		return applyLinkEmail;
	}
	public void setIsInvestment(Integer isInvestment) 
	{
		this.isInvestment = isInvestment;
	}

	public Integer getIsInvestment() 
	{
		return isInvestment;
	}
	public void setInvestmentStaff(String investmentStaff) 
	{
		this.investmentStaff = investmentStaff;
	}

	public String getInvestmentStaff() 
	{
		return investmentStaff;
	}


    public Integer getRegisteredCapital() {
		return registeredCapital;
	}

	public void setRegisteredCapital(Integer registeredCapital) {
		this.registeredCapital = registeredCapital;
	}

	public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("mid", getMid())
            .append("shopId", getShopId())
            .append("businessLicenceType", getBusinessLicenceType())
            .append("businessLicence", getBusinessLicence())
            .append("licenseAddress", getLicenseAddress())
            .append("businessAreaPath", getBusinessAreaPath())
            .append("legalPersonName", getLegalPersonName())
            .append("establishmentDate", getEstablishmentDate())
            .append("businessStartDate", getBusinessStartDate())
            .append("businessEnddate", getBusinessEndDate())
            .append("isLongbusinessDate", getIsLongbusinessDate())
            .append("registeredCapital", getRegisteredCapital())
            .append("empiricalRange", getEmpiricalRange())
            .append("legalCertificateType", getLegalCertificateType())
            .append("legalCertificate", getLegalCertificate())
            .append("legalCertificateStartDate", getLegalCertificateStartDate())
            .append("legalCertificateEndDate", getLegalCertificateEndDate())
            .append("isLonglegalCertificateDate", getIsLonglegalCertificateDate())
            .append("legalCertificateImg", getLegalCertificateImg())
            .append("businessLicenceImg", getBusinessLicenceImg())
            .append("bankAccountPermitImg", getBankAccountPermitImg())
            .append("organizationCode", getOrganizationCode())
            .append("organizationCodeStartDate", getOrganizationCodeStartDate())
            .append("organizationCodeEndDate", getOrganizationCodeEndDate())
            .append("isLongOrganizationCodeDate", getIsLongOrganizationCodeDate())
            .append("organizationCodeImg", getOrganizationCodeImg())
            .append("taxRegistrationCertificateImg", getTaxRegistrationCertificateImg())
            .append("taxpayerQualificationImg", getTaxpayerQualificationImg())
            .append("taxpayerType", getTaxpayerType())
            .append("taxpayerNo", getTaxpayerNo())
            .append("applyLinkMan", getApplyLinkMan())
            .append("applyLinkTel", getApplyLinkTel())
            .append("applyLinkEmail", getApplyLinkEmail())
            .append("isInvestment", getIsInvestment())
            .append("investmentStaff", getInvestmentStaff())
            .append("createTime", getCreateTime())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .append("remark", getRemark())
            .append("sort", getSort())
            .append("status", getStatus())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
