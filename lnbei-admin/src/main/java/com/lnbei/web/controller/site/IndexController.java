package com.lnbei.web.controller.site;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/w/index")
public class IndexController {

	private String prefix = "site/index";



	
	@GetMapping()
	public String index() {
		return prefix + "/index";
	}
}
