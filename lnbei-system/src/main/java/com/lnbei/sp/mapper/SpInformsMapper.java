package com.lnbei.sp.mapper;

import com.lnbei.sp.domain.SpInforms;
import java.util.List;	

/**
 * 举报管理 数据层
 * 
 * @author lnbei
 * @date 2020-02-23
 */
public interface SpInformsMapper 
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
     * 删除举报管理
     * 
     * @param mid 举报管理ID
     * @return 结果
     */
	public int deleteSpInformsById(String mid);
	
	/**
     * 批量删除举报管理
     * 
     * @param mids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSpInformsByIds(String[] mids);
	
}