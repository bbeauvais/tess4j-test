package com.bbeauv.tesseractdemo.controller;

import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

import java.io.File;
import java.util.Collection;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bbeauv.tesseractdemo.controller.utils.MultipartToFileConverter;
import com.bbeauv.tesseractdemo.service.FileService;
import com.bbeauv.tesseractdemo.service.entity.AnalyzedFile;

@Controller
@RequestMapping("/file")
public class FileController {

	private final FileService fileService;
	private final MultipartToFileConverter converter;

	public FileController(FileService fileService) {
		super();
		this.fileService = fileService;
		this.converter = new MultipartToFileConverter(System.getProperty("java.io.tmpdir"));
	}

	@GetMapping
	@ResponseBody
	public ResponseEntity<Collection<AnalyzedFile>> getList() {
		return ok(fileService.getAll());
	}

	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<AnalyzedFile> get(@PathVariable("id") Integer id) {
		return fileService.getById(id).map(ResponseEntity::ok).orElse(notFound().build());
	}

	@PostMapping
	@ResponseBody
	public ResponseEntity<AnalyzedFile> post(@RequestParam("file") MultipartFile uploadedFile) {
		File file = converter.apply(uploadedFile);
		return ok(fileService.analyse(file));
	}

	@DeleteMapping("/{id}")
	@ResponseBody
	public ResponseEntity<AnalyzedFile> delete(@PathVariable("id") Integer id) {
		fileService.delete(id);
		return ok().build();
	}
}
