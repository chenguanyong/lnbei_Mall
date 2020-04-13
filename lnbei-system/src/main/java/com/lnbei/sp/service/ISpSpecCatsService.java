package com.lnbei.sp.service;

import com.lnbei.sp.domain.SpSpecCats;
import java.util.List;

/**
 * 规格分类 服务层
 * 
 * @author lnbei
 * @date 2020-02-05
 */
public interface ISpSpecCatsService 
{
	/**
     * 查询规格分类信息
     * 
     * @param mid 规格分类ID
     * @return 规格分类信息
     */
	public SpSpecCats selectSpSpecCatsById(String mid);
	
	/**
     * 查询规格分类列表
     * 
     * @param spSpecCats 规格分类信息
     * @return 规格分类集合
     */
	public List<SpSpecCats> selectSpSpecCatsList(SpSpecCats spSpecCats);
	
	/**
     * 新增规格分类
     * 
     * @param spSpecCats 规格分类信息
     * @return 结果
     */
	public int insertSpSpecCats(SpSpecCats spSpecCats);
	
	/**
     * 修改规格分类
     * 
     * @param spSpecCats 规格分类信息
     * @return 结果
     */
	public int updateSpSpecCats(SpSpecCats spSpecCats);
		
	/**
     * 删除规格分类信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSpSpecCatsByIds(String ids);
	/**
     * 改变状态
     * 
     * @param mids 需要删除的数据ID
     * @return 结果
     */	
	public int changeStatus(SpSpecCats spSpecCats);	
	
	/**
	 * 获取规格和规格值
	 * @param spSpecCats
	 * @return
	 */
	public List<SpSpecCats> selectSpSpecCatsAndSpecItemsList(SpSpecCats spSpecCats);
}
