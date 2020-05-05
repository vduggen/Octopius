package br.com.octopus.apioctopusdashboard.configs;

import javax.annotation.Resource;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import br.com.octopus.apioctopusdashboard.interceptors.AuthInterceptor;

@Configuration
public class AppConfig extends WebMvcConfigurationSupport {

	@Resource
	private AuthInterceptor authInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(authInterceptor)
			.addPathPatterns("/api/v1/products")
			.addPathPatterns("/api/v1/blacklist")
			.addPathPatterns("/api/v1/notifications");
	}

}