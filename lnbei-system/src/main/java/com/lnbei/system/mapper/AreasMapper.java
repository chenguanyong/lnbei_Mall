package com.lnbei.system.mapper;

import com.lnbei.system.domain.Areas;
import java.util.List;	

/**
 * 城市管理 数据层
 * 
 * @author lnbei
 * @date 2020-02-04
 */
public interface AreasMapper 
{
	/**
     * 查询城市管理信息
     * 
     * @param mid 城市管理ID
     * @return 城市管理信息
     */
	public Areas selectAreasById(String mid);
	
	/**
     * 查询城市管理列表
     * 
     * @param areas 城市管理信息
     * @return 城市管理集合
     */
	public List<Areas> selectAreasList(Areas areas);
	
	/**
     * 新增城市管理
     * 
     * @param areas 城市管理信息
     * @return 结果
     */
	public int insertAreas(Areas areas);
	
	/**
     * 修改城市管理
     * 
     * @param areas 城市管理信息
     * @return 结果
     */
	public int updateAreas(Areas areas);
	
	/**
     * 删除城市管理
     * 
     * @param mid 城市管理ID
     * @return 结果
     */
	public int deleteAreasById(String mid);
	
	/**
     * 批量删除城市管理
     * 
     * @param mids 需要删除的数据ID
     * @return 结果
     */
	public int deleteAreasByIds(String[] mids);
	/**
	 * 根据PanrentId查询数据
	 * @param parentId
	 * @return
	 */
	public List<Areas> selectAreasByParentId(String parentId);
	
}