package com.poc.catalogservice.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.poc.catalogservice.models.CatalogItem;
import com.poc.catalogservice.models.Movie;
import com.poc.catalogservice.models.MovieSummary;
import com.poc.catalogservice.models.UserRatings;

@RestController
@RequestMapping("/movies")

public class MovieResources {

	@Autowired
	RestTemplate restTemplate;
	
	@Value("${api.key}")
	private String apikey;

	@RequestMapping("/{movieId}")
	public MovieSummary getMovieDetail(@PathVariable("movieId") String movieId){
		
		MovieSummary summary = restTemplate.getForObject
				("https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + apikey, MovieSummary.class);
		
		
		return summary;
				
	}
	
}
