package com.lnbei.sp.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.lnbei.system.domain.SysMenu;

/**
 * 商品分类表 sp_goods_cats
 * 
 * @author lnbei
 * @date 2020-02-05
 */
public class SpGoodsCats extends SpBase
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private String mid;
	/**  */
	private String parentId;
	/**  */
	private String catName;
	/**  */
	private String isShow;
	/**  */
	private String isFloor;
	/**  */
	private Integer catSort;
	/**  */
	private String dataFlag;
	/**  */
	private float commissionRate;
	/**  */
	private String catImg;
	/** 楼层副标题 */
	private String subTitle;
	/**  */
	private String simpleName;
	/** 分类seo标题 */
	private String seoTitle;
	/** 分类seo关键字 */
	private String seoKeywords;
	/** 分类seo描述 */
	private String seoDes;
	/** 商品分类列表风格 */
	private String catlistTheme;
	/** 商品详情风格 */
	private String detailTheme;
	/** 移动端商品分类列表风格 */
	private String mobileCatListTheme;
	/** 移动端商品详情风格 */
	private String mobileDetailTheme;
	/** 微信端商品分类列表风格 */
	private String wechatCatListTheme;
	/** 微信端商品详情风格 */
	private String wechatDetailTheme;
	/** 显示方式 0:卡片 1:列表 */
	private String showway;
    /** 子菜单 */
    private List<SpGoodsCats> children;
    
    private List<SpGoods> spGoodsList;
    
	public List<SpGoods> getSpGoodsList() {
		return spGoodsList;
	}

	public void setSpGoodsList(List<SpGoods> spGoodsList) {
		this.spGoodsList = spGoodsList;
	}

	public List<SpGoodsCats> getChildren() {
		return children;
	}

	public void setChildren(List<SpGoodsCats> children) {
		this.children = children;
	}

	public void setMid(String mid) 
	{
		this.mid = mid;
	}

	public String getMid() 
	{
		return mid;
	}
	public void setParentId(String parentId) 
	{
		this.parentId = parentId;
	}

	public String getParentId() 
	{
		return parentId;
	}
	public void setCatName(String catName) 
	{
		this.catName = catName;
	}

	public String getCatName() 
	{
		return catName;
	}
	public void setIsShow(String isShow) 
	{
		this.isShow = isShow;
	}

	public String getIsShow() 
	{
		return isShow;
	}
	public void setIsFloor(String isFloor) 
	{
		this.isFloor = isFloor;
	}

	public String getIsFloor() 
	{
		return isFloor;
	}
	public void setCatSort(Integer catSort) 
	{
		this.catSort = catSort;
	}

	public Integer getCatSort() 
	{
		return catSort;
	}
	public void setDataFlag(String dataFlag) 
	{
		this.dataFlag = dataFlag;
	}

	public String getDataFlag() 
	{
		return dataFlag;
	}
	public void setCommissionRate(float commissionRate) 
	{
		this.commissionRate = commissionRate;
	}

	public float getCommissionRate() 
	{
		return commissionRate;
	}
	public void setCatImg(String catImg) 
	{
		this.catImg = catImg;
	}

	public String getCatImg() 
	{
		return catImg;
	}
	public void setSubTitle(String subTitle) 
	{
		this.subTitle = subTitle;
	}

	public String getSubTitle() 
	{
		return subTitle;
	}
	public void setSimpleName(String simpleName) 
	{
		this.simpleName = simpleName;
	}

	public String getSimpleName() 
	{
		return simpleName;
	}
	public void setSeoTitle(String seoTitle) 
	{
		this.seoTitle = seoTitle;
	}

	public String getSeoTitle() 
	{
		return seoTitle;
	}
	public void setSeoKeywords(String seoKeywords) 
	{
		this.seoKeywords = seoKeywords;
	}

	public String getSeoKeywords() 
	{
		return seoKeywords;
	}
	public void setSeoDes(String seoDes) 
	{
		this.seoDes = seoDes;
	}

	public String getSeoDes() 
	{
		return seoDes;
	}
	public void setCatlistTheme(String catlistTheme) 
	{
		this.catlistTheme = catlistTheme;
	}

	public String getCatlistTheme() 
	{
		return catlistTheme;
	}
	public void setDetailTheme(String detailTheme) 
	{
		this.detailTheme = detailTheme;
	}

	public String getDetailTheme() 
	{
		return detailTheme;
	}
	public void setMobileCatListTheme(String mobileCatListTheme) 
	{
		this.mobileCatListTheme = mobileCatListTheme;
	}

	public String getMobileCatListTheme() 
	{
		return mobileCatListTheme;
	}
	public void setMobileDetailTheme(String mobileDetailTheme) 
	{
		this.mobileDetailTheme = mobileDetailTheme;
	}

	public String getMobileDetailTheme() 
	{
		return mobileDetailTheme;
	}
	public void setWechatCatListTheme(String wechatCatListTheme) 
	{
		this.wechatCatListTheme = wechatCatListTheme;
	}

	public String getWechatCatListTheme() 
	{
		return wechatCatListTheme;
	}
	public void setWechatDetailTheme(String wechatDetailTheme) 
	{
		this.wechatDetailTheme = wechatDetailTheme;
	}

	public String getWechatDetailTheme() 
	{
		return wechatDetailTheme;
	}
	public void setShowway(String showway) 
	{
		this.showway = showway;
	}

	public String getShowway() 
	{
		return showway;
	}


    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("mid", getMid())
            .append("parentId", getParentId())
            .append("catName", getCatName())
            .append("isShow", getIsShow())
            .append("isFloor", getIsFloor())
            .append("catSort", getCatSort())
            .append("dataFlag", getDataFlag())
            .append("commissionRate", getCommissionRate())
            .append("catImg", getCatImg())
            .append("subTitle", getSubTitle())
            .append("simpleName", getSimpleName())
            .append("seoTitle", getSeoTitle())
            .append("seoKeywords", getSeoKeywords())
            .append("seoDes", getSeoDes())
            .append("catlistTheme", getCatlistTheme())
            .append("detailTheme", getDetailTheme())
            .append("mobileCatListTheme", getMobileCatListTheme())
            .append("mobileDetailTheme", getMobileDetailTheme())
            .append("wechatCatListTheme", getWechatCatListTheme())
            .append("wechatDetailTheme", getWechatDetailTheme())
            .append("showway", getShowway())
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
