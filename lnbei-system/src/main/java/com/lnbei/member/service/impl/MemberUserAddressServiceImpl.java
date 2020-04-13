package com.lnbei.member.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnbei.member.mapper.MemberUserAddressMapper;
import com.lnbei.member.domain.MemberUserAddress;
import com.lnbei.member.service.IMemberUserAddressService;
import com.lnbei.common.core.text.Convert;

/**
 * 会员地址 服务层实现
 * 
 * @author lnbei
 * @date 2020-01-24
 */
@Service
public class MemberUserAddressServiceImpl implements IMemberUserAddressService 
{
	@Autowired
	private MemberUserAddressMapper memberUserAddressMapper;

	/**
     * 查询会员地址信息
     * 
     * @param mid 会员地址ID
     * @return 会员地址信息
     */
    @Override
	public MemberUserAddress selectMemberUserAddressById(String mid)
	{
	    return memberUserAddressMapper.selectMemberUserAddressById(mid);
	}
	
	/**
     * 查询会员地址列表
     * 
     * @param memberUserAddress 会员地址信息
     * @return 会员地址集合
     */
	@Override
	public List<MemberUserAddress> selectMemberUserAddressList(MemberUserAddress memberUserAddress)
	{
	    return memberUserAddressMapper.selectMemberUserAddressList(memberUserAddress);
	}
	
    /**
     * 新增会员地址
     * 
     * @param memberUserAddress 会员地址信息
     * @return 结果
     */
	@Override
	public int insertMemberUserAddress(MemberUserAddress memberUserAddress, Object user)
	{
		memberUserAddress.initInsert(user);
	    return memberUserAddressMapper.insertMemberUserAddress(memberUserAddress);
	}
	
	/**
     * 修改会员地址
     * 
     * @param memberUserAddress 会员地址信息
     * @return 结果
     */
	@Override
	public int updateMemberUserAddress(MemberUserAddress memberUserAddress, Object user)
	{
		memberUserAddress.initUpdate(user);
	    return memberUserAddressMapper.updateMemberUserAddress(memberUserAddress);
	}

	/**
     * 删除会员地址对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteMemberUserAddressByIds(String ids)
	{
		return memberUserAddressMapper.deleteMemberUserAddressByIds(Convert.toStrArray(ids));
	}
	
}
