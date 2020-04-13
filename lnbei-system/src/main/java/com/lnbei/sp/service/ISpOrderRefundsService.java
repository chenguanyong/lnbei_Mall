package com.lnbei.sp.service;

import com.lnbei.sp.domain.SpOrderRefunds;
import java.util.List;

/**
 * 退款订单 服务层
 * 
 * @author lnbei
 * @date 2020-02-05
 */
public interface ISpOrderRefundsService 
{
	/**
     * 查询退款订单信息
     * 
     * @param mid 退款订单ID
     * @return 退款订单信息
     */
	public SpOrderRefunds selectSpOrderRefundsById(String mid);
	
	/**
     * 查询退款订单列表
     * 
     * @param spOrderRefunds 退款订单信息
     * @return 退款订单集合
     */
	public List<SpOrderRefunds> selectSpOrderRefundsList(SpOrderRefunds spOrderRefunds);
	
	/**
     * 新增退款订单
     * 
     * @param spOrderRefunds 退款订单信息
     * @return 结果
     */
	public int insertSpOrderRefunds(SpOrderRefunds spOrderRefunds);
	
	/**
     * 修改退款订单
     * 
     * @param spOrderRefunds 退款订单信息
     * @return 结果
     */
	public int updateSpOrderRefunds(SpOrderRefunds spOrderRefunds);
		
	/**
     * 删除退款订单信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSpOrderRefundsByIds(String ids);
	
}
