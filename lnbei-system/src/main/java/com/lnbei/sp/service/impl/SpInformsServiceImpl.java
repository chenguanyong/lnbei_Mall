package com.lnbei.sp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnbei.sp.mapper.SpInformsMapper;
import com.lnbei.sp.domain.SpInforms;
import com.lnbei.sp.service.ISpInformsService;
import com.lnbei.common.core.text.Convert;

/**
 * 举报管理 服务层实现
 * 
 * @author lnbei
 * @date 2020-02-23
 */
@Service
public class SpInformsServiceImpl implements ISpInformsService 
{
	@Autowired
	private SpInformsMapper spInformsMapper;

	/**
     * 查询举报管理信息
     * 
     * @param mid 举报管理ID
     * @return 举报管理信息
     */
    @Override
	public SpInforms selectSpInformsById(String mid)
	{
	    return spInformsMapper.selectSpInformsById(mid);
	}
	
	/**
     * 查询举报管理列表
     * 
     * @param spInforms 举报管理信息
     * @return 举报管理集合
     */
	@Override
	public List<SpInforms> selectSpInformsList(SpInforms spInforms)
	{
	    return spInformsMapper.selectSpInformsList(spInforms);
	}
	
    /**
     * 新增举报管理
     * 
     * @param spInforms 举报管理信息
     * @return 结果
     */
	@Override
	public int insertSpInforms(SpInforms spInforms)
	{
	    return spInformsMapper.insertSpInforms(spInforms);
	}
	
	/**
     * 修改举报管理
     * 
     * @param spInforms 举报管理信息
     * @return 结果
     */
	@Override
	public int updateSpInforms(SpInforms spInforms)
	{
	    return spInformsMapper.updateSpInforms(spInforms);
	}

	/**
     * 删除举报管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSpInformsByIds(String ids)
	{
		return spInformsMapper.deleteSpInformsByIds(Convert.toStrArray(ids));
	}
	
}
