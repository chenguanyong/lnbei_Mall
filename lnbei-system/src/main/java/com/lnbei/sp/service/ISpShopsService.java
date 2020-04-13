package com.lnbei.sp.service;

import com.lnbei.member.domain.MemberUser;
import com.lnbei.sp.domain.SpShopExtras;
import com.lnbei.sp.domain.SpShops;
import java.util.List;

/**
 * 店铺 服务层
 * 
 * @author lnbei
 * @date 2020-02-05
 */
public interface ISpShopsService {
	/**
	 * 查询店铺信息
	 * 
	 * @param mid 店铺ID
	 * @return 店铺信息
	 */
	public SpShops selectSpShopsById(String mid);

	/**
	 * 查询店铺列表
	 * 
	 * @param spShops 店铺信息
	 * @return 店铺集合
	 */
	public List<SpShops> selectSpShopsList(SpShops spShops);

	/**
	 * 新增店铺
	 * 
	 * @param spShops 店铺信息
	 * @return 结果
	 */
	public int insertSpShops(SpShops spShops, Object user);

	/**
	 * 修改店铺
	 * 
	 * @param spShops 店铺信息
	 * @return 结果
	 */
	public int updateSpShops(SpShops spShops, Object user);

	/**
	 * 删除店铺信息
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	public int deleteSpShopsByIds(String ids);

	/**
	 * 创建商铺
	 * 
	 * @param spShops
	 * @param mExtras
	 * @param user
	 * @return
	 */
	public int createShop(MemberUser memberUser, SpShops spShops, SpShopExtras mExtras, Object user);
	/**
	 * 更新店铺
	 * @param spShops
	 * @param mExtras
	 * @param user
	 * @return
	 */
	public int updateSpShops(SpShops spShops, SpShopExtras mExtras, Object user) ;
}
