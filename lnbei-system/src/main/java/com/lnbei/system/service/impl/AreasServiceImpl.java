package com.lnbei.system.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnbei.system.mapper.AreasMapper;
import com.lnbei.system.domain.Areas;
import com.lnbei.system.service.IAreasService;
import com.lnbei.common.core.domain.Ztree;
import com.lnbei.common.core.text.Convert;

/**
 * 城市管理 服务层实现
 * 
 * @author lnbei
 * @date 2020-02-04
 */
@Service
public class AreasServiceImpl implements IAreasService 
{
	@Autowired
	private AreasMapper areasMapper;

	/**
     * 查询城市管理信息
     * 
     * @param mid 城市管理ID
     * @return 城市管理信息
     */
    @Override
	public Areas selectAreasById(String mid)
	{
	    return areasMapper.selectAreasById(mid);
	}
	
	/**
     * 查询城市管理列表
     * 
     * @param areas 城市管理信息
     * @return 城市管理集合
     */
	@Override
	public List<Areas> selectAreasList(Areas areas)
	{
	    return areasMapper.selectAreasList(areas);
	}
	
    /**
     * 新增城市管理
     * 
     * @param areas 城市管理信息
     * @return 结果
     */
	@Override
	public int insertAreas(Areas areas, Object user)
	{
		areas.insertData(user);
	    return areasMapper.insertAreas(areas);
	}
	
	/**
     * 修改城市管理
     * 
     * @param areas 城市管理信息
     * @return 结果
     */
	@Override
	public int updateAreas(Areas areas, Object user)
	{
		areas.updateData(user);
	    return areasMapper.updateAreas(areas);
	}

	/**
     * 删除城市管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteAreasByIds(String ids)
	{
		return areasMapper.deleteAreasByIds(Convert.toStrArray(ids));
	}

	@Override
	public List<Areas> selectAreasListByParentId(String panrentId) {
		// TODO Auto-generated method stub
		return areasMapper.selectAreasByParentId(panrentId);
	}

	@Override
	public List<Ztree> getZtreeListByParentId(String parentId) {
		// TODO Auto-generated method stub
		List<Ztree> mmList = new ArrayList<Ztree>();
		List<Areas> mmAreas = areasMapper.selectAreasByParentId(parentId);
		for (Areas areas : mmAreas) {
			Ztree mZtree = new Ztree();
			mZtree.setId(areas.getMid());
			mZtree.setName(areas.getAreaName());
			mZtree.setpId(areas.getParentId());
			int areaKey = Integer.parseInt(areas.getAreaType());
			if(areaKey<= 3) {
				mZtree.setIsParent(true);
			}else {
				mZtree.setIsParent(false);
			}
			mmList.add(mZtree);
		}
		return mmList;
	}
	
}
