package com.lnbei.home.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnbei.home.mapper.HomeUrlInfoMapper;
import com.lnbei.home.domain.HomeUrlInfo;
import com.lnbei.home.service.IHomeUrlInfoService;
import com.lnbei.common.core.text.Convert;

/**
 * 链接内容 服务层实现
 * 
 * @author lnbei
 * @date 2020-01-24
 */
@Service
public class HomeUrlInfoServiceImpl implements IHomeUrlInfoService 
{
	@Autowired
	private HomeUrlInfoMapper homeUrlInfoMapper;

	/**
     * 查询链接内容信息
     * 
     * @param mid 链接内容ID
     * @return 链接内容信息
     */
    @Override
	public HomeUrlInfo selectHomeUrlInfoById(String mid)
	{
	    return homeUrlInfoMapper.selectHomeUrlInfoById(mid);
	}
	
	/**
     * 查询链接内容列表
     * 
     * @param homeUrlInfo 链接内容信息
     * @return 链接内容集合
     */
	@Override
	public List<HomeUrlInfo> selectHomeUrlInfoList(HomeUrlInfo homeUrlInfo)
	{
	    return homeUrlInfoMapper.selectHomeUrlInfoList(homeUrlInfo);
	}
	
    /**
     * 新增链接内容
     * 
     * @param homeUrlInfo 链接内容信息
     * @return 结果
     */
	@Override
	public int insertHomeUrlInfo(HomeUrlInfo homeUrlInfo, Object user)
	{
		homeUrlInfo.initInsert(user);
	    return homeUrlInfoMapper.insertHomeUrlInfo(homeUrlInfo);
	}
	
	/**
     * 修改链接内容
     * 
     * @param homeUrlInfo 链接内容信息
     * @return 结果
     */
	@Override
	public int updateHomeUrlInfo(HomeUrlInfo homeUrlInfo, Object user)
	{
		homeUrlInfo.initUpdate(user);
	    return homeUrlInfoMapper.updateHomeUrlInfo(homeUrlInfo);
	}

	/**
     * 删除链接内容对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteHomeUrlInfoByIds(String ids)
	{
		return homeUrlInfoMapper.deleteHomeUrlInfoByIds(Convert.toStrArray(ids));
	}
	
}
