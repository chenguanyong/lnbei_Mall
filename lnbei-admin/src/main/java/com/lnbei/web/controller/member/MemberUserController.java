package com.lnbei.web.controller.member;

import java.io.IOException;
import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.lnbei.common.annotation.Log;
import com.lnbei.common.enums.BusinessType;
import com.lnbei.member.domain.MemberUser;
import com.lnbei.member.domain.MemberUserRanks;
import com.lnbei.member.service.IMemberUserRanksService;
import com.lnbei.member.service.IMemberUserService;
import com.lnbei.web.controller.common.CommonUnitBaseController;
import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.page.TableDataInfo;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.utils.poi.ExcelUtil;
import com.lnbei.framework.util.ShiroUtils;

/**
 * 会员 信息操作处理
 * 
 * @author lnbei
 * @date 2020-01-24
 */
@Controller
@RequestMapping("/member/memberUser")
public class MemberUserController extends CommonUnitBaseController {
	private String prefix = "member/memberUser";

	@Autowired
	private IMemberUserService memberUserService;
	@Autowired
	private IMemberUserRanksService memberUserRanksService;

	@RequiresPermissions("member:memberUser:view")
	@GetMapping()
	public String memberUser() {
		return prefix + "/memberUser";
	}

	/**
	 * 查询会员列表
	 */
	@RequiresPermissions("member:memberUser:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(MemberUser memberUser) {
		startPage();
		List<MemberUser> list = memberUserService.selectMemberUserList(memberUser);
		return getDataTable(list);
	}

	/**
	 * 导出会员列表
	 */
	@RequiresPermissions("member:memberUser:export")
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(MemberUser memberUser) {
		List<MemberUser> list = memberUserService.selectMemberUserList(memberUser);
		ExcelUtil<MemberUser> util = new ExcelUtil<MemberUser>(MemberUser.class);
		return util.exportExcel(list, "memberUser");
	}

	/**
	 * 新增会员
	 */
	@GetMapping("/add")
	public String add(MemberUser memberUser, ModelMap mmMap) {
		MemberUserRanks mmMemberUserRanks = new MemberUserRanks();
		List<MemberUserRanks> memberUserRanks = memberUserRanksService.selectMemberUserRanksList(mmMemberUserRanks);
		mmMap.put("memberUserRanks", memberUserRanks);
		return prefix + "/add";
	}

	@GetMapping("/adds")
	public String adds(MemberUser memberUser, ModelMap mmMap) {
		MemberUserRanks mmMemberUserRanks = new MemberUserRanks();
		List<MemberUserRanks> memberUserRanks = memberUserRanksService.selectMemberUserRanksList(mmMemberUserRanks);
		mmMap.put("memberUserRanks", memberUserRanks);
		return prefix + "/adds";
	}

	/**
	 * 新增保存会员
	 * 
	 * @throws IOException
	 */
	@RequiresPermissions("member:memberUser:add")
	@Log(title = "会员", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(MemberUser memberUser, MultipartFile file) throws IOException {
		if (file != null) {
			String photoString = uplodFile(file, true);
			memberUser.setUserPhoto(photoString);
		}

		return toAjax(memberUserService.insertMemberUser(memberUser, ShiroUtils.getUser()));
	}

	/**
	 * 新增保存会员
	 * 
	 * @throws IOException
	 */
	@RequiresPermissions("member:memberUser:adds")
	@Log(title = "会员", businessType = BusinessType.INSERT)
	@PostMapping("/adds")
	@ResponseBody
	public AjaxResult addsSave(MemberUser memberUser, Integer userSize) throws IOException {

		return toAjax(memberUserService.insertsMemberUser(memberUser, userSize, ShiroUtils.getUser()));
	}

	/**
	 * 修改会员
	 */
	@GetMapping("/edit/{mid}")
	public String edit(@PathVariable("mid") String mid, ModelMap mmap) {
		MemberUser memberUser = memberUserService.selectMemberUserById(mid);
		mmap.put("memberUser", memberUser);
		return prefix + "/edit";
	}

	/**
	 * 修改保存会员
	 * 
	 * @throws IOException
	 */
	@RequiresPermissions("member:memberUser:edit")
	@Log(title = "会员", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(MemberUser memberUser, MultipartFile file) throws IOException {
		if (file != null) {
			String photoString = uplodFile(file, true);
			memberUser.setUserPhoto(photoString);
		}
		return toAjax(memberUserService.updateMemberUser(memberUser, ShiroUtils.getUser()));
	}

	/**
	 * 修改保存会员
	 * 
	 * @throws IOException
	 */
	@RequiresPermissions("member:memberUser:activeMemberUser")
	@Log(title = "会员", businessType = BusinessType.UPDATE)
	@PostMapping("/activeMemberUser")
	@ResponseBody
	public AjaxResult activeMemberUser(MemberUser memberUser) throws IOException {
		return toAjax(memberUserService.activateMemberUser(memberUser, ShiroUtils.getUser()));
	}

	/**
	 * 删除会员
	 */
	@RequiresPermissions("member:memberUser:remove")
	@Log(title = "会员", businessType = BusinessType.DELETE)
	@PostMapping("/remove")
	@ResponseBody
	public AjaxResult remove(String ids) {
		return toAjax(memberUserService.deleteMemberUserByIds(ids));
	}

	/**
	 * 删除会员
	 */
	@RequiresPermissions("member:memberUser:activateMemberUser")
	@Log(title = "会员", businessType = BusinessType.UPDATE)
	@PostMapping("/activateMemberUser")
	@ResponseBody
	public AjaxResult activateMemberUser(MemberUser memberUser) {
		return toAjax(memberUserService.activateMemberUser(memberUser));
	}

	/**
	 * 删除会员
	 */
	@RequiresPermissions("member:memberUser:resetMemberUserPaw")
	@Log(title = "会员", businessType = BusinessType.UPDATE)
	@PostMapping("/resetMemberUserPaw")
	@ResponseBody
	public AjaxResult resetMemberUserPaw(MemberUser memberUser) {
		return toAjax(memberUserService.resetMemberUserPaw(memberUser));
	}
}
