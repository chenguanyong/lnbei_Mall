package com.lnbei.sp.mapper;

import com.lnbei.sp.domain.SpShopAccreds;
import java.util.List;	

/**
 * 店铺认证 数据层
 * 
 * @author lnbei
 * @date 2020-02-05
 */
public interface SpShopAccredsMapper 
{
	/**
     * 查询店铺认证信息
     * 
     * @param mid 店铺认证ID
     * @return 店铺认证信息
     */
	public SpShopAccreds selectSpShopAccredsById(String mid);
	
	/**
     * 查询店铺认证列表
     * 
     * @param spShopAccreds 店铺认证信息
     * @return 店铺认证集合
     */
	public List<SpShopAccreds> selectSpShopAccredsList(SpShopAccreds spShopAccreds);
	
	/**
     * 新增店铺认证
     * 
     * @param spShopAccreds 店铺认证信息
     * @return 结果
     */
	public int insertSpShopAccreds(SpShopAccreds spShopAccreds);
	
	/**
     * 修改店铺认证
     * 
     * @param spShopAccreds 店铺认证信息
     * @return 结果
     */
	public int updateSpShopAccreds(SpShopAccreds spShopAccreds);
	
	/**
     * 删除店铺认证
     * 
     * @param mid 店铺认证ID
     * @return 结果
     */
	public int deleteSpShopAccredsById(String mid);
	
	/**
     * 批量删除店铺认证
     * 
     * @param mids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSpShopAccredsByIds(String[] mids);
	
}