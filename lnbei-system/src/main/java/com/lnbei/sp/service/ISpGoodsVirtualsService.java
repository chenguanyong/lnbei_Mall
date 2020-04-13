package com.lnbei.sp.service;

import com.lnbei.sp.domain.SpGoodsVirtuals;
import java.util.List;

/**
 * 优惠劵 服务层
 * 
 * @author lnbei
 * @date 2020-02-05
 */
public interface ISpGoodsVirtualsService 
{
	/**
     * 查询优惠劵信息
     * 
     * @param mid 优惠劵ID
     * @return 优惠劵信息
     */
	public SpGoodsVirtuals selectSpGoodsVirtualsById(String mid);
	
	/**
     * 查询优惠劵列表
     * 
     * @param spGoodsVirtuals 优惠劵信息
     * @return 优惠劵集合
     */
	public List<SpGoodsVirtuals> selectSpGoodsVirtualsList(SpGoodsVirtuals spGoodsVirtuals);
	
	/**
     * 新增优惠劵
     * 
     * @param spGoodsVirtuals 优惠劵信息
     * @return 结果
     */
	public int insertSpGoodsVirtuals(SpGoodsVirtuals spGoodsVirtuals);
	
	/**
     * 修改优惠劵
     * 
     * @param spGoodsVirtuals 优惠劵信息
     * @return 结果
     */
	public int updateSpGoodsVirtuals(SpGoodsVirtuals spGoodsVirtuals);
		
	/**
     * 删除优惠劵信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSpGoodsVirtualsByIds(String ids);
	
}
