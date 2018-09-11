package com.ps.interceptor.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ps.interceptor.aop.RestInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	@Autowired
	private RestInterceptor restInterceptor;

	public void addInterceptors(InterceptorRegistry registry) {
		InterceptorRegistration interceptor = registry.addInterceptor(restInterceptor);
		interceptor.addPathPatterns("/**");
		interceptor.excludePathPatterns("/index/demo", "/error")
		.excludePathPatterns("/swagger-resources/**",
				"/webjars/**", "/v2/**", "/swagger-ui.html/**");
	}

	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html")
		.addResourceLocations("classpath:/META-INF/resources/");
//		registry.addResourceHandler("/webjars/**")
//		.addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
}
