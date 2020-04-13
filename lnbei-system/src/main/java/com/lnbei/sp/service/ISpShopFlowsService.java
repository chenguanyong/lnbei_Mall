package com.lnbei.sp.service;

import com.lnbei.sp.domain.SpShopFlows;
import java.util.List;

/**
 * 商铺流程 服务层
 * 
 * @author lnbei
 * @date 2020-02-05
 */
public interface ISpShopFlowsService 
{
	/**
     * 查询商铺流程信息
     * 
     * @param mid 商铺流程ID
     * @return 商铺流程信息
     */
	public SpShopFlows selectSpShopFlowsById(String mid);
	
	/**
     * 查询商铺流程列表
     * 
     * @param spShopFlows 商铺流程信息
     * @return 商铺流程集合
     */
	public List<SpShopFlows> selectSpShopFlowsList(SpShopFlows spShopFlows);
	
	/**
     * 新增商铺流程
     * 
     * @param spShopFlows 商铺流程信息
     * @return 结果
     */
	public int insertSpShopFlows(SpShopFlows spShopFlows);
	
	/**
     * 修改商铺流程
     * 
     * @param spShopFlows 商铺流程信息
     * @return 结果
     */
	public int updateSpShopFlows(SpShopFlows spShopFlows);
		
	/**
     * 删除商铺流程信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSpShopFlowsByIds(String ids);
	
}
