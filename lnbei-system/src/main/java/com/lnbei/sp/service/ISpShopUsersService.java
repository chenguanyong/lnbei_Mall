package com.lnbei.sp.service;

import com.lnbei.sp.domain.SpShopUsers;
import java.util.List;

/**
 * 店铺用户关系 服务层
 * 
 * @author lnbei
 * @date 2020-02-05
 */
public interface ISpShopUsersService 
{
	/**
     * 查询店铺用户关系信息
     * 
     * @param mid 店铺用户关系ID
     * @return 店铺用户关系信息
     */
	public SpShopUsers selectSpShopUsersById(String mid);
	
	/**
     * 查询店铺用户关系列表
     * 
     * @param spShopUsers 店铺用户关系信息
     * @return 店铺用户关系集合
     */
	public List<SpShopUsers> selectSpShopUsersList(SpShopUsers spShopUsers);
	
	/**
     * 新增店铺用户关系
     * 
     * @param spShopUsers 店铺用户关系信息
     * @return 结果
     */
	public int insertSpShopUsers(SpShopUsers spShopUsers);
	
	/**
     * 修改店铺用户关系
     * 
     * @param spShopUsers 店铺用户关系信息
     * @return 结果
     */
	public int updateSpShopUsers(SpShopUsers spShopUsers);
		
	/**
     * 删除店铺用户关系信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSpShopUsersByIds(String ids);
	
}
