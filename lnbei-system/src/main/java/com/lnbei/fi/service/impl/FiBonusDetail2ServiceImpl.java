package com.lnbei.fi.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnbei.fi.mapper.FiBonusDetail2Mapper;
import com.lnbei.fi.domain.FiBonusDetail2;
import com.lnbei.fi.service.IFiBonusDetail2Service;
import com.lnbei.common.core.text.Convert;

/**
 * 奖金明细 服务层实现
 * 
 * @author lnbei
 * @date 2020-02-13
 */
@Service
public class FiBonusDetail2ServiceImpl implements IFiBonusDetail2Service 
{
	@Autowired
	private FiBonusDetail2Mapper fiBonusDetail2Mapper;

	/**
     * 查询奖金明细信息
     * 
     * @param mid 奖金明细ID
     * @return 奖金明细信息
     */
    @Override
	public FiBonusDetail2 selectFiBonusDetail2ById(String mid)
	{
	    return fiBonusDetail2Mapper.selectFiBonusDetail2ById(mid);
	}
	
	/**
     * 查询奖金明细列表
     * 
     * @param fiBonusDetail2 奖金明细信息
     * @return 奖金明细集合
     */
	@Override
	public List<FiBonusDetail2> selectFiBonusDetail2List(FiBonusDetail2 fiBonusDetail2)
	{
	    return fiBonusDetail2Mapper.selectFiBonusDetail2List(fiBonusDetail2);
	}
	
    /**
     * 新增奖金明细
     * 
     * @param fiBonusDetail2 奖金明细信息
     * @return 结果
     */
	@Override
	public int insertFiBonusDetail2(FiBonusDetail2 fiBonusDetail2)
	{
	    return fiBonusDetail2Mapper.insertFiBonusDetail2(fiBonusDetail2);
	}
	
	/**
     * 修改奖金明细
     * 
     * @param fiBonusDetail2 奖金明细信息
     * @return 结果
     */
	@Override
	public int updateFiBonusDetail2(FiBonusDetail2 fiBonusDetail2)
	{
	    return fiBonusDetail2Mapper.updateFiBonusDetail2(fiBonusDetail2);
	}

	/**
     * 删除奖金明细对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteFiBonusDetail2ByIds(String ids)
	{
		return fiBonusDetail2Mapper.deleteFiBonusDetail2ByIds(Convert.toStrArray(ids));
	}
	
}
