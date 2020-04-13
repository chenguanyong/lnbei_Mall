package com.lnbei.ot.mapper;

import com.lnbei.ot.domain.OtAds;
import java.util.List;	

/**
 * 广告 数据层
 * 
 * @author lnbei
 * @date 2020-04-10
 */
public interface OtAdsMapper 
{
	/**
     * 查询广告信息
     * 
     * @param mid 广告ID
     * @return 广告信息
     */
	public OtAds selectOtAdsById(String mid);
	
	/**
     * 查询广告列表
     * 
     * @param otAds 广告信息
     * @return 广告集合
     */
	public List<OtAds> selectOtAdsList(OtAds otAds);
	
	/**
     * 新增广告
     * 
     * @param otAds 广告信息
     * @return 结果
     */
	public int insertOtAds(OtAds otAds);
	
	/**
     * 修改广告
     * 
     * @param otAds 广告信息
     * @return 结果
     */
	public int updateOtAds(OtAds otAds);
	
	/**
     * 删除广告
     * 
     * @param mid 广告ID
     * @return 结果
     */
	public int deleteOtAdsById(String mid);
	
	/**
     * 批量删除广告
     * 
     * @param mids 需要删除的数据ID
     * @return 结果
     */
	public int deleteOtAdsByIds(String[] mids);
	
}