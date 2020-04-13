package com.lnbei.ot.domain;


import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 轮播图位置表 ot_carousel_positions
 * 
 * @author lnbei
 * @date 2020-04-10
 */
public class OtCarouselPositions extends OtBase
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private String mid;
	/**  */
	private String positionType;
	/**  */
	private String positionName;
	/**  */
	private Integer positionWidth;
	/**  */
	private Integer positionHeight;
	/**  */
	private String positionCode;
	
	private String shopId;
	
	private  List<OtCarousel> otCarousel;
	
	public List<OtCarousel> getOtCarousel() {
		return otCarousel;
	}

	public void setOtCarousel(List<OtCarousel> otCarousel) {
		this.otCarousel = otCarousel;
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
	public void setPositionWidth(Integer positionWidth) 
	{
		this.positionWidth = positionWidth;
	}

	public Integer getPositionWidth() 
	{
		return positionWidth;
	}
	public void setPositionHeight(Integer positionHeight) 
	{
		this.positionHeight = positionHeight;
	}

	public Integer getPositionHeight() 
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

    public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
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
