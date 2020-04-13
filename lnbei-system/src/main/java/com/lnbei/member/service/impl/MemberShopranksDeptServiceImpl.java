package com.lnbei.member.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnbei.member.mapper.MemberShopranksDeptMapper;
import com.lnbei.member.domain.MemberShopranksDept;
import com.lnbei.member.service.IMemberShopranksDeptService;
import com.lnbei.common.core.text.Convert;

/**
 * 商户角色和部门关联 服务层实现
 * 
 * @author lnbei
 * @date 2020-03-05
 */
@Service
public class MemberShopranksDeptServiceImpl implements IMemberShopranksDeptService 
{
	@Autowired
	private MemberShopranksDeptMapper memberShopranksDeptMapper;

	/**
     * 查询商户角色和部门关联信息
     * 
     * @param ranksId 商户角色和部门关联ID
     * @return 商户角色和部门关联信息
     */
    @Override
	public MemberShopranksDept selectMemberShopranksDeptById(String ranksId)
	{
	    return memberShopranksDeptMapper.selectMemberShopranksDeptById(ranksId);
	}
	
	/**
     * 查询商户角色和部门关联列表
     * 
     * @param memberShopranksDept 商户角色和部门关联信息
     * @return 商户角色和部门关联集合
     */
	@Override
	public List<MemberShopranksDept> selectMemberShopranksDeptList(MemberShopranksDept memberShopranksDept)
	{
	    return memberShopranksDeptMapper.selectMemberShopranksDeptList(memberShopranksDept);
	}
	
    /**
     * 新增商户角色和部门关联
     * 
     * @param memberShopranksDept 商户角色和部门关联信息
     * @return 结果
     */
	@Override
	public int insertMemberShopranksDept(MemberShopranksDept memberShopranksDept)
	{
	    return memberShopranksDeptMapper.insertMemberShopranksDept(memberShopranksDept);
	}
	
	/**
     * 修改商户角色和部门关联
     * 
     * @param memberShopranksDept 商户角色和部门关联信息
     * @return 结果
     */
	@Override
	public int updateMemberShopranksDept(MemberShopranksDept memberShopranksDept)
	{
	    return memberShopranksDeptMapper.updateMemberShopranksDept(memberShopranksDept);
	}

	/**
     * 删除商户角色和部门关联对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteMemberShopranksDeptByIds(String ids)
	{
		return memberShopranksDeptMapper.deleteMemberShopranksDeptByIds(Convert.toStrArray(ids));
	}
	
}
