package com.lnbei.sp.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.javassist.compiler.ast.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lnbei.sp.mapper.SpOrdersMapper;
import com.lnbei.sp.baseservice.BaseService;
import com.lnbei.sp.domain.SpCarts;
import com.lnbei.sp.domain.SpGoods;
import com.lnbei.sp.domain.SpGoodsSpecs;
import com.lnbei.sp.domain.SpOrderGoods;
import com.lnbei.sp.domain.SpOrderRefunds;
import com.lnbei.sp.domain.SpOrderServices;
import com.lnbei.sp.domain.SpOrders;
import com.lnbei.sp.service.ISpCartsService;
import com.lnbei.sp.service.ISpGoodsService;
import com.lnbei.sp.service.ISpGoodsSpecsService;
import com.lnbei.sp.service.ISpInvoicesService;
import com.lnbei.sp.service.ISpOrderGoodsService;
import com.lnbei.sp.service.ISpOrderRefundsService;
import com.lnbei.sp.service.ISpOrderServicesService;
import com.lnbei.sp.service.ISpOrdersService;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.core.text.Convert;
import com.lnbei.common.utils.StringUtils;
import com.lnbei.member.domain.MemberUser;
import com.lnbei.member.domain.MemberUserAddress;
import com.lnbei.member.service.IMemberUserAddressService;
import com.lnbei.member.service.impl.MemberUserAddressServiceImpl;

/**
 * 订单 服务层实现
 * 
 * @author lnbei
 * @date 2020-02-05
 */
@Service
public class SpOrdersServiceImpl extends BaseService implements ISpOrdersService {
	@Autowired
	private SpOrdersMapper spOrdersMapper;
	@Autowired
	private ISpGoodsService spGoodsServiceImpl; // 商品服务
	@Autowired
	private ISpCartsService spCartsServiceImpl;// 购物车服务
	@Autowired
	private IMemberUserAddressService memberUserAddressServiceImpl;// 地址管理
	@Autowired
	private ISpInvoicesService spInvoicesService;// 发票管理
	@Autowired
	private ISpGoodsSpecsService spGoodsSpecsServiceImpl;// 商品规格
	@Autowired
	private ISpOrderGoodsService spOrderGoodsServiceImpl;//订单商品
	@Autowired
	private ISpOrderServicesService spOrderServicesService;//售后服务但
	@Autowired
	private ISpOrderRefundsService spOrderRefundsServiceImpl;//订单退款单
	/**
	 * 查询订单信息
	 * 
	 * @param mid 订单ID
	 * @return 订单信息
	 */
	@Override
	public SpOrders selectSpOrdersById(String mid) {
		return spOrdersMapper.selectSpOrdersById(mid);
	}

	/**
	 * 查询订单列表
	 * 
	 * @param spOrders 订单信息
	 * @return 订单集合
	 */
	@Override
	public List<SpOrders> selectSpOrdersList(SpOrders spOrders) {
		return spOrdersMapper.selectSpOrdersList(spOrders);
	}

	/**
	 * 新增订单
	 * 
	 * @param spOrders 订单信息
	 * @return 结果
	 */
	@Override
	public int insertSpOrders(SpOrders spOrders) {
		return spOrdersMapper.insertSpOrders(spOrders);
	}

	/**
	 * 修改订单
	 * 
	 * @param spOrders 订单信息
	 * @return 结果
	 */
	@Override
	public int updateSpOrders(SpOrders spOrders) {
		return spOrdersMapper.updateSpOrders(spOrders);
	}

