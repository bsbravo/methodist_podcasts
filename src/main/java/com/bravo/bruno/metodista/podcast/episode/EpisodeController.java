package com.bravo.bruno.metodista.podcast.episode;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EpisodeController {
	
	private final EpisodeRepository repository;
	
	public EpisodeController(EpisodeRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/episodes")
	List<Episode> all() {
		return repository.findAll();
	}

}
