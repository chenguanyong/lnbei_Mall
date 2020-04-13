package com.lnbei.sp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnbei.sp.mapper.SpGoodsAppraisesMapper;
import com.lnbei.sp.domain.SpGoodsAppraises;
import com.lnbei.sp.service.ISpGoodsAppraisesService;
import com.lnbei.common.core.text.Convert;

/**
 * 商品评价 服务层实现
 * 
 * @author lnbei
 * @date 2020-02-05
 */
@Service
public class SpGoodsAppraisesServiceImpl implements ISpGoodsAppraisesService 
{
	@Autowired
	private SpGoodsAppraisesMapper spGoodsAppraisesMapper;

	/**
     * 查询商品评价信息
     * 
     * @param mid 商品评价ID
     * @return 商品评价信息
     */
    @Override
	public SpGoodsAppraises selectSpGoodsAppraisesById(String mid)
	{
	    return spGoodsAppraisesMapper.selectSpGoodsAppraisesById(mid);
	}
	
	/**
     * 查询商品评价列表
     * 
     * @param spGoodsAppraises 商品评价信息
     * @return 商品评价集合
     */
	@Override
	public List<SpGoodsAppraises> selectSpGoodsAppraisesList(SpGoodsAppraises spGoodsAppraises)
	{
	    return spGoodsAppraisesMapper.selectSpGoodsAppraisesList(spGoodsAppraises);
	}
	
    /**
     * 新增商品评价
     * 
     * @param spGoodsAppraises 商品评价信息
     * @return 结果
     */
	@Override
	public int insertSpGoodsAppraises(SpGoodsAppraises spGoodsAppraises)
	{
	    return spGoodsAppraisesMapper.insertSpGoodsAppraises(spGoodsAppraises);
	}
	
	/**
     * 修改商品评价
     * 
     * @param spGoodsAppraises 商品评价信息
     * @return 结果
     */
	@Override
	public int updateSpGoodsAppraises(SpGoodsAppraises spGoodsAppraises)
	{
	    return spGoodsAppraisesMapper.updateSpGoodsAppraises(spGoodsAppraises);
	}

	/**
     * 删除商品评价对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSpGoodsAppraisesByIds(String ids)
	{
		return spGoodsAppraisesMapper.deleteSpGoodsAppraisesByIds(Convert.toStrArray(ids));
	}
	
}
