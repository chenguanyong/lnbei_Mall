package com.lnbei.oa.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnbei.oa.mapper.OaMessageLogMapper;
import com.lnbei.oa.mapper.OaSystemMapper;
import com.lnbei.oa.mapper.OaSystenInterfaceMapper;
import com.lnbei.oa.domain.OaMessageLog;
import com.lnbei.oa.domain.OaSystem;
import com.lnbei.oa.domain.OaSystenInterface;
import com.lnbei.oa.service.IOaMessageLogService;
import com.lnbei.common.core.text.Convert;

/**
 * 主动发消息日志 服务层实现
 * 
 * @author lnbei
 * @date 2019-03-20
 */
@Service
public class OaMessageLogServiceImpl implements IOaMessageLogService {
	@Autowired
	private OaMessageLogMapper oaMessageLogMapper;
	@Autowired
	private OaSystemMapper oaSystemMapper;
	@Autowired
	private OaSystenInterfaceMapper oaSystemInterfaceMapper;

	/**
	 * 查询主动发消息日志信息
	 * 
	 * @param id 主动发消息日志ID
	 * @return 主动发消息日志信息
	 */
	@Override
	public OaMessageLog selectOaMessageLogById(String id) {
		return oaMessageLogMapper.selectOaMessageLogById(id);
	}

	/**
	 * 查询主动发消息日志列表
	 * 
	 * @param oaMessageLog 主动发消息日志信息
	 * @return 主动发消息日志集合
	 */
	@Override
	public List<OaMessageLog> selectOaMessageLogList(OaMessageLog oaMessageLog) {
		return oaMessageLogMapper.selectOaMessageLogList(oaMessageLog);
	}

	/**
	 * 新增主动发消息日志
	 * 
	 * @param oaMessageLog 主动发消息日志信息
	 * @return 结果
	 */
	@Override
	public int insertOaMessageLog(OaMessageLog oaMessageLog) {
		return oaMessageLogMapper.insertOaMessageLog(oaMessageLog);
	}

	/**
	 * 修改主动发消息日志
	 * 
	 * @param oaMessageLog 主动发消息日志信息
	 * @return 结果
	 */
	@Override
	public int updateOaMessageLog(OaMessageLog oaMessageLog) {
		return oaMessageLogMapper.updateOaMessageLog(oaMessageLog);
	}

	/**
	 * 删除主动发消息日志对象
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	@Override
	public int deleteOaMessageLogByIds(String ids) {
		return oaMessageLogMapper.deleteOaMessageLogByIds(Convert.toStrArray(ids));
	}

	@Override
	public int sendMsg(String tableName, String targetId, Integer actionType, Integer isBatch) {
		// TODO Auto-generated method stub
		OaSystem mSystem = new OaSystem();
		mSystem.setStatus("0");
		List<OaSystem> oaSystems = oaSystemMapper.selectOaSystemList(mSystem);
		for (OaSystem mOaSystem : oaSystems) {
			OaSystenInterface oaSystenInterface = oaSystemInterfaceMapper.selectOaSystenInterfaceBySystemID(mOaSystem.getId(), "0");
			if(oaSystenInterface == null) {
				break;
			}
			OaMessageLog oaMessageLog = new OaMessageLog();
			oaMessageLog.setSysFlag(mOaSystem.getFlag());
			oaMessageLog.setSysName(mOaSystem.getSysName());
			oaMessageLog.setTableName(tableName);
			oaMessageLog.setTargetId(targetId);
			oaMessageLog.setIsBatch(isBatch);
			oaMessageLog.setActionType(actionType);
		    oaMessageLog.setUrl(oaSystenInterface.getUrl());
		    oaMessageLog.setMethod(oaSystenInterface.getMethod());
			oaMessageLogMapper.insertOaMessageLog(oaMessageLog);
		}
		return 0;
	}

}
