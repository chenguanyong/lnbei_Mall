package com.lnbei.quartz.task;

import org.springframework.stereotype.Component;

import com.lnbei.common.utils.http.HttpUtils;

/**
 * 定时任务调度测试
 * 
 * @author lnbei
 */
@Component("ryTask")
public class RyTask
{
    public void ryParams(String params)
    {
    	String urlString = "http://localhost:8011/api/send/sendMsg";
    	HttpUtils.sendGet(urlString, null);
    }

    public void ryNoParams()
    {
        System.out.println("执行无参方法");
    }
}
