package com.lnbei.sp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnbei.sp.mapper.SpGoodsSpecsMapper;
import com.lnbei.sp.domain.SpGoodsSpecs;
import com.lnbei.sp.service.ISpGoodsSpecsService;
import com.lnbei.common.core.text.Convert;

/**
 * 商品规格 服务层实现
 * 
 * @author lnbei
 * @date 2020-02-05
 */
@Service
public class SpGoodsSpecsServiceImpl implements ISpGoodsSpecsService 
{
	@Autowired
	private SpGoodsSpecsMapper spGoodsSpecsMapper;

	/**
     * 查询商品规格信息
     * 
     * @param mid 商品规格ID
     * @return 商品规格信息
     */
    @Override
	public SpGoodsSpecs selectSpGoodsSpecsById(String mid)
	{
	    return spGoodsSpecsMapper.selectSpGoodsSpecsById(mid);
	}
	
	/**
     * 查询商品规格列表
     * 
     * @param spGoodsSpecs 商品规格信息
     * @return 商品规格集合
     */
	@Override
	public List<SpGoodsSpecs> selectSpGoodsSpecsList(SpGoodsSpecs spGoodsSpecs)
	{
	    return spGoodsSpecsMapper.selectSpGoodsSpecsList(spGoodsSpecs);
	}
	
    /**
     * 新增商品规格
     * 
     * @param spGoodsSpecs 商品规格信息
     * @return 结果
     */
	@Override
	public int insertSpGoodsSpecs(SpGoodsSpecs spGoodsSpecs)
	{
	    return spGoodsSpecsMapper.insertSpGoodsSpecs(spGoodsSpecs);
	}
	
	/**
     * 修改商品规格
     * 
     * @param spGoodsSpecs 商品规格信息
     * @return 结果
     */
	@Override
	public int updateSpGoodsSpecs(SpGoodsSpecs spGoodsSpecs)
	{
	    return spGoodsSpecsMapper.updateSpGoodsSpecs(spGoodsSpecs);
	}

	/**
     * 删除商品规格对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSpGoodsSpecsByIds(String ids)
	{
		return spGoodsSpecsMapper.deleteSpGoodsSpecsByIds(Convert.toStrArray(ids));
	}
	/**
	 * 修改库存+
	 * @param mGoods
	 * @return
	 */
	@Override
	public int incSpGoodsSpecsStock(SpGoodsSpecs mGoodsSpecs) {
		return spGoodsSpecsMapper.incSpGoodsSpecsStock(mGoodsSpecs);
	};
	/**
	 * 修改库存-
	 * @param mGoods
	 * @return
	 */
	@Override
	public int decSpGoodsSpecsStock(SpGoodsSpecs mGoodsSpecs) {
		return spGoodsSpecsMapper.decSpGoodsSpecsStock(mGoodsSpecs);
	}	
}
