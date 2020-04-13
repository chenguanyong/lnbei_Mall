package com.lnbei.sp.mapper;

import com.lnbei.sp.domain.SpGoodsAppraises;
import java.util.List;	

/**
 * 商品评价 数据层
 * 
 * @author lnbei
 * @date 2020-02-05
 */
public interface SpGoodsAppraisesMapper 
{
	/**
     * 查询商品评价信息
     * 
     * @param mid 商品评价ID
     * @return 商品评价信息
     */
	public SpGoodsAppraises selectSpGoodsAppraisesById(String mid);
	
	/**
     * 查询商品评价列表
     * 
     * @param spGoodsAppraises 商品评价信息
     * @return 商品评价集合
     */
	public List<SpGoodsAppraises> selectSpGoodsAppraisesList(SpGoodsAppraises spGoodsAppraises);
	
	/**
     * 新增商品评价
     * 
     * @param spGoodsAppraises 商品评价信息
     * @return 结果
     */
	public int insertSpGoodsAppraises(SpGoodsAppraises spGoodsAppraises);
	
	/**
     * 修改商品评价
     * 
     * @param spGoodsAppraises 商品评价信息
     * @return 结果
     */
	public int updateSpGoodsAppraises(SpGoodsAppraises spGoodsAppraises);
	
	/**
     * 删除商品评价
     * 
     * @param mid 商品评价ID
     * @return 结果
     */
	public int deleteSpGoodsAppraisesById(String mid);
	
	/**
     * 批量删除商品评价
     * 
     * @param mids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSpGoodsAppraisesByIds(String[] mids);
	
}