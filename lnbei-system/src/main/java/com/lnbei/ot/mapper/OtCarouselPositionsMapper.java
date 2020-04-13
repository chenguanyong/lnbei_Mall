package com.lnbei.ot.mapper;

import com.lnbei.ot.domain.OtCarouselPositions;
import java.util.List;	

/**
 * 轮播图位置 数据层
 * 
 * @author lnbei
 * @date 2020-04-10
 */
public interface OtCarouselPositionsMapper 
{
	/**
     * 查询轮播图位置信息
     * 
     * @param mid 轮播图位置ID
     * @return 轮播图位置信息
     */
	public OtCarouselPositions selectOtCarouselPositionsById(String mid);
	
	/**
     * 查询轮播图位置信息
     * 
     * @param mid 轮播图位置ID
     * @return 轮播图位置信息
     */
	public OtCarouselPositions selectOtCarouselPositionsByPostionCode(String positionCode);
	
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
     * 删除轮播图位置
     * 
     * @param mid 轮播图位置ID
     * @return 结果
     */
	public int deleteOtCarouselPositionsById(String mid);
	
	/**
     * 批量删除轮播图位置
     * 
     * @param mids 需要删除的数据ID
     * @return 结果
     */
	public int deleteOtCarouselPositionsByIds(String[] mids);
	
}