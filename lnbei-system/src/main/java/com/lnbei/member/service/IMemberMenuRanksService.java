package com.lnbei.member.service;

import com.lnbei.member.domain.MemberMenuRanks;
import java.util.List;

/**
 * 等级关系i 服务层
 * 
 * @author lnbei
 * @date 2020-02-26
 */
public interface IMemberMenuRanksService 
{
	/**
     * 查询等级关系i信息
     * 
     * @param mid 等级关系iID
     * @return 等级关系i信息
     */
	public MemberMenuRanks selectMemberMenuRanksById(String mid);
	
	/**
     * 查询等级关系i列表
     * 
     * @param memberMenuRanks 等级关系i信息
     * @return 等级关系i集合
     */
	public List<MemberMenuRanks> selectMemberMenuRanksList(MemberMenuRanks memberMenuRanks);
	
	/**
     * 新增等级关系i
     * 
     * @param memberMenuRanks 等级关系i信息
     * @return 结果
     */
	public int insertMemberMenuRanks(MemberMenuRanks memberMenuRanks);
	
	/**
     * 修改等级关系i
     * 
     * @param memberMenuRanks 等级关系i信息
     * @return 结果
     */
	public int updateMemberMenuRanks(MemberMenuRanks memberMenuRanks);
		
	/**
     * 删除等级关系i信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteMemberMenuRanksByIds(String ids);
	/**
     * 根据用户等级ID删除等级与菜单的关系
     * 
     * @param mids 需要删除的数据ID
     * @return 结果
     */	
	public int deleteMemberMenuRanksByRanksId(String ranksId);
}
