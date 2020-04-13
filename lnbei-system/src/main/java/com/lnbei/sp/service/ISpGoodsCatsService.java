package com.lnbei.sp.service;

import com.lnbei.sp.domain.SpGoodsCats;
import java.util.List;

/**
 * 商品分类 服务层
 * 
 * @author lnbei
 * @date 2020-02-05
 */
public interface ISpGoodsCatsService 
{
	/**
     * 查询商品分类信息
     * 
     * @param mid 商品分类ID
     * @return 商品分类信息
     */
	public SpGoodsCats selectSpGoodsCatsById(String mid);
	
	/**
     * 查询商品分类列表
     * 
     * @param spGoodsCats 商品分类信息
     * @return 商品分类集合
     */
	public List<SpGoodsCats> selectSpGoodsCatsList(SpGoodsCats spGoodsCats);
	
	/**
     * 新增商品分类
     * 
     * @param spGoodsCats 商品分类信息
     * @return 结果
     */
	public int insertSpGoodsCats(SpGoodsCats spGoodsCats);
	
	/**
     * 修改商品分类
     * 
     * @param spGoodsCats 商品分类信息
     * @return 结果
     */
	public int updateSpGoodsCats(SpGoodsCats spGoodsCats);
		
	/**
     * 删除商品分类信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSpGoodsCatsByIds(String ids);
	/**
	 * 获取所有商品分类
	 * @return
	 */
	public List<SpGoodsCats> selectGoodsCatsAll(SpGoodsCats mGoodsCats);
}
