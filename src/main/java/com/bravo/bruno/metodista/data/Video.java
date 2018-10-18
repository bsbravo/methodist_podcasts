package com.bravo.bruno.metodista.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Video {
	
	private @Id @GeneratedValue Long id;
	private String title;
	private String description;
	private String url;

	Video(String title, String description, String url) {
		this.title = title;
		this.description = description;
		this.url = url;
	}

}
