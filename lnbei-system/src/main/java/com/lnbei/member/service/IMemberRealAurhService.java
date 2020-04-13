package com.lnbei.member.service;

import com.lnbei.member.domain.MemberRealAurh;
import java.util.List;

/**
 * 实名认证 服务层
 * 
 * @author lnbei
 * @date 2020-01-24
 */
public interface IMemberRealAurhService 
{
	/**
     * 查询实名认证信息
     * 
     * @param mid 实名认证ID
     * @return 实名认证信息
     */
	public MemberRealAurh selectMemberRealAurhById(String mid);
	
	/**
     * 查询实名认证列表
     * 
     * @param memberRealAurh 实名认证信息
     * @return 实名认证集合
     */
	public List<MemberRealAurh> selectMemberRealAurhList(MemberRealAurh memberRealAurh);
	
	/**
     * 新增实名认证
     * 
     * @param memberRealAurh 实名认证信息
     * @return 结果
     */
	public int insertMemberRealAurh(MemberRealAurh memberRealAurh, Object user);
	
	/**
     * 修改实名认证
     * 
     * @param memberRealAurh 实名认证信息
     * @return 结果
     */
	public int updateMemberRealAurh(MemberRealAurh memberRealAurh, Object user);
		
	/**
     * 删除实名认证信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteMemberRealAurhByIds(String ids);
	
}
