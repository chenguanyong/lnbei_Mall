package com.lnbei.sp.mapper;

import com.lnbei.sp.domain.SpOrderServices;
import java.util.List;	

/**
 * 订单服务 数据层
 * 
 * @author lnbei
 * @date 2020-02-05
 */
public interface SpOrderServicesMapper 
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
     * 删除订单服务
     * 
     * @param mid 订单服务ID
     * @return 结果
     */
	public int deleteSpOrderServicesById(String mid);
	
	/**
     * 批量删除订单服务
     * 
     * @param mids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSpOrderServicesByIds(String[] mids);
	
}