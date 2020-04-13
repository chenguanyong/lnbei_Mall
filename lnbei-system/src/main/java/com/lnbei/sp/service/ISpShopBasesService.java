package com.lnbei.sp.service;

import com.lnbei.sp.domain.SpShopBases;
import java.util.List;

/**
 * 商家审核 服务层
 * 
 * @author lnbei
 * @date 2020-02-05
 */
public interface ISpShopBasesService 
{
	/**
     * 查询商家审核信息
     * 
     * @param mid 商家审核ID
     * @return 商家审核信息
     */
	public SpShopBases selectSpShopBasesById(String mid);
	
	/**
     * 查询商家审核列表
     * 
     * @param spShopBases 商家审核信息
     * @return 商家审核集合
     */
	public List<SpShopBases> selectSpShopBasesList(SpShopBases spShopBases);
	
	/**
     * 新增商家审核
     * 
     * @param spShopBases 商家审核信息
     * @return 结果
     */
	public int insertSpShopBases(SpShopBases spShopBases);
	
	/**
     * 修改商家审核
     * 
     * @param spShopBases 商家审核信息
     * @return 结果
     */
	public int updateSpShopBases(SpShopBases spShopBases);
		
	/**
     * 删除商家审核信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSpShopBasesByIds(String ids);
	
}
