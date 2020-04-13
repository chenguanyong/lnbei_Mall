package com.lnbei.home.mapper;

import com.lnbei.home.domain.HomeUrlInfo;
import java.util.List;	

/**
 * 链接内容 数据层
 * 
 * @author lnbei
 * @date 2020-01-24
 */
public interface HomeUrlInfoMapper 
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
	public int insertHomeUrlInfo(HomeUrlInfo homeUrlInfo);
	
	/**
     * 修改链接内容
     * 
     * @param homeUrlInfo 链接内容信息
     * @return 结果
     */
	public int updateHomeUrlInfo(HomeUrlInfo homeUrlInfo);
	
	/**
     * 删除链接内容
     * 
     * @param mid 链接内容ID
     * @return 结果
     */
	public int deleteHomeUrlInfoById(String mid);
	
	/**
     * 批量删除链接内容
     * 
     * @param mids 需要删除的数据ID
     * @return 结果
     */
	public int deleteHomeUrlInfoByIds(String[] mids);
	
}