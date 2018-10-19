package com.bravo.bruno.metodista.podcast.episode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Episode {
	
	private @Id @GeneratedValue Long id;
	private String title;
	private String description;
	private String url;

	public Episode(String title, String description, String url) {
		this.title = title;
		this.description = description;
		this.url = url;
	}

}
