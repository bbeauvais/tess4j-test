package com.bbeauv.tesseractdemo.service.impl;

import static java.time.LocalDateTime.now;

import java.io.File;
import java.util.Collection;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bbeauv.tesseractdemo.service.FileService;
import com.bbeauv.tesseractdemo.service.dao.FileDao;
import com.bbeauv.tesseractdemo.service.entity.AnalyzedFile;
import com.bbeauv.tesseractdemo.service.impl.ocr.OCRAnalyzer;

@Service
public class FileServiceImpl implements FileService {

	private final OCRAnalyzer ocrAnalyzer;
	private final FileDao fileDao;

	public FileServiceImpl(OCRAnalyzer ocrAnalyzer, FileDao fileDao) {
		super();
		this.ocrAnalyzer = ocrAnalyzer;
		this.fileDao = fileDao;
	}

	@Override
	public AnalyzedFile analyse(File file) {
		AnalyzedFile result = new AnalyzedFile();

		result.setContent(ocrAnalyzer.read(file));
		result.setOriginalName(file.getName());
		result.setAnalyzedDate(now());
		
		return fileDao.create(result);
	}

	@Override
	public Optional<AnalyzedFile> getById(Integer id) {
		return fileDao.find(id);
	}

	@Override
	public Collection<AnalyzedFile> getAll() {
		return fileDao.findAll();
	}

	@Override
	public void delete(Integer id) {
		fileDao.delete(id);
	}

}
