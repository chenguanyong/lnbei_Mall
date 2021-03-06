package com.lnbei.sp.mapper;

import com.lnbei.sp.domain.SpExpress;
import java.util.List;	

/**
 * 快递 数据层
 * 
 * @author lnbei
 * @date 2020-02-05
 */
public interface SpExpressMapper 
{
	/**
     * 查询快递信息
     * 
     * @param mid 快递ID
     * @return 快递信息
     */
	public SpExpress selectSpExpressById(String mid);
	
	/**
     * 查询快递列表
     * 
     * @param spExpress 快递信息
     * @return 快递集合
     */
	public List<SpExpress> selectSpExpressList(SpExpress spExpress);
	
	/**
     * 新增快递
     * 
     * @param spExpress 快递信息
     * @return 结果
     */
	public int insertSpExpress(SpExpress spExpress);
	
	/**
     * 修改快递
     * 
     * @param spExpress 快递信息
     * @return 结果
     */
	public int updateSpExpress(SpExpress spExpress);
	
	/**
     * 删除快递
     * 
     * @param mid 快递ID
     * @return 结果
     */
	public int deleteSpExpressById(String mid);
	
	/**
     * 批量删除快递
     * 
     * @param mids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSpExpressByIds(String[] mids);
	
}