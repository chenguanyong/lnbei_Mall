package com.lnbei.member.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 实名认证表 member_real_aurh
 * 
 * @author lnbei
 * @date 2020-01-24
 */
public class MemberRealAurh extends MemberBase
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private String mid;

	/** 身份证号 */
	private String idcardNo;
	/** 身份证姓名 */
	private String trueName;
	/** 身份证正面 */
	private String idcardImgZ;
	/** 身份证号反面 */
	private String idcardImgF;
	/** 身份证合照 */
	private String idcardImgH;
	/**  */
	private String status;


	public void setMid(String mid) 
	{
		this.mid = mid;
	}

	public String getMid() 
	{
		return mid;
	}

	public void setIdcardNo(String idcardNo) 
	{
		this.idcardNo = idcardNo;
	}

	public String getIdcardNo() 
	{
		return idcardNo;
	}
	public void setTrueName(String trueName) 
	{
		this.trueName = trueName;
	}

	public String getTrueName() 
	{
		return trueName;
	}
	public void setIdcardImgZ(String idcardImgZ) 
	{
		this.idcardImgZ = idcardImgZ;
	}

	public String getIdcardImgZ() 
	{
		return idcardImgZ;
	}
	public void setIdcardImgF(String idcardImgF) 
	{
		this.idcardImgF = idcardImgF;
	}

	public String getIdcardImgF() 
	{
		return idcardImgF;
	}
	public void setIdcardImgH(String idcardImgH) 
	{
		this.idcardImgH = idcardImgH;
	}

	public String getIdcardImgH() 
	{
		return idcardImgH;
	}
	public void setStatus(String status) 
	{
		this.status = status;
	}

	public String getStatus() 
	{
		return status;
	}


    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("mid", getMid())
            .append("userId", getUserId())
            .append("memberId", getMemberId())
            .append("idcardNo", getIdcardNo())
            .append("trueName", getTrueName())
            .append("idcardImgZ", getIdcardImgZ())
            .append("idcardImgF", getIdcardImgF())
            .append("idcardImgH", getIdcardImgH())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("sort", getSort())
            .toString();
    }
}
