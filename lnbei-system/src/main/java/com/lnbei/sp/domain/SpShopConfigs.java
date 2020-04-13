package com.lnbei.sp.domain;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 商家配置表 sp_shop_configs
 * 
 * @author lnbei
 * @date 2020-02-05
 */
public class SpShopConfigs extends SpBase
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private String mid;
	/**  */
	private String shopId;
	/**  */
	private String shopTitle;
	/**  */
	private String shopKeywords;
	/**  */
	private String shopDesc;
	/**  */
	private String shopBanner;
	/**  */
	private String shopAds;
	/**  */
	private String shopAdsurl;
	/**  */
	private String shopServicer;
	/**  */
	private String shopHotWords;
	/** 店铺街背景 */
	private String shopStreetImg;
	/**  */
	private String shopMoveBanner;
	/** 店铺风格 */
	private String shopHomeTheme;
	/** 手机端店铺风格 */
	private String mobileShopHomeTheme;
	/** 微信端店铺风格 */
	private String wechatShopHomeTheme;


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
	public void setShopTitle(String shopTitle) 
	{
		this.shopTitle = shopTitle;
	}

	public String getShopTitle() 
	{
		return shopTitle;
	}
	public void setShopKeywords(String shopKeywords) 
	{
		this.shopKeywords = shopKeywords;
	}

	public String getShopKeywords() 
	{
		return shopKeywords;
	}
	public void setShopDesc(String shopDesc) 
	{
		this.shopDesc = shopDesc;
	}

	public String getShopDesc() 
	{
		return shopDesc;
	}
	public void setShopBanner(String shopBanner) 
	{
		this.shopBanner = shopBanner;
	}

	public String getShopBanner() 
	{
		return shopBanner;
	}
	public void setShopAds(String shopAds) 
	{
		this.shopAds = shopAds;
	}

	public String getShopAds() 
	{
		return shopAds;
	}
	public void setShopAdsurl(String shopAdsurl) 
	{
		this.shopAdsurl = shopAdsurl;
	}

	public String getShopAdsurl() 
	{
		return shopAdsurl;
	}
	public void setShopServicer(String shopServicer) 
	{
		this.shopServicer = shopServicer;
	}

	public String getShopServicer() 
	{
		return shopServicer;
	}
	public void setShopHotWords(String shopHotWords) 
	{
		this.shopHotWords = shopHotWords;
	}

	public String getShopHotWords() 
	{
		return shopHotWords;
	}
	public void setShopStreetImg(String shopStreetImg) 
	{
		this.shopStreetImg = shopStreetImg;
	}

	public String getShopStreetImg() 
	{
		return shopStreetImg;
	}
	public void setShopMoveBanner(String shopMoveBanner) 
	{
		this.shopMoveBanner = shopMoveBanner;
	}

	public String getShopMoveBanner() 
	{
		return shopMoveBanner;
	}
	public void setShopHomeTheme(String shopHomeTheme) 
	{
		this.shopHomeTheme = shopHomeTheme;
	}

	public String getShopHomeTheme() 
	{
		return shopHomeTheme;
	}
	public void setMobileShopHomeTheme(String mobileShopHomeTheme) 
	{
		this.mobileShopHomeTheme = mobileShopHomeTheme;
	}

	public String getMobileShopHomeTheme() 
	{
		return mobileShopHomeTheme;
	}
	public void setWechatShopHomeTheme(String wechatShopHomeTheme) 
	{
		this.wechatShopHomeTheme = wechatShopHomeTheme;
	}

	public String getWechatShopHomeTheme() 
	{
		return wechatShopHomeTheme;
	}


    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("mid", getMid())
            .append("shopId", getShopId())
            .append("shopTitle", getShopTitle())
            .append("shopKeywords", getShopKeywords())
            .append("shopDesc", getShopDesc())
            .append("shopBanner", getShopBanner())
            .append("shopAds", getShopAds())
            .append("shopAdsurl", getShopAdsurl())
            .append("shopServicer", getShopServicer())
            .append("shopHotWords", getShopHotWords())
            .append("shopStreetImg", getShopStreetImg())
            .append("shopMoveBanner", getShopMoveBanner())
            .append("shopHomeTheme", getShopHomeTheme())
            .append("mobileShopHomeTheme", getMobileShopHomeTheme())
            .append("wechatShopHomeTheme", getWechatShopHomeTheme())
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
