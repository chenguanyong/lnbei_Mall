package com.lnbei.oa.service;

import com.lnbei.oa.domain.OaFile;
import java.util.List;

/**
 * 文件管理 服务层
 * 
 * @author lnbei
 * @date 2020-02-01
 */
public interface IOaFileService 
{
	/**
     * 查询文件管理信息
     * 
     * @param mid 文件管理ID
     * @return 文件管理信息
     */
	public OaFile selectOaFileById(String mid);
	
	/**
     * 查询文件管理列表
     * 
     * @param oaFile 文件管理信息
     * @return 文件管理集合
     */
	public List<OaFile> selectOaFileList(OaFile oaFile);
	
	/**
     * 新增文件管理
     * 
     * @param oaFile 文件管理信息
     * @return 结果
     */
	public int insertOaFile(OaFile oaFile, Object user);
	
	/**
     * 修改文件管理
     * 
     * @param oaFile 文件管理信息
     * @return 结果
     */
	public int updateOaFile(OaFile oaFile, Object user);
		
	/**
     * 删除文件管理信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteOaFileByIds(String ids);
	/**
     * 增加文件转载量和下载量
     * 
     * @param mids 需要删除的数据ID
     * @return 结果
     */
	public int updateOaFileINC(OaFile oaFile);
	/**
     * 减少文件转载量和下载量
     * 
     * @param mids 需要删除的数据ID
     * @return 结果
     */
	public int updateOaFileDEC(OaFile oaFile);	
}
