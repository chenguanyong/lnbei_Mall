package com.lnbei.home.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnbei.home.mapper.HomeArticleInfoMapper;
import com.lnbei.home.domain.HomeArticleInfo;
import com.lnbei.home.service.IHomeArticleInfoService;
import com.lnbei.common.core.text.Convert;

/**
 * 文章详情 服务层实现
 * 
 * @author lnbei
 * @date 2020-01-24
 */
@Service
public class HomeArticleInfoServiceImpl implements IHomeArticleInfoService 
{
	@Autowired
	private HomeArticleInfoMapper homeArticleInfoMapper;

	/**
     * 查询文章详情信息
     * 
     * @param mid 文章详情ID
     * @return 文章详情信息
     */
    @Override
	public HomeArticleInfo selectHomeArticleInfoById(String mid)
	{
	    return homeArticleInfoMapper.selectHomeArticleInfoById(mid);
	}
	
	/**
     * 查询文章详情列表
     * 
     * @param homeArticleInfo 文章详情信息
     * @return 文章详情集合
     */
	@Override
	public List<HomeArticleInfo> selectHomeArticleInfoList(HomeArticleInfo homeArticleInfo)
	{
	    return homeArticleInfoMapper.selectHomeArticleInfoList(homeArticleInfo);
	}
	
    /**
     * 新增文章详情
     * 
     * @param homeArticleInfo 文章详情信息
     * @return 结果
     */
	@Override
	public int insertHomeArticleInfo(HomeArticleInfo homeArticleInfo, Object user)
	{
		homeArticleInfo.initInsert(user);
	    return homeArticleInfoMapper.insertHomeArticleInfo(homeArticleInfo);
	}
	
	/**
     * 修改文章详情
     * 
     * @param homeArticleInfo 文章详情信息
     * @return 结果
     */
	@Override
	public int updateHomeArticleInfo(HomeArticleInfo homeArticleInfo, Object user)
	{
		homeArticleInfo.initUpdate(user);
	    return homeArticleInfoMapper.updateHomeArticleInfo(homeArticleInfo);
	}

	/**
     * 删除文章详情对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteHomeArticleInfoByIds(String ids)
	{
		return homeArticleInfoMapper.deleteHomeArticleInfoByIds(Convert.toStrArray(ids));
	}
	
}
