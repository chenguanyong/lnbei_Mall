package com.lnbei.fi.service;

import com.lnbei.fi.domain.FiCashDraws;
import java.util.List;

/**
 * 提现记录 服务层
 * 
 * @author lnbei
 * @date 2020-02-13
 */
public interface IFiCashDrawsService 
{
	/**
     * 查询提现记录信息
     * 
     * @param mid 提现记录ID
     * @return 提现记录信息
     */
	public FiCashDraws selectFiCashDrawsById(String mid);
	
	/**
     * 查询提现记录列表
     * 
     * @param fiCashDraws 提现记录信息
     * @return 提现记录集合
     */
	public List<FiCashDraws> selectFiCashDrawsList(FiCashDraws fiCashDraws);
	
	/**
     * 新增提现记录
     * 
     * @param fiCashDraws 提现记录信息
     * @return 结果
     */
	public int insertFiCashDraws(FiCashDraws fiCashDraws);
	
	/**
     * 修改提现记录
     * 
     * @param fiCashDraws 提现记录信息
     * @return 结果
     */
	public int updateFiCashDraws(FiCashDraws fiCashDraws);
		
	/**
     * 删除提现记录信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteFiCashDrawsByIds(String ids);
	
}
