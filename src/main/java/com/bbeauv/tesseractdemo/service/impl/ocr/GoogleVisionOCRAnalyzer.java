package com.bbeauv.tesseractdemo.service.impl.ocr;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import static java.util.Arrays.*;
import java.util.List;

import com.google.cloud.vision.v1.AnnotateImageRequest;
import com.google.cloud.vision.v1.AnnotateImageResponse;
import com.google.cloud.vision.v1.BatchAnnotateImagesResponse;
import com.google.cloud.vision.v1.Feature;
import com.google.cloud.vision.v1.Feature.Type;
import com.google.cloud.vision.v1.Image;
import com.google.cloud.vision.v1.ImageAnnotatorClient;
import com.google.cloud.vision.v1.TextAnnotation;
import com.google.protobuf.ByteString;

public class GoogleVisionOCRAnalyzer implements OCRAnalyzer {

	@Override
	public String read(File file) {

		try {
			ByteString bytes = ByteString.readFrom(new FileInputStream(file));
			Image img = Image.newBuilder().setContent(bytes).build();
			Feature feat = Feature.newBuilder().setType(Type.DOCUMENT_TEXT_DETECTION).build();
			AnnotateImageRequest request = AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();

			List<AnnotateImageResponse> responses = new ArrayList<>();
			try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
				BatchAnnotateImagesResponse response = client.batchAnnotateImages(asList(request));
				responses = response.getResponsesList();
			}
			
			for (AnnotateImageResponse resp : responses) {
				TextAnnotation fullTextAnnotation = resp.getFullTextAnnotation();
				fullTextAnnotation.getText();
			}

			return responses.stream().map(AnnotateImageResponse::getFullTextAnnotation).map(TextAnnotation::getText)
					.reduce("", (acc, val) -> acc + val);
		} catch (IOException e) {
			throw new IllegalStateException(e);
		}

	}

}
