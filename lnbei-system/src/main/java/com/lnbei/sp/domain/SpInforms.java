package com.lnbei.sp.domain;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 举报管理表 sp_informs
 * 
 * @author lnbei
 * @date 2020-02-23
 */
public class SpInforms extends SpBase
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private String mid;
	/**  */
	private String informTargetId;
	/**  */
	private String goodId;
	/**  */
	private String shopId;
	/**  */
	private String informType;
	/**  */
	private String informContent;
	/**  */
	private String informAnnex;
	/**  */
	private Date informTime;
	/**  */
	private String respondContent;
	/**  */
	private String finalHandleStaffId;
	/**  */
	private Date finalHandleTime;

	public void setMid(String mid) 
	{
		this.mid = mid;
	}

	public String getMid() 
	{
		return mid;
	}
	public void setInformTargetId(String informTargetId) 
	{
		this.informTargetId = informTargetId;
	}

	public String getInformTargetId() 
	{
		return informTargetId;
	}
	public void setGoodId(String goodId) 
	{
		this.goodId = goodId;
	}

	public String getGoodId() 
	{
		return goodId;
	}
	public void setShopId(String shopId) 
	{
		this.shopId = shopId;
	}

	public String getShopId() 
	{
		return shopId;
	}
	public void setInformType(String informType) 
	{
		this.informType = informType;
	}

	public String getInformType() 
	{
		return informType;
	}
	public void setInformContent(String informContent) 
	{
		this.informContent = informContent;
	}

	public String getInformContent() 
	{
		return informContent;
	}
	public void setInformAnnex(String informAnnex) 
	{
		this.informAnnex = informAnnex;
	}

	public String getInformAnnex() 
	{
		return informAnnex;
	}
	public void setInformTime(Date informTime) 
	{
		this.informTime = informTime;
	}

	public Date getInformTime() 
	{
		return informTime;
	}
	public void setRespondContent(String respondContent) 
	{
		this.respondContent = respondContent;
	}

	public String getRespondContent() 
	{
		return respondContent;
	}
	public void setFinalHandleStaffId(String finalHandleStaffId) 
	{
		this.finalHandleStaffId = finalHandleStaffId;
	}

	public String getFinalHandleStaffId() 
	{
		return finalHandleStaffId;
	}
	public void setFinalHandleTime(Date finalHandleTime) 
	{
		this.finalHandleTime = finalHandleTime;
	}

	public Date getFinalHandleTime() 
	{
		return finalHandleTime;
	}


    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("mid", getMid())
            .append("informTargetId", getInformTargetId())
            .append("goodId", getGoodId())
            .append("shopId", getShopId())
            .append("informType", getInformType())
            .append("informContent", getInformContent())
            .append("informAnnex", getInformAnnex())
            .append("informTime", getInformTime())
            .append("respondContent", getRespondContent())
            .append("finalHandleStaffId", getFinalHandleStaffId())
            .append("finalHandleTime", getFinalHandleTime())
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
