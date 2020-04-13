package com.lnbei.member.mapper;

import com.lnbei.member.domain.MemberRanksShop;
import com.lnbei.member.domain.MemberRanksUser;

import java.util.List;	

/**
 * 商家与级别关系 数据层
 * 
 * @author lnbei
 * @date 2020-02-25
 */
public interface MemberRanksShopMapper 
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
     * 删除商家与级别关系
     * 
     * @param mid 商家与级别关系ID
     * @return 结果
     */
	public int deleteMemberRanksShopById(String mid);
	
	/**
     * 批量删除商家与级别关系
     * 
     * @param mids 需要删除的数据ID
     * @return 结果
     */
	public int deleteMemberRanksShopByIds(String[] mids);
	public int deleteUserRoleInfo(MemberRanksShop memberRanksShop);
	public int deleteUserRoleInfos(String ranksId, String[] memberId);
}