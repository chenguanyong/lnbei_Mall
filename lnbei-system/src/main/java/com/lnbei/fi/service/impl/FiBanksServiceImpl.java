package com.lnbei.fi.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnbei.fi.mapper.FiBanksMapper;
import com.lnbei.fi.domain.FiBanks;
import com.lnbei.fi.service.IFiBanksService;
import com.lnbei.common.core.text.Convert;

/**
 * 银行 服务层实现
 * 
 * @author lnbei
 * @date 2020-02-13
 */
@Service
public class FiBanksServiceImpl implements IFiBanksService 
{
	@Autowired
	private FiBanksMapper fiBanksMapper;

	/**
     * 查询银行信息
     * 
     * @param mid 银行ID
     * @return 银行信息
     */
    @Override
	public FiBanks selectFiBanksById(String mid)
	{
	    return fiBanksMapper.selectFiBanksById(mid);
	}
	
	/**
     * 查询银行列表
     * 
     * @param fiBanks 银行信息
     * @return 银行集合
     */
	@Override
	public List<FiBanks> selectFiBanksList(FiBanks fiBanks)
	{
	    return fiBanksMapper.selectFiBanksList(fiBanks);
	}
	
    /**
     * 新增银行
     * 
     * @param fiBanks 银行信息
     * @return 结果
     */
	@Override
	public int insertFiBanks(FiBanks fiBanks)
	{
	    return fiBanksMapper.insertFiBanks(fiBanks);
	}
	
	/**
     * 修改银行
     * 
     * @param fiBanks 银行信息
     * @return 结果
     */
	@Override
	public int updateFiBanks(FiBanks fiBanks)
	{
	    return fiBanksMapper.updateFiBanks(fiBanks);
	}

	/**
     * 删除银行对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteFiBanksByIds(String ids)
	{
		return fiBanksMapper.deleteFiBanksByIds(Convert.toStrArray(ids));
	}
	
}
