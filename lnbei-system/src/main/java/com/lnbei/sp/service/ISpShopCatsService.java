package com.lnbei.sp.service;

import com.lnbei.sp.domain.SpGoodsCats;
import com.lnbei.sp.domain.SpShopCats;
import java.util.List;

/**
 * 商家分类 服务层
 * 
 * @author lnbei
 * @date 2020-02-05
 */
public interface ISpShopCatsService 
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
     * 删除商家分类信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSpShopCatsByIds(String ids);
	/**
	 * 删除商家分类根据店铺ID
	 * @param shopId
	 * @return
	 */
	public int deleteSpShopCatsByShopId(String shopId);
	/**
	 * 获取店铺全部分类
	 * @param shopCats
	 * @return
	 */
	public List<SpShopCats> getSpShopCatsAllList(SpShopCats shopCats);
}
