package com.bbeauv.tesseractdemo.controller;

import org.springframework.boot.info.BuildProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class InfoController {
	
	private final BuildProperties buildProperties;

	public InfoController(BuildProperties buildProperties) {
		super();
		this.buildProperties = buildProperties;
	}

	@GetMapping
	public ResponseEntity<BuildProperties> getSrvInfo() {
		return new ResponseEntity<>(buildProperties, HttpStatus.OK);
	}

}
