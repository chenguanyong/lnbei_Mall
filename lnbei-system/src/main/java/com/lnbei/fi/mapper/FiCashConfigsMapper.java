package com.lnbei.fi.mapper;

import com.lnbei.fi.domain.FiCashConfigs;
import java.util.List;	

/**
 * 提现账号管理 数据层
 * 
 * @author lnbei
 * @date 2020-02-13
 */
public interface FiCashConfigsMapper 
{
	/**
     * 查询提现账号管理信息
     * 
     * @param mid 提现账号管理ID
     * @return 提现账号管理信息
     */
	public FiCashConfigs selectFiCashConfigsById(String mid);
	
	/**
     * 查询提现账号管理列表
     * 
     * @param fiCashConfigs 提现账号管理信息
     * @return 提现账号管理集合
     */
	public List<FiCashConfigs> selectFiCashConfigsList(FiCashConfigs fiCashConfigs);
	
	/**
     * 新增提现账号管理
     * 
     * @param fiCashConfigs 提现账号管理信息
     * @return 结果
     */
	public int insertFiCashConfigs(FiCashConfigs fiCashConfigs);
	
	/**
     * 修改提现账号管理
     * 
     * @param fiCashConfigs 提现账号管理信息
     * @return 结果
     */
	public int updateFiCashConfigs(FiCashConfigs fiCashConfigs);
	
	/**
     * 删除提现账号管理
     * 
     * @param mid 提现账号管理ID
     * @return 结果
     */
	public int deleteFiCashConfigsById(String mid);
	
	/**
     * 批量删除提现账号管理
     * 
     * @param mids 需要删除的数据ID
     * @return 结果
     */
	public int deleteFiCashConfigsByIds(String[] mids);
	
}