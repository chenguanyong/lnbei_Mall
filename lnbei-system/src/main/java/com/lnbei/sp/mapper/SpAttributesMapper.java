package com.lnbei.sp.mapper;

import com.lnbei.sp.domain.SpAttributes;
import java.util.List;	

/**
 * 商品属性 数据层
 * 
 * @author lnbei
 * @date 2020-02-05
 */
public interface SpAttributesMapper 
{
	/**
     * 查询商品属性信息
     * 
     * @param mid 商品属性ID
     * @return 商品属性信息
     */
	public SpAttributes selectSpAttributesById(String mid);
	
	/**
     * 查询商品属性列表
     * 
     * @param spAttributes 商品属性信息
     * @return 商品属性集合
     */
	public List<SpAttributes> selectSpAttributesList(SpAttributes spAttributes);
	
	/**
     * 新增商品属性
     * 
     * @param spAttributes 商品属性信息
     * @return 结果
     */
	public int insertSpAttributes(SpAttributes spAttributes);
	
	/**
     * 修改商品属性
     * 
     * @param spAttributes 商品属性信息
     * @return 结果
     */
	public int updateSpAttributes(SpAttributes spAttributes);
	
	/**
     * 删除商品属性
     * 
     * @param mid 商品属性ID
     * @return 结果
     */
	public int deleteSpAttributesById(String mid);
	
	/**
     * 批量删除商品属性
     * 
     * @param mids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSpAttributesByIds(String[] mids);
	
}