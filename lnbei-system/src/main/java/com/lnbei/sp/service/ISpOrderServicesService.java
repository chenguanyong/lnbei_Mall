package com.lnbei.sp.service;

import com.lnbei.sp.domain.SpOrderServices;
import java.util.List;

/**
 * 订单服务 服务层
 * 
 * @author lnbei
 * @date 2020-02-05
 */
public interface ISpOrderServicesService 
{
	/**
     * 查询订单服务信息
     * 
     * @param mid 订单服务ID
     * @return 订单服务信息
     */
	public SpOrderServices selectSpOrderServicesById(String mid);
	
	/**
     * 查询订单服务列表
     * 
     * @param spOrderServices 订单服务信息
     * @return 订单服务集合
     */
	public List<SpOrderServices> selectSpOrderServicesList(SpOrderServices spOrderServices);
	
	/**
     * 新增订单服务
     * 
     * @param spOrderServices 订单服务信息
     * @return 结果
     */
	public int insertSpOrderServices(SpOrderServices spOrderServices);
	
	/**
     * 修改订单服务
     * 
     * @param spOrderServices 订单服务信息
     * @return 结果
     */
	public int updateSpOrderServices(SpOrderServices spOrderServices);
		
	/**
     * 删除订单服务信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSpOrderServicesByIds(String ids);
	
}
