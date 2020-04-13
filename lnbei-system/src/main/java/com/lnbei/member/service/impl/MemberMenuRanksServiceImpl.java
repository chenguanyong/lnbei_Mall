package com.lnbei.member.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnbei.member.mapper.MemberMenuRanksMapper;
import com.lnbei.member.domain.MemberMenuRanks;
import com.lnbei.member.service.IMemberMenuRanksService;
import com.lnbei.common.core.text.Convert;

/**
 * 等级关系i 服务层实现
 * 
 * @author lnbei
 * @date 2020-02-26
 */
@Service
public class MemberMenuRanksServiceImpl implements IMemberMenuRanksService 
{
	@Autowired
	private MemberMenuRanksMapper memberMenuRanksMapper;

	/**
     * 查询等级关系i信息
     * 
     * @param mid 等级关系iID
     * @return 等级关系i信息
     */
    @Override
	public MemberMenuRanks selectMemberMenuRanksById(String mid)
	{
	    return memberMenuRanksMapper.selectMemberMenuRanksById(mid);
	}
	
	/**
     * 查询等级关系i列表
     * 
     * @param memberMenuRanks 等级关系i信息
     * @return 等级关系i集合
     */
	@Override
	public List<MemberMenuRanks> selectMemberMenuRanksList(MemberMenuRanks memberMenuRanks)
	{
	    return memberMenuRanksMapper.selectMemberMenuRanksList(memberMenuRanks);
	}
	
    /**
     * 新增等级关系i
     * 
     * @param memberMenuRanks 等级关系i信息
     * @return 结果
     */
	@Override
	public int insertMemberMenuRanks(MemberMenuRanks memberMenuRanks)
	{
	    return memberMenuRanksMapper.insertMemberMenuRanks(memberMenuRanks);
	}
	
	/**
     * 修改等级关系i
     * 
     * @param memberMenuRanks 等级关系i信息
     * @return 结果
     */
	@Override
	public int updateMemberMenuRanks(MemberMenuRanks memberMenuRanks)
	{
	    return memberMenuRanksMapper.updateMemberMenuRanks(memberMenuRanks);
	}

	/**
     * 删除等级关系i对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteMemberMenuRanksByIds(String ids)
	{
		return memberMenuRanksMapper.deleteMemberMenuRanksByIds(Convert.toStrArray(ids));
	}
	/**
     * 根据用户等级ID删除等级与菜单的关系
     * 
     * @param mids 需要删除的数据ID
     * @return 结果
     */	
	@Override
	public int deleteMemberMenuRanksByRanksId(String ranksId) {
		return memberMenuRanksMapper.deleteMemberMenuRanksByRanksId(ranksId);
	}
}