	/**
	 * 删除订单对象
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	@Override
	public int deleteSpOrdersByIds(String ids) {
		return spOrdersMapper.deleteSpOrdersByIds(Convert.toStrArray(ids));
	}

	/**
	 * 创建订单
	 */
	@Override
	@Transactional
	public AjaxResult buildOrder(SpOrders mOrders, MemberUser memberUser) throws Exception {
		// TODO Auto-generated method stub
		BigDecimal totalOrderMoney = new BigDecimal(0);
		Map<String, List<SpCarts>> mcartMap = getCartGoods(memberUser);// 获取购物车中的商品
		for (Map.Entry<String, List<SpCarts>> entry : mcartMap.entrySet()) {
			String shopId = (String) entry.getKey();
			List<SpCarts> mSpCartsList = (List<SpCarts>) entry.getValue();
			/***
			 * 确定地址
			 */
			MemberUserAddress memberUserAddress = new MemberUserAddress();
			memberUserAddress.setMemberId(memberUser.getMid());
			memberUserAddress.setIsDefault("0");
			List<MemberUserAddress> mmAddresses = memberUserAddressServiceImpl
					.selectMemberUserAddressList(memberUserAddress);
			MemberUserAddress mAddress = new MemberUserAddress();
			if (mmAddresses.size() > 0) {
				mAddress = mmAddresses.get(0);
			}
			/**
			 * 确认运费
			 */
			float freight = sureFreight(mAddress);

			mOrders.initInsert(memberUser);
			mOrders.setOrderNo(StringUtils.createNUM());// 设置订单标号
			mOrders.setShopId(shopId);//
			mOrders.setOrderStatus("4");// 待支付 设置订单状态
			mOrders.setDeliverMoney(BigDecimal.valueOf(freight));// 设置运费
			mOrders.setAreaId(mAddress.getAreaId());
			mOrders.setAreaIdPath(mAddress.getAreaidPath());
			mOrders.setUserAddress(mAddress.getUserAddress());// 详细地址

			int result = spOrdersMapper.insertSpOrders(mOrders);
			if (result == 0) {
				throw new Exception("下单失败！！！");
			}
			List<SpOrderGoods> mmGoods = new ArrayList<SpOrderGoods>();
			BigDecimal totalMoney = new BigDecimal(0);
			for (SpCarts spCarts : mSpCartsList) {

				SpOrderGoods mOrderGoods = new SpOrderGoods();
				SpGoods mm = spCarts.getSpGoods();
				SpGoodsSpecs mSpGoodsSpecs = spCarts.getSpGoodsSpecs();
				mOrderGoods.setOrderId(mOrders.getMid());
				mOrderGoods.setGoodsId(spCarts.getGoodsId());//

				if (mSpGoodsSpecs != null) {

					mOrderGoods.setGoodsspecId(spCarts.getGoodsspecId());
					mOrderGoods.setGoodSprice(mSpGoodsSpecs.getSpecPrice());
					BigDecimal goodsSpecStock = mSpGoodsSpecs.getSpecStock();
					BigDecimal cBigDecimal = goodsSpecStock.subtract(new BigDecimal(spCarts.getCartNum()));

					if (cBigDecimal.compareTo(BigDecimal.ZERO) == -1) {
						throw new Exception();
					}
					SpGoodsSpecs mGoodsSpecs = new SpGoodsSpecs();
					mGoodsSpecs.setMid(spCarts.getGoodsspecId());
					mGoodsSpecs.setSpecStock(cBigDecimal);
					spGoodsSpecsServiceImpl.updateSpGoodsSpecs(mGoodsSpecs);

				} else {
					mOrderGoods.setGoodSprice(mm.getShopPrice());
					SpGoods mSpGoods = new SpGoods();
					mSpGoods.setMid(mm.getMid());

					BigDecimal goodsSpecStock = mm.getGoodsStock();
					BigDecimal cBigDecimal = goodsSpecStock.subtract(new BigDecimal(spCarts.getCartNum()));

					if (cBigDecimal.compareTo(BigDecimal.ZERO) == -1) {
						throw new Exception();
					}
					mSpGoods.setGoodsStock(cBigDecimal);

					spGoodsServiceImpl.updateSpGoods(mSpGoods);

				}
				mOrderGoods.setGoodsName(mm.getGoodsName());
				mOrderGoods.setGoodsImg(mm.getGoodsImg());
				mOrderGoods.setGoodsNum(spCarts.getCartNum());
				mOrderGoods.setGoodsType(mm.getGoodsType());
				mOrderGoods.setCommissionRate(new BigDecimal(0));// 设置分佣利率
				BigDecimal goodsNum = new BigDecimal(mOrderGoods.getGoodsNum());
				// 没有做好积分减免等
				totalMoney.add(mOrderGoods.getGoodSprice().multiply(goodsNum));
				mmGoods.add(mOrderGoods);
				mOrderGoods.initInsert(memberUser);
				spOrderGoodsServiceImpl.insertSpOrderGoods(mOrderGoods);
			}
			totalOrderMoney.add(totalMoney);
			SpOrders mSpOrders = new SpOrders();
			mSpOrders.setMid(mOrders.getMid());
			mSpOrders.setTotalMoney(totalMoney);
			spOrdersMapper.updateSpOrders(mSpOrders);
		}
		int r = deleCart(memberUser);
		return toAjax(r);
	}

