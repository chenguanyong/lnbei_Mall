package com.lnbei.framework.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lnbei.framework.tag.LBDialect;
/**
 * 自定义thymeleaf标签
 * @author chen
 *<!DOCTYPE html SYSTEM "http://www.thymeleaf.org/dtd/xhtml1-strict-thymeleaf-spring4-4.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org" xmlns:LB="">
 */
@Configuration
public class ThymeleafDialectConfig {

	@Bean
    public LBDialect sysDialect() {
        return new LBDialect();
    }
	
}
