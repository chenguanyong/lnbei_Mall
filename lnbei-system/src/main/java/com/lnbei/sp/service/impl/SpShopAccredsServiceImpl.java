package com.lnbei.sp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnbei.sp.mapper.SpShopAccredsMapper;
import com.lnbei.sp.domain.SpShopAccreds;
import com.lnbei.sp.service.ISpShopAccredsService;
import com.lnbei.common.core.text.Convert;

/**
 * 店铺认证 服务层实现
 * 
 * @author lnbei
 * @date 2020-02-05
 */
@Service
public class SpShopAccredsServiceImpl implements ISpShopAccredsService 
{
	@Autowired
	private SpShopAccredsMapper spShopAccredsMapper;

	/**
     * 查询店铺认证信息
     * 
     * @param mid 店铺认证ID
     * @return 店铺认证信息
     */
    @Override
	public SpShopAccreds selectSpShopAccredsById(String mid)
	{
	    return spShopAccredsMapper.selectSpShopAccredsById(mid);
	}
	
	/**
     * 查询店铺认证列表
     * 
     * @param spShopAccreds 店铺认证信息
     * @return 店铺认证集合
     */
	@Override
	public List<SpShopAccreds> selectSpShopAccredsList(SpShopAccreds spShopAccreds)
	{
	    return spShopAccredsMapper.selectSpShopAccredsList(spShopAccreds);
	}
	
    /**
     * 新增店铺认证
     * 
     * @param spShopAccreds 店铺认证信息
     * @return 结果
     */
	@Override
	public int insertSpShopAccreds(SpShopAccreds spShopAccreds)
	{
	    return spShopAccredsMapper.insertSpShopAccreds(spShopAccreds);
	}
	
	/**
     * 修改店铺认证
     * 
     * @param spShopAccreds 店铺认证信息
     * @return 结果
     */
	@Override
	public int updateSpShopAccreds(SpShopAccreds spShopAccreds)
	{
	    return spShopAccredsMapper.updateSpShopAccreds(spShopAccreds);
	}

	/**
     * 删除店铺认证对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSpShopAccredsByIds(String ids)
	{
		return spShopAccredsMapper.deleteSpShopAccredsByIds(Convert.toStrArray(ids));
	}
	
}
