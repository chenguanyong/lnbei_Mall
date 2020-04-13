package com.lnbei.member.service;

import com.lnbei.member.domain.MemberRanksUser;
import java.util.List;

/**
 * 会员与级别关系i 服务层
 * 
 * @author lnbei
 * @date 2020-02-26
 */
public interface IMemberRanksUserService 
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
     * 删除会员与级别关系i信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteMemberRanksUserByIds(String ids);
	
	public int insertAuthUsers(String ranksId, String userIds);
}
