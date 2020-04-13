package com.lnbei.sp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnbei.sp.mapper.SpOrderRefundsMapper;
import com.lnbei.sp.domain.SpOrderRefunds;
import com.lnbei.sp.service.ISpOrderRefundsService;
import com.lnbei.common.core.text.Convert;

/**
 * 退款订单 服务层实现
 * 
 * @author lnbei
 * @date 2020-02-05
 */
@Service
public class SpOrderRefundsServiceImpl implements ISpOrderRefundsService 
{
	@Autowired
	private SpOrderRefundsMapper spOrderRefundsMapper;

	/**
     * 查询退款订单信息
     * 
     * @param mid 退款订单ID
     * @return 退款订单信息
     */
    @Override
	public SpOrderRefunds selectSpOrderRefundsById(String mid)
	{
	    return spOrderRefundsMapper.selectSpOrderRefundsById(mid);
	}
	
	/**
     * 查询退款订单列表
     * 
     * @param spOrderRefunds 退款订单信息
     * @return 退款订单集合
     */
	@Override
	public List<SpOrderRefunds> selectSpOrderRefundsList(SpOrderRefunds spOrderRefunds)
	{
	    return spOrderRefundsMapper.selectSpOrderRefundsList(spOrderRefunds);
	}
	
    /**
     * 新增退款订单
     * 
     * @param spOrderRefunds 退款订单信息
     * @return 结果
     */
	@Override
	public int insertSpOrderRefunds(SpOrderRefunds spOrderRefunds)
	{
	    return spOrderRefundsMapper.insertSpOrderRefunds(spOrderRefunds);
	}
	
	/**
     * 修改退款订单
     * 
     * @param spOrderRefunds 退款订单信息
     * @return 结果
     */
	@Override
	public int updateSpOrderRefunds(SpOrderRefunds spOrderRefunds)
	{
	    return spOrderRefundsMapper.updateSpOrderRefunds(spOrderRefunds);
	}

	/**
     * 删除退款订单对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSpOrderRefundsByIds(String ids)
	{
		return spOrderRefundsMapper.deleteSpOrderRefundsByIds(Convert.toStrArray(ids));
	}
	
}
