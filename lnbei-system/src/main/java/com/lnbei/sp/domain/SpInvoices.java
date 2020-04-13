package com.lnbei.sp.domain;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 发票管理表 sp_invoices
 * 
 * @author lnbei
 * @date 2020-02-23
 */
public class SpInvoices extends SpBase
{
	private static final long serialVersionUID = 1L;
	
	/** 主键 */
	private String mid;
	/** 发票抬头 */
	private String invoiceHead;
	/** 纳税人识别号 */
	private String invoiceCode;
	/** 用户id */
	private String memberId;
	/** 0:普票 1:增值税发票 */
	private String invoiceType;
	/** 增值税发票注册地址（invoiceType为1时该值不为空） */
	private String invoiceAddr;
	/** 增值税发票注册电话（invoiceType为1时该值不为空） */
	private String invoicePhoneNumber;
	/** 增值税发票开户银行（invoiceType为1时该值不为空） */
	private String invoiceBankName;
	/** 增值税发票银行账户（invoiceType为1时该值不为空） */
	private String invoiceBankNo;


	public void setMid(String mid) 
	{
		this.mid = mid;
	}

	public String getMid() 
	{
		return mid;
	}
	public void setInvoiceHead(String invoiceHead) 
	{
		this.invoiceHead = invoiceHead;
	}

	public String getInvoiceHead() 
	{
		return invoiceHead;
	}
	public void setInvoiceCode(String invoiceCode) 
	{
		this.invoiceCode = invoiceCode;
	}

	public String getInvoiceCode() 
	{
		return invoiceCode;
	}
	public void setMemberId(String memberId) 
	{
		this.memberId = memberId;
	}

	public String getMemberId() 
	{
		return memberId;
	}
	public void setInvoiceType(String invoiceType) 
	{
		this.invoiceType = invoiceType;
	}

	public String getInvoiceType() 
	{
		return invoiceType;
	}
	public void setInvoiceAddr(String invoiceAddr) 
	{
		this.invoiceAddr = invoiceAddr;
	}

	public String getInvoiceAddr() 
	{
		return invoiceAddr;
	}
	public void setInvoicePhoneNumber(String invoicePhoneNumber) 
	{
		this.invoicePhoneNumber = invoicePhoneNumber;
	}

	public String getInvoicePhoneNumber() 
	{
		return invoicePhoneNumber;
	}
	public void setInvoiceBankName(String invoiceBankName) 
	{
		this.invoiceBankName = invoiceBankName;
	}

	public String getInvoiceBankName() 
	{
		return invoiceBankName;
	}
	public void setInvoiceBankNo(String invoiceBankNo) 
	{
		this.invoiceBankNo = invoiceBankNo;
	}

	public String getInvoiceBankNo() 
	{
		return invoiceBankNo;
	}


    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("mid", getMid())
            .append("invoiceHead", getInvoiceHead())
            .append("invoiceCode", getInvoiceCode())
            .append("memberId", getMemberId())
            .append("invoiceType", getInvoiceType())
            .append("invoiceAddr", getInvoiceAddr())
            .append("invoicePhoneNumber", getInvoicePhoneNumber())
            .append("invoiceBankName", getInvoiceBankName())
            .append("invoiceBankNo", getInvoiceBankNo())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .append("remark", getRemark())
            .append("sort", getSort())
            .append("status", getStatus())
            .append("updateTime", getUpdateTime())
            .append("createTime", getCreateTime())
            .toString();
    }
}
