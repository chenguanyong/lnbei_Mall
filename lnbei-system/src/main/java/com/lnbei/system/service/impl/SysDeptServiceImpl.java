package com.lnbei.system.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.lnbei.common.annotation.DataScope;
import com.lnbei.common.constant.UserConstants;
import com.lnbei.common.core.domain.Ztree;
import com.lnbei.common.exception.BusinessException;
import com.lnbei.common.utils.StringUtils;
import com.lnbei.system.domain.SysDept;
import com.lnbei.system.domain.SysRole;
import com.lnbei.system.mapper.SysDeptMapper;
import com.lnbei.system.service.ISysDeptService;

/**
 * 部门管理 服务实现
 * 
 * @author lnbei
 */
@Service
public class SysDeptServiceImpl implements ISysDeptService {
	@Autowired
	private SysDeptMapper deptMapper;

	/**
	 * 查询部门管理数据
	 * 
	 * @param dept 部门信息
	 * @return 部门信息集合
	 */
	@Override
	@DataScope(tableAlias = "d")
	public List<SysDept> selectDeptList(SysDept dept) {
		return deptMapper.selectDeptList(dept);
	}

	/**
	 * 查询部门管理树
	 * 
	 * @param dept 部门信息
	 * @return 所有部门信息
	 */
	@Override
	@DataScope(tableAlias = "d")
	public List<Ztree> selectDeptTree(SysDept dept) {
		List<SysDept> deptList = deptMapper.selectDeptList(dept);
		List<Ztree> ztrees = initZtree(deptList);
		return ztrees;
	}

	/**
	 * 根据角色ID查询部门（数据权限）
	 *
	 * @param role 角色对象
	 * @return 部门列表（数据权限）
	 */
	@Override
	public List<Ztree> roleDeptTreeData(SysRole role) {
		String roleId = role.getRoleId().toString();
		List<Ztree> ztrees = new ArrayList<Ztree>();
		List<SysDept> deptList = selectDeptList(new SysDept());
		if (StringUtils.isNotNull(roleId)) {
			List<String> roleDeptList = deptMapper.selectRoleDeptTree(roleId);
			ztrees = initZtree(deptList, roleDeptList);
		} else {
			ztrees = initZtree(deptList);
		}
		return ztrees;
	}

	/**
	 * 对象转部门树
	 *
	 * @param deptList 部门列表
	 * @return 树结构列表
	 */
	public List<Ztree> initZtree(List<SysDept> deptList) {
		return initZtree(deptList, null);
	}

	/**
	 * 对象转部门树
	 *
	 * @param deptList     部门列表
	 * @param roleDeptList 角色已存在菜单列表
	 * @return 树结构列表
	 */
	public List<Ztree> initZtree(List<SysDept> deptList, List<String> roleDeptList) {

		List<Ztree> ztrees = new ArrayList<Ztree>();
		boolean isCheck = StringUtils.isNotNull(roleDeptList);
		for (SysDept dept : deptList) {
			if (UserConstants.DEPT_NORMAL.equals(dept.getStatus())) {
				Ztree ztree = new Ztree();
				ztree.setId(dept.getId());
				ztree.setpId(dept.getParentId());
				ztree.setName(dept.getName());
				ztree.setTitle(dept.getName());
				if (isCheck) {
					ztree.setChecked(roleDeptList.contains(dept.getId() + dept.getName()));
				}
				ztrees.add(ztree);
			}
		}
		return ztrees;
	}

	/**
	 * 查询部门人数
	 * 
	 * @param parentId 部门ID
	 * @return 结果
	 */
	@Override
	public int selectDeptCount(String parentId) {
		SysDept dept = new SysDept();
		dept.setParentId(parentId);
		return deptMapper.selectDeptCount(dept);
	}

	/**
	 * 查询部门是否存在用户
	 * 
	 * @param deptId 部门ID
	 * @return 结果 true 存在 false 不存在
	 */
	@Override
	public boolean checkDeptExistUser(String deptId) {
		int result = deptMapper.checkDeptExistUser(deptId);
		return result > 0 ? true : false;
	}

	/**
	 * 删除部门管理信息
	 * 
	 * @param deptId 部门ID
	 * @return 结果
	 */
	@Override
	public int deleteDeptById(String deptId) {
		return deptMapper.deleteDeptById(deptId);
	}

	/**
	 * 新增保存部门信息
	 * 
	 * @param dept 部门信息
	 * @return 结果
	 */
	@Override
	public int insertDept(SysDept dept) {
		SysDept info = deptMapper.selectDeptById(dept.getParentId());
		// 如果父节点不为"正常"状态,则不允许新增子节点
		if (!UserConstants.DEPT_NORMAL.equals(info.getStatus())) {
			throw new BusinessException("部门停用，不允许新增");
		}
		dept.setAncestors(info.getAncestors() + "," + dept.getParentId());
		return deptMapper.insertDept(dept);
	}

