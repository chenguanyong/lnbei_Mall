package com.lnbei.web.controller.api.sso;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.core.domain.Ztree;
import com.lnbei.system.domain.SysPost;
import com.lnbei.system.domain.SysUser;
import com.lnbei.system.service.impl.SysUserServiceImpl;

@Controller
@RequestMapping("/api/user")
public class ApiUserController extends BaseController {

	@Autowired
	private SysUserServiceImpl userService;

	@GetMapping("/getAllUsers")
	@ResponseBody
	public List<SysUser> getAllUsers() {
		List<SysUser> sysUserList = userService.getAllUserList("0");
		return sysUserList;
	}

	/**
	 * 根据指定的用户Id获取用户详细信息
	 * 
	 * @param userId
	 * @return
	 */
	@GetMapping("/getUsersByUserId/{userId}")
	@ResponseBody
	public SysUser getUsersByUserId(String userId) {
		SysUser mSysUser = userService.selectUserById(userId);
		return mSysUser;
	}

	/**
	 * 获取用户和部门树
	 * 
	 * @return
	 */
	@GetMapping("/getUserAndDeptZtreeList")
	@ResponseBody
	public List<Ztree> getUserAndDeptZtreeList() {

		List<Ztree> mZtrees = userService.getUserDeptZtree(null);
		return mZtrees;
	}

	/**
	 * 获取用户和部门树
	 * 
	 * @return
	 */
	@GetMapping("/getUserListByDeptId/{DeptId}")
	@ResponseBody
	public List<SysUser> getUserListByDeptId(String DeptId) {
		// List<SysUser> mUsers = userService
		return null;
	}

	@GetMapping("/getUserListByLoginName/{LoginName}")
	@ResponseBody
	public SysUser getUserListByLoginName(String LoginName) {
		SysUser mUsers = userService.selectUserByLoginName(LoginName);
		return mUsers;
	}

	@GetMapping("/checkLoginNameUnique/{LoginName}")
	@ResponseBody
	public AjaxResult checkLoginNameUnique(String LoginName) {
		String result = userService.checkLoginNameUnique(LoginName);
		return toAjax(Integer.parseInt(result));
	}

	@GetMapping("/checkPhoneUnique")
	@ResponseBody
	public AjaxResult checkPhoneUnique(SysUser user) {

		String result = userService.checkPhoneUnique(user);
		return toAjax(Integer.parseInt(result));
	}

	@GetMapping("/selectUserRoleGroup/{userId}")
	@ResponseBody
	public AjaxResult selectUserRoleGroup(String userId) {
		String result = userService.selectUserRoleGroup(userId);
		return toAjax(Integer.parseInt(result));
	}

	@GetMapping("/selectUserPostGroupList/{userId}")
	@ResponseBody
	public List<SysPost> selectUserPostGroupList(String userId) {
		List<SysPost> result = userService.selectUserPostGroupList(userId);
		return result;
	}
}
