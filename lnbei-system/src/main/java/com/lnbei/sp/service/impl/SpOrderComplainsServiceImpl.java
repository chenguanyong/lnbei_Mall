package com.lnbei.sp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnbei.sp.mapper.SpOrderComplainsMapper;
import com.lnbei.sp.domain.SpOrderComplains;
import com.lnbei.sp.service.ISpOrderComplainsService;
import com.lnbei.common.core.text.Convert;

/**
 * 商品投诉 服务层实现
 * 
 * @author lnbei
 * @date 2020-02-05
 */
@Service
public class SpOrderComplainsServiceImpl implements ISpOrderComplainsService 
{
	@Autowired
	private SpOrderComplainsMapper spOrderComplainsMapper;

	/**
     * 查询商品投诉信息
     * 
     * @param mid 商品投诉ID
     * @return 商品投诉信息
     */
    @Override
	public SpOrderComplains selectSpOrderComplainsById(String mid)
	{
	    return spOrderComplainsMapper.selectSpOrderComplainsById(mid);
	}
	
	/**
     * 查询商品投诉列表
     * 
     * @param spOrderComplains 商品投诉信息
     * @return 商品投诉集合
     */
	@Override
	public List<SpOrderComplains> selectSpOrderComplainsList(SpOrderComplains spOrderComplains)
	{
	    return spOrderComplainsMapper.selectSpOrderComplainsList(spOrderComplains);
	}
	
    /**
     * 新增商品投诉
     * 
     * @param spOrderComplains 商品投诉信息
     * @return 结果
     */
	@Override
	public int insertSpOrderComplains(SpOrderComplains spOrderComplains)
	{
	    return spOrderComplainsMapper.insertSpOrderComplains(spOrderComplains);
	}
	
	/**
     * 修改商品投诉
     * 
     * @param spOrderComplains 商品投诉信息
     * @return 结果
     */
	@Override
	public int updateSpOrderComplains(SpOrderComplains spOrderComplains)
	{
	    return spOrderComplainsMapper.updateSpOrderComplains(spOrderComplains);
	}

	/**
     * 删除商品投诉对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSpOrderComplainsByIds(String ids)
	{
		return spOrderComplainsMapper.deleteSpOrderComplainsByIds(Convert.toStrArray(ids));
	}
	
}
