package com.lnbei.sp.domain;


import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 品牌表 sp_brands
 * 
 * @author lnbei
 * @date 2020-02-05
 */
public class SpBrands extends SpBase
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private String mid;
	/**  */
	private String brandName;
	/**  */
	private String brandImg;
	/**  */
	private String brandDesc;


	public void setMid(String mid) 
	{
		this.mid = mid;
	}

	public String getMid() 
	{
		return mid;
	}
	public void setBrandName(String brandName) 
	{
		this.brandName = brandName;
	}

	public String getBrandName() 
	{
		return brandName;
	}

	public String getBrandImg() {
		return brandImg;
	}

	public void setBrandImg(String brandImg) {
		this.brandImg = brandImg;
	}

	public void setBrandDesc(String brandDesc) 
	{
		this.brandDesc = brandDesc;
	}

	public String getBrandDesc() 
	{
		return brandDesc;
	}
	

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("mid", getMid())
            .append("brandName", getBrandName())
            .append("brandLmg", getBrandImg())
            .append("brandDesc", getBrandDesc())
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
