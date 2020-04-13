package com.lnbei.system.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnbei.system.mapper.SysLineMapper;
import com.lnbei.system.mapper.SysStationMapper;
import com.lnbei.system.domain.SysLine;
import com.lnbei.system.service.ISysLineService;
import com.lnbei.common.core.text.Convert;
import com.lnbei.common.utils.StringUtils;
import com.lnbei.common.core.domain.Ztree;
/**
 * 线 服务层实现
 * 
 * @author lnbei
 * @date 2019-03-11
 */
@Service
public class SysLineServiceImpl implements ISysLineService 
{
	@Autowired
	private SysLineMapper lineMapper;
	
	@Autowired
	private SysStationMapper sysStationMapper;
	/**
     * 查询线信息
     * 
     * @param id 线ID
     * @return 线信息
     */
    @Override
	public SysLine selectLineById(String id)
	{
	    return lineMapper.selectLineById(id);
	}
	
	/**
     * 查询线列表
     * 
     * @param line 线信息
     * @return 线集合
     */
	@Override
	public List<SysLine> selectLineList(SysLine line)
	{
		List<SysLine> mSysLines = lineMapper.selectLineList(line);
		for(SysLine mSysLine : mSysLines) 
		{
			int mSize = sysStationMapper.countSysStationByLineID(mSysLine.getId());
			mSysLine.setStationSize(mSize);
		}
	    return mSysLines;
	}
	
    /**
     * 新增线
     * 
     * @param line 线信息
     * @return 结果
     */
	@Override
	public int insertLine(SysLine line)
	{
		line.setId(StringUtils.getUUID32());
	    return lineMapper.insertLine(line);
	}
	
	/**
     * 修改线
     * 
     * @param line 线信息
     * @return 结果
     */
	@Override
	public int updateLine(SysLine line)
	{
	    return lineMapper.updateLine(line);
	}

	/**
     * 删除线对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteLineByIds(String ids)
	{
		return lineMapper.deleteLineByIds(Convert.toStrArray(ids));
	}
	
	/**
	 * 获取树数据
	 */
	@Override
	public List<Ztree> getSysLineZtreeList(){
		List<SysLine> mSysLIneList = lineMapper.selectLineList(null);
		
		List<Ztree> mZtreeList = new ArrayList<Ztree>();
		Ztree mZtree = new Ztree();
		mZtree.setId("1");
		mZtree.setpId("0");
		mZtree.setName("所有线别");
		mZtreeList.add(mZtree);
		for(SysLine mSysLine : mSysLIneList) {
			int mSize = sysStationMapper.countSysStationByLineID(mSysLine.getId());
			Ztree mTempZtree = new Ztree();
			mTempZtree.setpId("1");
			mTempZtree.setId(mSysLine.getId());
			mTempZtree.setName(mSysLine.getName() + "("+mSize+")");
			mZtreeList.add(mTempZtree);
		}
		return mZtreeList;
	}
	
}
