package com.lnbei.sp.mapper;

import com.lnbei.sp.domain.SpFriendlinks;
import java.util.List;	

/**
 * 友情链接 数据层
 * 
 * @author lnbei
 * @date 2020-03-23
 */
public interface SpFriendlinksMapper 
{
	/**
     * 查询友情链接信息
     * 
     * @param mid 友情链接ID
     * @return 友情链接信息
     */
	public SpFriendlinks selectSpFriendlinksById(String mid);
	
	/**
     * 查询友情链接列表
     * 
     * @param spFriendlinks 友情链接信息
     * @return 友情链接集合
     */
	public List<SpFriendlinks> selectSpFriendlinksList(SpFriendlinks spFriendlinks);
	
	/**
     * 新增友情链接
     * 
     * @param spFriendlinks 友情链接信息
     * @return 结果
     */
	public int insertSpFriendlinks(SpFriendlinks spFriendlinks);
	
	/**
     * 修改友情链接
     * 
     * @param spFriendlinks 友情链接信息
     * @return 结果
     */
	public int updateSpFriendlinks(SpFriendlinks spFriendlinks);
	
	/**
     * 删除友情链接
     * 
     * @param mid 友情链接ID
     * @return 结果
     */
	public int deleteSpFriendlinksById(String mid);
	
	/**
     * 批量删除友情链接
     * 
     * @param mids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSpFriendlinksByIds(String[] mids);
	
}