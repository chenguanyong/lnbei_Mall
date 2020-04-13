package com.lnbei.sp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnbei.sp.mapper.SpFriendlinksMapper;
import com.lnbei.sp.domain.SpFriendlinks;
import com.lnbei.sp.service.ISpFriendlinksService;
import com.lnbei.common.core.text.Convert;

/**
 * 友情链接 服务层实现
 * 
 * @author lnbei
 * @date 2020-03-23
 */
@Service
public class SpFriendlinksServiceImpl implements ISpFriendlinksService 
{
	@Autowired
	private SpFriendlinksMapper spFriendlinksMapper;

	/**
     * 查询友情链接信息
     * 
     * @param mid 友情链接ID
     * @return 友情链接信息
     */
    @Override
	public SpFriendlinks selectSpFriendlinksById(String mid)
	{
	    return spFriendlinksMapper.selectSpFriendlinksById(mid);
	}
	
	/**
     * 查询友情链接列表
     * 
     * @param spFriendlinks 友情链接信息
     * @return 友情链接集合
     */
	@Override
	public List<SpFriendlinks> selectSpFriendlinksList(SpFriendlinks spFriendlinks)
	{
	    return spFriendlinksMapper.selectSpFriendlinksList(spFriendlinks);
	}
	
    /**
     * 新增友情链接
     * 
     * @param spFriendlinks 友情链接信息
     * @return 结果
     */
	@Override
	public int insertSpFriendlinks(SpFriendlinks spFriendlinks)
	{
	    return spFriendlinksMapper.insertSpFriendlinks(spFriendlinks);
	}
	
	/**
     * 修改友情链接
     * 
     * @param spFriendlinks 友情链接信息
     * @return 结果
     */
	@Override
	public int updateSpFriendlinks(SpFriendlinks spFriendlinks)
	{
	    return spFriendlinksMapper.updateSpFriendlinks(spFriendlinks);
	}

	/**
     * 删除友情链接对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSpFriendlinksByIds(String ids)
	{
		return spFriendlinksMapper.deleteSpFriendlinksByIds(Convert.toStrArray(ids));
	}
	
}
