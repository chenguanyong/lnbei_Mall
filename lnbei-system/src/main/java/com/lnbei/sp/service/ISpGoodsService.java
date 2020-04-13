package com.lnbei.sp.service;

import com.lnbei.sp.domain.SpGoods;
import com.lnbei.sp.domain.SpGoodsAttributes;
import com.lnbei.sp.domain.SpGoodsSpecs;
import com.lnbei.sp.domain.SpSpecItems;
import com.lnbei.sp.viewdomain.SpGoodsView;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

/**
 * 商品 服务层
 * 
 * @author lnbei
 * @date 2020-02-05
 */
public interface ISpGoodsService 
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
     * 删除商品信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSpGoodsByIds(String ids);
	
	/**
     * 新增商品
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int insertSpGoods(SpGoods spGoods, List<SpSpecItems> spSpecItems, List<SpGoodsSpecs> spGoodsSpecs,
			List<SpGoodsAttributes> spGoodsAttributes, Object user);
	/**
	 * 更新商品
	 * @param spGoods
	 * @param spSpecItems
	 * @param spGoodsSpecs
	 * @param spGoodsAttributes
	 * @param user
	 * @return
	 */
	public int updateSpGoods(SpGoods spGoods, List<SpSpecItems> spSpecItems, List<SpGoodsSpecs> spGoodsSpecs,
			List<SpGoodsAttributes> spGoodsAttributes, Object user) ;
	/**
	 * 获取商品和规格
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
	public List<SpGoods> selectSpGoodsGoodsListByGoodsType( String dataType);
	/**
	 * 处理搜索
	 * @param mGoodsView
	 * @return
	 */
	public List<SpGoods> search(SpGoodsView mGoodsView);
}
