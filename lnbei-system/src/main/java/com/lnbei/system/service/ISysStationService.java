package com.lnbei.system.service;

import com.lnbei.system.domain.SysStation;
import java.util.List;

/**
 * 站 服务层
 * 
 * @author lnbei
 * @date 2019-03-11
 */
public interface ISysStationService 
{
	/**
     * 查询站信息
     * 
     * @param id 站ID
     * @return 站信息
     */
	public SysStation selectSysStationById(String id);
	
	/**
     * 查询站列表
     * 
     * @param sysStation 站信息
     * @return 站集合
     */
	public List<SysStation> selectSysStationList(SysStation sysStation);
	
	/**
     * 新增站
     * 
     * @param sysStation 站信息
     * @return 结果
     */
	public int insertSysStation(SysStation sysStation);
	
	/**
     * 修改站
     * 
     * @param sysStation 站信息
     * @return 结果
     */
	public int updateSysStation(SysStation sysStation);
		
	/**
     * 删除站信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSysStationByIds(String ids);
	
}
