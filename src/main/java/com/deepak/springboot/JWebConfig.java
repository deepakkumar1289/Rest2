package com.deepak.springboot;

import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

    @SpringBootApplication
    public class JWebConfig extends WebMvcConfigurationSupport {
	@Bean
	public ViewResolver viewResolver() {
	InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	resolver.setPrefix("WEB-INF/myjsps/");
	resolver.setSuffix(".jsp");
	resolver.setViewClass(JstlView.class);
	return resolver;
	}
	
	protected void extendMessageConverters( List<HttpMessageConverter<?>> converters ) {
	for ( HttpMessageConverter<?> converter : converters ) {
	System.out.println(converter.getClass().getName());
	}
	}	
	
}



