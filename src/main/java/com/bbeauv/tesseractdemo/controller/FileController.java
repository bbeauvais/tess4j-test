package com.bbeauv.tesseractdemo.controller;

import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

import java.io.File;
import java.util.Collection;

import org.springframework.http.MediaType;
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

/**
 * API de gestion des fichiers
 * 
 * @author BBEAUVAIS
 *
 */
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

	/**
	 * Récupération de la liste des tous les fichiers ayant été analysés
	 * 
	 * @return
	 */
	@GetMapping
	@ResponseBody
	public ResponseEntity<Collection<AnalyzedFile>> getList() {
		return ok(fileService.getAll());
	}

	/**
	 * Récupération d'un fichier en fonction de son ID
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<AnalyzedFile> get(@PathVariable("id") Integer id) {
		return fileService.getById(id).map(ResponseEntity::ok).orElse(notFound().build());
	}

	/**
	 * Upload d'un fichier pour analyse OCR
	 * 
	 * @param uploadedFile
	 * @return
	 */
	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<AnalyzedFile> post(@RequestParam("file") MultipartFile uploadedFile) {
		File file = converter.apply(uploadedFile);
		return ok(fileService.analyse(file));
	}

	/**
	 * Suppression d'un fichier upload
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	@ResponseBody
	public ResponseEntity<AnalyzedFile> delete(@PathVariable("id") Integer id) {
		fileService.delete(id);
		return ok().build();
	}
}
