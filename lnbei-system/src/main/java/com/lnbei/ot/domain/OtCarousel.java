package com.lnbei.ot.domain;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 轮播图表 ot_carousel
 * 
 * @author lnbei
 * @date 2020-04-10
 */
public class OtCarousel extends OtBase
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private String mid;
	/**  */
	private String csPositionId;
	/**  */
	private String csFile;
	/**  */
	private String csName;
	/**  */
	private String csUrl;
	/**  */
	private Date csStartDate;
	/**  */
	private Date csEndDate;
	/**  */
	private Integer csClickNum;
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
	public void setCsPositionId(String csPositionId) 
	{
		this.csPositionId = csPositionId;
	}

	public String getCsPositionId() 
	{
		return csPositionId;
	}
	public void setCsFile(String csFile) 
	{
		this.csFile = csFile;
	}

	public String getCsFile() 
	{
		return csFile;
	}
	public void setCsName(String csName) 
	{
		this.csName = csName;
	}

	public String getCsName() 
	{
		return csName;
	}
	public void setCsUrl(String csUrl) 
	{
		this.csUrl = csUrl;
	}

	public String getCsUrl() 
	{
		return csUrl;
	}
	public void setCsStartDate(Date csStartDate) 
	{
		this.csStartDate = csStartDate;
	}

	public Date getCsStartDate() 
	{
		return csStartDate;
	}
	public void setCsEndDate(Date csEndDate) 
	{
		this.csEndDate = csEndDate;
	}

	public Date getCsEndDate() 
	{
		return csEndDate;
	}
	public void setCsClickNum(Integer csClickNum) 
	{
		this.csClickNum = csClickNum;
	}

	public Integer getCsClickNum() 
	{
		return csClickNum;
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
            .append("csPositionId", getCsPositionId())
            .append("csFile", getCsFile())
            .append("csName", getCsName())
            .append("csUrl", getCsUrl())
            .append("csStartDate", getCsStartDate())
            .append("csEndDate", getCsEndDate())
            .append("csClickNum", getCsClickNum())
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
