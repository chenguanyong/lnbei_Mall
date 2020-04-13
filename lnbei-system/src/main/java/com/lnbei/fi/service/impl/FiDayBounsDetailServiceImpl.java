package com.lnbei.fi.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnbei.fi.mapper.FiDayBounsDetailMapper;
import com.lnbei.fi.domain.FiDayBounsDetail;
import com.lnbei.fi.service.IFiDayBounsDetailService;
import com.lnbei.common.core.text.Convert;

/**
 * 每日奖金记录 服务层实现
 * 
 * @author lnbei
 * @date 2020-02-13
 */
@Service
public class FiDayBounsDetailServiceImpl implements IFiDayBounsDetailService 
{
	@Autowired
	private FiDayBounsDetailMapper fiDayBounsDetailMapper;

	/**
     * 查询每日奖金记录信息
     * 
     * @param mid 每日奖金记录ID
     * @return 每日奖金记录信息
     */
    @Override
	public FiDayBounsDetail selectFiDayBounsDetailById(String mid)
	{
	    return fiDayBounsDetailMapper.selectFiDayBounsDetailById(mid);
	}
	
	/**
     * 查询每日奖金记录列表
     * 
     * @param fiDayBounsDetail 每日奖金记录信息
     * @return 每日奖金记录集合
     */
	@Override
	public List<FiDayBounsDetail> selectFiDayBounsDetailList(FiDayBounsDetail fiDayBounsDetail)
	{
	    return fiDayBounsDetailMapper.selectFiDayBounsDetailList(fiDayBounsDetail);
	}
	
    /**
     * 新增每日奖金记录
     * 
     * @param fiDayBounsDetail 每日奖金记录信息
     * @return 结果
     */
	@Override
	public int insertFiDayBounsDetail(FiDayBounsDetail fiDayBounsDetail)
	{
	    return fiDayBounsDetailMapper.insertFiDayBounsDetail(fiDayBounsDetail);
	}
	
	/**
     * 修改每日奖金记录
     * 
     * @param fiDayBounsDetail 每日奖金记录信息
     * @return 结果
     */
	@Override
	public int updateFiDayBounsDetail(FiDayBounsDetail fiDayBounsDetail)
	{
	    return fiDayBounsDetailMapper.updateFiDayBounsDetail(fiDayBounsDetail);
	}

	/**
     * 删除每日奖金记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteFiDayBounsDetailByIds(String ids)
	{
		return fiDayBounsDetailMapper.deleteFiDayBounsDetailByIds(Convert.toStrArray(ids));
	}
	
}
