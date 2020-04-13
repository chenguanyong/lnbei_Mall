package com.lnbei.sp.mapper;

import com.lnbei.sp.domain.SpShopCats;
import java.util.List;	

/**
 * 商家分类 数据层
 * 
 * @author lnbei
 * @date 2020-02-05
 */
public interface SpShopCatsMapper 
{
	/**
     * 查询商家分类信息
     * 
     * @param mid 商家分类ID
     * @return 商家分类信息
     */
	public SpShopCats selectSpShopCatsById(String mid);
	
	/**
     * 查询商家分类列表
     * 
     * @param spShopCats 商家分类信息
     * @return 商家分类集合
     */
	public List<SpShopCats> selectSpShopCatsList(SpShopCats spShopCats);
	
	/**
     * 新增商家分类
     * 
     * @param spShopCats 商家分类信息
     * @return 结果
     */
	public int insertSpShopCats(SpShopCats spShopCats);
	
	/**
     * 修改商家分类
     * 
     * @param spShopCats 商家分类信息
     * @return 结果
     */
	public int updateSpShopCats(SpShopCats spShopCats);
	
	/**
     * 删除商家分类
     * 
     * @param mid 商家分类ID
     * @return 结果
     */
	public int deleteSpShopCatsById(String mid);
	
	/**
     * 批量删除商家分类
     * 
     * @param mids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSpShopCatsByIds(String[] mids);
	/**
	 * 删除商家分类根据店铺ID
	 * @param shopId
	 * @return
	 */
	public int deleteSpShopCatsByShopId(String shopId);
}