	/**
	 * 获取购物车中选中的商品
	 * 
	 * @return
	 */
	private Map<String, List<SpCarts>> getCartGoods(MemberUser memberUser) {
		SpCarts mCarts = new SpCarts();
		mCarts.setMemberId(memberUser.getMid());
		mCarts.setIsCheck("1");
		List<SpCarts> mCarts2 = spCartsServiceImpl.selectSpCartsList(mCarts);
		if (mCarts2.size() == 0) {
			return null;
		}
		Map<String, List<SpCarts>> mmMap = new HashMap<String, List<SpCarts>>();

		for (SpCarts spCarts : mCarts2) {
			String shopId = spCarts.getShopId();
			List<SpCarts> tempCarts = mmMap.get(shopId);
			if (tempCarts == null) {
				tempCarts = new ArrayList<SpCarts>();
				tempCarts.add(spCarts);

			} else {
				tempCarts.add(spCarts);
			}
			mmMap.put(shopId, tempCarts);
		}
		return mmMap;
	}

	/**
	 * 确定运费
	 * 
	 * @return
	 */
	private float sureFreight(MemberUserAddress address) {

		return 0;
	}

	/**
	 * 删除购物车数据
	 * 
	 * @param memberUser
	 * @return
	 */
	private int deleCart(MemberUser memberUser) {
		SpCarts mmCarts = new SpCarts();
		mmCarts.setMemberId(memberUser.getMemberId());
		mmCarts.setIsCheck("1");
		int r = spCartsServiceImpl.deleteSpCartsBySpCart(mmCarts);
		return r;

	}

	/**
	 * 拒收订单
	 * 
	 * @return
	 */
	@Transactional
	private AjaxResult rejectedOrder(SpOrders mSpOrders, MemberUser memberUser) {
		SpOrders mOrders = selectSpOrdersById(mSpOrders.getMid());
		if (mOrders.getOrderStatus().equals("4")) {// 待支付
			return AjaxResult.error("请先支付");
		} else if (mOrders.getOrderStatus().equals("0")) {// 待发货
			return AjaxResult.error("请先发货");
		} else if (mOrders.getOrderStatus().equals("1")) {// 配送中
			mSpOrders.setOrderStatus("3");
			mSpOrders.initUpdate(memberUser);
			int r = spOrdersMapper.updateSpOrders(mSpOrders);
			return toAjax(r, "操作成功！！！", "操作失败！！！");
		} else if (mOrders.getOrderStatus().equals("2")) {// 已收货
			return AjaxResult.error("您已收货，不能在拒收");
		} else if (mOrders.getOrderStatus().equals("3")) {// 用户拒收
			return AjaxResult.error("您已拒收，无需在操作");
		} else if (mOrders.getOrderStatus().equals("5")) {// 用户已取消
			return AjaxResult.error("您已取消,无需在操作");
		}
		return toAjax(0);
	}

	/**
	 * 确认收货
	 * 
	 * @return
	 */
	private AjaxResult receive(SpOrders mSpOrders, MemberUser memberUser) {
		SpOrders mOrders = selectSpOrdersById(mSpOrders.getMid());
		if (mOrders.getOrderStatus().equals("4")) {// 待支付
			return AjaxResult.error("请先支付");
		} else if (mOrders.getOrderStatus().equals("0")) {// 待发货
			return AjaxResult.error("请先发货");
		} else if (mOrders.getOrderStatus().equals("1")) {// 配送中
			mSpOrders.setOrderStatus("2");
			mSpOrders.initUpdate(memberUser);
			int r = spOrdersMapper.updateSpOrders(mSpOrders);
			return toAjax(r, "操作成功！！！", "操作失败！！！");
		} else if (mOrders.getOrderStatus().equals("2")) {// 已收货
			return AjaxResult.error("您已收货，不能在拒收");
		} else if (mOrders.getOrderStatus().equals("3")) {// 用户拒收
			return AjaxResult.error("您已拒收，无需在操作");
		} else if (mOrders.getOrderStatus().equals("5")) {// 用户已取消
			return AjaxResult.error("您已取消,无需在操作");
		}
		return toAjax(0);
	}

