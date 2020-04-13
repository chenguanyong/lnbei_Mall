package com.lnbei.sp.domain;


import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 购物车表 sp_carts
 * 
 * @author lnbei
 * @date 2020-02-05
 */
public class SpCarts extends SpBase
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private String mid;
	/**  */
	private String memberId;
	/**  */
	private String isCheck;
	/**  */
	private String goodsId;
	/**  */
	private String goodsspecId;
	/**  */
	private float cartNum;
	/**
	 * 店铺ID
	 */
	private String shopId;
	
	private SpGoods spGoods;
	
	private SpGoodsSpecs spGoodsSpecs;
	
	public SpGoods getSpGoods() {
		return spGoods;
	}

	public void setSpGoods(SpGoods spGoods) {
		this.spGoods = spGoods;
	}

	public SpGoodsSpecs getSpGoodsSpecs() {
		return spGoodsSpecs;
	}

	public void setSpGoodsSpecs(SpGoodsSpecs spGoodsSpecs) {
		this.spGoodsSpecs = spGoodsSpecs;
	}

	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public void setMid(String mid) 
	{
		this.mid = mid;
	}

	public String getMid() 
	{
		return mid;
	}
	public void setMemberId(String memberId) 
	{
		this.memberId = memberId;
	}

	public String getMemberId() 
	{
		return memberId;
	}
	public void setIsCheck(String isCheck) 
	{
		this.isCheck = isCheck;
	}

	public String getIsCheck() 
	{
		return isCheck;
	}
	public void setGoodsId(String goodsId) 
	{
		this.goodsId = goodsId;
	}

	public String getGoodsId() 
	{
		return goodsId;
	}
	public void setGoodsspecId(String goodsspecId) 
	{
		this.goodsspecId = goodsspecId;
	}

	public String getGoodsspecId() 
	{
		return goodsspecId;
	}
	public void setCartNum(float cartNum) 
	{
		this.cartNum = cartNum;
	}

	public float getCartNum() 
	{
		return cartNum;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("mid", getMid())
            .append("memberId", getMemberId())
            .append("isCheck", getIsCheck())
            .append("goodsId", getGoodsId())
            .append("goodsspecId", getGoodsspecId())
            .append("cartNum", getCartNum())
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
