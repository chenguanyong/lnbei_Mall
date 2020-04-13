package com.lnbei.sp.service;

import com.lnbei.sp.domain.SpShopScores;
import java.util.List;

/**
 * 商品评分 服务层
 * 
 * @author lnbei
 * @date 2020-02-05
 */
public interface ISpShopScoresService 
{
	/**
     * 查询商品评分信息
     * 
     * @param mid 商品评分ID
     * @return 商品评分信息
     */
	public SpShopScores selectSpShopScoresById(String mid);
	
	/**
     * 查询商品评分列表
     * 
     * @param spShopScores 商品评分信息
     * @return 商品评分集合
     */
	public List<SpShopScores> selectSpShopScoresList(SpShopScores spShopScores);
	
	/**
     * 新增商品评分
     * 
     * @param spShopScores 商品评分信息
     * @return 结果
     */
	public int insertSpShopScores(SpShopScores spShopScores);
	
	/**
     * 修改商品评分
     * 
     * @param spShopScores 商品评分信息
     * @return 结果
     */
	public int updateSpShopScores(SpShopScores spShopScores);
		
	/**
     * 删除商品评分信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSpShopScoresByIds(String ids);
	
}
