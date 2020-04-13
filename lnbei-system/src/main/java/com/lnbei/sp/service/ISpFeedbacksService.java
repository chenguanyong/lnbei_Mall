package com.lnbei.sp.service;

import com.lnbei.sp.domain.SpFeedbacks;
import java.util.List;

/**
 * 反馈 服务层
 * 
 * @author lnbei
 * @date 2020-03-23
 */
public interface ISpFeedbacksService 
{
	/**
     * 查询反馈信息
     * 
     * @param mid 反馈ID
     * @return 反馈信息
     */
	public SpFeedbacks selectSpFeedbacksById(String mid);
	
	/**
     * 查询反馈列表
     * 
     * @param spFeedbacks 反馈信息
     * @return 反馈集合
     */
	public List<SpFeedbacks> selectSpFeedbacksList(SpFeedbacks spFeedbacks);
	
	/**
     * 新增反馈
     * 
     * @param spFeedbacks 反馈信息
     * @return 结果
     */
	public int insertSpFeedbacks(SpFeedbacks spFeedbacks);
	
	/**
     * 修改反馈
     * 
     * @param spFeedbacks 反馈信息
     * @return 结果
     */
	public int updateSpFeedbacks(SpFeedbacks spFeedbacks);
		
	/**
     * 删除反馈信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSpFeedbacksByIds(String ids);
	
}
