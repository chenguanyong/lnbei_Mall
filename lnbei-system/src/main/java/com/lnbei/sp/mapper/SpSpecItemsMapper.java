package com.lnbei.sp.mapper;

import com.lnbei.sp.domain.SpSpecItems;
import java.util.List;

import org.apache.ibatis.annotations.Param;	

/**
 * 规格值 数据层
 * 
 * @author lnbei
 * @date 2020-02-05
 */
public interface SpSpecItemsMapper 
{
	/**
     * 查询规格值信息
     * 
     * @param mid 规格值ID
     * @return 规格值信息
     */
	public SpSpecItems selectSpSpecItemsById(String mid);
	
	/**
     * 查询规格值列表
     * 
     * @param spSpecItems 规格值信息
     * @return 规格值集合
     */
	public List<SpSpecItems> selectSpSpecItemsList(SpSpecItems spSpecItems);
	
	/**
     * 新增规格值
     * 
     * @param spSpecItems 规格值信息
     * @return 结果
     */
	public int insertSpSpecItems(SpSpecItems spSpecItems);
	
	/**
     * 修改规格值
     * 
     * @param spSpecItems 规格值信息
     * @return 结果
     */
	public int updateSpSpecItems(SpSpecItems spSpecItems);
	
	/**
     * 删除规格值
     * 
     * @param mid 规格值ID
     * @return 结果
     */
	public int deleteSpSpecItemsById(String mid);
	
	/**
     * 批量删除规格值
     * 
     * @param mids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSpSpecItemsByIds(String[] mids);
	public int deleteSpSpecItemsByShopIdAndGoodsId(@Param("shopId") String shopId, @Param("GoodsId") String goodsId );
}