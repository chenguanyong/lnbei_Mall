package com.lnbei.system.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Case;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lnbei.common.constant.UserConstants;
import com.lnbei.common.core.text.Convert;
import com.lnbei.common.html.FormHtml;
import com.lnbei.common.html.widget.SelectWidget;
import com.lnbei.common.utils.StringUtils;
import com.lnbei.system.domain.SysConfig;
import com.lnbei.system.domain.SysDictData;
import com.lnbei.system.mapper.SysConfigMapper;
import com.lnbei.system.service.ISysConfigService;
import com.lnbei.system.service.ISysDictDataService;
import com.lnbei.wf.domain.WfWorkflow;
import com.lnbei.wf.service.IWfWorkflowService;

/**
 * 参数配置 服务层实现
 * 
 * @author lnbei
 */
@Service
public class SysConfigServiceImpl implements ISysConfigService {
	@Autowired
	private SysConfigMapper configMapper;
	/**
	 * 处理字典
	 */
	@Autowired
	private ISysDictDataService sysDictDataService;
	/**
	 * 处理工作流程
	 */
	@Autowired
	private IWfWorkflowService wfWorkflowService;

	/**
	 * 查询参数配置信息
	 * 
	 * @param configId 参数配置ID
	 * @return 参数配置信息
	 */
	@Override
	public SysConfig selectConfigById(String configId) {
		SysConfig config = new SysConfig();
		config.setConfigId(configId);
		return configMapper.selectConfig(config);
	}

	/**
	 * 根据键名查询参数配置信息
	 * 
	 * @param configKey 参数key
	 * @return 参数键值
	 */
	@Override
	public String selectConfigByKey(String configKey) {
		SysConfig config = new SysConfig();
		config.setConfigKey(configKey);
		SysConfig retConfig = configMapper.selectConfig(config);
		return StringUtils.isNotNull(retConfig) ? retConfig.getConfigValue() : "";
	}

	/**
	 * 查询参数配置列表
	 * 
	 * @param config 参数配置信息
	 * @return 参数配置集合
	 */
	@Override
	public List<SysConfig> selectConfigList(SysConfig config) {
		return configMapper.selectConfigList(config);
	}

	/**
	 * 新增参数配置
	 * 
	 * @param config 参数配置信息
	 * @return 结果
	 */
	@Override
	public int insertConfig(SysConfig config) {
		return configMapper.insertConfig(config);
	}

	/**
	 * 修改参数配置
	 * 
	 * @param config 参数配置信息
	 * @return 结果
	 */
	@Override
	public int updateConfig(SysConfig config) {
		return configMapper.updateConfig(config);
	}

	/**
	 * 批量删除参数配置对象
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	@Override
	public int deleteConfigByIds(String ids) {
		return configMapper.deleteConfigByIds(Convert.toStrArray(ids));
	}

	/**
	 * 校验参数键名是否唯一
	 * 
	 * @param config 参数配置信息
	 * @return 结果
	 */
	@Override
	public String checkConfigKeyUnique(SysConfig config) {
		String configId = StringUtils.isNull(config.getConfigId()) ? "-1" : config.getConfigId();
		SysConfig info = configMapper.checkConfigKeyUnique(config.getConfigKey());
		if (StringUtils.isNotNull(info) && !info.getConfigId().equals(configId)) {
			return UserConstants.CONFIG_KEY_NOT_UNIQUE;
		}
		return UserConstants.CONFIG_KEY_UNIQUE;
	}

	@Override
	public List<SysConfig> sysConfigConvertEle(List<SysConfig> mConfigs) {
		int i=0;
		for (SysConfig sysConfig : mConfigs) {
			FormHtml mFormHtml = new FormHtml("");
			if(i == (mConfigs.size()-1)) {
				mFormHtml.setColspan("3");
			}
			
			if (sysConfig.getConfigVtype() <= 8) {
				sysConfig.toHtml();
			} else {
				toDataHtml(sysConfig);
			}
			i++;
		}
		return mConfigs;
	}

	/**
	 * 配置对象生成对应的HTML
	 * 
	 * @param mConfig
	 * @return
	 */
	private SysConfig toDataHtml(SysConfig mConfig) {

		if (mConfig.getConfigVtype() == 9) {
			String dictType = mConfig.getDictType();
			List<SysDictData> mDatas = sysDictDataService.selectDictDataByType(dictType);
			Map<String, String> mmMap = new HashMap<String, String>();

			for (SysDictData sysDictData : mDatas) {
				mmMap.put("c_" + sysDictData.getDictValue(), sysDictData.getDictLabel());
			}

			mConfig = toDictHtml(mConfig, mmMap);
		} else if (mConfig.getConfigVtype() > 9) {
			switch (mConfig.getConfigVtype()) {

			case 10: {
				List<WfWorkflow> mList = wfWorkflowService.selectWfWorkflowList(new WfWorkflow());
				Map<String, String> mmMap = new HashMap<String, String>();
				for (WfWorkflow m : mList) {
					mmMap.put("c_" + m.getMid(), m.getTitle());
				}
				mConfig = toDictHtml(mConfig, mmMap);
				}
				break;
			}
		}

		return mConfig;
	}

	private SysConfig toDictHtml(SysConfig mConfig, Map<String, String> mmMap) {

		SelectWidget mSelectWidget = new SelectWidget(mmMap);
		mConfig.setEleHtml(mSelectWidget.toHtml());
		return mConfig;
	}
	/**
	 * 保存配置
	 */
	@Override
	@Transactional
	public int saveSysconfig(String ctreeId, String param) {
		// TODO Auto-generated method stub
		if (StringUtils.isEmpty(param)) {
			return 0;
		}
		String[] paramArray = Convert.toStrArray("&", param);
		int result = 0;
		for (String string : paramArray) {
			String[] keyValue = Convert.toStrArray("=", string);
			SysConfig mConfig = new SysConfig();
			mConfig.setCtreeId(ctreeId);
			mConfig.setConfigKey(keyValue[0]);
			mConfig.setConfigValue(keyValue[1]);
			result = configMapper.updateConfigByConfigKeyCtreeId(mConfig);
		}
		
		return result;
	}
}
