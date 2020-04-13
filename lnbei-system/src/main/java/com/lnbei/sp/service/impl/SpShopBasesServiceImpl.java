package com.lnbei.sp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnbei.sp.mapper.SpShopBasesMapper;
import com.lnbei.sp.domain.SpShopBases;
import com.lnbei.sp.service.ISpShopBasesService;
import com.lnbei.common.core.text.Convert;

/**
 * 商家审核 服务层实现
 * 
 * @author lnbei
 * @date 2020-02-05
 */
@Service
public class SpShopBasesServiceImpl implements ISpShopBasesService 
{
	@Autowired
	private SpShopBasesMapper spShopBasesMapper;

	/**
     * 查询商家审核信息
     * 
     * @param mid 商家审核ID
     * @return 商家审核信息
     */
    @Override
	public SpShopBases selectSpShopBasesById(String mid)
	{
	    return spShopBasesMapper.selectSpShopBasesById(mid);
	}
	
	/**
     * 查询商家审核列表
     * 
     * @param spShopBases 商家审核信息
     * @return 商家审核集合
     */
	@Override
	public List<SpShopBases> selectSpShopBasesList(SpShopBases spShopBases)
	{
	    return spShopBasesMapper.selectSpShopBasesList(spShopBases);
	}
	
    /**
     * 新增商家审核
     * 
     * @param spShopBases 商家审核信息
     * @return 结果
     */
	@Override
	public int insertSpShopBases(SpShopBases spShopBases)
	{
	    return spShopBasesMapper.insertSpShopBases(spShopBases);
	}
	
	/**
     * 修改商家审核
     * 
     * @param spShopBases 商家审核信息
     * @return 结果
     */
	@Override
	public int updateSpShopBases(SpShopBases spShopBases)
	{
	    return spShopBasesMapper.updateSpShopBases(spShopBases);
	}

	/**
     * 删除商家审核对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSpShopBasesByIds(String ids)
	{
		return spShopBasesMapper.deleteSpShopBasesByIds(Convert.toStrArray(ids));
	}
	
}
