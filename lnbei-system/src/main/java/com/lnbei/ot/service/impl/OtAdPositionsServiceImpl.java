package com.lnbei.ot.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnbei.ot.mapper.OtAdPositionsMapper;
import com.lnbei.ot.domain.OtAdPositions;
import com.lnbei.ot.service.IOtAdPositionsService;
import com.lnbei.common.core.text.Convert;

/**
 * 广告位置 服务层实现
 * 
 * @author lnbei
 * @date 2020-04-10
 */
@Service
public class OtAdPositionsServiceImpl implements IOtAdPositionsService 
{
	@Autowired
	private OtAdPositionsMapper otAdPositionsMapper;

	/**
     * 查询广告位置信息
     * 
     * @param mid 广告位置ID
     * @return 广告位置信息
     */
    @Override
	public OtAdPositions selectOtAdPositionsById(String mid)
	{
	    return otAdPositionsMapper.selectOtAdPositionsById(mid);
	}
	
	/**
     * 查询广告位置列表
     * 
     * @param otAdPositions 广告位置信息
     * @return 广告位置集合
     */
	@Override
	public List<OtAdPositions> selectOtAdPositionsList(OtAdPositions otAdPositions)
	{
	    return otAdPositionsMapper.selectOtAdPositionsList(otAdPositions);
	}
	
    /**
     * 新增广告位置
     * 
     * @param otAdPositions 广告位置信息
     * @return 结果
     */
	@Override
	public int insertOtAdPositions(OtAdPositions otAdPositions)
	{
	    return otAdPositionsMapper.insertOtAdPositions(otAdPositions);
	}
	
	/**
     * 修改广告位置
     * 
     * @param otAdPositions 广告位置信息
     * @return 结果
     */
	@Override
	public int updateOtAdPositions(OtAdPositions otAdPositions)
	{
	    return otAdPositionsMapper.updateOtAdPositions(otAdPositions);
	}

	/**
     * 删除广告位置对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteOtAdPositionsByIds(String ids)
	{
		return otAdPositionsMapper.deleteOtAdPositionsByIds(Convert.toStrArray(ids));
	}
	/**
	 * 查询广告位置
	 */
	@Override
	public OtAdPositions selectOtAdPositionsByPositionCode(String postionCode) {
		// TODO Auto-generated method stub
		return otAdPositionsMapper.selectOtAdPositionsByPositionCode(postionCode);
	}
	
}
