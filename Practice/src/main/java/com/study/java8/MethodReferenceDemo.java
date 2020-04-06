package com.study.java8;

import java.util.Arrays;
import java.util.List;

public class MethodReferenceDemo {

	public static void main(String[] args) {
		
		List<String> messages = Arrays.asList("Ankit", "Jacob", "Michael","Eric");
		
		messages.forEach(System.out::println);
		
		messages.stream().sorted().forEach(System.out::println);
		
	}
}
