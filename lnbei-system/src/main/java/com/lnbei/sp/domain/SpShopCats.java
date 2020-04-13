package com.lnbei.sp.domain;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 商家分类表 sp_shop_cats
 * 
 * @author lnbei
 * @date 2020-02-05
 */
public class SpShopCats extends SpBase
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private String mid;
	/**  */
	private String shopId;
	/**  */
	private String parentId;

	/**  */
	private String catName;

	private List<SpShopCats> children;
	
	public List<SpShopCats> getChildren() {
		return children;
	}

	public void setChildren(List<SpShopCats> children) {
		this.children = children;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public void setMid(String mid) 
	{
		this.mid = mid;
	}

	public String getMid() 
	{
		return mid;
	}
	public void setShopId(String shopId) 
	{
		this.shopId = shopId;
	}

	public String getShopId() 
	{
		return shopId;
	}
	public void setCatName(String catName) 
	{
		this.catName = catName;
	}

	public String getCatName() 
	{
		return catName;
	}
	

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("mid", getMid())
            .append("shopId", getShopId())
            .append("parentId", getParentId())
            .append("catName", getCatName())
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
