package com.lnbei.fi.mapper;

import com.lnbei.fi.domain.FiDayBounsDetail;
import java.util.List;	

/**
 * 每日奖金记录 数据层
 * 
 * @author lnbei
 * @date 2020-02-13
 */
public interface FiDayBounsDetailMapper 
{
	/**
     * 查询每日奖金记录信息
     * 
     * @param mid 每日奖金记录ID
     * @return 每日奖金记录信息
     */
	public FiDayBounsDetail selectFiDayBounsDetailById(String mid);
	
	/**
     * 查询每日奖金记录列表
     * 
     * @param fiDayBounsDetail 每日奖金记录信息
     * @return 每日奖金记录集合
     */
	public List<FiDayBounsDetail> selectFiDayBounsDetailList(FiDayBounsDetail fiDayBounsDetail);
	
	/**
     * 新增每日奖金记录
     * 
     * @param fiDayBounsDetail 每日奖金记录信息
     * @return 结果
     */
	public int insertFiDayBounsDetail(FiDayBounsDetail fiDayBounsDetail);
	
	/**
     * 修改每日奖金记录
     * 
     * @param fiDayBounsDetail 每日奖金记录信息
     * @return 结果
     */
	public int updateFiDayBounsDetail(FiDayBounsDetail fiDayBounsDetail);
	
	/**
     * 删除每日奖金记录
     * 
     * @param mid 每日奖金记录ID
     * @return 结果
     */
	public int deleteFiDayBounsDetailById(String mid);
	
	/**
     * 批量删除每日奖金记录
     * 
     * @param mids 需要删除的数据ID
     * @return 结果
     */
	public int deleteFiDayBounsDetailByIds(String[] mids);
	
}