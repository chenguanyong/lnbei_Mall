package com.lnbei.fi.service;

import com.lnbei.fi.domain.FiPayments;
import java.util.List;

/**
 * 支付方式 服务层
 * 
 * @author lnbei
 * @date 2020-02-13
 */
public interface IFiPaymentsService 
{
	/**
     * 查询支付方式信息
     * 
     * @param mid 支付方式ID
     * @return 支付方式信息
     */
	public FiPayments selectFiPaymentsById(String mid);
	
	/**
     * 查询支付方式列表
     * 
     * @param fiPayments 支付方式信息
     * @return 支付方式集合
     */
	public List<FiPayments> selectFiPaymentsList(FiPayments fiPayments);
	
	/**
     * 新增支付方式
     * 
     * @param fiPayments 支付方式信息
     * @return 结果
     */
	public int insertFiPayments(FiPayments fiPayments);
	
	/**
     * 修改支付方式
     * 
     * @param fiPayments 支付方式信息
     * @return 结果
     */
	public int updateFiPayments(FiPayments fiPayments);
		
	/**
     * 删除支付方式信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteFiPaymentsByIds(String ids);
	
}
