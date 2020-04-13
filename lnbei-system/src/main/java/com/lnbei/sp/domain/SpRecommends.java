package com.lnbei.sp.domain;


import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 推荐表 sp_recommends
 * 
 * @author lnbei
 * @date 2020-03-31
 */
public class SpRecommends extends SpBase
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private String mid;
	/**  */
	private String goodscatId;
	/**  */
	private String dataType;
	/**  */
	private String dataSrc;
	/**  */
	private String dataId;

	public void setMid(String mid) 
	{
		this.mid = mid;
	}

	public String getMid() 
	{
		return mid;
	}
	public void setGoodscatId(String goodscatId) 
	{
		this.goodscatId = goodscatId;
	}

	public String getGoodscatId() 
	{
		return goodscatId;
	}
	public void setDataType(String dataType) 
	{
		this.dataType = dataType;
	}

	public String getDataType() 
	{
		return dataType;
	}
	public void setDataSrc(String dataSrc) 
	{
		this.dataSrc = dataSrc;
	}

	public String getDataSrc() 
	{
		return dataSrc;
	}
	public void setDataId(String dataId) 
	{
		this.dataId = dataId;
	}

	public String getDataId() 
	{
		return dataId;
	}


    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("mid", getMid())
            .append("goodscatId", getGoodscatId())
            .append("dataType", getDataType())
            .append("dataSrc", getDataSrc())
            .append("dataId", getDataId())
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
