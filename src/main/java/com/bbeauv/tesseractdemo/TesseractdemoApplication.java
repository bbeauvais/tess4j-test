package com.bbeauv.tesseractdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TesseractdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TesseractdemoApplication.class, args);

//		File image = new File(
//				TesseractdemoApplication.class.getClassLoader().getResource("EnglishText_Abstract.jpg").getFile());
//		Tesseract tess = new Tesseract();
//		tess.setDatapath("D:\\tessdata");
//		try {
//			tess.setLanguage("eng");
//			System.out.println(tess.doOCR(image));
//		} catch (TesseractException e) {
//			e.printStackTrace();
//		}
	}

}
