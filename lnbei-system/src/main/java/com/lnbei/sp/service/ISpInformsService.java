package com.lnbei.sp.service;

import com.lnbei.sp.domain.SpInforms;
import java.util.List;

/**
 * 举报管理 服务层
 * 
 * @author lnbei
 * @date 2020-02-23
 */
public interface ISpInformsService 
{
	/**
     * 查询举报管理信息
     * 
     * @param mid 举报管理ID
     * @return 举报管理信息
     */
	public SpInforms selectSpInformsById(String mid);
	
	/**
     * 查询举报管理列表
     * 
     * @param spInforms 举报管理信息
     * @return 举报管理集合
     */
	public List<SpInforms> selectSpInformsList(SpInforms spInforms);
	
	/**
     * 新增举报管理
     * 
     * @param spInforms 举报管理信息
     * @return 结果
     */
	public int insertSpInforms(SpInforms spInforms);
	
	/**
     * 修改举报管理
     * 
     * @param spInforms 举报管理信息
     * @return 结果
     */
	public int updateSpInforms(SpInforms spInforms);
		
	/**
     * 删除举报管理信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSpInformsByIds(String ids);
	
}
