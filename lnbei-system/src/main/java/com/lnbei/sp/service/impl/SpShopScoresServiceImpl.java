package com.lnbei.sp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnbei.sp.mapper.SpShopScoresMapper;
import com.lnbei.sp.domain.SpShopScores;
import com.lnbei.sp.service.ISpShopScoresService;
import com.lnbei.common.core.text.Convert;

/**
 * 商品评分 服务层实现
 * 
 * @author lnbei
 * @date 2020-02-05
 */
@Service
public class SpShopScoresServiceImpl implements ISpShopScoresService 
{
	@Autowired
	private SpShopScoresMapper spShopScoresMapper;

	/**
     * 查询商品评分信息
     * 
     * @param mid 商品评分ID
     * @return 商品评分信息
     */
    @Override
	public SpShopScores selectSpShopScoresById(String mid)
	{
	    return spShopScoresMapper.selectSpShopScoresById(mid);
	}
	
	/**
     * 查询商品评分列表
     * 
     * @param spShopScores 商品评分信息
     * @return 商品评分集合
     */
	@Override
	public List<SpShopScores> selectSpShopScoresList(SpShopScores spShopScores)
	{
	    return spShopScoresMapper.selectSpShopScoresList(spShopScores);
	}
	
    /**
     * 新增商品评分
     * 
     * @param spShopScores 商品评分信息
     * @return 结果
     */
	@Override
	public int insertSpShopScores(SpShopScores spShopScores)
	{
	    return spShopScoresMapper.insertSpShopScores(spShopScores);
	}
	
	/**
     * 修改商品评分
     * 
     * @param spShopScores 商品评分信息
     * @return 结果
     */
	@Override
	public int updateSpShopScores(SpShopScores spShopScores)
	{
	    return spShopScoresMapper.updateSpShopScores(spShopScores);
	}

	/**
     * 删除商品评分对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSpShopScoresByIds(String ids)
	{
		return spShopScoresMapper.deleteSpShopScoresByIds(Convert.toStrArray(ids));
	}
	
}
