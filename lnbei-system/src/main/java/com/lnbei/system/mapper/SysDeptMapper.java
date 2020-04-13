package com.lnbei.system.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.lnbei.system.domain.SysDept;

/**
 * 部门管理 数据层
 * 
 * @author lnbei
 */
public interface SysDeptMapper {
	/**
	 * 查询部门人数
	 * 
	 * @param dept 部门信息
	 * @return 结果
	 */
	public int selectDeptCount(SysDept dept);

	/**
	 * 查询部门是否存在用户
	 * 
	 * @param deptId 部门ID
	 * @return 结果
	 */
	public int checkDeptExistUser(String deptId);

	/**
	 * 查询部门管理数据
	 * 
	 * @param dept 部门信息
	 * @return 部门信息集合
	 */
	public List<SysDept> selectDeptList(SysDept dept);

	/**
	 * 删除部门管理信息
	 * 
	 * @param deptId 部门ID
	 * @return 结果
	 */
	public int deleteDeptById(String deptId);

	/**
	 * 新增部门信息
	 * 
	 * @param dept 部门信息
	 * @return 结果
	 */
	public int insertDept(SysDept dept);

	/**
	 * 修改部门信息
	 * 
	 * @param dept 部门信息
	 * @return 结果
	 */
	public int updateDept(SysDept dept);

	/**
	 * 修改子元素关系
	 * 
	 * @param depts 子元素
	 * @return 结果
	 */
	public int updateDeptChildren(@Param("depts") List<SysDept> depts);

	/**
	 * 根据部门ID查询信息
	 * 
	 * @param deptId 部门ID
	 * @return 部门信息
	 */
	public SysDept selectDeptById(String deptId);

	/**
	 * 校验部门名称是否唯一
	 * 
	 * @param deptName 部门名称
	 * @param parentId 父部门ID
	 * @return 结果
	 */
	public SysDept checkDeptNameUnique(@Param("deptName") String deptName, @Param("parentId") String parentId);

	/**
	 * 根据角色ID查询部门
	 *
	 * @param roleId 角色ID
	 * @return 部门列表
	 */
	public List<String> selectRoleDeptTree(String roleId);

	/**
	 * 修改所在部门的父级部门状态
	 * 
	 * @param dept 部门
	 */
	public void updateDeptStatus(@Param("deptIDs") List<String> deptIDs);

	/**
	 * 修改所在部门的排序值
	 * 
	 * @param dept 部门
	 */
	public int updateDeptSort(SysDept dept);

	/**
	 * 获取全部部门数据
	 * 
	 * @param dept 部门
	 */
	public List<SysDept> selectDeptAllList();

	/**
	 * 根据部门父ID获取子部门
	 * 
	 * @param dept 部门
	 */	
	public List<SysDept> selectDeptChildrenList(SysDept sysDept);
}
