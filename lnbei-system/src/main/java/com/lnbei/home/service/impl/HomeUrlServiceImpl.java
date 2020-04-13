package com.lnbei.home.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnbei.home.mapper.HomeUrlMapper;
import com.lnbei.home.domain.HomeUrl;
import com.lnbei.home.service.IHomeUrlService;
import com.lnbei.common.core.text.Convert;

/**
 * 链接详情 服务层实现
 * 
 * @author lnbei
 * @date 2020-01-24
 */
@Service
public class HomeUrlServiceImpl implements IHomeUrlService 
{
	@Autowired
	private HomeUrlMapper homeUrlMapper;

	/**
     * 查询链接详情信息
     * 
     * @param mid 链接详情ID
     * @return 链接详情信息
     */
    @Override
	public HomeUrl selectHomeUrlById(String mid)
	{
    	
	    return homeUrlMapper.selectHomeUrlById(mid);
	}
	
	/**
     * 查询链接详情列表
     * 
     * @param homeUrl 链接详情信息
     * @return 链接详情集合
     */
	@Override
	public List<HomeUrl> selectHomeUrlList(HomeUrl homeUrl)
	{
	    return homeUrlMapper.selectHomeUrlList(homeUrl);
	}
	
    /**
     * 新增链接详情
     * 
     * @param homeUrl 链接详情信息
     * @return 结果
     */
	@Override
	public int insertHomeUrl(HomeUrl homeUrl, Object user)
	{
		homeUrl.initInsert(user);
	    return homeUrlMapper.insertHomeUrl(homeUrl);
	}
	
	/**
     * 修改链接详情
     * 
     * @param homeUrl 链接详情信息
     * @return 结果
     */
	@Override
	public int updateHomeUrl(HomeUrl homeUrl, Object user)
	{
		homeUrl.initUpdate(user);
	    return homeUrlMapper.updateHomeUrl(homeUrl);
	}

	/**
     * 删除链接详情对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteHomeUrlByIds(String ids)
	{
		return homeUrlMapper.deleteHomeUrlByIds(Convert.toStrArray(ids));
	}
	/***
	 * 改变状态
	 */
	@Override
	public int changeStatus(HomeUrl mHomeUrl) {
		
		return homeUrlMapper.changeStatus(mHomeUrl);
	}
}
