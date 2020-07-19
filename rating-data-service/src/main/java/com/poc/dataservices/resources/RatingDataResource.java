package com.poc.dataservices.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.dataservices.model.Rating;
import com.poc.dataservices.model.UserRatings;

@RestController
@RequestMapping("/ratingdata")
public class RatingDataResource {

	@RequestMapping("/{movieId}")
	public Rating getRating(@PathVariable("movieId") String movieId){
		
		return new Rating(movieId,"4");
	}
	
	@RequestMapping("/user/{userId}")
	public UserRatings getUserRating(@PathVariable("userId") String userId){
		
		List<Rating> list =  Arrays.asList(
				new Rating("103","4"),
				new Rating("104","5")
				);
		return new UserRatings(list);
	}
}
