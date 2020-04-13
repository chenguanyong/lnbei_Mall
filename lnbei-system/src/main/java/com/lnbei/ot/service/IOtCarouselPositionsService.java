package com.lnbei.ot.service;

import com.lnbei.ot.domain.OtCarouselPositions;
import java.util.List;

/**
 * 轮播图位置 服务层
 * 
 * @author lnbei
 * @date 2020-04-10
 */
public interface IOtCarouselPositionsService 
{
	/**
     * 查询轮播图位置信息
     * 
     * @param mid 轮播图位置ID
     * @return 轮播图位置信息
     */
	public OtCarouselPositions selectOtCarouselPositionsById(String mid);
	
	/**
     * 查询轮播图位置列表
     * 
     * @param otCarouselPositions 轮播图位置信息
     * @return 轮播图位置集合
     */
	public List<OtCarouselPositions> selectOtCarouselPositionsList(OtCarouselPositions otCarouselPositions);
	
	/**
     * 新增轮播图位置
     * 
     * @param otCarouselPositions 轮播图位置信息
     * @return 结果
     */
	public int insertOtCarouselPositions(OtCarouselPositions otCarouselPositions);
	
	/**
     * 修改轮播图位置
     * 
     * @param otCarouselPositions 轮播图位置信息
     * @return 结果
     */
	public int updateOtCarouselPositions(OtCarouselPositions otCarouselPositions);
		
	/**
     * 删除轮播图位置信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteOtCarouselPositionsByIds(String ids);
	
	
	/**
     * 查询轮播图位置信息
     * 
     * @param mid 轮播图位置ID
     * @return 轮播图位置信息
     */
	public OtCarouselPositions selectOtCarouselPositionsByPostionCode(String positionCode);
	
}
