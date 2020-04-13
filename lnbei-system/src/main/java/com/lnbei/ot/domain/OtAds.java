package com.lnbei.ot.domain;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 广告表 ot_ads
 * 
 * @author lnbei
 * @date 2020-04-10
 */
public class OtAds extends OtBase
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private String mid;
	/**  */
	private String adPositionId;
	/**  */
	private String adFile;
	/**  */
	private String adName;
	/**  */
	private String adUrl;
	/**  */
	private Date adStartDate;
	/**  */
	private Date adEndDate;
	/**  */
	private Integer adClickNum;
	/**  */
	private String positionType;
	/**  */
	private String subTitle;


	public void setMid(String mid) 
	{
		this.mid = mid;
	}

	public String getMid() 
	{
		return mid;
	}
	public void setAdPositionId(String adPositionId) 
	{
		this.adPositionId = adPositionId;
	}

	public String getAdPositionId() 
	{
		return adPositionId;
	}
	public void setAdFile(String adFile) 
	{
		this.adFile = adFile;
	}

	public String getAdFile() 
	{
		return adFile;
	}
	public void setAdName(String adName) 
	{
		this.adName = adName;
	}

	public String getAdName() 
	{
		return adName;
	}
	public void setAdUrl(String adUrl) 
	{
		this.adUrl = adUrl;
	}

	public String getAdUrl() 
	{
		return adUrl;
	}
	public void setAdStartDate(Date adStartDate) 
	{
		this.adStartDate = adStartDate;
	}

	public Date getAdStartDate() 
	{
		return adStartDate;
	}
	public void setAdEndDate(Date adEndDate) 
	{
		this.adEndDate = adEndDate;
	}

	public Date getAdEndDate() 
	{
		return adEndDate;
	}
	public void setAdClickNum(Integer adClickNum) 
	{
		this.adClickNum = adClickNum;
	}

	public Integer getAdClickNum() 
	{
		return adClickNum;
	}
	public void setPositionType(String positionType) 
	{
		this.positionType = positionType;
	}

	public String getPositionType() 
	{
		return positionType;
	}
	public void setSubTitle(String subTitle) 
	{
		this.subTitle = subTitle;
	}

	public String getSubTitle() 
	{
		return subTitle;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("mid", getMid())
            .append("adPositionId", getAdPositionId())
            .append("adFile", getAdFile())
            .append("adName", getAdName())
            .append("adUrl", getAdUrl())
            .append("adStartDate", getAdStartDate())
            .append("adEndDate", getAdEndDate())
            .append("adClickNum", getAdClickNum())
            .append("positionType", getPositionType())
            .append("subTitle", getSubTitle())
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
