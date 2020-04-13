package com.lnbei.member.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnbei.member.mapper.MemberMenuShopRanksMapper;
import com.lnbei.member.domain.MemberMenuShopRanks;
import com.lnbei.member.service.IMemberMenuShopRanksService;
import com.lnbei.common.core.text.Convert;

/**
 * 商家等级关系 服务层实现
 * 
 * @author lnbei
 * @date 2020-02-25
 */
@Service
public class MemberMenuShopRanksServiceImpl implements IMemberMenuShopRanksService {
	@Autowired
	private MemberMenuShopRanksMapper memberMenuShopRanksMapper;

	/**
	 * 查询商家等级关系信息
	 * 
	 * @param mid 商家等级关系ID
	 * @return 商家等级关系信息
	 */
	@Override
	public MemberMenuShopRanks selectMemberMenuShopRanksById(String mid) {
		return memberMenuShopRanksMapper.selectMemberMenuShopRanksById(mid);
	}

	/**
	 * 查询商家等级关系列表
	 * 
	 * @param memberMenuShopRanks 商家等级关系信息
	 * @return 商家等级关系集合
	 */
	@Override
	public List<MemberMenuShopRanks> selectMemberMenuShopRanksList(MemberMenuShopRanks memberMenuShopRanks) {
		return memberMenuShopRanksMapper.selectMemberMenuShopRanksList(memberMenuShopRanks);
	}

	/**
	 * 新增商家等级关系
	 * 
	 * @param memberMenuShopRanks 商家等级关系信息
	 * @return 结果
	 */
	@Override
	public int insertMemberMenuShopRanks(MemberMenuShopRanks memberMenuShopRanks) {
		return memberMenuShopRanksMapper.insertMemberMenuShopRanks(memberMenuShopRanks);
	}

	/**
	 * 修改商家等级关系
	 * 
	 * @param memberMenuShopRanks 商家等级关系信息
	 * @return 结果
	 */
	@Override
	public int updateMemberMenuShopRanks(MemberMenuShopRanks memberMenuShopRanks) {
		return memberMenuShopRanksMapper.updateMemberMenuShopRanks(memberMenuShopRanks);
	}

	/**
	 * 删除商家等级关系对象
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	@Override
	public int deleteMemberMenuShopRanksByIds(String ids) {
		return memberMenuShopRanksMapper.deleteMemberMenuShopRanksByIds(Convert.toStrArray(ids));
	}

	/**
	 * 删除商家等级关系根据等级ID
	 * 
	 * @param mid 商家等级关系ID
	 * @return 结果
	 */
	@Override
	public int deleteMemberMenuShopRanksByRanksId(String RanksId) {

		return memberMenuShopRanksMapper.deleteMemberMenuShopRanksByRanksId(RanksId);
	}
}
