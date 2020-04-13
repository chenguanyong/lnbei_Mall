package com.lnbei.member.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lnbei.member.mapper.MemberUserMapper;
import com.lnbei.member.domain.MemberUser;
import com.lnbei.member.service.IMemberUserService;

import com.lnbei.common.core.text.Convert;
import com.lnbei.common.utils.StringUtils;
import com.lnbei.exception.ObjectNullExecption;

/**
 * 会员 服务层实现
 * 
 * @author lnbei
 * @date 2020-01-24
 */
@Service
public class MemberUserServiceImpl implements IMemberUserService 
{
	@Autowired
	private MemberUserMapper memberUserMapper;

	/**
     * 查询会员信息
     * 
     * @param mid 会员ID
     * @return 会员信息
     */
    @Override
	public MemberUser selectMemberUserById(String mid)
	{
	    return memberUserMapper.selectMemberUserById(mid);
	}
	
	/**
     * 查询会员列表
     * 
     * @param memberUser 会员信息
     * @return 会员集合
     */
	@Override
	public List<MemberUser> selectMemberUserList(MemberUser memberUser)
	{
	    return memberUserMapper.selectMemberUserList(memberUser);
	}
	
    /**
     * 新增会员
     * 
     * @param memberUser 会员信息
     * @return 结果
     */
	@Override
	@Transactional
	public int insertMemberUser(MemberUser memberUser, Object user) throws ObjectNullExecption
	{
		String serialNumber = memberUser.getSerialNumber();
		
		String recommendNumber = memberUser.getRecommendNumber();
		if(StringUtils.isEmpty(serialNumber)) {
			memberUser.setSerialNumber(StringUtils.createMemberNUM());
		}
        memberUser.setLoginPwd(StringUtils.toMd5String(memberUser.getLoginPwd()));
        memberUser.setPayPwd(memberUser.getLoginPwd());
		if(!checkHaveUser()) {
			if(StringUtils.isEmpty(recommendNumber)) {
				memberUser.setRecommendNumber("M0000001");
			}

			memberUser.setParentId("0");
			memberUser.setGrandfatherId("0");
			memberUser.setDirectPath("0");
			memberUser.setNodePath("0");
			memberUser.setPath("0");
		}else {
			MemberUser recommMemberUser = null;
			MemberUser recommMemberUserUpdate = new MemberUser();
			if(StringUtils.isEmpty(recommendNumber)) {
				memberUser.setRecommendNumber("M0000001");
			}
		
			recommMemberUser = memberUserMapper.selectMemberUserBySerialNumber(memberUser.getRecommendNumber());
			if(recommMemberUser == null) {
				throw new ObjectNullExecption("推荐人不存在");
			}
			
			memberUser.setDepth(recommMemberUser.getDepth()+1);//深度
			memberUser.setPath(recommMemberUser.getPath()+"-"+recommMemberUser.getMid());
			memberUser.setDirectPath(recommMemberUser.getPath()+"-"+recommMemberUser.getMid());
			memberUser.setParentId(recommMemberUser.getMid());
			recommMemberUserUpdate.setZtSize(recommMemberUser.getZtSize()+1);
			recommMemberUserUpdate.setMid(recommMemberUser.getMid());
			recommMemberUserUpdate.setChildCnt(recommMemberUser.getChildCnt()+1);
			recommMemberUserUpdate.initUpdate(user);
			memberUserMapper.updateMemberUser(recommMemberUserUpdate);
		}
		memberUser.initInsert(user);
	    return memberUserMapper.insertMemberUser(memberUser);
	}
	/**
	 * 批量添加会员
	 * @param memberUser
	 * @param user
	 * @return
	 * @throws ObjectNullExecption
	 */
	@Override
	@Transactional
	public int insertsMemberUser(MemberUser memberUser,Integer userSize, Object user) throws ObjectNullExecption
	{
		 int result = 0;
		String serialNumber = memberUser.getSerialNumber();
		
		String recommendNumber = memberUser.getRecommendNumber();
		if(StringUtils.isEmpty(serialNumber)) {
			memberUser.setSerialNumber(StringUtils.createMemberNUM());
		}
       // memberUser.setLoginPwd(StringUtils.toMd5String(memberUser.getLoginPwd()));
       // memberUser.setPayPwd(memberUser.getLoginPwd());
    	memberUser.setLoginName(StringUtils.getRandomString(6));
		memberUser.setLoginPwd(StringUtils.toMd5String("123456"));//(StringUtils.getRandomString(6));
		memberUser.setPayPwd(memberUser.getLoginPwd());
		
		for (int i = 0; i < userSize; i++) {
			
			if(!checkHaveUser()) {
				if(StringUtils.isEmpty(recommendNumber)) {
					memberUser.setRecommendNumber("M0000001");
				}
			
				memberUser.setParentId("0");
				memberUser.setGrandfatherId("0");
				memberUser.setDirectPath("0");
				memberUser.setNodePath("0");
				memberUser.setPath("0");
			}else {
				MemberUser recommMemberUser = null;
				MemberUser recommMemberUserUpdate = new MemberUser();
				if(StringUtils.isEmpty(recommendNumber)) {
					memberUser.setRecommendNumber("M0000001");
				}
			
				recommMemberUser = memberUserMapper.selectMemberUserBySerialNumber(memberUser.getRecommendNumber());
				if(recommMemberUser == null) {
					throw new ObjectNullExecption("推荐人不存在");
				}
				
				memberUser.setDepth(recommMemberUser.getDepth()+1);//深度
				memberUser.setPath(recommMemberUser.getPath()+"-"+recommMemberUser.getMid());
				memberUser.setDirectPath(recommMemberUser.getPath()+"-"+recommMemberUser.getMid());
				memberUser.setParentId(recommMemberUser.getMid());
				recommMemberUserUpdate.setZtSize(recommMemberUser.getZtSize()+1);
				recommMemberUserUpdate.setMid(recommMemberUser.getMid());
				recommMemberUserUpdate.setChildCnt(recommMemberUser.getChildCnt()+1);
				recommMemberUserUpdate.initUpdate(user);
				memberUserMapper.updateMemberUser(recommMemberUserUpdate);
			}
			memberUser.initInsert(user);
		    result =  memberUserMapper.insertMemberUser(memberUser);
		}
		 return result;
	}	
	/**
     * 修改会员
     * 
     * @param memberUser 会员信息
     * @return 结果
     */
	@Override
	public int updateMemberUser(MemberUser memberUser, Object user)
	{
		memberUser.initUpdate(user);
	    return memberUserMapper.updateMemberUser(memberUser);
	}
	/**
     * 修改会员
     * 
     * @param memberUser 会员信息
     * @return 结果
     */
	@Override
	public int activateMemberUser(MemberUser memberUser, Object user)
	{
		memberUser = new MemberUser();
		List<MemberUser> memberUsers = memberUserMapper.selectMemberUserList(memberUser);
		for (MemberUser memberUser2 : memberUsers) {
			memberUser.setMid(memberUser2.getMid());
			memberUser.setUserStatus("1");
			memberUserMapper.updateMemberUser(memberUser);
		}
	    return 1;
	}
	/**
     * 删除会员对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteMemberUserByIds(String ids)
	{
		return memberUserMapper.deleteMemberUserByIds(Convert.toStrArray(ids));
	}
	/**
	 * 通过用户名查询用户
	 * 
	 * @param userName 用户名
	 * @return 用户对象信息
	 */
	@Override
	public MemberUser selectUserByLoginName(String userName) {
		return memberUserMapper.selectUserByLoginName(userName);
	}

