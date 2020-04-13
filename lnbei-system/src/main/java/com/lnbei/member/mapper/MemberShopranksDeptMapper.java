package com.lnbei.member.mapper;

import com.lnbei.member.domain.MemberShopranksDept;
import java.util.List;	

/**
 * 商户角色和部门关联 数据层
 * 
 * @author lnbei
 * @date 2020-03-05
 */
public interface MemberShopranksDeptMapper 
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
     * 删除商户角色和部门关联
     * 
     * @param ranksId 商户角色和部门关联ID
     * @return 结果
     */
	public int deleteMemberShopranksDeptById(String ranksId);
	
	/**
     * 批量删除商户角色和部门关联
     * 
     * @param ranksIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteMemberShopranksDeptByIds(String[] ranksIds);
    /**
     * 批量新增角色部门信息
     * 
     * @param roleDeptList 角色部门列表
     * @return 结果
     */
    public int batchRoleDept(List<MemberShopranksDept> roleDeptList);
}