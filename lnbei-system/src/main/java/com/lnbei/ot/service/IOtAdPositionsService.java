package com.lnbei.ot.service;

import com.lnbei.ot.domain.OtAdPositions;
import java.util.List;

/**
 * 广告位置 服务层
 * 
 * @author lnbei
 * @date 2020-04-10
 */
public interface IOtAdPositionsService 
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
     * 删除广告位置信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteOtAdPositionsByIds(String ids);
	
}
