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
import com.lnbei.member.domain.MemberRanksUser;
import com.lnbei.member.domain.MemberUser;
import com.lnbei.member.domain.MemberUserRanks;
import com.lnbei.member.service.IMemberRanksUserService;
import com.lnbei.member.service.IMemberUserRanksService;
import com.lnbei.member.service.IMemberUserService;
import com.lnbei.web.controller.common.CommonUnitBaseController;
import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.page.TableDataInfo;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.utils.poi.ExcelUtil;
import com.lnbei.framework.util.ShiroUtils;

/**
 * 会员等级 信息操作处理
 * 
 * @author lnbei
 * @date 2020-01-24
 */
@Controller
@RequestMapping("/member/memberUserRanks")
public class MemberUserRanksController extends CommonUnitBaseController
{
    private String prefix = "member/memberUserRanks";
	
	@Autowired
	private IMemberUserRanksService memberUserRanksService;
	@Autowired
	private IMemberUserService memberUserService; 
	@Autowired
	private IMemberRanksUserService memberRanksUserService;
	@RequiresPermissions("member:memberUserRanks:view")
	@GetMapping()
	public String memberUserRanks()
	{
	    return prefix + "/memberUserRanks";
	}
	
	/**
	 * 查询会员等级列表
	 */
	@RequiresPermissions("member:memberUserRanks:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(MemberUserRanks memberUserRanks)
	{
		startPage();
        List<MemberUserRanks> list = memberUserRanksService.selectMemberUserRanksList(memberUserRanks);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出会员等级列表
	 */
	@RequiresPermissions("member:memberUserRanks:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(MemberUserRanks memberUserRanks)
    {
    	List<MemberUserRanks> list = memberUserRanksService.selectMemberUserRanksList(memberUserRanks);
        ExcelUtil<MemberUserRanks> util = new ExcelUtil<MemberUserRanks>(MemberUserRanks.class);
        return util.exportExcel(list, "memberUserRanks");
    }
	
	/**
	 * 新增会员等级
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存会员等级
	 * @throws IOException 
	 */
	@RequiresPermissions("member:memberUserRanks:add")
	@Log(title = "会员等级", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(MemberUserRanks memberUserRanks, MultipartFile file) throws IOException
	{		
		if (file != null) {
			String filePath = uplodFile(file, true);
			memberUserRanks.setUserrankImg(filePath);
		}
		return toAjax(memberUserRanksService.insertMemberUserRanks(memberUserRanks, ShiroUtils.getUser()));
	}

	/**
	 * 修改会员等级
	 */
	@GetMapping("/edit/{mid}")
	public String edit(@PathVariable("mid") String mid, ModelMap mmap)
	{
		MemberUserRanks memberUserRanks = memberUserRanksService.selectMemberUserRanksById(mid);
		mmap.put("memberUserRanks", memberUserRanks);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存会员等级
	 * @throws IOException 
	 */
	@RequiresPermissions("member:memberUserRanks:edit")
	@Log(title = "会员等级", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(MemberUserRanks memberUserRanks, MultipartFile file) throws IOException
	{		
		if (file != null) {
			String filePath = uplodFile(file,true);
			memberUserRanks.setUserrankImg(filePath);
		}
		return toAjax(memberUserRanksService.updateMemberUserRanks(memberUserRanks, ShiroUtils.getUser()));
	}
	
	/**
	 * 删除会员等级
	 */
	@RequiresPermissions("member:memberUserRanks:remove")
	@Log(title = "会员等级", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(memberUserRanksService.deleteMemberUserRanksByIds(ids));
	}
	

    /**
     * 分配用户
     */
    @RequiresPermissions("system:role:edit")
    @GetMapping("/authUser/{ranksId}")
    public String authUser(@PathVariable("ranksId") String ranksId, ModelMap mmap)
    {
        mmap.put("memberUserRanks", memberUserRanksService.selectMemberUserRanksById(ranksId));
        return prefix + "/authUser";
    }
    
    /**
     * 查询已分配用户角色列表
     */
    @RequiresPermissions("system:role:list")
    @PostMapping("/authUser/allocatedList")
    @ResponseBody
    public TableDataInfo allocatedList(MemberUser memberUser)
    {
        startPage();
        memberUser.setLevelId(memberUser.getMid());
        List<MemberUser> list = memberUserService.selectAllocatedList(memberUser);
        return getDataTable(list);
    }
    /**
     * 取消授权
     */
    @Log(title = "角色管理", businessType = BusinessType.GRANT)
    @PostMapping("/authUser/cancel")
    @ResponseBody
    public AjaxResult cancelAuthUser(MemberRanksUser memberRanksUser)
    {
        return toAjax(memberUserRanksService.deleteAuthUser(memberRanksUser));
    }

    /**
     * 批量取消授权
     */
    @Log(title = "角色管理", businessType = BusinessType.GRANT)
    @PostMapping("/authUser/cancelAll")
    @ResponseBody
    public AjaxResult cancelAuthUserAll(String roleId, String userIds)
    {
        return toAjax(memberUserRanksService.deleteAuthUsers(roleId, userIds));
    }
    
    /**
     * 选择用户
     */
    @GetMapping("/authUser/selectUser/{ranksId}")
    public String selectUser(@PathVariable("ranksId") String ranksId, ModelMap mmap)
    {
        mmap.put("memberUserRanks", memberUserRanksService.selectMemberUserRanksById(ranksId));
        return prefix + "/selectUser";
    }

    /**
     * 查询未分配用户角色列表
     */
    @RequiresPermissions("system:role:list")
    @PostMapping("/authUser/unallocatedList")
    @ResponseBody
    public TableDataInfo unallocatedList(MemberUser user)
    {
        startPage();
        List<MemberUser> list = memberUserService.selectUnallocatedList(user);
        return getDataTable(list);
    }

    /**
     * 批量选择用户授权
     */
    @Log(title = "角色管理", businessType = BusinessType.GRANT)
    @PostMapping("/authUser/selectAll")
    @ResponseBody
    public AjaxResult selectAuthUserAll(String roleId, String userIds)
    {
        return toAjax(memberRanksUserService.insertAuthUsers(roleId, userIds));
    }

}
