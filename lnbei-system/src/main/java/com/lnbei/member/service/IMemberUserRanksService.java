package com.lnbei.member.service;

import com.lnbei.member.domain.MemberRanksUser;
import com.lnbei.member.domain.MemberUserRanks;
import java.util.List;
import java.util.Set;

/**
 * 会员等级 服务层
 * 
 * @author lnbei
 * @date 2020-01-24
 */
public interface IMemberUserRanksService 
{
	/**
     * 查询会员等级信息
     * 
     * @param mid 会员等级ID
     * @return 会员等级信息
     */
	public MemberUserRanks selectMemberUserRanksById(String mid);
	
	/**
     * 查询会员等级列表
     * 
     * @param memberUserRanks 会员等级信息
     * @return 会员等级集合
     */
	public List<MemberUserRanks> selectMemberUserRanksList(MemberUserRanks memberUserRanks);
	
	/**
     * 新增会员等级
     * 
     * @param memberUserRanks 会员等级信息
     * @return 结果
     */
	public int insertMemberUserRanks(MemberUserRanks memberUserRanks, Object user);
	
	/**
     * 修改会员等级
     * 
     * @param memberUserRanks 会员等级信息
     * @return 结果
     */
	public int updateMemberUserRanks(MemberUserRanks memberUserRanks, Object user);
		
	/**
     * 删除会员等级信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteMemberUserRanksByIds(String ids);
	
	public Set<String> selectRanksKeys(String memberId, String identity);
	
    /**
     * 取消授权用户角色
     * 
     * @param userRole 用户和角色关联信息
     * @return 结果
     */

    public int deleteAuthUser(MemberRanksUser ranksUser);
   

    /**
     * 批量取消授权用户角色
     * 
     * @param roleId 角色ID
     * @param userIds 需要删除的用户数据ID
     * @return 结果
     */

    public int deleteAuthUsers(String roleId, String userIds);
}
