package com.lnbei.system.mapper;

import com.lnbei.system.domain.SysLine;
import java.util.List;	

/**
 * 线 数据层
 * 
 * @author lnbei
 * @date 2019-03-11
 */
public interface SysLineMapper 
{
	/**
     * 查询线信息
     * 
     * @param id 线ID
     * @return 线信息
     */
	public SysLine selectLineById(String id);
	
	/**
     * 查询线列表
     * 
     * @param line 线信息
     * @return 线集合
     */
	public List<SysLine> selectLineList(SysLine line);
	
	/**
     * 新增线
     * 
     * @param line 线信息
     * @return 结果
     */
	public int insertLine(SysLine line);
	
	/**
     * 修改线
     * 
     * @param line 线信息
     * @return 结果
     */
	public int updateLine(SysLine line);
	
	/**
     * 删除线
     * 
     * @param id 线ID
     * @return 结果
     */
	public int deleteLineById(String id);
	
	/**
     * 批量删除线
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteLineByIds(String[] ids);
	
}