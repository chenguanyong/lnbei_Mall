package com.lnbei.sp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnbei.sp.mapper.SpShopExtrasMapper;
import com.lnbei.sp.domain.SpShopExtras;
import com.lnbei.sp.service.ISpShopExtrasService;
import com.lnbei.common.core.text.Convert;

/**
 * 商铺扩展 服务层实现
 * 
 * @author lnbei
 * @date 2020-02-19
 */
@Service
public class SpShopExtrasServiceImpl implements ISpShopExtrasService {
	@Autowired
	private SpShopExtrasMapper spShopExtrasMapper;

	/**
	 * 查询商铺扩展信息
	 * 
	 * @param mid 商铺扩展ID
	 * @return 商铺扩展信息
	 */
	@Override
	public SpShopExtras selectSpShopExtrasById(String mid) {
		return spShopExtrasMapper.selectSpShopExtrasById(mid);
	}

	/**
	 * 查询商铺扩展列表
	 * 
	 * @param spShopExtras 商铺扩展信息
	 * @return 商铺扩展集合
	 */
	@Override
	public List<SpShopExtras> selectSpShopExtrasList(SpShopExtras spShopExtras) {
		return spShopExtrasMapper.selectSpShopExtrasList(spShopExtras);
	}

	/**
	 * 新增商铺扩展
	 * 
	 * @param spShopExtras 商铺扩展信息
	 * @return 结果
	 */
	@Override
	public int insertSpShopExtras(SpShopExtras spShopExtras) {
		return spShopExtrasMapper.insertSpShopExtras(spShopExtras);
	}

	/**
	 * 修改商铺扩展
	 * 
	 * @param spShopExtras 商铺扩展信息
	 * @return 结果
	 */
	@Override
	public int updateSpShopExtras(SpShopExtras spShopExtras) {
		return spShopExtrasMapper.updateSpShopExtras(spShopExtras);
	}

	/**
	 * 删除商铺扩展对象
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	@Override
	public int deleteSpShopExtrasByIds(String ids) {
		return spShopExtrasMapper.deleteSpShopExtrasByIds(Convert.toStrArray(ids));
	}

	/**
	 * 查询数据根据商铺ID
	 * 
	 * @param mid 商铺扩展ID
	 * @return 结果
	 */
	@Override
	public SpShopExtras selectSpShopExtrasByShopId(String shopId) {
		return spShopExtrasMapper.selectSpShopExtrasByShopId(shopId);
	}
}
