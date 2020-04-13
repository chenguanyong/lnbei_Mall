package com.lnbei.sp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnbei.sp.mapper.SpShopFlowsMapper;
import com.lnbei.sp.domain.SpShopFlows;
import com.lnbei.sp.service.ISpShopFlowsService;
import com.lnbei.common.core.text.Convert;

/**
 * 商铺流程 服务层实现
 * 
 * @author lnbei
 * @date 2020-02-05
 */
@Service
public class SpShopFlowsServiceImpl implements ISpShopFlowsService 
{
	@Autowired
	private SpShopFlowsMapper spShopFlowsMapper;

	/**
     * 查询商铺流程信息
     * 
     * @param mid 商铺流程ID
     * @return 商铺流程信息
     */
    @Override
	public SpShopFlows selectSpShopFlowsById(String mid)
	{
	    return spShopFlowsMapper.selectSpShopFlowsById(mid);
	}
	
	/**
     * 查询商铺流程列表
     * 
     * @param spShopFlows 商铺流程信息
     * @return 商铺流程集合
     */
	@Override
	public List<SpShopFlows> selectSpShopFlowsList(SpShopFlows spShopFlows)
	{
	    return spShopFlowsMapper.selectSpShopFlowsList(spShopFlows);
	}
	
    /**
     * 新增商铺流程
     * 
     * @param spShopFlows 商铺流程信息
     * @return 结果
     */
	@Override
	public int insertSpShopFlows(SpShopFlows spShopFlows)
	{
	    return spShopFlowsMapper.insertSpShopFlows(spShopFlows);
	}
	
	/**
     * 修改商铺流程
     * 
     * @param spShopFlows 商铺流程信息
     * @return 结果
     */
	@Override
	public int updateSpShopFlows(SpShopFlows spShopFlows)
	{
	    return spShopFlowsMapper.updateSpShopFlows(spShopFlows);
	}

	/**
     * 删除商铺流程对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSpShopFlowsByIds(String ids)
	{
		return spShopFlowsMapper.deleteSpShopFlowsByIds(Convert.toStrArray(ids));
	}
	
}
