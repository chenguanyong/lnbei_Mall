package com.lnbei.system.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.lnbei.common.annotation.DataScope;
import com.lnbei.common.constant.UserConstants;
import com.lnbei.common.core.domain.Ztree;
import com.lnbei.common.core.text.Convert;
import com.lnbei.common.exception.BusinessException;
import com.lnbei.common.utils.Md5Utils;
import com.lnbei.common.utils.StringUtils;
import com.lnbei.oa.service.IOaMessageLogService;

import com.lnbei.system.domain.SysDept;
import com.lnbei.system.domain.SysPost;
import com.lnbei.system.domain.SysRole;
import com.lnbei.system.domain.SysUser;
import com.lnbei.system.domain.SysUserPost;
import com.lnbei.system.domain.SysUserRole;
import com.lnbei.system.mapper.SysDeptMapper;
import com.lnbei.system.mapper.SysPostMapper;
import com.lnbei.system.mapper.SysRoleMapper;
import com.lnbei.system.mapper.SysUserMapper;
import com.lnbei.system.mapper.SysUserPostMapper;
import com.lnbei.system.mapper.SysUserRoleMapper;
import com.lnbei.system.service.ISysConfigService;
import com.lnbei.system.service.ISysUserService;

/**
 * 用户 业务层处理
 * 
 * @author lnbei
 */
@Service
public class SysUserServiceImpl implements ISysUserService {
	private static final Logger log = LoggerFactory.getLogger(SysUserServiceImpl.class);

	@Autowired
	private SysUserMapper userMapper;

	@Autowired
	private SysRoleMapper roleMapper;

	@Autowired
	private SysPostMapper postMapper;

	@Autowired
	private SysUserPostMapper userPostMapper;

	@Autowired
	private SysUserRoleMapper userRoleMapper;

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private SysDeptMapper sysDeptMapper;
	
	@Autowired
	private IOaMessageLogService OaMessageLogService;
	

	/**
	 * 根据条件分页查询用户对象
	 * 
	 * @param user 用户信息
	 * 
	 * @return 用户信息集合信息
	 */
	@Override
	@DataScope(tableAlias = "u")
	public List<SysUser> selectUserList(SysUser user) {
		return userMapper.selectUserList(user);
	}

	/**
	 * 通过用户名查询用户
	 * 
	 * @param userName 用户名
	 * @return 用户对象信息
	 */
	@Override
	public SysUser selectUserByLoginName(String userName) {
		return userMapper.selectUserByLoginName(userName);
	}

	/**
	 * 通过手机号码查询用户
	 * 
	 * @param phoneNumber 手机号码
	 * @return 用户对象信息
	 */
	@Override
	public SysUser selectUserByPhoneNumber(String phoneNumber) {
		return userMapper.selectUserByPhoneNumber(phoneNumber);
	}

	/**
	 * 通过邮箱查询用户
	 * 
	 * @param email 邮箱
	 * @return 用户对象信息
	 */
	@Override
	public SysUser selectUserByEmail(String email) {
		return userMapper.selectUserByEmail(email);
	}

	/**
	 * 通过用户ID查询用户
	 * 
	 * @param userId 用户ID
	 * @return 用户对象信息
	 */
	@Override
	public SysUser selectUserById(String userId) {
		return userMapper.selectUserById(userId);
	}

	/**
	 * 通过用户ID删除用户
	 * 
	 * @param userId 用户ID
	 * @return 结果
	 */
	@Override
	public int deleteUserById(String userId) {
		// 删除用户与角色关联
		userRoleMapper.deleteUserRoleByUserId(userId);
		// 删除用户与岗位表
		userPostMapper.deleteUserPostByUserId(userId);
		return userMapper.deleteUserById(userId);
	}

	/**
	 * 批量删除用户信息
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	@Override
	public int deleteUserByIds(String ids) throws BusinessException {
		String[] userIds = Convert.toStrArray(ids);
		for (String userId : userIds) {
			if (SysUser.isAdmin(userId)) {
				throw new BusinessException("不允许删除超级管理员用户");
			}
		}
		return userMapper.deleteUserByIds(userIds);
	}

	/**
	 * 新增保存用户信息
	 * 
	 * @param user 用户信息
	 * @return 结果
	 */
	@Override
	@Transactional
	public int insertUser(SysUser user) {
		// user.setId(StringUtils.getUUID32());
		// 新增用户信息
		int rows = userMapper.insertUser(user);
		// 新增用户岗位关联
		insertUserPost(user);
		// 新增用户与角色管理
		insertUserRole(user);
		return rows;
	}

	/**
	 * 修改保存用户信息
	 * 
	 * @param user 用户信息
	 * @return 结果
	 */
	@Override
	@Transactional
	public int updateUser(SysUser user) {
		String userId = user.getId();
		
		// 删除用户与角色关联
		userRoleMapper.deleteUserRoleByUserId(userId);
		// 新增用户与角色管理
		insertUserRole(user);
		// 删除用户与岗位关联
		userPostMapper.deleteUserPostByUserId(userId);
		// 新增用户与岗位管理
		insertUserPost(user);
		return userMapper.updateUser(user);
	}

