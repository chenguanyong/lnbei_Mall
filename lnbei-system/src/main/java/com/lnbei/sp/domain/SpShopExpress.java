package com.lnbei.sp.domain;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 商家快递表 sp_shop_express
 * 
 * @author lnbei
 * @date 2020-02-05
 */
public class SpShopExpress extends SpBase
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private String mid;
	/**  */
	private String expressId;
	/**  */
	private String isEnable;
	/**  */
	private String isDefault;
	/**  */
	private String shopId;


	public void setMid(String mid) 
	{
		this.mid = mid;
	}

	public String getMid() 
	{
		return mid;
	}
	public void setExpressId(String expressId) 
	{
		this.expressId = expressId;
	}

	public String getExpressId() 
	{
		return expressId;
	}
	public void setIsEnable(String isEnable) 
	{
		this.isEnable = isEnable;
	}

	public String getIsEnable() 
	{
		return isEnable;
	}
	public void setIsDefault(String isDefault) 
	{
		this.isDefault = isDefault;
	}

	public String getIsDefault() 
	{
		return isDefault;
	}
	public void setShopId(String shopId) 
	{
		this.shopId = shopId;
	}

	public String getShopId() 
	{
		return shopId;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("mid", getMid())
            .append("expressId", getExpressId())
            .append("isEnable", getIsEnable())
            .append("isDefault", getIsDefault())
            .append("shopId", getShopId())
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
