package com.lnbei.fi.service;

import com.lnbei.fi.domain.FiBonusDetail2;
import java.util.List;

/**
 * 奖金明细 服务层
 * 
 * @author lnbei
 * @date 2020-02-13
 */
public interface IFiBonusDetail2Service 
{
	/**
     * 查询奖金明细信息
     * 
     * @param mid 奖金明细ID
     * @return 奖金明细信息
     */
	public FiBonusDetail2 selectFiBonusDetail2ById(String mid);
	
	/**
     * 查询奖金明细列表
     * 
     * @param fiBonusDetail2 奖金明细信息
     * @return 奖金明细集合
     */
	public List<FiBonusDetail2> selectFiBonusDetail2List(FiBonusDetail2 fiBonusDetail2);
	
	/**
     * 新增奖金明细
     * 
     * @param fiBonusDetail2 奖金明细信息
     * @return 结果
     */
	public int insertFiBonusDetail2(FiBonusDetail2 fiBonusDetail2);
	
	/**
     * 修改奖金明细
     * 
     * @param fiBonusDetail2 奖金明细信息
     * @return 结果
     */
	public int updateFiBonusDetail2(FiBonusDetail2 fiBonusDetail2);
		
	/**
     * 删除奖金明细信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteFiBonusDetail2ByIds(String ids);
	
}
