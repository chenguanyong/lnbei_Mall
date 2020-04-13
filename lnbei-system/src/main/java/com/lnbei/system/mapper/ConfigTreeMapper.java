package com.lnbei.system.mapper;

import com.lnbei.system.domain.ConfigTree;
import java.util.List;	

/**
 * 配置树 数据层
 * 
 * @author lnbei
 * @date 2019-12-25
 */
public interface ConfigTreeMapper 
{
	/**
     * 查询配置树信息
     * 
     * @param id 配置树ID
     * @return 配置树信息
     */
	public ConfigTree selectConfigTreeById(String id);
	
	/**
     * 查询配置树列表
     * 
     * @param configTree 配置树信息
     * @return 配置树集合
     */
	public List<ConfigTree> selectConfigTreeList(ConfigTree configTree);
	
	/**
     * 新增配置树
     * 
     * @param configTree 配置树信息
     * @return 结果
     */
	public int insertConfigTree(ConfigTree configTree);
	
	/**
     * 修改配置树
     * 
     * @param configTree 配置树信息
     * @return 结果
     */
	public int updateConfigTree(ConfigTree configTree);
	
	/**
     * 删除配置树
     * 
     * @param id 配置树ID
     * @return 结果
     */
	public int deleteConfigTreeById(String id);
	
	/**
     * 批量删除配置树
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteConfigTreeByIds(String[] ids);
	
}