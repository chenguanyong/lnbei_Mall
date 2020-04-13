package com.lnbei.sp.service;

import com.lnbei.sp.domain.SpRecommends;
import java.util.List;

/**
 * 推荐 服务层
 * 
 * @author lnbei
 * @date 2020-03-31
 */
public interface ISpRecommendsService 
{
	/**
     * 查询推荐信息
     * 
     * @param mid 推荐ID
     * @return 推荐信息
     */
	public SpRecommends selectSpRecommendsById(String mid);
	
	/**
     * 查询推荐列表
     * 
     * @param spRecommends 推荐信息
     * @return 推荐集合
     */
	public List<SpRecommends> selectSpRecommendsList(SpRecommends spRecommends);
	
	/**
     * 新增推荐
     * 
     * @param spRecommends 推荐信息
     * @return 结果
     */
	public int insertSpRecommends(SpRecommends spRecommends);
	
	/**
     * 修改推荐
     * 
     * @param spRecommends 推荐信息
     * @return 结果
     */
	public int updateSpRecommends(SpRecommends spRecommends);
		
	/**
     * 删除推荐信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSpRecommendsByIds(String ids);
	
}
