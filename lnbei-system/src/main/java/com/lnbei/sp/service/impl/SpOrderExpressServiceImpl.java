package com.lnbei.sp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnbei.sp.mapper.SpOrderExpressMapper;
import com.lnbei.sp.domain.SpOrderExpress;
import com.lnbei.sp.service.ISpOrderExpressService;
import com.lnbei.common.core.text.Convert;

/**
 * 订单快递 服务层实现
 * 
 * @author lnbei
 * @date 2020-02-05
 */
@Service
public class SpOrderExpressServiceImpl implements ISpOrderExpressService 
{
	@Autowired
	private SpOrderExpressMapper spOrderExpressMapper;

	/**
     * 查询订单快递信息
     * 
     * @param mid 订单快递ID
     * @return 订单快递信息
     */
    @Override
	public SpOrderExpress selectSpOrderExpressById(String mid)
	{
	    return spOrderExpressMapper.selectSpOrderExpressById(mid);
	}
	
	/**
     * 查询订单快递列表
     * 
     * @param spOrderExpress 订单快递信息
     * @return 订单快递集合
     */
	@Override
	public List<SpOrderExpress> selectSpOrderExpressList(SpOrderExpress spOrderExpress)
	{
	    return spOrderExpressMapper.selectSpOrderExpressList(spOrderExpress);
	}
	
    /**
     * 新增订单快递
     * 
     * @param spOrderExpress 订单快递信息
     * @return 结果
     */
	@Override
	public int insertSpOrderExpress(SpOrderExpress spOrderExpress)
	{
	    return spOrderExpressMapper.insertSpOrderExpress(spOrderExpress);
	}
	
	/**
     * 修改订单快递
     * 
     * @param spOrderExpress 订单快递信息
     * @return 结果
     */
	@Override
	public int updateSpOrderExpress(SpOrderExpress spOrderExpress)
	{
	    return spOrderExpressMapper.updateSpOrderExpress(spOrderExpress);
	}

	/**
     * 删除订单快递对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSpOrderExpressByIds(String ids)
	{
		return spOrderExpressMapper.deleteSpOrderExpressByIds(Convert.toStrArray(ids));
	}
	
}
