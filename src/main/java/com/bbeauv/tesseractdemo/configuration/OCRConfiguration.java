package com.bbeauv.tesseractdemo.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.bbeauv.tesseractdemo.configuration.bean.TesseractConfiguration;
import com.bbeauv.tesseractdemo.service.impl.ocr.GoogleVisionOCRAnalyzer;
import com.bbeauv.tesseractdemo.service.impl.ocr.OCRAnalyzer;
import com.bbeauv.tesseractdemo.service.impl.ocr.TesseractOCRAnalyzer;

@Configuration
@ConfigurationProperties(prefix = "ocr")
public class OCRConfiguration {

	private final TesseractConfiguration tesseract;

	public OCRConfiguration(TesseractConfiguration tesseract) {
		super();
		this.tesseract = tesseract;
	}

	@Bean
	@Profile({ "default", "tesseract" })
	public OCRAnalyzer tesseractOCRAnalyzer() {
		return new TesseractOCRAnalyzer(tesseract.getDataPath(), tesseract.getLanguage());
	}

	@Bean
	@Profile("google-vision")
	public OCRAnalyzer visionOCRAnalyzer() {
		return new GoogleVisionOCRAnalyzer();
	}
}
