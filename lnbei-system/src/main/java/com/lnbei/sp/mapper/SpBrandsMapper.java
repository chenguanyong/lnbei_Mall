package com.lnbei.sp.mapper;

import com.lnbei.sp.domain.SpBrands;
import java.util.List;	

/**
 * 品牌 数据层
 * 
 * @author lnbei
 * @date 2020-02-05
 */
public interface SpBrandsMapper 
{
	/**
     * 查询品牌信息
     * 
     * @param mid 品牌ID
     * @return 品牌信息
     */
	public SpBrands selectSpBrandsById(String mid);
	
	/**
     * 查询品牌列表
     * 
     * @param spBrands 品牌信息
     * @return 品牌集合
     */
	public List<SpBrands> selectSpBrandsList(SpBrands spBrands);
	
	/**
     * 新增品牌
     * 
     * @param spBrands 品牌信息
     * @return 结果
     */
	public int insertSpBrands(SpBrands spBrands);
	
	/**
     * 修改品牌
     * 
     * @param spBrands 品牌信息
     * @return 结果
     */
	public int updateSpBrands(SpBrands spBrands);
	
	/**
     * 删除品牌
     * 
     * @param mid 品牌ID
     * @return 结果
     */
	public int deleteSpBrandsById(String mid);
	
	/**
     * 批量删除品牌
     * 
     * @param mids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSpBrandsByIds(String[] mids);
	
}