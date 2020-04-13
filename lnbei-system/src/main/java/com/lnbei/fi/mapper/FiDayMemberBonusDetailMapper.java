package com.lnbei.fi.mapper;

import com.lnbei.fi.domain.FiDayMemberBonusDetail;
import java.util.List;	

/**
 * 会员每日奖金记录 数据层
 * 
 * @author lnbei
 * @date 2020-02-13
 */
public interface FiDayMemberBonusDetailMapper 
{
	/**
     * 查询会员每日奖金记录信息
     * 
     * @param mid 会员每日奖金记录ID
     * @return 会员每日奖金记录信息
     */
	public FiDayMemberBonusDetail selectFiDayMemberBonusDetailById(String mid);
	
	/**
     * 查询会员每日奖金记录列表
     * 
     * @param fiDayMemberBonusDetail 会员每日奖金记录信息
     * @return 会员每日奖金记录集合
     */
	public List<FiDayMemberBonusDetail> selectFiDayMemberBonusDetailList(FiDayMemberBonusDetail fiDayMemberBonusDetail);
	
	/**
     * 新增会员每日奖金记录
     * 
     * @param fiDayMemberBonusDetail 会员每日奖金记录信息
     * @return 结果
     */
	public int insertFiDayMemberBonusDetail(FiDayMemberBonusDetail fiDayMemberBonusDetail);
	
	/**
     * 修改会员每日奖金记录
     * 
     * @param fiDayMemberBonusDetail 会员每日奖金记录信息
     * @return 结果
     */
	public int updateFiDayMemberBonusDetail(FiDayMemberBonusDetail fiDayMemberBonusDetail);
	
	/**
     * 删除会员每日奖金记录
     * 
     * @param mid 会员每日奖金记录ID
     * @return 结果
     */
	public int deleteFiDayMemberBonusDetailById(String mid);
	
	/**
     * 批量删除会员每日奖金记录
     * 
     * @param mids 需要删除的数据ID
     * @return 结果
     */
	public int deleteFiDayMemberBonusDetailByIds(String[] mids);
	
}