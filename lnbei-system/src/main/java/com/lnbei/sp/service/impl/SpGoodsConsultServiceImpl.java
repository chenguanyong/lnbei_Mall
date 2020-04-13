package com.lnbei.sp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnbei.sp.mapper.SpGoodsConsultMapper;
import com.lnbei.sp.domain.SpGoodsConsult;
import com.lnbei.sp.service.ISpGoodsConsultService;
import com.lnbei.common.core.text.Convert;

/**
 * 商品咨询 服务层实现
 * 
 * @author lnbei
 * @date 2020-02-05
 */
@Service
public class SpGoodsConsultServiceImpl implements ISpGoodsConsultService 
{
	@Autowired
	private SpGoodsConsultMapper spGoodsConsultMapper;

	/**
     * 查询商品咨询信息
     * 
     * @param mid 商品咨询ID
     * @return 商品咨询信息
     */
    @Override
	public SpGoodsConsult selectSpGoodsConsultById(String mid)
	{
	    return spGoodsConsultMapper.selectSpGoodsConsultById(mid);
	}
	
	/**
     * 查询商品咨询列表
     * 
     * @param spGoodsConsult 商品咨询信息
     * @return 商品咨询集合
     */
	@Override
	public List<SpGoodsConsult> selectSpGoodsConsultList(SpGoodsConsult spGoodsConsult)
	{
	    return spGoodsConsultMapper.selectSpGoodsConsultList(spGoodsConsult);
	}
	
    /**
     * 新增商品咨询
     * 
     * @param spGoodsConsult 商品咨询信息
     * @return 结果
     */
	@Override
	public int insertSpGoodsConsult(SpGoodsConsult spGoodsConsult)
	{
	    return spGoodsConsultMapper.insertSpGoodsConsult(spGoodsConsult);
	}
	
	/**
     * 修改商品咨询
     * 
     * @param spGoodsConsult 商品咨询信息
     * @return 结果
     */
	@Override
	public int updateSpGoodsConsult(SpGoodsConsult spGoodsConsult)
	{
	    return spGoodsConsultMapper.updateSpGoodsConsult(spGoodsConsult);
	}

	/**
     * 删除商品咨询对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSpGoodsConsultByIds(String ids)
	{
		return spGoodsConsultMapper.deleteSpGoodsConsultByIds(Convert.toStrArray(ids));
	}
	
}
