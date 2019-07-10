package com.bbeauv.tesseractdemo.dao.impl;

import static java.util.Optional.ofNullable;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Repository;

import com.bbeauv.tesseractdemo.service.dao.FileDao;
import com.bbeauv.tesseractdemo.service.entity.AnalyzedFile;

@Repository
public class FileDaoImpl implements FileDao {

	private static final AtomicInteger ID_GENERATOR = new AtomicInteger(1);
	private static final Map<Integer, AnalyzedFile> TMP_MEMORY_DATABASE = new ConcurrentHashMap<>();

	@Override
	public AnalyzedFile create(AnalyzedFile result) {
		result.setId(ID_GENERATOR.getAndIncrement());
		TMP_MEMORY_DATABASE.put(result.getId(), result);
		return result;
	}

	@Override
	public Optional<AnalyzedFile> find(Integer id) {
		return ofNullable(TMP_MEMORY_DATABASE.get(id));
	}

	@Override
	public Collection<AnalyzedFile> findAll() {
		return TMP_MEMORY_DATABASE.values();
	}

	@Override
	public void delete(Integer id) {
		TMP_MEMORY_DATABASE.remove(id);
	}
}
