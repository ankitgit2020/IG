package com.poc.dataservices.model;

import java.util.List;

public class UserRatings {
	

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
