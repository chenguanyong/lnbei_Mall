package com.lnbei.fi.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnbei.fi.mapper.FiCashConfigsMapper;
import com.lnbei.fi.domain.FiCashConfigs;
import com.lnbei.fi.service.IFiCashConfigsService;
import com.lnbei.common.core.text.Convert;

/**
 * 提现账号管理 服务层实现
 * 
 * @author lnbei
 * @date 2020-02-13
 */
@Service
public class FiCashConfigsServiceImpl implements IFiCashConfigsService 
{
	@Autowired
	private FiCashConfigsMapper fiCashConfigsMapper;

	/**
     * 查询提现账号管理信息
     * 
     * @param mid 提现账号管理ID
     * @return 提现账号管理信息
     */
    @Override
	public FiCashConfigs selectFiCashConfigsById(String mid)
	{
	    return fiCashConfigsMapper.selectFiCashConfigsById(mid);
	}
	
	/**
     * 查询提现账号管理列表
     * 
     * @param fiCashConfigs 提现账号管理信息
     * @return 提现账号管理集合
     */
	@Override
	public List<FiCashConfigs> selectFiCashConfigsList(FiCashConfigs fiCashConfigs)
	{
	    return fiCashConfigsMapper.selectFiCashConfigsList(fiCashConfigs);
	}
	
    /**
     * 新增提现账号管理
     * 
     * @param fiCashConfigs 提现账号管理信息
     * @return 结果
     */
	@Override
	public int insertFiCashConfigs(FiCashConfigs fiCashConfigs)
	{
	    return fiCashConfigsMapper.insertFiCashConfigs(fiCashConfigs);
	}
	
	/**
     * 修改提现账号管理
     * 
     * @param fiCashConfigs 提现账号管理信息
     * @return 结果
     */
	@Override
	public int updateFiCashConfigs(FiCashConfigs fiCashConfigs)
	{
	    return fiCashConfigsMapper.updateFiCashConfigs(fiCashConfigs);
	}

	/**
     * 删除提现账号管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteFiCashConfigsByIds(String ids)
	{
		return fiCashConfigsMapper.deleteFiCashConfigsByIds(Convert.toStrArray(ids));
	}
	
}
