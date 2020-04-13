package com.lnbei.oa.service;

import com.lnbei.oa.domain.OaSystenInterface;
import java.util.List;

/**
 * 接口管理 服务层
 * 
 * @author lnbei
 * @date 2019-03-19
 */
public interface IOaSystenInterfaceService 
{
	/**
     * 查询接口管理信息
     * 
     * @param id 接口管理ID
     * @return 接口管理信息
     */
	public OaSystenInterface selectOaSystenInterfaceById(String id);
	
	/**
     * 查询接口管理列表
     * 
     * @param oaSystenInterface 接口管理信息
     * @return 接口管理集合
     */
	public List<OaSystenInterface> selectOaSystenInterfaceList(OaSystenInterface oaSystenInterface);
	
	/**
     * 新增接口管理
     * 
     * @param oaSystenInterface 接口管理信息
     * @return 结果
     */
	public int insertOaSystenInterface(OaSystenInterface oaSystenInterface);
	
	/**
     * 修改接口管理
     * 
     * @param oaSystenInterface 接口管理信息
     * @return 结果
     */
	public int updateOaSystenInterface(OaSystenInterface oaSystenInterface);
		
	/**
     * 删除接口管理信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteOaSystenInterfaceByIds(String ids);
	
}
