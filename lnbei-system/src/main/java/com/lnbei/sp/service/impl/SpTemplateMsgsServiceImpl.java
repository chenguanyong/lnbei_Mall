package com.lnbei.sp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnbei.sp.mapper.SpTemplateMsgsMapper;
import com.lnbei.sp.domain.SpTemplateMsgs;
import com.lnbei.sp.service.ISpTemplateMsgsService;
import com.lnbei.common.core.text.Convert;

/**
 * 消息模板 服务层实现
 * 
 * @author lnbei
 * @date 2020-02-23
 */
@Service
public class SpTemplateMsgsServiceImpl implements ISpTemplateMsgsService 
{
	@Autowired
	private SpTemplateMsgsMapper spTemplateMsgsMapper;

	/**
     * 查询消息模板信息
     * 
     * @param mid 消息模板ID
     * @return 消息模板信息
     */
    @Override
	public SpTemplateMsgs selectSpTemplateMsgsById(String mid)
	{
	    return spTemplateMsgsMapper.selectSpTemplateMsgsById(mid);
	}
	
	/**
     * 查询消息模板列表
     * 
     * @param spTemplateMsgs 消息模板信息
     * @return 消息模板集合
     */
	@Override
	public List<SpTemplateMsgs> selectSpTemplateMsgsList(SpTemplateMsgs spTemplateMsgs)
	{
	    return spTemplateMsgsMapper.selectSpTemplateMsgsList(spTemplateMsgs);
	}
	
    /**
     * 新增消息模板
     * 
     * @param spTemplateMsgs 消息模板信息
     * @return 结果
     */
	@Override
	public int insertSpTemplateMsgs(SpTemplateMsgs spTemplateMsgs)
	{
	    return spTemplateMsgsMapper.insertSpTemplateMsgs(spTemplateMsgs);
	}
	
	/**
     * 修改消息模板
     * 
     * @param spTemplateMsgs 消息模板信息
     * @return 结果
     */
	@Override
	public int updateSpTemplateMsgs(SpTemplateMsgs spTemplateMsgs)
	{
	    return spTemplateMsgsMapper.updateSpTemplateMsgs(spTemplateMsgs);
	}

	/**
     * 删除消息模板对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSpTemplateMsgsByIds(String ids)
	{
		return spTemplateMsgsMapper.deleteSpTemplateMsgsByIds(Convert.toStrArray(ids));
	}
	
}
