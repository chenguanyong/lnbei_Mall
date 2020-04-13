package com.lnbei.sp.mapper;

import com.lnbei.sp.domain.SpGoodsScores;
import java.util.List;	

/**
 * 商品评分 数据层
 * 
 * @author lnbei
 * @date 2020-03-09
 */
public interface SpGoodsScoresMapper 
{
	/**
     * 查询商品评分信息
     * 
     * @param mid 商品评分ID
     * @return 商品评分信息
     */
	public SpGoodsScores selectSpGoodsScoresById(String mid);
	
	/**
     * 查询商品评分列表
     * 
     * @param spGoodsScores 商品评分信息
     * @return 商品评分集合
     */
	public List<SpGoodsScores> selectSpGoodsScoresList(SpGoodsScores spGoodsScores);
	
	/**
     * 新增商品评分
     * 
     * @param spGoodsScores 商品评分信息
     * @return 结果
     */
	public int insertSpGoodsScores(SpGoodsScores spGoodsScores);
	
	/**
     * 修改商品评分
     * 
     * @param spGoodsScores 商品评分信息
     * @return 结果
     */
	public int updateSpGoodsScores(SpGoodsScores spGoodsScores);
	
	/**
     * 删除商品评分
     * 
     * @param mid 商品评分ID
     * @return 结果
     */
	public int deleteSpGoodsScoresById(String mid);
	
	/**
     * 批量删除商品评分
     * 
     * @param mids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSpGoodsScoresByIds(String[] mids);
	
}