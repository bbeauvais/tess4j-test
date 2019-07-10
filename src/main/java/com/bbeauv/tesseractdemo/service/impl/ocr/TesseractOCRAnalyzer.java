package com.bbeauv.tesseractdemo.service.impl.ocr;

import java.io.File;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class TesseractOCRAnalyzer implements OCRAnalyzer {

	private final String pathData;

	public TesseractOCRAnalyzer(String pathData) {
		super();
		this.pathData = pathData;
	}

	@Override
	public String read(File file) {
		
		Tesseract tess = new Tesseract();
		tess.setDatapath(pathData);
		try {
			tess.setLanguage("eng");
			return tess.doOCR(file);
		} catch (TesseractException e) {
			throw new IllegalStateException("Echec de la lecture du fichier");
		}
	}
}
