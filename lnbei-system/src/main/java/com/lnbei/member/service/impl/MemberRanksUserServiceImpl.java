package com.lnbei.member.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnbei.member.mapper.MemberRanksUserMapper;
import com.lnbei.member.domain.MemberRanksUser;
import com.lnbei.member.service.IMemberRanksUserService;
import com.lnbei.common.core.text.Convert;

/**
 * 会员与级别关系i 服务层实现
 * 
 * @author lnbei
 * @date 2020-02-26
 */
@Service
public class MemberRanksUserServiceImpl implements IMemberRanksUserService 
{
	@Autowired
	private MemberRanksUserMapper memberRanksUserMapper;

	/**
     * 查询会员与级别关系i信息
     * 
     * @param mid 会员与级别关系iID
     * @return 会员与级别关系i信息
     */
    @Override
	public MemberRanksUser selectMemberRanksUserById(String mid)
	{
	    return memberRanksUserMapper.selectMemberRanksUserById(mid);
	}
	
	/**
     * 查询会员与级别关系i列表
     * 
     * @param memberRanksUser 会员与级别关系i信息
     * @return 会员与级别关系i集合
     */
	@Override
	public List<MemberRanksUser> selectMemberRanksUserList(MemberRanksUser memberRanksUser)
	{
	    return memberRanksUserMapper.selectMemberRanksUserList(memberRanksUser);
	}
	
    /**
     * 新增会员与级别关系i
     * 
     * @param memberRanksUser 会员与级别关系i信息
     * @return 结果
     */
	@Override
	public int insertMemberRanksUser(MemberRanksUser memberRanksUser)
	{
	    return memberRanksUserMapper.insertMemberRanksUser(memberRanksUser);
	}
	
	/**
     * 修改会员与级别关系i
     * 
     * @param memberRanksUser 会员与级别关系i信息
     * @return 结果
     */
	@Override
	public int updateMemberRanksUser(MemberRanksUser memberRanksUser)
	{
	    return memberRanksUserMapper.updateMemberRanksUser(memberRanksUser);
	}

	/**
     * 删除会员与级别关系i对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteMemberRanksUserByIds(String ids)
	{
		return memberRanksUserMapper.deleteMemberRanksUserByIds(Convert.toStrArray(ids));
	}

	@Override
	public int insertAuthUsers(String ranksId, String userIds) {
		// TODO Auto-generated method stub
		String [] userIdsArray = Convert.toStrArray(userIds);
		int reasult = 0;
		for (String string : userIdsArray) {
			MemberRanksUser memberRanksUser = new MemberRanksUser();
			memberRanksUser.setMemberId(string);
			memberRanksUser.setRanksId(ranksId);
			reasult = memberRanksUserMapper.insertMemberRanksUser(memberRanksUser);
		}
		return reasult;
	}
	
}
