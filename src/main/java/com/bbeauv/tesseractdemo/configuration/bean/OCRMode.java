package com.bbeauv.tesseractdemo.configuration.bean;

import com.bbeauv.tesseractdemo.service.impl.ocr.GoogleVisionOCRAnalyzer;
import com.bbeauv.tesseractdemo.service.impl.ocr.OCRAnalyzer;
import com.bbeauv.tesseractdemo.service.impl.ocr.TesseractOCRAnalyzer;

public enum OCRMode {
	TESSERACT {
		@Override
		public OCRAnalyzer getAnalyser(OCRConfigurationValues conf) {
			return new TesseractOCRAnalyzer(conf.getTesseract().getDataPath(), conf.getTesseract().getLanguage());
		}
	}, GOOGLE_VISION {
		@Override
		public OCRAnalyzer getAnalyser(OCRConfigurationValues conf) {
			return new GoogleVisionOCRAnalyzer();
		}
	};
	
	public abstract OCRAnalyzer getAnalyser(OCRConfigurationValues conf);
}
