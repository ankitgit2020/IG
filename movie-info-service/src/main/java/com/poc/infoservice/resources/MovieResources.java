package com.poc.infoservice.resources;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.infoservice.model.Movie;

@RestController
@RequestMapping("/movies")
public class MovieResources {

	@RequestMapping("/{movieId}")
	public Movie getMovie(@PathVariable("movieId") String movieId) {
		
		return new Movie(movieId, "Transformer1");
	}
}