	/**
	 * 通过手机号码查询用户
	 * 
	 * @param phoneNumber 手机号码
	 * @return 用户对象信息
	 */
	@Override
	public MemberUser selectUserByPhoneNumber(String phoneNumber) {
		return memberUserMapper.selectUserByPhoneNumber(phoneNumber);
	}

	/**
	 * 通过邮箱查询用户
	 * 
	 * @param email 邮箱
	 * @return 用户对象信息
	 */
	@Override
	public MemberUser selectUserByEmail(String email) {
		return memberUserMapper.selectUserByEmail(email);
	}

	@Override
	public MemberUser selectMemberUserBySerialNumber(String serialNumber) {
		// TODO Auto-generated method stub
		return memberUserMapper.selectMemberUserBySerialNumber(serialNumber);
	}
	/**
	 * 查询数据库中有多少个会员
	 * @return
	 */
	public Integer selectMemberUserCount() {
		return memberUserMapper.selectMemberUserCount();
	}
	/**
	 * 检查是否有会员
	 * @return
	 */
	private boolean checkHaveUser() {
		Integer mUserInteger = memberUserMapper.selectMemberUserCount();
		if(mUserInteger != 0) {
			return true;
		}
		return false;
	}
	/**
	 * 激活会员
	 * @param memberUser
	 * @return
	 */
	@Override
	public int activateMemberUser(MemberUser memberUser) {
		return memberUserMapper.activateMemberUser(memberUser);
	}
	/**
	 * 重置密码
	 * @param memberUser
	 * @return
	 */
	@Override
	public int resetMemberUserPaw(MemberUser memberUser) {
		return memberUserMapper.resetMemberUserPaw(memberUser);
	}
	/**
	 * 查询角色下的用户
	 */
	@Override
	public List<MemberUser> selectAllocatedList(MemberUser memberUser){
		return memberUserMapper.selectAllocatedList(memberUser);
	}
	/**
	 * 查询非角色下的用户
	 */
	@Override
	public List<MemberUser> selectUnallocatedList(MemberUser memberUser){
		
		return memberUserMapper.selectUnallocatedList(memberUser);
	}

	@Override
	public List<MemberUser> selectAllocatedShopList(MemberUser memberUser) {
		// TODO Auto-generated method stub
		return memberUserMapper.selectAllocatedShopList(memberUser);
	}

	@Override
	public List<MemberUser> selectUnallocatedShopList(MemberUser memberUser) {
		// TODO Auto-generated method stub
		return memberUserMapper.selectUnallocatedShopList(memberUser);
	}
}