	/**
	 * 修改用户个人详细信息
	 * 
	 * @param user 用户信息
	 * @return 结果
	 */
	@Override
	public int updateUserInfo(SysUser user) {
		return userMapper.updateUser(user);
	}

	/**
	 * 修改用户密码
	 * 
	 * @param user 用户信息
	 * @return 结果
	 */
	@Override
	public int resetUserPwd(SysUser user) {
		return updateUserInfo(user);
	}

	/**
	 * 新增用户角色信息
	 * 
	 * @param user 用户对象
	 */
	public void insertUserRole(SysUser user) {
		String[] roles = user.getRoleIds();
		if (StringUtils.isNotNull(roles)) {
			// 新增用户与角色管理
			List<SysUserRole> list = new ArrayList<SysUserRole>();
			for (String roleId : roles) {
				SysUserRole ur = new SysUserRole();
				ur.setUserId(user.getId());
				ur.setRoleId(roleId);
				list.add(ur);
			}
			if (list.size() > 0) {
				userRoleMapper.batchUserRole(list);
			}
		}
	}

	/**
	 * 新增用户岗位信息
	 * 
	 * @param user 用户对象
	 */
	public void insertUserPost(SysUser user) {
		String[] posts = user.getPostIds();
		if (StringUtils.isNotNull(posts)) {
			// 新增用户与岗位管理
			List<SysUserPost> list = new ArrayList<SysUserPost>();
			for (String postId : posts) {
				SysUserPost up = new SysUserPost();
				up.setUserId(user.getId());
				up.setPostId(postId);
				list.add(up);
			}
			if (list.size() > 0) {
				userPostMapper.batchUserPost(list);
			}
		}
	}

	/**
	 * 校验用户名称是否唯一
	 * 
	 * @param loginName 用户名
	 * @return
	 */
	@Override
	public String checkLoginNameUnique(String loginName) {
		int count = userMapper.checkLoginNameUnique(loginName);
		if (count > 0) {
			return UserConstants.USER_NAME_NOT_UNIQUE;
		}
		return UserConstants.USER_NAME_UNIQUE;
	}

	/**
	 * 校验用户名称是否唯一
	 *
	 * @param user 用户信息
	 * @return
	 */
	@Override
	public String checkPhoneUnique(SysUser user) {
		String userId = StringUtils.isNull(user.getId()) ? "-1" : user.getId();
		SysUser info = userMapper.checkPhoneUnique(user.getPhone());
		if (StringUtils.isNotNull(info) && info.getId() != userId) {
			return UserConstants.USER_PHONE_NOT_UNIQUE;
		}
		return UserConstants.USER_PHONE_UNIQUE;
	}

	/**
	 * 校验email是否唯一
	 *
	 * @param user 用户信息
	 * @return
	 */
	@Override
	public String checkEmailUnique(SysUser user) {
		String userId = StringUtils.isNull(user.getId()) ? "-1" : user.getId();
		SysUser info = userMapper.checkEmailUnique(user.getEmail());
		if (StringUtils.isNotNull(info) && info.getId() != userId) {
			return UserConstants.USER_EMAIL_NOT_UNIQUE;
		}
		return UserConstants.USER_EMAIL_UNIQUE;
	}

	/**
	 * 查询用户所属角色组
	 * 
	 * @param userId 用户ID
	 * @return 结果
	 */
	@Override
	public String selectUserRoleGroup(String userId) {
		List<SysRole> list = roleMapper.selectRolesByUserId(userId);
		StringBuffer idsStr = new StringBuffer();
		for (SysRole role : list) {
			idsStr.append(role.getRoleName()).append(",");
		}
		if (StringUtils.isNotEmpty(idsStr.toString())) {
			return idsStr.substring(0, idsStr.length() - 1);
		}
		return idsStr.toString();
	}

