package com.bbeauv.tesseractdemo;

import java.io.File;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

//@SpringBootApplication
public class TesseractdemoApplication {

	public static void main(String[] args) {
		// SpringApplication.run(TesseractdemoApplication.class, args);

		File image = new File(
				TesseractdemoApplication.class.getClassLoader().getResource("EnglishText_Abstract.jpg").getFile());
		Tesseract tess = new Tesseract();
		tess.setDatapath("D:\\tessdata");
		try {
			tess.setLanguage("eng");
			System.out.println(tess.doOCR(image));
		} catch (TesseractException e) {
			e.printStackTrace();
		}
	}

}
