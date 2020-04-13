package com.lnbei.system.service;

import com.lnbei.common.core.domain.Ztree;
import com.lnbei.system.domain.Areas;
import java.util.List;

/**
 * 城市管理 服务层
 * 
 * @author lnbei
 * @date 2020-02-04
 */
public interface IAreasService 
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
     * 查询城市管理列表
     * 
     * @param areas 城市管理信息
     * @return 城市管理集合
     */
	public List<Areas> selectAreasListByParentId(String  panrentId);
		
	/**
     * 新增城市管理
     * 
     * @param areas 城市管理信息
     * @return 结果
     */
	public int insertAreas(Areas areas, Object user);
	
	/**
     * 修改城市管理
     * 
     * @param areas 城市管理信息
     * @return 结果
     */
	public int updateAreas(Areas areas, Object user);
		
	/**
     * 删除城市管理信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteAreasByIds(String ids);
	/**
	 * 查询树结构
	 * @param parentId
	 * @return
	 */
	public List<Ztree> getZtreeListByParentId(String parentId);
}
