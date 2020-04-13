package com.lnbei.sp.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnbei.sp.mapper.SpGoodsCatsMapper;
import com.lnbei.sp.domain.SpGoodsCats;
import com.lnbei.sp.service.ISpGoodsCatsService;
import com.lnbei.system.domain.SysMenu;
import com.lnbei.common.core.text.Convert;

/**
 * 商品分类 服务层实现
 * 
 * @author lnbei
 * @date 2020-02-05
 */
@Service
public class SpGoodsCatsServiceImpl implements ISpGoodsCatsService 
{
	@Autowired
	private SpGoodsCatsMapper spGoodsCatsMapper;

	/**
     * 查询商品分类信息
     * 
     * @param mid 商品分类ID
     * @return 商品分类信息
     */
    @Override
	public SpGoodsCats selectSpGoodsCatsById(String mid)
	{
	    return spGoodsCatsMapper.selectSpGoodsCatsById(mid);
	}
	
	/**
     * 查询商品分类列表
     * 
     * @param spGoodsCats 商品分类信息
     * @return 商品分类集合
     */
	@Override
	public List<SpGoodsCats> selectSpGoodsCatsList(SpGoodsCats spGoodsCats)
	{
	    return spGoodsCatsMapper.selectSpGoodsCatsList(spGoodsCats);
	}
	
    /**
     * 新增商品分类
     * 
     * @param spGoodsCats 商品分类信息
     * @return 结果
     */
	@Override
	public int insertSpGoodsCats(SpGoodsCats spGoodsCats)
	{
	    return spGoodsCatsMapper.insertSpGoodsCats(spGoodsCats);
	}
	
	/**
     * 修改商品分类
     * 
     * @param spGoodsCats 商品分类信息
     * @return 结果
     */
	@Override
	public int updateSpGoodsCats(SpGoodsCats spGoodsCats)
	{
	    return spGoodsCatsMapper.updateSpGoodsCats(spGoodsCats);
	}

	/**
     * 删除商品分类对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSpGoodsCatsByIds(String ids)
	{
		return spGoodsCatsMapper.deleteSpGoodsCatsByIds(Convert.toStrArray(ids));
	}
    /**
     * 根据父节点的ID获取所有子节点
     * 
     * @param list 分类表
     * @param parentId 传入的父节点ID
     * @return String
     */
    public List<SpGoodsCats> getChildPerms(List<SpGoodsCats> list, String parentId)
    {
        List<SpGoodsCats> returnList = new ArrayList<SpGoodsCats>();
        for (Iterator<SpGoodsCats> iterator = list.iterator(); iterator.hasNext();)
        {
        	SpGoodsCats t = (SpGoodsCats) iterator.next();
            // 一、根据传入的某个父节点ID,遍历该父节点的所有子节点
            if (t.getParentId().equals(parentId))
            {
                recursionFn(list, t);
                returnList.add(t);
            }
        }
        return returnList;
    }
    
    /**
     * 递归列表
     * 
     * @param list
     * @param t
     */
    private void recursionFn(List<SpGoodsCats> list, SpGoodsCats t)
    {
        // 得到子节点列表
        List<SpGoodsCats> childList = getChildList(list, t);
        t.setChildren(childList);
        for (SpGoodsCats tChild : childList)
        {
            if (hasChild(list, tChild))
            {
                // 判断是否有子节点
                Iterator<SpGoodsCats> it = childList.iterator();
                while (it.hasNext())
                {
                	SpGoodsCats n = (SpGoodsCats) it.next();
                    recursionFn(list, n);
                }
            }
        }
    }
    
    /**
     * 判断是否有子节点
     */
    private boolean hasChild(List<SpGoodsCats> list, SpGoodsCats t)
    {
        return getChildList(list, t).size() > 0 ? true : false;
    }
    /**
     * 得到子节点列表
     */
    private List<SpGoodsCats> getChildList(List<SpGoodsCats> list, SpGoodsCats t)
    {
        List<SpGoodsCats> tlist = new ArrayList<SpGoodsCats>();
        Iterator<SpGoodsCats> it = list.iterator();
        while (it.hasNext())
        {
        	SpGoodsCats n = (SpGoodsCats) it.next();
            if (n.getParentId().equals(t.getMid()))
            {
                tlist.add(n);
            }
        }
        return tlist;
    }
    /**
     * 获取全部商品类别
     * 用在商品分类列表
     * @return
     */
    @Override
    public List<SpGoodsCats> selectGoodsCatsAll(SpGoodsCats mGoodsCats){
 
    	List<SpGoodsCats> allCats = selectSpGoodsCatsList(mGoodsCats);
    	return getChildPerms(allCats, "0");
    }
}
