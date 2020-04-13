package com.lnbei.web.controller.sp.index;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lnbei.common.core.controller.BaseController;
import com.lnbei.framework.util.RedisUtil;
import com.lnbei.framework.util.ShiroUtils;
import com.lnbei.member.domain.MemberUser;
import com.lnbei.sp.domain.SpGoods;
import com.lnbei.sp.service.ISpGoodsService;


@Controller
@RequestMapping("/spIndex/index")
public class SpIndexController extends BaseController {
	private String prefix = "spindex/index";
	@Autowired
	private ISpGoodsService spGoodsServiceImpl;	
	@Autowired
	private RedisUtil mRedisUtil;
    @Autowired
    private RabbitTemplate rabbitTemplate;  //使用RabbitTemplate,这提供了接收/发送等等方法
	@GetMapping()
	public String index(ModelMap mmMap) {
		MemberUser memberUser = ShiroUtils.getMemberUser(); 
		
		mmMap.put("user", memberUser);
		
		return prefix + "/index";
	}
	@GetMapping("/r")
	@ResponseBody
	public String sendString() {
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "test message, hello!";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String,Object> map=new HashMap<>();
        map.put("messageId",messageId);
        map.put("messageData",messageData);
        map.put("createTime",createTime);
        //将消息携带绑定键值：TestDirectRouting 发送到交换机TestDirectExchange
        rabbitTemplate.convertAndSend("TestDirectExchange", "TestDirectRouting", map);
        return "ok";
	}
}
