package com.lnbei.member.service;

import com.lnbei.member.domain.MemberUser;


import java.util.List;

/**
 * 会员 服务层
 * 
 * @author lnbei
 * @date 2020-01-24
 */
public interface IMemberUserService 
{
	/**
     * 查询会员信息
     * 
     * @param mid 会员ID
     * @return 会员信息
     */
	public MemberUser selectMemberUserById(String mid);
	
	/**
     * 查询会员列表
     * 
     * @param memberUser 会员信息
     * @return 会员集合
     */
	public List<MemberUser> selectMemberUserList(MemberUser memberUser);
	
	/**
     * 新增会员
     * 
     * @param memberUser 会员信息
     * @return 结果
     */
	public int insertMemberUser(MemberUser memberUser, Object user);
	
	/**
     * 修改会员
     * 
     * @param memberUser 会员信息
     * @return 结果
     */
	public int updateMemberUser(MemberUser memberUser, Object user);
		
	/**
     * 删除会员信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteMemberUserByIds(String ids);
	/**
	 * 通过用户名查询用户
	 * 
	 * @param userName 用户名
	 * @return 用户对象信息
	 */
	public MemberUser selectUserByLoginName(String userName);

	/**
	 * 通过手机号码查询用户
	 * 
	 * @param phoneNumber 手机号码
	 * @return 用户对象信息
	 */
	public MemberUser selectUserByPhoneNumber(String phoneNumber);

	/**
	 * 通过邮箱查询用户
	 * 
	 * @param email 邮箱
	 * @return 用户对象信息
	 */
	public MemberUser selectUserByEmail(String email);
	
	/**
	 * 通过编号查询用户
	 * @param recommonNumber
	 * @return
	 */
	public MemberUser selectMemberUserBySerialNumber(String serialNumber);
	
	/**
	 * 查询数据库中有多少个会员
	 * @return
	 */
	public Integer selectMemberUserCount();
	/**
	 * 批量添加会员
	 * @param memberUser
	 * @param userSize
	 * @param user
	 * @return
	 */
	public int insertsMemberUser(MemberUser memberUser,Integer userSize, Object user);
	/**
	 * 激活会员
	 * @param memberUser
	 * @param user
	 * @return
	 */
	public int activateMemberUser(MemberUser memberUser, Object user);
	
	/**
	 * 激活会员
	 * @param memberUser
	 * @return
	 */
	public int activateMemberUser(MemberUser memberUser);
	/**
	 * 重置密码
	 * @param memberUser
	 * @return
	 */
	public int resetMemberUserPaw(MemberUser memberUser);
	/**
	 * 查询指定角色下的用户
	 * @param memberUser
	 * @return
	 */
	public List<MemberUser> selectAllocatedList(MemberUser memberUser);
	/**
	 * 查询指定角色下的未分配用户
	 * @param memberUser
	 * @return
	 */
	public List<MemberUser> selectUnallocatedList(MemberUser memberUser);
	/**
	 * 查询指定角色下的商家用户
	 * @param memberUser
	 * @return
	 */
	public List<MemberUser> selectAllocatedShopList(MemberUser memberUser);
	/**
	 * 查询指定角色下的未分配商户
	 * @param memberUser
	 * @return
	 */
	public List<MemberUser> selectUnallocatedShopList(MemberUser memberUser);	
}
