package com.lnbei.sp.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnbei.sp.mapper.SpShopCatsMapper;
import com.lnbei.sp.domain.SpGoodsCats;
import com.lnbei.sp.domain.SpShopCats;
import com.lnbei.sp.service.ISpShopCatsService;
import com.lnbei.common.core.text.Convert;

/**
 * 商家分类 服务层实现
 * 
 * @author lnbei
 * @date 2020-02-05
 */
@Service
public class SpShopCatsServiceImpl implements ISpShopCatsService 
{
	@Autowired
	private SpShopCatsMapper spShopCatsMapper;

	/**
     * 查询商家分类信息
     * 
     * @param mid 商家分类ID
     * @return 商家分类信息
     */
    @Override
	public SpShopCats selectSpShopCatsById(String mid)
	{
	    return spShopCatsMapper.selectSpShopCatsById(mid);
	}
	
	/**
     * 查询商家分类列表
     * 
     * @param spShopCats 商家分类信息
     * @return 商家分类集合
     */
	@Override
	public List<SpShopCats> selectSpShopCatsList(SpShopCats spShopCats)
	{
	    return spShopCatsMapper.selectSpShopCatsList(spShopCats);
	}
	
    /**
     * 新增商家分类
     * 
     * @param spShopCats 商家分类信息
     * @return 结果
     */
	@Override
	public int insertSpShopCats(SpShopCats spShopCats)
	{
	    return spShopCatsMapper.insertSpShopCats(spShopCats);
	}
	
	/**
     * 修改商家分类
     * 
     * @param spShopCats 商家分类信息
     * @return 结果
     */
	@Override
	public int updateSpShopCats(SpShopCats spShopCats)
	{
	    return spShopCatsMapper.updateSpShopCats(spShopCats);
	}

	/**
     * 删除商家分类对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSpShopCatsByIds(String ids)
	{
		return spShopCatsMapper.deleteSpShopCatsByIds(Convert.toStrArray(ids));
	}

	@Override
	public int deleteSpShopCatsByShopId(String shopId) {
		// TODO Auto-generated method stub
		return spShopCatsMapper.deleteSpShopCatsByShopId(shopId);
	}
	   /**
     * 根据父节点的ID获取所有子节点
     * 
     * @param list 分类表
     * @param parentId 传入的父节点ID
     * @return String
     */
    public List<SpShopCats> getChildPerms(List<SpShopCats> list, String parentId)
    {
        List<SpShopCats> returnList = new ArrayList<SpShopCats>();
        for (Iterator<SpShopCats> iterator = list.iterator(); iterator.hasNext();)
        {
        	SpShopCats t = (SpShopCats) iterator.next();
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
    private void recursionFn(List<SpShopCats> list, SpShopCats t)
    {
        // 得到子节点列表
        List<SpShopCats> childList = getChildList(list, t);
        t.setChildren(childList);
        for (SpShopCats tChild : childList)
        {
            if (hasChild(list, tChild))
            {
                // 判断是否有子节点
                Iterator<SpShopCats> it = childList.iterator();
                while (it.hasNext())
                {
                	SpShopCats n = (SpShopCats) it.next();
                    recursionFn(list, n);
                }
            }
        }
    }
    
    /**
     * 判断是否有子节点
     */
    private boolean hasChild(List<SpShopCats> list, SpShopCats t)
    {
        return getChildList(list, t).size() > 0 ? true : false;
    }
    /**
     * 得到子节点列表
     */
    private List<SpShopCats> getChildList(List<SpShopCats> list, SpShopCats t)
    {
        List<SpShopCats> tlist = new ArrayList<SpShopCats>();
        Iterator<SpShopCats> it = list.iterator();
        while (it.hasNext())
        {
        	SpShopCats n = (SpShopCats) it.next();
            if (n.getParentId().equals(t.getMid()))
            {
                tlist.add(n);
            }
        }
        return tlist;
    }
    /**
     * 获取全部的店铺分类
     * @param shopCats
     * @return
     */
    @Override
	public List<SpShopCats> getSpShopCatsAllList(SpShopCats shopCats){
		
		List<SpShopCats> mShopCats = spShopCatsMapper.selectSpShopCatsList(shopCats);
		return getChildPerms(mShopCats, "0");
	}
}
