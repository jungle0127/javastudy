package com.rest.conditionmissingbean.cfg;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rest.conditionmissingbean.DefaultInfoService;
import com.rest.conditionmissingbean.IInfoService;

@Configuration
public class InfoServiceConfig {
	@Bean
	@ConditionalOnMissingBean(value=IInfoService.class)
	public IInfoService infoService() {
		return new DefaultInfoService();
	}
}
