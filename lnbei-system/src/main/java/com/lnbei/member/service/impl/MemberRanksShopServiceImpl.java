package com.lnbei.member.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnbei.member.mapper.MemberRanksShopMapper;
import com.lnbei.member.domain.MemberRanksShop;
import com.lnbei.member.domain.MemberRanksUser;
import com.lnbei.member.service.IMemberRanksShopService;
import com.lnbei.common.core.text.Convert;
import com.lnbei.common.utils.StringUtils;

/**
 * 商家与级别关系 服务层实现
 * 
 * @author lnbei
 * @date 2020-02-25
 */
@Service
public class MemberRanksShopServiceImpl implements IMemberRanksShopService {
	@Autowired
	private MemberRanksShopMapper memberRanksShopMapper;

	/**
	 * 查询商家与级别关系信息
	 * 
	 * @param mid 商家与级别关系ID
	 * @return 商家与级别关系信息
	 */
	@Override
	public MemberRanksShop selectMemberRanksShopById(String mid) {
		return memberRanksShopMapper.selectMemberRanksShopById(mid);
	}

	/**
	 * 查询商家与级别关系列表
	 * 
	 * @param memberRanksShop 商家与级别关系信息
	 * @return 商家与级别关系集合
	 */
	@Override
	public List<MemberRanksShop> selectMemberRanksShopList(MemberRanksShop memberRanksShop) {
		return memberRanksShopMapper.selectMemberRanksShopList(memberRanksShop);
	}

	/**
	 * 新增商家与级别关系
	 * 
	 * @param memberRanksShop 商家与级别关系信息
	 * @return 结果
	 */
	@Override
	public int insertMemberRanksShop(MemberRanksShop memberRanksShop) {
		int r = memberRanksShopMapper.insertMemberRanksShop(memberRanksShop);
//		if (r != 0 && StringUtils.isNotEmpty(memberRanksShop.getm)) {
//			
//		}
		return 0;
	}

	/**
	 * 修改商家与级别关系
	 * 
	 * @param memberRanksShop 商家与级别关系信息
	 * @return 结果
	 */
	@Override
	public int updateMemberRanksShop(MemberRanksShop memberRanksShop) {
		return memberRanksShopMapper.updateMemberRanksShop(memberRanksShop);
	}

	/**
	 * 删除商家与级别关系对象
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	@Override
	public int deleteMemberRanksShopByIds(String ids) {
		return memberRanksShopMapper.deleteMemberRanksShopByIds(Convert.toStrArray(ids));
	}

	/**
	 * 取消授权用户角色
	 * 
	 * @param userRole 用户和角色关联信息
	 * @return 结果
	 */
	@Override
	public int deleteAuthUser(MemberRanksShop memberRanksShop) {
		return memberRanksShopMapper.deleteUserRoleInfo(memberRanksShop);
	}

	/**
	 * 批量取消授权用户角色
	 * 
	 * @param roleId  角色ID
	 * @param userIds 需要删除的用户数据ID
	 * @return 结果
	 */
	@Override
	public int deleteAuthUsers(String roleId, String userIds) {
		return memberRanksShopMapper.deleteUserRoleInfos(roleId, Convert.toStrArray(userIds));
	}

	@Override
	public int insertAuthUsers(String ranksId, String userIds) {
		// TODO Auto-generated method stub
		String[] userIdsArray = Convert.toStrArray(userIds);
		int reasult = 0;
		for (String string : userIdsArray) {
			MemberRanksShop memberRanksShop = new MemberRanksShop();
			memberRanksShop.setMemberId(string);
			memberRanksShop.setRanksId(ranksId);
			reasult = memberRanksShopMapper.insertMemberRanksShop(memberRanksShop);
		}
		return reasult;
	}
}
