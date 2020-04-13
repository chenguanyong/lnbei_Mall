package com.lnbei.home.service;

import com.lnbei.common.core.domain.Ztree;
import com.lnbei.home.domain.HomeCategory;


import java.util.List;

/**
 * 分类 服务层
 * 
 * @author lnbei
 * @date 2020-01-24
 */
public interface IHomeCategoryService 
{
	/**
     * 查询分类信息
     * 
     * @param mid 分类ID
     * @return 分类信息
     */
	public HomeCategory selectHomeCategoryById(String mid);
	
	/**
     * 查询分类列表
     * 
     * @param homeCategory 分类信息
     * @return 分类集合
     */
	public List<HomeCategory> selectHomeCategoryList(HomeCategory homeCategory);
	
	/**
     * 新增分类
     * 
     * @param homeCategory 分类信息
     * @return 结果
     */
	public int insertHomeCategory(HomeCategory homeCategory, Object user);
	
	/**
     * 修改分类
     * 
     * @param homeCategory 分类信息
     * @return 结果
     */
	public int updateHomeCategory(HomeCategory homeCategory, Object user);
		
	/**
     * 删除分类信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteHomeCategoryByIds(String ids);
	
	/**
	 * 获取全部分类
	 */
	public List<Ztree> selectCategory(HomeCategory mCategory);
	/**
	 * 改变状态
	 * @param mCategory
	 * @return
	 */
	public int changeStatus(HomeCategory mCategory);
	/**
	 * 获取分类通过英文标识
	 * @param flag
	 * @return
	 */
	public HomeCategory selectHomeCategoryByFlag(String flag);
	/**
	 * 根据父ID查询数据
	 * @param parentId
	 * @return
	 */
	public List<HomeCategory> selectHomeCategoryListByParent(HomeCategory homeCategory);
	/**
	 * 根据路径和父ID查询数据
	 * @param homeCategory
	 * @return
	 */
	public List<HomeCategory> selectHomeCategoryByPathParentId(HomeCategory homeCategory);
}
