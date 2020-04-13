package com.lnbei.sp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnbei.sp.mapper.SpInvoicesMapper;
import com.lnbei.sp.domain.SpInvoices;
import com.lnbei.sp.service.ISpInvoicesService;
import com.lnbei.common.core.text.Convert;

/**
 * 发票管理 服务层实现
 * 
 * @author lnbei
 * @date 2020-02-23
 */
@Service
public class SpInvoicesServiceImpl implements ISpInvoicesService 
{
	@Autowired
	private SpInvoicesMapper spInvoicesMapper;

	/**
     * 查询发票管理信息
     * 
     * @param mid 发票管理ID
     * @return 发票管理信息
     */
    @Override
	public SpInvoices selectSpInvoicesById(String mid)
	{
	    return spInvoicesMapper.selectSpInvoicesById(mid);
	}
	
	/**
     * 查询发票管理列表
     * 
     * @param spInvoices 发票管理信息
     * @return 发票管理集合
     */
	@Override
	public List<SpInvoices> selectSpInvoicesList(SpInvoices spInvoices)
	{
	    return spInvoicesMapper.selectSpInvoicesList(spInvoices);
	}
	
    /**
     * 新增发票管理
     * 
     * @param spInvoices 发票管理信息
     * @return 结果
     */
	@Override
	public int insertSpInvoices(SpInvoices spInvoices)
	{
	    return spInvoicesMapper.insertSpInvoices(spInvoices);
	}
	
	/**
     * 修改发票管理
     * 
     * @param spInvoices 发票管理信息
     * @return 结果
     */
	@Override
	public int updateSpInvoices(SpInvoices spInvoices)
	{
	    return spInvoicesMapper.updateSpInvoices(spInvoices);
	}

	/**
     * 删除发票管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSpInvoicesByIds(String ids)
	{
		return spInvoicesMapper.deleteSpInvoicesByIds(Convert.toStrArray(ids));
	}
	
}
