package com.lnbei.sp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnbei.sp.mapper.SpAccredsMapper;
import com.lnbei.sp.domain.SpAccreds;
import com.lnbei.sp.service.ISpAccredsService;
import com.lnbei.common.core.text.Convert;

/**
 * 店铺认证 服务层实现
 * 
 * @author lnbei
 * @date 2020-02-23
 */
@Service
public class SpAccredsServiceImpl implements ISpAccredsService 
{
	@Autowired
	private SpAccredsMapper spAccredsMapper;

	/**
     * 查询店铺认证信息
     * 
     * @param mid 店铺认证ID
     * @return 店铺认证信息
     */
    @Override
	public SpAccreds selectSpAccredsById(String mid)
	{
	    return spAccredsMapper.selectSpAccredsById(mid);
	}
	
	/**
     * 查询店铺认证列表
     * 
     * @param spAccreds 店铺认证信息
     * @return 店铺认证集合
     */
	@Override
	public List<SpAccreds> selectSpAccredsList(SpAccreds spAccreds)
	{
	    return spAccredsMapper.selectSpAccredsList(spAccreds);
	}
	
    /**
     * 新增店铺认证
     * 
     * @param spAccreds 店铺认证信息
     * @return 结果
     */
	@Override
	public int insertSpAccreds(SpAccreds spAccreds)
	{
	    return spAccredsMapper.insertSpAccreds(spAccreds);
	}
	
	/**
     * 修改店铺认证
     * 
     * @param spAccreds 店铺认证信息
     * @return 结果
     */
	@Override
	public int updateSpAccreds(SpAccreds spAccreds)
	{
	    return spAccredsMapper.updateSpAccreds(spAccreds);
	}

	/**
     * 删除店铺认证对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSpAccredsByIds(String ids)
	{
		return spAccredsMapper.deleteSpAccredsByIds(Convert.toStrArray(ids));
	}
	
}
