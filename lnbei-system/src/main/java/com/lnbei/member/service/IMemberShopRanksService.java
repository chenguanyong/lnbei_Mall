package com.lnbei.member.service;

import com.lnbei.member.domain.MemberShopRanks;
import java.util.List;

/**
 * 商家等级 服务层
 * 
 * @author lnbei
 * @date 2020-02-25
 */
public interface IMemberShopRanksService 
{
	/**
     * 查询商家等级信息
     * 
     * @param mid 商家等级ID
     * @return 商家等级信息
     */
	public MemberShopRanks selectMemberShopRanksById(String mid);
	
	/**
     * 查询商家等级列表
     * 
     * @param memberShopRanks 商家等级信息
     * @return 商家等级集合
     */
	public List<MemberShopRanks> selectMemberShopRanksList(MemberShopRanks memberShopRanks);
	
	/**
     * 新增商家等级
     * 
     * @param memberShopRanks 商家等级信息
     * @return 结果
     */
	public int insertMemberShopRanks(MemberShopRanks memberShopRanks);
	
	/**
     * 修改商家等级
     * 
     * @param memberShopRanks 商家等级信息
     * @return 结果
     */
	public int updateMemberShopRanks(MemberShopRanks memberShopRanks);
		
	/**
     * 删除商家等级信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteMemberShopRanksByIds(String ids);
    public int authDataScope(MemberShopRanks  memberShopRanks);
}
