package com.lnbei.sp.mapper;

import com.lnbei.sp.domain.SpShopRoles;
import java.util.List;	

/**
 * 商家角色 数据层
 * 
 * @author lnbei
 * @date 2020-02-05
 */
public interface SpShopRolesMapper 
{
	/**
     * 查询商家角色信息
     * 
     * @param mid 商家角色ID
     * @return 商家角色信息
     */
	public SpShopRoles selectSpShopRolesById(String mid);
	
	/**
     * 查询商家角色列表
     * 
     * @param spShopRoles 商家角色信息
     * @return 商家角色集合
     */
	public List<SpShopRoles> selectSpShopRolesList(SpShopRoles spShopRoles);
	
	/**
     * 新增商家角色
     * 
     * @param spShopRoles 商家角色信息
     * @return 结果
     */
	public int insertSpShopRoles(SpShopRoles spShopRoles);
	
	/**
     * 修改商家角色
     * 
     * @param spShopRoles 商家角色信息
     * @return 结果
     */
	public int updateSpShopRoles(SpShopRoles spShopRoles);
	
	/**
     * 删除商家角色
     * 
     * @param mid 商家角色ID
     * @return 结果
     */
	public int deleteSpShopRolesById(String mid);
	
	/**
     * 批量删除商家角色
     * 
     * @param mids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSpShopRolesByIds(String[] mids);
	
}