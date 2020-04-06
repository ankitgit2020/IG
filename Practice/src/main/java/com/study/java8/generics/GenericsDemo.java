package com.study.java8.generics;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Container<T> {
	
	T value;

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
	
	public void show() {
		System.out.println(value.getClass().getName());
	}
	public void print(List<? extends Number> param){
		
		param.forEach(element -> System.out.println(element));
	}
}

public class GenericsDemo<T> {
	
	public static void main(String[] args) {
		
		Container<Integer> integerContainer = new Container<>();
		integerContainer.setValue(10);
		integerContainer.show();
		Integer[] spam = new Integer[] { 1, 2, 3 };
		List<Integer> intList = Arrays.asList(spam);
		integerContainer.print(intList);
		
		Container<String> stringContainer = new Container<>();
		stringContainer.setValue("Hello");
		stringContainer.show();
	
	}
}