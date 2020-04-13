package com.lnbei.sp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnbei.sp.mapper.SpExpressMapper;
import com.lnbei.sp.domain.SpExpress;
import com.lnbei.sp.service.ISpExpressService;
import com.lnbei.common.core.text.Convert;

/**
 * 快递 服务层实现
 * 
 * @author lnbei
 * @date 2020-02-05
 */
@Service
public class SpExpressServiceImpl implements ISpExpressService 
{
	@Autowired
	private SpExpressMapper spExpressMapper;

	/**
     * 查询快递信息
     * 
     * @param mid 快递ID
     * @return 快递信息
     */
    @Override
	public SpExpress selectSpExpressById(String mid)
	{
	    return spExpressMapper.selectSpExpressById(mid);
	}
	
	/**
     * 查询快递列表
     * 
     * @param spExpress 快递信息
     * @return 快递集合
     */
	@Override
	public List<SpExpress> selectSpExpressList(SpExpress spExpress)
	{
	    return spExpressMapper.selectSpExpressList(spExpress);
	}
	
    /**
     * 新增快递
     * 
     * @param spExpress 快递信息
     * @return 结果
     */
	@Override
	public int insertSpExpress(SpExpress spExpress)
	{
	    return spExpressMapper.insertSpExpress(spExpress);
	}
	
	/**
     * 修改快递
     * 
     * @param spExpress 快递信息
     * @return 结果
     */
	@Override
	public int updateSpExpress(SpExpress spExpress)
	{
	    return spExpressMapper.updateSpExpress(spExpress);
	}

	/**
     * 删除快递对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSpExpressByIds(String ids)
	{
		return spExpressMapper.deleteSpExpressByIds(Convert.toStrArray(ids));
	}
	
}
