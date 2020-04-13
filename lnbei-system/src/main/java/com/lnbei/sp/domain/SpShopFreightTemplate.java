package com.lnbei.sp.domain;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 店铺运费模板表 sp_shop_freight_template
 * 
 * @author lnbei
 * @date 2020-02-05
 */
public class SpShopFreightTemplate extends SpBase
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private String mid;
	/**  */
	private Integer shopExpressId;
	/**  */
	private String tempName;
	/** 0：全国 1：指定地区 */
	private String tempType;
	/** 省份id数组 */
	private String provinceIds;
	/** 城市id数组 */
	private String cityIds;
	/** 首件(件) */
	private Integer buyNumStart;
	/** 首件运费(元) */
	private BigDecimal buyNumStartPrice;
	/** 续件(件) */
	private Integer buyNumContinue;
	/** 续件运费(元) */
	private BigDecimal buyNumContinuePrice;
	/** 首重（kg） */
	private BigDecimal weightStart;
	/** 首重价格 */
	private BigDecimal weightStartprice;
	/** 续重（kg） */
	private BigDecimal weightContinue;
	/** 续重价格 */
	private BigDecimal weightContinueprice;
	/** 首体积量(m³) */
	private BigDecimal volumeStart;
	/** 首体积运费(元) */
	private BigDecimal volumeStartprice;
	/** 续体积量(m³) */
	private BigDecimal volumeContinue;
	/** 续体积运费(元) */
	private BigDecimal volumeContinueprice;
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
	public void setShopExpressId(Integer shopExpressId) 
	{
		this.shopExpressId = shopExpressId;
	}

	public Integer getShopExpressId() 
	{
		return shopExpressId;
	}
	public void setTempName(String tempName) 
	{
		this.tempName = tempName;
	}

	public String getTempName() 
	{
		return tempName;
	}
	public void setTempType(String tempType) 
	{
		this.tempType = tempType;
	}

	public String getTempType() 
	{
		return tempType;
	}
	public void setProvinceIds(String provinceIds) 
	{
		this.provinceIds = provinceIds;
	}

	public String getProvinceIds() 
	{
		return provinceIds;
	}
	public void setCityIds(String cityIds) 
	{
		this.cityIds = cityIds;
	}

	public String getCityIds() 
	{
		return cityIds;
	}
	public void setBuyNumStart(Integer buyNumStart) 
	{
		this.buyNumStart = buyNumStart;
	}

	public Integer getBuyNumStart() 
	{
		return buyNumStart;
	}
	public void setBuyNumStartPrice(BigDecimal buyNumStartPrice) 
	{
		this.buyNumStartPrice = buyNumStartPrice;
	}

	public BigDecimal getBuyNumStartPrice() 
	{
		return buyNumStartPrice;
	}
	public void setBuyNumContinue(Integer buyNumContinue) 
	{
		this.buyNumContinue = buyNumContinue;
	}

	public Integer getBuyNumContinue() 
	{
		return buyNumContinue;
	}
	public void setBuyNumContinuePrice(BigDecimal buyNumContinuePrice) 
	{
		this.buyNumContinuePrice = buyNumContinuePrice;
	}

	public BigDecimal getBuyNumContinuePrice() 
	{
		return buyNumContinuePrice;
	}
	public void setWeightStart(BigDecimal weightStart) 
	{
		this.weightStart = weightStart;
	}

	public BigDecimal getWeightStart() 
	{
		return weightStart;
	}
	public void setWeightStartprice(BigDecimal weightStartprice) 
	{
		this.weightStartprice = weightStartprice;
	}

	public BigDecimal getWeightStartprice() 
	{
		return weightStartprice;
	}
	public void setWeightContinue(BigDecimal weightContinue) 
	{
		this.weightContinue = weightContinue;
	}

	public BigDecimal getWeightContinue() 
	{
		return weightContinue;
	}
	public void setWeightContinueprice(BigDecimal weightContinueprice) 
	{
		this.weightContinueprice = weightContinueprice;
	}

	public BigDecimal getWeightContinueprice() 
	{
		return weightContinueprice;
	}
	public void setVolumeStart(BigDecimal volumeStart) 
	{
		this.volumeStart = volumeStart;
	}

	public BigDecimal getVolumeStart() 
	{
		return volumeStart;
	}
	public void setVolumeStartprice(BigDecimal volumeStartprice) 
	{
		this.volumeStartprice = volumeStartprice;
	}

	public BigDecimal getVolumeStartprice() 
	{
		return volumeStartprice;
	}
	public void setVolumeContinue(BigDecimal volumeContinue) 
	{
		this.volumeContinue = volumeContinue;
	}

	public BigDecimal getVolumeContinue() 
	{
		return volumeContinue;
	}
	public void setVolumeContinueprice(BigDecimal volumeContinueprice) 
	{
		this.volumeContinueprice = volumeContinueprice;
	}

	public BigDecimal getVolumeContinueprice() 
	{
		return volumeContinueprice;
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
            .append("shopExpressId", getShopExpressId())
            .append("tempName", getTempName())
            .append("tempType", getTempType())
            .append("provinceIds", getProvinceIds())
            .append("cityIds", getCityIds())
            .append("buyNumStart", getBuyNumStart())
            .append("buyNumStartPrice", getBuyNumStartPrice())
            .append("buyNumContinue", getBuyNumContinue())
            .append("buyNumContinuePrice", getBuyNumContinuePrice())
            .append("weightStart", getWeightStart())
            .append("weightStartprice", getWeightStartprice())
            .append("weightContinue", getWeightContinue())
            .append("weightContinueprice", getWeightContinueprice())
            .append("volumeStart", getVolumeStart())
            .append("volumeStartprice", getVolumeStartprice())
            .append("volumeContinue", getVolumeContinue())
            .append("volumeContinueprice", getVolumeContinueprice())
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
