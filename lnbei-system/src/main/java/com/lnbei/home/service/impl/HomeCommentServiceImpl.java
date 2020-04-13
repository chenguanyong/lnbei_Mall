package com.lnbei.home.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnbei.home.mapper.HomeCommentMapper;
import com.lnbei.home.domain.HomeComment;
import com.lnbei.home.service.IHomeCommentService;
import com.lnbei.common.core.text.Convert;

/**
 * 评论 服务层实现
 * 
 * @author lnbei
 * @date 2020-02-01
 */
@Service
public class HomeCommentServiceImpl implements IHomeCommentService {
	@Autowired
	private HomeCommentMapper homeCommentMapper;

	/**
	 * 查询评论信息
	 * 
	 * @param mid 评论ID
	 * @return 评论信息
	 */
	@Override
	public HomeComment selectHomeCommentById(String mid) {
		return homeCommentMapper.selectHomeCommentById(mid);
	}

	/**
	 * 查询评论列表
	 * 
	 * @param homeComment 评论信息
	 * @return 评论集合
	 */
	@Override
	public List<HomeComment> selectHomeCommentList(HomeComment homeComment) {
		return homeCommentMapper.selectHomeCommentList(homeComment);
	}

	/**
	 * 新增评论
	 * 
	 * @param homeComment 评论信息
	 * @return 结果
	 */
	@Override
	public int insertHomeComment(HomeComment homeComment, Object user) {
		homeComment.initInsert(user);
		return homeCommentMapper.insertHomeComment(homeComment);
	}

	/**
	 * 修改评论
	 * 
	 * @param homeComment 评论信息
	 * @return 结果
	 */
	@Override
	public int updateHomeComment(HomeComment homeComment, Object user) {
		homeComment.initUpdate(user);
		return homeCommentMapper.updateHomeComment(homeComment);
	}

	/**
	 * 删除评论对象
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	@Override
	public int deleteHomeCommentByIds(String ids) {
		return homeCommentMapper.deleteHomeCommentByIds(Convert.toStrArray(ids));
	}

	/**
	 * 改变状态
	 * 
	 * @param mCategory
	 * @return
	 */
	@Override
	public int changeStatus(HomeComment homeComment) {
		return homeCommentMapper.changeStatus(homeComment);
	}
}
