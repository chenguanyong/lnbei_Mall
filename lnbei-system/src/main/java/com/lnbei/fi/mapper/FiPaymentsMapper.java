package com.lnbei.fi.mapper;

import com.lnbei.fi.domain.FiPayments;
import java.util.List;	

/**
 * 支付方式 数据层
 * 
 * @author lnbei
 * @date 2020-02-13
 */
public interface FiPaymentsMapper 
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
     * 删除支付方式
     * 
     * @param mid 支付方式ID
     * @return 结果
     */
	public int deleteFiPaymentsById(String mid);
	
	/**
     * 批量删除支付方式
     * 
     * @param mids 需要删除的数据ID
     * @return 结果
     */
	public int deleteFiPaymentsByIds(String[] mids);
	
}