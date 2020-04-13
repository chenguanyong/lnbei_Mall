package com.lnbei.ot.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnbei.ot.mapper.OtCarouselPositionsMapper;
import com.lnbei.ot.domain.OtCarouselPositions;
import com.lnbei.ot.service.IOtCarouselPositionsService;
import com.lnbei.common.core.text.Convert;

/**
 * 轮播图位置 服务层实现
 * 
 * @author lnbei
 * @date 2020-04-10
 */
@Service
public class OtCarouselPositionsServiceImpl implements IOtCarouselPositionsService 
{
	@Autowired
	private OtCarouselPositionsMapper otCarouselPositionsMapper;

	/**
     * 查询轮播图位置信息
     * 
     * @param mid 轮播图位置ID
     * @return 轮播图位置信息
     */
    @Override
	public OtCarouselPositions selectOtCarouselPositionsById(String mid)
	{
	    return otCarouselPositionsMapper.selectOtCarouselPositionsById(mid);
	}
	/**
     * 查询轮播图位置信息
     * 
     * @param mid 轮播图位置ID
     * @return 轮播图位置信息
     */
    @Override
	public OtCarouselPositions selectOtCarouselPositionsByPostionCode(String positionCode)
	{
	    return otCarouselPositionsMapper.selectOtCarouselPositionsByPostionCode(positionCode);
	}	
	/**
     * 查询轮播图位置列表
     * 
     * @param otCarouselPositions 轮播图位置信息
     * @return 轮播图位置集合
     */
	@Override
	public List<OtCarouselPositions> selectOtCarouselPositionsList(OtCarouselPositions otCarouselPositions)
	{
	    return otCarouselPositionsMapper.selectOtCarouselPositionsList(otCarouselPositions);
	}
	
    /**
     * 新增轮播图位置
     * 
     * @param otCarouselPositions 轮播图位置信息
     * @return 结果
     */
	@Override
	public int insertOtCarouselPositions(OtCarouselPositions otCarouselPositions)
	{
	    return otCarouselPositionsMapper.insertOtCarouselPositions(otCarouselPositions);
	}
	
	/**
     * 修改轮播图位置
     * 
     * @param otCarouselPositions 轮播图位置信息
     * @return 结果
     */
	@Override
	public int updateOtCarouselPositions(OtCarouselPositions otCarouselPositions)
	{
	    return otCarouselPositionsMapper.updateOtCarouselPositions(otCarouselPositions);
	}

	/**
     * 删除轮播图位置对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteOtCarouselPositionsByIds(String ids)
	{
		return otCarouselPositionsMapper.deleteOtCarouselPositionsByIds(Convert.toStrArray(ids));
	}
	
}
