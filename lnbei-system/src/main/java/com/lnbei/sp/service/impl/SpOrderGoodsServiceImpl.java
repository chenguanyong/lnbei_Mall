package com.lnbei.sp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnbei.sp.mapper.SpOrderGoodsMapper;
import com.lnbei.sp.domain.SpOrderGoods;
import com.lnbei.sp.service.ISpOrderGoodsService;
import com.lnbei.common.core.text.Convert;

/**
 * 订单商品 服务层实现
 * 
 * @author lnbei
 * @date 2020-02-05
 */
@Service
public class SpOrderGoodsServiceImpl implements ISpOrderGoodsService 
{
	@Autowired
	private SpOrderGoodsMapper spOrderGoodsMapper;

	/**
     * 查询订单商品信息
     * 
     * @param mid 订单商品ID
     * @return 订单商品信息
     */
    @Override
	public SpOrderGoods selectSpOrderGoodsById(String mid)
	{
	    return spOrderGoodsMapper.selectSpOrderGoodsById(mid);
	}
	
	/**
     * 查询订单商品列表
     * 
     * @param spOrderGoods 订单商品信息
     * @return 订单商品集合
     */
	@Override
	public List<SpOrderGoods> selectSpOrderGoodsList(SpOrderGoods spOrderGoods)
	{
	    return spOrderGoodsMapper.selectSpOrderGoodsList(spOrderGoods);
	}
	
    /**
     * 新增订单商品
     * 
     * @param spOrderGoods 订单商品信息
     * @return 结果
     */
	@Override
	public int insertSpOrderGoods(SpOrderGoods spOrderGoods)
	{
	    return spOrderGoodsMapper.insertSpOrderGoods(spOrderGoods);
	}
	
	/**
     * 修改订单商品
     * 
     * @param spOrderGoods 订单商品信息
     * @return 结果
     */
	@Override
	public int updateSpOrderGoods(SpOrderGoods spOrderGoods)
	{
	    return spOrderGoodsMapper.updateSpOrderGoods(spOrderGoods);
	}

	/**
     * 删除订单商品对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSpOrderGoodsByIds(String ids)
	{
		return spOrderGoodsMapper.deleteSpOrderGoodsByIds(Convert.toStrArray(ids));
	}
	
}
