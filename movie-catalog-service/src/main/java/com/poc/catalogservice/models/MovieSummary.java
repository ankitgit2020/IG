package com.poc.catalogservice.models;

public class MovieSummary {

	String movieId;
	String name;
	
	public MovieSummary() {

	}
	public MovieSummary(String movieId, String name) {

		this.movieId = movieId;
		this.name = name;
	}
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
