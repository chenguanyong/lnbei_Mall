package com.lnbei.sp.service;

import com.lnbei.sp.domain.SpShopApplys;
import java.util.List;

/**
 * 店铺申请 服务层
 * 
 * @author lnbei
 * @date 2020-02-05
 */
public interface ISpShopApplysService 
{
	/**
     * 查询店铺申请信息
     * 
     * @param mid 店铺申请ID
     * @return 店铺申请信息
     */
	public SpShopApplys selectSpShopApplysById(String mid);
	
	/**
     * 查询店铺申请列表
     * 
     * @param spShopApplys 店铺申请信息
     * @return 店铺申请集合
     */
	public List<SpShopApplys> selectSpShopApplysList(SpShopApplys spShopApplys);
	
	/**
     * 新增店铺申请
     * 
     * @param spShopApplys 店铺申请信息
     * @return 结果
     */
	public int insertSpShopApplys(SpShopApplys spShopApplys);
	
	/**
     * 修改店铺申请
     * 
     * @param spShopApplys 店铺申请信息
     * @return 结果
     */
	public int updateSpShopApplys(SpShopApplys spShopApplys);
		
	/**
     * 删除店铺申请信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSpShopApplysByIds(String ids);
	
}
