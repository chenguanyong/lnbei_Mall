package com.lnbei.sp.service;

import com.lnbei.sp.domain.SpGoodsSpecs;
import java.util.List;

/**
 * 商品规格 服务层
 * 
 * @author lnbei
 * @date 2020-02-05
 */
public interface ISpGoodsSpecsService 
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
     * 删除商品规格信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSpGoodsSpecsByIds(String ids);
	
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
