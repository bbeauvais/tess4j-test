package com.bbeauv.tesseractdemo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bbeauv.tesseractdemo.configuration.bean.TesseractConfigurationValues;
import com.bbeauv.tesseractdemo.service.impl.ocr.OCRAnalyzer;
import com.bbeauv.tesseractdemo.service.impl.ocr.TesseractOCRAnalyzer;

@Configuration
public class OCRConfiguration {

	private final TesseractConfigurationValues tesseractConfigurationValues;

	public OCRConfiguration(TesseractConfigurationValues tesseractConfigurationValues) {
		super();
		this.tesseractConfigurationValues = tesseractConfigurationValues;
	}

	@Bean
	public OCRAnalyzer ocrAnalyzer() {
		return new TesseractOCRAnalyzer(tesseractConfigurationValues.getDataPath());
	}
	
}
