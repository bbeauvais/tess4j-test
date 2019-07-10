package com.bbeauv.tesseractdemo.service.dao;

import java.util.Collection;
import java.util.Optional;

import com.bbeauv.tesseractdemo.service.entity.AnalyzedFile;

public interface FileDao {

	AnalyzedFile create(AnalyzedFile result);

	Optional<AnalyzedFile> find(Integer id);

	Collection<AnalyzedFile> findAll();

	void delete(Integer id);
}
