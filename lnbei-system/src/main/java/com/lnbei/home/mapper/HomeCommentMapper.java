package com.lnbei.home.mapper;

import com.lnbei.home.domain.HomeArticle;
import com.lnbei.home.domain.HomeComment;
import java.util.List;	

/**
 * 评论 数据层
 * 
 * @author lnbei
 * @date 2020-02-01
 */
public interface HomeCommentMapper 
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
	public int insertHomeComment(HomeComment homeComment);
	
	/**
     * 修改评论
     * 
     * @param homeComment 评论信息
     * @return 结果
     */
	public int updateHomeComment(HomeComment homeComment);
	
	/**
     * 删除评论
     * 
     * @param mid 评论ID
     * @return 结果
     */
	public int deleteHomeCommentById(String mid);
	
	/**
     * 批量删除评论
     * 
     * @param mids 需要删除的数据ID
     * @return 结果
     */
	public int deleteHomeCommentByIds(String[] mids);
	
	/**
	 * 改变状态
	 * @param mCategory
	 * @return
	 */
	public int changeStatus(HomeComment homeComment);
	
}