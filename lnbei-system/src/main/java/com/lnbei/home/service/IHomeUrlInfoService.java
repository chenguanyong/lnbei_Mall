package com.lnbei.home.service;

import com.lnbei.home.domain.HomeUrlInfo;
import java.util.List;

/**
 * 链接内容 服务层
 * 
 * @author lnbei
 * @date 2020-01-24
 */
public interface IHomeUrlInfoService 
{
	/**
     * 查询链接内容信息
     * 
     * @param mid 链接内容ID
     * @return 链接内容信息
     */
	public HomeUrlInfo selectHomeUrlInfoById(String mid);
	
	/**
     * 查询链接内容列表
     * 
     * @param homeUrlInfo 链接内容信息
     * @return 链接内容集合
     */
	public List<HomeUrlInfo> selectHomeUrlInfoList(HomeUrlInfo homeUrlInfo);
	
	/**
     * 新增链接内容
     * 
     * @param homeUrlInfo 链接内容信息
     * @return 结果
     */
	public int insertHomeUrlInfo(HomeUrlInfo homeUrlInfo, Object user);
	
	/**
     * 修改链接内容
     * 
     * @param homeUrlInfo 链接内容信息
     * @return 结果
     */
	public int updateHomeUrlInfo(HomeUrlInfo homeUrlInfo, Object user);
		
	/**
     * 删除链接内容信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteHomeUrlInfoByIds(String ids);
	
}
