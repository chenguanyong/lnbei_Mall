package com.lnbei.sp.mapper;

import com.lnbei.sp.domain.SpShopExtras;
import java.util.List;	

/**
 * 商铺扩展 数据层
 * 
 * @author lnbei
 * @date 2020-02-19
 */
public interface SpShopExtrasMapper 
{
	/**
     * 查询商铺扩展信息
     * 
     * @param mid 商铺扩展ID
     * @return 商铺扩展信息
     */
	public SpShopExtras selectSpShopExtrasById(String mid);
	
	/**
     * 查询商铺扩展列表
     * 
     * @param spShopExtras 商铺扩展信息
     * @return 商铺扩展集合
     */
	public List<SpShopExtras> selectSpShopExtrasList(SpShopExtras spShopExtras);
	
	/**
     * 新增商铺扩展
     * 
     * @param spShopExtras 商铺扩展信息
     * @return 结果
     */
	public int insertSpShopExtras(SpShopExtras spShopExtras);
	
	/**
     * 修改商铺扩展
     * 
     * @param spShopExtras 商铺扩展信息
     * @return 结果
     */
	public int updateSpShopExtras(SpShopExtras spShopExtras);
	
	/**
     * 删除商铺扩展
     * 
     * @param mid 商铺扩展ID
     * @return 结果
     */
	public int deleteSpShopExtrasById(String mid);
	
	/**
     * 批量删除商铺扩展
     * 
     * @param mids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSpShopExtrasByIds(String[] mids);
	
	/**
     * 查询数据根据商铺ID
     * 
     * @param mid 商铺扩展ID
     * @return 结果
     */
	public SpShopExtras selectSpShopExtrasByShopId(String shopId);
}