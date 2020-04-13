package com.lnbei.oa.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnbei.oa.mapper.OaSystenInterfaceMapper;
import com.lnbei.oa.domain.OaSystenInterface;
import com.lnbei.oa.service.IOaSystenInterfaceService;
import com.lnbei.common.core.text.Convert;

/**
 * 接口管理 服务层实现
 * 
 * @author lnbei
 * @date 2019-03-19
 */
@Service
public class OaSystenInterfaceServiceImpl implements IOaSystenInterfaceService 
{
	@Autowired
	private OaSystenInterfaceMapper oaSystenInterfaceMapper;

	/**
     * 查询接口管理信息
     * 
     * @param id 接口管理ID
     * @return 接口管理信息
     */
    @Override
	public OaSystenInterface selectOaSystenInterfaceById(String id)
	{
	    return oaSystenInterfaceMapper.selectOaSystenInterfaceById(id);
	}
	
	/**
     * 查询接口管理列表
     * 
     * @param oaSystenInterface 接口管理信息
     * @return 接口管理集合
     */
	@Override
	public List<OaSystenInterface> selectOaSystenInterfaceList(OaSystenInterface oaSystenInterface)
	{
	    return oaSystenInterfaceMapper.selectOaSystenInterfaceList(oaSystenInterface);
	}
	
    /**
     * 新增接口管理
     * 
     * @param oaSystenInterface 接口管理信息
     * @return 结果
     */
	@Override
	public int insertOaSystenInterface(OaSystenInterface oaSystenInterface)
	{
	    return oaSystenInterfaceMapper.insertOaSystenInterface(oaSystenInterface);
	}
	
	/**
     * 修改接口管理
     * 
     * @param oaSystenInterface 接口管理信息
     * @return 结果
     */
	@Override
	public int updateOaSystenInterface(OaSystenInterface oaSystenInterface)
	{
	    return oaSystenInterfaceMapper.updateOaSystenInterface(oaSystenInterface);
	}

	/**
     * 删除接口管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteOaSystenInterfaceByIds(String ids)
	{
		return oaSystenInterfaceMapper.deleteOaSystenInterfaceByIds(Convert.toStrArray(ids));
	}
	
}
