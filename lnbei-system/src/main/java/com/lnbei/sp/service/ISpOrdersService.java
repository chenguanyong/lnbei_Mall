package com.lnbei.sp.service;

import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.member.domain.MemberUser;
import com.lnbei.sp.domain.SpOrders;
import java.util.List;

/**
 * 订单 服务层
 * 
 * @author lnbei
 * @date 2020-02-05
 */
public interface ISpOrdersService 
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
     * 删除订单信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSpOrdersByIds(String ids);
	/**
	 * 创建订单
	 * @return
	 */
	public AjaxResult buildOrder(SpOrders mOrders, MemberUser memberUser)  throws Exception;
	
}
