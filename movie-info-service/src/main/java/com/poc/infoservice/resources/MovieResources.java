package com.poc.infoservice.resources;

import java.security.Principal;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.infoservice.model.Movie;

@RestController
@RequestMapping("/movies")
public class MovieResources {

	@RequestMapping("/{movieId}")
	public Movie getMovie(@PathVariable("movieId") String movieId,Principal principal) {
		
		OAuth2Authentication authentication = (OAuth2Authentication) principal;
		if(authentication != null) {
			Map<String, Object> user = (Map<String, Object>) authentication.getUserAuthentication().getDetails();
			for(Map.Entry<String, Object> entry : user.entrySet()) {
				System.out.println(entry.getKey() + "----" + entry.getValue());
			}
			System.out.println("Inside movie service with user : " + principal.getName());
		}
		if(principal != null) {
			return new Movie(movieId, principal.getName());
		}
		else {
			return new Movie(movieId, "Terminator");
		}
		
	}
}
