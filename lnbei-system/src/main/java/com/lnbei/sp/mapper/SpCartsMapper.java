package com.lnbei.sp.mapper;

import com.lnbei.sp.domain.SpCarts;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;	

/**
 * 购物车 数据层
 * 
 * @author lnbei
 * @date 2020-02-05
 */
public interface SpCartsMapper 
{
	/**
     * 查询购物车信息
     * 
     * @param mid 购物车ID
     * @return 购物车信息
     */
	public SpCarts selectSpCartsById(String mid);
	
	/**
     * 查询购物车列表
     * 
     * @param spCarts 购物车信息
     * @return 购物车集合
     */
	public List<SpCarts> selectSpCartsList(SpCarts spCarts);
	
	/**
     * 新增购物车
     * 
     * @param spCarts 购物车信息
     * @return 结果
     */
	public int insertSpCarts(SpCarts spCarts);
	
	/**
     * 修改购物车
     * 
     * @param spCarts 购物车信息
     * @return 结果
     */
	public int updateSpCarts(SpCarts spCarts);
	
	/**
     * 删除购物车
     * 
     * @param mid 购物车ID
     * @return 结果
     */
	public int deleteSpCartsById(String mid);
	
	/**
     * 批量删除购物车
     * 
     * @param mids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSpCartsByIds(String[] mids);
	/**
	 * 选中购物车商品
	 * @return
	 */
	public int checkedGoods(@PathVariable("isCheck") String isCheck, @PathVariable("mids") String [] mids);
	/**
	 * 查询购物车信息
	 * @param mCarts
	 * @return
	 */
	public SpCarts selectSpCartsBySpCarts(SpCarts mCarts);  
	/**
	 * 查询购物车商品列表
	 * @param mSpCarts
	 * @return
	 */
	public List<SpCarts> selectSpCartsGoodsList(SpCarts mSpCarts);
	/**
	 * 查询购物车商品
	 * @param mid
	 * @return
	 */
	public SpCarts selectSpCartsGoodsById(String mid);
	/**
	 * 删除购物车中数据
	 * @param mCarts
	 * @return
	 */
	public int deleteSpCartsBySpCart(SpCarts mCarts);
	
}