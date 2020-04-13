package com.lnbei.fi.service;

import com.lnbei.fi.domain.FiDayBounsDetail;
import java.util.List;

/**
 * 每日奖金记录 服务层
 * 
 * @author lnbei
 * @date 2020-02-13
 */
public interface IFiDayBounsDetailService 
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
     * 删除每日奖金记录信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteFiDayBounsDetailByIds(String ids);
	
}
