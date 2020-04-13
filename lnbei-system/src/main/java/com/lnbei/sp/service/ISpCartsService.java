package com.lnbei.sp.service;

import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.sp.domain.SpCarts;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

/**
 * 购物车 服务层
 * 
 * @author lnbei
 * @date 2020-02-05
 */
public interface ISpCartsService 
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
     * 删除购物车信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSpCartsByIds(String ids);
	/**
	 * 选中购物车商品
	 * @param isCheck
	 * @param mids
	 * @return
	 */
	public int checkedGoods(String isCheck, String [] mids);
	/**
	 * 添加购物车7
	 * @param spCarts
	 * @return
	 */
	public AjaxResult addCart(SpCarts spCarts);
	
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
	 * 删除购物车商品
	 * @param mCarts
	 * @return
	 */
	public int deleteSpCartsBySpCart(SpCarts mCarts);
}
