package com.lnbei.web.controller.system;

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
import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.core.domain.Ztree;
import com.lnbei.common.enums.BusinessType;
import com.lnbei.common.utils.StringUtils;
import com.lnbei.framework.util.ShiroUtils;
import com.lnbei.member.domain.MemberUserRanks;
import com.lnbei.system.domain.SysMenu;
import com.lnbei.system.domain.SysRole;
import com.lnbei.system.service.ISysMenuService;

/**
 * 菜单信息
 * 
 * @author lnbei
 */
@Controller
@RequestMapping("/system/menu")
public class SysMenuController extends BaseController
{
    private String prefix = "system/menu";

    @Autowired
    private ISysMenuService menuService;

    @RequiresPermissions("system:menu:view")
    @GetMapping()
    public String menu()
    {
        return prefix + "/menu";
    }

    @RequiresPermissions("system:menu:list")
    @GetMapping("/list")
    @ResponseBody
    public List<SysMenu> list(SysMenu menu)
    {
        List<SysMenu> menuList = menuService.selectMenuList(menu);
        return menuList;
    }

    /**
     * 删除菜单
     */
    @Log(title = "菜单管理", businessType = BusinessType.DELETE)
    @RequiresPermissions("system:menu:remove")
    @GetMapping("/remove/{menuId}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("menuId") String menuId)
    {
        if (menuService.selectCountMenuByParentId(menuId) > 0)
        {
            return error(1, "存在子菜单,不允许删除");
        }
        if (menuService.selectCountRoleMenuByMenuId(menuId) > 0)
        {
            return error(1, "菜单已分配,不允许删除");
        }
        ShiroUtils.clearCachedAuthorizationInfo();
        return toAjax(menuService.deleteMenuById(menuId));
    }

    /**
     * 新增
     */
    @GetMapping("/add/{parentId}")
    public String add(@PathVariable("parentId") String parentId, ModelMap mmap)
    {
        SysMenu menu = null;
        if (!parentId.equals("0"))
        {
            menu = menuService.selectMenuById(parentId);
        }
        else
        {
            menu = new SysMenu();
            menu.setMenuId("0");
            menu.setMenuName("主目录");
        }
        mmap.put("menu", menu);
        return prefix + "/add";
    }

    /**
     * 新增保存菜单
     */
    @Log(title = "菜单管理", businessType = BusinessType.INSERT)
    @RequiresPermissions("system:menu:add")
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysMenu menu)
    {
        menu.setCreateBy(ShiroUtils.getLoginName());
        ShiroUtils.clearCachedAuthorizationInfo();
        return toAjax(menuService.insertMenu(menu));
    }

    /**
     * 修改菜单
     */
    @GetMapping("/edit/{menuId}")
    public String edit(@PathVariable("menuId") String menuId, ModelMap mmap)
    {
        mmap.put("menu", menuService.selectMenuById(menuId));
        return prefix + "/edit";
    }

    /**
     * 修改保存菜单
     */
    @Log(title = "菜单管理", businessType = BusinessType.UPDATE)
    @RequiresPermissions("system:menu:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysMenu menu)
    {
        menu.setUpdateBy(ShiroUtils.getLoginName());
        ShiroUtils.clearCachedAuthorizationInfo();
        return toAjax(menuService.updateMenu(menu));
    }

    /**
     * 选择菜单图标
     */
    @GetMapping("/icon")
    public String icon()
    {
        return prefix + "/icon";
    }

    /**
     * 校验菜单名称
     */
    @PostMapping("/checkMenuNameUnique")
    @ResponseBody
    public String checkMenuNameUnique(SysMenu menu)
    {
        return menuService.checkMenuNameUnique(menu);
    }

    /**
     * 加载角色菜单列表树
     */
    @GetMapping("/roleMenuTreeData/{menuAttr}")
    @ResponseBody
    public List<Ztree> roleMenuTreeData(@PathVariable("menuAttr") String menuAttr, SysRole role)
    {
    	if(StringUtils.isEmpty(menuAttr)) {
    		menuAttr="0";
    	}
        List<Ztree> ztrees = menuService.roleMenuTreeData(menuAttr, role);
        return ztrees;
    }
    /**
     * 加载角色菜单列表树
     */
    @GetMapping("/memberRanksMenuTreeData/{menuAttr}")
    @ResponseBody
    public List<Ztree> memberRanksMenuTreeData(@PathVariable("menuAttr") String menuAttr, MemberUserRanks memberUserRanks)
    {
    	if(StringUtils.isEmpty(menuAttr)) {
    		menuAttr="1";
    	}
        List<Ztree> ztrees = menuService.memberRanksMenuTreeData(menuAttr, memberUserRanks);
        return ztrees;
    }
    /**
     * 加载所有菜单列表树
     */
    @GetMapping("/menuTreeData")
    @ResponseBody
    public List<Ztree> menuTreeData(SysRole role)
    {
        List<Ztree> ztrees = menuService.menuTreeData();
        return ztrees;
    }

    /**
     * 选择菜单树
     */
    @GetMapping("/selectMenuTree/{menuId}")
    public String selectMenuTree(@PathVariable("menuId") String menuId, ModelMap mmap)
    {
    	SysMenu menu = new SysMenu();
    	menu =  menuService.selectMenuById(menuId);
    	if(menu == null) {
    		menu = new SysMenu();
    		menu.setMenuId("0");
    		menu.setMenuName("顶级");
    	}
    	
        mmap.put("menu",menu);
        return prefix + "/tree";
    }
}