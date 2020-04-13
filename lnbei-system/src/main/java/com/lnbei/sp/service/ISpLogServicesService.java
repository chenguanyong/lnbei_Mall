package com.lnbei.sp.service;

import com.lnbei.sp.domain.SpLogServices;
import java.util.List;

/**
 * 售后服务ID 服务层
 * 
 * @author lnbei
 * @date 2020-03-23
 */
public interface ISpLogServicesService 
{
	/**
     * 查询售后服务ID信息
     * 
     * @param mid 售后服务IDID
     * @return 售后服务ID信息
     */
	public SpLogServices selectSpLogServicesById(Integer mid);
	
	/**
     * 查询售后服务ID列表
     * 
     * @param spLogServices 售后服务ID信息
     * @return 售后服务ID集合
     */
	public List<SpLogServices> selectSpLogServicesList(SpLogServices spLogServices);
	
	/**
     * 新增售后服务ID
     * 
     * @param spLogServices 售后服务ID信息
     * @return 结果
     */
	public int insertSpLogServices(SpLogServices spLogServices);
	
	/**
     * 修改售后服务ID
     * 
     * @param spLogServices 售后服务ID信息
     * @return 结果
     */
	public int updateSpLogServices(SpLogServices spLogServices);
		
	/**
     * 删除售后服务ID信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSpLogServicesByIds(String ids);
	
}
