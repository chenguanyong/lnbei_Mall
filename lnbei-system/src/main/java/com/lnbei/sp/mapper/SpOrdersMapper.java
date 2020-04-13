package com.lnbei.sp.mapper;

import com.lnbei.sp.domain.SpOrders;
import java.util.List;	

/**
 * 订单 数据层
 * 
 * @author lnbei
 * @date 2020-02-05
 */
public interface SpOrdersMapper 
{
	/**
     * 查询订单信息
     * 
     * @param mid 订单ID
     * @return 订单信息
     */
	public SpOrders selectSpOrdersById(String mid);
	
	/**
     * 查询订单列表
     * 
     * @param spOrders 订单信息
     * @return 订单集合
     */
	public List<SpOrders> selectSpOrdersList(SpOrders spOrders);
	
	/**
     * 新增订单
     * 
     * @param spOrders 订单信息
     * @return 结果
     */
	public int insertSpOrders(SpOrders spOrders);
	
	/**
     * 修改订单
     * 
     * @param spOrders 订单信息
     * @return 结果
     */
	public int updateSpOrders(SpOrders spOrders);
	
	/**
     * 删除订单
     * 
     * @param mid 订单ID
     * @return 结果
     */
	public int deleteSpOrdersById(String mid);
	
	/**
     * 批量删除订单
     * 
     * @param mids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSpOrdersByIds(String[] mids);
	
}