package com.lnbei.sp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lnbei.sp.mapper.SpCartsMapper;
import com.lnbei.sp.mapper.SpGoodsMapper;
import com.lnbei.sp.mapper.SpGoodsSpecsMapper;
import com.lnbei.sp.baseservice.BaseService;
import com.lnbei.sp.domain.SpCarts;
import com.lnbei.sp.domain.SpGoods;
import com.lnbei.sp.domain.SpGoodsSpecs;
import com.lnbei.sp.service.ISpCartsService;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.core.text.Convert;
import com.lnbei.common.utils.StringUtils;

/**
 * 购物车 服务层实现
 * 
 * @author lnbei
 * @date 2020-02-05
 */
@Service
public class SpCartsServiceImpl extends BaseService implements ISpCartsService 
{
	@Autowired
	private SpCartsMapper spCartsMapper;
	@Autowired
	private SpGoodsSpecsMapper spGoodsSpecsMapper;
	@Autowired
	private SpGoodsMapper spGoodsMapper;
	/**
     * 查询购物车信息
     * 
     * @param mid 购物车ID
     * @return 购物车信息
     */
    @Override
	public SpCarts selectSpCartsById(String mid)
	{
	    return spCartsMapper.selectSpCartsById(mid);
	}
	
	/**
     * 查询购物车列表
     * 
     * @param spCarts 购物车信息
     * @return 购物车集合
     */
	@Override
	public List<SpCarts> selectSpCartsList(SpCarts spCarts)
	{
	    return spCartsMapper.selectSpCartsList(spCarts);
	}
	
    /**
     * 新增购物车
     * 
     * @param spCarts 购物车信息
     * @return 结果
     */
	@Override
	public int insertSpCarts(SpCarts spCarts)
	{
	    return spCartsMapper.insertSpCarts(spCarts);
	}
	
	/**
     * 修改购物车
     * 
     * @param spCarts 购物车信息
     * @return 结果
     */
	@Override
	public int updateSpCarts(SpCarts spCarts)
	{
	    return spCartsMapper.updateSpCarts(spCarts);
	}

	/**
     * 删除购物车对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSpCartsByIds(String ids)
	{
		return spCartsMapper.deleteSpCartsByIds(Convert.toStrArray(ids));
	}
/**
 * 选中购物车商品
 */
	@Override
	public int checkedGoods(String isCheck, String[] mids) {
		// TODO Auto-generated method stub
		return spCartsMapper.checkedGoods(isCheck, mids);
	}
	/**
	 * 添加购物车
	 * @param spCarts
	 * @return
	 */
	@Override
	@Transactional
	public AjaxResult addCart(SpCarts spCarts) {
		String cartId = spCarts.getMid();
		/**
		 * 更新已有的购物车数量
		 */
		if(!StringUtils.isEmpty(cartId)) {
			int result = updateSpCarts(spCarts);
			return toAjax(result);
		}
		SpGoods mgGoods = spGoodsMapper.selectSpGoodsById(spCarts.getGoodsId());
		
		if(mgGoods == null) {
			return AjaxResult.error("商品不存在！！！");
		}
		/**
		 * 检查商品的默认规格
		 */
		if(StringUtils.isEmpty(spCarts.getGoodsspecId())) {
			SpGoodsSpecs mGoodsSpecs = new SpGoodsSpecs();
			mGoodsSpecs.setGoodsId(spCarts.getGoodsId());
			mGoodsSpecs.setIsDefault("1");
			SpGoodsSpecs tempGoodsSpecs = spGoodsSpecsMapper.selectSpGoodsSpecsBySpGoodsSpecs(mGoodsSpecs);
			if(tempGoodsSpecs != null) {
				spCarts.setGoodsspecId(tempGoodsSpecs.getMid());
			}
		}
		
		boolean checkGoodsSpec = false;
		if(StringUtils.isEmpty(spCarts.getGoodsspecId())) {
			checkGoodsSpec = true;
		}else {
			checkGoodsSpec = checkGoodsSpec(spCarts);
		}
		
		
		int result = 0;
		if(checkGoodsSpec) {
			SpCarts mCarts = spCartsMapper.selectSpCartsBySpCarts(spCarts);
			if(mCarts == null) {
				result =	insertSpCarts(spCarts);
			}else {
				float cartNum = mCarts.getCartNum() + 1;
				spCarts.setCartNum(cartNum);
				spCarts.setMid(mCarts.getMid());
				result = updateSpCarts(spCarts);
			}
			
		}else {
			return AjaxResult.error("商品规格不存在");
		}
		return result > 0 ? AjaxResult.success("添加成功！"):AjaxResult.error("添加失败！");
	}
	/**
	 * 检查商品规格是否正确
	 * @param spCarts
	 * @return
	 */
	private boolean checkGoodsSpec(SpCarts spCarts) {
		
		SpGoodsSpecs mGoodsSpecs = spGoodsSpecsMapper.selectSpGoodsSpecsById(spCarts.getGoodsspecId());
		
		if(mGoodsSpecs != null && mGoodsSpecs.getMid().equals(spCarts.getGoodsId())) {
			return true;
		}
		return false;
	}

	@Override
	public List<SpCarts> selectSpCartsGoodsList(SpCarts mSpCarts) {
		// TODO Auto-generated method stub
		return spCartsMapper.selectSpCartsGoodsList(mSpCarts);
	}

	@Override
	public SpCarts selectSpCartsGoodsById(String mid) {
		// TODO Auto-generated method stub
		return spCartsMapper.selectSpCartsGoodsById(mid);
	}

	@Override
	public int deleteSpCartsBySpCart(SpCarts mCarts) {
		// TODO Auto-generated method stub
		return spCartsMapper.deleteSpCartsBySpCart(mCarts);
	}
}
