package com.lnbei.sp.mapper;

import com.lnbei.sp.domain.SpOrderComplains;
import java.util.List;	

/**
 * 商品投诉 数据层
 * 
 * @author lnbei
 * @date 2020-02-05
 */
public interface SpOrderComplainsMapper 
{
	/**
     * 查询商品投诉信息
     * 
     * @param mid 商品投诉ID
     * @return 商品投诉信息
     */
	public SpOrderComplains selectSpOrderComplainsById(String mid);
	
	/**
     * 查询商品投诉列表
     * 
     * @param spOrderComplains 商品投诉信息
     * @return 商品投诉集合
     */
	public List<SpOrderComplains> selectSpOrderComplainsList(SpOrderComplains spOrderComplains);
	
	/**
     * 新增商品投诉
     * 
     * @param spOrderComplains 商品投诉信息
     * @return 结果
     */
	public int insertSpOrderComplains(SpOrderComplains spOrderComplains);
	
	/**
     * 修改商品投诉
     * 
     * @param spOrderComplains 商品投诉信息
     * @return 结果
     */
	public int updateSpOrderComplains(SpOrderComplains spOrderComplains);
	
	/**
     * 删除商品投诉
     * 
     * @param mid 商品投诉ID
     * @return 结果
     */
	public int deleteSpOrderComplainsById(String mid);
	
	/**
     * 批量删除商品投诉
     * 
     * @param mids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSpOrderComplainsByIds(String[] mids);
	
}