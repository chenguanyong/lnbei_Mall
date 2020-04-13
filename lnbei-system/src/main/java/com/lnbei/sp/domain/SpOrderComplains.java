package com.lnbei.sp.domain;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 商品投诉表 sp_order_complains
 * 
 * @author lnbei
 * @date 2020-02-05
 */
public class SpOrderComplains extends SpBase
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private String mid;
	/**  */
	private String orderId;
	/**  */
	private String complainType;
	/**  */
	private String complainTargetId;
	/**  */
	private String respondTargetId;
	/**  */
	private String needRespond;
	/**  */
	private Date deliverRespondTime;
	/**  */
	private String complainContent;
	/**  */
	private String complainAnnex;
	/**  */
	private String complainStatus;
	/**  */
	private Date complainTime;
	/**  */
	private String respondContent;
	/**  */
	private String respondAnnex;
	/**  */
	private Date respondTime;
	/**  */
	private String finalResult;
	/**  */
	private Date finalResultTime;
	/**  */
	private Integer finalHandleStaffid;


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
	public void setComplainType(String complainType) 
	{
		this.complainType = complainType;
	}

	public String getComplainType() 
	{
		return complainType;
	}
	public void setComplainTargetId(String complainTargetId) 
	{
		this.complainTargetId = complainTargetId;
	}

	public String getComplainTargetId() 
	{
		return complainTargetId;
	}
	public void setRespondTargetId(String respondTargetId) 
	{
		this.respondTargetId = respondTargetId;
	}

	public String getRespondTargetId() 
	{
		return respondTargetId;
	}
	public void setNeedRespond(String needRespond) 
	{
		this.needRespond = needRespond;
	}

	public String getNeedRespond() 
	{
		return needRespond;
	}
	public void setDeliverRespondTime(Date deliverRespondTime) 
	{
		this.deliverRespondTime = deliverRespondTime;
	}

	public Date getDeliverRespondTime() 
	{
		return deliverRespondTime;
	}
	public void setComplainContent(String complainContent) 
	{
		this.complainContent = complainContent;
	}

	public String getComplainContent() 
	{
		return complainContent;
	}
	public void setComplainAnnex(String complainAnnex) 
	{
		this.complainAnnex = complainAnnex;
	}

	public String getComplainAnnex() 
	{
		return complainAnnex;
	}
	public void setComplainStatus(String complainStatus) 
	{
		this.complainStatus = complainStatus;
	}

	public String getComplainStatus() 
	{
		return complainStatus;
	}
	public void setComplainTime(Date complainTime) 
	{
		this.complainTime = complainTime;
	}

	public Date getComplainTime() 
	{
		return complainTime;
	}
	public void setRespondContent(String respondContent) 
	{
		this.respondContent = respondContent;
	}

	public String getRespondContent() 
	{
		return respondContent;
	}
	public void setRespondAnnex(String respondAnnex) 
	{
		this.respondAnnex = respondAnnex;
	}

	public String getRespondAnnex() 
	{
		return respondAnnex;
	}
	public void setRespondTime(Date respondTime) 
	{
		this.respondTime = respondTime;
	}

	public Date getRespondTime() 
	{
		return respondTime;
	}
	public void setFinalResult(String finalResult) 
	{
		this.finalResult = finalResult;
	}

	public String getFinalResult() 
	{
		return finalResult;
	}
	public void setFinalResultTime(Date finalResultTime) 
	{
		this.finalResultTime = finalResultTime;
	}

	public Date getFinalResultTime() 
	{
		return finalResultTime;
	}
	public void setFinalHandleStaffid(Integer finalHandleStaffid) 
	{
		this.finalHandleStaffid = finalHandleStaffid;
	}

	public Integer getFinalHandleStaffid() 
	{
		return finalHandleStaffid;
	}
	
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("mid", getMid())
            .append("orderId", getOrderId())
            .append("complainType", getComplainType())
            .append("complainTargetId", getComplainTargetId())
            .append("respondTargetId", getRespondTargetId())
            .append("needRespond", getNeedRespond())
            .append("deliverRespondTime", getDeliverRespondTime())
            .append("complainContent", getComplainContent())
            .append("complainAnnex", getComplainAnnex())
            .append("complainStatus", getComplainStatus())
            .append("complainTime", getComplainTime())
            .append("respondContent", getRespondContent())
            .append("respondAnnex", getRespondAnnex())
            .append("respondTime", getRespondTime())
            .append("finalResult", getFinalResult())
            .append("finalResultTime", getFinalResultTime())
            .append("finalHandleStaffid", getFinalHandleStaffid())
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
