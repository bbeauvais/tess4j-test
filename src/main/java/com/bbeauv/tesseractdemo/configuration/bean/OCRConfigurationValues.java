package com.bbeauv.tesseractdemo.configuration.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "ocr.impl")
public class OCRConfigurationValues {

	private TesseractConfiguration tesseract;

	public TesseractConfiguration getTesseract() {
		return tesseract;
	}

	public void setTesseract(TesseractConfiguration tesseract) {
		this.tesseract = tesseract;
	}
	
	
}
