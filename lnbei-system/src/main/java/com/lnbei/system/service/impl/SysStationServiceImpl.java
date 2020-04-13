package com.lnbei.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnbei.system.mapper.SysStationMapper;
import com.lnbei.system.domain.SysStation;
import com.lnbei.system.service.ISysStationService;
import com.lnbei.common.core.text.Convert;
import com.lnbei.common.utils.StringUtils;

/**
 * 站 服务层实现
 * 
 * @author lnbei
 * @date 2019-03-11
 */
@Service
public class SysStationServiceImpl implements ISysStationService 
{
	@Autowired
	private SysStationMapper sysStationMapper;

	/**
     * 查询站信息
     * 
     * @param id 站ID
     * @return 站信息
     */
    @Override
	public SysStation selectSysStationById(String id)
	{
	    return sysStationMapper.selectSysStationById(id);
	}
	
	/**
     * 查询站列表
     * 
     * @param sysStation 站信息
     * @return 站集合
     */
	@Override
	public List<SysStation> selectSysStationList(SysStation sysStation)
	{
	    return sysStationMapper.selectSysStationList(sysStation);
	}
	
    /**
     * 新增站
     * 
     * @param sysStation 站信息
     * @return 结果
     */
	@Override
	public int insertSysStation(SysStation sysStation)
	{
		sysStation.setId(StringUtils.getUUID32());
	    return sysStationMapper.insertSysStation(sysStation);
	}
	
	/**
     * 修改站
     * 
     * @param sysStation 站信息
     * @return 结果
     */
	@Override
	public int updateSysStation(SysStation sysStation)
	{
	    return sysStationMapper.updateSysStation(sysStation);
	}

	/**
     * 删除站对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSysStationByIds(String ids)
	{
		return sysStationMapper.deleteSysStationByIds(Convert.toStrArray(ids));
	}
	
}
