package com.lnbei.web.controller.api.sso;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lnbei.common.core.controller.BaseController;
import com.lnbei.common.core.domain.AjaxResult;
import com.lnbei.common.utils.http.HttpUtils;
import com.lnbei.oa.domain.OaMessageLog;
import com.lnbei.oa.service.IOaMessageLogService;

@Controller
@RequestMapping("/api/send")
public class ApiSendController extends BaseController {

	@Autowired
	private IOaMessageLogService oaMessageLogServiceImpl;
	@GetMapping("/sendMsg")
	@ResponseBody
	public AjaxResult sendMsg() {
		
		OaMessageLog messageLog = new OaMessageLog();
		messageLog.setIsReply(0);
		List<OaMessageLog> messageLogs = oaMessageLogServiceImpl.selectOaMessageLogList(messageLog);
		
		for(OaMessageLog mmMessageLog : messageLogs) {
			
			if(mmMessageLog.getMethod() == 0 && mmMessageLog.getSendSize() < 60) {
				String url = mmMessageLog.getUrl();
				String paramString = "sysFlag="+ mmMessageLog.getSysFlag() + "&tableName="+mmMessageLog.getTableName()+"&targetId="+mmMessageLog.getTargetId()+"&actionType="+mmMessageLog.getActionType()+"&isBatch="+mmMessageLog.getIsBatch();
				String result = HttpUtils.sendGet(url, paramString);
				if(result.equals("success")) {
					mmMessageLog.setIsReply(1);
					Date mDate = new Date();
					mmMessageLog.setReplyTime(mDate);
					
				}else {
					mmMessageLog.setSendSize(mmMessageLog.getSendSize()+1);
				}
				mmMessageLog.setIsSend(1);
				oaMessageLogServiceImpl.updateOaMessageLog(mmMessageLog);
			}
		}
		return toAjax(true);
	}
	
	
}
