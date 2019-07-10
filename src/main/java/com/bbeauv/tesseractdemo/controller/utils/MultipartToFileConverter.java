package com.bbeauv.tesseractdemo.controller.utils;

import java.io.File;
import java.util.function.Function;

import org.springframework.web.multipart.MultipartFile;

public class MultipartToFileConverter implements Function<MultipartFile, File> {

	private final String tmpDirPath;

	public MultipartToFileConverter(String tmpDirPath) {
		super();
		this.tmpDirPath = tmpDirPath;
	}

	@Override
	public File apply(MultipartFile multipart) {
		File uploadedFile = new File(tmpDirPath, multipart.getOriginalFilename());
		try {
			multipart.transferTo(uploadedFile);
		} catch (Exception e) {
			throw new IllegalStateException("Echec du transfert de fichier");
		}

		return uploadedFile;
	}

}
