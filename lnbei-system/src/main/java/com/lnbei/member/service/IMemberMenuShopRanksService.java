package com.lnbei.member.service;

import com.lnbei.member.domain.MemberMenuShopRanks;
import java.util.List;

/**
 * 商家等级关系 服务层
 * 
 * @author lnbei
 * @date 2020-02-25
 */
public interface IMemberMenuShopRanksService 
{
	/**
     * 查询商家等级关系信息
     * 
     * @param mid 商家等级关系ID
     * @return 商家等级关系信息
     */
	public MemberMenuShopRanks selectMemberMenuShopRanksById(String mid);
	
	/**
     * 查询商家等级关系列表
     * 
     * @param memberMenuShopRanks 商家等级关系信息
     * @return 商家等级关系集合
     */
	public List<MemberMenuShopRanks> selectMemberMenuShopRanksList(MemberMenuShopRanks memberMenuShopRanks);
	
	/**
     * 新增商家等级关系
     * 
     * @param memberMenuShopRanks 商家等级关系信息
     * @return 结果
     */
	public int insertMemberMenuShopRanks(MemberMenuShopRanks memberMenuShopRanks);
	
	/**
     * 修改商家等级关系
     * 
     * @param memberMenuShopRanks 商家等级关系信息
     * @return 结果
     */
	public int updateMemberMenuShopRanks(MemberMenuShopRanks memberMenuShopRanks);
		
	/**
     * 删除商家等级关系信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteMemberMenuShopRanksByIds(String ids);
	/**
     * 删除商家等级关系根据等级ID
     * 
     * @param mid 商家等级关系ID
     * @return 结果
     */
	public int deleteMemberMenuShopRanksByRanksId(String RanksId);
}