	/**
	 * 修改保存部门信息
	 * 
	 * @param dept 部门信息
	 * @return 结果
	 */
	@Override
	@Transactional
	public int updateDept(SysDept dept) {
		SysDept info = deptMapper.selectDeptById(dept.getParentId());
		if (StringUtils.isNotNull(info)) {
			String ancestors = info.getAncestors() + "," + info.getId();
			dept.setAncestors(ancestors);
			updateDeptChildren(dept.getId(), ancestors);
		}
		int result = deptMapper.updateDept(dept);
		if (UserConstants.DEPT_NORMAL.equals(dept.getStatus())) {
			// 如果该部门是启用状态，则启用该部门的所有上级部门
			// updateParentDeptStatus(dept);
		}
		return result;
	}

	/**
	 * 修改该部门的父级部门状态
	 * 
	 * @param dept 当前部门
	 */
	private void updateParentDeptStatus(SysDept dept) {
		String updateBy = dept.getUpdateBy();
		dept = deptMapper.selectDeptById(dept.getId());
		dept.setUpdateBy(updateBy);
		String ancestors = dept.getAncestors();
		List<String> mStrings = Arrays.asList(ancestors.split(","));
		deptMapper.updateDeptStatus(mStrings);
	}

	/**
	 * 修改子元素关系
	 * 
	 * @param deptId    部门ID
	 * @param ancestors 元素列表
	 */
	public void updateDeptChildren(String deptId, String ancestors) {
		SysDept dept = new SysDept();
		dept.setParentId(deptId);
		List<SysDept> childrens = deptMapper.selectDeptList(dept);
		for (SysDept children : childrens) {
			children.setAncestors(ancestors + "," + dept.getParentId());
		}
		if (childrens.size() > 0) {
			deptMapper.updateDeptChildren(childrens);
		}
	}

	/**
	 * 根据部门ID查询信息
	 * 
	 * @param deptId 部门ID
	 * @return 部门信息
	 */
	@Override
	public SysDept selectDeptById(String deptId) {
		return deptMapper.selectDeptById(deptId);
	}

	/**
	 * 校验部门名称是否唯一
	 * 
	 * @param dept 部门信息
	 * @return 结果
	 */
	@Override
	public String checkDeptNameUnique(SysDept dept) {

		String deptId = StringUtils.isNull(dept.getId()) ? "-1" : dept.getId();
		SysDept info = deptMapper.checkDeptNameUnique(dept.getName(), dept.getParentId());
		if (StringUtils.isNotNull(info) && !info.getId().equals(deptId)) {
			return UserConstants.DEPT_NAME_NOT_UNIQUE;
		}
		return UserConstants.DEPT_NAME_UNIQUE;
	}

	/**
	 * 更新部门的排序值
	 * 
	 * @param id
	 * @return
	 */
	public int updateDeptSort(SysDept dept) {

		return deptMapper.updateDeptSort(dept);
	}

	/**
	 * 获取部门树
	 * 
	 * @return
	 */
	public List<Ztree> getDeptAllZtree() {
		List<SysDept> mSysDepts = deptMapper.selectDeptAllList();
		List<Ztree> mZtrees = initDeptZtree(mSysDepts);
		return mZtrees;
	}

	/**
	 * 初始化部门树
	 * 
	 * @param ztrees
	 * @param deptList
	 * @return
	 */
	private List<Ztree> initDeptZtree(List<SysDept> deptList) {
		List<Ztree> ztrees = new ArrayList<Ztree>();
		for (SysDept dept : deptList) {
			if (UserConstants.DEPT_NORMAL.equals(dept.getStatus())) {
				Ztree ztree = new Ztree();
				ztree.setId(dept.getId());
				ztree.setpId(dept.getParentId());
				ztree.setName(dept.getName());
				ztree.setTitle(dept.getName());
				// ztree.setNocheck(true);
				ztrees.add(ztree);
			}
		}
		return ztrees;
	}
	/**
	 * 根据父ID获取子部门
	 * 
	 * @param ztrees
	 * @param deptList
	 * @return
	 */
	@Override
	public List<Ztree> getDeptChildrenZtrees(SysDept dept) {
		List<SysDept> sysDepts = deptMapper.selectDeptChildrenList(dept);
		return initDeptZtree(sysDepts);
	}
	@Override
	public List<SysDept> getDeptsChildrenList(SysDept dept){
		List<SysDept> sysDepts = deptMapper.selectDeptChildrenList(dept);
		return sysDepts;
	}
}
