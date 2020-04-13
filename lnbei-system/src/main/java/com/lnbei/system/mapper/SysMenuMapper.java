package com.lnbei.system.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.lnbei.system.domain.SysMenu;

/**
 * 菜单表 数据层
 * 
 * @author lnbei
 */
public interface SysMenuMapper
{
    /**
     * 查询系统所有菜单（含按钮）
     * 
     * @return 菜单列表
     */
    public List<SysMenu> selectMenuAll();
    
    /**
     * 查询系统正常显示菜单（不含按钮）
     * 
     * @return 菜单列表
     */
    public List<SysMenu> selectMenuNormalAll(String menuAttr);
    
    /**
     * 根据用户ID查询菜单
     * 
     * @param userId 用户ID
     * @return 菜单列表
     */
    public List<SysMenu> selectMenusByUserId(String userId);
    /**
     * 根据店铺用户Id查询菜单
     * @param memberId
     * @return
     */
    public List<SysMenu> selectShopMenusByMemberId(String memberId);
    /**
     * 根据用户Id查询菜单
     * @param memberId
     * @return
     */
    public List<SysMenu> selectMemberMenusByMemberId(String memberId);
    /**
     * 根据用户ID查询权限
     * 
     * @param userId 用户ID
     * @return 权限列表
     */
    public List<String> selectPermsByUserId(String userId);

    /**
     * 根据角色ID查询菜单
     * 
     * @param roleId 角色ID
     * @return 菜单列表
     */
    public List<String> selectMenuTree(String roleId);
    /**
     * 根据角色ID和菜单属性查询菜单
     * 
     * @param roleId 角色ID
     * @return 菜单列表
     */
    public List<String> selectMemberMenuTree(@Param("ranksId")String ranksId, @Param("menuAttr")String menuAttr);

    /**
     * 查询系统菜单列表
     * 
     * @param menu 菜单信息
     * @return 菜单列表
     */
    public List<SysMenu> selectMenuList(SysMenu menu);

    /**
     * 删除菜单管理信息
     * 
     * @param menuId 菜单ID
     * @return 结果
     */
    public int deleteMenuById(String menuId);

    /**
     * 根据菜单ID查询信息
     * 
     * @param menuId 菜单ID
     * @return 菜单信息
     */
    public SysMenu selectMenuById(String menuId);

    /**
     * 查询菜单数量
     * 
     * @param parentId 菜单父ID
     * @return 结果
     */
    public int selectCountMenuByParentId(String parentId);

    /**
     * 新增菜单信息
     * 
     * @param menu 菜单信息
     * @return 结果
     */
    public int insertMenu(SysMenu menu);

    /**
     * 修改菜单信息
     * 
     * @param menu 菜单信息
     * @return 结果
     */
    public int updateMenu(SysMenu menu);

    /**
     * 校验菜单名称是否唯一
     * 
     * @param menuName 菜单名称
     * @param parentId 父菜单ID
     * @return 结果
     */
    public SysMenu checkMenuNameUnique(@Param("menuName") String menuName, @Param("parentId") String parentId);
    
    /**
     * 根据用户ID和身份查询权限
     * @param memberId
     * @param identity
     * @return
     */
    public List<String> selectPermsByMemberIdAndIdentity(@Param("memberId") String memberId, @Param("identity") String identity);
    /**
     * 查询数据更具菜单属性
     * @param menuAttr
     * @return
     */
    public List<SysMenu> selectMenuAllByMenuAttr(String menuAttr);
}
