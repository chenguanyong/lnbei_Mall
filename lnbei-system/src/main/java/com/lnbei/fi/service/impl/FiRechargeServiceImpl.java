package com.lnbei.fi.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnbei.fi.mapper.FiRechargeMapper;
import com.lnbei.fi.domain.FiRecharge;
import com.lnbei.fi.service.IFiRechargeService;
import com.lnbei.common.core.text.Convert;

/**
 * 充值 服务层实现
 * 
 * @author lnbei
 * @date 2020-02-13
 */
@Service
public class FiRechargeServiceImpl implements IFiRechargeService 
{
	@Autowired
	private FiRechargeMapper fiRechargeMapper;

	/**
     * 查询充值信息
     * 
     * @param mid 充值ID
     * @return 充值信息
     */
    @Override
	public FiRecharge selectFiRechargeById(String mid)
	{
	    return fiRechargeMapper.selectFiRechargeById(mid);
	}
	
	/**
     * 查询充值列表
     * 
     * @param fiRecharge 充值信息
     * @return 充值集合
     */
	@Override
	public List<FiRecharge> selectFiRechargeList(FiRecharge fiRecharge)
	{
	    return fiRechargeMapper.selectFiRechargeList(fiRecharge);
	}
	
    /**
     * 新增充值
     * 
     * @param fiRecharge 充值信息
     * @return 结果
     */
	@Override
	public int insertFiRecharge(FiRecharge fiRecharge)
	{
	    return fiRechargeMapper.insertFiRecharge(fiRecharge);
	}
	
	/**
     * 修改充值
     * 
     * @param fiRecharge 充值信息
     * @return 结果
     */
	@Override
	public int updateFiRecharge(FiRecharge fiRecharge)
	{
	    return fiRechargeMapper.updateFiRecharge(fiRecharge);
	}

	/**
     * 删除充值对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteFiRechargeByIds(String ids)
	{
		return fiRechargeMapper.deleteFiRechargeByIds(Convert.toStrArray(ids));
	}
	
}
