package com.lnbei.oa.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnbei.oa.mapper.OaSystemMapper;
import com.lnbei.oa.domain.OaSystem;
import com.lnbei.oa.service.IOaSystemService;

import com.lnbei.common.core.domain.Ztree;
import com.lnbei.common.core.text.Convert;

/**
 * 系统注册 服务层实现
 * 
 * @author lnbei
 * @date 2019-03-19
 */
@Service
public class OaSystemServiceImpl implements IOaSystemService {
	@Autowired
	private OaSystemMapper oaSystemMapper;

	/**
	 * 查询系统注册信息
	 * 
	 * @param id 系统注册ID
	 * @return 系统注册信息
	 */
	@Override
	public OaSystem selectOaSystemById(String id) {
		return oaSystemMapper.selectOaSystemById(id);
	}

	/**
	 * 查询系统注册列表
	 * 
	 * @param oaSystem 系统注册信息
	 * @return 系统注册集合
	 */
	@Override
	public List<OaSystem> selectOaSystemList(OaSystem oaSystem) {
		return oaSystemMapper.selectOaSystemList(oaSystem);
	}

	/**
	 * 新增系统注册
	 * 
	 * @param oaSystem 系统注册信息
	 * @return 结果
	 */
	@Override
	public int insertOaSystem(OaSystem oaSystem) {
		return oaSystemMapper.insertOaSystem(oaSystem);
	}

	/**
	 * 修改系统注册
	 * 
	 * @param oaSystem 系统注册信息
	 * @return 结果
	 */
	@Override
	public int updateOaSystem(OaSystem oaSystem) {
		return oaSystemMapper.updateOaSystem(oaSystem);
	}

	/**
	 * 删除系统注册对象
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	@Override
	public int deleteOaSystemByIds(String ids) {
		return oaSystemMapper.deleteOaSystemByIds(Convert.toStrArray(ids));
	}

	/**
	 * 获取已注册系统树
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	@Override
	public List<Ztree> getSystemZtrees(){
		List<OaSystem> mOaSystems = oaSystemMapper.selectOaSystemList(null);
		List<Ztree> mZtreeList = new ArrayList<Ztree>();
		Ztree mZtree = new Ztree();
		mZtree.setId("1");
		mZtree.setpId("0");
		mZtree.setName("所有已注册系统");
		mZtreeList.add(mZtree);
		for(OaSystem mOaSystem : mOaSystems) {
			Ztree mTempZtree = new Ztree();
			mTempZtree.setpId("1");
			mTempZtree.setId(mOaSystem.getId());
			mTempZtree.setName(mOaSystem.getSysName());
			mZtreeList.add(mTempZtree);
		}
		return mZtreeList;
	}
}
