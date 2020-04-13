package com.lnbei.sp.service;

import com.lnbei.sp.domain.SpShopConfigs;
import java.util.List;

/**
 * 商家配置 服务层
 * 
 * @author lnbei
 * @date 2020-02-05
 */
public interface ISpShopConfigsService 
{
	/**
     * 查询商家配置信息
     * 
     * @param mid 商家配置ID
     * @return 商家配置信息
     */
	public SpShopConfigs selectSpShopConfigsById(String mid);
	
	/**
     * 查询商家配置列表
     * 
     * @param spShopConfigs 商家配置信息
     * @return 商家配置集合
     */
	public List<SpShopConfigs> selectSpShopConfigsList(SpShopConfigs spShopConfigs);
	
	/**
     * 新增商家配置
     * 
     * @param spShopConfigs 商家配置信息
     * @return 结果
     */
	public int insertSpShopConfigs(SpShopConfigs spShopConfigs);
	
	/**
     * 修改商家配置
     * 
     * @param spShopConfigs 商家配置信息
     * @return 结果
     */
	public int updateSpShopConfigs(SpShopConfigs spShopConfigs);
		
	/**
     * 删除商家配置信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSpShopConfigsByIds(String ids);
	
}
