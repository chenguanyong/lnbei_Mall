package com.lnbei.ot.mapper;

import com.lnbei.ot.domain.OtAdPositions;
import java.util.List;	

/**
 * 广告位置 数据层
 * 
 * @author lnbei
 * @date 2020-04-10
 */
public interface OtAdPositionsMapper 
{
	/**
     * 查询广告位置信息
     * 
     * @param mid 广告位置ID
     * @return 广告位置信息
     */
	public OtAdPositions selectOtAdPositionsById(String mid);
	
	/**
     * 查询广告位置信息
     * 
     * @param postionCode 广告位置代码
     * @return 广告位置信息
     */
	public OtAdPositions selectOtAdPositionsByPositionCode(String postionCode);
	/**
     * 查询广告位置列表
     * 
     * @param otAdPositions 广告位置信息
     * @return 广告位置集合
     */
	public List<OtAdPositions> selectOtAdPositionsList(OtAdPositions otAdPositions);
	
	/**
     * 新增广告位置
     * 
     * @param otAdPositions 广告位置信息
     * @return 结果
     */
	public int insertOtAdPositions(OtAdPositions otAdPositions);
	
	/**
     * 修改广告位置
     * 
     * @param otAdPositions 广告位置信息
     * @return 结果
     */
	public int updateOtAdPositions(OtAdPositions otAdPositions);
	
	/**
     * 删除广告位置
     * 
     * @param mid 广告位置ID
     * @return 结果
     */
	public int deleteOtAdPositionsById(String mid);
	
	/**
     * 批量删除广告位置
     * 
     * @param mids 需要删除的数据ID
     * @return 结果
     */
	public int deleteOtAdPositionsByIds(String[] mids);
	
}