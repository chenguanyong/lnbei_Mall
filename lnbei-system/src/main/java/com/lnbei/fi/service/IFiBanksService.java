package com.lnbei.fi.service;

import com.lnbei.fi.domain.FiBanks;
import java.util.List;

/**
 * 银行 服务层
 * 
 * @author lnbei
 * @date 2020-02-13
 */
public interface IFiBanksService 
{
	/**
     * 查询银行信息
     * 
     * @param mid 银行ID
     * @return 银行信息
     */
	public FiBanks selectFiBanksById(String mid);
	
	/**
     * 查询银行列表
     * 
     * @param fiBanks 银行信息
     * @return 银行集合
     */
	public List<FiBanks> selectFiBanksList(FiBanks fiBanks);
	
	/**
     * 新增银行
     * 
     * @param fiBanks 银行信息
     * @return 结果
     */
	public int insertFiBanks(FiBanks fiBanks);
	
	/**
     * 修改银行
     * 
     * @param fiBanks 银行信息
     * @return 结果
     */
	public int updateFiBanks(FiBanks fiBanks);
		
	/**
     * 删除银行信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteFiBanksByIds(String ids);
	
}
