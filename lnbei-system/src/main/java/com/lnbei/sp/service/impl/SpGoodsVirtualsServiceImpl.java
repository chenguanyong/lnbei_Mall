package com.lnbei.sp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnbei.sp.mapper.SpGoodsVirtualsMapper;
import com.lnbei.sp.domain.SpGoodsVirtuals;
import com.lnbei.sp.service.ISpGoodsVirtualsService;
import com.lnbei.common.core.text.Convert;

/**
 * 优惠劵 服务层实现
 * 
 * @author lnbei
 * @date 2020-02-05
 */
@Service
public class SpGoodsVirtualsServiceImpl implements ISpGoodsVirtualsService 
{
	@Autowired
	private SpGoodsVirtualsMapper spGoodsVirtualsMapper;

	/**
     * 查询优惠劵信息
     * 
     * @param mid 优惠劵ID
     * @return 优惠劵信息
     */
    @Override
	public SpGoodsVirtuals selectSpGoodsVirtualsById(String mid)
	{
	    return spGoodsVirtualsMapper.selectSpGoodsVirtualsById(mid);
	}
	
	/**
     * 查询优惠劵列表
     * 
     * @param spGoodsVirtuals 优惠劵信息
     * @return 优惠劵集合
     */
	@Override
	public List<SpGoodsVirtuals> selectSpGoodsVirtualsList(SpGoodsVirtuals spGoodsVirtuals)
	{
	    return spGoodsVirtualsMapper.selectSpGoodsVirtualsList(spGoodsVirtuals);
	}
	
    /**
     * 新增优惠劵
     * 
     * @param spGoodsVirtuals 优惠劵信息
     * @return 结果
     */
	@Override
	public int insertSpGoodsVirtuals(SpGoodsVirtuals spGoodsVirtuals)
	{
	    return spGoodsVirtualsMapper.insertSpGoodsVirtuals(spGoodsVirtuals);
	}
	
	/**
     * 修改优惠劵
     * 
     * @param spGoodsVirtuals 优惠劵信息
     * @return 结果
     */
	@Override
	public int updateSpGoodsVirtuals(SpGoodsVirtuals spGoodsVirtuals)
	{
	    return spGoodsVirtualsMapper.updateSpGoodsVirtuals(spGoodsVirtuals);
	}

	/**
     * 删除优惠劵对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSpGoodsVirtualsByIds(String ids)
	{
		return spGoodsVirtualsMapper.deleteSpGoodsVirtualsByIds(Convert.toStrArray(ids));
	}
	
}
