package com.bbeauv.tesseractdemo.service.impl.ocr;

import java.io.File;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class TesseractOCRAnalyzer implements OCRAnalyzer {

	private final String pathData;
	private String language;

	public TesseractOCRAnalyzer(String pathData, String language) {
		super();
		this.pathData = pathData;
		this.language = language;
	}

	@Override
	public String read(File file) {
		Tesseract tess = new Tesseract();
		tess.setDatapath(pathData);
		try {
			tess.setLanguage(language);
			return tess.doOCR(file);
		} catch (TesseractException e) {
			throw new IllegalStateException("Echec de la lecture du fichier");
		}
	}
}
