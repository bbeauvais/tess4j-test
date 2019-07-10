package com.bbeauv.tesseractdemo.service.entity;

import java.time.LocalDateTime;

public class AnalyzedFile {

	private Integer id;
	private String originalName;
	private String content;
	private LocalDateTime analyzedDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOriginalName() {
		return originalName;
	}

	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getAnalyzedDate() {
		return analyzedDate;
	}

	public void setAnalyzedDate(LocalDateTime analyzedDate) {
		this.analyzedDate = analyzedDate;
	}

}
