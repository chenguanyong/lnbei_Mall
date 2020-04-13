package com.lnbei.member.service;

import com.lnbei.member.domain.MemberUserAddress;
import java.util.List;

/**
 * 会员地址 服务层
 * 
 * @author lnbei
 * @date 2020-01-24
 */
public interface IMemberUserAddressService 
{
	/**
     * 查询会员地址信息
     * 
     * @param mid 会员地址ID
     * @return 会员地址信息
     */
	public MemberUserAddress selectMemberUserAddressById(String mid);
	
	/**
     * 查询会员地址列表
     * 
     * @param memberUserAddress 会员地址信息
     * @return 会员地址集合
     */
	public List<MemberUserAddress> selectMemberUserAddressList(MemberUserAddress memberUserAddress);
	
	/**
     * 新增会员地址
     * 
     * @param memberUserAddress 会员地址信息
     * @return 结果
     */
	public int insertMemberUserAddress(MemberUserAddress memberUserAddress, Object user);
	
	/**
     * 修改会员地址
     * 
     * @param memberUserAddress 会员地址信息
     * @return 结果
     */
	public int updateMemberUserAddress(MemberUserAddress memberUserAddress, Object user);
		
	/**
     * 删除会员地址信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteMemberUserAddressByIds(String ids);
	
}
