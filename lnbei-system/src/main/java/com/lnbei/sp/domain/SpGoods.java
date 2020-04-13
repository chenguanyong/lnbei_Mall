package com.lnbei.sp.domain;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 商品表 sp_goods
 * 
 * @author lnbei
 * @date 2020-02-05
 */
public class SpGoods extends SpBase
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private String mid;
	/**  */
	private String goodsSn;
	/**  */
	private String productNo;
	/**  */
	private String goodsName;
	/**  */
	private String goodsImg;
	/**  */
	private String shopId;
	/**  */
	private String goodsType;
	/**  */
	private BigDecimal marketPrice;
	/**  */
	private BigDecimal shopPrice;
	/**  */
	private BigDecimal warnStock;
	/**  */
	private BigDecimal goodsStock;
	/**  */
	private String goodsUnit;
	/**  */
	private String goodsTips;
	/**  */
	private String isSale;
	/**  */
	private String isBest;
	/**  */
	private String isHot;
	/**  */
	private String isNew;
	/**  */
	private String isRecom;
	/**  */
	private String goodsCatIdPath;
	/**  */
	private String goodscatId;
	/**  */
	private String shopCatId1;
	/**  */
	private String shopCatId2;
	/**  */
	private String brandId;
	/**  */
	private String goodsDesc;
	/**  */
	private String goodsStatus;
	/**  */
	private float saleNum;
	/**  */
	private Date saleTime;
	/**  */
	private Integer visitNum;
	/**  */
	private Integer appraiseNum;
	/**  */
	private String isSpec;
	/**  */
	private String gallery;
	/**  */
	private String goodsSeoKeywords;
	/**  */
	private String illegalremarks;
	/**  */
	private String isFreeshipping;
	/**  */
	private String goodsSerachKeyWords;
	/**  */
	private String goodsVideo;
	/**  */
	private BigDecimal costPrice;
	/**  */
	private String goodsVideoThumb;
	/**  */
	private String goodsSeoDesc;
	/** 计价方式 1:计件 2:重量 3:体积 */
	private String shippingFeetype;
	/** 商品重量 */
	private BigDecimal goodsWeight;
	/** 商品体积 */
	private BigDecimal goodsVolume;
	/**  */
	private String shopexpressId;

	private SpGoodsSpecs mGoodsSpecs;
	
	private SpShops spShops;
	
	public SpShops getSpShops() {
		return spShops;
	}

	public void setSpShops(SpShops spShops) {
		this.spShops = spShops;
	}

	public SpGoodsSpecs getmGoodsSpecs() {
		return mGoodsSpecs;
	}

	public void setmGoodsSpecs(SpGoodsSpecs mGoodsSpecs) {
		this.mGoodsSpecs = mGoodsSpecs;
	}

	public void setMid(String mid) 
	{
		this.mid = mid;
	}

	public String getMid() 
	{
		return mid;
	}
	public void setGoodsSn(String goodsSn) 
	{
		this.goodsSn = goodsSn;
	}

	public String getGoodsSn() 
	{
		return goodsSn;
	}
	public void setProductNo(String productNo) 
	{
		this.productNo = productNo;
	}

	public String getProductNo() 
	{
		return productNo;
	}
	public void setGoodsName(String goodsName) 
	{
		this.goodsName = goodsName;
	}

	public String getGoodsName() 
	{
		return goodsName;
	}
	public void setGoodsImg(String goodsImg) 
	{
		this.goodsImg = goodsImg;
	}

	public String getGoodsImg() 
	{
		return goodsImg;
	}
	public void setShopId(String shopId) 
	{
		this.shopId = shopId;
	}

	public String getShopId() 
	{
		return shopId;
	}
	public void setGoodsType(String goodsType) 
	{
		this.goodsType = goodsType;
	}

	public String getGoodsType() 
	{
		return goodsType;
	}
	public void setMarketPrice(BigDecimal marketPrice) 
	{
		this.marketPrice = marketPrice;
	}

	public BigDecimal getMarketPrice() 
	{
		return marketPrice;
	}
	public void setShopPrice(BigDecimal shopPrice) 
	{
		this.shopPrice = shopPrice;
	}

	public BigDecimal getShopPrice() 
	{
		return shopPrice;
	}
	public void setWarnStock(BigDecimal warnStock) 
	{
		this.warnStock = warnStock;
	}

	public BigDecimal getWarnStock() 
	{
		return warnStock;
	}
	public void setGoodsStock(BigDecimal goodsStock) 
	{
		this.goodsStock = goodsStock;
	}

	public BigDecimal getGoodsStock() 
	{
		return goodsStock;
	}
	public void setGoodsUnit(String goodsUnit) 
	{
		this.goodsUnit = goodsUnit;
	}

	public String getGoodsUnit() 
	{
		return goodsUnit;
	}
	public void setGoodsTips(String goodsTips) 
	{
		this.goodsTips = goodsTips;
	}

	public String getGoodsTips() 
	{
		return goodsTips;
	}
	public void setIsSale(String isSale) 
	{
		this.isSale = isSale;
	}

	public String getIsSale() 
	{
		return isSale;
	}
	public void setIsBest(String isBest) 
	{
		this.isBest = isBest;
	}

	public String getIsBest() 
	{
		return isBest;
	}
	public void setIsHot(String isHot) 
	{
		this.isHot = isHot;
	}

	public String getIsHot() 
	{
		return isHot;
	}
	public void setIsNew(String isNew) 
	{
		this.isNew = isNew;
	}

	public String getIsNew() 
	{
		return isNew;
	}
	public void setIsRecom(String isRecom) 
	{
		this.isRecom = isRecom;
	}

	public String getIsRecom() 
	{
		return isRecom;
	}
	public void setGoodsCatIdPath(String goodsCatIdPath) 
	{
		this.goodsCatIdPath = goodsCatIdPath;
	}

	public String getGoodsCatIdPath() 
	{
		return goodsCatIdPath;
	}
	public void setGoodscatId(String goodscatId) 
	{
		this.goodscatId = goodscatId;
	}

	public String getGoodscatId() 
	{
		return goodscatId;
	}
	public void setShopCatId1(String shopCatId1) 
	{
		this.shopCatId1 = shopCatId1;
	}

	public String getShopCatId1() 
	{
		return shopCatId1;
	}
	public void setShopCatId2(String shopCatId2) 
	{
		this.shopCatId2 = shopCatId2;
	}

	public String getShopCatId2() 
	{
		return shopCatId2;
	}
	public void setBrandId(String brandId) 
	{
		this.brandId = brandId;
	}

	public String getBrandId() 
	{
		return brandId;
	}
	public void setGoodsDesc(String goodsDesc) 
	{
		this.goodsDesc = goodsDesc;
	}

	public String getGoodsDesc() 
	{
		return goodsDesc;
	}
	public void setGoodsStatus(String goodsStatus) 
	{
		this.goodsStatus = goodsStatus;
	}

	public String getGoodsStatus() 
	{
		return goodsStatus;
	}
	public void setSaleNum(float saleNum) 
	{
		this.saleNum = saleNum;
	}

	public float getSaleNum() 
	{
		return saleNum;
	}
	public void setSaleTime(Date saleTime) 
	{
		this.saleTime = saleTime;
	}

	public Date getSaleTime() 
	{
		return saleTime;
	}
	public void setVisitNum(Integer visitNum) 
	{
		this.visitNum = visitNum;
	}

	public Integer getVisitNum() 
	{
		return visitNum;
	}
	public void setAppraiseNum(Integer appraiseNum) 
	{
		this.appraiseNum = appraiseNum;
	}

	public Integer getAppraiseNum() 
	{
		return appraiseNum;
	}
	public void setIsSpec(String isSpec) 
	{
		this.isSpec = isSpec;
	}

	public String getIsSpec() 
	{
		return isSpec;
	}
	public void setGallery(String gallery) 
	{
		this.gallery = gallery;
	}

	public String getGallery() 
	{
		return gallery;
	}
	public void setGoodsSeoKeywords(String goodsSeoKeywords) 
	{
		this.goodsSeoKeywords = goodsSeoKeywords;
	}

	public String getGoodsSeoKeywords() 
	{
		return goodsSeoKeywords;
	}
	public void setIllegalremarks(String illegalremarks) 
	{
		this.illegalremarks = illegalremarks;
	}

	public String getIllegalremarks() 
	{
		return illegalremarks;
	}
	public void setIsFreeshipping(String isFreeshipping) 
	{
		this.isFreeshipping = isFreeshipping;
	}

	public String getIsFreeshipping() 
	{
		return isFreeshipping;
	}
	public void setGoodsSerachKeyWords(String goodsSerachKeyWords) 
	{
		this.goodsSerachKeyWords = goodsSerachKeyWords;
	}

	public String getGoodsSerachKeyWords() 
	{
		return goodsSerachKeyWords;
	}
	public void setGoodsVideo(String goodsVideo) 
	{
		this.goodsVideo = goodsVideo;
	}

	public String getGoodsVideo() 
	{
		return goodsVideo;
	}
	public void setCostPrice(BigDecimal costPrice) 
	{
		this.costPrice = costPrice;
	}

	public BigDecimal getCostPrice() 
	{
		return costPrice;
	}
	public void setGoodsVideoThumb(String goodsVideoThumb) 
	{
		this.goodsVideoThumb = goodsVideoThumb;
	}

	public String getGoodsVideoThumb() 
	{
		return goodsVideoThumb;
	}
	public void setGoodsSeoDesc(String goodsSeoDesc) 
	{
		this.goodsSeoDesc = goodsSeoDesc;
	}

	public String getGoodsSeoDesc() 
	{
		return goodsSeoDesc;
	}
	public void setShippingFeetype(String shippingFeetype) 
	{
		this.shippingFeetype = shippingFeetype;
	}

	public String getShippingFeetype() 
	{
		return shippingFeetype;
	}
	public void setGoodsWeight(BigDecimal goodsWeight) 
	{
		this.goodsWeight = goodsWeight;
	}

	public BigDecimal getGoodsWeight() 
	{
		return goodsWeight;
	}
	public void setGoodsVolume(BigDecimal goodsVolume) 
	{
		this.goodsVolume = goodsVolume;
	}

	public BigDecimal getGoodsVolume() 
	{
		return goodsVolume;
	}
	public void setShopexpressId(String shopexpressId) 
	{
		this.shopexpressId = shopexpressId;
	}

	public String getShopexpressId() 
	{
		return shopexpressId;
	}
	

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("mid", getMid())
            .append("goodsSn", getGoodsSn())
            .append("productNo", getProductNo())
            .append("goodsName", getGoodsName())
            .append("goodsImg", getGoodsImg())
            .append("shopId", getShopId())
            .append("goodsType", getGoodsType())
            .append("marketPrice", getMarketPrice())
            .append("shopPrice", getShopPrice())
            .append("warnStock", getWarnStock())
            .append("goodsStock", getGoodsStock())
            .append("goodsUnit", getGoodsUnit())
            .append("goodsTips", getGoodsTips())
            .append("isSale", getIsSale())
            .append("isBest", getIsBest())
            .append("isHot", getIsHot())
            .append("isNew", getIsNew())
            .append("isRecom", getIsRecom())
            .append("goodsCatIdPath", getGoodsCatIdPath())
            .append("goodscatId", getGoodscatId())
            .append("shopCatId1", getShopCatId1())
            .append("shopCatId2", getShopCatId2())
            .append("brandId", getBrandId())
            .append("goodsDesc", getGoodsDesc())
            .append("goodsStatus", getGoodsStatus())
            .append("saleNum", getSaleNum())
            .append("saleTime", getSaleTime())
            .append("visitNum", getVisitNum())
            .append("appraiseNum", getAppraiseNum())
            .append("isSpec", getIsSpec())
            .append("gallery", getGallery())
            .append("goodsSeoKeywords", getGoodsSeoKeywords())
            .append("illegalremarks", getIllegalremarks())
            .append("isFreeshipping", getIsFreeshipping())
            .append("goodsSerachKeyWords", getGoodsSerachKeyWords())
            .append("goodsVideo", getGoodsVideo())
            .append("costPrice", getCostPrice())
            .append("goodsVideoThumb", getGoodsVideoThumb())
            .append("goodsSeoDesc", getGoodsSeoDesc())
            .append("shippingFeetype", getShippingFeetype())
            .append("goodsWeight", getGoodsWeight())
            .append("goodsVolume", getGoodsVolume())
            .append("shopexpressId", getShopexpressId())
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
