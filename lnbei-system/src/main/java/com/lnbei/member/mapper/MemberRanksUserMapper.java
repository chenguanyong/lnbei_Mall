package com.lnbei.member.mapper;

import com.lnbei.member.domain.MemberRanksUser;
import java.util.List;	

/**
 * 会员与级别关系i 数据层
 * 
 * @author lnbei
 * @date 2020-02-26
 */
public interface MemberRanksUserMapper 
{
	/**
     * 查询会员与级别关系i信息
     * 
     * @param mid 会员与级别关系iID
     * @return 会员与级别关系i信息
     */
	public MemberRanksUser selectMemberRanksUserById(String mid);
	
	/**
     * 查询会员与级别关系i列表
     * 
     * @param memberRanksUser 会员与级别关系i信息
     * @return 会员与级别关系i集合
     */
	public List<MemberRanksUser> selectMemberRanksUserList(MemberRanksUser memberRanksUser);
	
	/**
     * 新增会员与级别关系i
     * 
     * @param memberRanksUser 会员与级别关系i信息
     * @return 结果
     */
	public int insertMemberRanksUser(MemberRanksUser memberRanksUser);
	
	/**
     * 修改会员与级别关系i
     * 
     * @param memberRanksUser 会员与级别关系i信息
     * @return 结果
     */
	public int updateMemberRanksUser(MemberRanksUser memberRanksUser);
	
	/**
     * 删除会员与级别关系i
     * 
     * @param mid 会员与级别关系iID
     * @return 结果
     */
	public int deleteMemberRanksUserById(String mid);
	
	/**
     * 批量删除会员与级别关系i
     * 
     * @param mids 需要删除的数据ID
     * @return 结果
     */
	public int deleteMemberRanksUserByIds(String[] mids);
	
	public int deleteUserRoleInfo(MemberRanksUser memberRanksUser);
	public int deleteUserRoleInfos(String ranksId, String[] memberId);
}