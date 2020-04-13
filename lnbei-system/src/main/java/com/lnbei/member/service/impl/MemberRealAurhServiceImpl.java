package com.lnbei.member.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnbei.member.mapper.MemberRealAurhMapper;
import com.lnbei.member.domain.MemberRealAurh;
import com.lnbei.member.service.IMemberRealAurhService;
import com.lnbei.common.core.text.Convert;

/**
 * 实名认证 服务层实现
 * 
 * @author lnbei
 * @date 2020-01-24
 */
@Service
public class MemberRealAurhServiceImpl implements IMemberRealAurhService {
	@Autowired
	private MemberRealAurhMapper memberRealAurhMapper;

	/**
	 * 查询实名认证信息
	 * 
	 * @param mid 实名认证ID
	 * @return 实名认证信息
	 */
	@Override
	public MemberRealAurh selectMemberRealAurhById(String mid) {
		return memberRealAurhMapper.selectMemberRealAurhById(mid);
	}

	/**
	 * 查询实名认证列表
	 * 
	 * @param memberRealAurh 实名认证信息
	 * @return 实名认证集合
	 */
	@Override
	public List<MemberRealAurh> selectMemberRealAurhList(MemberRealAurh memberRealAurh) {
		return memberRealAurhMapper.selectMemberRealAurhList(memberRealAurh);
	}

	/**
	 * 新增实名认证
	 * 
	 * @param memberRealAurh 实名认证信息
	 * @return 结果
	 */
	@Override
	public int insertMemberRealAurh(MemberRealAurh memberRealAurh, Object user) {
		memberRealAurh.initInsert(user);
		return memberRealAurhMapper.insertMemberRealAurh(memberRealAurh);
	}

	/**
	 * 修改实名认证
	 * 
	 * @param memberRealAurh 实名认证信息
	 * @return 结果
	 */
	@Override
	public int updateMemberRealAurh(MemberRealAurh memberRealAurh, Object user) {
		memberRealAurh.initUpdate(user);
		return memberRealAurhMapper.updateMemberRealAurh(memberRealAurh);
	}

	/**
	 * 删除实名认证对象
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	@Override
	public int deleteMemberRealAurhByIds(String ids) {
		return memberRealAurhMapper.deleteMemberRealAurhByIds(Convert.toStrArray(ids));
	}

}