	/**
	 * 查询用户所属岗位组
	 * 
	 * @param userId 用户ID
	 * @return 结果
	 */
	@Override
	public String selectUserPostGroup(String userId) {
		List<SysPost> list = postMapper.selectPostsByUserId(userId);
		StringBuffer idsStr = new StringBuffer();
		for (SysPost post : list) {
			idsStr.append(post.getPostName()).append(",");
		}
		if (StringUtils.isNotEmpty(idsStr.toString())) {
			return idsStr.substring(0, idsStr.length() - 1);
		}
		return idsStr.toString();
	}
	/**
	 * 查询用户所属岗位组
	 * 
	 * @param userId 用户ID
	 * @return 结果
	 */
	@Override
	public List<SysPost> selectUserPostGroupList(String userId) {
		List<SysPost> list = postMapper.selectPostsByUserId(userId);
		return list;
	}
	/**
	 * 导入用户数据
	 * 
	 * @param userList        用户数据列表
	 * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
	 * @param operName        操作用户
	 * @return 结果
	 */
	@Override
	public String importUser(List<SysUser> userList, Boolean isUpdateSupport, String operName) {
		if (StringUtils.isNull(userList) || userList.size() == 0) {
			throw new BusinessException("导入用户数据不能为空！");
		}
		int successNum = 0;
		int failureNum = 0;
		StringBuilder successMsg = new StringBuilder();
		StringBuilder failureMsg = new StringBuilder();
		String password = configService.selectConfigByKey("sys.user.initPassword");
		for (SysUser user : userList) {
			try {
				// 验证是否存在这个用户
				SysUser u = userMapper.selectUserByLoginName(user.getLogName());
				if (StringUtils.isNull(u)) {
					user.setPwd(Md5Utils.hash(user.getLogName() + password));
					user.setCreateBy(operName);
					this.insertUser(user);
					OaMessageLogService.sendMsg("user", user.getId(), 0, 0);//向子系统发送消息
					successNum++;
					successMsg.append("<br/>" + successNum + "、账号 " + user.getLogName() + " 导入成功");
				} else if (isUpdateSupport) {
					user.setUpdateBy(operName);
					this.updateUser(user);
					OaMessageLogService.sendMsg("user", user.getId(), 1, 0);//向子系统发送消息
					successNum++;
					successMsg.append("<br/>" + successNum + "、账号 " + user.getLogName() + " 更新成功");
				} else {
					failureNum++;
					failureMsg.append("<br/>" + failureNum + "、账号 " + user.getLogName() + " 已存在");
				}
			} catch (Exception e) {
				failureNum++;
				String msg = "<br/>" + failureNum + "、账号 " + user.getLogName() + " 导入失败：";
				failureMsg.append(msg + e.getMessage());
				log.error(msg, e);
			}
		}
		if (failureNum > 0) {
			failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
			throw new BusinessException(failureMsg.toString());
		} else {
			successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
		}
		return successMsg.toString();
	}

	/**
	 * 用户状态修改
	 * 
	 * @param user 用户信息
	 * @return 结果
	 */
	@Override
	public int changeStatus(SysUser user) {
		if (SysUser.isAdmin(user.getId())) {
			throw new BusinessException("不允许修改超级管理员用户");
		}
		return userMapper.updateUser(user);
	}

	/**
	 * 用户状态修改
	 * 
	 * @param user 用户信息
	 * @return 结果
	 */
	@Override
	public int changeSort(SysUser user) {
		if (SysUser.isAdmin(user.getId())) {
			throw new BusinessException("不允许修改超级管理员用户");
		}
		return userMapper.updateUser(user);
	}
	/**
	 * 获取用户和部门树根据制定角色ID
	 * 
	 * @param user 用户信息
	 * @return 结果
	 */
	@Override
	public List<Ztree> getUserDeptZtree(String roleId) {
		// TODO Auto-generated method stub
		List<String> mStrings = null;
		if(StringUtils.isNotEmpty(roleId)) {
			mStrings = userMapper.selectRoleUserTree(roleId);
		}
		List<SysDept> mSysDepts = sysDeptMapper.selectDeptAllList();
		List<SysUser> mSysUsers = userMapper.selectUserAllList("0");
		List<Ztree> mZtrees = new ArrayList<Ztree>();
		mZtrees = initDeptZtree(mZtrees, mSysDepts);
		mZtrees = initUserZtree(mZtrees, mSysUsers, mStrings);
		return mZtrees;
	}

	/**
	 * 初始化部门树
	 * 
	 * @param ztrees
	 * @param deptList
	 * @return
	 */
	private List<Ztree> initDeptZtree(List<Ztree> ztrees, List<SysDept> deptList) {

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
	 * 初始化用户树
	 * 
	 * @param ztrees
	 * @param userList
	 * @param roleUserList
	 * @return
	 */
	public List<Ztree> initUserZtree(List<Ztree> ztrees, List<SysUser> userList, List<String> roleUserList) {
		boolean isCheck = StringUtils.isNotNull(roleUserList);
		for (SysUser user : userList) {
			if (UserConstants.DEPT_NORMAL.equals(user.getStatus().toString())) {
				Ztree ztree = new Ztree();
				ztree.setId(user.getId());
				ztree.setpId(user.getDeptId());
				ztree.setName(user.getName());
				ztree.setTitle(user.getName());
				ztree.setNocheck(false);
				if (isCheck) {
					ztree.setChecked(roleUserList.contains(user.getId() + user.getLogName()));
				}
				ztrees.add(ztree);
			}
		}
		return ztrees;
	}

	/**
	 * 获取全部用户
	 * 
	 * @param delFlag 是否删除用户
	 * @return 结果
	 */
	@Override
	public List<SysUser> getAllUserList(String delFlag) {
		List<SysUser> mSysUsers = userMapper.selectUserAllList(delFlag);
		return mSysUsers;
	}
	/**
	 * 获取全部用户根据制定部门ID
	 * 
	 * @param delFlag 是否删除用户
	 * @return 结果
	 */
	@Override
	public List<SysUser> getUserByDeptId(String deptId) {
		// TODO Auto-generated method stub
		List<SysUser> mUsers = userMapper.selectUserListByDeptId(deptId);
		return mUsers;
	}
}
