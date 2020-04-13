package com.lnbei.web.controller.api.sso;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.lnbei.common.core.controller.BaseController;
import com.lnbei.system.domain.SysRole;
import com.lnbei.system.service.ISysRoleService;


@Controller
@RequestMapping("/api/role")
public class ApiRoleController extends BaseController {

	@Autowired
	private ISysRoleService roleService;

	@GetMapping("/getRoleListByUserId/{userId}")
	@ResponseBody
	public List<SysRole> getRoleListByUserId(@PathVariable("userId")String userId) {
		List<SysRole> mSysRoles = roleService.selectRolesByUserId(userId);
		return mSysRoles;
	}
	@GetMapping("/getRoleByRoleId/{roleId}")
	@ResponseBody
	public SysRole getRoleByRoleId(@PathVariable("roleId")String roleId) {
		SysRole mSysRole = roleService.selectRoleById(roleId);
		return mSysRole;
	}
}
