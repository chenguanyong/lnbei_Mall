package com.lnbei.sp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lnbei.sp.mapper.SpGoodsAppraisesMapper;
import com.lnbei.sp.mapper.SpGoodsAttributesMapper;
import com.lnbei.sp.mapper.SpGoodsMapper;
import com.lnbei.sp.mapper.SpGoodsScoresMapper;
import com.lnbei.sp.mapper.SpGoodsSpecsMapper;
import com.lnbei.sp.mapper.SpSpecItemsMapper;
import com.lnbei.sp.domain.SpGoods;
import com.lnbei.sp.domain.SpGoodsAppraises;
import com.lnbei.sp.domain.SpGoodsAttributes;
import com.lnbei.sp.domain.SpGoodsSpecs;
import com.lnbei.sp.domain.SpSpecItems;
import com.lnbei.sp.service.ISpGoodsService;
import com.lnbei.sp.viewdomain.SpGoodsView;
import com.lnbei.system.domain.SysUser;
import com.lnbei.common.core.text.Convert;
import com.lnbei.common.utils.StringUtils;
import com.lnbei.member.domain.MemberUser;

/**
 * 商品 服务层实现
 * 
 * @author lnbei
 * @date 2020-02-05
 */
@Service
public  class SpGoodsServiceImpl implements ISpGoodsService 
{
	@Autowired
	private SpGoodsMapper spGoodsMapper;
	@Autowired
	private SpSpecItemsMapper spSpecItemsMapper;
	@Autowired
	private SpGoodsSpecsMapper spGoodsSpecsMapper;	
	@Autowired
	private SpGoodsAttributesMapper spGoodsAttributesMapper;
	@Autowired
	private SpGoodsAppraisesMapper spGoodsAppraisesMapper;	
	@Autowired
	private SpGoodsScoresMapper spGoodsScoresMapper;
	/**
     * 查询商品信息
     * 
     * @param mid 商品ID
     * @return 商品信息
     */
    @Override
	public SpGoods selectSpGoodsById(String mid)
	{
	    return spGoodsMapper.selectSpGoodsById(mid);
	}
	
	/**
     * 查询商品列表
     * 
     * @param spGoods 商品信息
     * @return 商品集合
     */
	@Override
	public List<SpGoods> selectSpGoodsList(SpGoods spGoods)
	{
	    return spGoodsMapper.selectSpGoodsList(spGoods);
	}
	
    /**
     * 新增商品
     * 
     * @param spGoods 商品信息
     * @return 结果
     */
	@Override
	public int insertSpGoods(SpGoods spGoods)
	{
	    return spGoodsMapper.insertSpGoods(spGoods);
	}
	
	/**
     * 修改商品
     * 
     * @param spGoods 商品信息
     * @return 结果
     */
	@Override
	public int updateSpGoods(SpGoods spGoods)
	{
	    return spGoodsMapper.updateSpGoods(spGoods);
	}

