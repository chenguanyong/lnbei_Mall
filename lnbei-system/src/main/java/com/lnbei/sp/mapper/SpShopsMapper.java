package com.lnbei.sp.mapper;

import com.lnbei.sp.domain.SpShops;
import java.util.List;	

/**
 * 店铺 数据层
 * 
 * @author lnbei
 * @date 2020-02-05
 */
public interface SpShopsMapper 
{
	/**
     * 查询店铺信息
     * 
     * @param mid 店铺ID
     * @return 店铺信息
     */
	public SpShops selectSpShopsById(String mid);
	
	/**
     * 查询店铺列表
     * 
     * @param spShops 店铺信息
     * @return 店铺集合
     */
	public List<SpShops> selectSpShopsList(SpShops spShops);
	
	/**
     * 新增店铺
     * 
     * @param spShops 店铺信息
     * @return 结果
     */
	public int insertSpShops(SpShops spShops);
	
	/**
     * 修改店铺
     * 
     * @param spShops 店铺信息
     * @return 结果
     */
	public int updateSpShops(SpShops spShops);
	
	/**
     * 删除店铺
     * 
     * @param mid 店铺ID
     * @return 结果
     */
	public int deleteSpShopsById(String mid);
	
	/**
     * 批量删除店铺
     * 
     * @param mids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSpShopsByIds(String[] mids);
	
}