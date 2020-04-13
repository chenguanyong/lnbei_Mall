package com.lnbei.sp.service;

import com.lnbei.sp.domain.SpFavorites;
import java.util.List;

/**
 * 收藏 服务层
 * 
 * @author lnbei
 * @date 2020-03-23
 */
public interface ISpFavoritesService 
{
	/**
     * 查询收藏信息
     * 
     * @param mid 收藏ID
     * @return 收藏信息
     */
	public SpFavorites selectSpFavoritesById(String mid);
	
	/**
     * 查询收藏列表
     * 
     * @param spFavorites 收藏信息
     * @return 收藏集合
     */
	public List<SpFavorites> selectSpFavoritesList(SpFavorites spFavorites);
	
	/**
     * 新增收藏
     * 
     * @param spFavorites 收藏信息
     * @return 结果
     */
	public int insertSpFavorites(SpFavorites spFavorites);
	
	/**
     * 修改收藏
     * 
     * @param spFavorites 收藏信息
     * @return 结果
     */
	public int updateSpFavorites(SpFavorites spFavorites);
		
	/**
     * 删除收藏信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSpFavoritesByIds(String ids);
	
}
