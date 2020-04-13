package com.lnbei.sp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnbei.sp.mapper.SpShopConfigsMapper;
import com.lnbei.sp.domain.SpShopConfigs;
import com.lnbei.sp.service.ISpShopConfigsService;
import com.lnbei.common.core.text.Convert;

/**
 * 商家配置 服务层实现
 * 
 * @author lnbei
 * @date 2020-02-05
 */
@Service
public class SpShopConfigsServiceImpl implements ISpShopConfigsService 
{
	@Autowired
	private SpShopConfigsMapper spShopConfigsMapper;

	/**
     * 查询商家配置信息
     * 
     * @param mid 商家配置ID
     * @return 商家配置信息
     */
    @Override
	public SpShopConfigs selectSpShopConfigsById(String mid)
	{
	    return spShopConfigsMapper.selectSpShopConfigsById(mid);
	}
	
	/**
     * 查询商家配置列表
     * 
     * @param spShopConfigs 商家配置信息
     * @return 商家配置集合
     */
	@Override
	public List<SpShopConfigs> selectSpShopConfigsList(SpShopConfigs spShopConfigs)
	{
	    return spShopConfigsMapper.selectSpShopConfigsList(spShopConfigs);
	}
	
    /**
     * 新增商家配置
     * 
     * @param spShopConfigs 商家配置信息
     * @return 结果
     */
	@Override
	public int insertSpShopConfigs(SpShopConfigs spShopConfigs)
	{
	    return spShopConfigsMapper.insertSpShopConfigs(spShopConfigs);
	}
	
	/**
     * 修改商家配置
     * 
     * @param spShopConfigs 商家配置信息
     * @return 结果
     */
	@Override
	public int updateSpShopConfigs(SpShopConfigs spShopConfigs)
	{
	    return spShopConfigsMapper.updateSpShopConfigs(spShopConfigs);
	}

	/**
     * 删除商家配置对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSpShopConfigsByIds(String ids)
	{
		return spShopConfigsMapper.deleteSpShopConfigsByIds(Convert.toStrArray(ids));
	}
	
}
