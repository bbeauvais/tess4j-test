package com.bbeauv.tesseractdemo.service;

import java.io.File;
import java.util.Collection;
import java.util.Optional;

import com.bbeauv.tesseractdemo.service.entity.AnalyzedFile;

public interface FileService {

	Optional<AnalyzedFile> getById(Integer id);

	Collection<AnalyzedFile> getAll();

	AnalyzedFile analyse(File file);

	void delete(Integer id);
}
