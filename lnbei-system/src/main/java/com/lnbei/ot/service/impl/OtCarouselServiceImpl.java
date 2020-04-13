package com.lnbei.ot.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnbei.ot.mapper.OtCarouselMapper;
import com.lnbei.ot.domain.OtCarousel;
import com.lnbei.ot.service.IOtCarouselService;
import com.lnbei.common.core.text.Convert;

/**
 * 轮播图 服务层实现
 * 
 * @author lnbei
 * @date 2020-04-10
 */
@Service
public class OtCarouselServiceImpl implements IOtCarouselService 
{
	@Autowired
	private OtCarouselMapper otCarouselMapper;

	/**
     * 查询轮播图信息
     * 
     * @param mid 轮播图ID
     * @return 轮播图信息
     */
    @Override
	public OtCarousel selectOtCarouselById(String mid)
	{
	    return otCarouselMapper.selectOtCarouselById(mid);
	}
	
	/**
     * 查询轮播图列表
     * 
     * @param otCarousel 轮播图信息
     * @return 轮播图集合
     */
	@Override
	public List<OtCarousel> selectOtCarouselList(OtCarousel otCarousel)
	{
	    return otCarouselMapper.selectOtCarouselList(otCarousel);
	}
	
    /**
     * 新增轮播图
     * 
     * @param otCarousel 轮播图信息
     * @return 结果
     */
	@Override
	public int insertOtCarousel(OtCarousel otCarousel)
	{
	    return otCarouselMapper.insertOtCarousel(otCarousel);
	}
	
	/**
     * 修改轮播图
     * 
     * @param otCarousel 轮播图信息
     * @return 结果
     */
	@Override
	public int updateOtCarousel(OtCarousel otCarousel)
	{
	    return otCarouselMapper.updateOtCarousel(otCarousel);
	}

	/**
     * 删除轮播图对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteOtCarouselByIds(String ids)
	{
		return otCarouselMapper.deleteOtCarouselByIds(Convert.toStrArray(ids));
	}
	
}
