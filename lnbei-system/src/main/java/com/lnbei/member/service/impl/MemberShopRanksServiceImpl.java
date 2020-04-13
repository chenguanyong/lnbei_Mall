package com.lnbei.member.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lnbei.member.mapper.MemberMenuShopRanksMapper;
import com.lnbei.member.mapper.MemberShopRanksMapper;
import com.lnbei.member.mapper.MemberShopranksDeptMapper;
import com.lnbei.member.domain.MemberMenuShopRanks;
import com.lnbei.member.domain.MemberRanksUser;
import com.lnbei.member.domain.MemberShopRanks;
import com.lnbei.member.domain.MemberShopranksDept;
import com.lnbei.member.service.IMemberShopRanksService;
import com.lnbei.common.core.text.Convert;
import com.lnbei.common.utils.StringUtils;

/**
 * 商家等级 服务层实现
 * 
 * @author lnbei
 * @date 2020-02-25
 */
@Service
public class MemberShopRanksServiceImpl implements IMemberShopRanksService {
	@Autowired
	private MemberShopRanksMapper memberShopRanksMapper;
	@Autowired
	private MemberMenuShopRanksMapper MemberMenuShopRanksMapper;
	@Autowired
	private MemberShopranksDeptMapper MemberShopranksDeptMapper;
	/**
	 * 查询商家等级信息
	 * 
	 * @param mid 商家等级ID
	 * @return 商家等级信息
	 */
	@Override
	public MemberShopRanks selectMemberShopRanksById(String mid) {
		return memberShopRanksMapper.selectMemberShopRanksById(mid);
	}

	/**
	 * 查询商家等级列表
	 * 
	 * @param memberShopRanks 商家等级信息
	 * @return 商家等级集合
	 */
	@Override
	public List<MemberShopRanks> selectMemberShopRanksList(MemberShopRanks memberShopRanks) {
		return memberShopRanksMapper.selectMemberShopRanksList(memberShopRanks);
	}

	/**
	 * 新增商家等级
	 * 
	 * @param memberShopRanks 商家等级信息
	 * @return 结果
	 */
	@Override
	@Transactional
	public int insertMemberShopRanks(MemberShopRanks memberShopRanks) {
		int r = memberShopRanksMapper.insertMemberShopRanks(memberShopRanks);

		String menuIdString = memberShopRanks.getMenuIds();
		if (r != 0 && StringUtils.isNotEmpty(menuIdString)) {

			String[] menuIdArray = Convert.toStrArray(menuIdString);

			for (String menuId : menuIdArray) {
				MemberMenuShopRanks tempMemberMenuShopRanks = new MemberMenuShopRanks();

				tempMemberMenuShopRanks.setRanksId(memberShopRanks.getMid());

				tempMemberMenuShopRanks.setMenuId(menuId);

				MemberMenuShopRanksMapper.insertMemberMenuShopRanks(tempMemberMenuShopRanks);
			}

		}
		return r;
	}

	/**
	 * 修改商家等级
	 * 
	 * @param memberShopRanks 商家等级信息
	 * @return 结果
	 */
	@Override
	@Transactional
	public int updateMemberShopRanks(MemberShopRanks memberShopRanks) {
		int r = memberShopRanksMapper.updateMemberShopRanks(memberShopRanks);
		String menuIdString = memberShopRanks.getMenuIds();
		if (r != 0 && StringUtils.isNotEmpty(menuIdString)) {
			int b = MemberMenuShopRanksMapper.deleteMemberMenuShopRanksByRanksId(memberShopRanks.getMid());
			String[] menuIdArray = Convert.toStrArray(menuIdString);
			if (b != 0) {
				for (String menuId : menuIdArray) {
					MemberMenuShopRanks tempMemberMenuShopRanks = new MemberMenuShopRanks();

					tempMemberMenuShopRanks.setRanksId(memberShopRanks.getMid());

					tempMemberMenuShopRanks.setMenuId(menuId);

					MemberMenuShopRanksMapper.insertMemberMenuShopRanks(tempMemberMenuShopRanks);
				}

			}
		}
		return r;
	}

	/**
	 * 删除商家等级对象
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	@Override
	public int deleteMemberShopRanksByIds(String ids) {
		return memberShopRanksMapper.deleteMemberShopRanksByIds(Convert.toStrArray(ids));
	}
	
    public int insertRoleDept(MemberShopRanks memberShopRanks)
    {
        int rows = 1;
        // 新增角色与部门（数据权限）管理
        List<MemberShopranksDept> list = new ArrayList<MemberShopranksDept>();
        for (String deptId : memberShopRanks.getDeptIds())
        {
            MemberShopranksDept rd = new MemberShopranksDept();
            rd.setRanksId(memberShopRanks.getMid());
            rd.setDeptId(deptId);
            list.add(rd);
        }
        if (list.size() > 0)
        {
            rows = MemberShopranksDeptMapper.batchRoleDept(list);
        }
        return rows;
    }
    
    @Override
    @Transactional
    public int authDataScope(MemberShopRanks  memberShopRanks)
    {
        // 修改角色信息
    	memberShopRanksMapper.updateMemberShopRanks(memberShopRanks);
        // 删除角色与部门关联
    	MemberShopranksDeptMapper.deleteMemberShopranksDeptById(memberShopRanks.getMid());
        // 新增角色和部门信息（数据权限）
        return insertRoleDept(memberShopRanks);
    }
}
