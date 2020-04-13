package com.lnbei.oa.mapper;

import com.lnbei.oa.domain.OaSystem;
import java.util.List;	

/**
 * 系统注册 数据层
 * 
 * @author lnbei
 * @date 2019-03-19
 */
public interface OaSystemMapper 
{
	/**
     * 查询系统注册信息
     * 
     * @param id 系统注册ID
     * @return 系统注册信息
     */
	public OaSystem selectOaSystemById(String id);
	
	/**
     * 查询系统注册列表
     * 
     * @param oaSystem 系统注册信息
     * @return 系统注册集合
     */
	public List<OaSystem> selectOaSystemList(OaSystem oaSystem);
	
	/**
     * 新增系统注册
     * 
     * @param oaSystem 系统注册信息
     * @return 结果
     */
	public int insertOaSystem(OaSystem oaSystem);
	
	/**
     * 修改系统注册
     * 
     * @param oaSystem 系统注册信息
     * @return 结果
     */
	public int updateOaSystem(OaSystem oaSystem);
	
	/**
     * 删除系统注册
     * 
     * @param id 系统注册ID
     * @return 结果
     */
	public int deleteOaSystemById(String id);
	
	/**
     * 批量删除系统注册
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteOaSystemByIds(String[] ids);
	
}