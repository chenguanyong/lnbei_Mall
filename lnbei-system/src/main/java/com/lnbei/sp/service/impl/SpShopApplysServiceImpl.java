package com.lnbei.sp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnbei.sp.mapper.SpShopApplysMapper;
import com.lnbei.sp.domain.SpShopApplys;
import com.lnbei.sp.service.ISpShopApplysService;
import com.lnbei.common.core.text.Convert;

/**
 * 店铺申请 服务层实现
 * 
 * @author lnbei
 * @date 2020-02-05
 */
@Service
public class SpShopApplysServiceImpl implements ISpShopApplysService 
{
	@Autowired
	private SpShopApplysMapper spShopApplysMapper;

	/**
     * 查询店铺申请信息
     * 
     * @param mid 店铺申请ID
     * @return 店铺申请信息
     */
    @Override
	public SpShopApplys selectSpShopApplysById(String mid)
	{
	    return spShopApplysMapper.selectSpShopApplysById(mid);
	}
	
	/**
     * 查询店铺申请列表
     * 
     * @param spShopApplys 店铺申请信息
     * @return 店铺申请集合
     */
	@Override
	public List<SpShopApplys> selectSpShopApplysList(SpShopApplys spShopApplys)
	{
	    return spShopApplysMapper.selectSpShopApplysList(spShopApplys);
	}
	
    /**
     * 新增店铺申请
     * 
     * @param spShopApplys 店铺申请信息
     * @return 结果
     */
	@Override
	public int insertSpShopApplys(SpShopApplys spShopApplys)
	{
	    return spShopApplysMapper.insertSpShopApplys(spShopApplys);
	}
	
	/**
     * 修改店铺申请
     * 
     * @param spShopApplys 店铺申请信息
     * @return 结果
     */
	@Override
	public int updateSpShopApplys(SpShopApplys spShopApplys)
	{
	    return spShopApplysMapper.updateSpShopApplys(spShopApplys);
	}

	/**
     * 删除店铺申请对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSpShopApplysByIds(String ids)
	{
		return spShopApplysMapper.deleteSpShopApplysByIds(Convert.toStrArray(ids));
	}
	
}
