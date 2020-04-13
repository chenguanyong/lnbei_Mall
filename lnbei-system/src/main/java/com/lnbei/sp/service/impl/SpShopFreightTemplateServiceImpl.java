package com.lnbei.sp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnbei.sp.mapper.SpShopFreightTemplateMapper;
import com.lnbei.sp.domain.SpShopFreightTemplate;
import com.lnbei.sp.service.ISpShopFreightTemplateService;
import com.lnbei.common.core.text.Convert;

/**
 * 店铺运费模板 服务层实现
 * 
 * @author lnbei
 * @date 2020-02-05
 */
@Service
public class SpShopFreightTemplateServiceImpl implements ISpShopFreightTemplateService 
{
	@Autowired
	private SpShopFreightTemplateMapper spShopFreightTemplateMapper;

	/**
     * 查询店铺运费模板信息
     * 
     * @param mid 店铺运费模板ID
     * @return 店铺运费模板信息
     */
    @Override
	public SpShopFreightTemplate selectSpShopFreightTemplateById(String mid)
	{
	    return spShopFreightTemplateMapper.selectSpShopFreightTemplateById(mid);
	}
	
	/**
     * 查询店铺运费模板列表
     * 
     * @param spShopFreightTemplate 店铺运费模板信息
     * @return 店铺运费模板集合
     */
	@Override
	public List<SpShopFreightTemplate> selectSpShopFreightTemplateList(SpShopFreightTemplate spShopFreightTemplate)
	{
	    return spShopFreightTemplateMapper.selectSpShopFreightTemplateList(spShopFreightTemplate);
	}
	
    /**
     * 新增店铺运费模板
     * 
     * @param spShopFreightTemplate 店铺运费模板信息
     * @return 结果
     */
	@Override
	public int insertSpShopFreightTemplate(SpShopFreightTemplate spShopFreightTemplate)
	{
	    return spShopFreightTemplateMapper.insertSpShopFreightTemplate(spShopFreightTemplate);
	}
	
	/**
     * 修改店铺运费模板
     * 
     * @param spShopFreightTemplate 店铺运费模板信息
     * @return 结果
     */
	@Override
	public int updateSpShopFreightTemplate(SpShopFreightTemplate spShopFreightTemplate)
	{
	    return spShopFreightTemplateMapper.updateSpShopFreightTemplate(spShopFreightTemplate);
	}

	/**
     * 删除店铺运费模板对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSpShopFreightTemplateByIds(String ids)
	{
		return spShopFreightTemplateMapper.deleteSpShopFreightTemplateByIds(Convert.toStrArray(ids));
	}
	
}
