package com.lnbei.system.mapper;

import com.lnbei.system.domain.SysStation;
import java.util.List;	

/**
 * 站 数据层
 * 
 * @author lnbei
 * @date 2019-03-11
 */
public interface SysStationMapper 
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
     * 删除站
     * 
     * @param id 站ID
     * @return 结果
     */
	public int deleteSysStationById(String id);
	
	/**
     * 批量删除站
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSysStationByIds(String[] ids);
	
	/**
	 * 获取站的数量根据线ID
	 * @param lineID
	 * @return
	 */
	public int countSysStationByLineID(String lineID) ;
	
}