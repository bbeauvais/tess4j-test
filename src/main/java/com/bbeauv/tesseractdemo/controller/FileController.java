package com.bbeauv.tesseractdemo.controller;

import static org.springframework.http.ResponseEntity.ok;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/file")
public class FileController {

	@PostMapping
	@ResponseBody
	public ResponseEntity<?> post(@RequestParam("file") MultipartFile file) {
		System.out.println(file.getOriginalFilename() + " " + file.getSize());
		return ok().build();
	}
	
}
