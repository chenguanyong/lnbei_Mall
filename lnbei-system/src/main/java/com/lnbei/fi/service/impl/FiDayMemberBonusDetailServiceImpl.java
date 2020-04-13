package com.lnbei.fi.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnbei.fi.mapper.FiDayMemberBonusDetailMapper;
import com.lnbei.fi.domain.FiDayMemberBonusDetail;
import com.lnbei.fi.service.IFiDayMemberBonusDetailService;
import com.lnbei.common.core.text.Convert;

/**
 * 会员每日奖金记录 服务层实现
 * 
 * @author lnbei
 * @date 2020-02-13
 */
@Service
public class FiDayMemberBonusDetailServiceImpl implements IFiDayMemberBonusDetailService 
{
	@Autowired
	private FiDayMemberBonusDetailMapper fiDayMemberBonusDetailMapper;

	/**
     * 查询会员每日奖金记录信息
     * 
     * @param mid 会员每日奖金记录ID
     * @return 会员每日奖金记录信息
     */
    @Override
	public FiDayMemberBonusDetail selectFiDayMemberBonusDetailById(String mid)
	{
	    return fiDayMemberBonusDetailMapper.selectFiDayMemberBonusDetailById(mid);
	}
	
	/**
     * 查询会员每日奖金记录列表
     * 
     * @param fiDayMemberBonusDetail 会员每日奖金记录信息
     * @return 会员每日奖金记录集合
     */
	@Override
	public List<FiDayMemberBonusDetail> selectFiDayMemberBonusDetailList(FiDayMemberBonusDetail fiDayMemberBonusDetail)
	{
	    return fiDayMemberBonusDetailMapper.selectFiDayMemberBonusDetailList(fiDayMemberBonusDetail);
	}
	
    /**
     * 新增会员每日奖金记录
     * 
     * @param fiDayMemberBonusDetail 会员每日奖金记录信息
     * @return 结果
     */
	@Override
	public int insertFiDayMemberBonusDetail(FiDayMemberBonusDetail fiDayMemberBonusDetail)
	{
	    return fiDayMemberBonusDetailMapper.insertFiDayMemberBonusDetail(fiDayMemberBonusDetail);
	}
	
	/**
     * 修改会员每日奖金记录
     * 
     * @param fiDayMemberBonusDetail 会员每日奖金记录信息
     * @return 结果
     */
	@Override
	public int updateFiDayMemberBonusDetail(FiDayMemberBonusDetail fiDayMemberBonusDetail)
	{
	    return fiDayMemberBonusDetailMapper.updateFiDayMemberBonusDetail(fiDayMemberBonusDetail);
	}

	/**
     * 删除会员每日奖金记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteFiDayMemberBonusDetailByIds(String ids)
	{
		return fiDayMemberBonusDetailMapper.deleteFiDayMemberBonusDetailByIds(Convert.toStrArray(ids));
	}
	
}
