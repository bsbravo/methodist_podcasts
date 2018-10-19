package com.bravo.bruno.metodista.podcast;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bravo.bruno.metodista.podcast.episode.Episode;
import com.bravo.bruno.metodista.podcast.episode.EpisodeRepository;

@Configuration
@Slf4j
class LoadDatabase {

	@Bean
	CommandLineRunner initDatabase(EpisodeRepository repository) {
		return args -> {
			log.info("Preloading " + repository.save(new Episode("Romanos 1", "Desc1","")));
			log.info("Preloading " + repository.save(new Episode("Romanos 2", "Desc2", "")));
		};
	}
}