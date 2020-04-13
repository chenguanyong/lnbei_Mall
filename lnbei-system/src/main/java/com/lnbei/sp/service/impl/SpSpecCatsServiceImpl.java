package com.lnbei.sp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnbei.sp.mapper.SpSpecCatsMapper;
import com.lnbei.sp.domain.SpSpecCats;
import com.lnbei.sp.service.ISpSpecCatsService;
import com.lnbei.common.core.text.Convert;

/**
 * 规格分类 服务层实现
 * 
 * @author lnbei
 * @date 2020-02-05
 */
@Service
public class SpSpecCatsServiceImpl implements ISpSpecCatsService 
{
	@Autowired
	private SpSpecCatsMapper spSpecCatsMapper;

	/**
     * 查询规格分类信息
     * 
     * @param mid 规格分类ID
     * @return 规格分类信息
     */
    @Override
	public SpSpecCats selectSpSpecCatsById(String mid)
	{
	    return spSpecCatsMapper.selectSpSpecCatsById(mid);
	}
	
	/**
     * 查询规格分类列表
     * 
     * @param spSpecCats 规格分类信息
     * @return 规格分类集合
     */
	@Override
	public List<SpSpecCats> selectSpSpecCatsList(SpSpecCats spSpecCats)
	{
	    return spSpecCatsMapper.selectSpSpecCatsList(spSpecCats);
	}
	
    /**
     * 新增规格分类
     * 
     * @param spSpecCats 规格分类信息
     * @return 结果
     */
	@Override
	public int insertSpSpecCats(SpSpecCats spSpecCats)
	{
	    return spSpecCatsMapper.insertSpSpecCats(spSpecCats);
	}
	
	/**
     * 修改规格分类
     * 
     * @param spSpecCats 规格分类信息
     * @return 结果
     */
	@Override
	public int updateSpSpecCats(SpSpecCats spSpecCats)
	{
	    return spSpecCatsMapper.updateSpSpecCats(spSpecCats);
	}

	/**
     * 删除规格分类对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSpSpecCatsByIds(String ids)
	{
		return spSpecCatsMapper.deleteSpSpecCatsByIds(Convert.toStrArray(ids));
	}
	/**
	 * 修改状态
	 */
	@Override
	public int changeStatus(SpSpecCats spSpecCats) {
		// TODO Auto-generated method stub
		return spSpecCatsMapper.changeStatus(spSpecCats);
	}
	/**
	 * 查询规格和规格值
	 */
	@Override
	public List<SpSpecCats> selectSpSpecCatsAndSpecItemsList(SpSpecCats spSpecCats) {
		// TODO Auto-generated method stub
		return spSpecCatsMapper.selectSpSpecCatsAndSpecItemsList(spSpecCats);
	}
	
}
