package com.lnbei.web.controller.system;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.lnbei.common.annotation.Log;
import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.core.page.TableDataInfo;
import com.lnbei.common.enums.BusinessType;
import com.lnbei.common.utils.StringUtils;
import com.lnbei.common.utils.poi.ExcelUtil;
import com.lnbei.framework.util.ShiroUtils;
import com.lnbei.system.domain.SysConfig;
import com.lnbei.system.service.ISysConfigService;

/**
 * 参数配置 信息操作处理
 * 
 * @author lnbei
 */
@Controller
@RequestMapping("/system/config")
public class SysConfigController extends BaseController {
	private String prefix = "system/config";

	@Autowired
	private ISysConfigService configService;

	@RequiresPermissions("system:config:view")
	@GetMapping()
	public String config() {
		return prefix + "/config";
	}

	@RequiresPermissions("system:config:set")
	@GetMapping("/set")
	public String configset() {
		return prefix + "/configset";
	}

	/**
	 * 查询参数配置列表
	 */
	@RequiresPermissions("system:config:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SysConfig config) {
		startPage();
		List<SysConfig> list = configService.selectConfigList(config);
		return getDataTable(list);
	}

	@Log(title = "参数管理", businessType = BusinessType.EXPORT)
	@RequiresPermissions("system:config:export")
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(SysConfig config) {
		List<SysConfig> list = configService.selectConfigList(config);
		ExcelUtil<SysConfig> util = new ExcelUtil<SysConfig>(SysConfig.class);
		return util.exportExcel(list, "参数数据");
	}

	/**
	 * 新增参数配置
	 */
	@GetMapping("/add/{id}")
	public String add(@PathVariable("id") String id, ModelMap mmMap) {
		if (StringUtils.isNotEmpty(id) && !id.equals("0")) {
			// SysConfig mConfig = configService.selectConfigById(id);
			mmMap.put("treeId", id);
		} else {
			mmMap.put("treeId", 0);
		}

		return prefix + "/add";
	}

	/**
	 * 新增保存参数配置
	 */
	@RequiresPermissions("system:config:add")
	@Log(title = "参数管理", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(SysConfig config) {
		config.setCreateBy(ShiroUtils.getLoginName());
		return toAjax(configService.insertConfig(config));
	}

	/**
	 * 修改参数配置
	 */
	@GetMapping("/edit/{configId}")
	public String edit(@PathVariable("configId") String configId, ModelMap mmap) {
		SysConfig mmConfig = configService.selectConfigById(configId);
		mmap.put("config", mmConfig);
		return prefix + "/edit";
	}

	/**
	 * 修改保存参数配置
	 */
	@RequiresPermissions("system:config:edit")
	@Log(title = "参数管理", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(SysConfig config) {
		config.setUpdateBy(ShiroUtils.getLoginName());
		return toAjax(configService.updateConfig(config));
	}

	/**
	 * 删除参数配置
	 */
	@RequiresPermissions("system:config:remove")
	@Log(title = "参数管理", businessType = BusinessType.DELETE)
	@PostMapping("/remove")
	@ResponseBody
	public AjaxResult remove(String ids) {
		return toAjax(configService.deleteConfigByIds(ids));
	}

	/**
	 * 校验参数键名
	 */
	@PostMapping("/checkConfigKeyUnique")
	@ResponseBody
	public String checkConfigKeyUnique(SysConfig config) {
		return configService.checkConfigKeyUnique(config);
	}

	/**
	 * 获取配置编辑数据的页面
	 * 
	 * @param ctreeId
	 * @param mmMap
	 * @return
	 */
	@GetMapping("/configValue")
	public String configValue(String ctreeId, ModelMap mmMap) {
		SysConfig mConfig = new SysConfig();
		mConfig.setCtreeId(ctreeId);
		mConfig.setStatus("0");
		List<SysConfig> mmConfigs = configService.selectConfigList(mConfig);
		configService.sysConfigConvertEle(mmConfigs);
		List<String> mmList = new ArrayList<String>();
		int i = 0;
		String temp = "";
		boolean isJI = mmConfigs.size() % 2 == 0;
		for (SysConfig mConfig2 : mmConfigs) {
			temp += mConfig2.getEleHtml();
			if (i % 2 == 0) {
				mmList.add(temp);
				temp = "";
			}
			if (isJI && (mmConfigs.size()) - 1 == i) {

				mmList.add(temp);
			}
			i++;
		}
		mmMap.put("configHtml", mmList);
		mmMap.put("ctreeId", ctreeId);
		return prefix + "/configvalue";
	}

	@PostMapping("/saveConfig")
	@ResponseBody
	public AjaxResult saveConfig(String ctreeId, String param) {
		return toAjax(configService.saveSysconfig(ctreeId, param));
	}

}
