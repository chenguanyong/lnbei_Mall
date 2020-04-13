package com.lnbei.member.service.impl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lnbei.member.mapper.MemberMenuRanksMapper;
import com.lnbei.member.mapper.MemberRanksUserMapper;
import com.lnbei.member.mapper.MemberUserRanksMapper;
import com.lnbei.member.domain.MemberMenuRanks;
import com.lnbei.member.domain.MemberRanksUser;
import com.lnbei.member.domain.MemberUserRanks;
import com.lnbei.member.service.IMemberUserRanksService;
import com.lnbei.common.core.text.Convert;
import com.lnbei.common.utils.StringUtils;

/**
 * 会员等级 服务层实现
 * 
 * @author lnbei
 * @date 2020-01-24
 */
@Service
public class MemberUserRanksServiceImpl implements IMemberUserRanksService 
{
	@Autowired
	private MemberUserRanksMapper memberUserRanksMapper;

	@Autowired
	private MemberMenuRanksMapper memberMenuRanksMapper;
	@Autowired
	private MemberRanksUserMapper memberRanksUserMapper;
	/**
     * 查询会员等级信息
     * 
     * @param mid 会员等级ID
     * @return 会员等级信息
     */
    @Override
	public MemberUserRanks selectMemberUserRanksById(String mid)
	{
	    return memberUserRanksMapper.selectMemberUserRanksById(mid);
	}
	
	/**
     * 查询会员等级列表
     * 
     * @param memberUserRanks 会员等级信息
     * @return 会员等级集合
     */
	@Override
	public List<MemberUserRanks> selectMemberUserRanksList(MemberUserRanks memberUserRanks)
	{
	    return memberUserRanksMapper.selectMemberUserRanksList(memberUserRanks);
	}
	
    /**
     * 新增会员等级
     * 
     * @param memberUserRanks 会员等级信息
     * @return 结果
     */
	@Override
	public int insertMemberUserRanks(MemberUserRanks memberUserRanks, Object user)
	{
		memberUserRanks.initInsert(user);
		int result =  memberUserRanksMapper.insertMemberUserRanks(memberUserRanks);
	    if(result == 0) {
	    	String menuIds = memberUserRanks.getMeunId();
	    	String [] menuArray = Convert.toStrArray(menuIds);
	    	for (String string : menuArray) {
				MemberMenuRanks menuRanks = new MemberMenuRanks();
				menuRanks.setMenuId(string);
				menuRanks.setRanksId(memberUserRanks.getMid());
				memberMenuRanksMapper.insertMemberMenuRanks(menuRanks);
			}
	    }
		return result;
	}
	
	/**
     * 修改会员等级
     * 
     * @param memberUserRanks 会员等级信息
     * @return 结果
     */
	@Override
	public int updateMemberUserRanks(MemberUserRanks memberUserRanks, Object user)
	{	memberUserRanks.initUpdate(user);
		int result = memberUserRanksMapper.updateMemberUserRanks(memberUserRanks);
	    result = memberMenuRanksMapper.deleteMemberMenuRanksByRanksId(memberUserRanks.getMid());
		if(result == 0) {
	    	String menuIds = memberUserRanks.getMeunId();
	    	String [] menuArray = Convert.toStrArray(menuIds);
	    	for (String string : menuArray) {
				MemberMenuRanks menuRanks = new MemberMenuRanks();
				menuRanks.setMenuId(string);
				menuRanks.setRanksId(memberUserRanks.getMid());
				memberMenuRanksMapper.insertMemberMenuRanks(menuRanks);
			}
	    }	    
		return result;
	}

	/**
     * 删除会员等级对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteMemberUserRanksByIds(String ids)
	{
		return memberUserRanksMapper.deleteMemberUserRanksByIds(Convert.toStrArray(ids));
	}
    @Override
    public Set<String> selectRanksKeys(String memberId, String identity)
    {
        List<MemberUserRanks> perms = memberUserRanksMapper.selectRanksByMemberIdAndIdentity(memberId, identity);
        Set<String> permsSet = new HashSet<>();
        for (MemberUserRanks perm : perms)
        {
            if (StringUtils.isNotNull(perm))
            {
                permsSet.addAll(Arrays.asList(perm.getRankKeys().trim().split(",")));
            }
        }
        return permsSet;
    }
    /**
     * 取消授权用户角色
     * 
     * @param userRole 用户和角色关联信息
     * @return 结果
     */
    @Override
    public int deleteAuthUser(MemberRanksUser memberRanksUser)
    {
        return memberRanksUserMapper.deleteUserRoleInfo(memberRanksUser);
    }

    /**
     * 批量取消授权用户角色
     * 
     * @param roleId 角色ID
     * @param userIds 需要删除的用户数据ID
     * @return 结果
     */
    @Override
    public int deleteAuthUsers(String roleId, String userIds)
    {
        return memberRanksUserMapper.deleteUserRoleInfos(roleId, Convert.toStrArray(userIds));
    }
    
}
