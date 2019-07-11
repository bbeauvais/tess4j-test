package com.bbeauv.tesseractdemo.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bbeauv.tesseractdemo.configuration.bean.OCRConfigurationValues;
import com.bbeauv.tesseractdemo.configuration.bean.OCRMode;
import com.bbeauv.tesseractdemo.service.impl.ocr.OCRAnalyzer;

@Configuration
@ConfigurationProperties(prefix = "ocr")
public class OCRConfiguration {

	private final OCRConfigurationValues configurationValues;
	private OCRMode mode;

	public OCRConfiguration(OCRConfigurationValues tesseractConfigurationValues) {
		super();
		this.configurationValues = tesseractConfigurationValues;
	}

	@Bean
	public OCRAnalyzer ocrAnalyzer() {
		return mode.getAnalyser(configurationValues);
	}

	public void setMode(OCRMode mode) {
		this.mode = mode;
	}

}
