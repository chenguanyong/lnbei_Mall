package com.lnbei.home.service;

import com.lnbei.home.domain.HomeComment;
import java.util.List;

/**
 * 评论 服务层
 * 
 * @author lnbei
 * @date 2020-02-01
 */
public interface IHomeCommentService 
{
	/**
     * 查询评论信息
     * 
     * @param mid 评论ID
     * @return 评论信息
     */
	public HomeComment selectHomeCommentById(String mid);
	
	/**
     * 查询评论列表
     * 
     * @param homeComment 评论信息
     * @return 评论集合
     */
	public List<HomeComment> selectHomeCommentList(HomeComment homeComment);
	
	/**
     * 新增评论
     * 
     * @param homeComment 评论信息
     * @return 结果
     */
	public int insertHomeComment(HomeComment homeComment, Object user);
	
	/**
     * 修改评论
     * 
     * @param homeComment 评论信息
     * @return 结果
     */
	public int updateHomeComment(HomeComment homeComment, Object user);
		
	/**
     * 删除评论信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteHomeCommentByIds(String ids);
	
	/**
	 * 改变状态
	 * @param mCategory
	 * @return
	 */
	public int changeStatus(HomeComment homeComment);
	
}
