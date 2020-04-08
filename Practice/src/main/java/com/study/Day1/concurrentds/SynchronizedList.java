package com.study.Day1.concurrentds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;



class AtomicCounter {
	
    private AtomicInteger c = new AtomicInteger(0);

    public void increment() {
        c.incrementAndGet();
    }

    public void decrement() {
        c.decrementAndGet();
    }

    public int value() {
        return c.get();
    }

}

public class SynchronizedList {

	List<String> syncCollection = Collections.synchronizedList(Arrays.asList("a", "b", "c"));
	List<String> uppercasedCollection = new ArrayList<>();
	int r = ThreadLocalRandom.current() .nextInt(4, 77);    
	
	public static void main(String[] args) {
		
		
	}
}
