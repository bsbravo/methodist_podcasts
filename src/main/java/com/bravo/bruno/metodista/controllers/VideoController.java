package com.bravo.bruno.metodista.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bravo.bruno.metodista.data.Video;
import com.bravo.bruno.metodista.data.VideoRepository;

@RestController
public class VideoController {
	
	private final VideoRepository repository;
	
	public VideoController(VideoRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/employees")
	List<Video> all() {
		return repository.findAll();
	}

}
