package com.lnbei.member.service;

import com.lnbei.member.domain.MemberShopranksDept;
import java.util.List;

/**
 * 商户角色和部门关联 服务层
 * 
 * @author lnbei
 * @date 2020-03-05
 */
public interface IMemberShopranksDeptService 
{
	/**
     * 查询商户角色和部门关联信息
     * 
     * @param ranksId 商户角色和部门关联ID
     * @return 商户角色和部门关联信息
     */
	public MemberShopranksDept selectMemberShopranksDeptById(String ranksId);
	
	/**
     * 查询商户角色和部门关联列表
     * 
     * @param memberShopranksDept 商户角色和部门关联信息
     * @return 商户角色和部门关联集合
     */
	public List<MemberShopranksDept> selectMemberShopranksDeptList(MemberShopranksDept memberShopranksDept);
	
	/**
     * 新增商户角色和部门关联
     * 
     * @param memberShopranksDept 商户角色和部门关联信息
     * @return 结果
     */
	public int insertMemberShopranksDept(MemberShopranksDept memberShopranksDept);
	
	/**
     * 修改商户角色和部门关联
     * 
     * @param memberShopranksDept 商户角色和部门关联信息
     * @return 结果
     */
	public int updateMemberShopranksDept(MemberShopranksDept memberShopranksDept);
		
	/**
     * 删除商户角色和部门关联信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteMemberShopranksDeptByIds(String ids);
	
}
