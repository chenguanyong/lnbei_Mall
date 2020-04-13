package com.lnbei.sp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnbei.sp.mapper.SpGoodsScoresMapper;
import com.lnbei.sp.domain.SpGoodsScores;
import com.lnbei.sp.service.ISpGoodsScoresService;
import com.lnbei.common.core.text.Convert;

/**
 * 商品评分 服务层实现
 * 
 * @author lnbei
 * @date 2020-03-09
 */
@Service
public class SpGoodsScoresServiceImpl implements ISpGoodsScoresService 
{
	@Autowired
	private SpGoodsScoresMapper spGoodsScoresMapper;

	/**
     * 查询商品评分信息
     * 
     * @param mid 商品评分ID
     * @return 商品评分信息
     */
    @Override
	public SpGoodsScores selectSpGoodsScoresById(String mid)
	{
	    return spGoodsScoresMapper.selectSpGoodsScoresById(mid);
	}
	
	/**
     * 查询商品评分列表
     * 
     * @param spGoodsScores 商品评分信息
     * @return 商品评分集合
     */
	@Override
	public List<SpGoodsScores> selectSpGoodsScoresList(SpGoodsScores spGoodsScores)
	{
	    return spGoodsScoresMapper.selectSpGoodsScoresList(spGoodsScores);
	}
	
    /**
     * 新增商品评分
     * 
     * @param spGoodsScores 商品评分信息
     * @return 结果
     */
	@Override
	public int insertSpGoodsScores(SpGoodsScores spGoodsScores)
	{
	    return spGoodsScoresMapper.insertSpGoodsScores(spGoodsScores);
	}
	
	/**
     * 修改商品评分
     * 
     * @param spGoodsScores 商品评分信息
     * @return 结果
     */
	@Override
	public int updateSpGoodsScores(SpGoodsScores spGoodsScores)
	{
	    return spGoodsScoresMapper.updateSpGoodsScores(spGoodsScores);
	}

	/**
     * 删除商品评分对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSpGoodsScoresByIds(String ids)
	{
		return spGoodsScoresMapper.deleteSpGoodsScoresByIds(Convert.toStrArray(ids));
	}
	
}
