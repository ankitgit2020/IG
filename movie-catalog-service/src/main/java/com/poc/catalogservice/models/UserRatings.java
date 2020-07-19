package com.poc.catalogservice.models;

import java.util.List;

public class UserRatings {
	

	public UserRatings() {
		
	}
	public UserRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	private List<Rating> ratings;

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}
}
