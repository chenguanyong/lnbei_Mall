package com.lnbei.sp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnbei.sp.mapper.SpShopExpressMapper;
import com.lnbei.sp.domain.SpShopExpress;
import com.lnbei.sp.service.ISpShopExpressService;
import com.lnbei.common.core.text.Convert;

/**
 * 商家快递 服务层实现
 * 
 * @author lnbei
 * @date 2020-02-05
 */
@Service
public class SpShopExpressServiceImpl implements ISpShopExpressService 
{
	@Autowired
	private SpShopExpressMapper spShopExpressMapper;

	/**
     * 查询商家快递信息
     * 
     * @param mid 商家快递ID
     * @return 商家快递信息
     */
    @Override
	public SpShopExpress selectSpShopExpressById(String mid)
	{
	    return spShopExpressMapper.selectSpShopExpressById(mid);
	}
	
	/**
     * 查询商家快递列表
     * 
     * @param spShopExpress 商家快递信息
     * @return 商家快递集合
     */
	@Override
	public List<SpShopExpress> selectSpShopExpressList(SpShopExpress spShopExpress)
	{
	    return spShopExpressMapper.selectSpShopExpressList(spShopExpress);
	}
	
    /**
     * 新增商家快递
     * 
     * @param spShopExpress 商家快递信息
     * @return 结果
     */
	@Override
	public int insertSpShopExpress(SpShopExpress spShopExpress)
	{
	    return spShopExpressMapper.insertSpShopExpress(spShopExpress);
	}
	
	/**
     * 修改商家快递
     * 
     * @param spShopExpress 商家快递信息
     * @return 结果
     */
	@Override
	public int updateSpShopExpress(SpShopExpress spShopExpress)
	{
	    return spShopExpressMapper.updateSpShopExpress(spShopExpress);
	}

	/**
     * 删除商家快递对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSpShopExpressByIds(String ids)
	{
		return spShopExpressMapper.deleteSpShopExpressByIds(Convert.toStrArray(ids));
	}
	
}
