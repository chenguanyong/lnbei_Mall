package com.lnbei.fi.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnbei.fi.mapper.FiPaymentsMapper;
import com.lnbei.fi.domain.FiPayments;
import com.lnbei.fi.service.IFiPaymentsService;
import com.lnbei.common.core.text.Convert;

/**
 * 支付方式 服务层实现
 * 
 * @author lnbei
 * @date 2020-02-13
 */
@Service
public class FiPaymentsServiceImpl implements IFiPaymentsService 
{
	@Autowired
	private FiPaymentsMapper fiPaymentsMapper;

	/**
     * 查询支付方式信息
     * 
     * @param mid 支付方式ID
     * @return 支付方式信息
     */
    @Override
	public FiPayments selectFiPaymentsById(String mid)
	{
	    return fiPaymentsMapper.selectFiPaymentsById(mid);
	}
	
	/**
     * 查询支付方式列表
     * 
     * @param fiPayments 支付方式信息
     * @return 支付方式集合
     */
	@Override
	public List<FiPayments> selectFiPaymentsList(FiPayments fiPayments)
	{
	    return fiPaymentsMapper.selectFiPaymentsList(fiPayments);
	}
	
    /**
     * 新增支付方式
     * 
     * @param fiPayments 支付方式信息
     * @return 结果
     */
	@Override
	public int insertFiPayments(FiPayments fiPayments)
	{
	    return fiPaymentsMapper.insertFiPayments(fiPayments);
	}
	
	/**
     * 修改支付方式
     * 
     * @param fiPayments 支付方式信息
     * @return 结果
     */
	@Override
	public int updateFiPayments(FiPayments fiPayments)
	{
	    return fiPaymentsMapper.updateFiPayments(fiPayments);
	}

	/**
     * 删除支付方式对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteFiPaymentsByIds(String ids)
	{
		return fiPaymentsMapper.deleteFiPaymentsByIds(Convert.toStrArray(ids));
	}
	
}
