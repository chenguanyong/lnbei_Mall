package com.lnbei.system.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnbei.system.mapper.ConfigTreeMapper;
import com.lnbei.system.domain.ConfigTree;

import com.lnbei.system.service.IConfigTreeService;

import com.lnbei.common.core.domain.Ztree;
import com.lnbei.common.core.text.Convert;
import com.lnbei.common.utils.StringUtils;

/**
 * 配置树 服务层实现
 * 
 * @author lnbei
 * @date 2019-12-25
 */
@Service
public class ConfigTreeServiceImpl implements IConfigTreeService 
{
	@Autowired
	private ConfigTreeMapper configTreeMapper;

	/**
     * 查询配置树信息
     * 
     * @param id 配置树ID
     * @return 配置树信息
     */
    @Override
	public ConfigTree selectConfigTreeById(String id)
	{
	    return configTreeMapper.selectConfigTreeById(id);
	}
	
	/**
     * 查询配置树列表
     * 
     * @param configTree 配置树信息
     * @return 配置树集合
     */
	@Override
	public List<ConfigTree> selectConfigTreeList(ConfigTree configTree)
	{
	    return configTreeMapper.selectConfigTreeList(configTree);
	}
	
    /**
     * 新增配置树
     * 
     * @param configTree 配置树信息
     * @return 结果
     */
	@Override
	public int insertConfigTree(ConfigTree configTree)
	{
	    return configTreeMapper.insertConfigTree(configTree);
	}
	
	/**
     * 修改配置树
     * 
     * @param configTree 配置树信息
     * @return 结果
     */
	@Override
	public int updateConfigTree(ConfigTree configTree)
	{
	    return configTreeMapper.updateConfigTree(configTree);
	}

	/**
     * 删除配置树对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteConfigTreeByIds(String ids)
	{
		return configTreeMapper.deleteConfigTreeByIds(Convert.toStrArray(ids));
	}

	@Override
	public List<Ztree> selectConfigTree(ConfigTree mConfigTree) {
		// TODO Auto-generated method stub
		List<ConfigTree> deptList = configTreeMapper.selectConfigTreeList(mConfigTree);
		List<Ztree> ztrees = initZtree(deptList);
		return ztrees;
	}
	/**
	 * 对象转部门树
	 *
	 * @param deptList 部门列表
	 * @return 树结构列表
	 */
	public List<Ztree> initZtree(List<ConfigTree> mConfigTrees) {
		return initZtree(mConfigTrees, null);
	}
	/**
	 * 对象转部门树
	 *
	 * @param deptList     部门列表
	 * @param roleDeptList 角色已存在菜单列表
	 * @return 树结构列表
	 */
	public List<Ztree> initZtree(List<ConfigTree> mConfigTrees, List<String> roleDeptList) {

		List<Ztree> ztrees = new ArrayList<Ztree>();
		boolean isCheck = StringUtils.isNotNull(roleDeptList);
		for (ConfigTree mConfigTree : mConfigTrees) {
			//if (UserConstants.DEPT_NORMAL.equals(dept.getStatus())) {
				Ztree ztree = new Ztree();
				ztree.setId(mConfigTree.getId());
				ztree.setpId(mConfigTree.getParentId());
				ztree.setName(mConfigTree.getName());
				ztree.setTitle(mConfigTree.getName());
				if (isCheck) {
					ztree.setChecked(roleDeptList.contains(mConfigTree.getId() + mConfigTree.getName()));
				}
				ztrees.add(ztree);
			//}
		}
		return ztrees;
	}
}
