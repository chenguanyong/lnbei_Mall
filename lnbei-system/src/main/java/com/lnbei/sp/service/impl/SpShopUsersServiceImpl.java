package com.lnbei.sp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnbei.sp.mapper.SpShopUsersMapper;
import com.lnbei.sp.domain.SpShopUsers;
import com.lnbei.sp.service.ISpShopUsersService;
import com.lnbei.common.core.text.Convert;

/**
 * 店铺用户关系 服务层实现
 * 
 * @author lnbei
 * @date 2020-02-05
 */
@Service
public class SpShopUsersServiceImpl implements ISpShopUsersService 
{
	@Autowired
	private SpShopUsersMapper spShopUsersMapper;

	/**
     * 查询店铺用户关系信息
     * 
     * @param mid 店铺用户关系ID
     * @return 店铺用户关系信息
     */
    @Override
	public SpShopUsers selectSpShopUsersById(String mid)
	{
	    return spShopUsersMapper.selectSpShopUsersById(mid);
	}
	
	/**
     * 查询店铺用户关系列表
     * 
     * @param spShopUsers 店铺用户关系信息
     * @return 店铺用户关系集合
     */
	@Override
	public List<SpShopUsers> selectSpShopUsersList(SpShopUsers spShopUsers)
	{
	    return spShopUsersMapper.selectSpShopUsersList(spShopUsers);
	}
	
    /**
     * 新增店铺用户关系
     * 
     * @param spShopUsers 店铺用户关系信息
     * @return 结果
     */
	@Override
	public int insertSpShopUsers(SpShopUsers spShopUsers)
	{
	    return spShopUsersMapper.insertSpShopUsers(spShopUsers);
	}
	
	/**
     * 修改店铺用户关系
     * 
     * @param spShopUsers 店铺用户关系信息
     * @return 结果
     */
	@Override
	public int updateSpShopUsers(SpShopUsers spShopUsers)
	{
	    return spShopUsersMapper.updateSpShopUsers(spShopUsers);
	}

	/**
     * 删除店铺用户关系对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSpShopUsersByIds(String ids)
	{
		return spShopUsersMapper.deleteSpShopUsersByIds(Convert.toStrArray(ids));
	}
	
}
