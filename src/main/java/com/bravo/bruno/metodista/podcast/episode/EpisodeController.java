package com.bravo.bruno.metodista.podcast.episode;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping("/episodes")
	Episode newEpisode(@RequestBody Episode newEpisode) {
		return repository.save(newEpisode);
	}
	
	@GetMapping("/episodes/{id}")
	Episode one(@PathVariable Long id) {
 		return repository.findById(id).orElseThrow(RuntimeException::new);
	}
	
	@PutMapping("/episodes/{id}")
	Episode replaceEpisode(@RequestBody Episode newEpisode, @PathVariable Long id) {

		return repository.findById(id)
			.map(episode -> {
				episode.setTitle(newEpisode.getTitle());
				episode.setDescription(newEpisode.getDescription());
				episode.setUrl(newEpisode.getUrl());
				return repository.save(episode);
			})
			.orElseGet(() -> {
				newEpisode.setId(id);
				return repository.save(newEpisode);
			});
	}

	@DeleteMapping("/episodes/{id}")
	void deleteEpisode(@PathVariable Long id) {
		repository.deleteById(id);
	}

}
