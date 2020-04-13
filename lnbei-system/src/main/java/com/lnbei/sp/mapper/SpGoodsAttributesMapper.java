package com.lnbei.sp.mapper;

import com.lnbei.sp.domain.SpGoodsAttributes;
import java.util.List;

import org.apache.ibatis.annotations.Param;	

/**
 * 商品属性 数据层
 * 
 * @author lnbei
 * @date 2020-02-05
 */
public interface SpGoodsAttributesMapper 
{
	/**
     * 查询商品属性信息
     * 
     * @param mid 商品属性ID
     * @return 商品属性信息
     */
	public SpGoodsAttributes selectSpGoodsAttributesById(String mid);
	
	/**
     * 查询商品属性列表
     * 
     * @param spGoodsAttributes 商品属性信息
     * @return 商品属性集合
     */
	public List<SpGoodsAttributes> selectSpGoodsAttributesList(SpGoodsAttributes spGoodsAttributes);
	
	/**
     * 新增商品属性
     * 
     * @param spGoodsAttributes 商品属性信息
     * @return 结果
     */
	public int insertSpGoodsAttributes(SpGoodsAttributes spGoodsAttributes);
	
	/**
     * 修改商品属性
     * 
     * @param spGoodsAttributes 商品属性信息
     * @return 结果
     */
	public int updateSpGoodsAttributes(SpGoodsAttributes spGoodsAttributes);
	
	/**
     * 删除商品属性
     * 
     * @param mid 商品属性ID
     * @return 结果
     */
	public int deleteSpGoodsAttributesById(String mid);
	
	/**
     * 批量删除商品属性
     * 
     * @param mids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSpGoodsAttributesByIds(String[] mids);
	
	public int deleteSpGoodsAttributesByShopIdAndGoodsId(@Param("shopId") String shopId, @Param("GoodsId") String goodsId );
}