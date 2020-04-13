package com.lnbei.sp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnbei.sp.mapper.SpFeedbacksMapper;
import com.lnbei.sp.domain.SpFeedbacks;
import com.lnbei.sp.service.ISpFeedbacksService;
import com.lnbei.common.core.text.Convert;

/**
 * 反馈 服务层实现
 * 
 * @author lnbei
 * @date 2020-03-23
 */
@Service
public class SpFeedbacksServiceImpl implements ISpFeedbacksService 
{
	@Autowired
	private SpFeedbacksMapper spFeedbacksMapper;

	/**
     * 查询反馈信息
     * 
     * @param mid 反馈ID
     * @return 反馈信息
     */
    @Override
	public SpFeedbacks selectSpFeedbacksById(String mid)
	{
	    return spFeedbacksMapper.selectSpFeedbacksById(mid);
	}
	
	/**
     * 查询反馈列表
     * 
     * @param spFeedbacks 反馈信息
     * @return 反馈集合
     */
	@Override
	public List<SpFeedbacks> selectSpFeedbacksList(SpFeedbacks spFeedbacks)
	{
	    return spFeedbacksMapper.selectSpFeedbacksList(spFeedbacks);
	}
	
    /**
     * 新增反馈
     * 
     * @param spFeedbacks 反馈信息
     * @return 结果
     */
	@Override
	public int insertSpFeedbacks(SpFeedbacks spFeedbacks)
	{
	    return spFeedbacksMapper.insertSpFeedbacks(spFeedbacks);
	}
	
	/**
     * 修改反馈
     * 
     * @param spFeedbacks 反馈信息
     * @return 结果
     */
	@Override
	public int updateSpFeedbacks(SpFeedbacks spFeedbacks)
	{
	    return spFeedbacksMapper.updateSpFeedbacks(spFeedbacks);
	}

	/**
     * 删除反馈对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSpFeedbacksByIds(String ids)
	{
		return spFeedbacksMapper.deleteSpFeedbacksByIds(Convert.toStrArray(ids));
	}
	
}
