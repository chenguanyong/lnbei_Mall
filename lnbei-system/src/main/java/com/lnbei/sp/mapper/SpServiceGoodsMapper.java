package com.lnbei.sp.mapper;

import com.lnbei.sp.domain.SpServiceGoods;
import java.util.List;	

/**
 * 服务关系 数据层
 * 
 * @author lnbei
 * @date 2020-02-20
 */
public interface SpServiceGoodsMapper 
{
	/**
     * 查询服务关系信息
     * 
     * @param mid 服务关系ID
     * @return 服务关系信息
     */
	public SpServiceGoods selectSpServiceGoodsById(String mid);
	
	/**
     * 查询服务关系列表
     * 
     * @param spServiceGoods 服务关系信息
     * @return 服务关系集合
     */
	public List<SpServiceGoods> selectSpServiceGoodsList(SpServiceGoods spServiceGoods);
	
	/**
     * 新增服务关系
     * 
     * @param spServiceGoods 服务关系信息
     * @return 结果
     */
	public int insertSpServiceGoods(SpServiceGoods spServiceGoods);
	
	/**
     * 修改服务关系
     * 
     * @param spServiceGoods 服务关系信息
     * @return 结果
     */
	public int updateSpServiceGoods(SpServiceGoods spServiceGoods);
	
	/**
     * 删除服务关系
     * 
     * @param mid 服务关系ID
     * @return 结果
     */
	public int deleteSpServiceGoodsById(String mid);
	
	/**
     * 批量删除服务关系
     * 
     * @param mids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSpServiceGoodsByIds(String[] mids);
	
}