package com.lnbei.sp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnbei.sp.mapper.SpSpecItemsMapper;
import com.lnbei.sp.domain.SpSpecItems;
import com.lnbei.sp.service.ISpSpecItemsService;
import com.lnbei.common.core.text.Convert;

/**
 * 规格值 服务层实现
 * 
 * @author lnbei
 * @date 2020-02-05
 */
@Service
public class SpSpecItemsServiceImpl implements ISpSpecItemsService 
{
	@Autowired
	private SpSpecItemsMapper spSpecItemsMapper;

	/**
     * 查询规格值信息
     * 
     * @param mid 规格值ID
     * @return 规格值信息
     */
    @Override
	public SpSpecItems selectSpSpecItemsById(String mid)
	{
	    return spSpecItemsMapper.selectSpSpecItemsById(mid);
	}
	
	/**
     * 查询规格值列表
     * 
     * @param spSpecItems 规格值信息
     * @return 规格值集合
     */
	@Override
	public List<SpSpecItems> selectSpSpecItemsList(SpSpecItems spSpecItems)
	{
	    return spSpecItemsMapper.selectSpSpecItemsList(spSpecItems);
	}
	
    /**
     * 新增规格值
     * 
     * @param spSpecItems 规格值信息
     * @return 结果
     */
	@Override
	public int insertSpSpecItems(SpSpecItems spSpecItems)
	{
	    return spSpecItemsMapper.insertSpSpecItems(spSpecItems);
	}
	
	/**
     * 修改规格值
     * 
     * @param spSpecItems 规格值信息
     * @return 结果
     */
	@Override
	public int updateSpSpecItems(SpSpecItems spSpecItems)
	{
	    return spSpecItemsMapper.updateSpSpecItems(spSpecItems);
	}

	/**
     * 删除规格值对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSpSpecItemsByIds(String ids)
	{
		return spSpecItemsMapper.deleteSpSpecItemsByIds(Convert.toStrArray(ids));
	}
	
}
