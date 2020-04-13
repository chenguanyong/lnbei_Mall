package com.lnbei.sp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnbei.sp.mapper.SpCatShopsMapper;
import com.lnbei.sp.domain.SpCatShops;
import com.lnbei.sp.service.ISpCatShopsService;
import com.lnbei.common.core.text.Convert;

/**
 * 类别和店铺 服务层实现
 * 
 * @author lnbei
 * @date 2020-03-06
 */
@Service
public class SpCatShopsServiceImpl implements ISpCatShopsService 
{
	@Autowired
	private SpCatShopsMapper spCatShopsMapper;

	/**
     * 查询类别和店铺信息
     * 
     * @param mid 类别和店铺ID
     * @return 类别和店铺信息
     */
    @Override
	public SpCatShops selectSpCatShopsById(String mid)
	{
	    return spCatShopsMapper.selectSpCatShopsById(mid);
	}
	
	/**
     * 查询类别和店铺列表
     * 
     * @param spCatShops 类别和店铺信息
     * @return 类别和店铺集合
     */
	@Override
	public List<SpCatShops> selectSpCatShopsList(SpCatShops spCatShops)
	{
	    return spCatShopsMapper.selectSpCatShopsList(spCatShops);
	}
	
    /**
     * 新增类别和店铺
     * 
     * @param spCatShops 类别和店铺信息
     * @return 结果
     */
	@Override
	public int insertSpCatShops(SpCatShops spCatShops)
	{
	    return spCatShopsMapper.insertSpCatShops(spCatShops);
	}
	
	/**
     * 修改类别和店铺
     * 
     * @param spCatShops 类别和店铺信息
     * @return 结果
     */
	@Override
	public int updateSpCatShops(SpCatShops spCatShops)
	{
	    return spCatShopsMapper.updateSpCatShops(spCatShops);
	}

	/**
     * 删除类别和店铺对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSpCatShopsByIds(String ids)
	{
		return spCatShopsMapper.deleteSpCatShopsByIds(Convert.toStrArray(ids));
	}
	/**
     * 根据商铺Id删除类别和店铺
     * 
     * @param mids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSpCatShopsByShopId(String shopId) {
		return spCatShopsMapper.deleteSpCatShopsByShopId(shopId);
	}
}
