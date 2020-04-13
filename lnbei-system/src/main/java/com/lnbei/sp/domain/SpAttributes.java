package com.lnbei.sp.domain;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.lnbei.sp.viewdomain.SpAttributesView;


/**
 * 商品属性表 sp_attributes
 * 
 * @author lnbei
 * @date 2020-02-05
 */
public class SpAttributes extends SpAttributesView
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private String mid;
	/**  */
	private String goodscatId;
	/**  */
	private String goodscatPath;
	/**  */
	private String attrName;
	/**  */
	private String attrType;
	/**  */
	private String attrVal;
	/**  */
	private String isShow;


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
	public void setGoodscatPath(String goodscatPath) 
	{
		this.goodscatPath = goodscatPath;
	}

	public String getGoodscatPath() 
	{
		return goodscatPath;
	}
	public void setAttrName(String attrName) 
	{
		this.attrName = attrName;
	}

	public String getAttrName() 
	{
		return attrName;
	}
	public void setAttrType(String attrType) 
	{
		this.attrType = attrType;
	}

	public String getAttrType() 
	{
		return attrType;
	}
	public void setAttrVal(String attrVal) 
	{
		this.attrVal = attrVal;
	}

	public String getAttrVal() 
	{
		return attrVal;
	}
	public void setIsShow(String isShow) 
	{
		this.isShow = isShow;
	}

	public String getIsShow() 
	{
		return isShow;
	}


    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("mid", getMid())
            .append("goodscatId", getGoodscatId())
            .append("goodscatPath", getGoodscatPath())
            .append("attrName", getAttrName())
            .append("attrType", getAttrType())
            .append("attrVal", getAttrVal())
            .append("isShow", getIsShow())
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