	/**
     * 删除商品对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSpGoodsByIds(String ids)
	{
		return spGoodsMapper.deleteSpGoodsByIds(Convert.toStrArray(ids));
	}

	@Override
	@Transactional
	public int insertSpGoods(SpGoods spGoods, List<SpSpecItems> spSpecItems, List<SpGoodsSpecs> spGoodsSpecs,
			List<SpGoodsAttributes> spGoodsAttributes, Object user) {
		// TODO Auto-generated method stub
		
		if(user instanceof SysUser) {
			spGoods.setShopId("1");
		}else if (user instanceof MemberUser) {
			MemberUser memberUser = (MemberUser) user;
			spGoods.setShopId(memberUser.getShopId());
		}
		spGoods.initInsert(user);
		int r = spGoodsMapper.insertSpGoods(spGoods);
		if(r == 1) {
			for (SpSpecItems mSpecItems : spSpecItems) {
				mSpecItems.setShopId(spGoods.getShopId());
				mSpecItems.setGoodsId(spGoods.getMid());
				if(StringUtils.isEmpty(mSpecItems.getMid())) {
					mSpecItems.initInsert(user);
					spSpecItemsMapper.insertSpSpecItems(mSpecItems);
				}else {
					mSpecItems.initUpdate(user);
					spSpecItemsMapper.updateSpSpecItems(mSpecItems)	;				
				}
			}
			
			for (SpGoodsSpecs sGoodsSpecs : spGoodsSpecs) {
				sGoodsSpecs.setShopId(spGoods.getShopId());
				sGoodsSpecs.setGoodsId(spGoods.getMid());
				sGoodsSpecs.setSpecIds(sGoodsSpecs.getItemName0id());
				if(StringUtils.isEmpty(sGoodsSpecs.getSpecIds())) {
					if(StringUtils.isNotEmpty(sGoodsSpecs.getItemName1())) {
						sGoodsSpecs.setSpecIds( sGoodsSpecs.getItemName1id());
					}else {
						continue;
					}
				}else {
					if(StringUtils.isNotEmpty(sGoodsSpecs.getItemName1())) {
						sGoodsSpecs.setSpecIds(":" + sGoodsSpecs.getItemName1id());
					}					
				}
				sGoodsSpecs.initInsert(user);
				spGoodsSpecsMapper.insertSpGoodsSpecs(sGoodsSpecs);
				
			}
			for (SpGoodsAttributes sAttributes : spGoodsAttributes) {
				sAttributes.setShopId(spGoods.getShopId());
				sAttributes.setGoodsId(spGoods.getMid());
				sAttributes.initInsert(user);
				spGoodsAttributesMapper.insertSpGoodsAttributes(sAttributes);
			}
//			SpGoodsAppraises m = new SpGoodsAppraises();
//			m.setShopId(spGoods.getShopId());
//			m.setGoodsId(spGoods.getMid());
//			m.initInsert(user);
//			spGoodsAppraisesMapper.insertSpGoodsAppraises(m);
		}

		return r;
	}
	/**
	 * 修改商品
	 */
	@Override
	@Transactional
	public int updateSpGoods(SpGoods spGoods, List<SpSpecItems> spSpecItems, List<SpGoodsSpecs> spGoodsSpecs,
			List<SpGoodsAttributes> spGoodsAttributes, Object user) {
		// TODO Auto-generated method stub
//		MemberUser memberUser = (MemberUser) user;
//		memberUser.setShopId(memberUser.getShopId());
		spGoods.initUpdate(user);
		int r = spGoodsMapper.insertSpGoods(spGoods);
		if(r == 0) {
			
			for (SpSpecItems mSpecItems : spSpecItems) {
				mSpecItems.setShopId(spGoods.getShopId());
				mSpecItems.setGoodsId(spGoods.getMid());
				if(StringUtils.isEmpty(mSpecItems.getMid())) {
					mSpecItems.initInsert(user);
					spSpecItemsMapper.insertSpSpecItems(mSpecItems);
				}else {
					mSpecItems.initUpdate(user);
					spSpecItemsMapper.updateSpSpecItems(mSpecItems)	;				
				}
			}
			
			for (SpGoodsSpecs sGoodsSpecs : spGoodsSpecs) {
				sGoodsSpecs.setShopId(spGoods.getShopId());
				sGoodsSpecs.setGoodsId(spGoods.getMid());
				sGoodsSpecs.setSpecIds(sGoodsSpecs.getItemName0id());
				if(StringUtils.isEmpty(sGoodsSpecs.getSpecIds())) {
					if(StringUtils.isNotEmpty(sGoodsSpecs.getItemName1())) {
						sGoodsSpecs.setSpecIds( sGoodsSpecs.getItemName1id());
					}else {
						continue;
					}
				}else {
					if(StringUtils.isNotEmpty(sGoodsSpecs.getItemName1())) {
						sGoodsSpecs.setSpecIds(":" + sGoodsSpecs.getItemName1id());
					}					
				}
				sGoodsSpecs.initInsert(user);
				spGoodsSpecsMapper.insertSpGoodsSpecs(sGoodsSpecs);
				
			}
			for (SpGoodsAttributes sAttributes : spGoodsAttributes) {
				sAttributes.setShopId(spGoods.getShopId());
				sAttributes.setGoodsId(spGoods.getMid());

				if(StringUtils.isEmpty(sAttributes.getMid())) {
					sAttributes.initInsert(user);
					spGoodsAttributesMapper.insertSpGoodsAttributes(sAttributes);
				}else {
					sAttributes.initUpdate(user);
					spGoodsAttributesMapper.updateSpGoodsAttributes(sAttributes);				
				}				
			}
		}
		return r;
	}
	/**
	 *获取商品和规格
	 */
	@Override
	public SpGoods selectSpGoodsGoodsSpecByGoodsSpecId(String goodsSpecId) {
		// TODO Auto-generated method stub
		return spGoodsMapper.selectSpGoodsGoodsSpecByGoodsSpecId(goodsSpecId);
	}
	/**
	 * 修改库存+
	 * @param mGoods
	 * @return
	 */
	@Override
	public int incSpGoodsStock(SpGoods mGoods) {
		return spGoodsMapper.incSpGoodsStock(mGoods);
	}
	/**
	 * 修改库存-
	 * @param mGoods
	 * @return
	 */
	@Override
	public int decSpGoodsStock(SpGoods mGoods) {
		return spGoodsMapper.decSpGoodsStock(mGoods);
	}
	/**
	 * 查询推荐的商品
	 * @param dataType
	 * @return
	 */
	@Override
	public List<SpGoods> selectSpGoodsGoodsListByGoodsType(String dataType) {
		// TODO Auto-generated method stub
		return spGoodsMapper.selectSpGoodsGoodsListByGoodsType(dataType);
	}
	
	/**
	 * 处理搜索
	 * @param mGoodsView
	 * @return
	 */
	public List<SpGoods> search(SpGoodsView mGoodsView){
		SpGoods mGoods = new SpGoods();
		mGoods.setGoodsName(mGoodsView.getSearchName());
		return spGoodsMapper.selectSpGoodsList(mGoods);
	}
}
