package com.lnbei.member.mapper;

import com.lnbei.member.domain.MemberUser;
import com.lnbei.member.domain.MemberUserRanks;
import java.util.List;

import org.apache.ibatis.annotations.Param;	

/**
 * 会员等级 数据层
 * 
 * @author lnbei
 * @date 2020-01-24
 */
public interface MemberUserRanksMapper 
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
	public int insertMemberUserRanks(MemberUserRanks memberUserRanks);
	
	/**
     * 修改会员等级
     * 
     * @param memberUserRanks 会员等级信息
     * @return 结果
     */
	public int updateMemberUserRanks(MemberUserRanks memberUserRanks);
	
	/**
     * 删除会员等级
     * 
     * @param mid 会员等级ID
     * @return 结果
     */
	public int deleteMemberUserRanksById(String mid);
	
	/**
     * 批量删除会员等级
     * 
     * @param mids 需要删除的数据ID
     * @return 结果
     */
	public int deleteMemberUserRanksByIds(String[] mids);
	
	/**
	 * 根据用户身份查询角色
	 * @param memberId
	 * @param identity
	 * @return
	 */
	public List<MemberUserRanks> selectRanksByMemberIdAndIdentity(@Param("memberId") String memberId, @Param("identity") String identity);
	

	
}