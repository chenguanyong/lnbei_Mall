package com.lnbei.ot.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnbei.ot.mapper.OtAdsMapper;
import com.lnbei.ot.domain.OtAds;
import com.lnbei.ot.service.IOtAdsService;
import com.lnbei.common.core.text.Convert;

/**
 * 广告 服务层实现
 * 
 * @author lnbei
 * @date 2020-04-10
 */
@Service
public class OtAdsServiceImpl implements IOtAdsService 
{
	@Autowired
	private OtAdsMapper otAdsMapper;

	/**
     * 查询广告信息
     * 
     * @param mid 广告ID
     * @return 广告信息
     */
    @Override
	public OtAds selectOtAdsById(String mid)
	{
	    return otAdsMapper.selectOtAdsById(mid);
	}
	
	/**
     * 查询广告列表
     * 
     * @param otAds 广告信息
     * @return 广告集合
     */
	@Override
	public List<OtAds> selectOtAdsList(OtAds otAds)
	{
	    return otAdsMapper.selectOtAdsList(otAds);
	}
	
    /**
     * 新增广告
     * 
     * @param otAds 广告信息
     * @return 结果
     */
	@Override
	public int insertOtAds(OtAds otAds)
	{
	    return otAdsMapper.insertOtAds(otAds);
	}
	
	/**
     * 修改广告
     * 
     * @param otAds 广告信息
     * @return 结果
     */
	@Override
	public int updateOtAds(OtAds otAds)
	{
	    return otAdsMapper.updateOtAds(otAds);
	}

	/**
     * 删除广告对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteOtAdsByIds(String ids)
	{
		return otAdsMapper.deleteOtAdsByIds(Convert.toStrArray(ids));
	}
	
}
