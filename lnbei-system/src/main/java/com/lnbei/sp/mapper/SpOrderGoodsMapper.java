package com.lnbei.sp.mapper;

import com.lnbei.sp.domain.SpOrderGoods;
import java.util.List;	

/**
 * 订单商品 数据层
 * 
 * @author lnbei
 * @date 2020-02-05
 */
public interface SpOrderGoodsMapper 
{
	/**
     * 查询订单商品信息
     * 
     * @param mid 订单商品ID
     * @return 订单商品信息
     */
	public SpOrderGoods selectSpOrderGoodsById(String mid);
	
	/**
     * 查询订单商品列表
     * 
     * @param spOrderGoods 订单商品信息
     * @return 订单商品集合
     */
	public List<SpOrderGoods> selectSpOrderGoodsList(SpOrderGoods spOrderGoods);
	
	/**
     * 新增订单商品
     * 
     * @param spOrderGoods 订单商品信息
     * @return 结果
     */
	public int insertSpOrderGoods(SpOrderGoods spOrderGoods);
	
	/**
     * 修改订单商品
     * 
     * @param spOrderGoods 订单商品信息
     * @return 结果
     */
	public int updateSpOrderGoods(SpOrderGoods spOrderGoods);
	
	/**
     * 删除订单商品
     * 
     * @param mid 订单商品ID
     * @return 结果
     */
	public int deleteSpOrderGoodsById(String mid);
	
	/**
     * 批量删除订单商品
     * 
     * @param mids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSpOrderGoodsByIds(String[] mids);
	
}