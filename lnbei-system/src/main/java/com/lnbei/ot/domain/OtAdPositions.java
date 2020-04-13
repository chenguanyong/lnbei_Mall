package com.lnbei.ot.domain;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 广告位置表 ot_ad_positions
 * 
 * @author lnbei
 * @date 2020-04-10
 */
public class OtAdPositions extends OtBase
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private String mid;
	/**  */
	private String positionType;
	/**  */
	private String positionName;
	/**  */
	private String positionWidth;
	/**  */
	private String positionHeight;
	/**  */
	private String positionCode;
	
	private List<OtAds> mAds ; 
	
	public List<OtAds> getmAds() {
		return mAds;
	}

	public void setmAds(List<OtAds> mAds) {
		this.mAds = mAds;
	}

	public void setMid(String mid) 
	{
		this.mid = mid;
	}

	public String getMid() 
	{
		return mid;
	}
	public void setPositionType(String positionType) 
	{
		this.positionType = positionType;
	}

	public String getPositionType() 
	{
		return positionType;
	}
	public void setPositionName(String positionName) 
	{
		this.positionName = positionName;
	}

	public String getPositionName() 
	{
		return positionName;
	}
	public void setPositionWidth(String positionWidth) 
	{
		this.positionWidth = positionWidth;
	}

	public String getPositionWidth() 
	{
		return positionWidth;
	}
	public void setPositionHeight(String positionHeight) 
	{
		this.positionHeight = positionHeight;
	}

	public String getPositionHeight() 
	{
		return positionHeight;
	}
	public void setPositionCode(String positionCode) 
	{
		this.positionCode = positionCode;
	}

	public String getPositionCode() 
	{
		return positionCode;
	}


    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("mid", getMid())
            .append("positionType", getPositionType())
            .append("positionName", getPositionName())
            .append("positionWidth", getPositionWidth())
            .append("positionHeight", getPositionHeight())
            .append("positionCode", getPositionCode())
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
