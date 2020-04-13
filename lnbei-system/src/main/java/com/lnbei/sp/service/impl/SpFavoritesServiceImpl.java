package com.lnbei.sp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnbei.sp.mapper.SpFavoritesMapper;
import com.lnbei.sp.domain.SpFavorites;
import com.lnbei.sp.service.ISpFavoritesService;
import com.lnbei.common.core.text.Convert;

/**
 * 收藏 服务层实现
 * 
 * @author lnbei
 * @date 2020-03-23
 */
@Service
public class SpFavoritesServiceImpl implements ISpFavoritesService 
{
	@Autowired
	private SpFavoritesMapper spFavoritesMapper;

	/**
     * 查询收藏信息
     * 
     * @param mid 收藏ID
     * @return 收藏信息
     */
    @Override
	public SpFavorites selectSpFavoritesById(String mid)
	{
	    return spFavoritesMapper.selectSpFavoritesById(mid);
	}
	
	/**
     * 查询收藏列表
     * 
     * @param spFavorites 收藏信息
     * @return 收藏集合
     */
	@Override
	public List<SpFavorites> selectSpFavoritesList(SpFavorites spFavorites)
	{
	    return spFavoritesMapper.selectSpFavoritesList(spFavorites);
	}
	
    /**
     * 新增收藏
     * 
     * @param spFavorites 收藏信息
     * @return 结果
     */
	@Override
	public int insertSpFavorites(SpFavorites spFavorites)
	{
	    return spFavoritesMapper.insertSpFavorites(spFavorites);
	}
	
	/**
     * 修改收藏
     * 
     * @param spFavorites 收藏信息
     * @return 结果
     */
	@Override
	public int updateSpFavorites(SpFavorites spFavorites)
	{
	    return spFavoritesMapper.updateSpFavorites(spFavorites);
	}

	/**
     * 删除收藏对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSpFavoritesByIds(String ids)
	{
		return spFavoritesMapper.deleteSpFavoritesByIds(Convert.toStrArray(ids));
	}
	
}
