package com.lnbei.sp.mapper;

import com.lnbei.sp.domain.SpGoods;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;	

/**
 * 商品 数据层
 * 
 * @author lnbei
 * @date 2020-02-05
 */
public interface SpGoodsMapper 
{
	/**
     * 查询商品信息
     * 
     * @param mid 商品ID
     * @return 商品信息
     */
	public SpGoods selectSpGoodsById(String mid);
	
	/**
     * 查询商品列表
     * 
     * @param spGoods 商品信息
     * @return 商品集合
     */
	public List<SpGoods> selectSpGoodsList(SpGoods spGoods);
	
	/**
     * 新增商品
     * 
     * @param spGoods 商品信息
     * @return 结果
     */
	public int insertSpGoods(SpGoods spGoods);
	
	/**
     * 修改商品
     * 
     * @param spGoods 商品信息
     * @return 结果
     */
	public int updateSpGoods(SpGoods spGoods);
	
	/**
     * 删除商品
     * 
     * @param mid 商品ID
     * @return 结果
     */
	public int deleteSpGoodsById(String mid);
	
	/**
     * 批量删除商品
     * 
     * @param mids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSpGoodsByIds(String[] mids);
	/**
	 * 获取商品规格
	 * @param goodsSpecId
	 * @return
	 */
	public SpGoods selectSpGoodsGoodsSpecByGoodsSpecId(String goodsSpecId);
	/**
	 * 修改库存+
	 * @param mGoods
	 * @return
	 */
	public int incSpGoodsStock(SpGoods mGoods);
	/**
	 * 修改库存-
	 * @param mGoods
	 * @return
	 */
	public int decSpGoodsStock(SpGoods mGoods);
	/**
	 * 查询推荐的商品
	 * @param dataType
	 * @return
	 */
	public List<SpGoods> selectSpGoodsGoodsListByGoodsType(@PathVariable("dataType") String dataType);
}