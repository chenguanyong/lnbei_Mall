package com.lnbei.sp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnbei.sp.mapper.SpRecommendsMapper;
import com.lnbei.sp.domain.SpRecommends;
import com.lnbei.sp.service.ISpRecommendsService;
import com.lnbei.common.core.text.Convert;

/**
 * 推荐 服务层实现
 * 
 * @author lnbei
 * @date 2020-03-31
 */
@Service
public class SpRecommendsServiceImpl implements ISpRecommendsService 
{
	@Autowired
	private SpRecommendsMapper spRecommendsMapper;

	/**
     * 查询推荐信息
     * 
     * @param mid 推荐ID
     * @return 推荐信息
     */
    @Override
	public SpRecommends selectSpRecommendsById(String mid)
	{
	    return spRecommendsMapper.selectSpRecommendsById(mid);
	}
	
	/**
     * 查询推荐列表
     * 
     * @param spRecommends 推荐信息
     * @return 推荐集合
     */
	@Override
	public List<SpRecommends> selectSpRecommendsList(SpRecommends spRecommends)
	{
	    return spRecommendsMapper.selectSpRecommendsList(spRecommends);
	}
	
    /**
     * 新增推荐
     * 
     * @param spRecommends 推荐信息
     * @return 结果
     */
	@Override
	public int insertSpRecommends(SpRecommends spRecommends)
	{
	    return spRecommendsMapper.insertSpRecommends(spRecommends);
	}
	
	/**
     * 修改推荐
     * 
     * @param spRecommends 推荐信息
     * @return 结果
     */
	@Override
	public int updateSpRecommends(SpRecommends spRecommends)
	{
	    return spRecommendsMapper.updateSpRecommends(spRecommends);
	}

	/**
     * 删除推荐对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSpRecommendsByIds(String ids)
	{
		return spRecommendsMapper.deleteSpRecommendsByIds(Convert.toStrArray(ids));
	}
	
}
