package com.bravo.bruno.metodista.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bravo.bruno.metodista.data.Video;
import com.bravo.bruno.metodista.data.VideoRepository;

@RestController
public class VideoController {
	
	private final VideoRepository repository;
	
	public VideoController(VideoRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/videos")
	List<Video> all() {
		return repository.findAll();
	}
	
	@GetMapping("/videos/{id}")
	Video one(@PathVariable Long id) {

		return repository.findById(id).orElseThrow(RuntimeException::new);
	}

}
