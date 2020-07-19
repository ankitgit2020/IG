package com.poc.catalogservice.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.poc.catalogservice.models.CatalogItem;
import com.poc.catalogservice.models.Movie;
import com.poc.catalogservice.models.UserRatings;
import com.poc.catalogservice.service.MovieInfoService;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResources {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private MovieInfoService movieInfoService;

	@RequestMapping("/{userId}")
	
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
		
		//RestTemplate restTemplate = new RestTemplate();	
		
//		List<Rating> ratings = Arrays.asList(
//					new Rating("101","4"),
//					new Rating("102","5")
//				);
		UserRatings userRatings = callRatingService(userId);
		List<CatalogItem> items = userRatings.getRatings().stream().map(rating -> {			
			Movie movie = movieInfoService.callMovieInfo(rating.getMovieId());
			return new CatalogItem(movie.getName(),"Desc test", rating.getRating());
		}
		)
		.collect(Collectors.toList());
		
		return items;
				
	}
	
	
	public UserRatings callRatingService(String userId){
		
		UserRatings ratings = restTemplate.
				getForObject("http://rating-data-service/ratingdata/user/" + userId, UserRatings.class);
		return ratings;
	}
}
