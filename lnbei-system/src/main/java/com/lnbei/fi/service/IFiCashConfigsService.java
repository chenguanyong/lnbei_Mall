package com.lnbei.fi.service;

import com.lnbei.fi.domain.FiCashConfigs;
import java.util.List;

/**
 * 提现账号管理 服务层
 * 
 * @author lnbei
 * @date 2020-02-13
 */
public interface IFiCashConfigsService 
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
     * 删除提现账号管理信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteFiCashConfigsByIds(String ids);
	
}
