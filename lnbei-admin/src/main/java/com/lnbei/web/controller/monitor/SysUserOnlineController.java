package com.lnbei.web.controller.monitor;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.lnbei.common.annotation.Log;
import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.core.page.TableDataInfo;
import com.lnbei.common.enums.BusinessType;
import com.lnbei.common.enums.OnlineStatus;
import com.lnbei.framework.shiro.session.OnlineSession;
import com.lnbei.framework.shiro.session.OnlineSessionDAO;
import com.lnbei.framework.util.ShiroUtils;
import com.lnbei.system.domain.SysUserOnline;
import com.lnbei.system.service.ISysUserOnlineService;

/**
 * 在线用户监控
 * 
 * @author lnbei
 */
@Controller
@RequestMapping("/monitor/online")
public class SysUserOnlineController extends BaseController {
	private String prefix = "monitor/online";

	@Autowired
	private ISysUserOnlineService userOnlineService;

	@Autowired
	private OnlineSessionDAO onlineSessionDAO;

	@RequiresPermissions("monitor:online:view")
	@GetMapping()
	public String online() {
		return prefix + "/online";
	}

	@RequiresPermissions("monitor:online:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SysUserOnline userOnline) {
		startPage();
		List<SysUserOnline> list = userOnlineService.selectUserOnlineList(userOnline);
		return getDataTable(list);
	}

	@RequiresPermissions("monitor:online:batchForceLogout")
	@Log(title = "在线用户", businessType = BusinessType.FORCE)
	@PostMapping("/batchForceLogout")
	@ResponseBody
	public AjaxResult batchForceLogout(@RequestParam("ids[]") String[] ids) {
		for (String sessionId : ids) {
			SysUserOnline online = userOnlineService.selectOnlineById(sessionId);
			if (online == null) {
				return error("用户已下线");
			}
			OnlineSession onlineSession = (OnlineSession) onlineSessionDAO.readSession(online.getSessionId());
			if (onlineSession == null) {
				return error("用户已下线");
			}
			if (sessionId.equals(ShiroUtils.getSessionId())) {
				return error("当前登陆用户无法强退");
			}
			onlineSession.setStatus(OnlineStatus.off_line);
			onlineSessionDAO.update(onlineSession);
			online.setStatus(OnlineStatus.off_line);
			userOnlineService.saveOnline(online);
		}
		return success();
	}

	@RequiresPermissions("monitor:online:forceLogout")
	@Log(title = "在线用户", businessType = BusinessType.FORCE)
	@PostMapping("/forceLogout")
	@ResponseBody
	public AjaxResult forceLogout(String sessionId) {
		SysUserOnline online = userOnlineService.selectOnlineById(sessionId);
		if (sessionId.equals(ShiroUtils.getSessionId())) {
			return error("当前登陆用户无法强退");
		}
		if (online == null) {
			return error("用户已下线");
		}
		OnlineSession onlineSession = (OnlineSession) onlineSessionDAO.readSession(online.getSessionId());
		if (onlineSession == null) {
			return error("用户已下线");
		}
		onlineSession.setStatus(OnlineStatus.off_line);
		onlineSessionDAO.update(onlineSession);
		online.setStatus(OnlineStatus.off_line);
		userOnlineService.saveOnline(online);
		return success();
	}
}
