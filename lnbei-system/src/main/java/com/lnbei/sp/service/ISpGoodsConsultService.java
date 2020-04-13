package com.lnbei.sp.service;

import com.lnbei.sp.domain.SpGoodsConsult;
import java.util.List;

/**
 * 商品咨询 服务层
 * 
 * @author lnbei
 * @date 2020-02-05
 */
public interface ISpGoodsConsultService 
{
	/**
     * 查询商品咨询信息
     * 
     * @param mid 商品咨询ID
     * @return 商品咨询信息
     */
	public SpGoodsConsult selectSpGoodsConsultById(String mid);
	
	/**
     * 查询商品咨询列表
     * 
     * @param spGoodsConsult 商品咨询信息
     * @return 商品咨询集合
     */
	public List<SpGoodsConsult> selectSpGoodsConsultList(SpGoodsConsult spGoodsConsult);
	
	/**
     * 新增商品咨询
     * 
     * @param spGoodsConsult 商品咨询信息
     * @return 结果
     */
	public int insertSpGoodsConsult(SpGoodsConsult spGoodsConsult);
	
	/**
     * 修改商品咨询
     * 
     * @param spGoodsConsult 商品咨询信息
     * @return 结果
     */
	public int updateSpGoodsConsult(SpGoodsConsult spGoodsConsult);
		
	/**
     * 删除商品咨询信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSpGoodsConsultByIds(String ids);
	
}
