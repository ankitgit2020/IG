package com.poc.catalogservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.poc.catalogservice.models.Movie;

@Service
public class MovieInfoService {
	
	@Autowired
	private RestTemplate restTemplate;

   public Movie callFallbackMovieInfo(String movieId){
		
		Movie movie = new Movie();
		movie.setMovieId("Fall");movie.setName("Fall");
		return movie;
	}
	@HystrixCommand(fallbackMethod = "callFallbackMovieInfo",
	        commandProperties = {
	                @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "50"),
	                @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
	                @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "1000"),
	                @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "10"),
	                @HystrixProperty(name = "execution.isolation.strategy", value = "THREAD"),
	                @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "20000"),
	                @HystrixProperty(name = "metrics.rollingPercentile.timeInMilliseconds", value = "20000"),
	                @HystrixProperty(name = "metrics.healthSnapshot.intervalInMilliseconds", value = "5000"),
	                @HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "100")
	        })
	public Movie callMovieInfo(String movieId){
		
		Movie movie = restTemplate.
				getForObject("http://movie-info-service/movies/" + movieId, Movie.class);
		return movie;
	}
}
