package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.example.interceptor.GloballInterfaceptor;

public class InterceptorConfig implements WebMvcConfigurer{
	@Autowired
	GloballInterfaceptor globallInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(globallInterceptor)
		.addPathPatterns("/**")
		.excludePathPatterns("/rest/**","/admin/**","/assets/**");
	}
}
