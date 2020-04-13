package com.lnbei.sp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnbei.sp.mapper.SpServiceGoodsMapper;
import com.lnbei.sp.domain.SpServiceGoods;
import com.lnbei.sp.service.ISpServiceGoodsService;
import com.lnbei.common.core.text.Convert;

/**
 * 服务关系 服务层实现
 * 
 * @author lnbei
 * @date 2020-02-20
 */
@Service
public class SpServiceGoodsServiceImpl implements ISpServiceGoodsService 
{
	@Autowired
	private SpServiceGoodsMapper spServiceGoodsMapper;

	/**
     * 查询服务关系信息
     * 
     * @param mid 服务关系ID
     * @return 服务关系信息
     */
    @Override
	public SpServiceGoods selectSpServiceGoodsById(String mid)
	{
	    return spServiceGoodsMapper.selectSpServiceGoodsById(mid);
	}
	
	/**
     * 查询服务关系列表
     * 
     * @param spServiceGoods 服务关系信息
     * @return 服务关系集合
     */
	@Override
	public List<SpServiceGoods> selectSpServiceGoodsList(SpServiceGoods spServiceGoods)
	{
	    return spServiceGoodsMapper.selectSpServiceGoodsList(spServiceGoods);
	}
	
    /**
     * 新增服务关系
     * 
     * @param spServiceGoods 服务关系信息
     * @return 结果
     */
	@Override
	public int insertSpServiceGoods(SpServiceGoods spServiceGoods)
	{
	    return spServiceGoodsMapper.insertSpServiceGoods(spServiceGoods);
	}
	
	/**
     * 修改服务关系
     * 
     * @param spServiceGoods 服务关系信息
     * @return 结果
     */
	@Override
	public int updateSpServiceGoods(SpServiceGoods spServiceGoods)
	{
	    return spServiceGoodsMapper.updateSpServiceGoods(spServiceGoods);
	}

	/**
     * 删除服务关系对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSpServiceGoodsByIds(String ids)
	{
		return spServiceGoodsMapper.deleteSpServiceGoodsByIds(Convert.toStrArray(ids));
	}
	
}
