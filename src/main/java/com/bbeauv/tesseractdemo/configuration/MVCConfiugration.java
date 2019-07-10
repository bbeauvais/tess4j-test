package com.bbeauv.tesseractdemo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.bbeauv.tesseractdemo.configuration.bean.MVCConfigurationValues;

@Configuration
public class MVCConfiugration {

	private final MVCConfigurationValues values;

	public MVCConfiugration(MVCConfigurationValues values) {
		super();
		this.values = values;
	}

	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(values.getMaxUploadSize());
		return multipartResolver;
	}

}
