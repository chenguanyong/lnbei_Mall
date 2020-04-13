package com.lnbei.sp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnbei.sp.mapper.SpGoodsAttributesMapper;
import com.lnbei.sp.domain.SpGoodsAttributes;
import com.lnbei.sp.service.ISpGoodsAttributesService;
import com.lnbei.common.core.text.Convert;

/**
 * 商品属性 服务层实现
 * 
 * @author lnbei
 * @date 2020-02-05
 */
@Service
public class SpGoodsAttributesServiceImpl implements ISpGoodsAttributesService 
{
	@Autowired
	private SpGoodsAttributesMapper spGoodsAttributesMapper;

	/**
     * 查询商品属性信息
     * 
     * @param mid 商品属性ID
     * @return 商品属性信息
     */
    @Override
	public SpGoodsAttributes selectSpGoodsAttributesById(String mid)
	{
	    return spGoodsAttributesMapper.selectSpGoodsAttributesById(mid);
	}
	
	/**
     * 查询商品属性列表
     * 
     * @param spGoodsAttributes 商品属性信息
     * @return 商品属性集合
     */
	@Override
	public List<SpGoodsAttributes> selectSpGoodsAttributesList(SpGoodsAttributes spGoodsAttributes)
	{
	    return spGoodsAttributesMapper.selectSpGoodsAttributesList(spGoodsAttributes);
	}
	
    /**
     * 新增商品属性
     * 
     * @param spGoodsAttributes 商品属性信息
     * @return 结果
     */
	@Override
	public int insertSpGoodsAttributes(SpGoodsAttributes spGoodsAttributes)
	{
	    return spGoodsAttributesMapper.insertSpGoodsAttributes(spGoodsAttributes);
	}
	
	/**
     * 修改商品属性
     * 
     * @param spGoodsAttributes 商品属性信息
     * @return 结果
     */
	@Override
	public int updateSpGoodsAttributes(SpGoodsAttributes spGoodsAttributes)
	{
	    return spGoodsAttributesMapper.updateSpGoodsAttributes(spGoodsAttributes);
	}

	/**
     * 删除商品属性对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSpGoodsAttributesByIds(String ids)
	{
		return spGoodsAttributesMapper.deleteSpGoodsAttributesByIds(Convert.toStrArray(ids));
	}
	
}
