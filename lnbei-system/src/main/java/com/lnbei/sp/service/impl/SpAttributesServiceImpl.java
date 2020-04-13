package com.lnbei.sp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnbei.sp.mapper.SpAttributesMapper;
import com.lnbei.sp.domain.SpAttributes;
import com.lnbei.sp.service.ISpAttributesService;
import com.lnbei.common.core.text.Convert;

/**
 * 商品属性 服务层实现
 * 
 * @author lnbei
 * @date 2020-02-05
 */
@Service
public class SpAttributesServiceImpl implements ISpAttributesService 
{
	@Autowired
	private SpAttributesMapper spAttributesMapper;

	/**
     * 查询商品属性信息
     * 
     * @param mid 商品属性ID
     * @return 商品属性信息
     */
    @Override
	public SpAttributes selectSpAttributesById(String mid)
	{
	    return spAttributesMapper.selectSpAttributesById(mid);
	}
	
	/**
     * 查询商品属性列表
     * 
     * @param spAttributes 商品属性信息
     * @return 商品属性集合
     */
	@Override
	public List<SpAttributes> selectSpAttributesList(SpAttributes spAttributes)
	{
	    return spAttributesMapper.selectSpAttributesList(spAttributes);
	}
	
    /**
     * 新增商品属性
     * 
     * @param spAttributes 商品属性信息
     * @return 结果
     */
	@Override
	public int insertSpAttributes(SpAttributes spAttributes)
	{
	    return spAttributesMapper.insertSpAttributes(spAttributes);
	}
	
	/**
     * 修改商品属性
     * 
     * @param spAttributes 商品属性信息
     * @return 结果
     */
	@Override
	public int updateSpAttributes(SpAttributes spAttributes)
	{
	    return spAttributesMapper.updateSpAttributes(spAttributes);
	}

	/**
     * 删除商品属性对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSpAttributesByIds(String ids)
	{
		return spAttributesMapper.deleteSpAttributesByIds(Convert.toStrArray(ids));
	}
	
}
