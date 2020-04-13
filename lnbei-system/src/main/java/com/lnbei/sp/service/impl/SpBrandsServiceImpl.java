package com.lnbei.sp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnbei.sp.mapper.SpBrandsMapper;
import com.lnbei.sp.domain.SpBrands;
import com.lnbei.sp.service.ISpBrandsService;
import com.lnbei.common.core.text.Convert;

/**
 * 品牌 服务层实现
 * 
 * @author lnbei
 * @date 2020-02-05
 */
@Service
public class SpBrandsServiceImpl implements ISpBrandsService 
{
	@Autowired
	private SpBrandsMapper spBrandsMapper;

	/**
     * 查询品牌信息
     * 
     * @param mid 品牌ID
     * @return 品牌信息
     */
    @Override
	public SpBrands selectSpBrandsById(String mid)
	{
	    return spBrandsMapper.selectSpBrandsById(mid);
	}
	
	/**
     * 查询品牌列表
     * 
     * @param spBrands 品牌信息
     * @return 品牌集合
     */
	@Override
	public List<SpBrands> selectSpBrandsList(SpBrands spBrands)
	{
	    return spBrandsMapper.selectSpBrandsList(spBrands);
	}
	
    /**
     * 新增品牌
     * 
     * @param spBrands 品牌信息
     * @return 结果
     */
	@Override
	public int insertSpBrands(SpBrands spBrands)
	{
	    return spBrandsMapper.insertSpBrands(spBrands);
	}
	
	/**
     * 修改品牌
     * 
     * @param spBrands 品牌信息
     * @return 结果
     */
	@Override
	public int updateSpBrands(SpBrands spBrands)
	{
	    return spBrandsMapper.updateSpBrands(spBrands);
	}

	/**
     * 删除品牌对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSpBrandsByIds(String ids)
	{
		return spBrandsMapper.deleteSpBrandsByIds(Convert.toStrArray(ids));
	}
	
}
