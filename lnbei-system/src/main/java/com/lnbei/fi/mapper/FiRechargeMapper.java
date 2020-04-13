package com.lnbei.fi.mapper;

import com.lnbei.fi.domain.FiRecharge;
import java.util.List;	

/**
 * 充值 数据层
 * 
 * @author lnbei
 * @date 2020-02-13
 */
public interface FiRechargeMapper 
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
     * 删除充值
     * 
     * @param mid 充值ID
     * @return 结果
     */
	public int deleteFiRechargeById(String mid);
	
	/**
     * 批量删除充值
     * 
     * @param mids 需要删除的数据ID
     * @return 结果
     */
	public int deleteFiRechargeByIds(String[] mids);
	
}