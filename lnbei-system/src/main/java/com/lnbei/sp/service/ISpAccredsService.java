package com.lnbei.sp.service;

import com.lnbei.sp.domain.SpAccreds;
import java.util.List;

/**
 * 店铺认证 服务层
 * 
 * @author lnbei
 * @date 2020-02-23
 */
public interface ISpAccredsService 
{
	/**
     * 查询店铺认证信息
     * 
     * @param mid 店铺认证ID
     * @return 店铺认证信息
     */
	public SpAccreds selectSpAccredsById(String mid);
	
	/**
     * 查询店铺认证列表
     * 
     * @param spAccreds 店铺认证信息
     * @return 店铺认证集合
     */
	public List<SpAccreds> selectSpAccredsList(SpAccreds spAccreds);
	
	/**
     * 新增店铺认证
     * 
     * @param spAccreds 店铺认证信息
     * @return 结果
     */
	public int insertSpAccreds(SpAccreds spAccreds);
	
	/**
     * 修改店铺认证
     * 
     * @param spAccreds 店铺认证信息
     * @return 结果
     */
	public int updateSpAccreds(SpAccreds spAccreds);
		
	/**
     * 删除店铺认证信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSpAccredsByIds(String ids);
	
}
