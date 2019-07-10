package com.bbeauv.tesseractdemo.configuration.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "web")
public class MVCConfigurationValues {

	private Integer maxUploadSize;

	public Integer getMaxUploadSize() {
		return maxUploadSize;
	}

	public void setMaxUploadSize(Integer maxUploadSize) {
		this.maxUploadSize = maxUploadSize;
	}

}
