package com.lnbei.system.mapper;

import java.util.List;
import com.lnbei.system.domain.SysUserRole;

/**
 * 用户表 数据层
 * 
 * @author lnbei
 */
public interface SysUserRoleMapper
{
    /**
     * 通过用户ID删除用户和角色关联
     * 
     * @param userId 用户ID
     * @return 结果
     */
    public int deleteUserRoleByUserId(String userId);

    /**
     * 批量删除用户和角色关联
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteUserRole(String[] ids);

    /**
     * 通过角色ID查询角色使用数量
     * 
     * @param roleId 角色ID
     * @return 结果
     */
    public int countUserRoleByRoleId(String roleId);

    /**
     * 批量新增用户角色信息
     * 
     * @param userRoleList 用户角色列表
     * @return 结果
     */
    public int batchUserRole(List<SysUserRole> userRoleList);
    /**
     * 批量删除用户和角色关联,根据角色ID
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteRoleUser(String roleId);
}
