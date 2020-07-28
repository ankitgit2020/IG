package com.study.java8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.study.Practice.App;

public class StreamDemo {

	public static void main(String[] args) {

		List<Integer> myList = new ArrayList<>();
		Map<String,String> map = new HashMap<>();
		map.put("Hello", "One");
		map.put("Welcome", "two");
		
		Map<String,String> map1 = new Hashtable<>();
		map1.put("Hi", "One");
		map1.put("Welcome", "two");
		
		map1.forEach((k,v) -> System.out.println("Testing null " + k));
		
		
		for (int i = 0; i < 100; i++)
			myList.add(i);

		// sequential stream
		Stream<Integer> sequentialStream = myList.stream();

		Stream<Integer> highNumsSeq = sequentialStream.filter(p -> p > 95);
		List<Integer> list = highNumsSeq.collect(Collectors.toList());
		for(Integer num : list) {
			System.out.println(num);
		}
		//highNumsSeq.forEach(p -> System.out.println("High Nums sequential=" + p));

		App app = new App();
		//app.instanceVariable = 10;
		//System.out.println(app.instanceVariable);
		app.show(2);

	}

}
