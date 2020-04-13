package com.lnbei.home.mapper;

import com.lnbei.home.domain.HomeCategory;
import java.util.List;	

/**
 * 分类 数据层
 * 
 * @author lnbei
 * @date 2020-01-24
 */
public interface HomeCategoryMapper 
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
	public int insertHomeCategory(HomeCategory homeCategory);
	
	/**
     * 修改分类
     * 
     * @param homeCategory 分类信息
     * @return 结果
     */
	public int updateHomeCategory(HomeCategory homeCategory);
	
	/**
     * 删除分类
     * 
     * @param mid 分类ID
     * @return 结果
     */
	public int deleteHomeCategoryById(String mid);
	
	/**
     * 批量删除分类
     * 
     * @param mids 需要删除的数据ID
     * @return 结果
     */
	public int deleteHomeCategoryByIds(String[] mids);
	/**
	 * 改变状态
	 * @param mCategory
	 * @return
	 */
	public int changeStatus(HomeCategory mCategory);
	/**
	 * 通过英文标识获取分类
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
	 * 查询数据
	 * @param parentId
	 * @return
	 */
	public List<HomeCategory> selectHomeCategoryByPathParentId(HomeCategory homeCategory);
}