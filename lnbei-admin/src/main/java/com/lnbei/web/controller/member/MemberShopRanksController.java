package com.lnbei.web.controller.member;

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
import com.lnbei.common.annotation.Log;
import com.lnbei.common.enums.BusinessType;
import com.lnbei.member.domain.MemberRanksShop;
import com.lnbei.member.domain.MemberRanksUser;
import com.lnbei.member.domain.MemberShopRanks;
import com.lnbei.member.domain.MemberUser;
import com.lnbei.member.service.IMemberRanksShopService;
import com.lnbei.member.service.IMemberRanksUserService;
import com.lnbei.member.service.IMemberShopRanksService;
import com.lnbei.member.service.IMemberUserService;
import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.page.TableDataInfo;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.utils.poi.ExcelUtil;

/**
 * 商家等级 信息操作处理
 * 
 * @author lnbei
 * @date 2020-02-25
 */
@Controller
@RequestMapping("/member/memberShopRanks")
public class MemberShopRanksController extends BaseController
{
    private String prefix = "member/memberShopRanks";
	
	@Autowired
	private IMemberShopRanksService memberShopRanksService;
	@Autowired
	private IMemberUserService memberUserService; 
	@Autowired
	private IMemberRanksShopService memberRanksShopService;
	@RequiresPermissions("member:memberShopRanks:view")
	@GetMapping()
	public String memberShopRanks()
	{
	    return prefix + "/memberShopRanks";
	}
	
	/**
	 * 查询商家等级列表
	 */
	@RequiresPermissions("member:memberShopRanks:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(MemberShopRanks memberShopRanks)
	{
		startPage();
        List<MemberShopRanks> list = memberShopRanksService.selectMemberShopRanksList(memberShopRanks);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出商家等级列表
	 */
	@RequiresPermissions("member:memberShopRanks:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(MemberShopRanks memberShopRanks)
    {
    	List<MemberShopRanks> list = memberShopRanksService.selectMemberShopRanksList(memberShopRanks);
        ExcelUtil<MemberShopRanks> util = new ExcelUtil<MemberShopRanks>(MemberShopRanks.class);
        return util.exportExcel(list, "memberShopRanks");
    }
	
	/**
	 * 新增商家等级
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存商家等级
	 */
	@RequiresPermissions("member:memberShopRanks:add")
	@Log(title = "商家等级", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(MemberShopRanks memberShopRanks)
	{		
		return toAjax(memberShopRanksService.insertMemberShopRanks(memberShopRanks));
	}

	/**
	 * 修改商家等级
	 */
	@GetMapping("/edit/{mid}")
	public String edit(@PathVariable("mid") String mid, ModelMap mmap)
	{
		MemberShopRanks memberShopRanks = memberShopRanksService.selectMemberShopRanksById(mid);
		mmap.put("memberShopRanks", memberShopRanks);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存商家等级
	 */
	@RequiresPermissions("member:memberShopRanks:edit")
	@Log(title = "商家等级", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(MemberShopRanks memberShopRanks)
	{		
		return toAjax(memberShopRanksService.updateMemberShopRanks(memberShopRanks));
	}
	
	/**
	 * 删除商家等级
	 */
	@RequiresPermissions("member:memberShopRanks:remove")
	@Log(title = "商家等级", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(memberShopRanksService.deleteMemberShopRanksByIds(ids));
	}

    /**
     * 分配用户
     */
    @RequiresPermissions("system:role:edit")
    @GetMapping("/authUser/{ranksId}")
    public String authUser(@PathVariable("ranksId") String ranksId, ModelMap mmap)
    {
        mmap.put("memberShopRanks", memberShopRanksService.selectMemberShopRanksById(ranksId));
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
        List<MemberUser> list = memberUserService.selectAllocatedShopList(memberUser);
        return getDataTable(list);
    }
    /**
     * 取消授权
     */
    @Log(title = "角色管理", businessType = BusinessType.GRANT)
    @PostMapping("/authUser/cancel")
    @ResponseBody
    public AjaxResult cancelAuthUser(MemberRanksShop memberRanksShop)
    {
        return toAjax(memberRanksShopService.deleteAuthUser(memberRanksShop));
    }

    /**
     * 批量取消授权
     */
    @Log(title = "角色管理", businessType = BusinessType.GRANT)
    @PostMapping("/authUser/cancelAll")
    @ResponseBody
    public AjaxResult cancelAuthUserAll(String roleId, String userIds)
    {
        return toAjax(memberRanksShopService.deleteAuthUsers(roleId, userIds));
    }
    
    /**
     * 选择用户
     */
    @GetMapping("/authUser/selectUser/{ranksId}")
    public String selectUser(@PathVariable("ranksId") String ranksId, ModelMap mmap)
    {
        mmap.put("memberShopRanks", memberShopRanksService.selectMemberShopRanksById(ranksId));
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
       
        List<MemberUser> list = memberUserService.selectUnallocatedShopList(user);
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
        return toAjax(memberRanksShopService.insertAuthUsers(roleId, userIds));
    }
    /**
     * 角色分配数据权限
     */
    @GetMapping("/authDataScope/{mid}")
    public String authDataScope(@PathVariable("mid") String mid, ModelMap mmap)
    {
    	 mmap.put("memberShopRanks", memberShopRanksService.selectMemberShopRanksById(mid));
        return prefix + "/dataScope";
    }

    /**
     * 保存角色分配数据权限
     */
    @RequiresPermissions("system:role:edit")
    @Log(title = "角色管理", businessType = BusinessType.UPDATE)
    @PostMapping("/authDataScope")
    @ResponseBody
    public AjaxResult authDataScopeSave(MemberShopRanks memberShopRanks)
    {
        return toAjax(memberShopRanksService.authDataScope(memberShopRanks));
    }
}
