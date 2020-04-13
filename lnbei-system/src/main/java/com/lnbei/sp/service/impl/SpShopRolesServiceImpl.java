package com.lnbei.sp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnbei.sp.mapper.SpShopRolesMapper;
import com.lnbei.sp.domain.SpShopRoles;
import com.lnbei.sp.service.ISpShopRolesService;
import com.lnbei.common.core.text.Convert;

/**
 * 商家角色 服务层实现
 * 
 * @author lnbei
 * @date 2020-02-05
 */
@Service
public class SpShopRolesServiceImpl implements ISpShopRolesService 
{
	@Autowired
	private SpShopRolesMapper spShopRolesMapper;

	/**
     * 查询商家角色信息
     * 
     * @param mid 商家角色ID
     * @return 商家角色信息
     */
    @Override
	public SpShopRoles selectSpShopRolesById(String mid)
	{
	    return spShopRolesMapper.selectSpShopRolesById(mid);
	}
	
	/**
     * 查询商家角色列表
     * 
     * @param spShopRoles 商家角色信息
     * @return 商家角色集合
     */
	@Override
	public List<SpShopRoles> selectSpShopRolesList(SpShopRoles spShopRoles)
	{
	    return spShopRolesMapper.selectSpShopRolesList(spShopRoles);
	}
	
    /**
     * 新增商家角色
     * 
     * @param spShopRoles 商家角色信息
     * @return 结果
     */
	@Override
	public int insertSpShopRoles(SpShopRoles spShopRoles)
	{
	    return spShopRolesMapper.insertSpShopRoles(spShopRoles);
	}
	
	/**
     * 修改商家角色
     * 
     * @param spShopRoles 商家角色信息
     * @return 结果
     */
	@Override
	public int updateSpShopRoles(SpShopRoles spShopRoles)
	{
	    return spShopRolesMapper.updateSpShopRoles(spShopRoles);
	}

	/**
     * 删除商家角色对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSpShopRolesByIds(String ids)
	{
		return spShopRolesMapper.deleteSpShopRolesByIds(Convert.toStrArray(ids));
	}
	
}
