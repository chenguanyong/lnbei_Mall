package com.lnbei.oa.service;

import com.lnbei.oa.domain.OaFileUser;
import java.util.List;

/**
 * 文件用户关系 服务层
 * 
 * @author lnbei
 * @date 2020-02-01
 */
public interface IOaFileUserService 
{
	/**
     * 查询文件用户关系信息
     * 
     * @param mid 文件用户关系ID
     * @return 文件用户关系信息
     */
	public OaFileUser selectOaFileUserById(String mid);
	
	/**
     * 查询文件用户关系列表
     * 
     * @param oaFileUser 文件用户关系信息
     * @return 文件用户关系集合
     */
	public List<OaFileUser> selectOaFileUserList(OaFileUser oaFileUser);
	
	/**
     * 新增文件用户关系
     * 
     * @param oaFileUser 文件用户关系信息
     * @return 结果
     */
	public int insertOaFileUser(OaFileUser oaFileUser);
	
	/**
     * 修改文件用户关系
     * 
     * @param oaFileUser 文件用户关系信息
     * @return 结果
     */
	public int updateOaFileUser(OaFileUser oaFileUser);
		
	/**
     * 删除文件用户关系信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteOaFileUserByIds(String ids);
	
}
