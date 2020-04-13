package com.lnbei.sp.service;

import com.lnbei.sp.domain.SpOrderExpress;
import java.util.List;

/**
 * 订单快递 服务层
 * 
 * @author lnbei
 * @date 2020-02-05
 */
public interface ISpOrderExpressService 
{
	/**
     * 查询订单快递信息
     * 
     * @param mid 订单快递ID
     * @return 订单快递信息
     */
	public SpOrderExpress selectSpOrderExpressById(String mid);
	
	/**
     * 查询订单快递列表
     * 
     * @param spOrderExpress 订单快递信息
     * @return 订单快递集合
     */
	public List<SpOrderExpress> selectSpOrderExpressList(SpOrderExpress spOrderExpress);
	
	/**
     * 新增订单快递
     * 
     * @param spOrderExpress 订单快递信息
     * @return 结果
     */
	public int insertSpOrderExpress(SpOrderExpress spOrderExpress);
	
	/**
     * 修改订单快递
     * 
     * @param spOrderExpress 订单快递信息
     * @return 结果
     */
	public int updateSpOrderExpress(SpOrderExpress spOrderExpress);
		
	/**
     * 删除订单快递信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSpOrderExpressByIds(String ids);
	
}