	/**
	 * 取消订单
	 * 
	 * @return
	 */
	private AjaxResult cancelOrder(SpOrders mSpOrders, SpOrderRefunds mRefunds, MemberUser memberUser) {
		SpOrders mOrders = selectSpOrdersById(mSpOrders.getMid());
		if (mOrders.getOrderStatus().equals("4")) {// 待支付
			return AjaxResult.error("请先支付");
		} else if (mOrders.getOrderStatus().equals("0")) {// 待发货
			return AjaxResult.error("请先发货");
		} else if (mOrders.getOrderStatus().equals("1")) {// 配送中
			mSpOrders.setOrderStatus("5");
		} else if (mOrders.getOrderStatus().equals("2")) {// 已收货
			return AjaxResult.error("您已收货，不能在拒收");
		} else if (mOrders.getOrderStatus().equals("3")) {// 用户拒收
			return AjaxResult.error("您已拒收，无需在操作");
		} else if (mOrders.getOrderStatus().equals("5")) {// 用户已取消
			return AjaxResult.error("您已取消,无需在操作");
		}
		mSpOrders.initUpdate(memberUser);
		int r = spOrdersMapper.updateSpOrders(mSpOrders);
		return toAjax(r, "操作成功！！！", "操作失败！！！");
	}

	/**
	 * 退库
	 * 
	 * @return
	 */
	private int retreatStock(SpOrders mOrders) {

		SpOrders mSpOrders = spOrdersMapper.selectSpOrdersById(mOrders.getMid());
		List<SpOrderGoods> mOrderGoods = mSpOrders.getmSpOrderGoodsList();
		if (mOrderGoods == null) {
			return 1;
		}
		int result = 0;
		for (SpOrderGoods spOrderGoods : mOrderGoods) {

			String goodsSpecsId = spOrderGoods.getGoodsspecId();

			if (StringUtils.isEmpty(goodsSpecsId)) {
				SpGoods mSpGoods = new SpGoods();
				mSpGoods.setMid(spOrderGoods.getGoodsId());
				mSpGoods.setGoodsStock(new BigDecimal(spOrderGoods.getGoodsNum()));
				result = spGoodsServiceImpl.incSpGoodsStock(mSpGoods);

			} else {
				SpGoodsSpecs mGoodsSpecs = new SpGoodsSpecs();
				mGoodsSpecs.setMid(goodsSpecsId);
				mGoodsSpecs.setSpecStock(new BigDecimal(spOrderGoods.getGoodsNum()));
				result = spGoodsSpecsServiceImpl.incSpGoodsSpecsStock(mGoodsSpecs);
			}
		}

		return result;
	}
	/**
	 * 创建退款订单
	 * @return
	 */
	private int createRefundOrder(SpOrders mSpOrders, MemberUser memberUser) {
		SpOrderServices mmOrderServices = new SpOrderServices();
		mmOrderServices.setOrderId(mSpOrders.getMid());
		
		SpOrderRefunds mOrderRefunds = new SpOrderRefunds();
		mOrderRefunds.setOrderId(mSpOrders.getMid());
		mOrderRefunds.setRefundTo(mSpOrders.getMemberId());
		mOrderRefunds.setRefundStatus("0");
		
	
		return 0;
	}
	/**
	 * 发货
	 * 
	 * @return
	 */
	private AjaxResult deliver(SpOrders mSpOrders, MemberUser memberUser) {
		SpOrders mOrders = selectSpOrdersById(mSpOrders.getMid());
		if (mOrders.getOrderStatus().equals("4")) {// 待支付
			return AjaxResult.error("请先支付");
		} else if (mOrders.getOrderStatus().equals("0")) {// 待发货
			if (!mOrders.getIsPay().equals("1")) {
				return AjaxResult.error("请先支付");
			}
			mSpOrders.setOrderStatus("1");
			mSpOrders.initUpdate(memberUser);
			int r = spOrdersMapper.updateSpOrders(mSpOrders);
			return toAjax(r, "操作成功！！！", "操作失败！！！");
		} else if (mOrders.getOrderStatus().equals("1")) {// 配送中
			return AjaxResult.error("您已发货，无需在此操作");

		} else if (mOrders.getOrderStatus().equals("2")) {// 已收货
			return AjaxResult.error("您已收货，不能在拒收");
		} else if (mOrders.getOrderStatus().equals("3")) {// 用户拒收
			return AjaxResult.error("您已拒收，无需在操作");
		} else if (mOrders.getOrderStatus().equals("5")) {// 用户已取消
			return AjaxResult.error("您已取消,无需在操作");
		}
		return toAjax(0);
	}
}
