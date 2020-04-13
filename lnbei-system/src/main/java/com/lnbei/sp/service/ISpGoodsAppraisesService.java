package com.lnbei.sp.service;

import com.lnbei.sp.domain.SpGoodsAppraises;
import java.util.List;

/**
 * 商品评价 服务层
 * 
 * @author lnbei
 * @date 2020-02-05
 */
public interface ISpGoodsAppraisesService 
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
     * 删除商品评价信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSpGoodsAppraisesByIds(String ids);
	
}
