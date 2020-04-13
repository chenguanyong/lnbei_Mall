package com.lnbei.sp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lnbei.sp.mapper.SpCatShopsMapper;
import com.lnbei.sp.mapper.SpShopCatsMapper;
import com.lnbei.sp.mapper.SpShopExtrasMapper;
import com.lnbei.sp.mapper.SpShopUsersMapper;
import com.lnbei.sp.mapper.SpShopsMapper;
import com.lnbei.sp.domain.SpCatShops;
import com.lnbei.sp.domain.SpShopCats;
import com.lnbei.sp.domain.SpShopExtras;
import com.lnbei.sp.domain.SpShopUsers;
import com.lnbei.sp.domain.SpShops;
import com.lnbei.sp.service.ISpShopsService;
import com.lnbei.common.core.text.Convert;
import com.lnbei.common.utils.StringUtils;
import com.lnbei.home.domain.HomeCategory;
import com.lnbei.home.mapper.HomeCategoryMapper;
import com.lnbei.member.domain.MemberUser;
import com.lnbei.member.mapper.MemberUserMapper;
import com.lnbei.member.service.IMemberUserService;
import com.lnbei.member.service.impl.MemberUserServiceImpl;

/**
 * 店铺 服务层实现
 * 
 * @author lnbei
 * @date 2020-02-05
 */
@Service
public class SpShopsServiceImpl implements ISpShopsService 
{
	@Autowired
	private SpShopsMapper spShopsMapper;
	@Autowired
	private SpShopExtrasMapper SpShopExtrasMapper;
	@Autowired
	private SpShopCatsMapper SpShopCatsMapper;
	@Autowired
	private HomeCategoryMapper homeCategoryMapper;
	@Autowired
	private MemberUserMapper memberUserMapper;
	@Autowired
	private SpCatShopsMapper spCatShopsMapper;	
	
	@Autowired
	private SpShopUsersMapper spShopUsersMapper;
	/**
     * 查询店铺信息
     * 
     * @param mid 店铺ID
     * @return 店铺信息
     */
    @Override
	public SpShops selectSpShopsById(String mid)
	{
	    return spShopsMapper.selectSpShopsById(mid);
	}
	
	/**
     * 查询店铺列表
     * 
     * @param spShops 店铺信息
     * @return 店铺集合
     */
	@Override
	public List<SpShops> selectSpShopsList(SpShops spShops)
	{
	    return spShopsMapper.selectSpShopsList(spShops);
	}
	
    /**
     * 新增店铺
     * 
     * @param spShops 店铺信息
     * @return 结果
     */
	@Override
	public int insertSpShops(SpShops spShops, Object user)
	{
	    return spShopsMapper.insertSpShops(spShops);
	}
	
	/**
     * 修改店铺
     * 
     * @param spShops 店铺信息
     * @return 结果
     */
	@Override
	public int updateSpShops(SpShops spShops, Object user)
	{
	    return spShopsMapper.updateSpShops(spShops);
	}

	/**
     * 删除店铺对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSpShopsByIds(String ids)
	{
		return spShopsMapper.deleteSpShopsByIds(Convert.toStrArray(ids));
	}
	
	@Override
	public int updateSpShops(SpShops spShops, SpShopExtras mExtras, Object user) {
		
		String areaIdPath = spShops.getAreaIdPath();
		if(!StringUtils.isEmpty(areaIdPath)) {
			String[] areaIdPathArray = Convert.toStrArray(areaIdPath);
			spShops.setAreaId(areaIdPathArray[areaIdPathArray.length-1]);
		}
		String bankAreaidPath = spShops.getBankAreaidPath();
		if(!StringUtils.isEmpty(bankAreaidPath)) {
			String[] bankAreaidPathArray = Convert.toStrArray(bankAreaidPath);
			spShops.setBankAreaId(bankAreaidPathArray[bankAreaidPathArray.length-1]);
		}
		spShops.initUpdate(user);
		int r =spShopsMapper.updateSpShops(spShops);
		if(r!= 0) {
			mExtras.initUpdate(user);
			mExtras.setShopId(spShops.getMid());
			SpShopExtrasMapper.updateSpShopExtras(mExtras);
		}
		spCatShopsMapper.deleteSpCatShopsByShopId(spShops.getMid());
		
		String goodsCatIds = spShops.getGoodsCatIds();
		if(StringUtils.isEmpty(goodsCatIds) && r != 0) {
			
			String [] gooStringsArray = Convert.toStrArray(goodsCatIds);
			
			for (String string : gooStringsArray) {
				SpCatShops tempShopCats = new SpCatShops();
				//	tempShopCats.setCategoryId(string);
					tempShopCats.setCatId(string);
					tempShopCats.setShopId(spShops.getMid());
					tempShopCats.initInsert(user);
				spCatShopsMapper.insertSpCatShops(tempShopCats);
			}
			
		}
		return r;
	}

	@Override
	@Transactional
	public int createShop(MemberUser memberUser, SpShops spShops, SpShopExtras mExtras, Object user) {
		// TODO Auto-generated method stub
		String areaIdPath = spShops.getAreaIdPath();
		if(!StringUtils.isEmpty(areaIdPath)) {
			String[] areaIdPathArray = Convert.toStrArray(areaIdPath);
			spShops.setAreaId(areaIdPathArray[areaIdPathArray.length-1]);
		}
		String bankAreaidPath = spShops.getBankAreaidPath();
		if(!StringUtils.isEmpty(bankAreaidPath)) {
			String[] bankAreaidPathArray = Convert.toStrArray(bankAreaidPath);
			spShops.setBankAreaId(bankAreaidPathArray[bankAreaidPathArray.length-1]);
		}
		spShops.initInsert(user);
		int r =spShopsMapper.insertSpShops(spShops);
		if(r!= 0) {
			mExtras.initInsert(user);
			mExtras.setShopId(spShops.getMid());
			SpShopExtrasMapper.insertSpShopExtras(mExtras);
		}
		String goodsCatIds = spShops.getGoodsCatIds();
		if(StringUtils.isEmpty(goodsCatIds) && r != 0) {
			
			String [] gooStringsArray = Convert.toStrArray(goodsCatIds);
			
			for (String string : gooStringsArray) {
				SpCatShops tempShopCats = new SpCatShops();
			//	tempShopCats.setCategoryId(string);
				tempShopCats.setCatId(string);
				tempShopCats.setShopId(spShops.getMid());
				tempShopCats.initInsert(user);
				spCatShopsMapper.insertSpCatShops(tempShopCats);
			}
			
		}
		
		if(r != 0) {
			
			r = handleUser(memberUser, spShops , user);
		}
		
		return r;
	}
	
	protected int handleUser(MemberUser memberUser, SpShops shops, Object user) {
		MemberUser tMemberUser = memberUserMapper.selectUserByLoginName(memberUser.getLoginName());
		SpShopUsers mShopUsers = new SpShopUsers();
		mShopUsers.setMemberId(tMemberUser.getMid());
		mShopUsers.setShopId(shops.getMid());
		mShopUsers.initInsert(user);
		spShopUsersMapper.insertSpShopUsers(mShopUsers);
		MemberUser memberUser2 = new MemberUser();
		memberUser2.setMid(tMemberUser.getMid());
		memberUser2.setShopId(shops.getMid());
		memberUser2.setIsShoper("1");
		int r= memberUserMapper.updateMemberUser(memberUser2);//(tMemberUser, memberUser2)
		return r;
	}
}
