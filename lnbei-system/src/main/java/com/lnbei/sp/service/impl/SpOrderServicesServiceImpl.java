package com.lnbei.sp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnbei.sp.mapper.SpOrderServicesMapper;
import com.lnbei.sp.domain.SpOrderServices;
import com.lnbei.sp.service.ISpOrderServicesService;
import com.lnbei.common.core.text.Convert;

/**
 * 订单服务 服务层实现
 * 
 * @author lnbei
 * @date 2020-02-05
 */
@Service
public class SpOrderServicesServiceImpl implements ISpOrderServicesService 
{
	@Autowired
	private SpOrderServicesMapper spOrderServicesMapper;

	/**
     * 查询订单服务信息
     * 
     * @param mid 订单服务ID
     * @return 订单服务信息
     */
    @Override
	public SpOrderServices selectSpOrderServicesById(String mid)
	{
	    return spOrderServicesMapper.selectSpOrderServicesById(mid);
	}
	
	/**
     * 查询订单服务列表
     * 
     * @param spOrderServices 订单服务信息
     * @return 订单服务集合
     */
	@Override
	public List<SpOrderServices> selectSpOrderServicesList(SpOrderServices spOrderServices)
	{
	    return spOrderServicesMapper.selectSpOrderServicesList(spOrderServices);
	}
	
    /**
     * 新增订单服务
     * 
     * @param spOrderServices 订单服务信息
     * @return 结果
     */
	@Override
	public int insertSpOrderServices(SpOrderServices spOrderServices)
	{
	    return spOrderServicesMapper.insertSpOrderServices(spOrderServices);
	}
	
	/**
     * 修改订单服务
     * 
     * @param spOrderServices 订单服务信息
     * @return 结果
     */
	@Override
	public int updateSpOrderServices(SpOrderServices spOrderServices)
	{
	    return spOrderServicesMapper.updateSpOrderServices(spOrderServices);
	}

	/**
     * 删除订单服务对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSpOrderServicesByIds(String ids)
	{
		return spOrderServicesMapper.deleteSpOrderServicesByIds(Convert.toStrArray(ids));
	}
	
}
