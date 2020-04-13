package com.lnbei.home.service;


import com.lnbei.home.domain.HomeUrl;
import java.util.List;

/**
 * 链接详情 服务层
 * 
 * @author lnbei
 * @date 2020-01-24
 */
public interface IHomeUrlService 
{
	/**
     * 查询链接详情信息
     * 
     * @param mid 链接详情ID
     * @return 链接详情信息
     */
	public HomeUrl selectHomeUrlById(String mid);
	
	/**
     * 查询链接详情列表
     * 
     * @param homeUrl 链接详情信息
     * @return 链接详情集合
     */
	public List<HomeUrl> selectHomeUrlList(HomeUrl homeUrl);
	
	/**
     * 新增链接详情
     * 
     * @param homeUrl 链接详情信息
     * @return 结果
     */
	public int insertHomeUrl(HomeUrl homeUrl, Object user);
	
	/**
     * 修改链接详情
     * 
     * @param homeUrl 链接详情信息
     * @return 结果
     */
	public int updateHomeUrl(HomeUrl homeUrl, Object user);
		
	/**
     * 删除链接详情信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteHomeUrlByIds(String ids);
	/**
	 * 改变状态
	 * @param mCategory
	 * @return
	 */
	public int changeStatus(HomeUrl mHomeUrl);
}
