package com.lnbei.home.service;

import com.lnbei.home.domain.HomeArticleInfo;
import java.util.List;

/**
 * 文章详情 服务层
 * 
 * @author lnbei
 * @date 2020-01-24
 */
public interface IHomeArticleInfoService 
{
	/**
     * 查询文章详情信息
     * 
     * @param mid 文章详情ID
     * @return 文章详情信息
     */
	public HomeArticleInfo selectHomeArticleInfoById(String mid);
	
	/**
     * 查询文章详情列表
     * 
     * @param homeArticleInfo 文章详情信息
     * @return 文章详情集合
     */
	public List<HomeArticleInfo> selectHomeArticleInfoList(HomeArticleInfo homeArticleInfo);
	
	/**
     * 新增文章详情
     * 
     * @param homeArticleInfo 文章详情信息
     * @return 结果
     */
	public int insertHomeArticleInfo(HomeArticleInfo homeArticleInfo, Object user);
	
	/**
     * 修改文章详情
     * 
     * @param homeArticleInfo 文章详情信息
     * @return 结果
     */
	public int updateHomeArticleInfo(HomeArticleInfo homeArticleInfo, Object user);
		
	/**
     * 删除文章详情信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteHomeArticleInfoByIds(String ids);
	
}
