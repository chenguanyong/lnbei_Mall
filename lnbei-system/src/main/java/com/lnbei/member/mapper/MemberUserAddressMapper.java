package com.lnbei.member.mapper;

import com.lnbei.member.domain.MemberUserAddress;
import java.util.List;	

/**
 * 会员地址 数据层
 * 
 * @author lnbei
 * @date 2020-01-24
 */
public interface MemberUserAddressMapper 
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
	public int insertMemberUserAddress(MemberUserAddress memberUserAddress);
	
	/**
     * 修改会员地址
     * 
     * @param memberUserAddress 会员地址信息
     * @return 结果
     */
	public int updateMemberUserAddress(MemberUserAddress memberUserAddress);
	
	/**
     * 删除会员地址
     * 
     * @param mid 会员地址ID
     * @return 结果
     */
	public int deleteMemberUserAddressById(String mid);
	
	/**
     * 批量删除会员地址
     * 
     * @param mids 需要删除的数据ID
     * @return 结果
     */
	public int deleteMemberUserAddressByIds(String[] mids);
	
}