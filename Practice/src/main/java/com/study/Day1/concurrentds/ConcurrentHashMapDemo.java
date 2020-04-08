package com.study.Day1.concurrentds;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {

	public static void main(String[] args) {
		
		ConcurrentHashMap<String,String> map = new ConcurrentHashMap<>();
		map.put("key1", "Value1");
		map.put("key2", "Value2");
		map.put("key3", "Value3");
		
		map.putIfAbsent("key4", "value4");
		
		map.remove("key3");
		
		map.putIfAbsent("key3", "updated value3");
		map.replace("key2", "updated 2");
		
		System.out.println(map);
	}
}
