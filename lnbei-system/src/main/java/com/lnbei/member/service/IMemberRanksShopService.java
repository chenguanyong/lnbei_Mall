package com.lnbei.member.service;

import com.lnbei.member.domain.MemberRanksShop;
import com.lnbei.member.domain.MemberRanksUser;

import java.util.List;

/**
 * 商家与级别关系 服务层
 * 
 * @author lnbei
 * @date 2020-02-25
 */
public interface IMemberRanksShopService 
{
	/**
     * 查询商家与级别关系信息
     * 
     * @param mid 商家与级别关系ID
     * @return 商家与级别关系信息
     */
	public MemberRanksShop selectMemberRanksShopById(String mid);
	
	/**
     * 查询商家与级别关系列表
     * 
     * @param memberRanksShop 商家与级别关系信息
     * @return 商家与级别关系集合
     */
	public List<MemberRanksShop> selectMemberRanksShopList(MemberRanksShop memberRanksShop);
	
	/**
     * 新增商家与级别关系
     * 
     * @param memberRanksShop 商家与级别关系信息
     * @return 结果
     */
	public int insertMemberRanksShop(MemberRanksShop memberRanksShop);
	
	/**
     * 修改商家与级别关系
     * 
     * @param memberRanksShop 商家与级别关系信息
     * @return 结果
     */
	public int updateMemberRanksShop(MemberRanksShop memberRanksShop);
		
	/**
     * 删除商家与级别关系信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteMemberRanksShopByIds(String ids);
	
    /**
     * 取消授权用户角色
     * 
     * @param userRole 用户和角色关联信息
     * @return 结果
     */

    public int deleteAuthUser(MemberRanksShop ranksUser);
   

    /**
     * 批量取消授权用户角色
     * 
     * @param roleId 角色ID
     * @param userIds 需要删除的用户数据ID
     * @return 结果
     */

    public int deleteAuthUsers(String roleId, String userIds);
    public int insertAuthUsers(String ranksId, String userIds);
}
