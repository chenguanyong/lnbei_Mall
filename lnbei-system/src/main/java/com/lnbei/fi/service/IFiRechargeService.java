package com.lnbei.fi.service;

import com.lnbei.fi.domain.FiRecharge;
import java.util.List;

/**
 * 充值 服务层
 * 
 * @author lnbei
 * @date 2020-02-13
 */
public interface IFiRechargeService 
{
	/**
     * 查询充值信息
     * 
     * @param mid 充值ID
     * @return 充值信息
     */
	public FiRecharge selectFiRechargeById(String mid);
	
	/**
     * 查询充值列表
     * 
     * @param fiRecharge 充值信息
     * @return 充值集合
     */
	public List<FiRecharge> selectFiRechargeList(FiRecharge fiRecharge);
	
	/**
     * 新增充值
     * 
     * @param fiRecharge 充值信息
     * @return 结果
     */
	public int insertFiRecharge(FiRecharge fiRecharge);
	
	/**
     * 修改充值
     * 
     * @param fiRecharge 充值信息
     * @return 结果
     */
	public int updateFiRecharge(FiRecharge fiRecharge);
		
	/**
     * 删除充值信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteFiRechargeByIds(String ids);
	
}
