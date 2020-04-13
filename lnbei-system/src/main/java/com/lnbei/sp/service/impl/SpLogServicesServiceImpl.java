package com.lnbei.sp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnbei.sp.mapper.SpLogServicesMapper;
import com.lnbei.sp.domain.SpLogServices;
import com.lnbei.sp.service.ISpLogServicesService;
import com.lnbei.common.core.text.Convert;

/**
 * 售后服务ID 服务层实现
 * 
 * @author lnbei
 * @date 2020-03-23
 */
@Service
public class SpLogServicesServiceImpl implements ISpLogServicesService 
{
	@Autowired
	private SpLogServicesMapper spLogServicesMapper;

	/**
     * 查询售后服务ID信息
     * 
     * @param mid 售后服务IDID
     * @return 售后服务ID信息
     */
    @Override
	public SpLogServices selectSpLogServicesById(Integer mid)
	{
	    return spLogServicesMapper.selectSpLogServicesById(mid);
	}
	
	/**
     * 查询售后服务ID列表
     * 
     * @param spLogServices 售后服务ID信息
     * @return 售后服务ID集合
     */
	@Override
	public List<SpLogServices> selectSpLogServicesList(SpLogServices spLogServices)
	{
	    return spLogServicesMapper.selectSpLogServicesList(spLogServices);
	}
	
    /**
     * 新增售后服务ID
     * 
     * @param spLogServices 售后服务ID信息
     * @return 结果
     */
	@Override
	public int insertSpLogServices(SpLogServices spLogServices)
	{
	    return spLogServicesMapper.insertSpLogServices(spLogServices);
	}
	
	/**
     * 修改售后服务ID
     * 
     * @param spLogServices 售后服务ID信息
     * @return 结果
     */
	@Override
	public int updateSpLogServices(SpLogServices spLogServices)
	{
	    return spLogServicesMapper.updateSpLogServices(spLogServices);
	}

	/**
     * 删除售后服务ID对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSpLogServicesByIds(String ids)
	{
		return spLogServicesMapper.deleteSpLogServicesByIds(Convert.toStrArray(ids));
	}
	
}
