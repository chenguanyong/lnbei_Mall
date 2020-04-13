package com.lnbei.oa.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnbei.oa.mapper.OaFileUserMapper;
import com.lnbei.oa.domain.OaFileUser;
import com.lnbei.oa.service.IOaFileUserService;
import com.lnbei.common.core.text.Convert;

/**
 * 文件用户关系 服务层实现
 * 
 * @author lnbei
 * @date 2020-02-01
 */
@Service
public class OaFileUserServiceImpl implements IOaFileUserService 
{
	@Autowired
	private OaFileUserMapper oaFileUserMapper;

	/**
     * 查询文件用户关系信息
     * 
     * @param mid 文件用户关系ID
     * @return 文件用户关系信息
     */
    @Override
	public OaFileUser selectOaFileUserById(String mid)
	{
	    return oaFileUserMapper.selectOaFileUserById(mid);
	}
	
	/**
     * 查询文件用户关系列表
     * 
     * @param oaFileUser 文件用户关系信息
     * @return 文件用户关系集合
     */
	@Override
	public List<OaFileUser> selectOaFileUserList(OaFileUser oaFileUser)
	{
	    return oaFileUserMapper.selectOaFileUserList(oaFileUser);
	}
	
    /**
     * 新增文件用户关系
     * 
     * @param oaFileUser 文件用户关系信息
     * @return 结果
     */
	@Override
	public int insertOaFileUser(OaFileUser oaFileUser)
	{
	    return oaFileUserMapper.insertOaFileUser(oaFileUser);
	}
	
	/**
     * 修改文件用户关系
     * 
     * @param oaFileUser 文件用户关系信息
     * @return 结果
     */
	@Override
	public int updateOaFileUser(OaFileUser oaFileUser)
	{
	    return oaFileUserMapper.updateOaFileUser(oaFileUser);
	}

	/**
     * 删除文件用户关系对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteOaFileUserByIds(String ids)
	{
		return oaFileUserMapper.deleteOaFileUserByIds(Convert.toStrArray(ids));
	}
	
}
