package com.lnbei.fi.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnbei.fi.mapper.FiCashDrawsMapper;
import com.lnbei.fi.domain.FiCashDraws;
import com.lnbei.fi.service.IFiCashDrawsService;
import com.lnbei.common.core.text.Convert;

/**
 * 提现记录 服务层实现
 * 
 * @author lnbei
 * @date 2020-02-13
 */
@Service
public class FiCashDrawsServiceImpl implements IFiCashDrawsService 
{
	@Autowired
	private FiCashDrawsMapper fiCashDrawsMapper;

	/**
     * 查询提现记录信息
     * 
     * @param mid 提现记录ID
     * @return 提现记录信息
     */
    @Override
	public FiCashDraws selectFiCashDrawsById(String mid)
	{
	    return fiCashDrawsMapper.selectFiCashDrawsById(mid);
	}
	
	/**
     * 查询提现记录列表
     * 
     * @param fiCashDraws 提现记录信息
     * @return 提现记录集合
     */
	@Override
	public List<FiCashDraws> selectFiCashDrawsList(FiCashDraws fiCashDraws)
	{
	    return fiCashDrawsMapper.selectFiCashDrawsList(fiCashDraws);
	}
	
    /**
     * 新增提现记录
     * 
     * @param fiCashDraws 提现记录信息
     * @return 结果
     */
	@Override
	public int insertFiCashDraws(FiCashDraws fiCashDraws)
	{
	    return fiCashDrawsMapper.insertFiCashDraws(fiCashDraws);
	}
	
	/**
     * 修改提现记录
     * 
     * @param fiCashDraws 提现记录信息
     * @return 结果
     */
	@Override
	public int updateFiCashDraws(FiCashDraws fiCashDraws)
	{
	    return fiCashDrawsMapper.updateFiCashDraws(fiCashDraws);
	}

	/**
     * 删除提现记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteFiCashDrawsByIds(String ids)
	{
		return fiCashDrawsMapper.deleteFiCashDrawsByIds(Convert.toStrArray(ids));
	}
	
}
