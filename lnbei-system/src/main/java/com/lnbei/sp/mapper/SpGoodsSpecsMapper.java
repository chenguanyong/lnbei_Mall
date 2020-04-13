package com.lnbei.sp.mapper;

import com.lnbei.sp.domain.SpGoods;
import com.lnbei.sp.domain.SpGoodsSpecs;
import java.util.List;

import org.apache.ibatis.annotations.Param;	

/**
 * 商品规格 数据层
 * 
 * @author lnbei
 * @date 2020-02-05
 */
public interface SpGoodsSpecsMapper 
{
	/**
     * 查询商品规格信息
     * 
     * @param mid 商品规格ID
     * @return 商品规格信息
     */
	public SpGoodsSpecs selectSpGoodsSpecsById(String mid);
	
	/**
     * 查询商品规格列表
     * 
     * @param spGoodsSpecs 商品规格信息
     * @return 商品规格集合
     */
	public List<SpGoodsSpecs> selectSpGoodsSpecsList(SpGoodsSpecs spGoodsSpecs);
	
	/**
     * 新增商品规格
     * 
     * @param spGoodsSpecs 商品规格信息
     * @return 结果
     */
	public int insertSpGoodsSpecs(SpGoodsSpecs spGoodsSpecs);
	
	/**
     * 修改商品规格
     * 
     * @param spGoodsSpecs 商品规格信息
     * @return 结果
     */
	public int updateSpGoodsSpecs(SpGoodsSpecs spGoodsSpecs);
	
	/**
     * 删除商品规格
     * 
     * @param mid 商品规格ID
     * @return 结果
     */
	public int deleteSpGoodsSpecsById(String mid);
	
	/**
     * 批量删除商品规格
     * 
     * @param mids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSpGoodsSpecsByIds(String[] mids);
	/**
	 * 删除商品规格根据店铺和商品ID
	 * @param shopId
	 * @param goodsId
	 * @return
	 */
	public int deleteSpGoodsSpecsByShopIdAndGoodsId(@Param("shopId") String shopId, @Param("goodsId") String goodsId);
	/**
	 * 查询商品规格
	 * @param mGoodsSpecs
	 * @return
	 */
	public SpGoodsSpecs	selectSpGoodsSpecsBySpGoodsSpecs(SpGoodsSpecs mGoodsSpecs);
	/**
	 * 修改库存+
	 * @param mGoods
	 * @return
	 */
	public int incSpGoodsSpecsStock(SpGoodsSpecs mGoodsSpecs);
	/**
	 * 修改库存-
	 * @param mGoods
	 * @return
	 */
	public int decSpGoodsSpecsStock(SpGoodsSpecs mGoodsSpecs);	
}